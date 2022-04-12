package ru.job4j.dream.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dream.model.City;
import ru.job4j.dream.persistence.CityDbStore;

import java.util.*;

@ThreadSafe
@Service
public class CityService {

    private final CityDbStore cityDbStore;

    public CityService(CityDbStore cityDbStore) {
        this.cityDbStore = cityDbStore;
    }

    public List<City> getAllCities() {
        return cityDbStore.findAll();
    }

    public City findById(int id) {
        return cityDbStore.findById(id);
    }
}
