package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();
    private long index = 0;

    public Student addStudent(Student student) {
        student.setId(++index);
        students.put(index, student);
        return student;
    }

    public Student findStudent(Long id) {
        if (students.containsKey(id)) {
            return students.get(id);
        }
        return null;
    }

    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(Long id) {
        if (students.containsKey(id)) {
            return students.remove(id);
        }
        return null;
    }

    public List<Student> filterByAge(int age) {
        return students.values()
                .stream()
                .filter(s -> s.getAge() == age)
                .toList();
    }
}
