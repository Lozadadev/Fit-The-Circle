package com.lozada.fitthecircle.entities;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.lozada.fitthecircle.GameScreen;
import com.lozada.fitthecircle.Main;
import com.lozada.fitthecircle.collisionInterface;

import java.util.LinkedList;

/**
 * This class creates entities using Factory Methods.
 */
public class EntityFactory {

    private AssetManager manager;
    private CircleEntity player;

    public EntityFactory(Main game) {
        this.manager = game.getManager();
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

    public LinkedList<BlockEntity> createBlocks(int dificulty, collisionInterface cI) {
        //8x12 SCREEN
        LinkedList<BlockEntity> ret = new LinkedList<BlockEntity>();
        switch (dificulty) {
            case 0:
                ret.add(new BlockEntity(player.bound,cI, new Vector2(5.1f,8), 1.7f));

                break;
            case 1:
                break;
            default:
                break;
        }

        return ret;
    }
    public PolygonEntity createPoly(collisionInterface cI, Camera camera){
        return new PolygonEntity(cI, new Vector2(1.6f,1.2f), camera);
    }
}
