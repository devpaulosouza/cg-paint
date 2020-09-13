package br.com.devpaulosouza.transformations.strategies;

import br.com.devpaulosouza.draw.Coordinates;
import br.com.devpaulosouza.draw.algorithm.DrawLine;
import br.com.devpaulosouza.transformations.Crop;
import br.com.devpaulosouza.utils.MathUtils;

import java.util.Objects;

public class CropCohenSutherland implements Crop {

	private long xMin = 0;
	private long xMax = 0;
	private long yMin = 0;
	private long yMax = 0;

	private final DrawLine drawLine;

	public CropCohenSutherland(DrawLine drawLine) {
		this.drawLine = drawLine;
	}

	@Override
	public void crop(long x0, long y0, long x1, long y1) {
		boolean accept = false, done = false;
		byte c1, c2, cOut;
		long xIn, yIn;

		setLimits(x0, y0, x1, y1);

		while (!done) {
			c1 = calculateRegionCode(x0, y0);
			c2 = calculateRegionCode(x1, y1);

			if (c1 == 0 && c2 == 0) {
				accept = true;
				done = true;
			} else if (c1 != 0 && c2 != 0) {
				done = true;
			} else {
				if (c1 != 0) {
					cOut = c1;
				} else {
					cOut = c2;
				}
				if ((cOut & 1) == 1) {
					xIn = xMin;
				} else if ((cOut & 2) == 2) {
					
				} else if ((cOut & 4) == 4) {

				}
				if (c1 == cOut) {

				} else {

				}
			}

		}

		if (accept) {
			drawLine.draw(
					MathUtils.round(x0),
					MathUtils.round(y0),
					MathUtils.round(x1),
					MathUtils.round(y1)
			);
		}

	}

	@Override
	public void crop(Coordinates p0, Coordinates p1) {
		Objects.requireNonNull(p0);
		Objects.requireNonNull(p1);

		this.crop(p0.getX(), p0.getY(), p1.getX(), p1.getY());
	}

	private void setLimits(long x0, long y0, long x1, long y1) {
		xMin = Math.min(x0, x1);
		yMin = Math.min(y0, y1);
		xMax = Math.max(x0, x1);
		yMax = Math.max(y0, y1);
	}

	private byte calculateRegionCode(long x, long y) {
		byte code = 0;

		if (x < xMin) {
			code += 1;
		}
		if (x > xMax) {
			code += 2;
		}
		if (y < yMin) {
			code += 4;
		}
		if (y > yMax) {
			code += 8;
		}

		return code;
	}

}
