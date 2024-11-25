package com.bemobi.password;

public class PassOptionsBuilderImpl implements Builder {

    private int length = 14;
    private boolean number = true;
    private int minNumber = 1;
    private boolean uppercase = true;
    private int minUppercase = 0;
    private boolean lowercase = true;
    private int minLowercase = 0;
    private boolean special = false;
    private int minSpecial = 1;
    private boolean ambiguous = false;

    @Override
    public Builder length(int length) {
        this.length = length;
        return this;
    }

    @Override
    public Builder useNumbers() {
        this.number = true;
        return this;
    }

    @Override
    public Builder removeNumbers() {
        this.number = false;
        return this;
    }

    @Override
    public Builder minNumbers(int minNumber) {
        this.minNumber = minNumber;
        return this;
    }

    @Override
    public Builder useUppercase() {
        this.uppercase = true;
        return this;
    }

    @Override
    public Builder removeUppercase() {
        this.uppercase = false;
        return this;
    }

    @Override
    public Builder minUppercase(int minUppercase) {
        this.minUppercase = minUppercase;
        return this;
    }

    @Override
    public Builder useLowercase() {
        this.lowercase = true;
        return this;
    }

    @Override
    public Builder removeLowercase() {
        this.lowercase = false;
        return this;
    }

    @Override
    public Builder minLowercase(int minLowercase) {
        this.minLowercase = minLowercase;
        return this;
    }

    @Override
    public Builder useSpecialCharacters() {
        this.special = true;
        return this;
    }

    @Override
    public Builder removeSpecialCharacters() {
        this.special = false;
        return this;
    }

    @Override
    public Builder minSpecial(int minSpecial) {
        this.minSpecial = minSpecial;
        return this;
    }

    @Override
    public Builder useAmbiguousCharacters() {
        this.ambiguous = true;
        return this;
    }

    @Override
    public PassOptions build() {
        if (!this.lowercase && !this.uppercase && !this.number && !this.special) {
            throw new IllegalArgumentException("At least one character set must be enabled: lowercase, uppercase, numbers, or special characters.");
        }
        return new PassOptions(this.length, this.number, this.minNumber, this.uppercase, this.minUppercase, this.lowercase, this.minLowercase, this.special, this.minSpecial, this.ambiguous);
    }

}
