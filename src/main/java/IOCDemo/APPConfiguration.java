package IOCDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ziwing
 * @date 2021/3/7
 */
@Configuration
@ComponentScan({"IOCDemo"})
public class APPConfiguration {

    @Bean(name = "language")
    public Language getLanguage(){
        return new Chinese();
    }

}
