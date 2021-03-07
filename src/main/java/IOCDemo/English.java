package IOCDemo;

/**
 * 具体的语言类
 * @author ziwing
 * @date 2021/3/7
 */
public class English implements Language {
    @Override
    public String getGreeting() {
        return "hello";
    }

    @Override
    public String getBye() {
        return "bye";
    }
}
