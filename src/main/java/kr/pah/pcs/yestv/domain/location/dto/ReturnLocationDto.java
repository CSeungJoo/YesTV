package kr.pah.pcs.yestv.domain.location.dto;

import jakarta.validation.constraints.NotNull;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NotNull
@AllArgsConstructor
public class ReturnLocationDto {
    private int idx;
    private String name;

    public ReturnLocationDto(Location location) {
        this.idx = location.getIdx();
        this.name = location.getName();
    }
}
