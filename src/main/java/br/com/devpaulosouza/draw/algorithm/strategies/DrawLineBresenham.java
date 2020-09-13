package br.com.devpaulosouza.draw.algorithm.strategies;

import br.com.devpaulosouza.draw.Coordinates;
import br.com.devpaulosouza.draw.algorithm.DrawLine;
import br.com.devpaulosouza.plotter.Plotter;
import br.com.devpaulosouza.draw.shape.Line;

import java.util.Objects;

public class DrawLineBresenham implements DrawLine {

	private final Plotter plotter;

	public DrawLineBresenham(Plotter plotter) {
		this.plotter = plotter;
	}

	@Override
	public void draw(long x1, long y1, long x2, long y2) {
		long dx, dy, x, y, c1, c2, p;
		int incrementX, incrementY;

		dx = x2 - x1;
		dy = y2 - y1;

		if (dx >= 0) {
			incrementX = 1;
		} else {
			incrementX = -1;
			dx = -dx;
		}

		if (dy >= 0) {
			incrementY = 1;
		} else {
			incrementY = -1;
			dy = -dy;
		}

		x = x1;
		y = y1;

		this.plotter.setPixel(x, y);

		if (dy < dx) {
			p = 2 * dy - dx;
			c1 = 2 * dy;
			c2 = 2 * (dy - dx);

			for (int i = 0; i < dx; ++i) {
				x += incrementX;
				if (p < 0) {
					p += c1;
				} else  {
					y += incrementY;
					p += c2;
				}
				this.plotter.setPixel(x, y);
			}

		} else {
			p = 2 * dx - dy;
			c1 = 2 * dx;
			c2 = 2 * (dx - dy);

			for (int i = 0; i < dy; ++i) {
				y += incrementY;
				if (p < 0) {
					p += c1;
				} else  {
					x += incrementX;
					p += c2;
				}
				this.plotter.setPixel(x, y);
			}
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
