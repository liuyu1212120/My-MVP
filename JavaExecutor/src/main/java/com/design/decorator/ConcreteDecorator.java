package com.design.decorator;

/**
 * @author: Rookie
 * @since: 2018-11-16
 * @desc 具体装饰类
 */
public class ConcreteDecorator extends AbstractDecorator {

    public ConcreteDecorator(AbstractComponent abstractComponent) {
        super(abstractComponent);
    }

    @Override
    public void doSomeThing() {
        // 对原来的方法进行装饰
         beforeDoSomeThing();
         super.doSomeThing();
         afterDoSomeThing();
    }

    private void afterDoSomeThing() {
        System.out.println("-----Finish to Print------");
    }

    private void beforeDoSomeThing() {
        System.out.println("-----Ready to Print------");
    }
}
