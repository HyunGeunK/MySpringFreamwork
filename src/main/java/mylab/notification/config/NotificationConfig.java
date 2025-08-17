package mylab.notification.config;

import mylab.notification.manager.NotificationManager;
import mylab.notification.service.EmailNotificationService;
import mylab.notification.service.NotificationService;
import mylab.notification.service.SmsNotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스는 Spring 설정 파일 역할을 합니다.
public class NotificationConfig {

    @Bean // 이 메서드가 반환하는 객체를 Spring Bean으로 등록합니다.
    public NotificationService emailService() {
        // EmailNotificationService 객체를 생성하여 반환
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    @Bean // 이 메서드가 반환하는 객체를 Spring Bean으로 등록합니다.
    public NotificationService smsService() {
        // SmsNotificationService 객체를 생성하여 반환
        return new SmsNotificationService("SKT");
    }

    @Bean // 이 메서드가 반환하는 객체를 Spring Bean으로 등록합니다.
    public NotificationManager notificationManager(NotificationService emailService, NotificationService smsService) {
        // Spring이 위에서 정의한 emailService와 smsService Bean을 자동으로 파라미터에 주입해줍니다.
        // 주입받은 객체들로 NotificationManager를 생성하여 반환합니다.
        return new NotificationManager(emailService, smsService);
    }
}