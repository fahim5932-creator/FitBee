package models;

import models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrackerService {
    private User user;
    private List<Workout> workouts;
    private List<Meal> meals;
    private Goal goal;

    public TrackerService(User user) {
        this.user = user;
        this.workouts = new ArrayList<>();
        this.meals = new ArrayList<>();
    }

    public void addWorkout(String type, int duration, int caloriesBurned) {
        workouts.add(new Workout(type, duration, caloriesBurned, LocalDate.now()));
    }

    public void addMeal(String name, int calories) {
        meals.add(new Meal(name, calories, LocalDate.now()));
    }

    public void setGoal(String goalType, int targetCalories, double targetWeight) {
        this.goal = new Goal(goalType, targetCalories, targetWeight);
    }

    public double calculateBMI() {
        double height = user.getHeight();
        return user.getWeight() / (height * height);
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public Goal getGoal() {
        return goal;
    }

    public int getTotalWorkoutCalories() {
        return workouts.stream().mapToInt(Workout::getCaloriesBurned).sum();
    }

    public int getTotalMealCalories() {
        return meals.stream().mapToInt(Meal::getCalories).sum();
    }
}
