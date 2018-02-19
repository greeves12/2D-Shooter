package com.tatemylove.SpaceShooter.Engine.Engine;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    public LinkedList<GameObject> object = new LinkedList<>();

    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject object1 = object.get(i);
            object1.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject gameObject = object.get(i);

            gameObject.render(g);
        }
    }

    public void addObject(GameObject gameObject){
        this.object.add(gameObject);
    }

    public void removeObject(GameObject gameObject){
        this.object.remove(gameObject);
    }
}
