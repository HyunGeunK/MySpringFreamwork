package mylab.user.service;

import mylab.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 이 클래스를 Spring Bean으로 등록합니다.
public class UserService {

    @Autowired // Spring이 UserRepository 타입의 Bean을 자동으로 주입합니다.
    private UserRepository userRepository;
    
    @Autowired // Spring이 SecurityService 타입의 Bean을 자동으로 주입합니다.
    private SecurityService securityService;
    
    public boolean registerUser(String username, String password) {
        if (securityService.authenticate(username, password)) {
            userRepository.saveUser(username);
            return true;
        }
        return false;
    }

    // 테스트를 위한 Getter 메서드
    public UserRepository getUserRepository() {
        return userRepository;
    }

    public SecurityService getSecurityService() {
        return securityService;
    }
}