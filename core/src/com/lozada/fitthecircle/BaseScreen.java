package com.lozada.fitthecircle;

import com.badlogic.gdx.Screen;

/**
 * Created by GONZALO on 8/4/2017.
 */

public abstract class BaseScreen implements Screen {
    protected Main game;
    public BaseScreen(Main game) {
        this.game = game;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
