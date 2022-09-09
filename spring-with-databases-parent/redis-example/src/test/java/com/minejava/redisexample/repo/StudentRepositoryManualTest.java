package com.minejava.redisexample.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

//import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import com.minejava.redisexample.model.Student;
import com.minejava.redisexample.repository.StudentRepository;

public class StudentRepositoryManualTest {

    @Autowired
    private StudentRepository studentRepository;

    // container {
    @Container
    public GenericContainer<?> redis = new GenericContainer<>(DockerImageName.parse("redis:5.0.3-alpine"))
            .withExposedPorts(6379);

        // }

    @BeforeEach
    public void setUp() {
        //String address = redis.getHost();
        //Integer port = redis.getFirstMappedPort();

        // Now we have an address and port for Redis, no matter where it is running
        // underTest = new RedisBackedCache(address, port);
        }

        @Test
        public void whenSavingStudent_thenAvailableOnRetrieval() throws Exception {
            final Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
            studentRepository.save(student);
            final Student retrievedStudent = studentRepository.findById(student.getId()).get();
            assertEquals(student.getId(), retrievedStudent.getId());
        }

        @Test
        public void whenUpdatingStudent_thenAvailableOnRetrieval() throws Exception {
            final Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
            studentRepository.save(student);
            student.setName("Richard Watson");
            studentRepository.save(student);
            final Student retrievedStudent = studentRepository.findById(student.getId()).get();
            assertEquals(student.getName(), retrievedStudent.getName());
        }

        @Test
        public void whenSavingStudents_thenAllShouldAvailableOnRetrieval() throws Exception {
            final Student engStudent = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
            final Student medStudent = new Student("Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
            studentRepository.save(engStudent);
            studentRepository.save(medStudent);
            List<Student> students = new ArrayList<>();
            studentRepository.findAll().forEach(students::add);
            assertEquals(students.size(), 2);
        }

        @Test
        public void whenDeletingStudent_thenNotAvailableOnRetrieval() throws Exception {
            final Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
            studentRepository.save(student);
            studentRepository.deleteById(student.getId());
            final Student retrievedStudent = studentRepository.findById(student.getId()).orElse(null);
            assertNull(retrievedStudent);
        }
}
