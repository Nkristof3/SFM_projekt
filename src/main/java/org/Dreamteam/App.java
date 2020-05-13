package org.Dreamteam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"));
        MediaView videoablak = (MediaView)scene.lookup("#videoablak");
        MediaPlayer player = new MediaPlayer(new Media(getClass().getResource("video.mp4").toExternalForm()));
        player.setAutoPlay(true);
        videoablak.setMediaPlayer(player);
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("logo.jpg")));
        stage.show();
        stage.setTitle("Kezdőlap");
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

     static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}