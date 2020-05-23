package com.company.oop;


import lombok.*;

import java.time.LocalDate;


@Data                   // implementuje gettery settery i toString()
@NoArgsConstructor      // implementuje domyślny kontruktor
//@AllArgsConstructor     // implementuje konstruktor z wszystkimi polami w argumentach
public class Task {
    private String taskName;
    private LocalDate startDate;
    private LocalDate stopDate;

    public Task(String taskName, LocalDate startDate, LocalDate stopDate) {
        System.out.println("Jestem w Task");
        this.taskName = taskName;
        this.startDate = startDate;
        this.stopDate = stopDate;
    }
    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", startDate=" + startDate +
                ", stopDate=" + stopDate +
                '}';
    }
}
