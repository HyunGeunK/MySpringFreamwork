package mylab.user.service;

import org.springframework.stereotype.Component;

@Component // 이 클래스를 Spring Bean으로 등록합니다.
public class SecurityService {
    public boolean authenticate(String username, String password) {
        System.out.println("사용자 '" + username + "' 인증 성공.");
        return true;
    }
}