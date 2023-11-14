package tech.getarrays.departmentmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.departmentmanager.model.DepartmentEntity;
import tech.getarrays.departmentmanager.modelDTO.DepartmentDTO;
import tech.getarrays.departmentmanager.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentResource {

    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/all")
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/find/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable int id) {

        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/add")
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO departmentDTO) {

        return departmentService.createDepartment(departmentDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable int id) {

        departmentService.deleteDepartment(id);
    }

//    @PutMapping("/update/{id}")
//    public DepartmentDTO updateDepartment(@PathVariable int id, @RequestBody DepartmentDTO departmentDTO) {
//
//        return departmentService.updateDepartment(id, departmentDTO);
//    }

    @PatchMapping("/update/{id}")
    public void updateDepartment(@PathVariable int id, @RequestBody Map<String, Object> departmentMap) {
        departmentService.updateDepartment(id, departmentMap);

    }


}
