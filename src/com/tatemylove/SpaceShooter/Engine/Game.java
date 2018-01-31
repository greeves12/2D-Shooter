package com.tatemylove.SpaceShooter.Engine;

import com.tatemylove.SpaceShooter.Engine.Engine.Handler;
import com.tatemylove.SpaceShooter.Engine.Engine.ID;
import com.tatemylove.SpaceShooter.Engine.Engine.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread gameThread;
    private boolean started = false;

    private Handler handler;

    public Game(){
        new Window(WIDTH, HEIGHT, "Test Game", this);

        handler = new Handler();

        handler.addObject(new Player(100, 100, ID.Player));
    }

    public synchronized void start(){
        gameThread = new Thread(this);
        gameThread.start();

        started = true;
    }

    public synchronized void stop(){
        try {
            gameThread = new Thread(this);
            gameThread.join();
            started = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTick = 60.0;
        double ns = 1000000000 / amountOfTick;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(started){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(started)
                render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.print("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();
    }

    private void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static void main (String args[]){
        new Game();
    }
}
