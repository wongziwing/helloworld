package IOCDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ziwing
 * @date 2021/3/7
 */
public class DemoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(APPConfiguration.class);
        System.out.println("===================================");
        // 从ioc容器中获取 名称为language的bean
        Language language = (Language)context.getBean("language");
        System.out.println("bean language: " + language);
        System.out.println("language.sayBye: " + language.getBye());

        Language language2 = (Language)context.getBean("language");
        System.out.println("bean language2: " + language2);
        System.out.println("language == language2 ? --> " + (language == language2));
        // 从ioc容器中获取 名称为greetingService的bean
        GreetingService service = (GreetingService)context.getBean("greetingService");
        service.sayGreeting();
        System.out.println("===================================");
        // 从ioc容器中获取 名称为myComponent的bean
        MyComponent myComponent = (MyComponent)context.getBean("myComponent");
        myComponent.showAppInfo();

        APPConfiguration app = new APPConfiguration();
        System.out.println("one class: " + app.getLanguage());
        System.out.println("two class: " + app.getLanguage());

        System.out.println(app.getLanguage() instanceof Language);
    }

}
