package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class LavaTile extends Tile{
	
	public LavaTile(int id){
		super(Assets.lava, id);
		
	}

	@Override
	public boolean isSolid(){
		return true;
	}
	
}
