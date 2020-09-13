package br.com.devpaulosouza.draw.algorithm.strategies;

import br.com.devpaulosouza.draw.Coordinates;
import br.com.devpaulosouza.draw.algorithm.DrawCircle;
import br.com.devpaulosouza.plotter.Plotter;
import br.com.devpaulosouza.draw.shape.Circle;

import java.util.Objects;

public class DrawCircleBresenham implements DrawCircle {

	private final Plotter plotter;

	public DrawCircleBresenham(Plotter plotter) {
		this.plotter = plotter;
	}

	@Override
	public void draw(long xc, long yc, long r) {
		long x, y, p;

		x = 0;
		y = r;
		p = 3 - 2 * r;

		plotCirclePoints(xc, yc, x, y);

		while (x < y) {
			if (p < 0) {
				p = p + 4 * x + 6;
			} else {
				p = p + 4 * (x - y) + 10;
				y = y -1;
			}
			x = x + 1;
			plotCirclePoints(xc, yc, x, y);
		}
	}

	@Override
	public void draw(Coordinates center, long r) {
		Objects.requireNonNull(center);

		draw(center.getX(), center.getY(), r);
	}

	@Override
	public void draw(Circle circle) {
		Objects.requireNonNull(circle);

		this.draw(circle.getPoint(), circle.getRadius());
	}

	private void plotCirclePoints (long xc, long yc, long x, long y) {
		plotter.setPixel(xc + x, yc + y);
		plotter.setPixel(xc - x, yc + y);
		plotter.setPixel(xc + x, yc - y);
		plotter.setPixel(xc - x, yc - y);

		plotter.setPixel(xc + y, yc + x);
		plotter.setPixel(xc - y, yc + x);
		plotter.setPixel(xc + y, yc - x);
		plotter.setPixel(xc - y, yc - x);
	}

}
