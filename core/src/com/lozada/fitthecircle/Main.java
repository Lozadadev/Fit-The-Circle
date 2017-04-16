package com.lozada.fitthecircle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;


public class Main extends Game {
	private AssetManager manager;
	@Override
	public void create() {
		// Initialize the asset manager. We add every aset to the manager so that it can be loaded
		// inside the LoadingScreen screen. Remember to put the name of the asset in the first
		// argument, then the type of the asset in the second argument.
		manager = new AssetManager();
		manager.load("player.png", Texture.class);
		manager.load("path.png", Texture.class);
		manager.finishLoading();

		setScreen(new GameScreen(this));
	}
	public AssetManager getManager() {
		return manager;
	}
}
