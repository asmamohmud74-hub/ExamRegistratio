package Assignment;

import java.util.Scanner;

class InvalidRegistrationException extends Exception {
    public InvalidRegistrationException(String message) {
        super(message);
    }
}

public class ExamRegistration {

    static void registerStudent(
            String studentId,
            String name,
            int age,
            double examMark,
            int subjects
    ) throws InvalidRegistrationException {

        if (studentId.trim().isEmpty()) {
            throw new InvalidRegistrationException("Student ID cannot be empty.");
        }

        if (age < 18) {
            throw new InvalidRegistrationException("Student age must be at least 18.");
        }

        if (examMark < 0 || examMark > 100) {
            throw new InvalidRegistrationException("Exam mark must be between 0 and 100.");
        }

        if (subjects < 1) {
            throw new InvalidRegistrationException("Minimum allowed subjects is 1.");
        }

        if (subjects > 5) {
            throw new InvalidRegistrationException("Maximum allowed subjects is 5.");
        }

        System.out.println("\nRegistration Successful!");
        System.out.println("Student: " + name);
        System.out.println("Registered Subjects: " + subjects);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== EXAM REGISTRATION SYSTEM =====");

        try {
            System.out.print("Enter Student ID: ");
            String studentId = input.nextLine();

            System.out.print("Enter Student Name: ");
            String name = input.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(input.nextLine());

            System.out.print("Enter Exam Mark: ");
            double examMark = Double.parseDouble(input.nextLine());

            System.out.print("Enter Number of Subjects: ");
            int subjects = Integer.parseInt(input.nextLine());

            registerStudent(studentId, name, age, examMark, subjects);

        } catch (InvalidRegistrationException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: Please enter valid numbers for age, mark, and subjects.");

        } finally {
            System.out.println("\nRegistration attempt completed.");
            input.close();
        }
    }
}
