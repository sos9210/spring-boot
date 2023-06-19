package hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogController {

    @GetMapping("/log")
    public String log() {
        log.trace("trace log입니다");
        log.debug("debug log입니다");
        log.info("info log입니다");
        log.warn("warn log입니다");
        log.error("error log입니다");
        return "ok";
    }
}
