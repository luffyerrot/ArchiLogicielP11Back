package fr.pierre.medhead.repository;

import fr.pierre.medhead.model.entity.HopitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HopitalRepository extends JpaRepository<HopitalEntity, Integer> {

    Optional<List<HopitalEntity>> findBySpecialitesIdOrderByAvailableBedsDesc(Integer specialiteId);
}
