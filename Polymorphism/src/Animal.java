public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String sound() {
        return null;
    }

    public String food() {
        return null;
    }

    public String toString() {
        return name.concat(" says ").concat(sound()).concat(" and eats ").concat(food());
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public String sound() {
        return "Woof";
    }

    public String food() {
        return "steak";
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public String sound() {
        return "Meow";
    }

    public String food() {
        return "mice";
    }
}

class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    public String sound() {
        return "Moo";
    }

    public String food() {
        return "grass";
    }
}