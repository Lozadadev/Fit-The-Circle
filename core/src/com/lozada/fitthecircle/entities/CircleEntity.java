package com.lozada.fitthecircle.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.lozada.fitthecircle.Constants;


public class CircleEntity extends Actor{
    /** The player texture. */
    private Sprite sprite;
    Circle bound;
    /** The world instance this player is in. */
    private float degrees, speed, accel;
    private Vector2 position;
    private final float x;
    private final float y;

    CircleEntity(Texture texture, Vector2 position) {
        sprite = new Sprite(texture);
        x = position.x;
        y = position.y;
        setSize(0.5f*Constants.PIXELS_IN_METER, 0.5f*Constants.PIXELS_IN_METER);
        sprite.setSize(getWidth(),getHeight());
        sprite.setOriginCenter();
        bound = new Circle((position.x - 0.25f) * Constants.PIXELS_IN_METER,
                (position.y - 0.25f) * Constants.PIXELS_IN_METER, 0.25f*Constants.PIXELS_IN_METER);
        speed = 1.5f;
        accel = 1;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition((position.x - 0.25f) * Constants.PIXELS_IN_METER,
                (position.y - 0.35f) * Constants.PIXELS_IN_METER);
        sprite.setPosition(getX(),getY());
        bound.setPosition(getX(),getY());
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        degrees = degrees >= 360? 0:degrees+(speed+delta)*accel;
        position = calculateOrbit(degrees,1.25f);
    }
    public void incrementSpeed(boolean set) {
        if(set)accel = 1.5f;else accel =1;
    }
    public void decrementSpeed(boolean set) {
        if(set)accel = 0.4f;else accel =1;
    }
    private Vector2 calculateOrbit(float currentOrbitDegrees, float distance) {
        float radians = MathUtils.degreesToRadians*currentOrbitDegrees;
        return new Vector2(x+MathUtils.cos(radians) * distance,y+ (MathUtils.sin(radians) * distance));
    }
    public void reset() {
        accel=1;
        degrees = 0;
    }
}
