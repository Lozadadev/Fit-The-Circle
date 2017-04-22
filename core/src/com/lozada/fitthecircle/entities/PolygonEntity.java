package com.lozada.fitthecircle.entities;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.lozada.fitthecircle.Constants;
import com.lozada.fitthecircle.collisionInterface;

/**
 * Created by gonzalo on 21/04/2017.
 */

public class PolygonEntity extends Actor {
    private PolygonSprite sprite;
    private PolygonSpriteBatch batch2;
    private PolygonRegion bound;
    private Vector2 position;
    private collisionInterface game;
    private Texture texture;
    private Camera camera;
    PolygonEntity(collisionInterface game, Vector2 position, Camera camera) {
        this.game = game;
        this.camera = camera;
        Pixmap color = new Pixmap(1, 1, Pixmap.Format.RGB888);
        color.setColor(Color.BLACK);
        color.fill();
        texture = new Texture(color);

        this.position = position;

        bound = new PolygonRegion(new TextureRegion(texture),new float[] {
                                    0, 0,
                                    100, 0,
                                    70, 100,
                                    0,100
        }, new short[] {0, 1, 2,
                        0, 3, 2});

        sprite = new PolygonSprite(bound);
        batch2 = new PolygonSpriteBatch();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        batch2.setProjectionMatrix(batch.getProjectionMatrix());
        sprite.setPosition((position.x)*Constants.PIXELS_IN_METER,(position.y)*Constants.PIXELS_IN_METER);
        batch2.begin();
        sprite.draw(batch2);
        batch2.end();
        batch.begin();
    }

    @Override
    public void act(float delta) {
        //position.y -= delta;
        /*if(position.y < -0.25f) {
            texture.dispose();
            this.remove();
            return;
        }*/

            game.hitBlock(sprite);



    }
}
