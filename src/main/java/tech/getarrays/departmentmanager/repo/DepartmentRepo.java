package tech.getarrays.departmentmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.departmentmanager.model.DepartmentEntity;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Integer> {
//    void deleteDepartmentEntityById(int id);
}
