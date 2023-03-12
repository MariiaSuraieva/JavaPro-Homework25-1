package com.example.demowithtests.web;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.EmployeeDto;
import com.example.demowithtests.dto.EmployeeReadDto;
import com.example.demowithtests.service.Service;
import com.example.demowithtests.util.config.EmployeeConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    private final Service service;

    private final EmployeeConverter converter;


    //Операция сохранения юзера в базу данных
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return converter.toDto(
                service.create(
                        converter.getMapperFacade().map(employeeDto, Employee.class)
                )
        );
    }

    //Получение списка юзеров
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeReadDto> getAllUsers() {
        List<Employee> employees = service.getAll();
        List<EmployeeReadDto> employeesReadDto = new ArrayList<>();
        for (Employee employee : employees) {
            employeesReadDto.add(
                    converter.toReadDto(employee)
            );
        }
        return employeesReadDto;
    }

    //Получения юзера по id
    @GetMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeReadDto getEmployeeById(@PathVariable String id) {
        return converter.toReadDto(
                service.getById(id)
        );
    }

    //Обновление юзера
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeReadDto refreshEmployee(@PathVariable("id") String id, @RequestBody EmployeeDto employeeDto) {
        Integer parseId = Integer.parseInt(id);
        return converter.toReadDto(
                service.updateById(parseId, converter.fromDto(employeeDto))
        );
    }

    //Удаление по id
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable String id) {
        Integer parseId = Integer.parseInt(id);
        service.removeById(parseId);
    }

    //Удаление всех юзеров
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        service.removeAll();
    }


    @PostMapping("/sendEmailByCountry")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmailByCountry(@RequestParam String country, @RequestParam String text) {
        service.sendEmailByCountry(country, text);
    }

    @PostMapping("/sendEmailByCity")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmailByCity(@RequestParam String cities, @RequestBody String text) {
        service.sendEmailByCity(cities, text);
    }

    @PostMapping("/fillingDataBase/{quantity}")
    @ResponseStatus(HttpStatus.OK)
    public void fillingDataBase(@PathVariable String quantity) {
        service.fillingDataBase(quantity);
    }

    @PostMapping("/updateBaseByCountryFully")
    @ResponseStatus(HttpStatus.OK)
    public void updateByCountryFully(@RequestParam String countries) {
        service.updaterByCountryFully(countries);
    }

    @PostMapping("/updateBaseByCountrySmart")
    @ResponseStatus(HttpStatus.OK)
    public void updateByCountrySmart(@RequestParam String countries) {
        service.updaterByCountrySmart(countries);
    }

    @PostMapping("/replaceNull")
    @ResponseStatus(HttpStatus.OK)
    public void replaceNull() {
        service.processor();
    }
}