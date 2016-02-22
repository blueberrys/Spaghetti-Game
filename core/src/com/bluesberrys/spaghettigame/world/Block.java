package com.bluesberrys.spaghettigame.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class Block {
	public static final float SIZE = 20;

	private Color color;

	public Block() {
		float r = (float) MathUtils.random.nextDouble();
		float g = (float) MathUtils.random.nextDouble();
		float b = (float) MathUtils.random.nextDouble();
		this.color = new Color(r, g, b, 1);
	}

	public void render(ShapeRenderer sr, float x, float y) {
		sr.setColor(color);
		sr.rect(x * SIZE, y * SIZE, SIZE, SIZE);
	}

}
