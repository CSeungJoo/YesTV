package kr.pah.pcs.yestv.domain.videoReq.domain;

import jakarta.persistence.*;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.user.domain.User;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class VideoReq {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

}
