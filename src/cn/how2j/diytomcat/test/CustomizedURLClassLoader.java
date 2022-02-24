package cn.how2j.diytomcat.test;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author tqszbd
 */
public class CustomizedURLClassLoader extends URLClassLoader {

    public CustomizedURLClassLoader(URL[] urls) {
        super(urls);
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL("file:d:/tq_project/diytomcat/jar_4_test/test.jar");
        URL[] urls = new URL[] {url};

        CustomizedURLClassLoader loader1 = new CustomizedURLClassLoader(urls);

        Class<?> how2jClass1 = loader1.loadClass("cn.how2j.diytomcat.test.HOW2J");
        System.out.println(how2jClass1.getClassLoader());
        CustomizedURLClassLoader loader2 = new CustomizedURLClassLoader(urls);
        Class<?> how2jClass2 = loader2.loadClass("cn.how2j.diytomcat.test.HOW2J");
        System.out.println(how2jClass2.getClassLoader());
        System.out.println(how2jClass1==how2jClass2);
//        Object o = how2jClass.newInstance();
//        Method m = how2jClass.getMethod("hello");
//        m.invoke(o);
//
//        System.out.println(how2jClass.getClassLoader());

    }

}
