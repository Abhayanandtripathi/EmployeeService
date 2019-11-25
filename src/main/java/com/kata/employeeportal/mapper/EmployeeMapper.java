package com.kata.employeeportal.mapper;

import com.kata.employeeportal.data.EmployeeDTO;
import com.kata.employeeportal.data.EmployeeEntity;
import com.kata.employeeportal.data.EmployeesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    @Mapping(target="dateOfBirth", source = "entity.dateOfBirth", dateFormat = "dd/MM/yyyy")
    EmployeeDTO toEmployeeDTO(EmployeeEntity entity);
    @Mapping(target="dateOfBirth", source = "dto.dateOfBirth", dateFormat = "dd/MM/yyyy")
    EmployeeEntity toEmployeeEntity(EmployeeDTO dto);
    default EmployeesDTO toEmployeesDTO(List<EmployeeEntity> entities){
        return new EmployeesDTO(entities.stream().map(this::toEmployeeDTO).collect(Collectors.toList()));
    }
}
