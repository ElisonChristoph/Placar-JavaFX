/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxFutebol;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Elison
 */
public class JavaFXFutebol extends Application {

    private static Stage stage;

    private FXMLFutebolController fc;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLFutebol.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        //stage.setFullScreen(true);
        setStage(stage);
        //Inicia Cronometro
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent k) -> {
            if (k.getCode() == KeyCode.P) {
                
                
                
                
               /////////continuar aqui
            
            
            
            
            
            
            }
        });
        //Fecha janela ao pressionar ESC
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
            if (t.getCode() == KeyCode.ESCAPE) {

                fecha();
            }
        });
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        JavaFXFutebol.stage = stage;
    }

    public void fecha() {

        JavaFXFutebol.getStage().close();
    }

}
