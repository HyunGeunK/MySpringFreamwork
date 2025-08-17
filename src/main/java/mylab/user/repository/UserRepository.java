package mylab.user.repository;

import org.springframework.stereotype.Component;

@Component // 이 클래스를 Spring Bean으로 등록합니다.
public class UserRepository {
    private String dbType = "MySQL";

    public void saveUser(String username) {
        System.out.println(dbType + " DB에 사용자 '" + username + "'을(를) 저장했습니다.");
    }

    public String getDbType() {
        return dbType;
    }
}