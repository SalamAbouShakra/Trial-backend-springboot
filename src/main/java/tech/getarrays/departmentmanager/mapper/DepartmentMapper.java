package tech.getarrays.departmentmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.getarrays.departmentmanager.model.DepartmentEntity;
import tech.getarrays.departmentmanager.modelDTO.DepartmentDTO;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDTO departmentEntityToDepartmentDTO(DepartmentEntity departmentEntity);

    DepartmentEntity departmentDTOToDepartmentEntity(DepartmentDTO departmentDTO);
}
