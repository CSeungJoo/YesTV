package kr.pah.pcs.yestv.domain.cam.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NotNull
public class UpdateCamDto {
    private int idx;
    private String name;
    private String ip;
}
