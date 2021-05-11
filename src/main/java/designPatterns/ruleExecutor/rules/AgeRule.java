package designPatterns.ruleExecutor.rules;

import designPatterns.ruleExecutor.dto.RuleDTO;

import java.util.Optional;

/**
 * 指定年龄规则
 * @author ziwing
 * @date 2021/5/11
 */
public class AgeRule extends AbstractRule {
    @Override
    public boolean execute(RuleDTO dto) {
        System.out.println("AgeRule invoke");
        return Optional.of(dto.getAge())
                .map(a -> a >= 18)
                .orElse(false);
    }
}
