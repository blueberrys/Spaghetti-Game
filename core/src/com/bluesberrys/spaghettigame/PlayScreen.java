package com.bluesberrys.spaghettigame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class PlayScreen extends ScreenAdapter {

	private OrthographicCamera cam;

	private PlayerInput input;
	private float moveSpeed;

	private ShapeRenderer sr;

	private SpriteBatch batch;
	private Texture img;

	public PlayScreen(OrthographicCamera cam) {
		this.cam = cam;
	}

	@Override
	public void show() {
		input = new PlayerInput(cam);
		Gdx.input.setInputProcessor(input);
		moveSpeed = 2;

		sr = new ShapeRenderer();

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render(float delta) {
		sr.setProjectionMatrix(cam.combined);

		sr.begin(ShapeType.Filled);
		sr.setColor(0, 0, 0, 1);
		sr.rect(20, 20, 20, 20);
		sr.circle(20, 40, 20);
		sr.end();

		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	public void tick(float tickTime) {
		if (input.move.x != 0 || input.move.y != 0) {
			cam.position.x += input.move.x * moveSpeed;
			cam.position.y += input.move.y * moveSpeed;
			cam.update();
		}
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}
}
