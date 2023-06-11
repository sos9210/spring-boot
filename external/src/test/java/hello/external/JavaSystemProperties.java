package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class JavaSystemProperties {

    public static void main(String[] args) {

        //자바 VM옵션을 통한 설정방법
        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            log.info("prop {}={}",key, System.getProperty(String.valueOf(key)));
        }

        String url = System.getProperty("url");
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        log.info("url={}",url);
        log.info("username={}",username);
        log.info("password={}",password);

        //자바코드로 환경변수 설정
        System.setProperty("hello_key","hello_value");
        String value = System.getProperty("hello_key");
        log.info("hello_key={}",value);
    }
}
