package com.projectapi.personapi.dto.request;



import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    
    private Long id;

    @NotEmpty
    @Size(min = 5, max = 60)
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 60)
    private String lastName;

    @NotNull
    private String birthDate;

    @NotEmpty
    @CPF
    private String cpf;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;
}
