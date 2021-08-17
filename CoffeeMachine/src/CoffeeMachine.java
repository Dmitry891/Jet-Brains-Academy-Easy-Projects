import java.util.Scanner;

public class CoffeeMachine {
    public static int water = 400;
    public static int milk = 540;
    public static int coffeeBeans = 120;
    public static int disposableCups = 9;
    public static int money = 550;

    public static void main(String[] args) {
        String choiceAction = "";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            choiceAction = scanner.nextLine();
            switch (choiceAction) {
                case ("buy"): {
                    buy();
                    break;
                }
                case ("fill"): {
                    fill();
                    break;
                }
                case ("take"): {
                    take();
                    break;
                }
                case ("remaining"): {
                    remaining();
                    break;
                }
                case ("exit"): {
                    break;
                }
                default: {
                    System.out.println("Error!");
                }
            }
        } while (!choiceAction.equals("exit"));
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        Scanner scanner = new Scanner(System.in);
        String choiceCoffee = scanner.nextLine();
        switch (choiceCoffee) {
            case "1": {
                if (water >= 250 & coffeeBeans >= 16 & disposableCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    coffeeBeans -= 16;
                    disposableCups -= 1;
                    money += 4;
                } else {
                    if (water < 250) {
                        System.out.println("Sorry, not enough water");
                    } else if (coffeeBeans < 16) {
                        System.out.println("Sorry, not enough coffeeBeans");
                    } else if (disposableCups < 1) {
                        System.out.println("Sorry, not enough disposableCups");
                    }
                }
                break;
            }
            case "2": {
                if (water >= 350 & coffeeBeans >= 20 & milk >= 75 & disposableCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    coffeeBeans -= 20;
                    milk -= 75;
                    disposableCups -= 1;
                    money += 7;
                } else {
                    if (water < 350) {
                        System.out.println("Sorry, not enough water");
                    } else if (coffeeBeans < 20) {
                        System.out.println("Sorry, not enough coffeeBeans");
                    } else if (disposableCups < 1) {
                        System.out.println("Sorry, not enough disposableCups");
                    } else if (milk < 75) {
                        System.out.println("Sorry, not enough milk");
                    }
                }
                break;
            }
            case "3": {
                if (water >= 200 & coffeeBeans >= 12 & milk >= 100 & disposableCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    coffeeBeans -= 12;
                    milk -= 100;
                    disposableCups -= 1;
                    money += 6;
                } else {
                    if (water < 200) {
                        System.out.println("Sorry, not enough water");
                    } else if (coffeeBeans < 12) {
                        System.out.println("Sorry, not enough coffeeBeans");
                    } else if (disposableCups < 1) {
                        System.out.println("Sorry, not enough disposableCups");
                    } else if (milk < 100) {
                        System.out.println("Sorry, not enough milk");
                    }
                }
                break;
            }
            case "back": {
                break;
            }
        }
    }

    public static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int addCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int addDisposableCups = scanner.nextInt();
        water = water + addWater;
        milk = milk + addMilk;
        coffeeBeans = coffeeBeans + addCoffeeBeans;
        disposableCups = disposableCups + addDisposableCups;
    }

    public static void take() {
        System.out.println("I gave you" + " $" + money);
        money = 0;
    }

    public static void remaining() {
        System.out.println("The coffee machine has:" + "\n" +
                water + " ml of water" + "\n" +
                milk + " ml of milk" + "\n" +
                coffeeBeans + " g of coffee beans" + "\n" +
                disposableCups + " disposable cups" + "\n" +
                "$" + money + " of money");
    }
}
