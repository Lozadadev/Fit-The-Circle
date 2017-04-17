package com.lozada.fitthecircle.entities;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.lozada.fitthecircle.GameScreen;
import com.lozada.fitthecircle.Main;

import java.util.LinkedList;

/**
 * This class creates entities using Factory Methods.
 */
public class EntityFactory {

    private AssetManager manager;
    private Main game;
    private GameScreen screen;
    private CircleEntity player;
    /**
     * Create a new entity factory using the provided asset manager.
     *
     * @param manager the asset manager used to generate things.
     */
    public EntityFactory(Main game, GameScreen screen) {
        this.game = game;
        this.manager = game.getManager();
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

    public LinkedList<BlockEntity> createBlocks(int dificulty) {
        //8x12 SCREEN
        LinkedList<BlockEntity> ret = new LinkedList<BlockEntity>();
        switch (dificulty) {
            case 0:
                ret.add(new BlockEntity(player.bound,game, new Vector2(5.1f,8), 1.2f));
                ret.add(new BlockEntity(player.bound,game, new Vector2(4.7f,9), 1.2f));
                ret.add(new BlockEntity(player.bound,game, new Vector2(4.3f,10), 1.2f));
                ret.add(new BlockEntity(player.bound,game, new Vector2(3.9f,11), 1.2f));
                ret.add(new BlockEntity(player.bound,game, new Vector2(4.5f,13), 1.2f));
                ret.add(new BlockEntity(player.bound,game, new Vector2(4.9f,14), 1.2f));
                ret.add(new BlockEntity(player.bound,game, new Vector2(5.3f,15), 1.2f));
                ret.add(new BlockEntity(player.bound,game, new Vector2(0,17f), 0));
                break;
            case 1:
                break;
            default:
                break;
        }

        return ret;
    }
}
