package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GEmailSender {

    public boolean sendEmail(String to, String from, String subject) {
        boolean flag = false;

        //logic
        //smtp properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        String username = "madmani2127@gmail.com";
        String password = "hepu rwof zeaf rylz";


        //session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Read HTML content from file
            String htmlContent = readHtmlFromFile("D:\\Project_Workspace\\Local_Project\\.github\\workflows\\CoverageReport.html");

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(htmlContent, "text/html");

            // Send the message
            Transport.send(message);
            System.out.println("Message sent successfully.");
            flag = true;
        } catch (MessagingException | IOException ex) {
            System.out.println("Error sending email:");
            ex.printStackTrace();
        }

        return flag;
    }

    public static void main(String[] args) {

        GEmailSender gEmailSender = new GEmailSender();
        String to = "gbg1297@gmail.com";
        String from = "madmani2127@gmail.com";
        String subject = "HTML content test Mail";
        boolean b = gEmailSender.sendEmail(to, from, subject);
        if (b) {
            System.out.println("Email is sent successfully");
        } else {
            System.out.println("There is problem in sending email");
        }

    }

    private static String readHtmlFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

}
