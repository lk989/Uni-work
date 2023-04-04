package com.example.atm;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Image background = new Image("https://img.freepik.com/free-photo/abstract-luxury-gradient-blue-background-smooth-dark-blue-with-black-vignette-studio-banner_1258-52767.jpg?w=900&t=st=1680594032~exp=1680594632~hmac=a65b2d0b0cae847425dcdebb9147f5f1ea7adfbaf898eaa2f872d7ce99184bd6");
        ImageView image = new ImageView(background);
        BorderPane pane = new BorderPane();

        //top
        Label atm = new Label("ATM");
        atm.setFont((Font.font("Impact", FontWeight.BOLD, 80)));
        atm.setStyle("-fx-text-fill: white;");
        atm.setPadding(new Insets(40, 10, 0, 50));
        pane.setTop(atm);

        //left
        Text welcome = new Text("Welcome:");
        welcome.setFill(Color.GRAY);
        welcome.setFont((Font.font("Impact", FontWeight.BOLD, 20)));

        Text name = new Text("Lama Bugis");
        name.setFill(Color.WHITE);
        name.setFont((Font.font("Impact", FontWeight.BOLD, 22)));

        Text account = new Text("Account #1 :");
        account.setFill(Color.GRAY);
        account.setFont((Font.font("Impact", FontWeight.BOLD, 20)));

        Text acount_balance = new Text("$5.245,69");
        acount_balance.setFill(Color.WHITE);
        acount_balance.setFont((Font.font("Impact", FontWeight.BOLD, 22)));

        Text savings = new Text("Saving #1 :");
        savings.setFill(Color.GRAY);
        savings.setFont((Font.font("Impact", FontWeight.BOLD, 20)));

        Text saving_balance = new Text("$794,98");
        saving_balance.setFill(Color.WHITE);
        saving_balance.setFont((Font.font("Impact", FontWeight.BOLD, 22)));

        Button card_return = new Button("Card Return");
        card_return.setStyle("-fx-font-size: 1.1em; -fx-background-color: slategray; -fx-text-fill: white");

        VBox left = new VBox(10);
        left.getChildren().addAll(welcome, name, account, acount_balance, savings, saving_balance, card_return);
        left.setPadding(new Insets(30, 0, 0, 60));
        pane.setLeft(left);

        //center
        VBox center = new VBox(10);
        center.setPrefWidth(300);
        Button get_cash = new Button("Get Cach");
        get_cash.setStyle("-fx-font-size: 1.8em; -fx-font-family: Impact;");
        get_cash.setMinWidth(300);
        get_cash.setMinHeight(70);
        Button payments = new Button("Payments");
        payments.setStyle("-fx-font-size: 1.8em; -fx-font-family: Impact;");
        payments.setMinWidth(300);
        payments.setMinHeight(70);
        Button account_settings = new Button("Account Settings");
        account_settings.setStyle("-fx-font-size: 1.8em; -fx-font-family: Impact;");
        account_settings.setMinWidth(300);
        account_settings.setMinHeight(70);
        center.getChildren().addAll(get_cash, payments, account_settings);
        center.setPadding(new Insets(25, 20, 0, 90));
        pane.setCenter(center);

        //right
        VBox right = new VBox(10);
        right.setPrefWidth(300);
        Button deposite = new Button("Deposite");
        deposite.setStyle("-fx-font-size: 1.8em; -fx-font-family: Impact;");
        deposite.setMinWidth(300);
        deposite.setMinHeight(70);
        Button credit_card = new Button("Credit Card");
        credit_card.setStyle("-fx-font-size: 1.8em; -fx-font-family: Impact;");
        credit_card.setMinWidth(300);
        credit_card.setMinHeight(70);
        Button other = new Button("Other");
        other.setStyle("-fx-font-size: 1.8em; -fx-font-family: Impact;");
        other.setMinWidth(300);
        other.setMinHeight(70);
        right.getChildren().addAll(deposite, credit_card, other);
        right.setPadding(new Insets(25, 20, 0, 0));
        pane.setRight(right);

        //bottom
        HBox bottom = new HBox(20);
        
        Label red = new Label();
        red.setStyle("-fx-background-color: lightgray;");
        red.setPrefWidth(450);
        red.setPrefHeight(45);

        Label quick_cash = new Label("Quick Cash");
        quick_cash.setStyle("-fx-text-fill: dimgrey;");
        quick_cash.setFont((Font.font("Impact", FontWeight.NORMAL, 20)));
        
        TextField amount = new TextField("Enter the amount");
        amount.setPrefWidth(230);

        Button withdraw = new Button("Done");
        
        bottom.getChildren().addAll(quick_cash, amount, withdraw);
        bottom.setPadding(new Insets(10, 0, 0, 140));
        
        StackPane bottom_pane = new StackPane(red, bottom);
        bottom_pane.setPadding(new Insets(10, 0, 0, 195));

        pane.setBottom(bottom_pane);


        //grouping
        Group root = new Group(image, pane);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}