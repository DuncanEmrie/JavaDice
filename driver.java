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
		dieBox.setAlignment(Pos.TOP_CENTER);


	  /* create 6 images for dice faces */
		Image face1 = new Image("one.png");
		Image face2 = new Image("two.png");
		//Image face3 = new Image("image/three.png");
		//Image face4 = new Image("image/four.png");
		//Image face5 = new Image("image/five.png");
		//Image face6 = new Image("image/six.png");

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
		infoBox.setSpacing(25);
		infoBox.setStyle("-fx-background-color: #88FF88;");
		infoBox.setAlignment(Pos.BOTTOM_CENTER);

	  /* create and add children to the infoBox */
		Button rollButton = new Button("Roll Dice");
		rollButton.setPrefSize(135, 35);
		rollButton.setFont(m20);

		Button exitButton = new Button("Exit");
		exitButton.setPrefSize(60, 35);
		exitButton.setFont(m20);
		exitButton.setOnMouseClicked(event -> Platform.exit());

		infoBox.getChildren().addAll(rollButton, exitButton);

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
