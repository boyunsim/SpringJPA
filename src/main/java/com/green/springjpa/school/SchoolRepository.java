package com.green.springjpa.school;


import com.green.springjpa.entity.School;
import com.green.springjpa.school.model.SchoolGetRes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query(" SELECT new com.green.springjpa.school.model.SchoolGetRes(s.schoolId, s.name, s.schoolTypeCode) " +
            "FROM School s ")
    List<SchoolGetRes> findList(Pageable pageable);
}
