package org.itstep.zoo;

import org.itstep.time.Date;

import java.util.Arrays;

public abstract class Animal {
    private String name;
    private  int age;
    private int weight;
    private int id;
    private int time;
    private int AnimalType;
    private Expenses[] expenses = new Expenses[0]; //расходы на содержание

    public Animal(String name, int age, int weight, int id, int time, int AnimalType) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.id = id;
        this.time = time;
        this.AnimalType = AnimalType;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Animal(String name, int age, int weight, int id, int time, int animalType, Expenses[] expenses) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.id = id;
        this.time = time;
        this.AnimalType = animalType;
        this.expenses = expenses;
    }

    public void addExpanses(Expenses expenses) {
        this.expenses = Arrays.copyOf(this.expenses, this.expenses.length + 1);
        this.expenses[this.expenses.length - 1] = expenses;
    }
    public double getExpensesForDay(Date date) {
        double sum = 0;
        for (Expenses e: expenses){
            if (date.equals(e.getDate())){
                sum += e.getMoney();
            }
        }
        return sum;
    }
    public double getExpenses() {
        double sum = 0;
        for (Expenses e: expenses){
                sum += e.getMoney();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Списко животных: \n" +
                "Имя: " + name + '\'' +
                ", Возраст: " + age +
                ", Вес: " + weight +
                ", Номер вольера: " + id +
                ", Сколько лет в зоопарке: " + time +
                ", Тип животного: " + AnimalType;
    }
}
