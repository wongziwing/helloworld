package designPatterns.factoryMethodPattern;

/**
 * 通过输入不同的操作符，产生不同的对象，
 */
public class OperationTest {

    public static void main(String[] args) throws Exception {
        String add = "add";
        Operation operation = OperationFactory.getOperationByClassName(add);
        assert operation != null;
        operation.setNumberA(100);
        operation.setNumberB(50);
        System.out.println("operation.getResult() = " + operation.getResult());
    }


}
