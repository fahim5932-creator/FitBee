package models;

import java.time.LocalDate;

public class Workout {
    private String type;
    private int duration; // in minutes
    private int caloriesBurned;
    private LocalDate date;

    public Workout(String type, int duration, int caloriesBurned, LocalDate date) {
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public LocalDate getDate() {
        return date;
    }

    public String toString() {
        return date + " | " + type + " | " + duration + " min | " + caloriesBurned + " cal";
    }
}
