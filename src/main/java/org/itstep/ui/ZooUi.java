package org.itstep.ui;
import org.itstep.zoo.*;

import java.util.Date;
import java.util.Scanner;

import static org.itstep.ui.Menuitems.*;

public class ZooUi {
   private final Scanner scanner;
   private final Zoo zoo = new Zoo();


    public ZooUi(){
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int menu = 0;
        do {
            menu = menu();
            switch (menu) {
                case ADD:
                    addAnimal();
                    break;
                case SNOW:
                    showAnimal();
                    break;
                case DELETE:
                    deleteAnimal();
                    break;
                case ADD_EXPENSIVE:
                    addExpensive();
                    break;
                case CALC_TODAY:
                    calcExpensesToday();
                    break;
                case CALC_ALL:
                    calcExpensesAll();
                    break;
            }
        }while (menu !=7);
        System.out.println("Работа заверешена");
    }

    private void calcExpensesAll() {
        System.out.println("Расходы за весь период: $" + zoo.getExpensesAll());
    }

    private void calcExpensesToday() {
        Date date = gerDate();
        System.out.println("Расходы за весь день: $" + zoo.getExpensesAll());
    }

    private Date gerDate(){
        System.out.println("Введите день: ");
        int day = getIntInRange(1, 31);
        System.out.println("Введите месяц: ");
        int month = getIntInRange(1, 12);
        System.out.println("Введите год: ");
        int year = getIntInRange(1900, 2050);
        return new Date(day, month, year);
    }

    private void addExpensive() {
        System.out.println("Добавление рассходов на день");
        System.out.println("Введите кличку животного: ");
        String name = scanner.nextLine();
        System.out.println("Введите сумму расходов: ");
        double money = Double.parseDouble(scanner.nextLine());
        System.out.println("Добавление даты");
        Date date = gerDate();
        zoo.addExpenses(name, new Expenses(money, date));
    }

    private void deleteAnimal() {
        System.out.println("Удаление животного по кличке");
        System.out.println("Введите кличку животного: ");
        String name = scanner.nextLine();
        zoo.deleteByName(name);
    }

    private void showAnimal() {
        for (Animal animal: zoo.getAnimals()){
            System.out.println(animal);
        }
    }

    private void addAnimal() {
        System.out.println("Добавление нового животного");

         String name;
         int age;
         int weight;
         int id;
         int time;
         int AnimalType = 0;
        System.out.println("Введите кличку: ");
        name = scanner.nextLine();
        System.out.println("Введите возраст:");
        age = getIntInRange(0, 50);
        System.out.println("Введите вес животного: ");
        weight = getIntInRange(0, 150);
        System.out.println("Введите номер вольера: ");
        id = getIntInRange(1, 50);
        System.out.println("Введите время в годах перебывания в зоопарке: ");
        time = getIntInRange(0, 10);

        Animal animal = null;
        System.out.println("Укажите вид животного");
        System.out.println(SNAKES +". Змеи\n" +
                            CAT +". Кошки\n" +
                            DOGS +". Собаки");
        int choice = getIntInRange(SNAKES, DOGS);
        int animalType = 0;
        switch (choice){
            case SNAKES:
                System.out.println("1. Питон\n" +
                                    "2. Удав\n" +
                                    "3. Гадюка\n");
                choice = getIntInRange(1,3);
                switch (choice){
                    case 1:
                        animalType = AnimalTypes.PYTHON;
                        break;
                    case 2:
                        animalType = AnimalTypes.BOA;
                        break;
                    case 3:
                        animalType = AnimalTypes.VIPER;
                        break;
                }
                animal = new Snake(name,age, weight, id, time, animalType);
                break;
            case CAT:
                System.out.println("1. Лев\n" +
                                "2. Пантера\n");
                choice = getIntInRange(1,2);
                switch (choice) {
                    case 1:
                        animalType = AnimalTypes.LION;
                        break;
                    case 2:
                        animalType = AnimalTypes.PANTHER;
                        break;
                }
                animal = new Cat(name,age, weight, id, time, animalType);
                break;
            case DOGS:
                System.out.println("1. Волк\n" +
                                "2. Собака динго\n");
                choice = getIntInRange(1,2);
                switch (choice){
                    case 1:
                        animalType = AnimalTypes.WOLF;
                        break;
                    case 2:
                        animalType = AnimalTypes.DINGO;
                        break;
                }
                animal = new Dog(name,age, weight, id, time, animalType);
                break;
        }
        zoo.add(animal);
    }


    public int menu(){
        System.out.println(
                ADD +". Добавление нового животного в зоопарк\n" +
                SNOW +". Отображение всех животных\n" +
                DELETE +". Удаление животного по кличке\n" +
                ADD_EXPENSIVE +". Добавление расходов на еду за текущий день для отдельного животного\n" +
                CALC_TODAY +". Подсчет расходов на питание для всех животных за текущий день...\n" +
                CALC_ALL +". Подсчет расходов на питание для всех животных и за весь период учета\n" +
                EXIT + ". Выйти из программы");
        return getIntInRange(ADD, EXIT);
    }


    private int getIntInRange(int from, int to) {
        int menu = 0;
        do {
            System.out.print(">>>");
            String input = scanner.nextLine();
                    try{
                        menu = Integer.parseInt(input);
                    } catch (Throwable ex){
                        System.out.println("Необходимо ввести число от "+ from +" до " + to);
                    }
        } while (menu  < from || menu > to);
        return menu;
    }
}
