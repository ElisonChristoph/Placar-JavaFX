/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxFutebol;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Elison
 */
public class FXMLFutebolController implements Initializable {
    
    
    @FXML private AnchorPane aPFutebol;
    @FXML private MediaView mvPropaganda;
    private static File file = new File("c:/users/elison/documents/netBeansprojects/javafxplacar/src/UEFA.mp4");
    private static final String mediaurl = file.toURI().toString(); 
    private MediaPlayer mediaplayer;
    private Media media;
    
    @FXML private void pausaVideo(ActionEvent event){
        mediaplayer.stop();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        media = new Media(mediaurl);
        mediaplayer = new MediaPlayer(media);
        mvPropaganda.setMediaPlayer(mediaplayer);
        mediaplayer.play();
        
    } 
    
    
    
    
    
    
}
