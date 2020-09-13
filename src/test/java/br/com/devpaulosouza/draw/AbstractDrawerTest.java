package br.com.devpaulosouza.draw;

import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class AbstractDrawerTest extends TestCase {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	private final PrintStream originalOut = System.out;

	private final PrintStream originalErr = System.err;

	public String getOutput() {
		String output = outContent.toString().replaceAll("\n", "");
		outContent.reset();
		return output;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();

		System.setOut(originalOut);
		System.setErr(originalErr);
	}

}
