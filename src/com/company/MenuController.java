package com.company;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {

    public TextField textfieldLogin;
    public TextField textfieldHasło;
    public Label labelCzyUdało;
    private MainController mainController;

    @FXML
    public void openapllication(){
        if(textfieldLogin.getText().equals("admin")&& textfieldHasło.getText().equals("admin"))
        {
            FXMLLoader loader = new FXMLLoader(this.getClass()
                    .getResource("AppScreen.fxml"));
            Pane pane=null;
            try{
                pane =loader.load();
            }catch (IOException e){
                e.printStackTrace();
            }
            AppController appController = loader.getController();
            appController.setMainController(mainController);
            mainController.setScreen(pane);
        }
        else{
            labelCzyUdało.setText("Błedne dane Logowania, brak dostepu do panelu administracyjnego !!");
        }

    }
    @FXML
    public void openoption(){
        FXMLLoader loader = new FXMLLoader(this.getClass()
                .getResource("OptionScreen.fxml"));
        Pane pane=null;
        try{
            pane =loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        OptionController optionController = loader.getController();
        optionController.setMainController(mainController);
        mainController.setScreen(pane);

    }
    @FXML
    public void exit(){
        Platform.exit();
    }

    public void setController(MainController mainController) {
        this.mainController = mainController;
    }
}
