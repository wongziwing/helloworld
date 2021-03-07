package IOCDemo;

/**
 * 具体的语言
 * @author ziwing
 * @date 2021/3/7
 */
public class Chinese implements Language {
    @Override
    public String getGreeting() {
        return "你好";
    }

    @Override
    public String getBye() {
        return "再见";
    }
}
