package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer.Random;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

public class Obs {
	private static final int FLUCTUATION = 130;
	private static final int gap = 100;
	private static final int lowesto = 120;
private Texture topobs,botobs;
private Vector2 postopobs,posbotobs;
private Random rand;
public Obs(float x) {
	topobs = new Texture("pacman.png");
	botobs = new Texture("pacman.png");
	rand = new Random();
	//postopobs = new Vector2 (x,rand.nextInt(FLUCTUATION)+gap+lowesto);
}
}
