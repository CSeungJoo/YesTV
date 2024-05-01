package kr.pah.pcs.yestv.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UpdateUserDto {
    @NotBlank(message = "닉네임은 필수 입력 항목입니다.")
    private String nickname;
    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    private String password;
    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    private String email;
}
