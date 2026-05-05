package com.sergio.football.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompetitionCreateDTO {

    @NotBlank(message = "Competition name is required")
    private String name;

    @NotNull(message = "Prize amount is required")
    @Positive(message = "Prize amount must be greater than 0")
    private Integer prizeAmount;
}
