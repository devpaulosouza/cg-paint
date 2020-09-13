package br.com.devpaulosouza.plotter.debug;

import br.com.devpaulosouza.plotter.Plotter;

public class DebugPlotter implements Plotter {

    private String delimiter = "\n";

    public DebugPlotter() {

    }

    public DebugPlotter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public void setPixel(int x, int y) {
        //noinspection RedundantCast
        setPixel((long) x,  (long) y);
    }

    @Override
    public void setPixel(long x, long y) {
        System.out.printf("(%d, %d)%s", x, y, delimiter);
    }

}
