package view;
import controller.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Group;
import model.StageName;

public class startView extends View{
	
	Main m;
	public startView(Stage primaryStage, Main main) {
		m = main;
		this.stage = primaryStage;
		stage.setResizable(false);
		stage.sizeToScene();
		primaryStage.setTitle("Group Simulator");
		Button btn = new Button();
		btn.setText("Start from Scratch");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("next");
				primaryStage.setScene(main.getScenes().get(StageName.GROUPSELECTION));
			}
		});
		
		Button stageFour = new Button();
		stageFour.setText("To Stage 4 Week 3");
		stageFour.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				m.getModel().setGroupA(new Group(false));
				
				m.getModel().getGroupA().simulateMatches(m.getModel().getGroupA(), false);
				
				m.getModel().setGroupB(new Group(true));
				m.getModel().getGroupB().simulateMatches(m.getModel().getGroupB(), false);
				
				
				m.getSim().updateGrid(m.getModel().getGroupA());
				primaryStage.setScene(m.getScenes().get(StageName.SIMULATION));
				
			}
		});
		
		Button stageFive = new Button();
		stageFive.setText("To Stage 5");
		stageFive.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				m.getModel().setGroupA(new Group(false));
				
				m.getModel().setGroupB(new Group(true));
				
				m.getGroupAmatches().updateGP();
				m.getGroupBmatches().updateGP();
				primaryStage.setScene(m.getScenes().get(StageName.MATCHESA));
				
			}
		});
		
		GridPane gp = new GridPane();
		gp.setHgap(25);
		gp.add(btn,0,0,1,1);
		gp.add(stageFour,1,0,1,1);
		gp.add(stageFive,2,0,1,1);
		gp.setAlignment(Pos.CENTER);
		
		ImageView test= new ImageView(new Image(getClass().getResourceAsStream("Home Image.jpeg")));
		test.prefWidth(canvasWidth);
		test.prefHeight(canvasHeight);
		StackPane root = new StackPane();
		BackgroundImage myBI= new BackgroundImage(new Image(getClass().getResourceAsStream("Home Image.jpeg"),canvasWidth,canvasHeight,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		//then you set to your node
		root.setBackground(new Background(myBI));
		
		root.getChildren().add(gp);
		
		scene = new Scene(root, canvasWidth, canvasHeight);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
