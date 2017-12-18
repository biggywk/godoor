package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Worldrender {
	

	public PacmanGame pacmanGame;
	public  Texture pacmanImg;
	public  Texture enemyimg;
	public World world;
	public void render() {
		this.world= world;
        SpriteBatch batch = PacmanGame.batch;
        batch.begin();
        batch.draw(pacmanImg, world.x, world.y);	//วาด
        batch.draw(enemyimg, world.ex, world.ey+500);
        batch.end();     
    }
}
