package com;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class Main {

    // 测试var
    @Test
    public void testVar() {

        var a = "AAA";
        System.out.println(a);

        var b = new StringBuffer("123");
        System.out.println(b instanceof StringBuffer);
        System.out.println(b);

        //var list = new ArrayList<Integer>();
        //list.add("aaa"); // 这里编译会报错

        //var n;  // 错误，无法推断类型

        // 函数接口中添加注解，正好可以用var
        Consumer<String> consumer = (@Deprecated var x) -> System.out.println(x.toUpperCase());
        consumer.accept("aaabbb");

    }

    /**
     * 测试集合新api
     */
    @Test
    public void testCollection() {

        // 创建集合使用新的方法
        List<Integer> list = List.of(1, 2, 3, 4);
        //list.add(5);// java.lang.UnsupportedOperationException

        var set = Set.of(1, "2");
        set.forEach(x -> {
            System.out.println(x.getClass());
            System.out.println(set.getClass());
        });

        //set.add(3);// java.lang.UnsupportedOperationException

        Map<String, Integer> map = Map.of("1", 1, "2", 2);
        System.out.println(map.get("1"));
        //map.put("3", 3);// java.lang.UnsupportedOperationException

    }
}
