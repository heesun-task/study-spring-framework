package com.hs.learnspringframework.examples.c1;

import org.springframework.stereotype.Component;

@Component
public class MySQLDatabaseService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[] {5, 1, 4, 25, 2};
    }
}
