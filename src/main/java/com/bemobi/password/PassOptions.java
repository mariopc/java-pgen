package com.bemobi.password;

public class PassOptions {

    private int length;
    private boolean number;
    private int minNumber;
    private boolean uppercase;
    private int minUppercase;
    private boolean lowercase;
    private int minLowercase;
    private boolean special;
    private int minSpecial;
    private boolean ambiguous;

    protected PassOptions(int length, boolean number, int minNumber, boolean uppercase, int minUppercase, boolean lowercase, int minLowercase, boolean special, int minSpecial, boolean ambiguous) {
        this.length = length;
        this.number = number;
        this.minNumber = minNumber;
        this.uppercase = uppercase;
        this.minUppercase = minUppercase;
        this.lowercase = lowercase;
        this.minLowercase = minLowercase;
        this.special = special;
        this.minSpecial = minSpecial;
        this.ambiguous = ambiguous;
    }

    public int length() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isNumber() {
        return number;
    }

    public void setNumber(boolean number) {
        this.number = number;
    }

    public int minNumber() {
        return minNumber;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    public boolean isUppercase() {
        return uppercase;
    }

    public void setUppercase(boolean uppercase) {
        this.uppercase = uppercase;
    }

    public int minUppercase() {
        return minUppercase;
    }

    public void setMinUppercase(int minUppercase) {
        this.minUppercase = minUppercase;
    }

    public boolean isLowercase() {
        return lowercase;
    }

    public void setLowercase(boolean lowercase) {
        this.lowercase = lowercase;
    }

    public int minLowercase() {
        return minLowercase;
    }

    public void setMinLowercase(int minLowercase) {
        this.minLowercase = minLowercase;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public int minSpecial() {
        return minSpecial;
    }

    public void setMinSpecial(int minSpecial) {
        this.minSpecial = minSpecial;
    }

    public boolean isAmbiguous() {
        return ambiguous;
    }

    public void setAmbiguous(boolean ambiguous) {
        this.ambiguous = ambiguous;
    }

    public static Builder newBuilder() {
        return new PassOptionsBuilderImpl();
    }

    @Override
    public String toString() {
        return "PassOptions{" +
                "length=" + length +
                ", number=" + number +
                ", minNumber=" + minNumber +
                ", uppercase=" + uppercase +
                ", minUppercase=" + minUppercase +
                ", lowercase=" + lowercase +
                ", minLowercase=" + minLowercase +
                ", special=" + special +
                ", minSpecial=" + minSpecial +
                ", ambiguous=" + ambiguous +
                '}';
    }
}
