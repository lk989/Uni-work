package com.example.ramadangreetingcard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class RamadanCard extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Image
        Image image = new Image("https://i.pinimg.com/originals/79/00/27/790027d5ac076dd42e750c1bbe17ac37.jpg");
        //ImageView
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);

        //Text
        Text text = new Text(90, 310, "Ramadan Kareem");
        //Font
        text.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 30));
        //Color
        text.setFill(Color.rgb(47,79,79));

        //Line
        Line line1 = new Line(160, 10, 160, 40);
        line1.setFill(Color.GRAY);
        //Circle
        Circle circle1 = new Circle(160, 40, 5);
        circle1.setFill(Color.rgb(184,134,11));
        //Line
        Line line2 = new Line(220, 40, 220, 70);
        line2.setFill(Color.GRAY);
        //Circle
        Circle circle2 = new Circle(220, 70, 5);
        circle2.setFill(Color.rgb(184,134,11));
        //Line
        Line line3 = new Line(300, 30, 300, 60);
        line3.setFill(Color.GRAY);
        //Circle
        Circle circle3 = new Circle(300, 60, 5);
        circle3.setFill(Color.rgb(184,134,11));

        //Rectangle
        Rectangle rectangle = new Rectangle(80, 275, 240, 50);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.rgb(245,222,179));

        Group root = new Group(imageView, text, line1, circle1, line2, circle2, line3, circle3, rectangle);
        Scene scene = new Scene(root);
        stage.setTitle("Lab1- Greeting Card");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}