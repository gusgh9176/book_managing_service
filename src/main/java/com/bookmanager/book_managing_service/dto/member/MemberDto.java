package com.bookmanager.book_managing_service.dto.member;


import com.bookmanager.book_managing_service.domain.member.MemberEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String password;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}