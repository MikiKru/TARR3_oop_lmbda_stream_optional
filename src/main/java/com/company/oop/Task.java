package com.company.oop;


import lombok.*;

import java.time.LocalDate;


@Data                   // implementuje gettery settery i toString()
@NoArgsConstructor      // implementuje domyślny kontruktor
@AllArgsConstructor     // implementuje konstruktor z wszystkimi polami w argumentach
public class Task {
    private String taskName;
    private LocalDate startDate;
    private LocalDate stopDate;
}
