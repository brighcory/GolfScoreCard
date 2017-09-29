package com.merlin.bright.cory.golfscorecard;

/**
 * Created by cory on 9/29/17.
 */

public class Hole {
    int mScore;
    int mHole;
    String mHoleName = "Hole "+mHole+":";

    public Hole(int score, int hole) {
        mScore = score;
        mHole = hole;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }

    public void setHole(int hole) {
        mHole = hole;
    }

    public String getHoleName() {
        return mHoleName;
    }

    public void setHoleName(int holeName) {
        mHoleName = "Hole "+holeName+":";
    }
}
