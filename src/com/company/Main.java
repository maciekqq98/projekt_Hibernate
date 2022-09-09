package com.company;

import Model.WynikiEntity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Apka");
        primaryStage.setScene(new Scene(root));
        // Controller controller = new Controller();
        //controller.initialize();

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
       // Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       // session.beginTransaction();
        //WynikiEntity wynikiEntity = session.get(WynikiEntity.class, 1);
        //session.getTransaction().commit();
        //session.close();




    }
}
