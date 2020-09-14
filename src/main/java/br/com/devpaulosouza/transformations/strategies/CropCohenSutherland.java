package br.com.devpaulosouza.transformations.strategies;

import br.com.devpaulosouza.draw.Coordinates;
import br.com.devpaulosouza.plotter.Plotter;
import br.com.devpaulosouza.transformations.Crop;
import br.com.devpaulosouza.utils.MathUtils;

public class CropCohenSutherland implements Crop {

	private long xMin = 0;
	private long xMax = 0;
	private long yMin = 0;
	private long yMax = 0;

	private final Plotter plotter;

	public CropCohenSutherland(Plotter plotter) {
		this.plotter = plotter;
	}

	@Override
	public void crop(Coordinates p1, Coordinates p2, Coordinates pIn, Coordinates pFin) {
		boolean accept = false, done = false;
		byte c1, c2, cOut;
		long xIn = 0, yIn = 0;

		setLimits(p1.getX(), p1.getY(), p2.getX(), p2.getY());

		long x0 = pIn.getX();
		long y0 = pIn.getY();
		long x1 = pFin.getX();
		long y1 = pFin.getY();

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
					yIn = y0 + (y1-y0) * (xMin-x0)/(x1-x0);
				} else if ((cOut & 2) == 2) {
					xIn = xMax;
					yIn = y0 + (y1-y0) * (xMax-x0)/(x1-x0);
				} else if ((cOut & 4) == 4) {
					yIn = yMin;
					xIn = x0 + (x1-x0) * (yMin-y0)/(y1-y0);
				} else if ((cOut & 8) == 8) {
					yIn = yMax;
					xIn = x0 + (x1-x0) * (yMax-y0) / (y1-y0);
				}

				if (c1 == cOut) {
					x0 = xIn;
					y0 = yIn;
				} else {
					x1 = xIn;
					y1 = yIn;
				}
			}

		}

		if (accept) {
			plotter.setPixel(
					MathUtils.round(x0),
					MathUtils.round(y0));
			plotter.setPixel(
					MathUtils.round(x1),
					MathUtils.round(y1)
			);
		}

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
