package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player, grass, water, lava, tree, rock, deadTree, pine, wall;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_left;

	
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/texturesheet.png"));
		
		player_down = new BufferedImage[2];
		
		player_down[0]= sheet.crop(0,0, width, height);
		player_down[1]= sheet.crop(0, height, width, height);
		
		player_up = new BufferedImage[2];
		
		player_up[0]= sheet.crop(0,height * 6 + 5, width, height);
		player_up[1]= sheet.crop(0,height * 7 + 5, width, height);
		
		player_right = new BufferedImage[2];
		
		player_right[0]= sheet.crop(0,height * 5 + 2, width, height);
		player_right[1]= sheet.crop(0, height * 4 + 2, width, height);
		
		player_left = new BufferedImage[2];
		
		player_left[0]= sheet.crop(0,height * 2 , width, height);
		player_left[1]= sheet.crop(0, height * 3 , width, height);
		
		
		
				
				
		water = sheet.crop(width + 1, height * 4, width, height);
		grass = sheet.crop(width + 1, 0 , width, height);
		lava = sheet.crop(width * 4 + 1, 0, width, height);
		tree = sheet.crop(width + 1, height, width, height);
		rock = sheet.crop(width * 3 + 1, height * 14, width, height);
		deadTree = sheet.crop(width * 2 + 1, height * 15, width, height);
		pine = sheet.crop(width * 10, height * 19, width, height);
		wall = sheet.crop(width * 7, height * 1 , width, height);
		
		
		
		
	}
}
