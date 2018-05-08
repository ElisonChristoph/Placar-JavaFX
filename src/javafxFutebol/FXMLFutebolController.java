/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxFutebol;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafxSet.FXMLSetDadosController;

/**
 *
 * @author Elison
 */
public class FXMLFutebolController implements Initializable {

    @FXML
    private AnchorPane aPFutebol;
    @FXML
    private MediaView mvPropaganda;
    @FXML
    private Label labelTimeEsquerda;
    @FXML
    private Label labelTimeDireita;
    @FXML
    private Label lPlacarTimeEsquerda;
    @FXML
    private Label lPlacarTimeDireita;
    @FXML
    private Label lCronometro;

    private static File file = new File("src/UEFA.mp4");
    private static final String mediaurl = file.toURI().toString();
    private MediaPlayer mediaplayer;
    private Media media;
    private static FXMLSetDadosController c;

    public boolean stopc = true;
    private int segundo = 0;
    private int minuto = 0;
    private int hora = 0;

    public void iniciaCronometro() {
        Task t = new Task() {

            @Override
            protected Object call() throws Exception {
                while (stopc == true) {
                    segundo++;

                    if (segundo == 60) {
                        minuto++;
                        segundo = 0;
                    }

                    if (minuto == 60) {
                        hora++;
                        minuto = 0;
                    }
                    String hr = hora <= 9 ? "0" + hora : hora + "";
                    String min = minuto <= 9 ? "0" + minuto : minuto + "";
                    String seg = segundo <= 9 ? "0" + segundo : segundo + "";

                    Platform.runLater(() -> {

                        lCronometro.setText(min + ":" + seg);
                    });
                    Thread.sleep(1000);

                }
                return null;
            }
        };
        new Thread(t).start();

    }

    public void Placar() {
        Task t2 = new Task() {

            @Override
            protected Object call() throws Exception {
                //while (stopc == true) {

                int pe = 0;
                pe = Integer.parseInt(lPlacarTimeEsquerda.getText());
                pe = (pe + 1);
                String spe = Integer.toString(pe);
                Platform.runLater(() -> {

                    lPlacarTimeEsquerda.setText(spe);
                });
                

                //}
                return null;
            }
        };
        new Thread(t2).start();

    }

    @FXML
    private void pausaVideo(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            mediaplayer.stop();
        }
    }

    public void pegarTime(String nomea, String nomeb) {

        this.labelTimeEsquerda.setText(nomea);
        this.labelTimeDireita.setText(nomeb);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        c = new FXMLSetDadosController();
        try {
            pegarTime(c.retornaTimeA(), c.retornaTimeB());
        } catch (Exception ex) {
            System.out.println("Deu merda" + ex.getMessage());
        }

        media = new Media(mediaurl);
        mediaplayer = new MediaPlayer(media);
        mvPropaganda.setMediaPlayer(mediaplayer);
        mediaplayer.play();
        iniciaCronometro();
        Placar();

    }

}
