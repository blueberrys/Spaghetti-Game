package com.bluesberrys.spaghettigame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.bluesberrys.blugameengine_v3.base.TickableGame;

public class SpaghettiGame extends TickableGame {
	public static final float WIDTH = 800;
	public static final float HEIGHT = 600;

	// public static final float TICKS_PER_SEC = 30;
	// public static final float MAX_TICKS_PER_FRAME = 5;

	private OrthographicCamera cam;
	private ExtendViewport vPort;

	private PlayScreen playScreen;

	@Override
	public void create() {
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		vPort = new ExtendViewport(WIDTH, HEIGHT, cam);

		playScreen = new PlayScreen(cam);
		setScreen(playScreen);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		vPort.update(width, height);
	}
}
