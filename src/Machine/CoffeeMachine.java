package Machine;

import java.util.Scanner;

public class CoffeeMachine {

    public enum State {
        MAIN_MENU,
        BUY_MENU,
        ADD_WATER,
        ADD_MILK,
        ADD_BEANS,
        ADD_CUPS;
    }

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private State state;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
        this.state = State.MAIN_MENU;
        System.out.print("Write action (buy, fill, take, remaining, exit):\n> ");
    }

    private void getRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private void makeCoffee(String order) {
        switch (order) {
            case "1":
                if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans < 16) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    water -= 250;
                    beans -= 16;
                    money += 4;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "2":
                if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans < 20) {
                    System.out.println("Sorry, not enough beans!");
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "3":
                if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans < 12) {
                    System.out.println("Sorry, not enough beans!");
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    money += 6;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                }
        }
    }
    public void Action (String command) {
        switch (state) {
            case MAIN_MENU:
                switch (command) {
                    case "exit":
                        System.exit(0);
                        break;
                    case "remaining":
                        getRemaining();
                        System.out.print("\nWrite action (buy, fill, take, remaining, exit):\n> ");
                        break;
                    case "fill":
                        this.state = State.ADD_WATER;
                        System.out.print("Write how many ml of water do you want to add:\n> ");
                        break;
                    case "buy":
                        this.state = State.BUY_MENU;
                        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n> ");
                        break;
                    case "take":
                        System.out.println("I gave you $" + money);
                        this.money = 0;
                        System.out.print("\nWrite action (buy, fill, take, remaining, exit):\n> ");
                        break;
                    default:
                        System.out.println("Wrong command");
                }
                break;
            case ADD_WATER:
                this.water += Integer.parseInt(command);
                this.state = State.ADD_MILK;
                System.out.print("Write how many ml of milk do you want to add:\n> ");
                break;
            case ADD_MILK:
                this.milk += Integer.parseInt(command);
                this.state = State.ADD_BEANS;
                System.out.print("Write how many grams of coffee beans do you want to add:\n> ");
                break;
            case ADD_BEANS:
                this.beans += Integer.parseInt(command);
                this.state = State.ADD_CUPS;
                System.out.print("Write how many disposable cups of coffee do you want to add:\n> ");
                break;
            case ADD_CUPS:
                this.cups += Integer.parseInt(command);
                this.state = State.MAIN_MENU;
                System.out.print("\nWrite action (buy, fill, take, remaining, exit):\n> ");
                break;
            case BUY_MENU:
                if (command != "back") {
                  makeCoffee(command);
                }
                this.state = State.MAIN_MENU;
                System.out.print("\nWrite action (buy, fill, take, remaining, exit):\n> ");
        }
    }
    public static void main(String[] args) {
        CoffeeMachine myMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);
        boolean goOn = true;
        do {
            String command = scanner.next();
            if (command != "exit") {
                myMachine.Action(command);
            } else {
                goOn = false;
            }
        } while (goOn);
    }
}


