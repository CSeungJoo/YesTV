package kr.pah.pcs.yestv.domain.location.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NotNull
@AllArgsConstructor
public class UpdateLocationDto {
    private int idx;
    private String name;
}
