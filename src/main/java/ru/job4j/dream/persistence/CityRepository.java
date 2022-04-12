package ru.job4j.dream.persistence;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.dream.model.City;

public interface CityRepository extends CrudRepository<City, Integer> {
}
