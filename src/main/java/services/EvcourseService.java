package services;

import dao.EvcourseDao;
import models.Evcourse;

import java.util.List;

public class EvcourseService {

    private EvcourseDao evcourseDao = new EvcourseDao();

    public EvcourseService() {
    }

    public Evcourse findEvcourse(int id) {
        return evcourseDao.findById(id);
    }

    public void saveEvcourse(Evcourse evcourse) {
        evcourseDao.save(evcourse);
    }

    public void deleteEvcourse(Evcourse evcourse) {
        evcourseDao.delete(evcourse);
    }

    public void updateEvcourse(Evcourse evcourse) {
        evcourseDao.update(evcourse);
    }

    public List<Evcourse> findAllEvcourses() {
        return evcourseDao.findAll();
    }

}
