package kr.pah.pcs.yestv.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateUserDto {
    @NotBlank(message = "필수 입력 항목입니다.")
    private String username;
    @NotBlank(message = "필수 입력 항목입니다.")
    private String nickname;
    @NotBlank(message = "필수 입력 항목입니다.")
    private String password;
    @NotBlank(message = "필수 입력 항목입니다.")
    private String email;
    @NotBlank(message = "필수 입렭 항목입니다.")
    private Integer location_id;
}
