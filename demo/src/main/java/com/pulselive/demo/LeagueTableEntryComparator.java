package com.pulselive.demo;

import java.util.Comparator;

public class LeagueTableEntryComparator implements Comparator<LeagueTableEntry> {

    @Override
    public int compare(LeagueTableEntry o1, LeagueTableEntry o2) {
        // I hope this is the right way around. If not I can just reverse.

        if(o1.getPoints()>o2.getPoints()){
            return -1;
        }else if(o2.getPoints()>o1.getPoints()){
            return 1;
        }else{
            if(o1.getGoalDifference()>o2.getGoalDifference()){
                return -1;
            }else if(o2.getGoalDifference()>o1.getGoalDifference()){
                return 1;
            }else{
                if(o1.getGoalsFor()>o2.getGoalsFor()){
                    return -1;
                }else if(o2.getGoalsFor()>o1.getGoalsFor()){
                    return 1;
                }else{
                    return o1.getTeamName().compareTo(o2.getTeamName());
                }
            }
        }
    }
}
