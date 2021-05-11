package designPatterns.ruleExecutor.rules;

import designPatterns.ruleExecutor.dto.RuleDTO;

/**
 * 规则模板
 * @author ziwing
 * @date 2021/5/11
 */
public abstract class AbstractRule implements BaseRule {

    protected <T> T convert(RuleDTO dto){
        return (T) dto;
    }

    protected <T> boolean executeRule(T t){
        return true;
    }

    @Override
    public boolean execute(RuleDTO dto) {
        return executeRule(convert(dto));
    }
}
