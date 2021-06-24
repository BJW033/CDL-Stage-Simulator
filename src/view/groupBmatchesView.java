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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.StageName;

public class groupBmatchesView extends View{
	Main m;

	GridPane matches;
	BorderPane layout;
	Label top;
	public groupBmatchesView(Stage primaryStage, Main main) {
		this.stage = primaryStage;
		m=main;
		layout = new BorderPane();
		ToolBar toolbar = createTB();

		layout.setBottom(toolbar);
		matches = generateGP();
		
		layout.setCenter(matches);
		
		top = createTop();
		layout.setTop(top);
		
		BorderPane.setAlignment(top, Pos.CENTER);
		BorderPane.setAlignment(matches, Pos.TOP_CENTER);
		
		StackPane root = new StackPane();
		
		root.getChildren().add(layout);
		//primaryStage.setScene(new Scene(root, canvasWidth, canvasHeight));

		scene = new Scene(root, canvasWidth, canvasHeight);
		
		
		
	}
	private GridPane generateGP() {
		GridPane gp = new GridPane();
		m.getModel().getGroupB().printPool();
		int count = 1;
		
			for(int r=0;r<14;r++) {
				
					if(r%3==2) {
						Label t = new Label();
						t.setText("");
						gp.add(t, 0, r);
					}

					else if(r%3==1) {
						Label t = new Label();
						t.setText(m.getModel().getGroupB().getPool().get(count).getName());
						gp.add(t, 0, r);
						count++;
					}
					else {
						Label t = new Label();
						t.setText(m.getModel().getGroupB().getPool().get(0).getName());
						gp.add(t, 0, r);
					}
			
	
		}
		
		
		return gp;
	}
	
