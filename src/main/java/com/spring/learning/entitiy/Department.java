package com.spring.learning.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn()
    private int id;

    @Column()
    private  String name;

    @Column()
    private int min_salary;

    @Column()
    private int max_salary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employeeList;

    public void addEmployeeToDepartment(Employee employee){
        if(employeeList==null){ employeeList = new ArrayList<>();}
        employeeList.add(employee);
        employee.setDepartment(this);
    }

    public Department(String name, int min_salary, int max_salary) {
        this.name = name;
        this.min_salary = min_salary;
        this.max_salary = max_salary;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", min_salary=" + min_salary +
                ", max_salary=" + max_salary +
                '}';
    }
}

