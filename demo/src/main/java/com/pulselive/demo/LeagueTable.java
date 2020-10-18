package com.pulselive.demo;

import java.util.*;

public class LeagueTable {

    // Using Arraylist to for indexing and preserving order.
    private final ArrayList<LeagueTableEntry> tableEntries;

    public LeagueTable( final List<Match> matches ) {
        this.tableEntries = new ArrayList<>();
        setTableEntries(matches);
    }

    private void setTableEntries(List<Match> matches){
        // Clear any old entries in table List
        tableEntries.clear();

        /*  Using a map since finding by key (Which will be teamName) is nice and easy
            from the match data. Originally, I was going to use a set to ensure no duplication,
            but in the end I decided that I can just check with the map key.

            Also, setting initial size improves performance for maps.
            You can also tune performace by setting load factor, but I am not sure
            that is 100% necessary here. */
        Map<String,LeagueTableEntry> map = new HashMap<>(matches.size(),(float)1.0);

        // Loop matches and extract data
        matches.stream().forEach(match -> {
            /*  Match or data might be null, unlikely, but one can never be certain.
                I will choose to skip these, to prevent null pointer exceptions. */
            if(null!=match && null!=match.getHomeTeam() && null!=match.getAwayTeam()){
                String home = match.getHomeTeam().toLowerCase();
                String away = match.getAwayTeam().toLowerCase();

            /*  Add entries only if they dont exist.
                This ensures you don't overwrite entries. */

                if(null==map.get(home)){
                    map.put(home, new LeagueTableEntry(home,
                            0,0,0,0,0,0,0,0));
                }
                if(null==map.get(away)){
                    map.put(away, new LeagueTableEntry(away,
                            0,0,0,0,0,0,0,0));
                }

                // Get the entry that will definitely exist now.
                LeagueTableEntry entryHome = map.get(home);
                LeagueTableEntry entryAway = map.get(away);

                // Add and set goals for and against
                entryHome.setGoalsFor(entryHome.getGoalsFor() + match.getHomeScore());
                entryHome.setGoalsAgainst(entryHome.getGoalsAgainst() + match.getAwayScore());

                entryAway.setGoalsFor(entryAway.getGoalsFor() + match.getAwayScore());
                entryAway.setGoalsAgainst(entryAway.getGoalsAgainst() + match.getHomeScore());

                // Determine winner and tally wins etc
                if(match.homeOrAwayWin().equals(Constants.HOME)){
                    // Add points for Home win
                    entryHome.setWon(entryHome.getWon()+1);
                    entryHome.setPoints(entryHome.getPoints()+3);
                    entryAway.setLost(entryAway.getLost()+1);
                }else if(match.homeOrAwayWin().equals(Constants.AWAY)){
                    // Add points for Away win
                    entryAway.setWon(entryAway.getWon()+1);
                    entryAway.setPoints(entryAway.getPoints()+3);
                    entryHome.setLost(entryHome.getLost()+1);
                }else{
                    // Draw
                    entryHome.setDrawn(entryHome.getDrawn()+1);
                    entryHome.setPoints(entryHome.getPoints()+1);
                    entryAway.setDrawn(entryAway.getDrawn()+1);
                    entryAway.setPoints(entryAway.getPoints()+1);
                }
            }
        });

        // Determine final goal diff, and add to the List
        map.forEach( (key,entry) -> {
            entry.setGoalDifference(entry.getGoalsFor() - entry.getGoalsAgainst());
            tableEntries.add(entry);
        });
    }

    /**
     * Get the ordered list of league table entries for this league table.
     *
     * @return
     */
    public List<LeagueTableEntry> getTableEntries() {
        tableEntries.sort(new LeagueTableEntryComparator());
        //  If you want the reverse.
        //Collections.sort(tableEntries,Collections.reverseOrder());
        return tableEntries;
    }
}
