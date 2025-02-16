package fr.pierre.medhead.repository;

import fr.pierre.medhead.model.entity.GroupeSpecialiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeSpecialiteRepository extends JpaRepository<GroupeSpecialiteEntity, Integer> {
}
