import java.util.ArrayList;
import java.util.Scanner;

class Grade {
    private String subject;
    private double score;

    public Grade(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public double getScore() {
        return score;
    }
}

class Student {
    private String name;
    private ArrayList<Grade> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(String subject, double score) {
        grades.add(new Grade(subject, score));
    }

    public double calculateAverage() {
        double total = 0;
        for (Grade grade : grades) {
            total += grade.getScore();
        }
        return total / grades.size();
    }

    public char calculateLetterGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void displayGrades() {
        System.out.println("Grades for " + name + ":");
        for (Grade grade : grades) {
            System.out.println(grade.getSubject() + ": " + grade.getScore());
        }
    }

    public void displayOverallGrade() {
        double average = calculateAverage();
        char letterGrade = calculateLetterGrade(average);
        System.out.println("Average Grade: " + average);
        System.out.println("Letter Grade: " + letterGrade);
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student's name:");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("Menu:");
            System.out.print("1.Add Grade   ");
            System.out.print("2.Display Grades   ");
            System.out.print("3.Display Overall Grade   ");
            System.out.println("4.Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the subject:");
                    String subject = scanner.nextLine();
                    System.out.print("Enter the grade:");
                    double score = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    student.addGrade(subject, score);
                    break;
                case 2:
                    student.displayGrades();
                    break;
                case 3:
                    student.displayOverallGrade();
                    break;
                case 4:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}