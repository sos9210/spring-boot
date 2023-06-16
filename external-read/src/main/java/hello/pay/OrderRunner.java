package hello.pay;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRunner implements ApplicationRunner { //ApplicationRunner구현체를 스프링이 올라오면서 run()을 실행시켜줌

    private final OrderService orderService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        orderService.order(1000);
    }
}
