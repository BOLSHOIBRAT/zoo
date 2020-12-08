package org.itstep.zoo;

import org.itstep.time.Date;

import java.util.Arrays;

public class Zoo {
    private Animal[] animals = new Animal[0];

    public void add(Animal animal){
        animals = Arrays.copyOf(animals, animals.length +1);
        animals[animals.length - 1] = animal;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void  deleteByName (String name) {
        if (name == null) return;
        int deleteindex = -1;
        for (int i = 0; i < animals.length; i++) {
            if (name.equals(animals[i].getName())){
                deleteindex = 1;
                break;
            }
        }
        if (deleteindex >= 0) {
            for (int i = deleteindex + 1; i < animals.length; i++) {
                animals[i-1] = animals[i];
            }
        }
    }

    public  void  addExpenses(String name, Expenses expense){
        if (name == null) return;
        for (Animal animal: animals) {
            if(name.equals(animal.getName())){
                animal.addExpanses(expense);
            }
        }
    }

    public  void  addExpenses(int id, Expenses expense){
        for (Animal animal: animals) {
            if(id == animal.getId()){
                animal.addExpanses(expense);
            }
        }
    }

    public double getExpensesForDay(Date date){
        double sum = 0;
        for (Animal animal: animals) {
            sum += animal.getExpensesForDay(date);
        }
        return sum;
    }

    public double getExpensesAll(){
        double sum = 0;
        for (Animal animal: animals) {
            sum += animal.getExpenses();
        }
        return sum;
    }
}
