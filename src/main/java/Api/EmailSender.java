package Api;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class EmailSender {

    public static void sendEmail(String to, String subject, String content) {
        final String username = "vitalmedclinica91@gmail.com";
        final String password = "qouz isrw hdsd grhu"; 

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        // Configuraciones anti-spam (¡Nuevo!)
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Usar TLS moderno
        props.put("mail.smtp.timeout", "5000"); // Timeout de 5 segundos
        props.put("mail.smtp.connectiontimeout", "5000");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            
  
            message.setFrom(new InternetAddress(username, "Clínica VitalMed")); 
            message.setReplyTo(InternetAddress.parse("no-reply@vitalmed.com"));
            
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            
         
            message.addHeader("Precedence", "bulk");
            message.addHeader("X-Priority", "1"); 
            message.addHeader("X-Mailer", "JavaMail");
            message.addHeader("Content-Type", "text/plain; charset=UTF-8");
            
            
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(content, "UTF-8");
            
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(
                "<html><body>" +
                "<p style='font-family:Arial;font-size:14px'>" + content.replace("\n", "<br>") + "</p>" +
                "<p style='font-family:Arial;font-size:12px;color:#666'>" +
                "Este es un correo automático, por favor no responda.</p>" +
                "</body></html>", 
                "text/html; charset=UTF-8"
            );
            
            Multipart multipart = new MimeMultipart("alternative");
            multipart.addBodyPart(textPart); 
            multipart.addBodyPart(htmlPart);
            
            message.setContent(multipart);
          
            message.saveChanges();
            
            Transport.send(message);
            System.out.println("Correo enviado con éxito a: " + to);

        } catch (MessagingException | UnsupportedEncodingException e) {
            System.err.println("Error al enviar el correo:");
            e.printStackTrace();
            throw new RuntimeException("Falló el envío: " + e.getMessage(), e);
        }
    }
}