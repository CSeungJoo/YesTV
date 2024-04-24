package kr.pah.pcs.yestv.domain.videoReq.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NotNull
public class CreateVideoReqDto {
    private String title;
    private String content;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
