package view;
import controller.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
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
		btn.setText("Start");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("next");
				primaryStage.setScene(main.getScenes().get(StageName.GROUPSELECTION));
			}
		});
		
		Button skip = new Button();
		skip.setText("To Stage 4 Week 3");
		skip.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("skip");
				//m.getModel().getGroupA().printStandings(false, m.getModel().getGroupA().getPool());
				m.getModel().getGroupA().simulateMatches(m.getModel().getGroupA(), false);
				//main.getModel().getGroupB().simulateMatches(main.getModel().getGroupB(), false);
				//main.getModel().getGroupB().printStandings(false, main.getModel().getGroupB().getPool());
				m.getModel().getGroupB().simulateMatches(m.getModel().getGroupB(), false);
				//m.getModel().getGroupB().getPool().get(0).getPlacings();
				
				m.getSim().updateGrid(m.getModel().getGroupA());
				primaryStage.setScene(m.getScenes().get(StageName.SIMULATION));
				
			}
		});
		TilePane tp = new TilePane(btn,skip);
		StackPane root = new StackPane();
		root.getChildren().add(tp);
		
		scene = new Scene(root, canvasWidth, canvasHeight);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
