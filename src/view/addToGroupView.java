package view;

import java.util.ArrayList;

import controller.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.StageName;
import model.team;

/**
 * addToGroupView is used to determine the impact of a particular match outcome with the given set of matches of each pool. 
 * The match is NOT ADDED to the pool, but rather added, simulated, then removed. Teams are sorted by their top 3% before and after
 * simulations. 
 * @author bwu
 *
 */
public class addToGroupView extends View{
	
	private Main m; 
	private GridPane gpBefore;
	private GridPane centerColumn;
	private GridPane gpAfter;
	private BorderPane layout;
	private ToolBar tb;
	private GridPane c;
	
	/**
	 * The constructor of the scene fills the scene with basic formating. The UI includes one navigation button and one change group button.
	 * The scene also includes two grids for a before and after comparison of the team's top 3 chances. In the center of the scene are two images,
	 * two combo boxes, map count labels, and a submit button that add a match to the pool. 
	 * @param primaryStage Stage used for view
	 * @param main Main used to get Model information of the teams in the pool
	 */
	public addToGroupView(Stage primaryStage, Main main) {
		this.stage = primaryStage;
		m=main;
		
		layout = new BorderPane();
			
		gpBefore=new GridPane();
		gpBefore.setAlignment(Pos.CENTER);
		gpAfter=new GridPane();
		gpAfter.setAlignment(Pos.CENTER);
		centerColumn = new GridPane();
		centerColumn.setAlignment(Pos.CENTER);
		
		
		c = new GridPane();
		c.setHgap(25);
		c.setAlignment(Pos.CENTER);
		
		updateTB("A");
		layout.setBottom(tb);
			
		updateGrid(m.getModel().getGroupA(),"A");
		layout.setCenter(c);
			
		BorderPane.setAlignment(gpBefore, Pos.CENTER);
		
		c.setPadding(new Insets(10));
		
		gpBefore.setPadding(new Insets(10));
		gpBefore.setVgap(5);
		gpBefore.setHgap(10);
		
		BorderPane.setAlignment(gpAfter, Pos.CENTER);
		gpAfter.setPadding(new Insets(10));
		gpAfter.setVgap(5);
		gpAfter.setHgap(10);
		
		BorderPane.setAlignment(centerColumn, Pos.CENTER);
		centerColumn.setPadding(new Insets(10));
		centerColumn.setVgap(5);
		centerColumn.setHgap(10);
		
		
		StackPane root = new StackPane();
		root.getChildren().add(layout);
		BackgroundImage myBI= new BackgroundImage(new Image(getClass().getResourceAsStream("BGImage.jpeg"),canvasWidth,canvasHeight,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));
		
		
		
		scene = new Scene(root,canvasWidth,canvasHeight);
		
	}
	/**
	 * updates all parts of the center including both before and after grids plus the middle sections. This is used in changing between 
	 * groups. The toolbar is also updated to change the label of the button to the text of another group. 
	 * @param let Group instance of Group to displayed
	 * @param pool String either "A" or "B"
	 */
	public void updateGrid(model.Group let,String pool) {
		gpBefore.getChildren().clear();
		gpAfter.getChildren().clear();
		c.getChildren().clear();
		model.Group g = let;
		updateBeforeGrid(g);
		updateMiddle(g);
		updateAfterGrid(g);
		updateTB(pool);
	}
		
