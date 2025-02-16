package fr.pierre.medhead.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "specialite_hopital", joinColumns = @JoinColumn(name = "specialite_id"), inverseJoinColumns = @JoinColumn(name = "hopital_id"))
    private List<HopitalEntity> Hopitaux;
}
