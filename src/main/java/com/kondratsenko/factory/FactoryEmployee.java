package com.kondratsenko.factory;

import com.kondratsenko.employee.Employee;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(exclude = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name = "employee_factory")

public class FactoryEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "factoryEmployee", cascade = CascadeType.PERSIST)
    private Set<Employee> employees;
}
