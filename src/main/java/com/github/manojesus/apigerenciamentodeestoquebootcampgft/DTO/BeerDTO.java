package com.github.manojesus.apigerenciamentodeestoquebootcampgft.DTO;

import com.github.manojesus.apigerenciamentodeestoquebootcampgft.enums.BeerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BeerDTO {
    private Long id;
    @NotNull
    @Size(min = 1, max = 150)
    private String name;
    @NotNull
    @Size(min = 1, max = 150)
    private String brand;
    @NotNull
    @Max(500)
    @Min(0)
    private Integer max;
    @NotNull
    @Max(100)
    @Min(0)
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    @NotNull
    private BeerType beerType;


}
