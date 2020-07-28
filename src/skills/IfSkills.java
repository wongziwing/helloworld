package skills;

import java.util.LinkedHashMap;
import java.util.function.Function;

public class IfSkills {

    /**
     * 将if-else转换成表驱动法
     * @param para 原始金额
     * @return 应该交的税
     */
    public static Double getTax(Double para){
        if (para == null || para < 0) return -1.0;

/*        if (para <= 2200){
            return 0.0;
        } else if (para <= 2700){
            return 0.2 * (para - 2200);
        } else if (para <= 3200){
            return 70 + 0.15 * (para - 2700);
        } else if (para <= 4500){
            return 140 + 0.2 * (para - 3200);
        } else {
            return 0.5 * para;
        }*/
        // 表驱动法
        LinkedHashMap<Double, Function<Double, Double>> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(2200.0, num -> 0.0);
        linkedHashMap.put(2700.0, num -> (num - 2200) * 0.2);
        linkedHashMap.put(3200.0, num -> 70 + (num - 2700) * 0.15);
        linkedHashMap.put(4500.0, num -> 140 + (num - 3200) * 0.2);

        for (Double i : linkedHashMap.keySet()){
            if (para <= i){
                return linkedHashMap.get(i).apply(para);
            }
        }
        return para * 0.5;
    }


    public static void main(String[] args) {
        Double[] list = {-1.0, 0.0, 1200.0, 2700.0, 3000.0, 3200.0, 4000.0, 4500.0, 5000.0};
        for (Double d : list){
            Double tax = getTax(d);
            System.out.println(tax);
        }

    }

}
