package com.example.ideal_weight_formula;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Label age = new Label("Age");
    TextField ageField = new TextField();
    RadioButton male = new RadioButton("Male");
    RadioButton female = new RadioButton("Female");
    Label height = new Label("height");
    TextField heightField = new TextField();
    Button calculate = new Button("Calculate");
    TextField result = new TextField();
    @Override
    public void start(Stage stage) throws IOException {
        GridPane gp = new GridPane();
        GridPane.setConstraints(age, 0,0);
        GridPane.setConstraints(ageField, 1,0);
        GridPane.setConstraints(male, 0,1);
        GridPane.setConstraints(female, 1,1);
        GridPane.setConstraints(height, 0,2);
        GridPane.setConstraints(heightField,1,2);
        GridPane.setConstraints(calculate, 0,3);
        GridPane.setConstraints(result, 0,4);

        ToggleGroup group = new ToggleGroup();
        male.setToggleGroup(group);
        female.setToggleGroup(group);
        calculate.setOnAction(event->{
            if(male.isSelected()) {
                double ibw = 50 + (0.91 * (Double.parseDouble(heightField.getText()) - 152.4));
                result.setText(String.valueOf(ibw*2.20462));
            }else if(female.isSelected()){
                double ibw = 45.5 + (0.91 * (Double.parseDouble(heightField.getText())-152.4));
                result.setText(String.valueOf(ibw*2.20462));
            }
        });
        gp.getChildren().addAll(result, male, female, calculate, height, heightField, age, ageField);
        Scene scene = new Scene(gp, 320, 240);
        stage.setTitle("Ideal Weight Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}