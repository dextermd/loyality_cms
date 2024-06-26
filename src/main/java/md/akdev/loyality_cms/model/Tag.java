package md.akdev.loyality_cms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import md.akdev.loyality_cms.model.promotion.Promotion;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Column(name = "name_ru")
    private String nameRu;


    @ManyToMany
    @JoinTable(
            name = "promotions_tags",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "promotion_id"))
    private List<Promotion> promotion;

    @Column(name = "created_at")
    private Instant createdAt;


    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", name_ru='" + nameRu + '\'' +
                '}';
    }
}