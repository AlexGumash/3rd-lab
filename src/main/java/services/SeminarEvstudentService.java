package services;

import dao.SeminarEvstudentDao;
import models.SeminarEvstudent;

import java.util.List;

public class SeminarEvstudentService {

    private SeminarEvstudentDao seminarEvstudentDao = new SeminarEvstudentDao();

    public SeminarEvstudentService() {
    }

    public SeminarEvstudent findSeminarEvstudent(int id) {
        return seminarEvstudentDao.findById(id);
    }

    public void saveSeminarEvstudent(SeminarEvstudent seminarEvstudent) {
        seminarEvstudentDao.save(seminarEvstudent);
    }

    public void deleteSeminarEvstudent(SeminarEvstudent seminarEvstudent) {
        seminarEvstudentDao.delete(seminarEvstudent);
    }

    public void updateSeminarEvstudent(SeminarEvstudent seminarEvstudent) {
        seminarEvstudentDao.update(seminarEvstudent);
    }

    public List<SeminarEvstudent> findAllSeminarEvstudents() {
        return seminarEvstudentDao.findAll();
    }

}
