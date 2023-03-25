package org.example;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
        // this line :
        AccessibleObject.setAccessible(
                new AccessibleObject[]{
                        type,field
                },true
        );
        // is equivalent to field.setAccessible(true); && type.setAccessible(true);
        assert field.isAccessible();

        type.set(field,String.class);
        field.set(
                Bar,"should print 5"
        );
        Object hidden = field.get(Bar);
        System.out.println(hidden);

        Method speakMeth = clazz.getDeclaredMethod("speak");
        speakMeth.setAccessible(true);
        speakMeth.invoke(Bar);

        VI[] values = VI.class.getEnumConstants();
        for (VI value : values){
            System.out.println(value);
        }
        Field[] fields = WSSystem.class.getDeclaredFields();
    }


}

class Bar{
    private int hidden = 10 ;
    private void speak(){
        System.out.println("I am speaking..");
    }
}

interface WSSystem{
    void doSomething();
    void run();
    void stop();
}

enum VI{
    ONE , TWO , THREE
}