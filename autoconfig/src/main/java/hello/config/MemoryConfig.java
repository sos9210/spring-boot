package hello.config;

import memory.MemoryCondition;
import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Conditional(MemoryCondition.class)
@ConditionalOnProperty(name = "memory", havingValue = "on") //MemoryCondition.class의 구현내용과 같음
public class MemoryConfig {

    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }
}
