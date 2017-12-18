package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
public class World {
	public  int x;
    public  int y;
    public  int ex;
    public  int ey;
    private  int status=0;	//กำหนดสถานะ
    private  int stand=0;
    private  int poison=1;
	public  void update(float delta) {
    	statusandmove();
    	enemymove(delta);
    }
	private void enemymove(float delta) {
		ex+=10+delta%71;
		if(ex<0) {
    		ex=0;}
    	if(ex>1600) {
    		ex=0;}
    	if(ey<0) {
    		ey=0;}
    	if(ey>300) {
    		ey=0;}
	}



	public void statusandmove() {
    	y=y-10;
		if(status==stand) {
			if(x<0) {
        		x=0;}
        	if(x>1600) {
        		x=1600;}
        	if(y<0) {
        		y=0;}
        	if(y>300) {
        		y=300;}
	    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
	            x -= 10;
	        }
	    	if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
	            x += 10;
	        }
	    	if(Gdx.input.isKeyPressed(Keys.UP)) {
	            y += 30;
	        }
	    	if(Gdx.input.isKeyPressed(Keys.DOWN)) {
	            y -= 10;
	        }}
	    
}
	

}
