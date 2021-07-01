package view;

import controller.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.StageName;

/**
 * groupAmatchesView provides the user the ability to add match results to the simulation. 
 * @author bwu
 *
 */
public class groupAmatchesView extends View{
	private Main m;
	private GridPane matches;
	private BorderPane layout;
	private Label top;
	/**
	 * Builds the UI of the groupAmatchesView. This scene uses a grid of team calling cards to represent matches and gives the user the ability 
	 * to select match counts with "+" and "-." The scene also includes a navigation toolbar that can send the user back to groupView
	 * or forward to groupBmatchesView.
	 * @param primaryStage Stage used for view
	 * @param main Main used to get Model information of the teams in the pool
	 */
	public groupAmatchesView(Stage primaryStage, Main main) {
		this.stage = primaryStage;
		m=main;
		layout = new BorderPane();
		ToolBar toolbar = createTB();

		layout.setBottom(toolbar);
		toolbar.setStyle("-fx-background-color: transparent");
		
		matches = generateGP();
		matches.setHgap(7);
		matches.setVgap(10);
		matches.setPadding(new Insets(20));
		matches.setAlignment(Pos.TOP_CENTER);
		
		layout.setCenter(matches);
		
		top = createTop();
		layout.setTop(top);
		
		BorderPane.setAlignment(top, Pos.CENTER);
		BorderPane.setAlignment(matches, Pos.TOP_CENTER);
		
		StackPane root = new StackPane();
		
		root.getChildren().add(layout);
		BackgroundImage myBI= new BackgroundImage(new Image(getClass().getResourceAsStream("2020Trophy.jpeg"),canvasWidth,canvasHeight,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));
		//primaryStage.setScene(new Scene(root, canvasWidth, canvasHeight));

		scene = new Scene(root, canvasWidth, canvasHeight);
		
		
		
	}
	/**
	 * Creates the basic grid for match updates by filling in the names of the pool. This is always updated. 
	 * @return GridPane basic grid for updates
	 */
	private GridPane generateGP() {
		GridPane gp = new GridPane();
		//m.getModel().getGroupA().printPool();
		int count = 1;
		
			for(int r=0;r<14;r++) {
				
					if(r%3==2) {
						Label t = new Label();
						t.setText("");
						gp.add(t, 0, r);
					}

					else if(r%3==1) {
						Label t = new Label();
						t.setText(m.getModel().getGroupA().getPool().get(count).getName());
						gp.add(t, 0, r);
						count++;
					}
					else {
						Label t = new Label();
						t.setText(m.getModel().getGroupA().getPool().get(0).getName());
						gp.add(t, 0, r);
					}
			
	
		}
		
		
		return gp;
	}
	/**
	 * Clears the contents of the grid first. Builds the grid by row filling in each column in the pattern: SPACE, Calling Card, 
	 * "-", MapWins, "+", SPACE. This pattern is repeated five times per row. There are two space rows between the three sets of matches. 
	 * The "-" labels decrease the map count if above zero. "+" labels increase map count if below three. If the other team already had three 
	 * map wins, then the label of the other team becomes two while the team with the "+" becomes three. The map counts are saved in the 
	 * user data of each label. 
	 */
	public void updateGP() {
		
		matches.getChildren().clear();
		int count = 1;
		String s = "";
		for(int r = 0; r<9;r++) {
			for(int c = 0; c<25;c++) {
				Label t = new Label();
				t.setTextFill(Color.WHITE);
				t.setFont(new Font("Courier New",12));
				t.setStyle("-fx-background-color: BLACK");
				t.setAlignment(Pos.CENTER);
				t.setTextAlignment(TextAlignment.CENTER);
				if(c==0) {
					s="";
					t.setText(s);
					t.setUserData(s);
					t.setStyle("-fx-background-color: transparent");
					matches.add(t, c, r);
				}
				else if(r==0) {
					if(c==1 || c==6 || c==11||c==16||c==21) {
						s=m.getModel().getGroupA().getPool().get(r).getName();
						ImageView callingCard = new ImageView(
								new Image(getClass().getResourceAsStream(s+ "CC.png")));
						callingCard.setFitHeight(25);
						callingCard.setFitWidth(100);
						callingCard.setUserData(s);
						matches.add(callingCard, c, r);
					}
				}
				else if(r==1) {
					if(c==1 || c==6 || c==11||c==16||c==21) {
						s=m.getModel().getGroupA().getPool().get(count).getName();
						ImageView callingCard = new ImageView(
								new Image(getClass().getResourceAsStream(s+ "CC.png")));
						callingCard.setFitHeight(25);
						callingCard.setFitWidth(100);
						callingCard.setUserData(s);
						matches.add(callingCard, c, r);
						count++;
					}
					if(c==21) {
						count=2;
					}
				}
				else if(r==3) {
					if(c==1 || c==6 || c==11||c==16) {
						s=m.getModel().getGroupA().getPool().get(r%2).getName();
						ImageView callingCard = new ImageView(
								new Image(getClass().getResourceAsStream(s+ "CC.png")));
						callingCard.setFitHeight(25);
						callingCard.setFitWidth(100);
						callingCard.setUserData(s);
						matches.add(callingCard, c, r);
						
						
						
					}
					if(c==21) {
						s=m.getModel().getGroupA().getPool().get(2).getName();
						ImageView callingCard = new ImageView(
								new Image(getClass().getResourceAsStream(s+ "CC.png")));
						callingCard.setFitHeight(25);
						callingCard.setFitWidth(100);
						callingCard.setUserData(s);
						matches.add(callingCard, c, r);
						
						
					}
				}
				else if(r==4) {
					
					if(c==1 || c==6 || c==11||c==16) {
						s=m.getModel().getGroupA().getPool().get(count).getName();
						ImageView callingCard = new ImageView(
								new Image(getClass().getResourceAsStream(s+ "CC.png")));
						callingCard.setFitHeight(25);
						callingCard.setFitWidth(100);
						callingCard.setUserData(s);
						matches.add(callingCard, c, r);
						count++;
					}
					if(c==21) {
						count=3;
						s=m.getModel().getGroupA().getPool().get(count).getName();
						ImageView callingCard = new ImageView(
								new Image(getClass().getResourceAsStream(s+ "CC.png")));
						callingCard.setFitHeight(25);
						callingCard.setFitWidth(100);
						callingCard.setUserData(s);
						matches.add(callingCard, c, r);
						count++;
					}
				}
				else if(r==6) {
					
					if(c==1 || c==6 ) {
						s=m.getModel().getGroupA().getPool().get(2).getName();
						ImageView callingCard = new ImageView(
								new Image(getClass().getResourceAsStream(s+ "CC.png")));
						callingCard.setFitHeight(25);
						callingCard.setFitWidth(100);
						callingCard.setUserData(s);
						matches.add(callingCard, c, r);
						
						
						
					}
					if(c==11||c==16) {
						s=m.getModel().getGroupA().getPool().get(3).getName();
						ImageView callingCard = new ImageView(
								new Image(getClass().getResourceAsStream(s+ "CC.png")));
						callingCard.setFitHeight(25);
						callingCard.setFitWidth(100);
						callingCard.setUserData(s);
						matches.add(callingCard, c, r);
						
						
						
					}
					if(c==21) {
						s=m.getModel().getGroupA().getPool().get(4).getName();
						ImageView callingCard = new ImageView(
								new Image(getClass().getResourceAsStream(s+ "CC.png")));
						callingCard.setFitHeight(25);
						callingCard.setFitWidth(100);
						callingCard.setUserData(s);
						matches.add(callingCard, c, r);
					}
				}
				else if(r==7) {
					
					if(c==1 || c==6 ) {
						s=m.getModel().getGroupA().getPool().get(count).getName();
						ImageView callingCard = new ImageView(
								new Image(getClass().getResourceAsStream(s+ "CC.png")));
						callingCard.setFitHeight(25);
						callingCard.setFitWidth(100);
						callingCard.setUserData(s);
						matches.add(callingCard, c, r);
						count++;
					}
					if(c==11||c==16) {
						if(c==11) {
							count=4;
						}
						s=m.getModel().getGroupA().getPool().get(count).getName();
						ImageView callingCard = new ImageView(
								new Image(getClass().getResourceAsStream(s+ "CC.png")));
						callingCard.setFitHeight(25);
						callingCard.setFitWidth(100);
						callingCard.setUserData(s);
						matches.add(callingCard, c, r);
						count++;
					}
					if(c==21) {
						count=5;
						s=m.getModel().getGroupA().getPool().get(count).getName();
						ImageView callingCard = new ImageView(
								new Image(getClass().getResourceAsStream(s+ "CC.png")));
						callingCard.setFitHeight(25);
						callingCard.setFitWidth(100);
						callingCard.setUserData(s);
						matches.add(callingCard, c, r);
					}
				}
				if(r%3!=2) {
					t.setPadding(new Insets(10));
					if(c==2 || c==7 || c==12 ||c==17||c==22) {
						s="-";
						
						t.setText(s);
						t.setUserData("(" + r + "," + c + ") -");
						int column = c;
						int row = r;
						
						matches.add(t, c, r);
						
						t.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {
								int i =0;
								for(Node l: matches.getChildren()) {
									if(l.getUserData().equals("(" + row + "," + column + ") -")){
										break;
									}
									i++;
								}
								Label mc = (Label) (((Labeled) matches.getChildren().get(i+1)));
								int mapcur = Integer.parseInt((((Labeled) matches.getChildren().get(i+1)).getText()));
								//System.out.println(row + ", " + column);
								
								if(mapcur!=0) {
									mc.setText(mapcur-1+"");
									mc.setUserData(mapcur-1+"");
								}
								
								
								
							}
							
						});
						
					}
					if(c==3 || c==8 || c==13 ||c==18||c==23) {
						s = 0+"";
						if(r%3==1) {
							String teamA = (String) matches.getChildren().get(matches.getChildren().size()-27).getUserData();
							String teamB = (String) matches.getChildren().get(matches.getChildren().size()-2).getUserData();
							//System.out.println(teamA + " " + teamB);
							String teamAMap = m.getModel().getGroupA().getTeam(teamA).findMatch(teamB).getMapA()+"";
							((Label) matches.getChildren().get(matches.getChildren().size()-25)).setText(teamAMap);
							((Label) matches.getChildren().get(matches.getChildren().size()-25)).setUserData(teamAMap);
							s = m.getModel().getGroupA().getTeam(teamA).findMatch(teamB).getMapB()+"";
						}
						
						t.setText(s);
						t.setUserData(s);
						matches.add(t, c, r);
					}
					if(c==4 || c==9 || c==14 ||c==19||c==24) {
						s="+";
						t.setText(s);
						t.setUserData("(" + r + "," + c + ") +");
						matches.add(t, c, r);
						int column = c;
						int row = r;
						t.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {
								int i =0;
								for(Node l: matches.getChildren()) {
									if(l.getUserData().equals("(" + row + "," + column + ") +")){
										break;
									}
									i++;
								}
								Label mc = (Label) (((Labeled) matches.getChildren().get(i-1)));
								int mapcur = Integer.parseInt((((Labeled) matches.getChildren().get(i-1)).getText()));
								//System.out.println(row + ", " + column);
								Label mc2 = findOpponent(row,column,i);
								int mapcur2 = Integer.parseInt((String) mc2.getUserData());
								if(mapcur<3) {
									if(mapcur==2 && mapcur2==3) {
										mc2.setText(mapcur2-1+"");
										mc2.setUserData(mapcur2-1+"");
									}
									mc.setText(mapcur+1+"");
									mc.setUserData(mapcur+1+"");
								}
								
								
								
								
							}
							
						});
					}
					if(c==5 || c==10 || c==15 ||c==20) {
						s = "";
						t.setText(s);
						t.setUserData(s);
						t.setStyle("-fx-background-color: transparent");
						matches.add(t, c, r);
					}
					
				}
			}
		}
		
