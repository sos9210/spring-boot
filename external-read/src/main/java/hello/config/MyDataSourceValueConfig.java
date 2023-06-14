package hello.config;

import hello.datasource.MyDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

@Slf4j
@Configuration
public class MyDataSourceValueConfig {
//@Value 방식은 필드주입과,파라미터 주입으로 받을 수 있다.

    @Value("${my.datasource.url}")
    private String url;
    @Value("${my.datasource.username}")
    private String username;
    @Value("${my.datasource.password}")
    private String password;
    @Value("${my.datasource.etc.max-connection}")
    private int maxConnection;
    @Value("${my.datasource.etc.timeout}")
    private Duration timeout;
    @Value("${my.datasource.etc.options}")
    private List<String> options;

    @Bean
    public MyDataSource myDataSource1() {
        return new MyDataSource(url,username,password,maxConnection,timeout,options);
    }
    @Bean
    public MyDataSource myDataSource2(
                            @Value("${my.datasource.url}") String url,
                            @Value("${my.datasource.username}") String username,
                            @Value("${my.datasource.password}") String password,
                            //${키:기본값} 프로퍼티 조회시 값이 없는경우 기본값을 설정할 수 있다.
                            @Value("${my.datasource.etc.max-connection-asdf:22}") int maxConnection,
                            @Value("${my.datasource.etc.timeout}") Duration timeout,
                            @Value("${my.datasource.etc.options}") List<String> options) {
        return new MyDataSource(url,username,password,maxConnection,timeout,options);
    }
}