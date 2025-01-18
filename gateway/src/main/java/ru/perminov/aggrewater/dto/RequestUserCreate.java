package ru.perminov.aggrewater.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestUserCreate {

    private String email;

    private String realPassword;

}
