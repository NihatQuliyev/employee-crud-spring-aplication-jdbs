package com.company.employeecrudaplication.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class EmployeeDtoResponse {
    Long id ;
    String name ;
    String email ;
    Integer salary ;
}
