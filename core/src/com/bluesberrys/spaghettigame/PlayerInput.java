package com.bluesberrys.spaghettigame;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class PlayerInput extends InputAdapter {

	public final Vector2 move;
	private OrthographicCamera cam;

	public PlayerInput(OrthographicCamera cam) {
		this.move = new Vector2();
		this.cam = cam;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
			case Input.Keys.W:
				move.y += 1;
				break;
			case Input.Keys.S:
				move.y -= 1;
				break;
			case Input.Keys.D:
				move.x += 1;
				break;
			case Input.Keys.A:
				move.x -= 1;
				break;
			default:
				break;
		}

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
			case Input.Keys.W:
				move.y -= 1;
				break;
			case Input.Keys.S:
				move.y += 1;
				break;
			case Input.Keys.D:
				move.x -= 1;
				break;
			case Input.Keys.A:
				move.x += 1;
				break;
			default:
				break;
		}

		return false;
	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		cam.zoom += amount * 0.1;
		cam.update();
		return false;
	}
}
