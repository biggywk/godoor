package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameScreen;
public class PacmanGame extends Game {
    public static SpriteBatch batch;
    private Music music;
    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new GameScreen(this));
        music =Gdx.audio.newMusic(Gdx.files.internal("songmp3.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();
        
        
    }
    @Override
    public void render() {
    	super.render();
    }
    @Override
    public void dispose() {
        batch.dispose();
    }
}