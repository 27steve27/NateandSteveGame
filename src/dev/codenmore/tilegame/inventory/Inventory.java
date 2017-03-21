package dev.codenmore.tilegame.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.Text;
import dev.codenmore.tilegame.items.Item;

public class Inventory {
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	public int inventoryPositionX = 0;
	public int inventoryPositionY = 340;
	
	private int selectedItem = 0;
	
	
	
	public Inventory(Handler handler){
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
		addItem(Item.pebbleItem.createNew(5));
		addItem(Item.woodItem.createNew(4));
	}
	
	
	
	public void tick(){
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)){
			active = !active;
		}
		if(!active)
		return;
	}
	
	public void render(Graphics g){
		if(!active)
			return;
		
		g.drawImage(Assets.inventoryScreen, inventoryPositionX, inventoryPositionY, 300, 400, null);
		
		int len = inventoryItems.size();
		if(len == 0){
			return;
		}
		
		
		}
	
	
	
	//Inventory methods	
	
	public void addItem(Item item){ 
		for(Item i : inventoryItems){
			if(i.getId() == item.getId()){
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}


	public Handler getHandler() {
		return handler;
	}



	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	
	
}
