package ru.sbt.bit.ood.solid.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbQuery {

    private final Connection connection;

    public DbQuery(Connection connection) {
        this.connection = connection;
    }

    public ResultSet resultOfQuery(Report report) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select emp.id as emp_id, emp.name as amp_name, sum(salary) as salary from employee emp left join" +
                "salary_payments sp on emp.id = sp.employee_id where emp.department_id = ? and" +
                " sp.date >= ? and sp.date <= ? group by emp.id, emp.name");
        // inject parameters to sql
        ps.setString(0, report.getDepartmentId());
        ps.setDate(1, new java.sql.Date(report.getLocalDateRange().getFrom().toEpochDay()));
        ps.setDate(2, new java.sql.Date(report.getLocalDateRange().getTo().toEpochDay()));
        // execute query and get the results
        return ps.executeQuery();
    }


}
