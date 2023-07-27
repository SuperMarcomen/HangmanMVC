package it.marcodemartino.hangmanmvc.model;

public interface IIHangmanModifiableModel extends IHangmanReadableModel {

    void setHiddenWord(String hiddenWord);
    void setLives(int lives);
    void addGuessedLetter(char letter);
}
