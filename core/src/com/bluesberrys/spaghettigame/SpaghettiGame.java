package com.bluesberrys.spaghettigame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class SpaghettiGame extends ApplicationAdapter {
	public static final float WIDTH = 800;
	public static final float HEIGHT = 600;

	public static final float TICKS_PER_SEC = 30;
	public static final float MAX_TICKS_PER_FRAME = 5;
	public static final float TIME_PER_TICK = 1 / TICKS_PER_SEC;
	public static final float MAX_FRAME_TIME = TIME_PER_TICK * MAX_TICKS_PER_FRAME;

	private OrthographicCamera cam;
	private ExtendViewport vPort;

	private float tickTimeAccumulator;

	private SpriteBatch batch;
	private Texture img;

	@Override
	public void create() {
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		vPort = new ExtendViewport(WIDTH, HEIGHT, cam);

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	public void tick(float timePerTick) {
		
	}

	@Override
	public void render() {
		// tick
		float frameTime = Math.min(Gdx.graphics.getDeltaTime(), MAX_FRAME_TIME);
		tickTimeAccumulator += frameTime;
		while (tickTimeAccumulator >= TIME_PER_TICK) {
			tick(TIME_PER_TICK);
			tickTimeAccumulator -= TIME_PER_TICK;
		}

		// render
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();

		batch.setProjectionMatrix(cam.combined);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		vPort.update(width, height);
	}
}
