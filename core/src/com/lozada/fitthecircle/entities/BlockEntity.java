package com.lozada.fitthecircle.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.lozada.fitthecircle.Constants;
import com.lozada.fitthecircle.GameScreen;

/**
 * Created by GONZALO on 9/4/2017.
 */

public class BlockEntity extends Actor {
    /** The player texture. */
    private Sprite spriteLeft, spriteRight;
    private Rectangle boundLeft, boundRight;
    private float openLen;
    private Vector2 position;
    private Circle player;
    private Pixmap color;
    private GameScreen screen;
    private Texture texture;
    BlockEntity(Circle player,GameScreen screen, Vector2 position, float openLen) {
        this.screen = screen;
        color = new Pixmap(1,1, Pixmap.Format.RGB888);
        color.setColor(Color.BLACK);
        color.fill();
        texture = new Texture(color);
        spriteLeft = new Sprite(texture);
        spriteRight = new Sprite(texture);

        this.position = position;
        this.player = player;
        this.openLen = openLen/2;
        setSize(8* Constants.PIXELS_IN_METER, 0.5f*Constants.PIXELS_IN_METER);
        spriteLeft.setSize(getWidth(),getHeight());
        spriteLeft.setOriginCenter();
        spriteRight.setSize(getWidth(),getHeight());
        spriteRight.setOriginCenter();
        boundLeft = new Rectangle((position.x - 4) * Constants.PIXELS_IN_METER, (position.y - 0.25f) * Constants.PIXELS_IN_METER, getWidth(),getHeight());
        boundRight = new Rectangle((position.x + 4) * Constants.PIXELS_IN_METER, (position.y - 0.25f) * Constants.PIXELS_IN_METER, getWidth(),getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition((position.x - 4) * Constants.PIXELS_IN_METER,
                (position.y - 0.25f) * Constants.PIXELS_IN_METER);

        spriteLeft.setPosition(getX()-(4+openLen)*Constants.PIXELS_IN_METER,getY());
        boundLeft.setPosition(spriteLeft.getX()-0.25f*Constants.PIXELS_IN_METER,spriteLeft.getY()-0.25f*Constants.PIXELS_IN_METER);

        spriteRight.setPosition(getX()+(4+openLen)*Constants.PIXELS_IN_METER,getY());
        boundRight.setPosition(spriteRight.getX()-0.25f*Constants.PIXELS_IN_METER, spriteRight.getY()-0.25f*Constants.PIXELS_IN_METER);

        spriteLeft.draw(batch);
        spriteRight.draw(batch);
    }

    @Override
    public void act(float delta) {
        position.y -= 1.5f*delta;
        if(position.y < -0.25f) {
            texture.dispose();
            this.remove();
            return;
        }
        if(Intersector.overlaps(player, boundLeft)) {
            color.setColor(Color.BLUE);
            color.fill();
            texture = new Texture(color);
            spriteLeft.setTexture(texture);
            screen.currentState = GameScreen.GAME_OVER;

        } else {
            color.setColor(Color.BLACK);
            color.fill();
            texture = new Texture(color);
            spriteLeft.setTexture(texture);
        }

        if(Intersector.overlaps(player, boundRight)) {
            color.setColor(Color.BLUE);
            color.fill();
            texture = new Texture(color);
            spriteRight.setTexture(texture);
            screen.currentState = GameScreen.GAME_OVER;
        } else {
            color.setColor(Color.BLACK);
            color.fill();
            texture = new Texture(color);
            spriteRight.setTexture(texture);
        }

    }
}
