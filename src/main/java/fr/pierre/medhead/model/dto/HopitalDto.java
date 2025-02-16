package fr.pierre.medhead.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
public class HopitalDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5355155460681944901L;

    private int id;
    private String adresse;
    private int available_beds;
    private String city;
    private String email;
    private float latitude;
    private float longitude;
    private String name;
    private String phone;
    private String post_code;
    private String website;
}
