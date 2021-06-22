package view;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class View {
	private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	protected Scene scene;
	protected Stage stage;
	
	protected int canvasWidth = gd.getDisplayMode().getWidth() - 150;
	protected int canvasHeight = gd.getDisplayMode().getHeight() - 150;
	public Scene getScene() {return scene;}
	
}
