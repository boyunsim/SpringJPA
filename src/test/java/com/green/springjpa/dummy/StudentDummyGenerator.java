package com.green.springjpa.dummy;

import com.green.springjpa.entity.School;
import com.green.springjpa.entity.Student;
import com.green.springjpa.school.SchoolRepository;
import com.green.springjpa.student.StudentRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Locale;

//JPA Test
@DataJpaTest
//DB 바꾸지 않겠다
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentDummyGenerator {
    @Autowired private StudentRepository studentRepository;
    @Autowired private SchoolRepository schoolRepository;

    Faker faker = new Faker(new Locale("ko"));

    @Test
    @Rollback(false)
    void generate() {
        //기존 데이터 삭제
        studentRepository.deleteAll();

        List<School> schoolList = schoolRepository.findAll();

        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder(faker.name().lastName());
            sb.append(faker.name().firstName());

            Student student = Student.builder()
                    .name(sb.toString())
//                    .school(schoolList.get((int)(Math.random()*schoolList.size())))
                    .school(schoolList.get(faker.random().nextInt(schoolList.size())))
                    //위의 코드로 랜덤값 넣어도 되지만 faker에서 제공하는 메소드를 통해 넣어도 된다.
                    .build();
            studentRepository.save(student);
        }
        studentRepository.flush();
    }
}


