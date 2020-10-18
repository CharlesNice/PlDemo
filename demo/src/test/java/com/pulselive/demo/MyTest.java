package com.pulselive.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.List;

public class MyTest {

    private static final List<Match> matches = new ArrayList<>();
    private static final LeagueTable lt;

    static{
        // Make some quick test data
        Match m1 = new Match(TestConstants.ARS,TestConstants.CHLS,3, 1);
        Match m2 = new Match(TestConstants.ARS,TestConstants.MC,3, 1);
        Match m3 = new Match(TestConstants.ARS,TestConstants.LIV,3, 1);

        Match m4 = new Match(TestConstants.CHLS,TestConstants.ARS,2, 1);
        Match m5 = new Match(TestConstants.CHLS,TestConstants.MC,2, 1);
        Match m6 = new Match(TestConstants.CHLS,TestConstants.LIV,2, 1);

        Match m7 = new Match(TestConstants.MC,TestConstants.ARS,1, 1);
        Match m8 = new Match(TestConstants.MC,TestConstants.CHLS,1, 1);
        Match m9 = new Match(TestConstants.MC,TestConstants.LIV,1, 1);

        Match m10 = new Match(TestConstants.LIV,TestConstants.ARS,1, 1);
        Match m11 = new Match(TestConstants.LIV,TestConstants.CHLS,1, 1);
        Match m12 = new Match(TestConstants.LIV,TestConstants.MC,1, 1);

        matches.add(m1);
        matches.add(m2);
        matches.add(m3);
        matches.add(m4);
        matches.add(m5);
        matches.add(m6);
        matches.add(m7);
        matches.add(m8);
        matches.add(m9);
        matches.add(m10);
        matches.add(m11);
        matches.add(m12);
        lt = new LeagueTable(matches);
        lt.getTableEntries().stream().forEach(entry -> System.out.println(entry.toString()));
    }

    @Test
    public void testTableSize(){
        int expected = 4;
        Assertions.assertEquals(expected,lt.getTableEntries().size());
    }

    @Test
    public void testTop(){
        String expected = TestConstants.ARS;
        String actual = lt.getTableEntries().get(0).getTeamName();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testBottom(){
        String expected = TestConstants.MC;
        String actual = lt.getTableEntries().get(lt.getTableEntries().size()-1).getTeamName();
        Assertions.assertEquals(expected,actual);
    }
}