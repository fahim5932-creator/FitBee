package models;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Java Fitness Tracker!");
        System.out.print("Create username: ");
        String username = sc.nextLine();

        System.out.print("Create password: ");
        String password = sc.nextLine();

        System.out.print("Enter height (in meters): ");
        double height = sc.nextDouble();

        System.out.print("Enter current weight (in kg): ");
        double weight = sc.nextDouble();

        User user = new User(username, password, height, weight);
        TrackerService tracker = new TrackerService(user);

        ReminderService.showReminders();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Workout");
            System.out.println("2. Add Meal");
            System.out.println("3. Set Goal");
            System.out.println("4. View Workouts");
            System.out.println("5. View Meals");
            System.out.println("6. View BMI");
            System.out.println("7. Export Data");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Workout type: ");
                    String type = sc.nextLine();
                    System.out.print("Duration (min): ");
                    int duration = sc.nextInt();
                    System.out.print("Calories burned: ");
                    int calories = sc.nextInt();
                    tracker.addWorkout(type, duration, calories);
                    System.out.println("Workout added.");
                    break;

                case 2:
                    System.out.print("Meal name: ");
                    String meal = sc.nextLine();
                    System.out.print("Calories: ");
                    int mealCalories = sc.nextInt();
                    tracker.addMeal(meal, mealCalories);
                    System.out.println("Meal logged.");
                    break;

                case 3:
                    sc.nextLine(); // consume newline
                    System.out.print("Goal Type (e.g., Weight Loss): ");
                    String goalType = sc.nextLine();
                    System.out.print("Target Calories: ");
                    int targetCalories = sc.nextInt();
                    System.out.print("Target Weight (kg): ");
                    double targetWeight = sc.nextDouble();
                    tracker.setGoal(goalType, targetCalories, targetWeight);
                    System.out.println("Goal set!");
                    break;

                case 4:
                    System.out.println("Workouts:");
                    tracker.getWorkouts().forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Meals:");
                    tracker.getMeals().forEach(System.out::println);
                    break;

                case 6:
                    double bmi = tracker.calculateBMI();
                    System.out.printf("Your BMI: %.2f (%s)%n", bmi, models.BMICalculator.interpretBMI(bmi));
                    break;

                case 7:
                    FileService.exportWorkouts(tracker.getWorkouts());
                    FileService.exportMeals(tracker.getMeals());
                    break;

                case 0:
                    System.out.println("Thank you for using Fitness Tracker. Stay healthy!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
