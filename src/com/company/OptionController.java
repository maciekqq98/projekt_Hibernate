package com.company;

import DAO.EmployeDAO;
import Model.WynikiEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.List;

public class OptionController {

    private MainController mainController;
    public Label labelPokazCały;

    public Label labelPokazIle;

    public TextField textFieldwiekszeOd; // buttonWiekszeOd
    public Label labelWiekszeOd; //do buttonWiekszeOd
    //

    @FXML
    public void backMenu(){
        mainController.loadMenuScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    @FXML
    void initialize()
    {
    }
    public void buttonPokazCaly(ActionEvent actionEvent) {

        EmployeDAO employeDAO = new EmployeDAO();
        List<WynikiEntity> wynikiEntity =employeDAO.getAllWyniki();
        labelPokazCały.setText(String.valueOf(wynikiEntity));

    }

    public void buttonWiekszeOd(ActionEvent actionEvent) {
        EmployeDAO employeDAO = new EmployeDAO();
        List<WynikiEntity> wynikiEntity =employeDAO.getPktMore(Integer.parseInt(textFieldwiekszeOd.getText()));
        labelWiekszeOd.setText(String.valueOf(wynikiEntity));
    }


    public void buttonPokazIle(ActionEvent actionEvent) {
        EmployeDAO employeDAO = new EmployeDAO();
        int i=0;
        int gra1=0;
        int gra2=0;
        int gra3=0;
        List<WynikiEntity> wynikiEntity=employeDAO.getAllWyniki();
        for(WynikiEntity var:wynikiEntity)
        {
            if(var.getGraEntity().getId()==1)
            {
                gra1++;
            }else if (var.getGraEntity().getId()==2)
            {
                gra2++;
            }else {
                gra3++;
            }
        }
        labelPokazIle.setText("Liczba graczy cs:  "+gra1 +"\n"+
                              "Liczba graczy lol:  "+gra2+ "\n"+
                              "Liczba graczy dota2:  "+gra3);
    }
}
