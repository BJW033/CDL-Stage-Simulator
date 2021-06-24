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

public class addToGroupView extends View{
	
	Main m; 
	GridPane gpBefore;
	GridPane centerColumn;
	GridPane gpAfter;
	BorderPane layout;
	ToolBar tb;
	TilePane top;
	GridPane c;
	
	public addToGroupView(Stage primaryStage, Main main) {
		this.stage = primaryStage;
		m=main;
		gpBefore=new GridPane();
		gpBefore.setAlignment(Pos.CENTER);
		gpAfter=new GridPane();
		gpAfter.setAlignment(Pos.CENTER);
		centerColumn = new GridPane();
		centerColumn.setAlignment(Pos.CENTER);
		c = new GridPane();
		c.setHgap(25);
		c.setAlignment(Pos.CENTER);
		
		tb = createTB();
		layout = new BorderPane();
		
		layout.setBottom(tb);
		
		
		
		updateGrid(m.getModel().getGroupA());
		
		
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
		
		scene = new Scene(root,canvasWidth,canvasHeight);
		c.setGridLinesVisible(true);
		
	}
	
	public void updateGrid(model.Group let) {
		gpBefore.getChildren().clear();
		gpAfter.getChildren().clear();
		c.getChildren().clear();
		model.Group g = let;
		updateBeforeGrid(g);
		updateMiddle(g);
		updateAfterGrid(g);

	}
		
	
	public void updateMiddle(model.Group g) {
		centerColumn.getChildren().clear();
		//centerColumn.setGridLinesVisible(true);
		Label title = new Label("Select a new match");
		
		centerColumn.add(title, 1, 0, 5,1);
		
		title.setAlignment(Pos.CENTER);
		StackPane stackA = new StackPane();
		ImageView testA= new ImageView();
	//	new Image(getClass().getResourceAsStream("LeagueLogo.png"))
		testA.setFitHeight(75);
		testA.setFitWidth(75);
		stackA.getChildren().add(testA);
		stackA.setPadding(new Insets(5));
		centerColumn.add(stackA,0,2);
		
		
		String tA = "Pick Team A";
		ComboBox<String> teamA = new ComboBox<String>();
		for(team t: g.getPool()) {
			teamA.getItems().add(t.getName());
		}
		teamA.setValue(tA);
		
		//test.setImage(new Image(getClass().getResourceAsStream(teamA.getValue()+".png")));
		
		teamA.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				//System.out.println(teamA.getValue());
				//stack.getChildren().clear();
				testA.setImage(new Image(getClass().getResourceAsStream(teamA.getValue()+".png")));
				//stack.getChildren().add(test);
				//System.out.println(stack.getChildren());
			}
			
		});
		
		centerColumn.add(teamA, 1, 2);
		
		StackPane stackB = new StackPane();
		ImageView testB= new ImageView();
	//	new Image(getClass().getResourceAsStream("LeagueLogo.png"))
		testB.setFitHeight(75);
		testB.setFitWidth(75);
		stackB.getChildren().add(testB);
		stackB.setPadding(new Insets(5));
		centerColumn.add(stackB,0,3);
		
		String tB = "Pick Team B";
		ComboBox<String> teamB = new ComboBox<String>();
		for(team t: g.getPool()) {
			teamB.getItems().add(t.getName());
		}
		teamB.setValue(tB);
		
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
		
		aMinus.setPadding(new Insets(5));
		aNum.setPadding(new Insets(5));
		aPlus.setPadding(new Insets(5));
		bMinus.setPadding(new Insets(5));
		bNum.setPadding(new Insets(5));
		bPlus.setPadding(new Insets(5));
		
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
		
		c.add(centerColumn,1,0);
		
		
	}
	
	
	
	
	
	
	
	public void updateBeforeGrid(model.Group g) {
		ArrayList<team> sorted = g.sortByTop3();
		Label beforeTitle = new Label("Top 3% Before Match");
		beforeTitle.setAlignment(Pos.CENTER);
		gpBefore.add(beforeTitle, 1, 0, 3, 1);
		
		for(int r = 1; r<sorted.size()+1 ; r++) {
			for(int c = 0; c<3;c++) {
				if(c==0) {
					StackPane stack = new StackPane();
					ImageView test= new ImageView(new Image(getClass().getResourceAsStream(sorted.get(r-1).getName()+".png")));
					test.setFitWidth(75);
					test.setFitHeight(75);

					stack.getChildren().add(test);
					stack.setPadding(new Insets(5));
					gpBefore.add(stack,c,r);
				}
				else if(c==1) {
					Label test = new Label();
					test.setText(sorted.get(r-1).getName());
					test.setFont(new Font(20));
					test.setTextAlignment(TextAlignment.CENTER);
					test.setPadding(new Insets(5));
					test.setPrefHeight(50);
					test.setPrefWidth(100);
					test.setAlignment(Pos.CENTER);
					gpBefore.add(test, c, r);
				}
				else if(c==2) {
					Label test = new Label();
					double top3 = 0;
					for(int i = 0; i<3;i++) {
						top3 = top3 + sorted.get(r-1).getPlacings().get(i);
					}
					test.setText(String.format("%.3f%%", top3/m.getModel().getSimulations()*100));
					test.setTextAlignment(TextAlignment.CENTER);
					test.setPadding(new Insets(5));
					test.setPrefHeight(50);
					test.setPrefWidth(100);
					test.setAlignment(Pos.CENTER);
					gpBefore.add(test, c, r);
				}
			}
		}
		c.add(gpBefore,0,0);
	}
	
	public void updateAfterGrid(model.Group g) {
		ArrayList<team> sorted =g.sortByTop3Sim();
		c.getChildren().remove(gpAfter);
		gpAfter.getChildren().clear();
		Label beforeTitle = new Label("Top 3% After Match");
		beforeTitle.setAlignment(Pos.CENTER);
		gpAfter.add(beforeTitle, 1, 0, 3, 1);
		
		for(int r = 1; r<g.getPool().size()+1 ; r++) {
			for(int c = 0; c<3;c++) {
				if(c==0) {
					StackPane stack = new StackPane();
					ImageView test= new ImageView(new Image(getClass().getResourceAsStream(sorted.get(r-1).getName()+".png")));
					test.setFitWidth(75);
					test.setFitHeight(75);

					stack.getChildren().add(test);
					stack.setPadding(new Insets(5));
					gpAfter.add(stack,c,r);
				}
				else if(c==1) {
					Label test = new Label();
					test.setText(sorted.get(r-1).getName());
					test.setFont(new Font(20));
					test.setTextAlignment(TextAlignment.CENTER);
					test.setPadding(new Insets(5));
					test.setPrefHeight(50);
					test.setPrefWidth(100);
					test.setAlignment(Pos.CENTER);
					gpAfter.add(test, c, r);
				}
				else if(c==2) {
					Label test = new Label();
					double top3 = 0;
					for(int i = 0; i<3;i++) {
						top3 = top3 + sorted.get(r-1).getPlacings2().get(i);
					}
					test.setText(String.format("%.3f%%", top3/m.getModel().getSimulations()*100));
					test.setTextAlignment(TextAlignment.CENTER);
					test.setPadding(new Insets(5));
					test.setPrefHeight(50);
					test.setPrefWidth(100);
					test.setAlignment(Pos.CENTER);
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

	
	
	
	public ToolBar createTB() {
		Button backA = new Button();
		backA.setText("Back to Simulation results");
		backA.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Back Simulations");
				stage.setScene(m.getScenes().get(StageName.SIMULATION));
				
				
			}
		});
		backA.setPrefSize(200, 50);
		

		Region emptyCenter = new Region();
		HBox.setHgrow(emptyCenter, Priority.ALWAYS);
		Button toB = new Button();
		toB.setText("Group B");
		toB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(toB.getText().equals("Group B")) {
					toB.setText("Group A");
					m.getModel().getGroupB().resetSims2();
					updateGrid(m.getModel().getGroupB());
					
				}
				else {
					toB.setText("Group B");
					m.getModel().getGroupA().resetSims2();
					updateGrid(m.getModel().getGroupA());
				}
				
				
			}
		});
		toB.setPrefSize(100, 50);
		
		return new ToolBar(backA,emptyCenter,toB);
	}
	
	



	
}