package com.example.tv;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Image tv = new Image("https://cdn.dribbble.com/users/3173935/screenshots/9520030/crttv-01.png");
        ImageView imageView = new ImageView(tv);

        HBox hBox = new HBox(38);
        hBox.setPadding(new Insets(491.5, 0, 0, 470));

        Rectangle rectangle = new Rectangle(0,0, 440, 385);
        rectangle.setArcWidth(60.0);
        rectangle.setArcHeight(60.0);
        rectangle.setFill(Color.TAN);

        rectangle.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rectangle.setStroke(Color.SADDLEBROWN);
                rectangle.setStrokeWidth(5);
            }
        });
        rectangle.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rectangle.setStroke(null);
            }
        });

        HBox buttons = new HBox(3);
        RadioButton rbRed = new RadioButton("R");
        rbRed.setStyle("-fx-text-fill: SaddleBrown; -jfx-selected-color: red; -jfx-unselected-color: green;");
        rbRed.setFont(new Font("Impact", 20));
        rbRed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rectangle.setFill(Color.MAROON);
            }
        });
        RadioButton rbGreen = new RadioButton("G");
        rbGreen.setStyle(" -fx-text-fill: SaddleBrown;");
        rbGreen.setFont(new Font("Impact", 20));
        rbGreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rectangle.setFill(Color.DARKOLIVEGREEN);
            }
        });
        RadioButton rbBlue = new RadioButton("B");
        rbBlue.setStyle(" -fx-text-fill: SaddleBrown;");
        rbBlue.setFont(new Font("Impact", 20));
        rbBlue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rectangle.setFill(Color.MIDNIGHTBLUE);
            }
        });

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbBlue.setToggleGroup(group);

        buttons.getChildren().addAll(rbBlue, rbRed, rbGreen);
        buttons.setPadding(new Insets(270, 0, 0, 0));

        hBox.getChildren().addAll(rectangle, buttons);

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