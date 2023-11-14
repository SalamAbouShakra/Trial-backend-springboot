package tech.getarrays.departmentmanager.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import tech.getarrays.departmentmanager.mapper.DepartmentMapper;
import tech.getarrays.departmentmanager.model.DepartmentEntity;
import tech.getarrays.departmentmanager.modelDTO.DepartmentDTO;
import tech.getarrays.departmentmanager.repo.DepartmentRepo;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;
    private final DepartmentMapper departmentMapper;

//    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo, DepartmentMapper departmentMapper) {
        this.departmentRepo = departmentRepo;
        this.departmentMapper = departmentMapper;
    }
//    public DepartmentEntity addDepartment(DepartmentEntity departmentEntity) {
//        return departmentRepo.save(departmentEntity);
//    }



//    public List<DepartmentEntity> findAllDepartments() {
//        return departmentRepo.findAll();
//    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departments = departmentRepo.findAll();
        return departments.stream()
                .map(departmentMapper::departmentEntityToDepartmentDTO)
                .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(int id) {
        DepartmentEntity departmentEntity = departmentRepo.findById(id).orElse(null);
        if (departmentEntity != null)
            return departmentMapper.departmentEntityToDepartmentDTO(departmentEntity);
        return null;
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity = departmentMapper.departmentDTOToDepartmentEntity(departmentDTO);
        departmentEntity = departmentRepo.save(departmentEntity);
        return departmentMapper.departmentEntityToDepartmentDTO(departmentEntity);
    }

//    public DepartmentDTO updateDepartment(int id, DepartmentDTO departmentDTO) {
//        DepartmentEntity existingDepartmentEntity = departmentRepo.findById(id).orElse(null);
//
//        if (existingDepartmentEntity != null) {
//            // Update the existing user entity with new data
//            existingDepartmentEntity.setName(departmentDTO.getName());
//            existingDepartmentEntity.setPhoneNumber(departmentDTO.getPhoneNumber());
//
//            // Save and return the updated user
//            existingDepartmentEntity = departmentRepo.save(existingDepartmentEntity);
//            return departmentMapper.departmentEntityToDepartmentDTO(existingDepartmentEntity);
//        } else {
//            // Handle the case where the user to update is not found
//            return null;
//        }
//    }

    public void deleteDepartment(int id) {
        departmentRepo.deleteById(id);
    }

//    @Override
    public void updateDepartment(int id, Map<String, Object> departmentMap) {
        DepartmentEntity entityToUpdate = departmentRepo.findById(id).orElse(null);
        Class entityToUpdateClass = DepartmentEntity.class;
        updateEntity(departmentMap, entityToUpdate, entityToUpdateClass);
        departmentRepo.saveAndFlush(entityToUpdate);
    }

    public void updateEntity(Map<String, Object> entityDTO, Object entityToUpdate, Class entityToUpdateClass) {
        // Map key is field name, v is value
        entityDTO.forEach((k, v) -> {
            // use reflection to get field k on entityToUpdate and set it to value k
            Field field = ReflectionUtils.findField(entityToUpdateClass, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, entityToUpdate, v);
        });
    }



//    public void deleteDepartment(int id){
////        departmentRepo.deleteDepartmentEntityById(id);
//        departmentRepo.deleteById(id);
//    }

}
