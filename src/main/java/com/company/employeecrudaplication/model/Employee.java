package com.company.employeecrudaplication.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    Long id ;
    String name ;
    String email ;
    Integer salary ;
}
