import java.io.*;
import java.util.*;
import java.util.logging.*;


class InvalidStudentException extends Exception {
    public InvalidStudentException(String message) {
        super(message);
    }
}


class Student {
    Integer id;
    String name;
    Integer age;

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return id + "," + name + "," + age;
    }
}

public class problem5 {

    private static final Logger logger = Logger.getLogger(problem5.class.getName());

    public static void main(String[] args) {

        File inputFile = new File("students.txt");
        File validFile = new File("valid.txt");
        File invalidFile = new File("invalid.txt");

        List<Student> studentList = new ArrayList<>();
        Set<Student> studentSet = new HashSet<>();

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter validWriter = new BufferedWriter(new FileWriter(validFile));
            BufferedWriter invalidWriter = new BufferedWriter(new FileWriter(invalidFile))
        ) {
            logger.info("File reading started");
            

            String line;

            while ((line = br.readLine()) != null) {
                try {
                    Student s = processLine(line);
                    studentSet.add(s); 
                } catch (InvalidStudentException e) {
                    invalidWriter.write(line);
                    invalidWriter.newLine();
                    logger.warning("Invalid record skipped: " + line);
                }
            }


            studentList.addAll(studentSet);

            for (Student s : studentList) {
                validWriter.write(s.toString());
                validWriter.newLine();
            }

            logger.info("Processing completed successfully");

        } catch (IOException e) {
            logger.severe("File operation failed: " + e.getMessage());
        } finally {
            logger.info("Program execution finished");
        }
    }

    public static Student processLine(String line) throws InvalidStudentException {

        String[] parts = line.split(",");

        if (parts.length != 3) {
            throw new InvalidStudentException("Incorrect format");
        }

        try {
            Integer id = Integer.parseInt(parts[0].trim());
            String name = cleanName(parts[1]);
            Integer age = Integer.parseInt(parts[2].trim());

            if (age < 18) {
                throw new InvalidStudentException("Age below 18");
            }

            return new Student(id, name, age);

        } catch (NumberFormatException e) {
            throw new InvalidStudentException("Invalid numeric data");
        }
    }

    private static String cleanName(String rawName) {
        StringBuilder sb = new StringBuilder();
        sb.append(rawName.trim().replaceAll("\\s+", " "));
        return sb.toString();
    }
}
