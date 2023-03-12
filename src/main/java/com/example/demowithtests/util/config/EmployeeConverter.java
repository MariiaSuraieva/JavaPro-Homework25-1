package com.example.demowithtests.util.config;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.EmployeeDto;
import com.example.demowithtests.dto.EmployeeReadDto;
import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.MapperFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@AllArgsConstructor
@Component
public class EmployeeConverter {

    private final MapperFacade mapperFacade;


    public MapperFacade getMapperFacade() {
        return mapperFacade;
    }



    public EmployeeDto toDto(Employee entity) {
        return mapperFacade.map(entity, EmployeeDto.class);
    }

    public EmployeeReadDto toReadDto(Employee entity) {
        return mapperFacade.map(entity, EmployeeReadDto.class);
    }


    public Employee fromDto(EmployeeDto dto) {
        return mapperFacade.map(dto, Employee.class);
    }

    public Employee fromReadDto(EmployeeReadDto readDto) {
        return mapperFacade.map(readDto, Employee.class);
    }
}
