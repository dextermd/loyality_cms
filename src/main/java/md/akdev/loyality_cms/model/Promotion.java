package md.akdev.loyality_cms.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "promotions")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column (name = "description")
    private String description;
    @Column (name = "start_date")
    private LocalDateTime startDate;
    @Column (name = "end_date")
    private LocalDateTime endDate;
    @Column (name = "status")
    private String status;
    @Column (name = "up_to_discount")
    private Double upToDiscount;
    @Column (name = "up_to_bonus")
    private Double upToBonus;
    @Column (name = "image_name")
    private String imageName;
    @Column (name = "image_type")
    private String imageType;
    @Column (name = "image")
    private String image;
    @Column (name = "created_at")
    private LocalDateTime created_at;

    @OneToMany(mappedBy = "promotion", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private List<PromotionDetails> promotionDetails;

}
