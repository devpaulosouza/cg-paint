package br.com.devpaulosouza.draw.algorithm.strategies;

import br.com.devpaulosouza.draw.Coordinates;
import br.com.devpaulosouza.draw.algorithm.DrawLine;
import br.com.devpaulosouza.plotter.Plotter;
import br.com.devpaulosouza.draw.shape.Line;
import br.com.devpaulosouza.utils.MathUtils;

import java.util.Objects;

public class DrawLineDda implements DrawLine {

	private final Plotter plotter;

	public DrawLineDda(Plotter plotter) {
		this.plotter = plotter;
	}

	@Override
	public void draw(long x0, long y0, long x1, long y1) {
		long dx, dy, steps;
		double x, y;
		float incrementX, incrementY;

		dx = x1 - x0;
		dy = y1 - y0;

		steps = Math.max(Math.abs(dx), Math.abs(dy));

		incrementX = (float) dx / steps;
		incrementY = (float) dy / steps;
		x = x0;
		y = y0;

		this.plotter.setPixel(MathUtils.round(x), MathUtils.round(y));

		for (int i = 0; i < steps; ++i) {
			x += incrementX;
			y += incrementY;
			this.plotter.setPixel(MathUtils.round(x), MathUtils.round(y));
		}
	}

	@Override
	public void draw(Coordinates p0, Coordinates p1) {
		Objects.requireNonNull(p0);
		Objects.requireNonNull(p1);

		this.draw(p0.getX(), p0.getY(), p1.getX(), p1.getY());
	}

	@Override
	public void draw(Line line) {
		Objects.requireNonNull(line);

		this.draw(line.getP0(), line.getP1());
	}

}