//		while (index<matches.getChildren().size()) {
//			System.out.println(index + ": " + matches.getChildren().get(index).getUserData());
//			index++;
//		}
		for(int r=2;r<6;r+=3) {
			Label l = new Label();
			l.setPrefHeight(40);
			matches.add(l, 0, r);
		}
	
	
	}
	
	/**
	 * Creates the navigation bar. The back button sends the user back to the group selection page and resets the 
	 * opacity of all logos back to 0.5. The "Group B" button takes the user to groupBmatchesView which is identical to 
	 * the groupAmatchesView but with Group B. The "Group B" button also iterates through the matches of the grid and checks to 
	 * see if an updated match has a winner or if the map count is zero-zero. If a match does not have a winner but does have a map
	 * count, an error box appears alerting the user a match is not complete and keeps the scene the same until the problem 
	 * is remedied by the user. 
	 * @return ToolBar navigation bar. 
	 */
	public ToolBar createTB() {
		Button back = new Button();
		back.setText("Back to Group Selection");
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("back to groups");
				stage.setScene(m.getScenes().get(StageName.GROUPSELECTION));
				m.getGroupA().clear();
				m.getGroupB().clear();
				for(int i = 0; i<12;i++) {
					m.getGroupView().getGp().getChildren().get(i).setStyle("-fx-opacity: 0.5;");
					
				}
				
			}
		});
		back.setPrefSize(250, 50);
		back.setFont(new Font("Courier New",15));
		Button toB = new Button();
		toB.setText("Group B");
		toB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				if(updateMatches()) {
					//m.getModel().getGroupA().printPlayedMatches();
					System.out.println("To Group B matches");
					stage.setScene(m.getScenes().get(StageName.MATCHESB));
				}
				else {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("Input not valid");
					errorAlert.setContentText("One match with a map count does not have a winner.");
					errorAlert.showAndWait();
					System.out.println("error");
				}
				
				
			}
		});
		toB.setPrefSize(100, 50);
		toB.setFont(new Font("Courier New",15));
		
		
		Region emptyCenter = new Region();
		HBox.setHgrow(emptyCenter, Priority.ALWAYS);

		
		return new ToolBar(back,emptyCenter,toB);
	}
	
	/**
	 * Creates the title label of the scene
	 * @return Label title of the scene
	 */
	public Label createTop() {
		Label l = new Label("Update the matches for Group A");
		l.setTextFill(Color.WHITE);
		l.setStyle("-fx-background-color: black");
		l.setFont(new Font("Courier New",25));
		l.setPadding(new Insets(20));
		l.setAlignment(Pos.CENTER);
		l.setTextAlignment(TextAlignment.CENTER);
		return l;
	}
	
	/**
	 * Called by updateGP() in the handle of clicking "+" labels while adding maps to a match in order to determine if the 
	 * other team already had three map wins. Used to create the dynamic effect of the map update process by returning the 
	 * Label of the other team's map count. 
	 * @param r int row number of "+" label
	 * @param c int column number of "+" label
	 * @param index int index of "+" label in gp.getChildren()
	 * @return
	 */
	private Label findOpponent(int r, int c, int index) {
		int topTeam = 24;
		int bottomTeam = 26;
		if(r%3==0) {
			return (Label) matches.getChildren().get(index+topTeam);
		}
		else {
			return (Label) matches.getChildren().get(index-bottomTeam);
		}
	}
	/**
	 * Function is called in the button to navigate to Group B is clicked. The function iterates through the grid of matches going from
	 * map count to map count. If there is a match winner, the Group is updated, if there is no map count, the iteration continues, and 
	 * if neither of these are true, false is returned which creates the alert box to show. 
	 * @return false if there is a map count but no winner, true otherwise
	 */
	private boolean updateMatches() {
		int mapWins = 3;
		int noContest = 0;
		
		int toTeamName = 2;
		int toOppName = 23;
		int toOppMap = 25;
		
		int indexOfMapValue = 51;
		//mult represents the group of matches 
		for(int mult = 0; mult<3; mult++) {
			// i represents the index of the map count value of the team of the top row of the group of matches
			for(int i = 3; i<25;i+=5) {
				String teamA = (String) matches.getChildren().get((mult*indexOfMapValue) + i-toTeamName).getUserData();
				String teamB = (String) matches.getChildren().get((indexOfMapValue) + i+toOppName).getUserData();
				int mA = Integer.parseInt((String) matches.getChildren().get((mult*indexOfMapValue) + i).getUserData());
				int mB = Integer.parseInt((String) matches.getChildren().get((mult*indexOfMapValue) + i+toOppMap).getUserData());
				if(mA == mapWins || mB ==mapWins ) {
					
					m.getModel().getGroupA().updateMatch(teamA, teamB, mA, mB, false);
				}
				else if(mA == noContest && mB == noContest) {
					
				}
				else {
					return false;
				}
			}
		}
		
		return true;
	}
}
