package kr.pah.pcs.yestv.domain.user.entity;

import jakarta.persistence.*;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.video.domain.Video;
import kr.pah.pcs.yestv.domain.video.model.Role;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private Role role;

    @OneToMany
    @JoinColumn(name = "video_id")
    private List<Video> Video;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
