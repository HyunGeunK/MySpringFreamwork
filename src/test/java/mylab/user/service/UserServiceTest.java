package mylab.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // Spring과 JUnit을 연동합니다.
@ContextConfiguration("classpath:mylab-user-di.xml") // 설정 파일을 로드합니다.
public class UserServiceTest {

    @Autowired // 테스트할 UserService Bean을 주입받습니다.
    private UserService userService;

    @Test
    public void testDiConfiguration() {
        // 1. UserService가 제대로 주입되었는지 검증
        System.out.println("검증 1: UserService가 null이 아닌지 확인");
        assertNotNull("UserService should not be null", userService);
        System.out.println("✅ 통과: UserService가 성공적으로 주입되었습니다.");

        // 2. UserRepository가 제대로 주입되었는지 검증
        System.out.println("\n검증 2: UserRepository가 null이 아닌지 확인");
        assertNotNull("UserRepository should not be null", userService.getUserRepository());
        System.out.println("✅ 통과: UserRepository가 성공적으로 주입되었습니다.");
        
        // 3. UserRepository의 dbType 값 검증
        System.out.println("\n검증 3: UserRepository의 dbType이 'MySQL'인지 확인");
        assertEquals("DB type should be MySQL", "MySQL", userService.getUserRepository().getDbType());
        System.out.println("✅ 통과: dbType 값이 'MySQL'로 일치합니다.");
        
        // 4. SecurityService가 제대로 주입되었는지 검증
        System.out.println("\n검증 4: SecurityService가 null이 아닌지 확인");
        assertNotNull("SecurityService should not be null", userService.getSecurityService());
        System.out.println("✅ 통과: SecurityService가 성공적으로 주입되었습니다.");

        // 5. registerUser 메서드가 정상 동작하는지 검증
        System.out.println("\n검증 5: registerUser 메서드가 true를 반환하는지 확인");
        assertTrue("registerUser should return true", userService.registerUser("testuser", "password"));
        System.out.println("✅ 통과: registerUser 메서드가 정상적으로 동작합니다.");
    }
}