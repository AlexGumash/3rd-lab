package restServices;

import models.Application;
import models.EvclassEvstudent;
import models.Evstudent;
import services.ApplicationService;
import services.EvclassEvstudentService;
import services.EvstudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/application")
public class ApplicationRestService extends RestService {
    EvstudentService evstudentService;
    ApplicationService applicationService;
    EvclassEvstudentService evclassEvstudentService;

    public ApplicationRestService() {
        this.evstudentService = new EvstudentService();
        this.applicationService = new ApplicationService();
        this.evclassEvstudentService = new EvclassEvstudentService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postApplication(
            @FormParam("name") String name,
            @FormParam("surname") String surname,
            @FormParam("patronymic") String patronymic,
            @FormParam("phone") String phone,
            @FormParam("email") String email,
            @FormParam("evclassId") int evclassId,
            @FormParam("source") String source,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        List<Application> applications = applicationService.findApplication(name, surname, email);
        if (applications.isEmpty()) {
            Evstudent student = new Evstudent(name, surname, patronymic, phone, email, source, true);
            int savedStudentId = evstudentService.saveEvstudent(student);

            Application application = new Application(name, surname, phone, email, evclassId);
            applicationService.saveApplication(application);


            EvclassEvstudent evclassEvstudent = new EvclassEvstudent(evclassId, savedStudentId);
            evclassEvstudentService.saveEvclassEvstudent(evclassEvstudent);

        } else {
            boolean applicationExists = false;
            int savedStudentId = 0;
            for (Application application : applications) {
                if (application.getPhone().equals(phone) || application.getEmail().equals(email)) {
                    if (application.getPhone().equals(phone)) {
                        String appPhone = application.getPhone();
                        savedStudentId = evstudentService.findEvstudentByPhone(application.getName(), application.getSurname(), appPhone).getEvstudentId();
                    } else {
                        String appEmail = application.getEmail();
                        savedStudentId = evstudentService.findEvstudentByEmail(application.getName(), application.getSurname(), appEmail).getEvstudentId();
                    }
                    List<EvclassEvstudent> evclassEvstudents = evclassEvstudentService.findEvclassEvstudent(evclassId, savedStudentId);
                    if (evclassEvstudents.isEmpty()) {

                        EvclassEvstudent evclassEvstudent = new EvclassEvstudent(evclassId, savedStudentId);
                        evclassEvstudentService.saveEvclassEvstudent(evclassEvstudent);

                        Application application2 = new Application(name, surname, phone, email, evclassId);
                        applicationService.saveApplication(application2);
                    }
                    applicationExists = true;
                    break;
                } else {
                    applicationExists = false;
                }
            }
            if (applicationExists == false) {
                Evstudent student = new Evstudent(name, surname, patronymic, phone, email, source, true);
                savedStudentId = evstudentService.saveEvstudent(student);

                Application application = new Application(name, surname, phone, email, evclassId);
                applicationService.saveApplication(application);

                EvclassEvstudent evclassEvstudent = new EvclassEvstudent(evclassId, savedStudentId);
                evclassEvstudentService.saveEvclassEvstudent(evclassEvstudent);
            }
        }


        return Response.status(200).build();
    }
}
