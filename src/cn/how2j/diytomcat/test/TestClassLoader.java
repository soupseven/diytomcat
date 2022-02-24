package cn.how2j.diytomcat.test;

public class TestClassLoader {

    //    public static void main(String[] args) {
//        Object o = new Object();
//
//        System.out.println(o);
//
//        Class<?> clazz = o.getClass();
//
//        System.out.println(clazz);
//
//
    public static void main(String[] args) {

        System.out.println(Object.class.getClassLoader());

        System.out.println(TestClassLoader.class.getClassLoader());

    }

}
