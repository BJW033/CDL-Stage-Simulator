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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.StageName;
import model.team;
/**
 * The simulationsView prints the result of the randomized outcomes of the groups. This scene includes two buttons to quickly change from one 
 * pool to the other. Navigation buttons include ways to go to each group's matches and a way to go to the addToGroupView. Teams
 * are sorted in the grid by best chance to get first, then second, etc. 
 * @author bwu
 *
 */
public class simulationsView extends View{
	
	private Main m; 
	private GridPane gp;
	private BorderPane layout;
	private ToolBar tb;
	private TilePane top;
	/**
	 * Constructs the default format or the scene including four navigation buttons in the toolbar, a grid, and two buttons to change the grid
	 * content.
	 * @param primaryStage Stage used for view
	 * @param main Main used to get Model information of the teams in the pool
	 */
	public simulationsView(Stage primaryStage, Main main) {
		this.stage = primaryStage;
		m=main;
		gp=new GridPane();
		
		tb = createTB();
		tb.setStyle("-fx-background-color: transparent");
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
		BackgroundImage myBI= new BackgroundImage(new Image(getClass().getResourceAsStream("BGImage.jpeg"),canvasWidth,canvasHeight,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));
		
		
		scene = new Scene(root,canvasWidth,canvasHeight);
		
		
	}
	
	
	/**
	 * Updates the grid using the information from a given group. The grid consists of the team logos, names, chances at top 3, 
	 * and the chances at each placing in the group. The teams are sorted by chances of each placement (1st, 2nd, 3rd, etc.). 
	 * @param let
	 */
	public void updateGrid(model.Group let) {
		ArrayList<team> sorted = let.sortBySimPer();
		gp.getChildren().clear();
		
		
		for(int r = 1; r<sorted.size()+1 ; r++) {
			StackPane stack = new StackPane();
			//System.out.println(sorted.get(r-1).getName());
	    	ImageView test= new ImageView(new Image(getClass().getResourceAsStream(sorted.get(r-1).getName()+".png")));
	    	
	    	test.setFitWidth(75);
	    	test.setFitHeight(75);
	    	
	    	stack.getChildren().add(test);
	    	stack.setPadding(new Insets(5));
	    	stack.setStyle("-fx-background-color: white");
	    	gp.add(stack,0,r);
	    	
		}
		for(int r = 1; r<sorted.size()+1 ; r++) {
			Label test = new Label();
			
			test.setText(sorted.get(r-1).getName());
			test.setStyle("-fx-background-color: black");
			test.setTextFill(Color.WHITE);
			test.setFont(new Font("Courier New",15));
	    	test.setTextAlignment(TextAlignment.CENTER);
	    	test.setPadding(new Insets(5));
	    	test.setPrefHeight(50);
	    	test.setPrefWidth(125);
	    	test.setAlignment(Pos.CENTER);
	    	gp.add(test, 1, r);
		}
		for(int r = 1; r<sorted.size()+1 ; r++) {
			Label test = new Label();
			
			test.setText(String.format("%.3f%%", ((double)sorted.get(r-1).getTop3Per()/m.getModel().getSimulations())*100));
			test.setStyle("-fx-background-color: black");
			test.setTextFill(Color.GOLD);
			test.setFont(new Font("Courier New",15));
	    	test.setTextAlignment(TextAlignment.CENTER);
	    	test.setPadding(new Insets(5));
	    	test.setPrefHeight(30);
	    	test.setPrefWidth(125);
	    	test.setAlignment(Pos.CENTER);
	    	gp.add(test, 2, r);
		}
		
		for(int c = 2;c<9;c++) {
			Label test = new Label();
			test.setStyle("-fx-background-color: black");
			test.setTextFill(Color.WHITE);
			
			if(c>=6) {
				test.setText(c-2+"th");
			}
			else if(c==2) {
				test.setText("Top 3%");
				test.setTextFill(Color.GOLD);
			}
			else if(c==3) {
				test.setText(c-2+"st");
			}
			else if(c==4) {
				test.setText(c-2+"nd");
			}
			else if(c==5) {
				test.setText(c-2+"rd");
			}
			
			test.setFont(new Font("Courier New",20));
			
	    	test.setTextAlignment(TextAlignment.CENTER);
	    	test.setPadding(new Insets(5));
	    	test.setPrefHeight(30);
	    	test.setPrefWidth(125);
	    	test.setAlignment(Pos.CENTER);
	    	gp.add(test, c, 0);
			
		}
		
		//m.getModel().getGroupA().printSimulatedPercentages(m.getModel().getSimulations());
		
		for(int r = 1; r<sorted.size()+1; r++) {
			for(int c = 3; c<9; c++) {
				Label test = new Label();
				test.setText(String.format("%.3f%%", ((double)sorted.get(r-1).getPlacings().get(c-3)/m.getModel().getSimulations())*100));
				test.setStyle("-fx-background-color: black");
				test.setTextFill(Color.WHITE);
				test.setFont(new Font("Courier New",15));
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
	
	
	/**
	 * Creates the navigation bar which includes short cuts to groupAmatchesView, groupBmatchView, and addToGroupView. Two buttons 
	 * got to addToGroupView (one for each Group A and B). When the user goes back to groupAMatchesView, the matches of both groups
	 * are reset. When the user goes back to groupBMatchesView, only matches in GroupB are reset. The UI displays what the matches were 
	 * set to previously. This is to avoid double-counting matches. 
	 * @return ToolBar navigation buttons
	 */
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
		backA.setPrefSize(250, 50);
		backA.setFont(new Font("Courier New",15));
		Button backB = new Button();
		backB.setText("Group B Match Selection");
		backB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.setScene(m.getScenes().get(StageName.MATCHESB));
				m.getGroupBmatches().updateGP();
				m.getModel().getGroupB().resetMatches();
				
				
			}
		});
		backB.setPrefSize(250, 50);
		backB.setFont(new Font("Courier New",15));
		Button addToA = new Button();
		addToA.setText("Add a Match to A");
		addToA.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				m.getAddToGroup().updateGrid(m.getModel().getGroupA(),"B");
				stage.setScene(m.getScenes().get(StageName.ADDTO));
				
			}
		});
		addToA.setPrefSize(200, 50);
		addToA.setFont(new Font("Courier New",15));
		
		
		Button addToB = new Button();
		addToB.setText("Add a Match to B");
		addToB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("add to b");
				m.getAddToGroup().updateGrid(m.getModel().getGroupB(),"A");
				
				stage.setScene(m.getScenes().get(StageName.ADDTO));
			}
		});
		addToB.setPrefSize(200, 50);
		addToB.setFont(new Font("Courier New",15));
		
		Region emptyCenter = new Region();
		HBox.setHgrow(emptyCenter, Priority.ALWAYS);

		
		return new ToolBar(backA,backB,emptyCenter,addToA,addToB);
	}
	/**
	 * The top contains the two buttons used to update the grid between each group
	 * @return TilePane buttons to change Group illustrated in grid
	 */
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
		A.setFont(new Font("Courier New",15));
		B.setFont(new Font("Courier New",15));
		A.setAlignment(Pos.CENTER);
		B.setAlignment(Pos.CENTER);
		TilePane tp = new TilePane(A,B);
		tp.setHgap(20);
		tp.setVgap(10);
		return tp;
	}



	
}
