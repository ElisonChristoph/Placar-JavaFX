package javafxFutebol;


import java.util.logging.Level;
import java.util.logging.Logger;


public class Relogio implements Runnable{
    private FXMLFutebolController fc;
    
    @Override
    public void run() {
        int seg, min, hor, h, m, s;
        seg = 0;
        min = 0;
        hor = 0;
        
        for(h = 0; h <24;h++){
            hor = h;
            
        for (m = 0; m < 60; m++){
            min = m;
            
        for (s = 0; s < 60; s++) {
            
            //fc.setCron(Integer.toString(seg), Integer.toString(min));
            System.out.println(hor+":"+min+":"+s);
        }
        s = 0;
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Relogio.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        }
    }
       
    }

    
    
}
