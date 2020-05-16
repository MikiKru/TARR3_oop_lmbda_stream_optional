package com.company.data;

import com.company.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface UserData {
    // publiczne statyczne finalne
    List<User> users = new ArrayList<>(Arrays.asList(
            new User("Michał", "K", "mk@mk.pl", "mk"),
            new User("Jan", "T", "jt@jt.pl", "jt"),
            new User("Anna", "K", "ak@ak.pl", "alk"),
            new User("Tomasz", "P", "tp@tp.pl", "tp"),
            new User("Adam", "V", "av@av.pl", "av"),
            new User("Agata", "O", "ao@ao.pl", "ao")
        )
    );
}
