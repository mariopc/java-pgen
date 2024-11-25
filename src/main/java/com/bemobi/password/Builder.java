package com.bemobi.password;

public interface Builder {

    Builder length(int length);

    Builder useNumbers();

    Builder removeNumbers();

    Builder minNumbers(int minNumber);

    Builder useUppercase();

    Builder removeUppercase();

    Builder minUppercase(int minUppercase);

    Builder useLowercase();

    Builder removeLowercase();

    Builder minLowercase(int minLowercase);

    Builder useSpecialCharacters();

    Builder removeSpecialCharacters();

    Builder minSpecial(int minSpecial);

    Builder useAmbiguousCharacters();

    PassOptions build();
}
