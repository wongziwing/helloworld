package designPatterns.ruleExecutor.rules;

import designPatterns.ruleExecutor.dto.RuleDTO;

/**
 * 抽象规则
 * @author ziwing
 * @date 2021/5/11
 */
public interface BaseRule {

    boolean execute(RuleDTO dto);
}
