package kr.pah.pcs.yestv.domain.videoReq.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateVideoReqDto {
    private String title;
    private String content;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
