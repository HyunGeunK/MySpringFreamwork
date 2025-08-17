package mylab.notification.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import mylab.notification.manager.NotificationManager;
import mylab.notification.service.EmailNotificationService;
import mylab.notification.service.SmsNotificationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // Spring과 JUnit을 연동합니다.
@ContextConfiguration(classes = NotificationConfig.class) // XML 대신 Java 설정 클래스를 로드합니다.
public class NotificationConfigTest {

    @Autowired // 테스트할 NotificationManager Bean을 주입받습니다.
    private NotificationManager notificationManager;

    @Test
    public void testDiConfiguration() {
        // 1. NotificationManager 주입 검증
        System.out.println("검증 1: NotificationManager가 null이 아닌지 확인");
        assertNotNull("NotificationManager should not be null", notificationManager);
        System.out.println("✅ 통과: NotificationManager가 성공적으로 주입되었습니다.");

        // 2. Email 서비스 검증
        System.out.println("\n검증 2: EmailService 속성 확인");
        assertNotNull("EmailService should not be null", notificationManager.getEmailService());
        
        // 주입된 서비스가 EmailNotificationService 타입인지 확인
        assertTrue(notificationManager.getEmailService() instanceof EmailNotificationService);
        EmailNotificationService emailService = (EmailNotificationService) notificationManager.getEmailService();
        
        assertEquals("SMTP server should be 'smtp.gmail.com'", "smtp.gmail.com", emailService.getSmtpServer());
        assertEquals("Port should be 587", 587, emailService.getPort());
        System.out.println("✅ 통과: EmailService가 올바른 값으로 주입되었습니다.");
        
        // 3. SMS 서비스 검증
        System.out.println("\n검증 3: SmsService 속성 확인");
        assertNotNull("SmsService should not be null", notificationManager.getSmsService());

        // 주입된 서비스가 SmsNotificationService 타입인지 확인
        assertTrue(notificationManager.getSmsService() instanceof SmsNotificationService);
        SmsNotificationService smsService = (SmsNotificationService) notificationManager.getSmsService();

        assertEquals("Provider should be 'SKT'", "SKT", smsService.getProvider());
        System.out.println("✅ 통과: SmsService가 올바른 값으로 주입되었습니다.");
        
        // 4. NotificationManager의 메서드 실행
        System.out.println("\n검증 4: 알림 메서드 실행 확인");
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
        System.out.println("✅ 통과: 모든 알림 메서드가 오류 없이 실행되었습니다.");
    }
}