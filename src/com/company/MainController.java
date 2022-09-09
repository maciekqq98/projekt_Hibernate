package com.company;

import DAO.EmployeDAO;
import Model.GraEntity;
import Model.WynikiEntity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

public class MainController {

    @FXML
    private StackPane stackpane1;

    @FXML
    void initialize() throws IOException {
        loadMenuScreen();
        //EmployeDAO employeDAO = new EmployeDAO();
        //GraEntity graEntity2 =employeDAO.getGraById(3);

        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //session.beginTransaction();
       // WynikiEntity wynikiEntity = session.get(WynikiEntity.class, 1);


        //WynikiEntity wynikiEntity1 =employeDAO.getWynikiById(1); // uwarzac na sesje by wychodzi błąd
        //System.out.println(wynikiEntity1);

        //List<WynikiEntity> wynikiEntity=employeDAO.getAllWyniki();
        //for (WynikiEntity emp : wynikiEntity){
           // System.out.println(wynikiEntity.get(1).getGraEntity().getName());
        //}


      //GraEntity graEntity1 =employeDAO.getGraById(2);
        //System.out.println(graEntity1);
       // Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //session.beginTransaction();
        //List<WynikiEntity> wynikiEntities = session.createSQLQuery("select pkt,idgry from wyniki ")
        //        .getResultList();
       // session.close();

        //System.out.println(wynikiEntities.toString());
       /// WynikiEntity wynikiEntity=employeDAO.getWynikiById(5);
        //wynikiEntity.setName("tomek");
       // wynikiEntity.setSurname("kołek");
       // wynikiEntity.setPkt(60);
       // employeDAO.updatWyniki(wynikiEntity);



        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //session.beginTransaction();
        //String znak="'w%'";
        //List<WynikiEntity> wyniki = session.createSQLQuery("select surname from wyniki where surname like"+znak)
         //       .getResultList();
       // System.out.println(wyniki);


        //}
        // póba dodania
        //bez session
        //WynikiEntity wynikiEntity3 = new WynikiEntity("mariusz","nowak",50,graEntity2);
        //employeDAO.saveWyniki(wynikiEntity3);

        //employeDAO.deleteWynik(wynikiEntity1);

        //System.out.println(wynikiEntity.toString());
        //session.getTransaction().commit();
       // session.close();
    }

    public void loadMenuScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass()
                .getResource("MenuScreen.fxml"));

        Pane pane=null;
        try{
            pane =loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        MenuController menuController=loader.getController();
        menuController.setController(this);
        setScreen(pane);
    }

    public void setScreen(Pane pane) {
        stackpane1.getChildren().clear();
        stackpane1.getChildren().add(pane);
    }

}
