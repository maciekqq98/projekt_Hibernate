package com.company;

import DAO.EmployeDAO;
import Model.GraEntity;
import Model.WynikiEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;


import java.util.List;

public class AppController {
    public Label labelwyswietl; // label do buttonwyswietl
    public TextField textFieldwyswietl; //TextField do buttonwyswietl

    public TextField textimie; // do buttonDodaj
    public TextField textnazwisko; // do buttonDodaj
    public TextField textpkt; // do buttonDodaj
    public TextField textgra; // do buttonDodaj
    public Label labeldodaj;// do buttonDodaj

    public Label labelWiekszeOd; //do buttonWiekszeOd
    public TextField textFieldwiekszeOd; //do buttonWiekszeOd

    public TextField textEdytujId; //do buttonEdytuj
    public TextField textEdytujImie; //do buttonEdytuj
    public TextField textEdytujNazwisko; //do buttonEdytuj
    public TextField textEdytujPkt; //do buttonEdytuj
    public TextField textEdytujGra; //do buttonEdytuj

    private MainController mainController;
    // admin
    @FXML
    public void backMenu() {
        mainController.loadMenuScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void buttonwyswietl(ActionEvent actionEvent) {

        EmployeDAO employeDAO = new EmployeDAO();
        WynikiEntity wynikiEntity1 = employeDAO.getWynikiById(Integer.parseInt(textFieldwyswietl.getText()));

            labelwyswietl.setText(String.valueOf(wynikiEntity1));

        if(labelwyswietl.getText().equals("null"))
        {
            labelwyswietl.setText("Nie ma takiego rekordu!!");
        }
    }

    public void buttonDodaj(ActionEvent actionEvent) {

        int var = switch (textgra.getText()) {
            case "cs" -> 1;
            case "lol" -> 2;
            case "dota2" -> 3;
            default -> 0;
        };

        EmployeDAO employeDAO = new EmployeDAO();
        GraEntity graEntity1 =employeDAO.getGraById(var);
        WynikiEntity wynikiEntity1 = new WynikiEntity(textimie.getText(),textnazwisko.getText(),
                Integer.parseInt(textpkt.getText()),graEntity1);
        labeldodaj.setText(employeDAO.saveWyniki(wynikiEntity1));
        textgra.clear();
        textpkt.clear();
        textnazwisko.clear();
        textimie.clear();
    }

    public void buttonWiekszeOd(ActionEvent actionEvent) {

        EmployeDAO employeDAO = new EmployeDAO();
        List<WynikiEntity> wynikiEntity =employeDAO.getPktMore(Integer.parseInt(textFieldwiekszeOd.getText()));
        labelWiekszeOd.setText(String.valueOf(wynikiEntity));

    }

    public void buttonEdytuj(ActionEvent actionEvent) {
        EmployeDAO employeDAO = new EmployeDAO();
        WynikiEntity wynikiEntity=employeDAO.getWynikiById(Integer.parseInt(textEdytujId.getText()));
        int var = switch (textEdytujGra.getText()) {
            case "cs" -> 1;
            case "lol" -> 2;
            case "dota2" -> 3;
            default -> 0;
        };
        GraEntity graEntity= employeDAO.getGraById(var);
        if (!textEdytujImie.getText().isEmpty()) {
            wynikiEntity.setName(textEdytujImie.getText());
        }
        if(!textEdytujNazwisko.getText().isEmpty()) {
            wynikiEntity.setSurname(textEdytujNazwisko.getText());
        }
        if(!textEdytujPkt.getText().isEmpty()) {
            wynikiEntity.setPkt(Integer.parseInt(textEdytujPkt.getText()));
        }
        if (!textEdytujGra.getText().isEmpty()) {
            wynikiEntity.setGraEntity(graEntity);
        }

        employeDAO.updatWyniki(wynikiEntity);

    }
}
