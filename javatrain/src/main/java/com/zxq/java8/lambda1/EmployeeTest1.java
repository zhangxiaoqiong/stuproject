package com.zxq.java8.lambda1;

/**
 * @author zhangxiaoqiong
 * @desc xxx
 * @date 2021/6/10 14:08
 */
public class EmployeeTest1 {

    public static void main(String[] args) {
        // 创建对象调用方法
//        EmployeeTim employeeTim = new EmployeeTim();
//        employeeTim.getSalay();

        // 匿名内部类调用
//        Employee employee = new Employee() {
//            public int getSalay() {
//                System.out.println("...12");
//                return 0;
//            }
//        };
//        employee.getSalay();

        // lambda表达式  (Employee必须为一个函数式接口，即有且仅有一个抽象方法)
        Employee employee = () -> {
            System.out.println("...12");
            return 0;
        };

        employee.getSalay();
    }
}
