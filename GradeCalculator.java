import java.util.Scanner;

class Student {
    String name;
    double[] scores;

    public Student(String name, int numSubjects) {
        this.name = name;
        scores = new double[numSubjects];
    }

    public void inputScores(Scanner scanner) {
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Enter score for subject " + (i + 1) + ": ");
            scores[i] = scanner.nextDouble();
        }
    }

    public double calculateAverage() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    public String getGrade() {
        double average = calculateAverage();
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        scanner.nextLine(); // Consume the newline character
        
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
        scanner.nextLine(); // Consume the newline character

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            
            students[i] = new Student(name, numSubjects);
            students[i].inputScores(scanner);
        }

        System.out.println("\nStudent Grades:");

        for (int i = 0; i < numStudents; i++) {
            System.out.println(students[i].name + ": Average = " + students[i].calculateAverage() + ", Grade = " + students[i].getGrade());
        }

        scanner.close();
    }
}
