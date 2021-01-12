package designPatterns.factoryMethodPattern;

/**
 * 计算器减法运算, 重写其中getResult方法
 */
public class OperationSub extends Operation {

    @Override
    public double getResult() {
        double result = 0;
        result = super.getNumberA() - super.getNumberB();
        return result;
    }
}
