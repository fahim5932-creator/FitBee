package models;

import models.Meal;
import models.Workout;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileService {

    public static void exportWorkouts(List<Workout> workouts) {
        try (FileWriter writer = new FileWriter("workouts.txt")) {
            for (Workout w : workouts) {
                writer.write(w.toString() + "\n");
            }
            System.out.println("Workouts exported to workouts.txt!");
        } catch (IOException e) {
            System.out.println("Error writing workouts to file.");
        }
    }

    public static void exportMeals(List<Meal> meals) {
        try (FileWriter writer = new FileWriter("meals.txt")) {
            for (Meal m : meals) {
                writer.write(m.toString() + "\n");
            }
            System.out.println("Meals exported to meals.txt!");
        } catch (IOException e) {
            System.out.println("Error writing meals to file.");
        }
    }
}
