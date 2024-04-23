package kr.pah.pcs.yestv.domain.cam.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NotNull
public class CreateCamDto {
    private String name;
    private String ip;
    private String detailedLocation;
    private int locationId;
}
