package com.model;

import java.util.Arrays;

public enum Group {
    GROUP1,
    GROUP2,
    GROUP3;

    public static boolean contain(String group){
        return Arrays.stream(Group.values())
                .anyMatch(g -> g
                        .toString()
                        .equals(group)
                );
    }
}
