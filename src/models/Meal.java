package models;

import java.time.LocalDate;

public class Meal {
    private String name;
    private int calories;
    private LocalDate date;

    public Meal(String name, int calories, LocalDate date) {
        this.name = name;
        this.calories = calories;
        this.date = date;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDate getDate() {
        return date;
    }

    public String toString() {
        return date + " | " + name + " | " + calories + " cal";
    }
}
