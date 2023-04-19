package com.company.employeecrudaplication.dto.requset;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class EmployeeDtoRequest {
    String name ;
    String email ;
    Integer salary ;
}
