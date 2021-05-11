package designPatterns.ruleExecutor;

import designPatterns.ruleExecutor.dto.RuleDTO;
import designPatterns.ruleExecutor.rules.BaseRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 执行器构建
 * @author ziwing
 * @date 2021/5/11
 */
public class RuleService {

    private final Map<Integer, List<BaseRule>> rules = new HashMap<>();

    private static final int AND = 1;

    private static final int OR = 0;

    public static RuleService create(){
        return new RuleService();
    }

    public RuleService and(List<BaseRule> ruleList){
        rules.put(AND, ruleList);
        return this;
    }

    public RuleService or(List<BaseRule> ruleList){
        rules.put(OR, ruleList);
        return this;
    }

    private boolean and(RuleDTO dto, List<BaseRule> ruleList){
        for (BaseRule rule : ruleList) {
            boolean execute = rule.execute(dto);
            // and 需要保证全部成功
            if (!execute){
                return false;
            }
        }
        return true;
    }

    private boolean or(RuleDTO dto, List<BaseRule> ruleList){
        for (BaseRule rule : ruleList) {
            // or 保证成功一次即可
            if (rule.execute(dto)){
                return true;
            }
        }
        return false;
    }

    public boolean execute(RuleDTO dto){
        for (Map.Entry<Integer, List<BaseRule>> item : rules.entrySet()){
            List<BaseRule> ruleList = item.getValue();
            switch (item.getKey()){
                case AND:
                    System.out.println("execute key = " + AND);
                    if (!and(dto, ruleList)){
                        return false;
                    }
                    break;
                case OR:
                    System.out.println("execute key = " + OR);
                    if (!or(dto, ruleList)){
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }
}














