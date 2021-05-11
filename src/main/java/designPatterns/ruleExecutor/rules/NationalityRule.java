package designPatterns.ruleExecutor.rules;


import designPatterns.ruleExecutor.dto.NationalityRuleDTO;
import designPatterns.ruleExecutor.dto.RuleDTO;

/**
 * 具体的国家规则
 * @author ziwing
 * @date 2021/5/11
 */
public class NationalityRule extends AbstractRule {

    /**
     * 模拟业务规则，如果该地址以深圳开头，则属于中国的
     * @param dto 业务数据
     * @param <T> 通用泛型
     * @return T
     */
    @Override
    protected <T> T convert(RuleDTO dto) {
        NationalityRuleDTO nationalityRuleDTO = new NationalityRuleDTO();
        if (dto.getAddress().startsWith("深圳")){
            nationalityRuleDTO.setNationality("中国");
        }
        return (T) nationalityRuleDTO;
    }

    @Override
    protected <T> boolean executeRule(T t) {
        NationalityRuleDTO ruleDTO = (NationalityRuleDTO) t;
        if (ruleDTO.getNationality().startsWith("中国")){
            return true;
        }
        return false;
    }
}
