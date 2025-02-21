package com.green.springjpa.student;

import com.green.springjpa.student.model.StudentRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("student")
@Slf4j
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping//Pageable은 0이 1페이지이다.
    public List<StudentRes> getStudentList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        return studentService.getStudentList(PageRequest.of(page,size));
    }
}
