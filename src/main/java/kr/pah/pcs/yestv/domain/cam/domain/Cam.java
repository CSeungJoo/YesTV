package kr.pah.pcs.yestv.domain.cam.domain;

import jakarta.persistence.*;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Cam {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column
    private String name;

    @Column
    private String ip;

    @Column
    private String detailedLocation;

    @Column
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public void modifiedCam(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public void changeDeleteStatus() {
        isDelete = !isDelete;
    }

    @PrePersist
    private void init() {
        isDelete = false;
    }
}
