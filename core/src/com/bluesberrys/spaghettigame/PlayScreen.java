package com.bluesberrys.spaghettigame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayScreen implements Screen {

	private OrthographicCamera cam;

	private SpriteBatch batch;
	private Texture img;

	public PlayScreen(OrthographicCamera cam) {
		this.cam = cam;

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void show() {
	}

	public void tick(float tickTime) {

	}

	@Override
	public void render(float delta) {
		batch.setProjectionMatrix(cam.combined);

		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
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
