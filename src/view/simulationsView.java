package view;


import java.util.ArrayList;

import controller.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.StageName;
import model.team;

public class simulationsView extends View{
	
	Main m; 
	GridPane gp;
	BorderPane layout;
	ToolBar tb;
	TilePane top;
	
	public simulationsView(Stage primaryStage, Main main) {
		this.stage = primaryStage;
		m=main;
		gp=new GridPane();
		
		tb = createTB();
		layout = new BorderPane();
		
		layout.setBottom(tb);
		top = createTop();
		top.setAlignment(Pos.CENTER);
		layout.setTop(top);
		
		updateGrid(m.getModel().getGroupA());
		layout.setCenter(gp);
		
		
		BorderPane.setAlignment(top, Pos.CENTER);
		BorderPane.setAlignment(gp, Pos.CENTER);
		top.setPadding(new Insets(20));
		gp.setPadding(new Insets(10));
		gp.setVgap(5);
		gp.setHgap(10);
		StackPane root = new StackPane();
		root.getChildren().add(layout);
		
		scene = new Scene(root,canvasWidth,canvasHeight);
		
		
	}
	
	
	
	public void updateGrid(model.Group let) {
		ArrayList<team> sorted = let.sortBySimPer();
		gp.getChildren().clear();
		
		
		for(int r = 1; r<sorted.size()+1 ; r++) {
			StackPane stack = new StackPane();
			System.out.println(sorted.get(r-1).getName());
	    	ImageView test= new ImageView(new Image(getClass().getResourceAsStream(sorted.get(r-1).getName()+".png")));
	    	test.setFitWidth(75);
	    	test.setFitHeight(75);
	    	
	    	stack.getChildren().add(test);
	    	stack.setPadding(new Insets(5));
	    	gp.add(stack,0,r);
	    	
		}
		for(int r = 1; r<sorted.size()+1 ; r++) {
			Label test = new Label();
			test.setText(sorted.get(r-1).getName());
	    	test.setFont(new Font(20));
	    	test.setTextAlignment(TextAlignment.CENTER);
	    	test.setPadding(new Insets(5));
	    	test.setPrefHeight(50);
	    	test.setPrefWidth(100);
	    	test.setAlignment(Pos.CENTER);
	    	gp.add(test, 1, r);
		}
		for(int c = 2;c<8;c++) {
			Label test = new Label();
			if(c>=5) {
				test.setText(c-1+"th");
			}
			else if(c==2) {
				test.setText(c-1+"st");
			}
			else if(c==3) {
				test.setText(c-1+"nd");
			}
			else if(c==4) {
				test.setText(c-1+"rd");
			}
			test.setFont(new Font(15));
	    	test.setTextAlignment(TextAlignment.CENTER);
	    	test.setPadding(new Insets(5));
	    	test.setPrefHeight(30);
	    	test.setPrefWidth(125);
	    	test.setAlignment(Pos.CENTER);
	    	gp.add(test, c, 0);
			
		}
		
		//m.getModel().getGroupA().printSimulatedPercentages(m.getModel().getSimulations());
		
		for(int r = 1; r<sorted.size()+1; r++) {
			for(int c = 2; c<8; c++) {
				Label test = new Label();
				test.setText(String.format("%.3f%%", ((double)sorted.get(r-1).getPlacings().get(c-2)/m.getModel().getSimulations())*100));
				test.setTextAlignment(TextAlignment.CENTER);
		    	test.setPadding(new Insets(5));
		    	test.setPrefHeight(30);
		    	test.setPrefWidth(125);
		    	test.setAlignment(Pos.CENTER);
		    	gp.add(test, c, r);
			}
		}
		
		
		
		
		gp.setAlignment(Pos.CENTER);
		
	}
	
	
	
	public ToolBar createTB() {
		Button backA = new Button();
		backA.setText("Group A Match Selection");
		backA.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Back to A matches");
				stage.setScene(m.getScenes().get(StageName.MATCHESA));
				m.getGroupAmatches().updateGP();
				m.getGroupBmatches().updateGP();
				m.getModel().getGroupA().resetMatches();
				m.getModel().getGroupB().resetMatches();
				
				
			}
		});
		backA.setPrefSize(200, 50);
		
		Button backB = new Button();
		backB.setText("Group B Match Selection");
		backB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("back to b matches");
				stage.setScene(m.getScenes().get(StageName.MATCHESB));
				m.getGroupBmatches().updateGP();
				m.getModel().getGroupB().resetMatches();
				
				
			}
		});
		backB.setPrefSize(200, 50);
		
		Button addToA = new Button();
		addToA.setText("Add a Match to A");
		addToA.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("add to a ");
				m.getAddToGroup().updateGrid(m.getModel().getGroupA());
				stage.setScene(m.getScenes().get(StageName.ADDTO));
				
			}
		});
		addToA.setPrefSize(150, 50);
		
		Button addToB = new Button();
		addToB.setText("Add a Match to B");
		addToB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("add to b");
				m.getAddToGroup().updateGrid(m.getModel().getGroupB());
				stage.setScene(m.getScenes().get(StageName.ADDTO));
			}
		});
		addToB.setPrefSize(150, 50);
		
		
		Region emptyCenter = new Region();
		HBox.setHgrow(emptyCenter, Priority.ALWAYS);

		
		return new ToolBar(backA,backB,emptyCenter,addToA,addToB);
	}
	
	public TilePane createTop() {
		Button A = new Button("Group A");
		Button B = new Button("Group B");
		
		A.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				updateGrid(m.getModel().getGroupA());
				
			}
			
		});
		
		B.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				updateGrid(m.getModel().getGroupB());
				
			}
			
		});
		
		
		
		A.setPrefSize(100, 50);
		B.setPrefSize(100, 50);
		A.setAlignment(Pos.CENTER);
		B.setAlignment(Pos.CENTER);
		TilePane tp = new TilePane(A,B);
		tp.setHgap(20);
		tp.setVgap(10);
		return tp;
	}



	
}
