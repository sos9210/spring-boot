package hello.external;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommandLineV1 {
    //자바에서 제공하는 옵션방법 (키값형태가 아닌 공백을 기준으로 나눠짐)
    public static void main(String[] args) {
        for (String arg : args) {
            log.info("args {}",arg);
        }
    }
}
