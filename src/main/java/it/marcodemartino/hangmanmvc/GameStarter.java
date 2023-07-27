package it.marcodemartino.hangmanmvc;

import it.marcodemartino.hangmanmvc.controller.HangmanController;
import it.marcodemartino.hangmanmvc.controller.IHangmanController;
import it.marcodemartino.hangmanmvc.model.HangmanModel;
import it.marcodemartino.hangmanmvc.model.IIHangmanModifiableModel;
import it.marcodemartino.hangmanmvc.view.HangmanView;
import it.marcodemartino.hangmanmvc.view.IHangmanView;

public class GameStarter {

    public static void main(String[] args) {
        IIHangmanModifiableModel model = new HangmanModel("hello");
        IHangmanView view = new HangmanView(model);
        IHangmanController controller = new HangmanController(view, model);
        view.setController(controller);
        controller.startGame();
    }
}
