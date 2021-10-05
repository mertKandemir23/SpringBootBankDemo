package com.mertkandemir.bank.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CreateCustomerRequest extends BaseCustomerRequest {
    String id;


}
