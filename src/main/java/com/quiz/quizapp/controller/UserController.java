package com.quiz.quizapp.controller;

import com.quiz.quizapp.model.UserData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Label;

public class UserController {

    @FXML
    private Button userBtn;

    @FXML
    private TextField nameField;

    @FXML
    private void initialize() {
        userBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String userName = nameField.getText();
                if (userName != null && !userName.isEmpty()) {
                    UserData.setUserName(userName);
                    System.out.println("User name saved: " + UserData.getUserName());
                }

                MusicController.playClickSound(); // Play click sound
                try {
                    Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                    thisstage.close();

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/quiz/quizapp/avatar.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    scene.setFill(Color.TRANSPARENT);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
