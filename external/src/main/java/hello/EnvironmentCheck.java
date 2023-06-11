package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnvironmentCheck {
    //스프링에서 제공하는 기능
    //자바시스템옵션(VmOption), 커맨드라인옵션, 설정데이터(파일 ex:properties,yml),OS환경변수 등에서 모두 Key,Value형태로 조회가능하다.
    //키값이 같은경우 우선순위는 범위가 넓은것보다 좁은것이 더 우선순위를 갖는다.
    //설정데이터 > 커맨드라인옵션> 자바시스템옵션> OS환경변수
    private final Environment env;

    public EnvironmentCheck(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init() {
        String url = env.getProperty("url");
        String username = env.getProperty("username");
        String password = env.getProperty("password");
        log.info("env url = {}",url);
        log.info("env username = {}",username);
        log.info("env password = {}",password);
    }
}
