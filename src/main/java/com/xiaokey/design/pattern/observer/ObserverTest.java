package com.xiaokey.design.pattern.observer;


import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhao
 * @net xiaokey.com
 */
public class ObserverTest {
    public static void main(String[] args) {

        Subject subject = new Subject();
        Task1 task1 = new Task1();
        subject.addObserver(task1);
        Task2 task2 = new Task2();
        subject.addObserver(task2);

        subject.notifyObserver("xxxxx ");
        System.out.println("------------------");
        subject.remove(task1);
        subject.remove(task2);
        subject.notifyObserver("yyyyyy ");


    }
}

class Subject {
    // 容器
    private List<Observer> container = new ArrayList<>();

    // add
    public void addObserver(Observer observer) {
        container.add(observer);
    }

    // remove
    public void remove(Observer observer) {
        container.remove(observer);
    }

    public void notifyObserver(Object object) {
        for (Observer item : container) {
            item.update(object);
        }

    }
}


interface Observer {
    void update(Object object);
}

class Task1 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println(" task1 received: " + object);
    }
}

class Task2 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println(" task2 received:" + object);
    }
}



