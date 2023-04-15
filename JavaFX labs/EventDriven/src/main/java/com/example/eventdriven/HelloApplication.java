package com.example.eventdriven;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
        HBox hBox = new HBox(38.0);
        hBox.setPadding(new Insets(491.5, 0.0, 0.0, 470.0));
        Pane container = new Pane();
        final Rectangle rectangle = new Rectangle(0.0, 0.0, 440.0, 385.0);
        rectangle.setArcWidth(60.0);
        rectangle.setArcHeight(60.0);
        rectangle.setFill(Color.TAN);
        Image micky = new Image("https://i.pinimg.com/originals/3c/38/70/3c38709217b5a721ab4a80331f5b46d1.png");
        ImageView mm = new ImageView(micky);
        mm.setFitHeight(200);
        mm.setFitWidth(150);
        Pane micky_mouse = new Pane();
        micky_mouse.getChildren().add(mm);
        container.getChildren().addAll(rectangle, micky_mouse);
        rectangle.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                rectangle.setStroke(Color.SADDLEBROWN);
                rectangle.setStrokeWidth(5.0);
            }
        });
        rectangle.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                rectangle.setStroke(null);
            }
        });
        HBox buttons = new HBox(3.0);
        RadioButton rbRed = new RadioButton("R");
        rbRed.setStyle("-fx-text-fill: SaddleBrown; -jfx-selected-color: red; -jfx-unselected-color: green;");
        rbRed.setFont(new Font("Impact", 20.0));
        rbRed.setFocusTraversable(false);
        rbRed.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                rectangle.setFill(Color.MAROON);
            }
        });
        RadioButton rbGreen = new RadioButton("G");
        rbGreen.setStyle(" -fx-text-fill: SaddleBrown;");
        rbGreen.setFont(new Font("Impact", 20.0));
        rbGreen.setFocusTraversable(false);
        rbGreen.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                rectangle.setFill(Color.DARKOLIVEGREEN);
            }
        });
        RadioButton rbBlue = new RadioButton("B");
        rbBlue.setStyle(" -fx-text-fill: SaddleBrown;");
        rbBlue.setFont(new Font("Impact", 20.0));
        rbBlue.setFocusTraversable(false);
        rbBlue.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                rectangle.setFill(Color.MIDNIGHTBLUE);
            }
        });
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbBlue.setToggleGroup(group);
        buttons.getChildren().addAll(rbBlue, rbRed, rbGreen);
        buttons.setPadding(new Insets(270.0, 0.0, 0.0, 0.0));
        hBox.getChildren().addAll(container, buttons);
        Group root = new Group(imageView, hBox);
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.UP)
                micky_mouse.setTranslateY(micky_mouse.getTranslateY() - 10);
            else if(e.getCode() == KeyCode.DOWN)
                micky_mouse.setTranslateY(micky_mouse.getTranslateY() + 10);
            else if(e.getCode() == KeyCode.RIGHT)
                micky_mouse.setTranslateX(micky_mouse.getTranslateX() + 10);
            else
                micky_mouse.setTranslateX(micky_mouse.getTranslateX() - 10);
        });

        micky_mouse.requestFocus();

        stage.setTitle("TV!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}