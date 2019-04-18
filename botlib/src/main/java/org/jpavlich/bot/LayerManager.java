package org.jpavlich.bot;

import java.util.ArrayList;
import java.util.List;

public class LayerManager {


	private List<Layer> layers = new ArrayList<>();


	public void addLayer(Layer layer) {
		layers.add(layer);
	}

	public void draw() {
		for (Layer layer : layers) {
			layer.draw();
		}
	}

}
