package mylab.order.di.xml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

// JUnit5에서 스프링 테스트를 사용하기 위한 어노테이션
@ExtendWith(SpringExtension.class)
// 스프링 컨테이너를 구성할 XML 파일의 위치를 지정
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {

    // 스프링 컨테이너에서 해당 타입의 Bean을 찾아 자동으로 주입
    @Autowired
    private ShoppingCart shoppingCart;
    
    @Autowired
    private OrderService orderService;
    
    @Test
    @DisplayName("ShoppingCart 스프링 Bean 테스트")
    void testShoppingCartInjection() {
        // shoppingCart 객체가 Null이 아닌지 검증
        assertNotNull(shoppingCart, "ShoppingCart Bean이 주입되지 않았습니다.");
        
        // shoppingCart에 담긴 상품의 개수가 2개인지 검증
        assertEquals(2, shoppingCart.getProducts().size(), "상품 목록의 크기가 2가 아닙니다.");
        
        // 첫 번째 상품의 이름이 "노트북"인지 검증
        assertEquals("노트북", shoppingCart.getProducts().get(0).getName(), "첫 번째 상품의 이름이 일치하지 않습니다.");
        
        // 두 번째 상품의 이름이 "스마트폰"인지 검증
        assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName(), "두 번째 상품의 이름이 일치하지 않습니다.");
        
        System.out.println("ShoppingCart 테스트 통과!");
    }
    
    @Test
    @DisplayName("OrderService 스프링 Bean 테스트")
    void testOrderServiceInjection() {
        // orderService 객체가 Null이 아닌지 검증
        assertNotNull(orderService, "OrderService Bean이 주입되지 않았습니다.");
        
        // OrderService에 ShoppingCart가 올바르게 주입되었는지 검증
        assertNotNull(orderService.getShoppingCart(), "OrderService에 ShoppingCart가 주입되지 않았습니다.");

        // 총 주문 금액 계산 테스트
        assertEquals(950000.0, orderService.calculateOrderTotal(), "주문 총액 계산이 올바르지 않습니다.");

        System.out.println("OrderService 테스트 통과!");
    }
}