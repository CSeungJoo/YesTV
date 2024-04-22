package kr.pah.pcs.yestv.domain.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserDto {
    private String username;
    private String password;
    private String email;
}
