package com.kondratsenko.employee;

import com.kondratsenko.factory.FactoryEmployee;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(exclude = "factoryEmployee")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name = "employee")
@NamedQueries(@NamedQuery(name = "byName", query = "select new com.kondratsenko.dto.EmployeeDto(e.name, e.salary) from Employee e where e.name = :name"))
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int salary;

//    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "employee_factoryid")
    private FactoryEmployee factoryEmployee;

}
