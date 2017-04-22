package com.lozada.fitthecircle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.lozada.fitthecircle.entities.BlockEntity;
import com.lozada.fitthecircle.entities.CircleEntity;
import com.lozada.fitthecircle.entities.EntityFactory;
import com.lozada.fitthecircle.entities.PathEntity;
import com.lozada.fitthecircle.entities.PolygonEntity;

import java.util.LinkedList;


public class GameScreen extends BaseScreen implements collisionInterface {
    private Stage stage;
    private CircleEntity player;
    private PathEntity path;
    //private Vector3 position;
    private EntityFactory factory;

    private LinkedList<BlockEntity> blockList;
    GameScreen(Main game) {
        super(game);
        stage = new Stage(new FillViewport(640,960));
        //position = new Vector3(stage.getCamera().position);

        factory = new EntityFactory(game);
        player = factory.createCircle(new Vector2(4f, 2.25f));
        path = factory.createPath(new Vector2(4f, 2.25f));
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(new inputProcessor());
        player.reset();
        blockList = factory.createBlocks(0, this);

        stage.addActor(path);
        stage.addActor(player);
        stage.addActor(factory.createPoly(this, stage.getCamera()));
        //for(BlockEntity block : blockList)
        //stage.addActor(block);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void hitBlock(PolygonSprite poly) {

        if(overlaps(poly,player.bound)) {
            game.setScreen(game.gameOverScreen);
            player.reset();
        }
    }
    private boolean overlaps(PolygonSprite p, Circle c) {
        float[] vertices = p.getVertices();
        Vector2 center = new Vector2(c.x, c.y);

        float squareRadius = c.radius * c.radius;
        for (int i = 0; i < vertices.length-2; i += 2) {
                if (Intersector.intersectSegmentCircle(new Vector2(
                        vertices[i + 3], vertices[i + 2]), new Vector2(
                        vertices[i+1], vertices[i]), center, squareRadius))
                    return true;

        }
        return false;
    }
    private class inputProcessor extends inputInterface {
        private float midScreen;
        inputProcessor() {
            this.midScreen = Gdx.graphics.getWidth()/2;
        }
        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {

            if(screenX >= midScreen)
                player.incrementSpeed(true);
                else
                player.decrementSpeed(true);
            return true;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            if(screenX >= midScreen)
                player.incrementSpeed(false);
            else
                player.decrementSpeed(false);
            return true;
        }
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
        stage.clear();
        blockList.clear();
        blockList = null;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }


}
