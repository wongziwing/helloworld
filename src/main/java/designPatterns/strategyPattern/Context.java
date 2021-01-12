package designPatterns.strategyPattern;

public class Context {

    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    // 调用不同方法
    public void ContextInterface(){
        //strategy.AlgorithmInterface();
    }
}
