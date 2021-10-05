package com.mertkandemir.bank.dto;

import com.mertkandemir.bank.model.City;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAccountRequest extends BaseAccountRequest {
    String id;

}
