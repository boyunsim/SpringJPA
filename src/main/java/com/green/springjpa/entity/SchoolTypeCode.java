package com.green.springjpa.entity;

import com.green.springjpa.config.relationenum.AbstractEnumCodeConverter;
import com.green.springjpa.config.relationenum.EnumMapperType;
import jakarta.persistence.AttributeConverter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SchoolTypeCode implements EnumMapperType {
    //Mybatis였으면 ELEMENTARY라는 String값이 데이터베이스에 들어가지만 JPA에서는 index값인 0으로 들어간다
      ELEMENTARY("00101", "초등학교")
    , MIDDLE("00102", "중학교")
    , HIGH("00103", "고등학교");

//    SchoolTypeCode(String code, String value) {
//        this.code = code;
//        this.value = value;
//    }
//    @RequiredArgsConstructor가 없으면 이렇게 작성해야한다.
    private final String code;
    private final String value;

    public static class CodeConverter extends AbstractEnumCodeConverter<SchoolTypeCode> {
        private static final String ENUM_NAME = "학교타입";

        public CodeConverter() {
            super(SchoolTypeCode.class, false, ENUM_NAME);
        }
    }
}
