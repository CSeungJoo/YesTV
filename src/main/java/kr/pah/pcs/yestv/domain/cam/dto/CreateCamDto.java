package kr.pah.pcs.yestv.domain.cam.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NotNull
@AllArgsConstructor
public class CreateCamDto {
    private String name;
    private String ip;
    private String detailedLocation;
    private int locationId;
}
