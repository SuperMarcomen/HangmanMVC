package it.marcodemartino.hangmanmvc.model;

import java.util.Set;

public interface IHangmanReadableModel {

    String getWord();
    String getHiddenWord();
    int getLives();
    Set<Character> getGuessedLetters();

}
