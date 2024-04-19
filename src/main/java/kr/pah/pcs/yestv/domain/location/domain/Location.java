package kr.pah.pcs.yestv.domain.location.domain;

import jakarta.persistence.*;
import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import kr.pah.pcs.yestv.domain.user.entity.User;
import kr.pah.pcs.yestv.domain.video.domain.Video;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column
    private String name;

    @OneToMany
    @JoinColumn(name = "cam_id")
    private List<Cam> cam;

    @OneToMany
    @JoinColumn(name = "users_id")
    private List<User> user;

    @OneToMany
    @JoinColumn(name = "videos_id")
    private List<Video> videos;
}
