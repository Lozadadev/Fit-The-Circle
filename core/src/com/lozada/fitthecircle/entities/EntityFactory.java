package com.lozada.fitthecircle.entities;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.lozada.fitthecircle.GameScreen;

import java.util.LinkedList;

/**
 * This class creates entities using Factory Methods.
 */
public class EntityFactory {

    private AssetManager manager;
    private GameScreen screen;
    private CircleEntity player;
    /**
     * Create a new entity factory using the provided asset manager.
     *
     * @param manager the asset manager used to generate things.
     */
    public EntityFactory(AssetManager manager, GameScreen screen) {
        this.manager = manager;
        this.screen = screen;
    }

    public CircleEntity createCircle(Vector2 position) {
        Texture playerTexture = manager.get("player.png");
        this.player = new CircleEntity(playerTexture, position);
        return player;
    }
    public com.lozada.fitthecircle.entities.PathEntity createPath(Vector2 position) {
        Texture pathTexture = manager.get("path.png");
        return new com.lozada.fitthecircle.entities.PathEntity(pathTexture, position);
    }

    public LinkedList<BlockEntity> createBlocks(int dificulty, int state) {
        //8x12 SCREEN
        LinkedList<BlockEntity> ret = new LinkedList<BlockEntity>();
        state = GameScreen.GAME_OVER;
        switch (dificulty) {
            case 0:
                ret.add(new BlockEntity(player.bound,screen, new Vector2(5.1f,8), 1.2f));
                ret.add(new BlockEntity(player.bound,screen, new Vector2(4.7f,9), 1.2f));
                ret.add(new BlockEntity(player.bound,screen, new Vector2(4.3f,10), 1.2f));
                ret.add(new BlockEntity(player.bound,screen, new Vector2(3.9f,11), 1.2f));
                ret.add(new BlockEntity(player.bound,screen, new Vector2(4.5f,13), 1.2f));
                ret.add(new BlockEntity(player.bound,screen, new Vector2(4.9f,14), 1.2f));
                ret.add(new BlockEntity(player.bound,screen, new Vector2(5.3f,15), 1.2f));
                ret.add(new BlockEntity(player.bound,screen, new Vector2(0,17f), 0));
                break;
            case 1:
                break;
            default:
                break;
        }

        return ret;
    }
}
