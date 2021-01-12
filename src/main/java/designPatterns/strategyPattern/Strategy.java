package designPatterns.strategyPattern;

public abstract class Strategy {
    // 定义算法方法
    public abstract double AlgorithmInterface(double money);
}

// 模拟正常收费
class ConcreateStrategyA extends Strategy{

    @Override
    public double AlgorithmInterface(double money) {
        return money;
    }
}

// 模拟打折的情况
class ConcreateStrategyB extends Strategy{
    private double discount;

    public ConcreateStrategyB(double discount) {
        this.discount = discount;
    }

    @Override
    public double AlgorithmInterface(double money) {
        return money * discount;
    }
}

// 模拟满减的情况
class ConcreateStrategyC extends Strategy{
    private double cash;
    private double rebate;

    public ConcreateStrategyC(double cash, double rebate) {
        this.cash = cash;
        this.rebate = rebate;
    }

    @Override
    public double AlgorithmInterface(double money) {
        if (money >= cash){
            money -= Math.floor(money / cash) * rebate;
        }
        return money;
    }
}