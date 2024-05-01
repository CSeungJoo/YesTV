package kr.pah.pcs.yestv.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ReturnUserDto {
    @NotBlank(message = "필수 입력 항목입니다.")
    private Integer idx;
    @NotBlank(message = "필수 입력 항목입니다.")
    private String username;
    @NotBlank(message = "필수 입력 항목입니다.")
    private String nickname;
    @NotBlank(message = "필수 입력 항목입니다.")
    private String email;
    @NotBlank(message = "필수 입력 항목입니다.")
    private Role role;
    @NotBlank(message = "필수 입력 항목입니다.")
    private Location location;
}
