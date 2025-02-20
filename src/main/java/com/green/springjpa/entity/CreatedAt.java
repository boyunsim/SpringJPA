package com.green.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass //Entity 부모역할
@EntityListeners(AuditingEntityListener.class) //이벤트 연결(binding), insert가 될 때 현재 일시값을 넣자.
// 데이터베이스 기능 current_time_stamp 로 일시값을 넣는 것이 아니라 jpa에서 직접 데이터를 만들어서 넣는 방식이다.
//Listener라는 단어가 있으면 event 연결이라고 생각
public class CreatedAt {
    @CreatedDate //insert가 되었을 때 현재일시값을 넣는다. 이 애노테이션이 작동하기 위해서는 @EntityListeners세팅이 되어 있어야 한다.
    @Column(nullable = false) //이 애노테이션은 자동으로 작성이 되는데 설정을 좀 더 해주고 싶다면 이 애노테이션을 붙여야 한다.
    private LocalDateTime createdAt; //이전까지는 String 사용했지만 테이블을 만들어야 하기 때문에 타입을 맞춰야 한다.
}





