package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

@Slf4j
public class CommandLineV2 {
    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg = {}",arg);
        }

        //스프링에서 제공하는 기능
        ApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs()));          //모든 옵션인수 한번에 조회
        log.info("NonOptionsArgs = {}", appArgs.getNonOptionArgs());            // --가 안들어간것
        log.info("OptionNames = {}",appArgs.getOptionNames());                  //옵션 키값

        //--가 들어가야만 키값으로 조회가 가능해진다.
        Set<String> optionNames = appArgs.getOptionNames();
        for (String optionName : optionNames) {
            log.info("option arg {}={}",optionName,appArgs.getOptionValues(optionName));
        }

        //키값으로 조회
        //List로 반환하는 이유는 하나의 키에 여러개의 값이 들어갈수 있기때문
        List<String> url = appArgs.getOptionValues("url");
        List<String> username = appArgs.getOptionValues("username");
        List<String> password = appArgs.getOptionValues("password");
        List<String> mode = appArgs.getOptionValues("mode");
        log.info("url={}",url);
        log.info("username={}",username);
        log.info("password={}",password);
        log.info("mode={}",mode);
    }
}
