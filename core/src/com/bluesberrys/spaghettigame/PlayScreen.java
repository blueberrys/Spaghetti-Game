package com.bluesberrys.spaghettigame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bluesberrys.spaghettigame.player.PlayerInput;
import com.bluesberrys.spaghettigame.world.World;

public class PlayScreen extends ScreenAdapter {

	private OrthographicCamera cam;

	private PlayerInput input;
	private float moveSpeed;

	private World world;

	private ShapeRenderer sr;
	
	public PlayScreen(OrthographicCamera cam) {
		this.cam = cam;
	}

	@Override
	public void show() {
		input = new PlayerInput(cam);
		Gdx.input.setInputProcessor(input);
		moveSpeed = 4;

		world = new World(20, 10);

		sr = new ShapeRenderer();
	}

	@Override
	public void render(float delta) {
		sr.setProjectionMatrix(cam.combined);

		sr.begin(ShapeType.Filled);
		sr.setColor(255, 255, 255, 1);
		world.render(sr);
		sr.end();
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
