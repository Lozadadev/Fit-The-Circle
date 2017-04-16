package com.lozada.fitthecircle.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.lozada.fitthecircle.Constants;


public class PathEntity extends Actor{
    /** The player texture. */
    private Sprite sprite;

    /** The body for this player. */
    private Vector2 position;


    public PathEntity(Texture texture, Vector2 position) {
        sprite = new Sprite(texture);
        this.position = position;

        setSize(2.5f * Constants.PIXELS_IN_METER,2.5f * Constants.PIXELS_IN_METER);
        sprite.setSize(getWidth(), getHeight());
        sprite.setOriginCenter();

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition((position.x - 1.25f) * Constants.PIXELS_IN_METER,
                (position.y - 1.25f) * Constants.PIXELS_IN_METER);
        sprite.setPosition(getX(),getY());

        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {

    }

    public void detach() {

    }
}
