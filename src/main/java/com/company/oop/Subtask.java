package com.company.oop;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
public class Subtask extends Task {
    public String taskDescription;

    public Subtask(String taskName, LocalDate startDate, LocalDate stopDate, String taskDescription) {
        super(taskName, startDate, stopDate);   // wywołanie konstruktora klasy Task
        this.taskDescription = taskDescription;
        System.out.println("Jestem w subtask");
    }
    // ------------- PRZECIĄŻANIE ---------------------------
    public void editSubtask(String taskName, LocalDate startDate, LocalDate stopDate, String taskDescription){
        setTaskName(taskName);
        setStartDate(startDate);
        setStopDate(stopDate);
        this.taskDescription = taskDescription;
    }
    public void editSubtask(String taskName, String taskDescription){
        setTaskName(taskName);
        this.taskDescription = taskDescription;
    }
    // -------------------------------------------------------

    @Override
    public String toString() {
        return "Subtask{" +
                "taskDescription='" + taskDescription + '\'' +
                "} " + super.toString();
    }
}
