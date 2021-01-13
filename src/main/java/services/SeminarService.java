package services;

import dao.SeminarDao;
import models.Seminar;

import java.util.List;

public class SeminarService {

    private SeminarDao seminarDao = new SeminarDao();

    public SeminarService() {
    }

    public Seminar findSeminar(int id) {
        return seminarDao.findById(id);
    }

    public void saveSeminar(Seminar seminar) {
        seminarDao.save(seminar);
    }

    public void deleteSeminar(Seminar seminar) {
        seminarDao.delete(seminar);
    }

    public void updateSeminar(Seminar seminar) {
        seminarDao.update(seminar);
    }

    public List<Seminar> findAllSeminars() {
        return seminarDao.findAll();
    }

}