	public void updateGP() {
		
		
		GridPane gp = matches;
		gp.getChildren().retainAll(gp.getChildren().get(0));
		gp.setHgap(10);
		matches.getChildren().clear();
		m.getModel().getGroupB().printPool();
		//gp.setGridLinesVisible(true);
		gp.setPadding(new Insets(20));
		gp.setAlignment(Pos.TOP_CENTER);
		int count = 1;
		String s = "";
		for(int r = 0; r<9;r++) {
			for(int c = 0; c<25;c++) {
				Label t = new Label();
				
				t.setAlignment(Pos.CENTER);
				t.setTextAlignment(TextAlignment.CENTER);
				if(c==0) {
					s="";
					t.setText(s);
					t.setUserData(s);
					gp.add(t, c, r);
				}
				else if(r==0) {
					if(c==1 || c==6 || c==11||c==16||c==21) {
						s=m.getModel().getGroupB().getPool().get(r).getName();
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
					}
				}
				else if(r==1) {
					if(c==1 || c==6 || c==11||c==16||c==21) {
						s=m.getModel().getGroupB().getPool().get(count).getName();
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
						count++;
					}
					if(c==21) {
						count=2;
					}
				}
				else if(r==3) {
					if(c==1 || c==6 || c==11||c==16) {
						s=m.getModel().getGroupB().getPool().get(r%2).getName();
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
					}
					if(c==21) {
						s=m.getModel().getGroupB().getPool().get(2).getName();
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
					}
				}
				else if(r==4) {
					
					if(c==1 || c==6 || c==11||c==16) {
						s=m.getModel().getGroupB().getPool().get(count).getName();
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
						count++;
					}
					if(c==21) {
						count=3;
						s=m.getModel().getGroupB().getPool().get(count).getName();
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
						count++;
					}
				}
				else if(r==6) {
					
					if(c==1 || c==6 ) {
						s=m.getModel().getGroupB().getPool().get(2).getName();
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
					}
					if(c==11||c==16) {
						s=m.getModel().getGroupB().getPool().get(3).getName();
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
					}
					if(c==21) {
						s=m.getModel().getGroupB().getPool().get(4).getName();
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
					}
				}
				else if(r==7) {
					
					if(c==1 || c==6 ) {
						s=m.getModel().getGroupB().getPool().get(count).getName();
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
						count++;
					}
					if(c==11||c==16) {
						if(c==11) {
							count=4;
						}
						s=m.getModel().getGroupB().getPool().get(count).getName();
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
						count++;
					}
					if(c==21) {
						count=5;
						s=m.getModel().getGroupB().getPool().get(count).getName();
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
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
						
						gp.add(t, c, r);
						
						t.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {
								int i =0;
								for(Node l: gp.getChildren()) {
									if(l.getUserData().equals("(" + row + "," + column + ") -")){
										break;
									}
									i++;
								}
								Label mc = (Label) (((Labeled) gp.getChildren().get(i+1)));
								int mapcur = Integer.parseInt((((Labeled) gp.getChildren().get(i+1)).getText()));
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
							String teamA = (String) gp.getChildren().get(gp.getChildren().size()-27).getUserData();
							String teamB = (String) gp.getChildren().get(gp.getChildren().size()-2).getUserData();
							//System.out.println(teamA + " " + teamB);
							String teamAMap = m.getModel().getGroupB().getTeam(teamA).findMatch(teamB).getMapA()+"";
							((Label) gp.getChildren().get(gp.getChildren().size()-25)).setText(teamAMap);
							((Label) gp.getChildren().get(gp.getChildren().size()-25)).setUserData(teamAMap);
							s = m.getModel().getGroupB().getTeam(teamA).findMatch(teamB).getMapB()+"";
						}
						
						t.setText(s);
						t.setUserData(s);
						gp.add(t, c, r);
					}
					if(c==4 || c==9 || c==14 ||c==19||c==24) {
						s="+";
						t.setText(s);
						t.setUserData("(" + r + "," + c + ") +");
						gp.add(t, c, r);
						int column = c;
						int row = r;
						t.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {
								int i =0;
								for(Node l: gp.getChildren()) {
									if(l.getUserData().equals("(" + row + "," + column + ") +")){
										break;
									}
									i++;
								}
								Label mc = (Label) (((Labeled) gp.getChildren().get(i-1)));
								int mapcur = Integer.parseInt((((Labeled) gp.getChildren().get(i-1)).getText()));
								//System.out.println(row + ", " + column);
								Label mc2 = findOppenent(row,column,i);
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
						gp.add(t, c, r);
					}
					
				}
			}
		}
		//int index = 0;
//		while (index<gp.getChildren().size()) {
//			System.out.println(index + ": " + gp.getChildren().get(index).getUserData());
//			index++;
//		}
		
		
	
	}
	public ToolBar createTB() {
		Button back = new Button();
		back.setText("Group A");
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("back to A");
				stage.setScene(m.getScenes().get(StageName.MATCHESA));
				m.getGroupAmatches().updateGP();
				m.getModel().getGroupA().resetMatches();
				
				
			}
		});
		back.setPrefSize(100, 50);
		
		Button toB = new Button();
		toB.setText("To simulation results:");
		toB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("sim");
				if(updateMatches()) {
					//m.getModel().getGroupB().printAllMatches();
					stage.setScene(m.getScenes().get(StageName.SIMULATION));
				//	m.getModel().getGroupA().setSimulations(100000);
					//m.getModel().getGroupB().setSimulations(100000);
					m.getModel().setSimulations(100000);
					m.getModel().getGroupA().simulateMatches(m.getModel().getGroupA(), false);
					m.getModel().getGroupA().sortStandings(m.getModel().getGroupA().getPool());
					m.getModel().getGroupB().simulateMatches(m.getModel().getGroupB(), false);
					m.getSim().updateGrid(m.getModel().getGroupA());
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
		toB.setPrefSize(200, 50);
		
		
		Region emptyCenter = new Region();
		HBox.setHgrow(emptyCenter, Priority.ALWAYS);

		
		return new ToolBar(back,emptyCenter,toB);
	}
	
	public Label createTop() {
		Label l = new Label("Group B");
		l.setPadding(new Insets(20));
		l.setAlignment(Pos.CENTER);
		l.setTextAlignment(TextAlignment.CENTER);
		return l;
	}
	
	
	private Label findOppenent(int r, int c, int index) {
		if(r%3==0) {
			return (Label) matches.getChildren().get(index+24);
		}
		else {
			return (Label) matches.getChildren().get(index-26);
		}
	}
	
	boolean updateMatches() {
		for(int mult = 0; mult<3; mult++) {
			for(int i = 3; i<25;i+=5) {
				String teamA = (String) matches.getChildren().get((mult*51) + i-2).getUserData();
				String teamB = (String) matches.getChildren().get((mult*51) + i+23).getUserData();
				int mA = Integer.parseInt((String) matches.getChildren().get((mult*51) + i).getUserData());
				int mB = Integer.parseInt((String) matches.getChildren().get((mult*51) + i+25).getUserData());
				if(mA == 3 || mB ==3 ) {
					
					m.getModel().getGroupB().updateMatch(teamA, teamB, mA, mB, false);
				}
				else if(mA == 0 && mB == 0) {
					
				}
				else {
					return false;
				}
			//	System.out.println(matches.getChildren().get((mult*51) + i-2).getUserData() + " " + matches.getChildren().get((mult*51) + i).getUserData() + " - " + 
	//		matches.getChildren().get((mult*51) + i+25).getUserData() + " " + matches.getChildren().get((mult*51) + i+23).getUserData());
			}
		}
		
		
		//m.getModel().getGroupB().updateMatch(teamA, teamB, mapAw, mapBw, recent);
		
		return true;
	}
}
