package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.inventory.Inventory;

public class Player extends Creature{
	//Animations
	private Animation animDown;
	private Animation animRight;
	private Animation animLeft;
	private Animation animUp;
	//Attack Timer
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	
	//Inventory
	private Inventory inventory;
	
	

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH - 32, Creature.DEFAULT_CREATURE_HEIGHT -32);
		bounds.y = 5;
		bounds.width = 14;
		bounds.height = 18;
		inventory = new Inventory(handler);
		
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
		//Check Attacks
		checkAttacks();
		
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		//Inventory
		inventory.tick();
	}
	
	private void checkAttacks(){
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		
		if(attackTimer < attackCooldown)
			return;
		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
			
		}
		else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}
		else if(handler.getKeyManager().aLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}
		else if(handler.getKeyManager().aRight){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height - arSize / 2;
		}else{
			return;
		}
		
		attackTimer = 0;
		
		
		for(Entity e: handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt(1);
				System.out.println("Hit");
				return;
			}
		}
		
		
		
	}

	@Override
	public void die(){
		System.out.println("You Lose");
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;

		
		
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed; 
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		
	}
	
	@Override
	public void render(Graphics g) {
		
		
		if(handler.getKeyManager().aDown){
			g.drawImage(Assets.atkdown,(int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		}else if (handler.getKeyManager().aUp){
			g.drawImage(Assets.atkup,(int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		}else if(handler.getKeyManager().aLeft){
			g.drawImage(Assets.atkleft,(int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		}else if(handler.getKeyManager().aRight){
			g.drawImage(Assets.atkright,(int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		}else
			g.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()), width, height, null);
	
//		g.setColor(Color.red);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
	//			(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		
	}
	public void postRender(Graphics g){
		inventory.render(g);
	}

 private BufferedImage getCurrentAnimationFrame(){
	
	 
	 
	 if(xMove < 0){
		
		 return animLeft.getCurrentFrame();
	 }else if(xMove > 0){
		 
		 return animRight.getCurrentFrame();
	 }else if(yMove < 0){
		
		 return animUp.getCurrentFrame();
	 }else {
		 
		 return animDown.getCurrentFrame();
	 
	 
	 }
 }

public Inventory getInventory() {
	return inventory;
}

public void setInventory(Inventory inventory) {
	this.inventory = inventory;
}
 
 
}
	
 

