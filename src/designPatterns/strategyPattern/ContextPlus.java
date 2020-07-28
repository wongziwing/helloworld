package designPatterns.strategyPattern;

/**
 * 改进后的上下文
 */
public class ContextPlus {
    Strategy strategy = null;

    /**
     * 选择收费模型
     * @param type 传入收费类型
     */
    public ContextPlus(String type) {
        switch (type){
            case "正常收费":
                ConcreateStrategyA csa = new ConcreateStrategyA();
                strategy = csa;
                break;
            case "打8折":
                ConcreateStrategyB csb = new ConcreateStrategyB(0.8);
                strategy = csb;
                break;
            case "满300返100":
                ConcreateStrategyC csc = new ConcreateStrategyC(300, 100);
                strategy = csc;
                break;
        }
    }

    public double getResult(double money){
        return strategy.AlgorithmInterface(money);
    }
}
