package cn.how2j.diytomcat.test;

import java.io.File;
import java.lang.reflect.Method;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author tqszbd
 */
public class CustomizedClassLoader extends ClassLoader {
  //  private File classesFolder = new File(System.getProperty("user.dir"), "classes_5_test");
  private File classesFolder = new File("D:/tq_project/javaweb/web/WEB-INF/classes");

    @Override
    protected Class<?> findClass(String QualifiedName) throws ClassNotFoundException {
        byte[] data = loadClassData(QualifiedName);
        return defineClass(QualifiedName, data, 0, data.length);
    }

    private byte[] loadClassData(String fullQualifiedName) throws ClassNotFoundException {
        String fileName = StrUtil.replace(fullQualifiedName, ".", "/") + ".class";
        System.out.println(classesFolder.getName());
        File classFile = new File(classesFolder, fileName);
        System.out.println(classFile.getName());
        if (!classFile.exists()) {
            throw new ClassNotFoundException(fullQualifiedName);
        }
        return FileUtil.readBytes(classFile);
    }

    public static void main(String[] args) throws Exception {

        CustomizedClassLoader loader = new CustomizedClassLoader();

        Class<?> how2jClass = loader.loadClass("HHH");

        System.out.println(how2jClass.getClassLoader());

        Object o = how2jClass.newInstance();

        Method m = how2jClass.getMethod("haha");

        m.invoke(o);

        System.out.println(how2jClass.getClassLoader());

    }

}
