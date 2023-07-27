package it.marcodemartino.hangmanmvc.view;

import it.marcodemartino.hangmanmvc.controller.IHangmanController;
import it.marcodemartino.hangmanmvc.model.IHangmanReadableModel;

import java.util.Scanner;

public class HangmanView implements IHangmanView {

    private  IHangmanController controller;
    private final IHangmanReadableModel model;
    private final Scanner scanner;

    public HangmanView(IHangmanReadableModel model) {
        this.model = model;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void askInput() {
        System.out.printf("Word to guess: %s%n", model.getHiddenWord());
        System.out.print("Guess a letter: ");
        String input = scanner.nextLine();
        controller.handleInput(input);
    }

    @Override
    public void noticeIncorrectInput() {
        System.out.println("You have to write a letter, idiot!");
    }

    @Override
    public void noticeLetterAlreadySaid() {
        System.out.println("Letter already said!");
    }

    @Override
    public void noticeWrongLetter() {
        System.out.println("Wrong letter!");
        System.out.printf("You now have %d lives%n", model.getLives());
    }

    @Override
    public void noticeCorrectLetter() {
        System.out.println("Nice, correct!");
    }

    @Override
    public void noticeLostMatch() {
        System.out.printf("You lost... The word to guess was %s%n", model.getWord());
    }

    @Override
    public void noticeWonMatch() {
        System.out.println("You have won");
    }

    public void setController(IHangmanController controller) {
        this.controller = controller;
    }
}
