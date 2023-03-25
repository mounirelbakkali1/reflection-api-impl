package org.example;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class OopsAgain {
    public static void main(String[] args) throws Exception{
        // TODO : Retreive class informations
            Bar Bar = new Bar();
        /*
                 Methode 1 with class instantiation :

            Class<? extends Bar> clazz = Bar.getClass();
        */
        /*
                 Methode 2 :
             Class<Bar> clazz = Bar.class;

         */
        // Methode 3 :
        Class<?> clazz = Class.forName("org.example.Bar");
        Field field = clazz.getDeclaredField("hidden");
        Field type = Field.class.getDeclaredField("type");
        AccessibleObject.setAccessible(
                new AccessibleObject[]{
                        field ,type
                },
                true
        );
        type.set(field,String.class);
        field.set(
                Bar,"should print 5"
        );
        Object hidden = field.get(Bar);
        System.out.println(hidden);
    }
}

class Bar{
    private int hidden = 10 ;
}
