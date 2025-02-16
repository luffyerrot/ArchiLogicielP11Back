package fr.pierre.medhead.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Builder
public class SpecialiteDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 693955498665366871L;

    private int id;
    private String nom;
    private String groupe;
}
