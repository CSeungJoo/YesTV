package kr.pah.pcs.yestv.domain.user.dto;

import jakarta.validation.constraints.NotNull;
import kr.pah.pcs.yestv.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NotNull
@AllArgsConstructor
public class ReturnUserDto {
    private int idx;
    private String username;
    private String nickname;
    private String email;
    private Role role;
}
