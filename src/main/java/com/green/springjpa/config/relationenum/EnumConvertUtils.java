package com.green.springjpa.config.relationenum;

import io.micrometer.common.util.StringUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.EnumSet;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
//객체생성 하지 못하게 하기 위함, 부모로써만 동작하게 하고 싶을 때
public class EnumConvertUtils {
    //enumClass: SchoolTypeCode.class, value: "초등학교" >> SchoolTypeCode.ELEMENTARY 타입이 리턴
    //                                 value: "중학교" >> SchoolTypeCode.MIDDLE 타입이 리턴
    //<E extends Enum<E> & EnumMapperType> 제네릭 제한
    public static <E extends Enum<E> & EnumMapperType> E ofCode(Class<E> enumClass, String code) {
        if(StringUtils.isBlank(code)) {return null;}
        return EnumSet.allOf(enumClass) //Enum이 가지고 있는 모든 아이템들을 가진 콜렉션 리턴 (1)
                      .stream() //(1)을 스트림 생성
                      .filter(item -> item.getCode().equals(code)) //스트림 아이템 중에 원하는 아이템만 다시 스트림 생성한다.(2)
                      .findFirst() //(2)스트림 아이템 중 첫번째 아이템을 리턴(Optional) (3)
                      .orElse(null); //(3)이 null이었다면 null리턴
    }


    // enumItem으로 SchoolTypeCode.ELEMENTARY가 들어오면 "초등학교" 리턴
    //                           .MIDDLE이 들어오면 "중학교" 리턴
    public static <E extends Enum<E> & EnumMapperType> String toCode(E enumItem) {
        if(enumItem == null) {return null;}
        return enumItem.getCode();
    }
}
