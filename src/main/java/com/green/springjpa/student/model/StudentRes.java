package com.green.springjpa.student.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class StudentRes {
    private Long studentId;
    private String name;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //가장 간편하지만 모든 곳에 적어줘야해서 나이스하지 못하다
    private LocalDateTime createdAt;

    public StudentRes(Long studentId, String name, LocalDateTime createdAt) {
        this.studentId = studentId;
        this.name = name;
        this.createdAt = createdAt;
    }
}
