package io.github.somethinginconspicuous.game;

public class TimeLimit {
    private int minutesLeft;

    public TimeLimit(){
        this(9 * 60); // 9 hours
    }

    public TimeLimit(int minutesLeft){
        this.minutesLeft = minutesLeft;
    }

    public void spend(int minutes){
        minutesLeft -= minutes;
    }

    public void spendHours(int hours){
        spend(hours * 60);
    }

    public boolean hasTimeLeft(){
        return minutesLeft > 0;
    }

    public int minutesLeft(){
        return minutesLeft;
    }

    public int hoursLeft(){
        return minutesLeft / 60;
    }

    public int minutesOnlyLeft(){
        return minutesLeft % 60;
    }

    @Override
    public String toString() {
        int mm = minutesOnlyLeft();
        return hoursLeft() + ":" + (mm == 0 ? "00" : mm);
    }
}
