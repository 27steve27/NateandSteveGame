	package dev.codenmore.tilegame.entities.statics;

	import java.awt.Graphics;
	import java.util.Random;

	import dev.codenmore.tilegame.Handler;
	import dev.codenmore.tilegame.gfx.Assets;
	import dev.codenmore.tilegame.items.Item;
	import dev.codenmore.tilegame.tiles.Tile;
	import dev.codenmore.tilegame.utils.RandomNumber;

public class Rock extends StaticEntity{

		public Rock(Handler handler, float x, float y) {
			super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
			bounds.x = 6;
			bounds.y = 6;
			bounds.width = 17;
			bounds.height = 22;
			health = 1;
			
			
		}
		@Override
		public void die(){
			int droproll = RandomNumber.randomInt(1, 128);
			if(droproll >=1 && droproll <= 128)
			handler.getWorld().getItemManager().addItem(Item.pebbleItem.createNew((int) x,(int) y));
		}
		
		@Override
		public void tick() {
			
		}

		@Override
		public void render(Graphics g) {
			g.drawImage(Assets.rock,(int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
			
			//g.setColor(Color.red);
			//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
					//(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		}

	}


