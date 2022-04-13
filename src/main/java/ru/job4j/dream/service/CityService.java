package ru.job4j.dream.service;

import org.springframework.stereotype.Service;
import ru.job4j.dream.model.City;
import ru.job4j.dream.persistence.CityRepository;

import java.util.*;

@Service
public class CityService {

    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> getAllCities() {
        List<City> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public City findById(int id) {
        return repository.findById(id).get();
    }
}
