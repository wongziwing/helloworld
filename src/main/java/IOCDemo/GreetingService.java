package IOCDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ziwing
 * @date 2021/3/7
 */
@Service
public class GreetingService {

    @Autowired
    private Language language;

    public GreetingService(){

    }

    public void sayGreeting(){
        String greeting = language.getGreeting();
        System.out.println(greeting);
    }

}
