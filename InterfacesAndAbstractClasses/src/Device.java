interface Volume {
    void increaseVol();
    void decreaseVol();
}

class SmartSpeaker implements Switchable, Connectable, Volume {
    private boolean isOn = false;
    private int volume = 50;
    private boolean isConnected = false;

    //Switchable methods
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("SmartSpeaker is turned ON.");
    }
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("SmartSpeaker is turned OFF.");
    }

    //Connectable methods
    @Override
    public void connect() {
        isConnected = true;
        System.out.println("SmartSpeaker is connected to the network.");
    }
    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println("SmartSpeaker is disconnected from the network.");
    }

    //Volume methods
    @Override
    public void increaseVol() {
        if (volume > 100) {
            volume += 10;
            System.out.println("Volume is increased to " + volume + "%");
        } else {
            System.out.println("Volume is already on the maximum level.");
        }
    }
    @Override
    public void decreaseVol() {
        if (volume < 0) {
            volume -= 10;
            System.out.println("Volume is decreased to " + volume + "%");
        } else  {
            System.out.println("Volume is already on the minimum level.");
        }
    }
}

class Fan implements Switchable, Adjustable {
    private boolean isOn = false;
    private int speed = 50;

    //Switchable methods
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Fan is turned ON.");
    }
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Fan is turned OFF.");
    }

    //Adjustable methods
    @Override
    public void increase() {
        if (speed < 100) {
            speed += 10;
            System.out.println("Fan speed increased to " + speed + "% of the maximum.");
        } else {
            System.out.println("Fan speed is already at maximum.");
        }
    }
    @Override
    public void decrease() {
        if (speed > 0) {
            speed -= 10;
            System.out.println("Fan speed decreased to " + speed + "% of the maximum.");
        } else {
            System.out.println("Fan speed is already at minimum.");
        }
    }
}