	/**
	 * Updates the middle section to accommodate the selected group g. The middle section contains two imageviews linked to two 
	 * combo boxes that contain the team names of the teams in the pool, and labels used to select the match count. Finally, the middle
	 * section includes a submit button that adds the match to the pool and updates the after grid to print the top 3 chances of each team. 
	 * The submit button checks to make sure that the match: is not between the same team, is not missing a team, has a map count, 
	 * has a match winner, and the match had not happened yet.  
	 * @param g Group Group to be illustrated
	 */
	public void updateMiddle(model.Group g) {
		centerColumn.getChildren().clear();
		//centerColumn.setGridLinesVisible(true);
		Label title = new Label("Select a new match");
		title.setTextFill(Color.WHITE);
		title.setStyle("-fx-background-color: black");
		title.setFont(new Font("Courier New",20));
		centerColumn.add(title, 0, 0, 5,1);
		title.setPrefWidth(400);
		title.setAlignment(Pos.CENTER);
		StackPane stackA = new StackPane();
		ImageView testA= new ImageView();
	//	new Image(getClass().getResourceAsStream("LeagueLogo.png"))
		testA.setFitHeight(75);
		testA.setFitWidth(75);
		stackA.getChildren().add(testA);
		stackA.setStyle("-fx-background-color: white");
		stackA.setPadding(new Insets(5));
		centerColumn.add(stackA,0,2);
		
		
		String tA = "Pick Team A";
		
		ComboBox<String> teamA = new ComboBox<String>();
		for(team t: g.getPool()) {
			teamA.getItems().add(t.getName());
		}
		teamA.setValue(tA);
		teamA.setStyle("-fx-font: 15px \"Courier New\";");
		
		//test.setImage(new Image(getClass().getResourceAsStream(teamA.getValue()+".png")));
		
		teamA.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				testA.setImage(new Image(getClass().getResourceAsStream(teamA.getValue()+".png")));
			}
			
		});
		
		centerColumn.add(teamA, 1, 2);
		
		StackPane stackB = new StackPane();
		ImageView testB= new ImageView();
	
		testB.setFitHeight(75);
		testB.setFitWidth(75);
		stackB.getChildren().add(testB);
		stackB.setStyle("-fx-background-color: white");
		stackB.setPadding(new Insets(5));
		centerColumn.add(stackB,0,3);
		
		String tB = "Pick Team B";
		ComboBox<String> teamB = new ComboBox<String>();
		for(team t: g.getPool()) {
			teamB.getItems().add(t.getName());
		}
		teamB.setValue(tB);
		teamB.setStyle("-fx-font: 15px \"Courier New\";");
		
		
		teamB.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				//System.out.println(teamB.getValue());
				testB.setImage(new Image(getClass().getResourceAsStream(teamB.getValue()+".png")));
			}
			
		});
		
		
		centerColumn.add(teamB, 1, 3);
		
		Label aMinus = new Label("-");
		Label aNum = new Label(0+"");
		Label aPlus = new Label("+");
		Label bMinus = new Label("-");
		Label bNum = new Label(0+"");
		Label bPlus = new Label("+");

		
		ArrayList<Label> labels = new ArrayList<Label>();
		labels.add(aMinus);labels.add(aNum);labels.add(aPlus);
		labels.add(bMinus);labels.add(bNum);labels.add(bPlus);
		for(Label l: labels) {
			l.setPadding(new Insets(5));
			l.setTextFill(Color.WHITE);
			l.setStyle("-fx-background-color: black");
			l.setFont(new Font("Courier New",15));
		}
		
		
		for(int r = 2; r<4;r++) {
			for(int c = 2;c<5;c++) {
				if(c==2) {
					if(r==2) {
						centerColumn.add(aMinus, c, r);
						aMinus.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {
								if(Integer.parseInt(aNum.getText())!=0) {
									aNum.setText(Integer.parseInt(aNum.getText())-1 +"");
								}
								
							}
							
						});
					}
					else {
						centerColumn.add(bMinus, c, r);
						bMinus.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {
								if(Integer.parseInt(bNum.getText())!=0) {
									bNum.setText(Integer.parseInt(bNum.getText())-1 +"");
								}
								
							}
							
						});
					}
					
				}
				else if(c==3) {
					if(r==2) {
						centerColumn.add(aNum, c, r);
					}
					else {
						centerColumn.add(bNum, c, r);
					}
				}
				else if(c==4) {
					if(r==2) {
						centerColumn.add(aPlus, c, r);
						aPlus.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {
								
								if(Integer.parseInt(aNum.getText())!=3) {
									aNum.setText(Integer.parseInt(aNum.getText())+1 +"");
									if(Integer.parseInt(aNum.getText())==3&&Integer.parseInt(bNum.getText())==3) {
										bNum.setText(Integer.parseInt(bNum.getText())-1 +"");
									}
								}
							}
							
						});
					}
					else {
						centerColumn.add(bPlus, c, r);
						bPlus.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {
								if(Integer.parseInt(bNum.getText())!=3) {
									bNum.setText(Integer.parseInt(bNum.getText())+1 +"");
									if(Integer.parseInt(bNum.getText())==3&&Integer.parseInt(aNum.getText())==3) {
										aNum.setText(Integer.parseInt(aNum.getText())-1 +"");
									}
								}
								
							}
							
						});
					}
				}
			}
		}
		Button submit = new Button("Submit");
		centerColumn.add(submit, 2, 4,3,1);
		submit.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(teamA.getValue().equals(teamB.getValue())) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("Input not valid");
					errorAlert.setContentText("A team cannot play themselves.");
					errorAlert.showAndWait();
					System.out.println("error");
				}
				else if(teamA.getValue().equals(tA)||teamB.getValue().equals(tB)) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("Input not valid");
					errorAlert.setContentText("Missing Team.");
					errorAlert.showAndWait();
					System.out.println("error");
				}
				else if(Integer.parseInt(aNum.getText()) == 0 && Integer.parseInt(bNum.getText()) == 0) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("Input not valid");
					errorAlert.setContentText("Need a Map Count.");
					errorAlert.showAndWait();
					System.out.println("error");
				}
				else if(Integer.parseInt(aNum.getText()) != 3 && Integer.parseInt(bNum.getText()) != 3) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("Input not valid");
					errorAlert.setContentText("No Winning Team.");
					errorAlert.showAndWait();
					System.out.println("error");
				}
				else if(g.getTeam(teamA.getValue()).findMatch(teamB.getValue()).getMapA() != 0 ||
						g.getTeam(teamA.getValue()).findMatch(teamB.getValue()).getMapB() != 0) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("Input not valid");
					errorAlert.setContentText("Match already played.");
					errorAlert.showAndWait();
					System.out.println("error");
				}
				else {
					//g.updateMatch(teamA.getValue(),teamB.getValue(),Integer.parseInt(aNum.getText()),Integer.parseInt(bNum.getText()),true);
					g.matchImpact(teamA.getValue(),teamB.getValue(),Integer.parseInt(aNum.getText()),Integer.parseInt(bNum.getText()));
					updateAfterGrid(g);
				}
				
				
			}
			
		});
		submit.setFont(new Font("Courier New",15));
		c.add(centerColumn,1,0);
		
		
	}
	
	/**
	 * Updates the content of the before grid on the left with the teams and top three chances of Group g. The teams
	 * are sorted by top three chances from each team's placings value. The grid includes the team logo and name with 
	 * the top three chances. Additionally, there is a title label. 
	 * @param g Group group to be used
	 */
	public void updateBeforeGrid(model.Group g) {
		ArrayList<team> sorted = g.sortByTop3();
		Label beforeTitle = new Label("Top 3% Before Match");
		beforeTitle.setTextFill(Color.WHITE);
		beforeTitle.setStyle("-fx-background-color:black");
		beforeTitle.setAlignment(Pos.CENTER);
		beforeTitle.setFont(new Font("Courier New", 20));
		
		
		gpBefore.add(beforeTitle, 1, 0, 3, 1);
		
		for(int r = 1; r<sorted.size()+1 ; r++) {
			for(int c = 0; c<3;c++) {
				Label test = new Label();
				test.setFont(new Font("Courier New", 15));
				test.setTextFill(Color.WHITE);
				test.setStyle("-fx-background-color: black");
				test.setTextAlignment(TextAlignment.CENTER);
				test.setPadding(new Insets(5));
				test.setPrefHeight(50);
				test.setAlignment(Pos.CENTER);
				
				if(c==0) {
					StackPane stack = new StackPane();
					ImageView logo= new ImageView(new Image(getClass().getResourceAsStream(sorted.get(r-1).getName()+".png")));
					logo.setFitWidth(75);
					logo.setFitHeight(75);

					stack.getChildren().add(logo);
					stack.setStyle("-fx-background-color: white");
					stack.setPadding(new Insets(5));
					gpBefore.add(stack,c,r);
				}
				else if(c==1) {
					test.setText(sorted.get(r-1).getName());
					test.setPrefWidth(150);
					gpBefore.add(test, c, r);
				}
				else if(c==2) {
					
					double top3 = 0;
					for(int i = 0; i<3;i++) {
						top3 = top3 + sorted.get(r-1).getPlacings().get(i);
					}
					test.setText(String.format("%.3f%%", top3/m.getModel().getSimulations()*100));
					test.setPrefWidth(100);
					gpBefore.add(test, c, r);
				}
			}
		}
		c.add(gpBefore,0,0);
	}
	/**
	 * Updates the content of the after grid on the right with the teams and top three chances of Group g. The teams
	 * are sorted by top three chances from each team's placingsSim value. The grid includes the team logo and name 
	 * with the top three chances. Additionally, there is a title label. 
	 * @param g Group group to be used
	 */
	public void updateAfterGrid(model.Group g) {
		ArrayList<team> sorted =g.sortByTop3Sim();
		c.getChildren().remove(gpAfter);
		gpAfter.getChildren().clear();
		Label afterTitle = new Label("Top 3% After Match");
		afterTitle.setTextFill(Color.WHITE);
		afterTitle.setStyle("-fx-background-color:black");
		afterTitle.setAlignment(Pos.CENTER);
		afterTitle.setFont(new Font("Courier New", 20));
		
		afterTitle.setAlignment(Pos.CENTER);
		gpAfter.add(afterTitle, 1, 0, 3, 1);
		
		for(int r = 1; r<g.getPool().size()+1 ; r++) {
			for(int c = 0; c<3;c++) {
				Label test = new Label();
				test.setFont(new Font("Courier New" , 15));
				test.setTextFill(Color.WHITE);
				test.setStyle("-fx-background-color: black");
				test.setTextAlignment(TextAlignment.CENTER);
				test.setPadding(new Insets(5));
				test.setPrefHeight(50);
				test.setAlignment(Pos.CENTER);
				if(c==0) {
					StackPane stack = new StackPane();
					ImageView logo= new ImageView(new Image(getClass().getResourceAsStream(sorted.get(r-1).getName()+".png")));
					logo.setFitWidth(75);
					logo.setFitHeight(75);
					stack.getChildren().add(logo);
					stack.setStyle("-fx-background-color: white");
					stack.setPadding(new Insets(5));
					gpAfter.add(stack,c,r);
				}
				else if(c==1) {
					test.setText(sorted.get(r-1).getName());
					test.setPrefWidth(150);
					gpAfter.add(test, c, r);
				}
				else if(c==2) {
					double top3 = 0;
					for(int i = 0; i<3;i++) {
						top3 = top3 + sorted.get(r-1).getPlacingsSim().get(i);
					}
					test.setText(String.format("%.3f%%", top3/m.getModel().getSimulations()*100));test.setPrefWidth(100);
					gpAfter.add(test, c, r);
				}
			}
		}
		/*
		 * for(int i = 0;i<6;i++) {
		 * System.out.println(m.getModel().getGroupA().getPool().get(i).getName() + " "
		 * + m.getModel().getGroupA().getPoolsim().get(i).getName() ); }
		 */
		c.add(gpAfter,3,0);
	}

	/**
	 * Creates/updates the bottom toolbar which includes a back button to the simulationView and a button that changes
	 * the pool that is displayed. When the pool that is being displayed changes, the button text changes to the name of
	 * the other pool. 
	 * @param pool
	 */
	public void updateTB(String pool) {
		
		
		Button backA = new Button();
		backA.setText("Back to Simulation results");
		backA.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Back Simulations");
				stage.setScene(m.getScenes().get(StageName.SIMULATION));
				
				
			}
		});
		backA.setPrefSize(300, 50);
		backA.setFont(new Font("Courier New",15));

		Region emptyCenter = new Region();
		HBox.setHgrow(emptyCenter, Priority.ALWAYS);
		Button toB = new Button();
		toB.setText("Group " + pool);
		toB.setOnAction(new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent event) {
				if(toB.getText().equals("Group B")) {
					toB.setText("Group A");
					m.getModel().getGroupB().resetPlacingSim();
					updateGrid(m.getModel().getGroupB(),"A");
					
				}
				else {
					toB.setText("Group B");
					m.getModel().getGroupA().resetPlacingSim();
					updateGrid(m.getModel().getGroupA(),"B");
				}
				
				
			}
		});
		toB.setPrefSize(100, 50);
		toB.setFont(new Font("Courier New",15));
		
		tb = new ToolBar(backA, emptyCenter,toB);
		
		layout.setBottom(tb);
		tb.setStyle("-fx-background-color: transparent");
		
		
		
	}
	
	



	
}