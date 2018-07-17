package com.company.commonJava;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
//    https://dzone.com/articles/things-to-keep-in-mind-while-using-custom-classes
    private long id;
    private String name;
    private Date dateOfBirth;
    private BigDecimal salary;
    //Getter and Setters
    // to String
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        if (id != employee.id) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(employee.dateOfBirth) : employee.dateOfBirth != null) return false;
        return salary != null ? salary.equals(employee.salary) : employee.salary == null;
    }
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }
}
