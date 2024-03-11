package md.akdev.loyality_cms.repository;

import md.akdev.loyality_cms.model.Reward;
import md.akdev.loyality_cms.model.RewardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RewardDetailsRepository extends JpaRepository<RewardDetail, Integer>{
    List<RewardDetail> findByReward(Reward reward);

    Optional<RewardDetail> findByRewardAndId(Reward reward, Integer id);
}
