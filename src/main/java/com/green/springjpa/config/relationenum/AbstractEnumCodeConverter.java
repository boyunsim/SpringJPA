package com.green.springjpa.config.relationenum;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Converter(autoApply = true)
public abstract class AbstractEnumCodeConverter<E extends Enum<E> & EnumMapperType>
        implements AttributeConverter<E, String> {
    private final Class<E> targetEnumClass;
    private final boolean nullable;
    private final String enumName;

    //DB에 값을 넣을 때 사용 (insert, update)
    @Override
    public String convertToDatabaseColumn(E enumItem) {
        if(!nullable && enumItem == null) {
            throw new IllegalArgumentException(String.format("%s(는)은 NULL로 저장할 수 없습니다.", enumName));
        }
        return EnumConvertUtils.toCode(enumItem);
    }

    //DB에서 값을 가져올 때 (select)
    @Override
    public E convertToEntityAttribute(String dbData) {
        if(!nullable && StringUtils.isBlank(dbData) || dbData == null) {
            throw new IllegalArgumentException(String.format("%s(는)가 DB에 NULL 혹은 Empty로 저장되어 있습니다.", enumName));
        }
        return EnumConvertUtils.ofCode(targetEnumClass, dbData);
    }
}
