package it.marcodemartino.hangmanmvc.view;

import it.marcodemartino.hangmanmvc.controller.IHangmanController;

public interface IHangmanView {

    void askInput();
    void noticeIncorrectInput();
    void noticeLetterAlreadySaid();
    void noticeWrongLetter();
    void noticeCorrectLetter();
    void noticeLostMatch();
    void noticeWonMatch();
    void setController(IHangmanController controller);
}
