public class AnimalFarm {
    public static void main(String[] args) {
        Animal animal1 = new Dog("Sammy");
        Animal animal2 = new Cat("Harold");
        Animal animal3 = new Cow("Margaret");

        System.out.println("animal1 sound " + animal1.sound());
        System.out.println("animal2 sound " + animal2.sound());
        System.out.println("animal3 sound " + animal3.sound());
    }
}
