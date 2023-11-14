package tech.getarrays.departmentmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "department", schema = "departmentmanager", catalog = "")
public class DepartmentEntity {
    @Id@Column(name = "id")
    private int id;
    @Basic@Column(name = "name")
    private String name;
    @Basic@Column(name = "phone_number")
    private String phoneNumber;


}
