package view;


import controller.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Group;
import model.StageName;
/**
 * groupView is used when the user wants to manually select the teams in each pool. groupView class sets up the toolbar for navigation and
 * the grid of images of team selection. The construction of the UI is broken into different methods.
 * @author bwu
 *
 */
public class groupView extends View{
	private Main m;
	private int selected = 0;
	private GridPane gp;
	/**
	 * Builds the UI for the groupView including a grid and a toolbar for navigation, places them in borderpane. Sets up background image. 
	 * @param primaryStage Stage used as active stage for UI
	 * @param main Main used to transfer selected teams into respective pools and update groupAmatchesView and groupBmatchesView
	 */
	public groupView(Stage primaryStage,Main main) {
		this.stage = primaryStage;
		m = main;
		stage.setResizable(false);
		stage.sizeToScene();
		primaryStage.setTitle("Group Simulator");
		BorderPane borderPane = new BorderPane();
		ToolBar toolbar = createTB();

		borderPane.setBottom(toolbar);
		Label t = generateTop();
		t.setAlignment(Pos.CENTER);
		borderPane.setTop(t);

		BorderPane.setAlignment(t, Pos.CENTER);
		gp = new GridPane();
		updateGP();

		borderPane.setCenter(gp);



		StackPane root = new StackPane();
		BackgroundImage myBI= new BackgroundImage(new Image(getClass().getResourceAsStream("GroupSelectionBG.png"),canvasWidth,canvasHeight,false,true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		//then you set to your node
		root.setBackground(new Background(myBI));
		root.getChildren().add(borderPane);
		//primaryStage.setScene(new Scene(root, canvasWidth, canvasHeight));

		scene = new Scene(root, canvasWidth, canvasHeight);
	}

	/**
	 * Creates grid of team images by iterating through the list of teams from the Model (received from Main). Each of the images
	 * are set to lower opacities until selected by user, then the opacities are reset. Once six teams are selected, the 
	 * scene is set to groupAmatchesView. The grid is iterated through and selected teams are placed in Group A 
	 * and the rest populate Group B
	 */
	public void updateGP() {
		gp.getChildren().clear();
		gp.setHgap(20);
		gp.setVgap(20);
		int count = 0;

		for (int i = 0; i < 3; i++) {
			for(int y = 0 ; y<4;y++) {
				StackPane stack = new StackPane();
				ImageView test= new ImageView(new Image(getClass().getResourceAsStream(m.getModel().getTeams().get(count)+".png")));
				stack.getChildren().add(test);
				stack.setUserData(m.getModel().getTeams().get(count));
				stack.setAlignment(Pos.CENTER);
				stack.setStyle("-fx-opacity: 0.5;");

				stack.setOnMouseClicked(new EventHandler<MouseEvent>(){

					@Override
					public void handle(MouseEvent event) {


						Node n = (Node) event.getSource();
						if (n.getStyle().equals("-fx-opacity: 1.0;")) {
							n.setStyle("-fx-opacity: 0.5;");
							selected--;
							for(int w = 0 ;w<m.getGroupA().size();w++) {
								if(m.getGroupA().get(w).equals((String)n.getUserData())) {
									m.getGroupA().remove(w);
								}
							}
						} else {
							n.setStyle("-fx-opacity: 1.0;");
							selected++;
							m.getGroupA().add((String)n.getUserData());
						}
						//System.out.println(selected);
						if(selected==6) {
							for(int a = 0 ; a<12;a++) {
								if(gp.getChildren().get(a).getStyle().equals("-fx-opacity: 0.5;")) {
									m.getGroupB().add((String)gp.getChildren().get(a).getUserData());
								}
							}

							stage.setScene(m.getScenes().get(StageName.MATCHESA));
							//System.out.println("GroupA: " + m.getGroupA());
							//System.out.println("GroupB: " + m.getGroupB());
							selected = 0;
							m.getModel().setGroupA(new Group(m.getGroupA()));
							m.getGroupAmatches().updateGP();
							//System.out.println(m.getGroupB());
							m.getModel().setGroupB(new Group(m.getGroupB()));
							m.getGroupBmatches().updateGP();
						}


					}


				});
				test.setFitWidth(200);
				test.setFitHeight(200);
				gp.getChildren().add(stack);
				GridPane.setConstraints(stack, y, i);
				count++;
			}
		}
		gp.setAlignment(Pos.CENTER);
	
	}





	/**
	 * Creates the toolbar with the primary purpose of navigation. Only one button is needed and sends the user back to the main screen. 
	 * Selected teams logos are set to unselected opacity and selected attribute is reset to zero. 
	 * @return Toolbar navigation toolbar
	 */
	public ToolBar createTB() {
		Button back = new Button();
		back.setFont(new Font("Courier New",15));
		back.setText("Back to Home");
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for(Node n: gp.getChildren()) {
					n.setStyle("-fx-opacity: 0.5;");
					selected = 0;
				}
				m.getGroupA().clear();
				m.getGroupB().clear();
				stage.setScene(m.getScenes().get(StageName.WELCOME));
			}
		});
		back.setPrefSize(150, 50);

		Region emptyCenter = new Region();
		HBox.setHgrow(emptyCenter, Priority.ALWAYS);

		ToolBar tb = new ToolBar(back,emptyCenter);
		tb.setStyle("-fx-background-color: transparent;");

		return tb;
	}
	/**
	 * Creates label/title on the top of the scene. 
	 * @return Label scene title
	 */
	private Label generateTop() {
		Label ret = new Label("Select Teams in Group A");
		ret.setAlignment(Pos.CENTER);
		ret.setStyle("-fx-background-color: black");
		ret.setPadding(new Insets(10));
		ret.setFont(new Font("Courier New", 25));
		ret.setTextFill(Color.WHITE);
		ret.setPrefSize(500, 50);
		return ret;
	}
	
	public GridPane getGp() {
		return gp;
	}

}
