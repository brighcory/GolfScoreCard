package com.merlin.bright.cory.golfscorecard;

/**
 * Created by cory on 9/29/17.
 */

public class Hole {
    private int mScore;
    private int mHole;
    private String mHoleName;

    public Hole(int hole, int score) {
        mScore = score;
        mHole = hole;
        mHoleName = "Hole " + mHole + ": ";
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }

    public int getHole() {
        return mHole;
    }

    public String getHoleName() {
        return mHoleName;
    }

}
