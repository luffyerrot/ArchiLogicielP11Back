package fr.pierre.medhead.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
public class GroupeSpecialiteDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8913625596973031813L;

    private int id;
    private String nom;
}
