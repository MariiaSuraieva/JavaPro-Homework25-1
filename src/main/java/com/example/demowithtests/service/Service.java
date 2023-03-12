package com.example.demowithtests.service;

import com.example.demowithtests.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface Service {

    Employee create(Employee employee);

    List<Employee> getAll();

    Employee getById(String id);

    Employee updateById(Integer id, Employee plane);

    void removeById(Integer id);

    void removeAll();

    List<Employee> sendEmailByCountry(String country, String text);

    List<Employee> sendEmailByCity(String city, String text);

    Employee createrEmployee(String name, String country, String email);

    void fillingDataBase(String quantity);

    void updaterByCountryFully(String countries);
    void updaterByCountrySmart(String countries);
    String randomCountry(String countriesString);
    List<Employee> processor();


}