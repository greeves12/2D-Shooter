package com.tatemylove.SpaceShooter.Engine.Commands;

import com.tatemylove.SpaceShooter.Engine.Engine.GameObject;
import com.tatemylove.SpaceShooter.Engine.Engine.Handler;
import com.tatemylove.SpaceShooter.Engine.Engine.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++){
            GameObject gameObject = handler.object.get(i);

            if(gameObject.getId() == ID.Player){
                if(key == KeyEvent.VK_D){
                    gameObject.setVelX(5);
                }else if(key == KeyEvent.VK_A){
                    gameObject.setVelX(-5);
                }else if(key == KeyEvent.VK_W){
                    gameObject.setVelY(-5);
                }else if(key == KeyEvent.VK_S){
                    gameObject.setVelY(5);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++){
            GameObject gameObject = handler.object.get(i);

            if(gameObject.getId() == ID.Player){
                if(key == KeyEvent.VK_D){
                    gameObject.setVelX(0);
                }else if(key == KeyEvent.VK_A){
                    gameObject.setVelX(0);
                }else if(key == KeyEvent.VK_W){
                    gameObject.setVelY(0);
                }else if(key == KeyEvent.VK_S){
                    gameObject.setVelY(0);
                }
            }
        }
    }
}
