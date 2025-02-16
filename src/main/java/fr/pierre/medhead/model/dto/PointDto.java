package fr.pierre.medhead.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
public class PointDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4621017557733791323L;

    private float longitude;
    private float latitude;
}
