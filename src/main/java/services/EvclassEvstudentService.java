package services;

import dao.EvclassEvstudentDao;
import models.EvclassEvstudent;

import java.util.List;

public class EvclassEvstudentService {

    private EvclassEvstudentDao evclassEvstudentDao = new EvclassEvstudentDao();

    public EvclassEvstudentService() {
    }

    public EvclassEvstudent findEvclassEvstudent(int id) {
        return evclassEvstudentDao.findById(id);
    }

    public List<EvclassEvstudent> findEvclassEvstudent(int classId, int studentId) {
        return evclassEvstudentDao.findByClass(classId, studentId);
    }

    public void saveEvclassEvstudent(EvclassEvstudent evclassEvstudent) {
        evclassEvstudentDao.save(evclassEvstudent);
    }

    public void deleteEvclassEvstudent(EvclassEvstudent evclassEvstudent) {
        evclassEvstudentDao.delete(evclassEvstudent);
    }

    public void updateEvclassEvstudent(EvclassEvstudent evclassEvstudent) {
        evclassEvstudentDao.update(evclassEvstudent);
    }

    public List<EvclassEvstudent> findAllEvclassEvstudents() {
        return evclassEvstudentDao.findAll();
    }

}
