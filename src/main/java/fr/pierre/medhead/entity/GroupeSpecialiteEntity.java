package fr.pierre.medhead.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groupe")
public class GroupeSpecialiteEntity {

    @Id
    private int id;

    private String nom;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupeEntity", cascade = CascadeType.ALL)
    private List<SpecialiteEntity> specialites;
}
