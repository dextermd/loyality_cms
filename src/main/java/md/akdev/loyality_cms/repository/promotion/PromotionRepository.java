package md.akdev.loyality_cms.repository.promotion;

import md.akdev.loyality_cms.dto.promotion.PromotionImp;
import md.akdev.loyality_cms.model.promotion.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    @Query(value = "select id, p.priority, p.name as name, p.name_ru as nameRu, p.description as description, p.description_ru as descriptionRu, p.start_date as startDate, p.end_date as endDate" +
            " ,p.up_to_discount as upToDiscount, p.up_to_bonus as upToBonus,  p.image_name as imageName, p.image_type as imageType, p.status as status " +
            "from promotions p where ?1 between p.start_date and p.end_date", nativeQuery = true)
    List<PromotionImp> findAllActive(LocalDate now);


}
