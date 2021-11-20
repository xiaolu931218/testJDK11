package com;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

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

    /**
     * 流的操作
     */
    @Test
    public void testStream() {
        var list = List.of(1, 2, 3, 4);
        // 因为println方法和forEach方法都是有参数，无返回值，所以可以用：：这种
        list.stream().forEach(x -> System.out.print(x % 2 ));

        // java.lang.NullPointerException
        //Stream<Object> stream = Stream.of(null);
        // ofNullable会调 empty()创建空数组
        Stream<Object> stream = Stream.ofNullable(null);
        stream.forEach(System.out::println);

        System.out.println("1、========");
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
        // takeWhile()方法接受所有值，直到谓词返回false为止
        stream1.takeWhile(x -> x % 2 != 0).forEach(System.out::print);//1
        System.out.println("\n2、========");
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);
        // dropWhile()方法丢弃所有值，直到谓词返回false为止
        stream2.dropWhile(x -> x % 2 != 0).forEach(System.out::print);//23456

    }

    @Test
    public void testIterate() {
        Stream<Integer> iterate = Stream.iterate(1, t -> t * 2 + 1);
        // 无限流会无限增长
//        iterate.forEach(System.out::println);
        // 限制10个
//        iterate.limit(10).forEach(System.out::println);

        // 新的限制流，限制在小于1000
        Stream<Integer> iterate1 = Stream.iterate(1, t -> t < 1000, t -> t * 2 + 1);
        iterate1.forEach(System.out::println);
    }
}
