package kr.pah.pcs.yestv.domain.videoReq.domain;

import jakarta.persistence.*;
import kr.pah.pcs.yestv.domain.user.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class VideoReq {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private LocalDateTime startTime;

    @Column LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

}
