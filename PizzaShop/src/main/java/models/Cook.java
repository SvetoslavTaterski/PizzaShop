package models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Table(name = "cook")
@Entity
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName; // first_name

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "employee_number")
    private Integer employeeNum; // employee_num
}
