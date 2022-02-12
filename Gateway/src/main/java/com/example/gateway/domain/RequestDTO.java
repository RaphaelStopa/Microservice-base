package com.example.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// Só para ao JWT
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RequestDTO {

    private String uri;

    private String method;
}
