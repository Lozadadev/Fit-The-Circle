package com.lozada.fitthecircle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;


public class Main extends Game {
	private AssetManager manager;
    BaseScreen menuScreen, gameScreen;
    public BaseScreen gameOverScreen;
	@Override
	public void create() {
		// Initialize the asset manager. We add every aset to the manager so that it can be loaded
		// inside the LoadingScreen screen. Remember to put the name of the asset in the first
		// argument, then the type of the asset in the second argument.
		manager = new AssetManager();
		manager.load("player.png", Texture.class);
		manager.load("path.png", Texture.class);
		manager.finishLoading();

		// Enter the loading screen to load the assets.
		LoadingScreen loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
	}
	void finishLoading() {
		menuScreen = new MenuScreen(this);
		gameScreen = new GameScreen(this);
		gameOverScreen = new GameOverScreen(this);
		setScreen(menuScreen);
	}
	public AssetManager getManager() {
		return manager;
	}
}
