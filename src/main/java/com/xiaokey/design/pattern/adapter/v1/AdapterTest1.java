package com.xiaokey.design.pattern.adapter.v1;

/**
 * @author chenhao
 * @net xiaokey.com
 * @desc 对象适配器模式
 */
public class AdapterTest1 {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();

        Target target = new Adapter(adaptee);
        target.output5v();

    }
}

class Adaptee {
    public int output220v() {
        return 220;
    }
}

interface Target {
    int output5v();
}

class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int i = adaptee.output220v();
        System.out.println(String.format("原始电压： %d v  - >  输出电压： %d  v  ", i, 5));
        return 5;
    }
}



