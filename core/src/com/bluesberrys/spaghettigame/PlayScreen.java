package com.bluesberrys.spaghettigame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bluesberrys.blugameengine_v3.base.TickableScreen;
import com.bluesberrys.blugameengine_v3.events.input.InputEventsManager;
import com.bluesberrys.spaghettigame.world.World;

public class PlayScreen implements TickableScreen {
	
	private OrthographicCamera cam;

	private ShapeRenderer sr;
	private InputEventsManager input;

	private World world;

	public PlayScreen(OrthographicCamera cam) {
		this.cam = cam;

		this.sr = new ShapeRenderer();
		this.input = new InputEventsManager();
		input.getScrolledEvent().addTask(data -> {
			cam.zoom += data * 0.1;
			cam.update();
		});
		input.getTouchDownEvent().addTask(data -> {

		});
		input.getTouchDraggedEvent().addTask(data -> {

		});

		this.world = new World();
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(input);
	}

	@Override
	public void render(float delta) {
		sr.setProjectionMatrix(cam.combined);
		sr.begin(ShapeType.Filled);
		world.render(sr);
		sr.end();
	}

	@Override
	public void tick(float tickTime) {
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
