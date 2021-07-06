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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Group;
import model.StageName;
/**
 * The startView class sets up the first screen by setting up the background image, and three navigation buttons. The class also includes
 * the button functionality on presses. 
 * @author bwu
 *
 */
public class startView extends View{
	
	private Main m;
	/**
	 * Creates the startView window and its functionality. Creates each of the three buttons. One button starts from the group selection 
	 * (groupView), one button starts from the simulations run after Stage Four Week Three (simulationsView), 
	 * and the final button automatically starts with Stage Five pools and goes to the match selection screen(groupAmatchesView). 
	 * All buttons are styled in this constructor as well including the background image. 
	 * @param primaryStage Stage used as active stage for UI
	 * @param main Main used to communicate with other views from button functionality
	 */
	public startView(Stage primaryStage, Main main) {
		m = main;
		this.stage = primaryStage;
		stage.setResizable(false);
		stage.sizeToScene();
		primaryStage.setTitle("Group Simulator");
		Button btn = new Button();
		btn.setText("Start from Scratch");
		btn.setFont(new Font("Courier New",15));
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//System.out.println("next");
				primaryStage.setScene(main.getScenes().get(StageName.GROUPSELECTION));
			}
		});
		
		Button stageFour = new Button();
		stageFour.setText("To Stage 4 Week 3");
		stageFour.setFont(new Font("Courier New",15));
		stageFour.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				m.getModel().setGroupA(new Group(false,4));
				
				m.getModel().getGroupA().simulateMatches(m.getModel().getGroupA(), false);
				
				m.getModel().setGroupB(new Group(true,4));
				m.getModel().getGroupB().simulateMatches(m.getModel().getGroupB(), false);
				
				
				m.getSim().updateGrid(m.getModel().getGroupA());
				primaryStage.setScene(m.getScenes().get(StageName.SIMULATION));
				
			}
		});
		
		Button stageFive = new Button();
		stageFive.setText("To Stage 5");
		stageFive.setFont(new Font("Courier New",15));
		stageFive.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				m.getModel().setGroupA(new Group(false,5));
				
				m.getModel().setGroupB(new Group(true,5));
				
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
