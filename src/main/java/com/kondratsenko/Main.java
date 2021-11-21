package com.kondratsenko;

import com.kondratsenko.dto.EmployeeDto;
import com.kondratsenko.dto.ResultDto;
import com.kondratsenko.employee.Employee;
import com.kondratsenko.factory.FactoryEmployee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = query.from(Employee.class);
        query.select(employeeRoot);
        em.createQuery(query).getResultList().forEach(Main::print);

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
//        query.from(Employee.class);
//        em.createQuery(query).getResultList().forEach(Main::print);

//        TypedQuery<FactoryEmployee> query = em.createQuery(
//                "select fe from FactoryEmployee fe join fetch fe.employees", FactoryEmployee.class);
//        query.getResultList().forEach(Main::print);

//        TypedQuery<ResultDto> query = em.createQuery(
//                "select new com.kondratsenko.dto.ResultDto(e.name, fe.name, e.salary) from Employee e, FactoryEmployee fe where e.factoryEmployee = fe and e.salary > 1000", ResultDto.class);
//        query.getResultList().forEach(Main::print);

//        TypedQuery<ResultDto> query = em.createQuery(
//                "select new com.kondratsenko.dto.ResultDto(e.name, ef.name, e.salary) from Employee e join e.factoryEmployee ef ", ResultDto.class);
//        query.getResultList().forEach(Main::print);

//        TypedQuery<FactoryEmployee> query = em.createQuery("select fe from Employee e join e.factoryEmployee fe", FactoryEmployee.class);
//        query.getResultList().forEach(Main::print);

//        TypedQuery<FactoryEmployee> query = em.createQuery("select e.factoryEmployee from Employee e", FactoryEmployee.class);
//        query.getResultList().forEach(Main::print);

//        TypedQuery<EmployeeDto> query = em.createNamedQuery("byName", EmployeeDto.class );
//        query.setParameter("name", "Samira");
//        query.getResultList().forEach(Main::print);

//        TypedQuery<EmployeeDto> query = em.createQuery("select new com.kondratsenko.dto.EmployeeDto(e.name, e.salary) from Employee e where e.name = :name", EmployeeDto.class );
//        query.setParameter("name", "Samira");
//        query.getResultList().forEach(Main::print);

//        TypedQuery<EmployeeDto> query = em.createQuery("select new com.kondratsenko.dto.EmployeeDto(e.name, e.salary) from Employee e where e.name like 'V%'", EmployeeDto.class );
//        query.getResultList().forEach(Main::print);

//        TypedQuery<EmployeeDto> query = em.createQuery("select new com.kondratsenko.dto.EmployeeDto(e.name, e.salary) from Employee e", EmployeeDto.class );
//        query.getResultList().forEach(Main::print);

//        Query query = em.createQuery("select e.name, e.salary from Employee e");
//        query.getResultList().stream().flatMap(arr -> Arrays.stream((Object[]) arr)).forEach(Main::print);

//        TypedQuery<String> query = em.createQuery("select e.name from Employee e", String.class);
//        query.getResultList().forEach(Main::print);

//        TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);
//        query.getResultList().forEach(Main::print);

//        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
//        query.getResultList().forEach(Main::print);

        et.commit();
        em.close();
    }

    private static void print(Object obj) {
        System.out.println("------" + obj);
    }
}
