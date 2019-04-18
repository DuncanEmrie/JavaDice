package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class driver extends Application {
	@Override
	public void start(Stage baseStage) {
	  /* creating the game here? */
		diceGame Game = new diceGame();

	  /* giving it a title */
		baseStage.setTitle("diceGame JavaFX");

	  /* create Font for buttons and labels */
		Font m20 = new Font("monospace", 20 );

	  /* create root node as flow layout */
	    GridPane rootNode = new GridPane();

	  /* create Hbox for die */
	    HBox dieBox = new HBox();
        dieBox.setPadding(new Insets(10, 20, 10, 20));
	    dieBox.setSpacing(10);
	    dieBox.setStyle("-fx-background-color: #88BB88;");

	  /* create 6 images for dice faces */
		Image face1 = new Image("one.png");
		Image face2 = new Image("two.png");
		Image face3 = new Image("three.png");
		Image face4 = new Image("four.png");
		Image face5 = new Image("five.png");
		Image face6 = new Image("six.png");

      /* create and add children to the dieBox */
		/* stuff for die1 */
		ImageView die1 = new ImageView();
		die1.setImage(face1);
		die1.setFitHeight(350);
		die1.setFitWidth(350);

		/* stuff for die2 */
		ImageView die2 = new ImageView();
		die2.setImage(face2);
		die2.setFitHeight(350);
		die2.setFitWidth(350);

		dieBox.getChildren().addAll(die1, die2);

	  /* create Hbox for info */
		HBox infoBox = new HBox();
		infoBox.setPadding(new Insets(10, 10, 10, 10));
		infoBox.setSpacing(10);
		infoBox.setStyle("-fx-background-color: #88FF88;");

	  /* create and add children to the infoBox */
		Label betLabel = new Label("Your Bet: ");
			betLabel.setFont(m20);
			betLabel.setPrefHeight(35);
			betLabel.setAlignment(Pos.CENTER);

		TextField userGuess = new TextField ();
			userGuess.setPrefSize(30, 35);
			userGuess.setAlignment(Pos.CENTER);
			userGuess.setOnKeyReleased(event ->{
				if (misc.isNumeric(userGuess.getText())) {
					int temp = misc.toInt(userGuess.getText());
					if(temp > 1 && temp < 13){
						userGuess.setStyle("-fx-background-color: #888888;");
						Game.setRoll(true);
					}
					else {
						userGuess.setStyle("-fx-background-color: #FF8888;");
						Game.setRoll(false);
					}
				}
			});


		Button rollButton = new Button("Roll Dice");
			rollButton.setPrefSize(135, 35);
			rollButton.setFont(m20);
			rollButton.setOnMouseClicked(event ->{
				if (Game.getRoll()){
				  /* updates dice values */
					Game.roll();

			      /* updates die1 image */
					int temp = Game.getDie1();
					switch (temp){
						case 1: die1.setImage(face1); break;
						case 2: die1.setImage(face2); break;
						case 3: die1.setImage(face3); break;
						case 4: die1.setImage(face4); break;
						case 5: die1.setImage(face5); break;
						case 6: die1.setImage(face6); break;
					}

				  /* updates die2 image */
					temp = Game.getDie2();
					switch (temp){
						case 1: die2.setImage(face1); break;
						case 2: die2.setImage(face2); break;
						case 3: die2.setImage(face3); break;
						case 4: die2.setImage(face4); break;
						case 5: die2.setImage(face5); break;
						case 6: die2.setImage(face6); break;
					}
					if(Game.getTotal() == misc.toInt(userGuess.getText()) )
						System.out.println("You guessed right");
					else
						System.out.println("You were wrong");
			}});

		Button exitButton = new Button("Exit");
			exitButton.setPrefSize(60, 35);
			exitButton.setFont(m20);
			exitButton.setOnMouseClicked(event -> Platform.exit());

		infoBox.getChildren().addAll(betLabel, userGuess, rollButton, exitButton);

		rootNode.add(dieBox, 0, 0);
		rootNode.add(infoBox, 0, 1);
		Scene scene = new Scene(rootNode, 750, 435);
		baseStage.setScene(scene);
		baseStage.show();

	}

  /*override the init method */
	@Override
	public void init() {
		System.out.println("Inside the start method");
	}

  /* override the stop method */
	@Override
	public void stop() {
		System.out.println("Inside the stop method.");
	}

	public static void main(String[] args) {
		System.out.println("Launching diceGame with JavaFX");
		launch(args);
	}
}
