package it.marcodemartino.hangmanmvc.model;

import java.util.HashSet;
import java.util.Set;

public class HangmanModel implements IIHangmanModifiableModel {

    private static final int STARTING_LIVES = 5;
    private final String word;
    private String hiddenWord;
    private int lives;
    private final Set<Character> guessedLetters;

    public HangmanModel(String word) {
        this.word = word;
        this.lives = STARTING_LIVES;
        this.guessedLetters = new HashSet<>();
    }

    @Override
    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    @Override
    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public void addGuessedLetter(char letter) {
        this.guessedLetters.add(letter);
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public String getHiddenWord() {
        return hiddenWord;
    }

    @Override
    public int getLives() {
        return lives;
    }

    @Override
    public Set<Character> getGuessedLetters() {
        return new HashSet<>(guessedLetters);
    }
}
