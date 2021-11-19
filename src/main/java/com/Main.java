package com;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Consumer;

public class Main {


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
}
