package mylab.notification.service;

public class SmsNotificationService implements NotificationService {
    private String provider;

    public SmsNotificationService(String provider) {
        this.provider = provider;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS 발송: [" + message + "] via " + provider);
    }
    
    // 테스트를 위한 Getter
    public String getProvider() { return provider; }
}