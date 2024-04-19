package kr.pah.pcs.yestv.domain.video.domain;

import jakarta.persistence.*;
import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @OneToOne
    @JoinColumn(name = "cam_id")
    private Cam cam;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;


    @Column
    private String url;

    @Transient
    private MultipartFile video;
}