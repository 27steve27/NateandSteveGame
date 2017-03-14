package dev.codenmore.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.ui.ClickListener;
import dev.codenmore.tilegame.ui.UIImageButton;
import dev.codenmore.tilegame.ui.UIManager;

public class MenuState extends State{
	
	private UIManager uiManager;
	
	
	public MenuState(Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.player_down, new ClickListener(){

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				 	
			}}));
	}

	@Override
	public void tick() {
		// if both are clicked then switches game state if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
			//State.setState(handler.getGame().gameState);
		
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
		uiManager.render(g);
	}

}
