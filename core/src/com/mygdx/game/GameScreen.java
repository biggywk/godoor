package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer.Random;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
public class GameScreen extends ScreenAdapter {
	public PacmanGame pacmanGame;
	public Texture pacmanImg;
	public Texture enemyimg;
	public Texture enemyimg1;
	public Texture enemyimg2;
	public Texture enemyimg3;
	public Texture enemyimg4;
	private Texture doorimg;
	private Texture bgImg; 
	public Gopo pacman;
	public Gopo enemimg;
	public Vector2 pos; 
	public Vector2 posene;
	private Gopo enemtimg;
	private Gopo enemtimg1; 
	public GameScreen(PacmanGame pacmanGame) {
		this.pacmanGame = pacmanGame;
        pacmanImg = new Texture("player.png");	//รูป
        enemyimg = new Texture("pacman.png"); 
        enemyimg1 = new Texture("pacman.png"); 
        enemyimg2 = new Texture("pacman.png"); 
        enemyimg3 = new Texture("pacman.png"); 
        enemyimg4 = new Texture("pacman.png"); 
        doorimg = new Texture("door.jpg");
        bgImg = new Texture("bg.jpg");
        pacman = new Gopo(100,100);
        pos = pacman.getPosition();
        enemtimg = new Gopo(20,30);
        posene = enemtimg.getPosition();
        enemtimg1 = new Gopo(60,300);
        j = enemtimg1.getPosition();
	}

	@Override
    public void render(float delta) {
		font = new BitmapFont();
        update(delta);	//อัพเดท
    	Gdx.gl.glClearColor(0, 0, 0, 1);	//ให้ภาพไม่เป็นเส้น
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renders(delta);
          
    }
	public int win=0;
    public  Vector2 j;
    public  int ex4=-50;
    public  int ey4=-20;
    public  int k1=-90;
    public  int k2=-5;
    public  int ex;
    public  int ey;
    public int w;
    private  int status=0;	//กำหนดสถานะ
    private  int stand=0;
    private  int poi=0;
    int life =100;
    Random rand = new Random(); 
    
	public int score=0;
	
	public  void update(float delta) {
		
		if(ex ==10)
			score++;
    	statusandmove();
    	enemymove(delta);
    }
	private void enemymove(float delta) {
		
		posene.x+=10;
		ey4-=10;
		j.x=j.x+5;
		if(posene.x<0) {
			posene.x=0;}
    	if(posene.x>1600) {
    		posene.x=0;
    		}
    	if(posene.y<0) {
    		posene.y=0;}
    	if(posene.y>300) {
    		posene.y=0;}
    	if(j.x>1600) {
    		j.x=0;
    		}
    	if(j.y>300) {
    		j.y=0;
    		}
    	if(ex4<0) {
    		ex4=1500;}

    		
    	if(ey4<0) {
    		ey4=300;
    		ex4-=100;}
    	
	}



	
public void renders(float delta) {
	
	if(win==-1) {
		
	SpriteBatch batch = PacmanGame.batch;
    batch.begin();
    batch.draw(bgImg, 0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 
	font.draw(batch, "You failed,score "+life+"score.", 500, 200);
	font.draw(batch, "Press R to continues", 1000, 150);
	
	 batch.end();
	 if(Gdx.input.isKeyPressed(Keys.R)) {
         win=0;
	}}
	if(win==0) {
    SpriteBatch batch = PacmanGame.batch;
    batch.begin();
    batch.draw(bgImg, 0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 
    
    batch.draw(pacmanImg, pos.x, pos.y);
    batch.draw(enemyimg, posene.x, posene.y);
    batch.draw(enemyimg1, j.x, j.y);//กลาง
  //  if(poi>1) {
  //  	batch.draw(enemyimg2, ex+200, ey+290);}
    if(poi>1) {
    	batch.draw(enemyimg4, ex4, ey4);}
    
    if(poi==1) {
    	if(pos.x<200) poi++;
    	batch.draw(doorimg, 100,100 );}
    if(poi==0)
    {if(pos.x>1100)
    	poi++;
    	batch.draw(doorimg, 1300,200 );}
   if(poi==2)
        {if(pos.x>1100)
        	poi++;
        	batch.draw(doorimg, 1300,200 );}
    if(poi==3) {
        	if(pos.x<200) 
        		poi++;
        	batch.draw(doorimg, 100,100 );}
    if(poi==4)
        { batch.draw(doorimg, 1300+20,200+20 );
        poi++;
        }
    if(poi==5) {
    	batch.draw(doorimg,1400,20);
    	if(pos.x>1200)
		win=1;}
    
    font.draw(batch, "Time:" + gettime(delta), 700, 60);
    font.draw(batch, " Yellow has Ray", 500, 60);
   // batch.draw(bgImg, 0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    batch.end();    
    if(pos.x+5>=posene.x&&posene.x>=pos.x-5&&pos.y+5<=posene.y) {
		win=-1;
		life--;
	}
    if(ex4>=pos.x+5) {
    	if(ex4<=pos.x+5) {
		win=-1;
		life--;}
	}
    if(pos.x+5>=j.x&&j.x>=pos.x-5&&pos.y+5<=j.y) {
		win=-1;
		life--;
	}
    
	} 
	else if(win==1) {
		SpriteBatch batch = PacmanGame.batch;
	    batch.begin();
	    batch.draw(bgImg, 0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		font.draw(batch, "You win,score "+life+"score.", 500, 200);
		batch.draw(pacmanImg, 1000, 1000);
		batch.end();
	}
}
    int time=0;
    private BitmapFont font;
    public float gettime(float delta) {
    	if (delta>0)
    		time++;
        return (float) (time/10);
    }
public void statusandmove() {
    	
		if(status==stand) {
			if(pos.x<0) {
        		pos.x=0;}
        	if(pos.x>1600) {
        		pos.x=1500;}
        	if(pos.y<-100) {
        		pos.y=-100;}
        	if(pos.y>150) {
        		pos.y=150;}
	    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
	            pos.x -= 5;
	        }
	    	if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
	            pos.x += 5;
	        }
	    	if(Gdx.input.isKeyPressed(Keys.UP)) {
	            pos.y += 5;
	        }
	    	if(Gdx.input.isKeyPressed(Keys.DOWN)) {
	            pos.y -= 5;
	        }}
}
}
    




	
