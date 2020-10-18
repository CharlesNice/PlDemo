package com.pulselive.demo;

public class Match {

    private String homeTeam;
    private String awayTeam;
    // Same as before, you could probably save some memory using shorts here.
    private int homeScore;
    private int awayScore;

    public Match( final String homeTeam, final String awayTeam, final int homeScore, final int awayScore )
    {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public String getHomeTeam()
    {
        return homeTeam;
    }

    public String getAwayTeam()
    {
        return awayTeam;
    }

    public int getHomeScore()
    {
        return homeScore;
    }

    public int getAwayScore()
    {
        return awayScore;
    }

    public String homeOrAwayWin(){
        // Just to make life a little easier
        if(homeScore>awayScore){
            return Constants.HOME;
        }else if(awayScore>homeScore){
            return Constants.AWAY;
        }else{
            return Constants.DRAW;
        }
    }
}
