package designPatterns.ruleExecutor;

import designPatterns.ruleExecutor.dto.RuleDTO;
import designPatterns.ruleExecutor.rules.AddressRule;
import designPatterns.ruleExecutor.rules.AgeRule;
import designPatterns.ruleExecutor.rules.NationalityRule;

import java.util.Arrays;
import java.util.Collections;

/**
 * 模拟执行器运行
 * @author ziwing
 * @date 2021/5/11
 */
public class RuleServicesMain {

    public static void main(String[] args) {
        AddressRule addressRule = new AddressRule();
        NationalityRule nationalityRule = new NationalityRule();
        AgeRule ageRule = new AgeRule();

        RuleDTO ruleDTO = new RuleDTO();
        ruleDTO.setAddress("深圳市南山区");
        ruleDTO.setName("xxx");
        ruleDTO.setAge(18);

        boolean result = RuleService.create()
                .and(Arrays.asList(nationalityRule, ageRule))
                .or(Collections.singletonList(addressRule))
                .execute(ruleDTO);
        System.out.println("result is " + result);
    }
}
