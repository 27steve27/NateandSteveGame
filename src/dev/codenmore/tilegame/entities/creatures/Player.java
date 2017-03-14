package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tiles.Tile;

public class Player extends Creature{
	//Animations
	private Animation animDown;
	private Animation animRight;
	private Animation animLeft;
	private Animation animUp;
	private Animation animStand;
	
	

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH - 32, Creature.DEFAULT_CREATURE_HEIGHT -32);
		bounds.y = 5;
		bounds.width = 14;
		bounds.height = 18;
		
	
		 //Animations
		
	animDown = new Animation(500, Assets.player_down);
	animUp = new Animation(500, Assets.player_up);
	animRight = new Animation(500, Assets.player_right);
	animLeft = new Animation(500, Assets.player_left);
	
	}

	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getMouseManager().leftPressed){
			float tx = handler.getMouseManager().getMouseX();
			float ty = handler.getMouseManager().getMouseY();
			
			if (tx - x > 0){
			for(int counter = 0; counter <= tx - x; counter++)
			 x ++;
			}
			else if(tx - x < 0){
				for(int counter = 0; counter <= tx - x; counter++)
				x --;}
		
	
			if (y - ty > 0){
				for(int counter = 0; counter <= ty - y; counter++)
					 y ++;
					}
			else if(y - ty < 0)
				for(int counter = 0; counter <= ty - y; counter++)
				y--;
			
		}
			
			
			/*yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed; 
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;*/
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()), width, height, null);
	
//		g.setColor(Color.red);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
	//			(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		 
	} 
 private BufferedImage getCurrentAnimationFrame(){
	 if(xMove < 0){
		 return animLeft.getCurrentFrame();
	 }else if(xMove > 0){
		 return animRight.getCurrentFrame();
	 }else if(yMove < 0){
		 return animUp.getCurrentFrame();
	 }else{
		 return animDown.getCurrentFrame();
	 
	 }
	
 }
}
