package designPatterns.factoryMethodPattern;

/**
 * 计算器除法运算, 重写其中getResult方法
 */
public class OperationDiv extends Operation {

    @Override
    public double getResult() throws Exception {
        double result = 0;
        if (super.getNumberB() == 0){
            throw new Exception("除数不能为0");
        }
        result = super.getNumberA() / super.getNumberB();
        return result;
    }
}
