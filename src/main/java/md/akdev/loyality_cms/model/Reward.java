package md.akdev.loyality_cms.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "rewards")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "reward_type")
    @NotNull
    private RewardsType rewardType;

    @NotNull
    @Column(name = "date_from", nullable = false)
    private LocalDate dateFrom;

    @NotNull
    @Column(name = "date_to", nullable = false)
    private LocalDate dateTo;

    @Column(name = "image", nullable = false, length = Integer.MAX_VALUE)
    @NotNull
    private String image;

    @Column(name = "image_name", nullable = false, length = 100)
    @NotNull
    private String imageName = "image.jpg";

    @Column(name = "image_type", nullable = false, length = 255)
    @NotNull
    private String imageType = "image/jpeg";

    @OneToMany(mappedBy = "reward", cascade = {CascadeType.ALL},  fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private List<RewardDetail> rewardDetails;
}
