package ru.job4j.dream.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dream.model.City;
import ru.job4j.dream.persistence.CityDbStore;
import ru.job4j.dream.persistence.CityRepository;

import java.util.*;

@Service
public class CityService {

    /*private final CityDbStore cityDbStore;*/
    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> getAllCities() {
        List<City> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
        /*return cityDbStore.findAll();*/
    }

    public City findById(int id) {
        return repository.findById(id).get();
        /*return cityDbStore.findById(id);*/
    }
}
