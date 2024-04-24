package kr.pah.pcs.yestv.domain.videoReq.dto;

import jakarta.validation.constraints.NotNull;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.videoReq.domain.VideoReq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NotNull
public class ReturnVideoReqDto {
    private int idx;
    private String title;
    private String content;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int locationIdx;
    private String locationName;
    private int userIdx;
    private String nickname;


    public ReturnVideoReqDto(VideoReq videoReq) {
        this.idx = videoReq.getIdx();
        this.title = videoReq.getTitle();
        this.content = videoReq.getContent();
        this.startTime = videoReq.getStartTime();
        this.endTime = videoReq.getEndTime();
        this.locationIdx = videoReq.getLocation().getIdx();
        this.locationName = videoReq.getLocation().getName();
        this.userIdx = videoReq.getUser().getIdx();
        this.nickname = videoReq.getUser().getNickname();
    }
}
