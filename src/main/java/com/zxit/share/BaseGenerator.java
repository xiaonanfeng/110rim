package com.zxit.share;


import java.lang.reflect.Field;

/**
 * 代码生成器
 *
 * @author Administrator
 */
public class BaseGenerator {

    public static void main(String[] args) {
        String classFullName = "com.zxit.model.Jcjb";
//        getQuery(classFullName);
        getJPQL(classFullName);
    }


    private static void getJPQL(String classFullName) {
        try {
            Class<?> c = Class.forName(classFullName); //要包名+类名
            String className = c.getSimpleName();
            String classNameToFirstLower = BaseGenerator.toLowerCaseFirstOne(className);//类首字母小写
            Field[] fields = c.getDeclaredFields();//拿到数据成员
            System.out.println(" stringBuilder.append(\" from " + className + " t where \"); ");
            for (Field f : fields) {
                String type = f.getType().getSimpleName();
                String name = f.getName();
//                if type
                //时间段查询
                if (type.equals("Date")) {
                    System.out.println(type + " " + name + " = " + classNameToFirstLower + ".get" + BaseGenerator.toUpperCaseFirstOne(name) + "Start();");
                    System.out.println("if (null!=" + name + "){");//时间开始
                    System.out.println("String start = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\").format(" + name + ") ");
                    System.out.println("stringBuilder.append(\"" + name + " >= \"+ to_date('\"+start+\"','yyyy-MM-dd HH24:mi:ss') and " + "\");");
                    System.out.println("}");
                    System.out.println(type + " " + name + " = " + classNameToFirstLower + ".get" + BaseGenerator.toUpperCaseFirstOne(name) + "End();");
                    System.out.println("if (null!=" + name + "End){");//时间结束
                    System.out.println("String end = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\").format(" + name + ") ");
                    System.out.println("stringBuilder.append(\"" + name + " <= \"+ to_date('\"+end+\"','yyyy-MM-dd HH24:mi:ss') and " + "\");");
                    System.out.println("}");
                }
//                //字符串模糊查询
                if (type.equals("String")) {
                    System.out.println(type + " " + name + " = " + classNameToFirstLower + ".get" + BaseGenerator.toUpperCaseFirstOne(name) + "();");
                    System.out.println("if (StringUtils.isNoneBlank(" + name + ")){");
                    System.out.println("stringBuilder.append(\"" + name + " like '%\"+ " + name + "+\"%' and " + "\");");
                    System.out.println("}");
                }
                //Integer查询
                if (type.equals("Long")) {
                    System.out.println(type + " " + name + " = " + classNameToFirstLower + ".get" + BaseGenerator.toUpperCaseFirstOne(name) + "();");
                    System.out.println("if (null!=" + name + "){");
                    System.out.println("stringBuilder.append(\"" + name + " = \"+ " + name + "+\" and " + "\");");
                    System.out.println("}");
                }
            }
            System.out.println(" stringBuilder.append(\" 1 =1 \"); ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void getQuery(String classFullName) {
        try {
            Class<?> c = Class.forName(classFullName); //要包名+类名
            String className = c.getSimpleName();
            String classNameToFirstLower = BaseGenerator.toLowerCaseFirstOne(className);//类首字母小写
            Field[] fields = c.getDeclaredFields();//拿到数据成员
            for (Field f : fields) {
                String type = f.getType().getSimpleName();
                String name = f.getName();
//                if type
                //时间段查询
                if (type.equals("Date")) {
                    System.out.println(type + " " + name + "Start = " + classNameToFirstLower + ".get" + BaseGenerator.toUpperCaseFirstOne(name) + "Start();");
                    System.out.println("if (null!=" + name + "Start){");//时间开始
                    System.out.println("list.add(res.greaterThan(root.get(" + "\"" + name + "\"" + ").as(" + type + ".class),  " + name + "Start));");
                    System.out.println("}");
                    System.out.println(type + " " + name + "End = " + classNameToFirstLower + ".get" + BaseGenerator.toUpperCaseFirstOne(name) + "End();");
                    System.out.println("if (null!=" + name + "End){");//时间结束
                    System.out.println("list.add(res.lessThan(root.get(" + "\"" + name + "\"" + ").as(" + type + ".class),  " + name + "End));");
                    System.out.println("}");
                }
                //字符串模糊查询
                if (type.equals("String")) {
                    System.out.println(type + " " + name + " = " + classNameToFirstLower + ".get" + BaseGenerator.toUpperCaseFirstOne(name) + "();");
                    System.out.println("if (StringUtils.isNoneBlank(" + name + ")){");
                    System.out.println("list.add(res.like(root.get(" + "\"" + name + "\"" + ").as(" + type + ".class), \"%\" + " + name + " + \"%\"));");
                    System.out.println("}");
                }
                //id查询
                if (type.equals("Long")) {
                    System.out.println(type + " " + name + " = " + classNameToFirstLower + ".get" + BaseGenerator.toUpperCaseFirstOne(name) + "();");
                    System.out.println("if (null!=" + name + "){");
                    System.out.println("list.add(res.equal(root.get(" + "\"" + name + "\"" + ").as(" + type + ".class), " + name + " ));");
                    System.out.println("}");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    //首字母转大写
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}
