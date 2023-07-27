package it.marcodemartino.hangmanmvc.controller;

import it.marcodemartino.hangmanmvc.model.IIHangmanModifiableModel;
import it.marcodemartino.hangmanmvc.view.IHangmanView;

import java.util.Set;

public class HangmanController implements IHangmanController {
    public static final String WORD_SPACER = "-";

    private final IHangmanView view;
    private final IIHangmanModifiableModel model;
    private boolean running;

    public HangmanController(IHangmanView view, IIHangmanModifiableModel model) {
        this.view = view;
        this.model = model;
        running = true;
        model.setHiddenWord(creteHiddenWord());
    }

    @Override
    public void startGame() {
        while (running) {
            view.askInput();
        }
    }

    @Override
    public void handleInput(String input) {
        char letter = input.charAt(0);
        if (input.length() > 1 || !Character.isAlphabetic(letter)) {
            view.noticeIncorrectInput();
            return;
        }

        if (model.getGuessedLetters().contains(letter)) {
            view.noticeLetterAlreadySaid();
            return;
        }

        handleGuessedLetter(letter);
        checkIfGameEnded();
    }

    private void checkIfGameEnded() {
        if (model.getLives() == 0) {
            view.noticeLostMatch();
            running = false;
            return;
        }
        if (model.getWord().equals(model.getHiddenWord())) {
            view.noticeWonMatch();
            running = false;
        }
    }

    private void handleGuessedLetter(char guessedLetter) {
        model.addGuessedLetter(guessedLetter);
        updateLives(guessedLetter);
        notifyUser(guessedLetter);
        model.setHiddenWord(creteHiddenWord());
    }

    private void notifyUser(char guessedLetter) {
        if (model.getWord().contains(String.valueOf(guessedLetter))) {
            view.noticeCorrectLetter();
        } else {
            view.noticeWrongLetter();
        }

    }

    private void updateLives(char guessedLetter) {
        if (model.getWord().contains(String.valueOf(guessedLetter))) return;
        model.setLives(model.getLives() - 1);
    }

    private String creteHiddenWord() {
        StringBuilder hiddenWord = new StringBuilder();
        Set<Character> guessedLetters = model.getGuessedLetters();
        for (char wordLetter : model.getWord().toCharArray()) {
            if (guessedLetters.contains(wordLetter)) {
                hiddenWord.append(wordLetter);
            } else {
                hiddenWord.append(WORD_SPACER);
            }
        }
        return hiddenWord.toString();
    }
}
