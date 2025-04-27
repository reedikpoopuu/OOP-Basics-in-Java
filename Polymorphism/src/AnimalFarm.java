import java.util.Scanner;

public class AnimalFarm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal[] animals = new Animal[10];
        int anmIdx = 0;

        while(true) {
            System.out.println("Press 1 to view the animals, " +
                    "\n2 to add animals, " +
                    "\nand any other key to exit: ");
            String userAction = scanner.nextLine();
            if (userAction.equals("1")) {
                for (int i = 0; i < animals.length; i++) {
                    if (animals[i] != null) {
                        System.out.println(animals[i]);
                    }
                }
            } else if (userAction.equals("2")) {
                if (anmIdx == 10) {
                    System.out.println("10 animals already. Cannot add any more animals!");
                    continue;
                }

                System.out.println("Which animal do you want to create?" +
                        "\nPress 1 for dog," +
                        "\n 2 for cat," +
                        "\n3 for cow: ");
                String animalChoice = scanner.nextLine();
                if (animalChoice.equals("1")) {
                    System.out.println("Enter the name of the dog: ");
                    String dogName = scanner.nextLine();
                    Animal anmlTmp = new Dog(dogName);
                    animals[anmIdx++] = anmlTmp;
                } else if (animalChoice.equals("2")) {
                    System.out.println("Enter the name of the cat: ");
                    String catName = scanner.nextLine();
                    Animal anmlTmp = new Cat(catName);
                    animals[anmIdx++] = anmlTmp;
                } else if (animalChoice.equals("3")) {
                    System.out.println("Enter the name of the cow: ");
                    String cowName = scanner.nextLine();
                    Animal anmlTmp = new Cow(cowName);
                    animals[anmIdx++] = anmlTmp;
                }
            } else {
                break;
            }
        }
    }
}
