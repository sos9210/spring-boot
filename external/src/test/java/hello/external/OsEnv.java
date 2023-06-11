package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class OsEnv {

    public static void main(String[] args) {
        //OS환경변수를 사용하는 설정방법
        Map<String, String> envMap = System.getenv();
        for (String key : envMap.keySet()) {
            log.info("env {}={}", key,envMap.get(key));
        }

        //개발,운영서버에서 환경변수를 셋팅(ex: db접속정보)하고 불러온다.
        String deurl = System.getenv("DEURL");
    }
}
