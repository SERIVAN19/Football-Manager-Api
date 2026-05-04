package com.sergio.football.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAssociationDTO {

    @NotBlank(message = "El nombre de la asociacion es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String name;

    @NotBlank(message = "El país es obligatorio")
    private String country;

    @NotBlank(message = "El CEO es obligatorio")
    private String ceo;
}
