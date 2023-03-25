package org.example;

import java.lang.reflect.Field;

public class Oops {
    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();
        Class<? extends Foo> clazz = foo.getClass();
        Field field =  clazz.getDeclaredField("hidden");
        field.setAccessible(true);
        Object hidden = field.get(foo);
        System.out.println(hidden);

    }
}


class Foo{
    private String hidden = "This should remain inacceble !";
}