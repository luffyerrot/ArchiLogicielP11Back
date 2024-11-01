package fr.pierre.medhead.repository;

import fr.pierre.medhead.entity.SpecialiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialiteRepository extends JpaRepository<SpecialiteEntity, Integer> {
}
