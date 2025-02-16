package fr.pierre.medhead.repository;

import fr.pierre.medhead.model.entity.SpecialiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialiteRepository extends JpaRepository<SpecialiteEntity, Integer> {

    Optional<List<SpecialiteEntity>> findByGroupeEntityId(Integer groupeId);
}
