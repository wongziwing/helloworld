package IOCDemo;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author ziwing
 * @date 2021/3/7
 */
@Repository
public class MyRepository {

    public String getAppName(){
        return "hello my first spring app";
    }

    public Date getSystemDateTime(){
        return new Date();
    }

}
