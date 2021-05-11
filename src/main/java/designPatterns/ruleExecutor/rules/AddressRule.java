package designPatterns.ruleExecutor.rules;

import designPatterns.ruleExecutor.dto.RuleDTO;

import java.util.Optional;

/**
 * 具体的地址规则
 * @author ziwing
 * @date 2021/5/11
 */
public class AddressRule extends AbstractRule {

    /**
     * 重写具体的规则逻辑
     * 例如: 下列例子，匹配以深圳为开头的业务数据
     * @param dto 业务数据
     * @return 是否通过规则
     */
    @Override
    public boolean execute(RuleDTO dto) {
        System.out.println("AddressRule invoke");
        return Optional.ofNullable(dto.getAddress())
                .map(a -> a.startsWith("深圳"))
                .orElse(false);

    }
}
