package fr.pierre.medhead.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Builder
public class SpecialiteDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -6081714706246172054L;

    private int id;
    private String nom;
    private String groupe;
}
