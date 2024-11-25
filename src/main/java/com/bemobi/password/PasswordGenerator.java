package com.bemobi.password;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {

    private final StringBuilder lowercaseCharSet = new StringBuilder("abcdefghijkmnopqrstuvwxyz");
    private final StringBuilder uppercaseCharSet = new StringBuilder("ABCDEFGHJKLMNPQRSTUVWXYZ");
    private final StringBuilder numberCharSet = new StringBuilder("23456789");
    private final StringBuilder specialCharSet = new StringBuilder("!@#$%^&*");
    private final SecureRandom r = new SecureRandom();

    public String generatePassword(PassOptions opt) {
        sanitizePasswordLength(opt, true);

        int minLength = opt.minUppercase() + opt.minLowercase() + opt.minNumber() + opt.minSpecial();
        if (opt.length() < minLength) {
            opt.setLength(minLength);
        }
        List<String> positions = getPositions(opt);
        Collections.shuffle(positions);

        // build out the char sets
        StringBuilder allCharSet = new StringBuilder();

        if (opt.isAmbiguous()) {
            lowercaseCharSet.append("l");
        }
        if (opt.isLowercase()) {
            allCharSet.append(lowercaseCharSet);
        }
        if (opt.isAmbiguous()) {
            uppercaseCharSet.append("IO");
        }
        if (opt.isUppercase()) {
            allCharSet.append(uppercaseCharSet);
        }
        if (opt.isAmbiguous()) {
            numberCharSet.append("01");
        }
        if (opt.isNumber()) {
            allCharSet.append(numberCharSet);
        }
        if (opt.isSpecial()) {
            allCharSet.append(specialCharSet);
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < opt.length(); i++) {
            String positionChars = "";
            switch (positions.get(i)) {
                case "l":
                    positionChars = lowercaseCharSet.toString();
                    break;
                case "u":
                    positionChars = uppercaseCharSet.toString();
                    break;
                case "n":
                    positionChars = numberCharSet.toString();
                    break;
                case "s":
                    positionChars = specialCharSet.toString();
                    break;
                case "a":
                    positionChars = allCharSet.toString();
                    break;
                default:
                    break;
            }
            int randomCharIndex = r.nextInt(0, positionChars.length() -1);
            password.append(positionChars.charAt(randomCharIndex));
        }

        return password.toString();

    }

    private List<String> getPositions(PassOptions opt) {
        List<String> positions = new ArrayList<>();
        if (opt.isLowercase() && opt.minLowercase() > 0) {
            for (int i = 0; i < opt.minLowercase(); i++) {
                positions.add("l");
            }
        }

        if (opt.isUppercase() && opt.minUppercase() > 0) {
            for (int i = 0; i < opt.minUppercase(); i++) {
                positions.add("u");
            }
        }
        if (opt.isNumber() && opt.minNumber() > 0) {
            for (int i = 0; i < opt.minNumber(); i++) {
                positions.add("n");
            }
        }
        if (opt.isSpecial() && opt.minSpecial() > 0) {
            for (int i = 0; i < opt.minSpecial(); i++) {
                positions.add("s");
            }
        }
        while (positions.size() < opt.length()) {
            positions.add("a");
        }
        return positions;
    }

    private void sanitizePasswordLength(PassOptions passOpt, boolean forGeneration) {

        int minUppercaseCalc = 0;
        int minLowercaseCalc = 0;
        int minNumberCalc = passOpt.minNumber();
        int minSpecialCalc = passOpt.minSpecial();

        if (passOpt.isUppercase() && passOpt.minUppercase() <= 0) {
            minUppercaseCalc = 1;
        } else if (!passOpt.isUppercase()) {
            minUppercaseCalc = 0;
        }

        if (passOpt.isLowercase() && passOpt.minLowercase() <= 0) {
            minLowercaseCalc = 1;
        } else if (!passOpt.isLowercase()) {
            minLowercaseCalc = 0;
        }

        if (passOpt.isNumber() && passOpt.minNumber() <= 0) {
            minNumberCalc = 1;
        } else if (!passOpt.isNumber()) {
            minNumberCalc = 0;
        }

        if (passOpt.isSpecial() && passOpt.minSpecial() <= 0) {
            minSpecialCalc = 1;
        } else if (!passOpt.isSpecial()) {
            minSpecialCalc = 0;
        }

        // This should never happen but is a final safety net
        if (passOpt.length() < 1) {
            passOpt.setLength(10);
        }

        int minLength = minUppercaseCalc + minLowercaseCalc + minNumberCalc + minSpecialCalc;
        // Normalize and Generation both require this modification
        if (passOpt.length() < minLength) {
            passOpt.setLength(minLength);
        }

        // Apply other changes if the options object passed in is for generation
        if (forGeneration) {
            passOpt.setMinUppercase(minUppercaseCalc);
            passOpt.setMinLowercase(minLowercaseCalc);
            passOpt.setMinNumber(minNumberCalc);
            passOpt.setMinSpecial(minSpecialCalc);
        }
    }
}
