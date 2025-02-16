package fr.pierre.medhead.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "hopital")
public class HopitalEntity {

    @Id
    private int id;

    private String adresse;
    @Column(name = "available_beds")
    private int availableBeds;
    private String city;
    private String email;
    private float latitude;
    private float longitude;
    private String name;
    private String phone;
    private String post_code;
    private String website;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "Hopitaux", cascade = CascadeType.ALL)
    private List<SpecialiteEntity> specialites;
}
