package br.com.devpaulosouza.draw.algorithm.strategies;

import br.com.devpaulosouza.draw.AbstractDrawerTest;
import br.com.devpaulosouza.draw.algorithm.DrawLine;
import br.com.devpaulosouza.plotter.debug.DebugPlotter;

public class LineBresenhamTest extends AbstractDrawerTest {

	private final DrawLine drawer;

	public LineBresenhamTest() {
		this.drawer = new DrawLineBresenham(new DebugPlotter());
	}

	public void test() {
		this.drawer.draw(5, -1, 9, 2);
		assertEquals("(5, -1) -> (9, 2)", "(5, -1)(6, 0)(7, 1)(8, 1)(9, 2)", getOutput());

		this.drawer.draw(9, 2, 5, -1);
		assertEquals("(9, 2) -> (5, -1)", "(9, 2)(8, 1)(7, 0)(6, 0)(5, -1)", getOutput());

		this.drawer.draw(5, -1, 7, 3);
		assertEquals("(5, -1) -> (7, 3)", "(5, -1)(6, 0)(6, 1)(7, 2)(7, 3)", getOutput());
	}

}
