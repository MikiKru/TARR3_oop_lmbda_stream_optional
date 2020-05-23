package com.company.oop;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Task task = new Task("Nauka programowania",
                LocalDate.now(),
                LocalDate.of(2020,9,30));
        System.out.println(task.toString());
        Task emptyTask = new Task();
        emptyTask.setTaskName("Empty task");
        System.out.println(emptyTask.getTaskName());

        Subtask st = new Subtask();
        st.setTaskName("Nauka OOP w Javie");
        st.setStartDate(LocalDate.now());
        System.out.println(st.getTaskName());
        System.out.println(st);

        Subtask st1 = new Subtask(
                "Nauka MySQL",
                LocalDate.of(2020,6,6),
                LocalDate.of(2020, 8,8),
                "Będę się uczył MySQL 2 h dziennie"
                );
        System.out.println(st1.toString());
        st1.editSubtask("X","X");
        System.out.println(st1);
        st1.editSubtask(
                "Y",
                LocalDate.now(),
                LocalDate.now(),
                "Y");
        System.out.println(st1);
//        System.out.println(LocalDate.of(2020,10,1));
        System.out.println(st1.taskDescription);
        // polimorfizm
        Task t1 = new Subtask();
        System.out.println(t1.getClass().getName());
        System.out.println(t1.getTaskName());
        ((Subtask) t1).editSubtask("Q","Q");
        System.out.println(t1);

        System.out.println(isStopedBefore(
                new Task(
                "X",
                LocalDate.now(),
                LocalDate.of(2020,7,7)),
                new Task(
                        "X",
                        LocalDate.now(),
                        LocalDate.of(2020,9,7))
                ));
        System.out.println(isStopedBefore(
                new Subtask(
                        "X",
                        LocalDate.now(),
                        LocalDate.of(2020,11,7),
                        "X"
                        ),
                new Subtask(
                        "Y",
                        LocalDate.now(),
                        LocalDate.of(2020,9,7),
                        "Y"
                        )
        ));
        System.out.println(isStopedBefore(
                new Task(
                        "X",
                        LocalDate.now(),
                        LocalDate.of(2020,11,7)
                ),
                new Subtask(
                        "Y",
                        LocalDate.now(),
                        LocalDate.of(2020,9,7),
                        "Y"
                )
        ));

    }
    public static boolean isStopedBefore(Task t1, Task t2){
        return t1.getStopDate().isBefore(t2.getStopDate());
    }
}
