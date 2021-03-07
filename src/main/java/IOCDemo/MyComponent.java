package IOCDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ziwing
 * @date 2021/3/7
 */
@Component
public class MyComponent {

    @Autowired
    private MyRepository repository;

    public void showAppInfo(){
        System.out.println("now is: " + repository.getSystemDateTime());
        System.out.println("app name: " + repository.getAppName());
    }

}
