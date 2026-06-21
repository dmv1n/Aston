import java.util.*;

public class StudentDemo {
    public static void main(String[] args) {
        // Создаём коллекцию студентов
        Set<Student> students = new HashSet<>();

        students.add(new Student("Иванов Иван Иванович", "Группа 1", 1, Arrays.asList(4, 5, 3, 4)));
        students.add(new Student("Петров Петр Петрович", "Группа 1", 1, Arrays.asList(2, 3, 2, 2)));
        students.add(new Student("Сидоров Сергей Александрович", "Группа 2", 2, Arrays.asList(5, 5, 5, 5)));
        students.add(new Student("Козлов Николай Валерьевич", "Группа 2", 2, Arrays.asList(3, 4, 3, 3)));

        System.out.println("Все студенты:");
        printStudents(students, 0); // 0 означает "все курсы"

        // Удаляем студентов со средним < 3
        removePoorStudents(students);

        System.out.println("\nПосле удаления студентов с низким баллом:");
        printStudents(students, 0);

        // Переводим студентов на следующий курс, если средний >= 3
        promoteStudents(students);

        System.out.println("\nПосле перевода на следующий курс:");
        printStudents(students, 0);

        // Печатаем студентов с номером курса
        System.out.println("\nСтуденты на курсе 2:");
        printStudents(students, 2);
        System.out.println("\nСтуденты на курсе 3:");
        printStudents(students, 3);
    }

    // Метод удаляет студентов со средним баллом < 3
    public static void removePoorStudents(Set<Student> students) {
        students.removeIf(student -> student.averageGrade() < 3);
    }

    // Метод переводит студентов на следующий курс, если средний балл >= 3
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.averageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    // Метод печатает имена студентов на заданном курсе (если course = 0 – всех)
    public static void printStudents(Set<Student> students, int course) {
        for (Student s : students) {
            if (course == 0 || s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }
}