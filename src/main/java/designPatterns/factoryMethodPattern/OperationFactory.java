package designPatterns.factoryMethodPattern;

import java.util.Map;

public class OperationFactory {

    public static Operation createOperate(String operate){
        Operation oper = null;
        switch (operate){
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }

    public static Operation getOperationByClassName(String className){

        try {
            Map<String, String> map = new PropertiesReader().getProperties();
            Operation operation = (Operation) Class.forName(map.get(className)).newInstance();
            return operation;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
