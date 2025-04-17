package models;

public class Goal {
    private String goalType;
    private int targetCalories;
    private double targetWeight;

    public Goal(String goalType, int targetCalories, double targetWeight) {
        this.goalType = goalType;
        this.targetCalories = targetCalories;
        this.targetWeight = targetWeight;
    }

    public String toString() {
        return "Goal: " + goalType + " | Target Calories: " + targetCalories + " | Target Weight: " + targetWeight + " kg";
    }
}
