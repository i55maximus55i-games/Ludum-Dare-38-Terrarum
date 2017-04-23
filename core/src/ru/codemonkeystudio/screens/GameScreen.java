package ru.codemonkeystudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import ru.codemonkeystudio.game.MyGdxGame;
import ru.codemonkeystudio.gameworld.GameRenderer;
import ru.codemonkeystudio.gameworld.GameWorld;

import javax.swing.*;

/**
 * Created by maximus on 22.04.17.
 */
public class GameScreen implements Screen {
	private MyGdxGame game;

	private GameWorld world;
	private GameRenderer renderer;

	public GameScreen(MyGdxGame game) {
		this.game = game;
		world = new GameWorld();
		renderer = new GameRenderer(world);
		world.setRenderer(renderer);
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		world.update(delta);
		renderer.render(delta);
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) game.setScreen(new MainMenuScreen(game));

		if (world.getPlayer().lives <= 0) {
			JOptionPane.showMessageDialog(null, "Вы проиграли");
			game.setScreen(new MainMenuScreen(game));
		}
		if (world.win) {
			game.setScreen(new MainMenuScreen(game));
			JOptionPane.showMessageDialog(null, "Вы выиграли");
		}
	}

	@Override
	public void resize(int width, int height) {
		renderer.resize(width, height);
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
