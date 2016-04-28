package net.ultradev.dominion;

import javafx.event.ActionEvent;
import javax.servlet.http.HttpSession;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import net.ultradev.dominion.game.Turn;
import net.ultradev.dominion.game.local.LocalGame;
import net.ultradev.dominion.gameGUI.GUtils;

public class LocalGameMenu {
	private BorderPane root;


	public LocalGameMenu(){
		createLocalGameMenu();
	}

	public BorderPane getRoot(){
		return root;
	}

	private void createLocalGameMenu(){
		double width = 300;
		double height = 100;
		root = new BorderPane();
		root.setId("Menu");
		GUtils functions = new GUtils();

		VBox center = new VBox();
		center.setAlignment(Pos.CENTER);

		Button newGame = functions.createButton("Create new Game", width, height);
		newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            	/*GameServer gs = new GameServer();
                gs.getUtils().setDebugging(false);
                LocalGame localGame = gs.getGameManager().createGame(null);
                //tijdelijk TODO Apart menu maken om spel in te stellen
                localGame.addPlayer("John_Cena");
                localGame.addPlayer("RickAstley");
                localGame.addPlayer("DonaldPlumb");
                localGame.start();

                PlayerConfirm pC = new PlayerConfirm(localGame,true);*/

            	GameCreationMenu gcm = new GameCreationMenu();

            	DominionGUIMain.setRoot(gcm.getRoot());

            }
        });
		Button loadGame = functions.createButton("Load Game", width, height);
		center.getChildren().addAll(newGame,loadGame);
		root.setCenter(center);

		HBox bottom = new HBox();
		bottom.setAlignment(Pos.CENTER_RIGHT);
		Button exitBtn = functions.createExit();
		bottom.getChildren().add(exitBtn);
		root.setBottom(bottom);
	}



}
