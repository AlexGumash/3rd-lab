package services;

import dao.EvclassDao;
import models.Evclass;

import java.util.List;

public class EvclassService {

    private EvclassDao evclassDao = new EvclassDao();

    public EvclassService() {
    }

    public Evclass findEvclass(int id) {
        return evclassDao.findById(id);
    }

    public void saveEvclass(Evclass evclass) {
        evclassDao.save(evclass);
    }

    public void deleteEvclass(Evclass evclass) {
        evclassDao.delete(evclass);
    }

    public void updateEvclass(Evclass evclass) {
        evclassDao.update(evclass);
    }

    public List<Evclass> findAllEvclasses() {
        return evclassDao.findAll();
    }

}
