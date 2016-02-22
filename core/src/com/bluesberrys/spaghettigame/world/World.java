package com.bluesberrys.spaghettigame.world;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class World {
	private int width;
	private int height;
	private Block[][] blocks;

	public World() {
		this(50, 50);
	}

	public World(int width, int height) {
		this.width = width;
		this.height = height;
		this.blocks = new Block[height][width];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width - 1; x++) {
				blocks[y][x] = new Block();
			}
		}
	}

	public void render(ShapeRenderer sr) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width - 1; x++) {
				blocks[y][x].render(sr, x, y);
			}
		}
	}

}
