package kr.pah.pcs.yestv.domain.video.dto;

import jakarta.validation.constraints.NotNull;
import kr.pah.pcs.yestv.domain.video.domain.Video;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@NotNull
@AllArgsConstructor
public class ReturnVideoDto {
    private int idx;
    private String detailedLocation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String locationName;

    public ReturnVideoDto(Video video) {
        this.idx = video.getIdx();
        this.detailedLocation = video.getCam().getDetailedLocation();
        this.startTime = video.getStartTime();
        this.endTime = video.getEndTime();
        this.locationName = video.getLocation().getName();
    }
}
