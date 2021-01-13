package services;

import dao.EvstudentDao;
import models.Evstudent;

import java.util.List;

public class EvstudentService {

    private EvstudentDao evstudentDao = new EvstudentDao();

    public EvstudentService() {
    }

    public Evstudent findEvstudent(int id) {
        return evstudentDao.findById(id);
    }

    public Evstudent findEvstudentByPhone(String name, String surname, String phone) {
        return evstudentDao.findByPhone(name, surname, phone);
    }

    public Evstudent findEvstudentByEmail(String name, String surname, String email) {
        return evstudentDao.findByEmail(name, surname, email);
    }

    public int saveEvstudent(Evstudent evstudent) {
        return evstudentDao.save(evstudent);
    }

    public void deleteEvstudent(Evstudent evstudent) {
        evstudentDao.delete(evstudent);
    }

    public void updateEvstudent(Evstudent evstudent) {
        evstudentDao.update(evstudent);
    }

    public List<Evstudent> findAllEvstudents() {
        return evstudentDao.findAll();
    }

}
