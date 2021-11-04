package com.luxoft.reflection;

public class Alien {
    private double averageSpeed = 77.3;
    private long veryLong =  1235465432;
    private char sign =  'M';
    private String name = "XENO";
    private int age = 2;
    private int weight = 100;
    public int id = 1515;
    public String status = "STATUS: ALIVE";
    String babayka = "babayka";
    private boolean isHungry = true;
    boolean isCreated = true;

    public Alien() {
        System.out.println("=====XENOMORPH CREATED======");
    }
    public Alien(String name, int age) {
        System.out.println("=====XENOMORPH CREATED from CONSTRUCTOR ======");
    }

    private void eat(String name) {
        System.out.println(name + "===IS EATING===");
    }

    final void sleep() {
        System.out.println("===SLEEPING, Zzz===");
    }

    public void hunt() {
        System.out.println("===HUNTING===");
    }

    public void run() {
        System.out.println("===RUNNING===");
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHungry() {
        return isHungry;
    }

}

