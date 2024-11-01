package fr.pierre.medhead.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "specialite")
public class SpecialiteEntity {

    @Id
    private int id;

    private String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupe_id", nullable = false)
    private GroupeSpecialiteEntity groupeEntity;
}
