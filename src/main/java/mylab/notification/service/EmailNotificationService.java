package mylab.notification.service;

public class EmailNotificationService implements NotificationService {
    private String smtpServer;
    private int port;

    public EmailNotificationService(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("이메일 발송: [" + message + "] to " + smtpServer + ":" + port);
    }
    
    // 테스트를 위한 Getter
    public String getSmtpServer() { return smtpServer; }
    public int getPort() { return port; }
}