package fr.pierre.medhead.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
public class MapPathDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -6778567524727505573L;

    private PointDto origin;
    private PointDto target;
}
