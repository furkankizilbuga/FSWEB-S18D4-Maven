package com.workintech.s18d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class BurgerErrorResponse {

    private String message;

}
