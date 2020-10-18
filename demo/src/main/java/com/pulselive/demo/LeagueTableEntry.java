package com.pulselive.demo;

import java.util.Objects;

public class LeagueTableEntry {

    /*
        Just a side note. I know you don't want method signatures changed.
        But, you could probably get away with using a shorts instead of ints.
        int feels a tad excessive, considering its maximum value.
        - CN
     */
    private String teamName;
    private int played;
    private int won;
    private int drawn;
    private int lost;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;
    private int points;

    public LeagueTableEntry( final String teamName, final int played, final int won, final int drawn, final int lost,
                             final int goalsFor, final int goalsAgainst, final int goalDifference, final int points )
    {
        this.teamName = teamName;
        this.played = played;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.points = points;
    }

    // Copy Constructor for making deep copies.
    /*  I was going to use this,
        but, in the end, I decided not to.
        But, I am leaving to show you I understand the concept.

    public LeagueTableEntry(LeagueTableEntry l){
        this.teamName = new String(l.getTeamName());
        this.played = l.getPlayed();
        this.won = l.getWon();
        this.drawn = l.getDrawn();
        this.lost = l.getLost();
        this.goalsFor = l.getGoalsFor();
        this.goalsAgainst = l.getGoalsAgainst();
        this.goalDifference = l.getGoalDifference();
        this.points = l.getPoints();
    }
    */

    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName( String teamName )
    {
        this.teamName = teamName;
    }

    public int getPlayed()
    {
        return played;
    }

    public void setPlayed( int played )
    {
        this.played = played;
    }

    public int getWon()
    {
        return won;
    }

    public void setWon( int won )
    {
        this.won = won;
    }

    public int getDrawn()
    {
        return drawn;
    }

    public void setDrawn( int drawn )
    {
        this.drawn = drawn;
    }

    public int getLost()
    {
        return lost;
    }

    public void setLost( int lost )
    {
        this.lost = lost;
    }

    public int getGoalsFor()
    {
        return goalsFor;
    }

    public void setGoalsFor( int goalsFor )
    {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst()
    {
        return goalsAgainst;
    }

    public void setGoalsAgainst( int goalsAgainst )
    {
        this.goalsAgainst = goalsAgainst;
    }

    public int getGoalDifference()
    {
        return goalDifference;
    }

    public void setGoalDifference( int goalDifference )
    {
        this.goalDifference = goalDifference;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints( int points )
    {
        this.points = points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Team: ");
        sb.append(teamName);
        sb.append(", Points: ");
        sb.append(points);
        sb.append(", W/L/D: ");
        sb.append(won);
        sb.append(":");
        sb.append(lost);
        sb.append(":");
        sb.append(drawn);
        sb.append(", GF/GA: ");
        sb.append(goalsFor);
        sb.append(":");
        sb.append(goalsAgainst);
        sb.append(", GD ");
        sb.append(goalDifference);

        return sb.toString();
    }
}
