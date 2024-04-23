package kr.pah.pcs.yestv.domain.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NotNull
@AllArgsConstructor
public class UpdateUserDto {
    private String nickname;
    private String password;
    private String email;
}
