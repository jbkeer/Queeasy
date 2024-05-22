package com.quiz.quizapp.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserData {
    private static StringProperty userName = new SimpleStringProperty();

    public static StringProperty userNameProperty() {
        return userName;
    }

    public static String getUserName() {
        return userName.get();
    }

    public static void setUserName(String name) {
        userName.set(name);
    }
}
