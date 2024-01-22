import java.util.*;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input: Take marks obtained in each subject
        System.out.println("Enter the number of subjects:");
        int numSubjects = scanner.nextInt();
        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        // Calculate Total Marks
        int totalMarks = calculateTotalMarks(marks);
        // Calculate Average Percentage
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
        // Grade Calculation
        char grade = calculateGrade(averagePercentage);
        // Display Results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    private static int calculateTotalMarks(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }
    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }
    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
