package com.bluesberrys.spaghettigame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.bluesberrys.blugameengine_v3.base.TickableScreen;
import com.bluesberrys.blugameengine_v3.events.input.InputEventsManager;
import com.bluesberrys.spaghettigame.world.World;

public class PlayScreen implements TickableScreen {

	private OrthographicCamera cam;
	private Vector2 camMove;
	private float camMoveSpeed;

	private ShapeRenderer sr;
	private InputEventsManager input;

	private World world;

	public PlayScreen(OrthographicCamera cam) {
		this.cam = cam;
		this.camMove = new Vector2();
		this.camMoveSpeed = 1f;

		this.sr = new ShapeRenderer();
		this.input = new InputEventsManager();
		initInput();

		this.world = new World();
	}

	private void initInput() {
		input.getKeyDownEvent().addTask(data -> {
			switch (data) {
				case Input.Keys.W:
					camMove.y += camMoveSpeed;
					break;
				case Input.Keys.S:
					camMove.y -= camMoveSpeed;
					break;
				case Input.Keys.D:
					camMove.x += camMoveSpeed;
					break;
				case Input.Keys.A:
					camMove.x -= camMoveSpeed;
					break;
			}
		});
		input.getKeyUpEvent().addTask(data -> {
			switch (data) {
				case Input.Keys.W:
					camMove.y -= camMoveSpeed;
					break;
				case Input.Keys.S:
					camMove.y += camMoveSpeed;
					break;
				case Input.Keys.D:
					camMove.x -= camMoveSpeed;
					break;
				case Input.Keys.A:
					camMove.x += camMoveSpeed;
					break;
			}
		});
		input.getScrolledEvent().addTask(data -> {
			cam.zoom += data * 0.01;
			if (cam.zoom <= 0) {
				cam.zoom -= data * 0.01;
			}
			cam.update();
		});
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(input);

		cam.zoom = 0.1f;
		cam.update();
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
		if (camMove.x != 0 || camMove.y != 0) {
			cam.position.x += camMove.x;
			cam.position.y += camMove.y;
			cam.update();
		}
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
