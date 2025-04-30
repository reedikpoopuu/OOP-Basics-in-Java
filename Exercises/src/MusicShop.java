abstract class Instrument {
    private String name;
    protected int year;

    public Instrument(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String play() {
        return null;
    }

    public String getName() {
        return this.name;
    }

    public String getInstrumentDetails() {
        return "Name: " + this.name + "\nYear of manufacture: " + this.year;
    }
}

interface Tunable {
    String tune();
    String adjustPitch(boolean up);
}

interface Maintainable {
    String clean();
    String inspect();
}

class StringedInstrument extends Instrument {
    private int numberOfStrings;

    public StringedInstrument(String name, int year, int numberOfStrings) {
        super(name, year);
        this.numberOfStrings = numberOfStrings;
    }

    public String play() {
        return "Sound of Music";
    }

    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + "\nStrings: " + numberOfStrings;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }
}

class Guitar extends StringedInstrument implements Tunable, Maintainable {
    private String guitarType;

    public Guitar(String name, int year, int numberOfStrings, String guitarType) {
        super(name, year, numberOfStrings);
        this.guitarType = guitarType;
    }

    @Override
    public String play() {
        return "Playing the " + guitarType + " guitar with " + getNumberOfStrings() + " strings";
    }
    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Type: " + guitarType;
    }

    @Override
    public String tune() {
        return "Tuning the " + guitarType + " guitar";
    }
    @Override
    public String adjustPitch(boolean up) {
        return up ? "Increasing pitch of the guitar" : "Decreasing pitch of the guitar";
    }
    @Override
    public String clean() {
        return "Cleaning the " + guitarType + " guitar";
    }
    @Override
    public String inspect(){
        return "Inspecting the " + guitarType + " guitar from " + year;
    }
}

class Piano extends Instrument implements Tunable, Maintainable {
    private boolean isGrand;

    public Piano(String name, int year, boolean isGrand) {
        super(name, year);
        this.isGrand = isGrand;
    }

    @Override
    public String play() {
        return "Playing the " + (isGrand? "grand" : "upright") + " piano.";
    }

    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + "\nType: " + (isGrand? "Grand" : "Upright");
    }

    @Override
    public String tune() {
        return "Tuning the piano.";
    }

    @Override
    public String adjustPitch(boolean up) {
        return up? "Increasing the pitch of the piano.": "Decreasing the pitch of the piano.";
    }

    @Override
    public String inspect() {
        return "Inspecting the " + (isGrand? "grand":"upright") + " piano from " + year + ".";
    }

    @Override
    public String clean() {
        return "Cleaning the piano keys and interior.";
    }
}

public class MusicShop {
    public static void main(String[] args) {
        Instrument instruments[] = new Instrument[3];

        instruments[0] = new Guitar("Fender Stratocaster", 2020, 6, "electric");
        instruments[1] = new Piano("Steinway", 2015, true);
        instruments[2] = new Guitar("Martin", 2018, 12, "acoustic");


        // Demonstrate polymorphism by calling play() for each instrument
        System.out.println("===== PLAYING INSTRUMENTS =====");
        for (Instrument instrument : instruments) {
            System.out.println(instrument.play());
            System.out.println(instrument.getInstrumentDetails());
        }

        // Demonstrate interface type checking and method calling
        System.out.println("\n===== MAINTAINING INSTRUMENTS =====");
        for (Instrument instrument : instruments) {
            System.out.println("Working with: " + instrument.getName());

            // Check if this instrument is Tunable
            if (instrument instanceof Tunable) {
                Tunable tunableInstrument = (Tunable) instrument;
                System.out.println(tunableInstrument.tune());
                System.out.println(tunableInstrument.adjustPitch(true));
            }

            // Check if this instrument is Maintainable
            if (instrument instanceof Maintainable) {
                Maintainable maintainableInstrument = (Maintainable) instrument;
                System.out.println(maintainableInstrument.clean());
                System.out.println(maintainableInstrument.inspect());
            }

            System.out.println("-----");
        }
    }
}