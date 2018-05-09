/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxBasquetebol;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Elison
 */
public class FXMLBasquetebolController implements Initializable {
    @FXML
    private MediaView mvBasquete;
    
    private static File file = new File("src/NET.mp4");
    private static final String mediaurl = file.toURI().toString();
    private MediaPlayer mediaplayer;
    private Media media;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    media = new Media(mediaurl);
        mediaplayer = new MediaPlayer(media);
        mvBasquete.setMediaPlayer(mediaplayer);
        mediaplayer.play();
        
    }    
    
}
