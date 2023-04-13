package com.example.eventdriven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Image tv = new Image("https://cdn.dribbble.com/users/3173935/screenshots/9520030/crttv-01.png");
        ImageView imageView = new ImageView(tv);

        HBox hBox = new HBox(110);
        hBox.setPadding(new Insets(491, 0, 0, 470));

        Rectangle rectangle = new Rectangle(0,0, 440, 385);
        rectangle.setArcWidth(60.0);
        rectangle.setArcHeight(60.0);
        /*
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(rbBlue, rbRed, rbGreen);
        */

        FlowPane pane = new FlowPane();
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlue = new RadioButton("Blue");
        rbBlue.setContentDisplay(ContentDisplay.TOP);

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbBlue.setToggleGroup(group);

        pane.getChildren().addAll(rbBlue, rbRed, rbGreen);


        hBox.getChildren().addAll(rectangle, pane);

        Group root = new Group(imageView, hBox);
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}