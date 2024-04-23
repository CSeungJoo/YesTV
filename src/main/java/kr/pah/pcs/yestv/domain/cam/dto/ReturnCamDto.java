package kr.pah.pcs.yestv.domain.cam.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@NotNull
public class ReturnCamDto {
    private Integer idx;
    private String name;
    private String ip;
    private String detailedLocation;
    private String locationName;

    public ReturnCamDto(Cam cam) {
        this.idx = cam.getIdx();
        this.name = cam.getName();
        this.ip = cam.getIp();
        this.detailedLocation = cam.getDetailedLocation();
        this.locationName = cam.getLocation().getName();
    }
}
