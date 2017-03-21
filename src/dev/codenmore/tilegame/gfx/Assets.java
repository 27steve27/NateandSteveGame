package dev.codenmore.tilegame.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static Font font28;
	
	public static BufferedImage player, grass, water, lava, tree, rock, deadTree, pine, wall;
	//Items
	public static BufferedImage wood, pebble;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_left;
	public static BufferedImage atkup, atkdown, atkleft, atkright;
	public static BufferedImage	inventoryScreen;

	
	
	public static void init(){
		//font28 = FontLoader.loadFont("/res/fonts/AGENCYR.ttf", 28);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/texturesheet.png"));
		
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
		
		
		//Player Animations 
		player_down = new BufferedImage[2];
		
		player_down[0]= sheet.crop(width * 4,0, width, height);
		player_down[1]= sheet.crop(width * 5, 0, width, height);
		
		player_up = new BufferedImage[2];
		
		player_up[0]= sheet.crop(width * 10, 0, width, height);
		player_up[1]= sheet.crop(width * 11, 0, width, height);
		
		player_right = new BufferedImage[2];
		
		player_right[0]= sheet.crop(width * 8, 0, width, height);
		player_right[1]= sheet.crop(width * 9, 0, width, height);
		
		player_left = new BufferedImage[2];
		
		player_left[0]= sheet.crop(width * 6, 0 , width, height);
		player_left[1]= sheet.crop(width * 7, 0 , width, height);
		
		
		
		//Items
		wood = sheet.crop(width * 4, height * 6, width, height);
		pebble = sheet.crop(width, height * 14, width, height);
				
		//Entities		
		water = sheet.crop(width, height * 4, width, height);
		grass = sheet.crop(0 , height , width, height);
		lava = sheet.crop(width * 3, height, width, height);
		tree = sheet.crop(0, height * 2, width, height);
		rock = sheet.crop(width * 2, height * 15, width, height);
		deadTree = sheet.crop(0 , height * 16, width, height);
		pine = sheet.crop(width * 9, height * 20, width, height);
		wall = sheet.crop(width * 6, height * 2 , width, height);
		
		
		atkleft = water = sheet.crop(width , 0, width, height);
		atkright = sheet.crop(width * 2, 0, width, height);
		atkup = sheet.crop(width * 3, 0, width, height);
		atkdown = sheet.crop(0, 0, width, height);
	
		
	}
}
