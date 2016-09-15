package ru.sbt.bit.ood.solid.homework;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SalaryHtmlReportNotifier {

    private final Connection connection;

    public SalaryHtmlReportNotifier(Connection databaseConnection) {
        this.connection = databaseConnection;
    }

    public void generateAndSendHtmlSalaryReport(String departmentId, LocalDate dateFrom, LocalDate dateTo, String recipients) throws SQLException {
        Report report = new Report(departmentId, new LocalDateRange(dateFrom, dateTo));
        ResultSet resultOfQuery = new DbQuery(connection).resultOfQuery(report);
        String htmlForm = new WebForm(resultOfQuery).generateHtmlForm();
        new SenderMail().send(htmlForm, recipients);
    }
}

