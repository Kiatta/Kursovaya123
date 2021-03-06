package Anim;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;
public class Anim{
    private TranslateTransition tt;
    public Anim(Node node){
        tt= new TranslateTransition(Duration.millis(70),node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(4);
        tt.setAutoReverse(true);
    }
    public void playAnim(){
        tt.playFromStart();
    }
}