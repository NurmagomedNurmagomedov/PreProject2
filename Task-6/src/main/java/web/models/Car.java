package web.models;

public class Car {
    String model;
    String color;
    String engine;
    String gear;

    public Car(String model, String color, String engine, String gear) {
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.gear = gear;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }
}
