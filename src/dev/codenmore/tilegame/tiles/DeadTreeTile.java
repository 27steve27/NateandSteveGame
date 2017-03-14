package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class DeadTreeTile extends Tile{
	
	public DeadTreeTile(int id){
		super(Assets.deadTree, id);
		
	}

	@Override
	public boolean isSolid(){
		return true;
	}
	
}
