package ru.sbt.bit.ood.solid.homework;



public class Report {
    private final String departmentId;
    private final LocalDateRange localDateRange;


    public Report(String departmentId, LocalDateRange localDateRange) {
        this.departmentId = departmentId;
        this.localDateRange = localDateRange;

    }



    public String getDepartmentId() {
        return departmentId;
    }

    public LocalDateRange getLocalDateRange() {
        return localDateRange;
    }
}
