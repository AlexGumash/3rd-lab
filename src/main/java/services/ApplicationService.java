package services;

import dao.ApplicationDao;
import models.Application;

import java.util.List;

public class ApplicationService {

    private ApplicationDao applicationDao = new ApplicationDao();

    public ApplicationService() {
    }

    public Application findApplication(int id) {
        return applicationDao.findById(id);
    }

    public List<Application> findApplication(String name, String surname, String email) {
        return applicationDao.findByFullNameAndEmail(name, surname, email);
    }

    public void saveApplication(Application application) {
        applicationDao.save(application);
    }

    public void deleteApplication(Application application) {
        applicationDao.delete(application);
    }

    public void updateApplication(Application application) {
        applicationDao.update(application);
    }

    public List<Application> findAllApplications() {
        return applicationDao.findAll();
    }

}
