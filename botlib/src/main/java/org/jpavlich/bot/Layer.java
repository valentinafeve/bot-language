package org.jpavlich.bot;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PMatrix;
import processing.core.PMatrix2D;
import processing.core.PMatrix3D;
import processing.core.PShape;
import processing.core.PStyle;
import processing.core.PSurface;
import processing.data.JSONArray;
import processing.data.JSONObject;
import processing.data.Table;
import processing.data.XML;
import processing.event.Event;
import processing.event.KeyEvent;
import processing.event.MouseEvent;
import processing.opengl.PGL;
import processing.opengl.PShader;

public abstract class Layer {

	private PApplet applet;

	public Layer(PApplet applet) {
		this.applet = applet;
	}

	public abstract void init();

	public abstract void draw();

	public int hashCode() {
		return applet.hashCode();
	}

	public boolean equals(Object obj) {
		return applet.equals(obj);
	}

	public String toString() {
		return applet.toString();
	}

	public PSurface getSurface() {
		return applet.getSurface();
	}

	public void settings() {
		applet.settings();
	}

	public final int sketchWidth() {
		return applet.sketchWidth();
	}

	public final int sketchHeight() {
		return applet.sketchHeight();
	}

	public final String sketchRenderer() {
		return applet.sketchRenderer();
	}

	public final int sketchSmooth() {
		return applet.sketchSmooth();
	}

	public final boolean sketchFullScreen() {
		return applet.sketchFullScreen();
	}

	public final int sketchDisplay() {
		return applet.sketchDisplay();
	}

	public final String sketchOutputPath() {
		return applet.sketchOutputPath();
	}

	public final OutputStream sketchOutputStream() {
		return applet.sketchOutputStream();
	}

	public final int sketchWindowColor() {
		return applet.sketchWindowColor();
	}

	public final int sketchPixelDensity() {
		return applet.sketchPixelDensity();
	}

	public int displayDensity() {
		return applet.displayDensity();
	}

	public void pixelDensity(int density) {
		applet.pixelDensity(density);
	}

	public void setSize(int width, int height) {
		applet.setSize(width, height);
	}

	public void smooth() {
		applet.smooth();
	}

	public void smooth(int level) {
		applet.smooth(level);
	}

	public void noSmooth() {
		applet.noSmooth();
	}

	public PGraphics getGraphics() {
		return applet.getGraphics();
	}

	public void orientation(int which) {
		applet.orientation(which);
	}

	public void start() {
		applet.start();
	}

	public void stop() {
		applet.stop();
	}

	public void pause() {
		applet.pause();
	}

	public void resume() {
		applet.resume();
	}

	public void registerMethod(String methodName, Object target) {
		applet.registerMethod(methodName, target);
	}

	public void unregisterMethod(String name, Object target) {
		applet.unregisterMethod(name, target);
	}

	public final void setup() {
		init();
		applet.setup();
	}

	public void fullScreen() {
		applet.fullScreen();
	}

	public void fullScreen(int display) {
		applet.fullScreen(display);
	}

	public void fullScreen(String renderer) {
		applet.fullScreen(renderer);
	}

	public void fullScreen(String renderer, int display) {
		applet.fullScreen(renderer, display);
	}

	public void size(int width, int height) {
		applet.size(width, height);
	}

	public void size(int width, int height, String renderer) {
		applet.size(width, height, renderer);
	}

	public void size(int width, int height, String renderer, String path) {
		applet.size(width, height, renderer, path);
	}

	public PGraphics createGraphics(int w, int h) {
		return applet.createGraphics(w, h);
	}

	public PGraphics createGraphics(int w, int h, String renderer) {
		return applet.createGraphics(w, h, renderer);
	}

	public PGraphics createGraphics(int w, int h, String renderer, String path) {
		return applet.createGraphics(w, h, renderer, path);
	}

	public PImage createImage(int w, int h, int format) {
		return applet.createImage(w, h, format);
	}

	public void handleDraw() {
		applet.handleDraw();
	}

	public void redraw() {
		applet.redraw();
	}

	public void loop() {
		applet.loop();
	}

	public void noLoop() {
		applet.noLoop();
	}

	public boolean isLooping() {
		return applet.isLooping();
	}

	public void postEvent(Event pe) {
		applet.postEvent(pe);
	}

	public void mousePressed() {
		applet.mousePressed();
	}

	public void mousePressed(MouseEvent event) {
		applet.mousePressed(event);
	}

	public void mouseReleased() {
		applet.mouseReleased();
	}

	public void mouseReleased(MouseEvent event) {
		applet.mouseReleased(event);
	}

	public void mouseClicked() {
		applet.mouseClicked();
	}

	public void mouseClicked(MouseEvent event) {
		applet.mouseClicked(event);
	}

	public void mouseDragged() {
		applet.mouseDragged();
	}

	public void mouseDragged(MouseEvent event) {
		applet.mouseDragged(event);
	}

	public void mouseMoved() {
		applet.mouseMoved();
	}

	public void mouseMoved(MouseEvent event) {
		applet.mouseMoved(event);
	}

	public void mouseEntered() {
		applet.mouseEntered();
	}

	public void mouseEntered(MouseEvent event) {
		applet.mouseEntered(event);
	}

	public void mouseExited() {
		applet.mouseExited();
	}

	public void mouseExited(MouseEvent event) {
		applet.mouseExited(event);
	}

	public void mouseWheel() {
		applet.mouseWheel();
	}

	public void mouseWheel(MouseEvent event) {
		applet.mouseWheel(event);
	}

	public void keyPressed() {
		applet.keyPressed();
	}

	public void keyPressed(KeyEvent event) {
		applet.keyPressed(event);
	}

	public void keyReleased() {
		applet.keyReleased();
	}

	public void keyReleased(KeyEvent event) {
		applet.keyReleased(event);
	}

	public void keyTyped() {
		applet.keyTyped();
	}

	public void keyTyped(KeyEvent event) {
		applet.keyTyped(event);
	}

	public void focusGained() {
		applet.focusGained();
	}

	public void focusLost() {
		applet.focusLost();
	}

	public int millis() {
		return applet.millis();
	}

	public void delay(int napTime) {
		applet.delay(napTime);
	}

	public void frameRate(float fps) {
		applet.frameRate(fps);
	}

	public void link(String url) {
		applet.link(url);
	}

	public void die(String what) {
		applet.die(what);
	}

	public void die(String what, Exception e) {
		applet.die(what, e);
	}

	public void exit() {
		applet.exit();
	}

	public boolean exitCalled() {
		return applet.exitCalled();
	}

	public void exitActual() {
		applet.exitActual();
	}

	public void dispose() {
		applet.dispose();
	}

	public void method(String name) {
		applet.method(name);
	}

	public void thread(String name) {
		applet.thread(name);
	}

	public void save(String filename) {
		applet.save(filename);
	}

	public void saveFrame() {
		applet.saveFrame();
	}

	public void saveFrame(String filename) {
		applet.saveFrame(filename);
	}

	public String insertFrame(String what) {
		return applet.insertFrame(what);
	}

	public void cursor(int kind) {
		applet.cursor(kind);
	}

	public void cursor(PImage img) {
		applet.cursor(img);
	}

	public void cursor(PImage img, int x, int y) {
		applet.cursor(img, x, y);
	}

	public void cursor() {
		applet.cursor();
	}

	public void noCursor() {
		applet.noCursor();
	}

	public final float random(float high) {
		return applet.random(high);
	}

	public final float randomGaussian() {
		return applet.randomGaussian();
	}

	public final float random(float low, float high) {
		return applet.random(low, high);
	}

	public final void randomSeed(long seed) {
		applet.randomSeed(seed);
	}

	public float noise(float x) {
		return applet.noise(x);
	}

	public float noise(float x, float y) {
		return applet.noise(x, y);
	}

	public float noise(float x, float y, float z) {
		return applet.noise(x, y, z);
	}

	public void noiseDetail(int lod) {
		applet.noiseDetail(lod);
	}

	public void noiseDetail(int lod, float falloff) {
		applet.noiseDetail(lod, falloff);
	}

	public void noiseSeed(long seed) {
		applet.noiseSeed(seed);
	}

	public PImage loadImage(String filename) {
		return applet.loadImage(filename);
	}

	public PImage loadImage(String filename, String extension) {
		return applet.loadImage(filename, extension);
	}

	public PImage requestImage(String filename) {
		return applet.requestImage(filename);
	}

	public PImage requestImage(String filename, String extension) {
		return applet.requestImage(filename, extension);
	}

	public XML loadXML(String filename) {
		return applet.loadXML(filename);
	}

	public XML loadXML(String filename, String options) {
		return applet.loadXML(filename, options);
	}

	public XML parseXML(String xmlString) {
		return applet.parseXML(xmlString);
	}

	public XML parseXML(String xmlString, String options) {
		return applet.parseXML(xmlString, options);
	}

	public boolean saveXML(XML xml, String filename) {
		return applet.saveXML(xml, filename);
	}

	public boolean saveXML(XML xml, String filename, String options) {
		return applet.saveXML(xml, filename, options);
	}

	public JSONObject parseJSONObject(String input) {
		return applet.parseJSONObject(input);
	}

	public JSONObject loadJSONObject(String filename) {
		return applet.loadJSONObject(filename);
	}

	public boolean saveJSONObject(JSONObject json, String filename) {
		return applet.saveJSONObject(json, filename);
	}

	public boolean saveJSONObject(JSONObject json, String filename, String options) {
		return applet.saveJSONObject(json, filename, options);
	}

	public JSONArray parseJSONArray(String input) {
		return applet.parseJSONArray(input);
	}

	public JSONArray loadJSONArray(String filename) {
		return applet.loadJSONArray(filename);
	}

	public boolean saveJSONArray(JSONArray json, String filename) {
		return applet.saveJSONArray(json, filename);
	}

	public boolean saveJSONArray(JSONArray json, String filename, String options) {
		return applet.saveJSONArray(json, filename, options);
	}

	public Table loadTable(String filename) {
		return applet.loadTable(filename);
	}

	public Table loadTable(String filename, String options) {
		return applet.loadTable(filename, options);
	}

	public boolean saveTable(Table table, String filename) {
		return applet.saveTable(table, filename);
	}

	public boolean saveTable(Table table, String filename, String options) {
		return applet.saveTable(table, filename, options);
	}

	public PFont loadFont(String filename) {
		return applet.loadFont(filename);
	}

	public PFont createFont(String name, float size) {
		return applet.createFont(name, size);
	}

	public PFont createFont(String name, float size, boolean smooth) {
		return applet.createFont(name, size, smooth);
	}

	public PFont createFont(String name, float size, boolean smooth, char[] charset) {
		return applet.createFont(name, size, smooth, charset);
	}

	public void selectInput(String prompt, String callback) {
		applet.selectInput(prompt, callback);
	}

	public void selectInput(String prompt, String callback, File file) {
		applet.selectInput(prompt, callback, file);
	}

	public void selectInput(String prompt, String callback, File file, Object callbackObject) {
		applet.selectInput(prompt, callback, file, callbackObject);
	}

	public void selectOutput(String prompt, String callback) {
		applet.selectOutput(prompt, callback);
	}

	public void selectOutput(String prompt, String callback, File file) {
		applet.selectOutput(prompt, callback, file);
	}

	public void selectOutput(String prompt, String callback, File file, Object callbackObject) {
		applet.selectOutput(prompt, callback, file, callbackObject);
	}

	public void selectFolder(String prompt, String callback) {
		applet.selectFolder(prompt, callback);
	}

	public void selectFolder(String prompt, String callback, File file) {
		applet.selectFolder(prompt, callback, file);
	}

	public void selectFolder(String prompt, String callback, File file, Object callbackObject) {
		applet.selectFolder(prompt, callback, file, callbackObject);
	}

	public BufferedReader createReader(String filename) {
		return applet.createReader(filename);
	}

	public PrintWriter createWriter(String filename) {
		return applet.createWriter(filename);
	}

	public InputStream createInput(String filename) {
		return applet.createInput(filename);
	}

	public InputStream createInputRaw(String filename) {
		return applet.createInputRaw(filename);
	}

	public byte[] loadBytes(String filename) {
		return applet.loadBytes(filename);
	}

	public String[] loadStrings(String filename) {
		return applet.loadStrings(filename);
	}

	public OutputStream createOutput(String filename) {
		return applet.createOutput(filename);
	}

	public boolean saveStream(String target, String source) {
		return applet.saveStream(target, source);
	}

	public boolean saveStream(File target, String source) {
		return applet.saveStream(target, source);
	}

	public boolean saveStream(String target, InputStream source) {
		return applet.saveStream(target, source);
	}

	public void saveBytes(String filename, byte[] data) {
		applet.saveBytes(filename, data);
	}

	public void saveStrings(String filename, String[] data) {
		applet.saveStrings(filename, data);
	}

	public String sketchPath() {
		return applet.sketchPath();
	}

	public String sketchPath(String where) {
		return applet.sketchPath(where);
	}

	public File sketchFile(String where) {
		return applet.sketchFile(where);
	}

	public String savePath(String where) {
		return applet.savePath(where);
	}

	public File saveFile(String where) {
		return applet.saveFile(where);
	}

	public String dataPath(String where) {
		return applet.dataPath(where);
	}

	public File dataFile(String where) {
		return applet.dataFile(where);
	}

	public final int color(int gray) {
		return applet.color(gray);
	}

	public final int color(float fgray) {
		return applet.color(fgray);
	}

	public final int color(int gray, int alpha) {
		return applet.color(gray, alpha);
	}

	public final int color(float fgray, float falpha) {
		return applet.color(fgray, falpha);
	}

	public final int color(int v1, int v2, int v3) {
		return applet.color(v1, v2, v3);
	}

	public final int color(int v1, int v2, int v3, int alpha) {
		return applet.color(v1, v2, v3, alpha);
	}

	public final int color(float v1, float v2, float v3) {
		return applet.color(v1, v2, v3);
	}

	public final int color(float v1, float v2, float v3, float alpha) {
		return applet.color(v1, v2, v3, alpha);
	}

	public int lerpColor(int c1, int c2, float amt) {
		return applet.lerpColor(c1, c2, amt);
	}

	public void frameMoved(int x, int y) {
		applet.frameMoved(x, y);
	}

	public void frameResized(int w, int h) {
		applet.frameResized(w, h);
	}

	public PGraphics beginRecord(String renderer, String filename) {
		return applet.beginRecord(renderer, filename);
	}

	public void beginRecord(PGraphics recorder) {
		applet.beginRecord(recorder);
	}

	public void endRecord() {
		applet.endRecord();
	}

	public PGraphics beginRaw(String renderer, String filename) {
		return applet.beginRaw(renderer, filename);
	}

	public void beginRaw(PGraphics rawGraphics) {
		applet.beginRaw(rawGraphics);
	}

	public void endRaw() {
		applet.endRaw();
	}

	public void loadPixels() {
		applet.loadPixels();
	}

	public void updatePixels() {
		applet.updatePixels();
	}

	public void updatePixels(int x1, int y1, int x2, int y2) {
		applet.updatePixels(x1, y1, x2, y2);
	}

	public PGL beginPGL() {
		return applet.beginPGL();
	}

	public void endPGL() {
		applet.endPGL();
	}

	public void flush() {
		applet.flush();
	}

	public void hint(int which) {
		applet.hint(which);
	}

	public void beginShape() {
		applet.beginShape();
	}

	public void beginShape(int kind) {
		applet.beginShape(kind);
	}

	public void edge(boolean edge) {
		applet.edge(edge);
	}

	public void normal(float nx, float ny, float nz) {
		applet.normal(nx, ny, nz);
	}

	public void attribPosition(String name, float x, float y, float z) {
		applet.attribPosition(name, x, y, z);
	}

	public void attribNormal(String name, float nx, float ny, float nz) {
		applet.attribNormal(name, nx, ny, nz);
	}

	public void attribColor(String name, int color) {
		applet.attribColor(name, color);
	}

	public void attrib(String name, float... values) {
		applet.attrib(name, values);
	}

	public void attrib(String name, int... values) {
		applet.attrib(name, values);
	}

	public void attrib(String name, boolean... values) {
		applet.attrib(name, values);
	}

	public void textureMode(int mode) {
		applet.textureMode(mode);
	}

	public void textureWrap(int wrap) {
		applet.textureWrap(wrap);
	}

	public void texture(PImage image) {
		applet.texture(image);
	}

	public void noTexture() {
		applet.noTexture();
	}

	public void vertex(float x, float y) {
		applet.vertex(x, y);
	}

	public void vertex(float x, float y, float z) {
		applet.vertex(x, y, z);
	}

	public void vertex(float[] v) {
		applet.vertex(v);
	}

	public void vertex(float x, float y, float u, float v) {
		applet.vertex(x, y, u, v);
	}

	public void vertex(float x, float y, float z, float u, float v) {
		applet.vertex(x, y, z, u, v);
	}

	public void beginContour() {
		applet.beginContour();
	}

	public void endContour() {
		applet.endContour();
	}

	public void endShape() {
		applet.endShape();
	}

	public void endShape(int mode) {
		applet.endShape(mode);
	}

	public PShape loadShape(String filename) {
		return applet.loadShape(filename);
	}

	public PShape loadShape(String filename, String options) {
		return applet.loadShape(filename, options);
	}

	public PShape createShape() {
		return applet.createShape();
	}

	public PShape createShape(int type) {
		return applet.createShape(type);
	}

	public PShape createShape(int kind, float... p) {
		return applet.createShape(kind, p);
	}

	public PShader loadShader(String fragFilename) {
		return applet.loadShader(fragFilename);
	}

	public PShader loadShader(String fragFilename, String vertFilename) {
		return applet.loadShader(fragFilename, vertFilename);
	}

	public void shader(PShader shader) {
		applet.shader(shader);
	}

	public void shader(PShader shader, int kind) {
		applet.shader(shader, kind);
	}

	public void resetShader() {
		applet.resetShader();
	}

	public void resetShader(int kind) {
		applet.resetShader(kind);
	}

	public void filter(PShader shader) {
		applet.filter(shader);
	}

	public void clip(float a, float b, float c, float d) {
		applet.clip(a, b, c, d);
	}

	public void noClip() {
		applet.noClip();
	}

	public void blendMode(int mode) {
		applet.blendMode(mode);
	}

	public void bezierVertex(float x2, float y2, float x3, float y3, float x4, float y4) {
		applet.bezierVertex(x2, y2, x3, y3, x4, y4);
	}

	public void bezierVertex(float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4) {
		applet.bezierVertex(x2, y2, z2, x3, y3, z3, x4, y4, z4);
	}

	public void quadraticVertex(float cx, float cy, float x3, float y3) {
		applet.quadraticVertex(cx, cy, x3, y3);
	}

	public void quadraticVertex(float cx, float cy, float cz, float x3, float y3, float z3) {
		applet.quadraticVertex(cx, cy, cz, x3, y3, z3);
	}

	public void curveVertex(float x, float y) {
		applet.curveVertex(x, y);
	}

	public void curveVertex(float x, float y, float z) {
		applet.curveVertex(x, y, z);
	}

	public void point(float x, float y) {
		applet.point(x, y);
	}

	public void point(float x, float y, float z) {
		applet.point(x, y, z);
	}

	public void line(float x1, float y1, float x2, float y2) {
		applet.line(x1, y1, x2, y2);
	}

	public void line(float x1, float y1, float z1, float x2, float y2, float z2) {
		applet.line(x1, y1, z1, x2, y2, z2);
	}

	public void triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
		applet.triangle(x1, y1, x2, y2, x3, y3);
	}

	public void quad(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
		applet.quad(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	public void rectMode(int mode) {
		applet.rectMode(mode);
	}

	public void rect(float a, float b, float c, float d) {
		applet.rect(a, b, c, d);
	}

	public void rect(float a, float b, float c, float d, float r) {
		applet.rect(a, b, c, d, r);
	}

	public void rect(float a, float b, float c, float d, float tl, float tr, float br, float bl) {
		applet.rect(a, b, c, d, tl, tr, br, bl);
	}

	public void ellipseMode(int mode) {
		applet.ellipseMode(mode);
	}

	public void ellipse(float a, float b, float c, float d) {
		applet.ellipse(a, b, c, d);
	}

	public void arc(float a, float b, float c, float d, float start, float stop) {
		applet.arc(a, b, c, d, start, stop);
	}

	public void arc(float a, float b, float c, float d, float start, float stop, int mode) {
		applet.arc(a, b, c, d, start, stop, mode);
	}

	public void box(float size) {
		applet.box(size);
	}

	public void box(float w, float h, float d) {
		applet.box(w, h, d);
	}

	public void sphereDetail(int res) {
		applet.sphereDetail(res);
	}

	public void sphereDetail(int ures, int vres) {
		applet.sphereDetail(ures, vres);
	}

	public void sphere(float r) {
		applet.sphere(r);
	}

	public float bezierPoint(float a, float b, float c, float d, float t) {
		return applet.bezierPoint(a, b, c, d, t);
	}

	public float bezierTangent(float a, float b, float c, float d, float t) {
		return applet.bezierTangent(a, b, c, d, t);
	}

	public void bezierDetail(int detail) {
		applet.bezierDetail(detail);
	}

	public void bezier(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
		applet.bezier(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	public void bezier(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3,
			float x4, float y4, float z4) {
		applet.bezier(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
	}

	public float curvePoint(float a, float b, float c, float d, float t) {
		return applet.curvePoint(a, b, c, d, t);
	}

	public float curveTangent(float a, float b, float c, float d, float t) {
		return applet.curveTangent(a, b, c, d, t);
	}

	public void curveDetail(int detail) {
		applet.curveDetail(detail);
	}

	public void curveTightness(float tightness) {
		applet.curveTightness(tightness);
	}

	public void curve(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
		applet.curve(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	public void curve(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3,
			float x4, float y4, float z4) {
		applet.curve(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
	}

	public void imageMode(int mode) {
		applet.imageMode(mode);
	}

	public void image(PImage img, float a, float b) {
		applet.image(img, a, b);
	}

	public void image(PImage img, float a, float b, float c, float d) {
		applet.image(img, a, b, c, d);
	}

	public void image(PImage img, float a, float b, float c, float d, int u1, int v1, int u2, int v2) {
		applet.image(img, a, b, c, d, u1, v1, u2, v2);
	}

	public void shapeMode(int mode) {
		applet.shapeMode(mode);
	}

	public void shape(PShape shape) {
		applet.shape(shape);
	}

	public void shape(PShape shape, float x, float y) {
		applet.shape(shape, x, y);
	}

	public void shape(PShape shape, float a, float b, float c, float d) {
		applet.shape(shape, a, b, c, d);
	}

	public void textAlign(int alignX) {
		applet.textAlign(alignX);
	}

	public void textAlign(int alignX, int alignY) {
		applet.textAlign(alignX, alignY);
	}

	public float textAscent() {
		return applet.textAscent();
	}

	public float textDescent() {
		return applet.textDescent();
	}

	public void textFont(PFont which) {
		applet.textFont(which);
	}

	public void textFont(PFont which, float size) {
		applet.textFont(which, size);
	}

	public void textLeading(float leading) {
		applet.textLeading(leading);
	}

	public void textMode(int mode) {
		applet.textMode(mode);
	}

	public void textSize(float size) {
		applet.textSize(size);
	}

	public float textWidth(char c) {
		return applet.textWidth(c);
	}

	public float textWidth(String str) {
		return applet.textWidth(str);
	}

	public float textWidth(char[] chars, int start, int length) {
		return applet.textWidth(chars, start, length);
	}

	public void text(char c, float x, float y) {
		applet.text(c, x, y);
	}

	public void text(char c, float x, float y, float z) {
		applet.text(c, x, y, z);
	}

	public void text(String str, float x, float y) {
		applet.text(str, x, y);
	}

	public void text(char[] chars, int start, int stop, float x, float y) {
		applet.text(chars, start, stop, x, y);
	}

	public void text(String str, float x, float y, float z) {
		applet.text(str, x, y, z);
	}

	public void text(char[] chars, int start, int stop, float x, float y, float z) {
		applet.text(chars, start, stop, x, y, z);
	}

	public void text(String str, float x1, float y1, float x2, float y2) {
		applet.text(str, x1, y1, x2, y2);
	}

	public void text(int num, float x, float y) {
		applet.text(num, x, y);
	}

	public void text(int num, float x, float y, float z) {
		applet.text(num, x, y, z);
	}

	public void text(float num, float x, float y) {
		applet.text(num, x, y);
	}

	public void text(float num, float x, float y, float z) {
		applet.text(num, x, y, z);
	}

	public void pushMatrix() {
		applet.pushMatrix();
	}

	public void popMatrix() {
		applet.popMatrix();
	}

	public void translate(float x, float y) {
		applet.translate(x, y);
	}

	public void translate(float x, float y, float z) {
		applet.translate(x, y, z);
	}

	public void rotate(float angle) {
		applet.rotate(angle);
	}

	public void rotateX(float angle) {
		applet.rotateX(angle);
	}

	public void rotateY(float angle) {
		applet.rotateY(angle);
	}

	public void rotateZ(float angle) {
		applet.rotateZ(angle);
	}

	public void rotate(float angle, float x, float y, float z) {
		applet.rotate(angle, x, y, z);
	}

	public void scale(float s) {
		applet.scale(s);
	}

	public void scale(float x, float y) {
		applet.scale(x, y);
	}

	public void scale(float x, float y, float z) {
		applet.scale(x, y, z);
	}

	public void shearX(float angle) {
		applet.shearX(angle);
	}

	public void shearY(float angle) {
		applet.shearY(angle);
	}

	public void resetMatrix() {
		applet.resetMatrix();
	}

	public void applyMatrix(PMatrix source) {
		applet.applyMatrix(source);
	}

	public void applyMatrix(PMatrix2D source) {
		applet.applyMatrix(source);
	}

	public void applyMatrix(float n00, float n01, float n02, float n10, float n11, float n12) {
		applet.applyMatrix(n00, n01, n02, n10, n11, n12);
	}

	public void applyMatrix(PMatrix3D source) {
		applet.applyMatrix(source);
	}

	public void applyMatrix(float n00, float n01, float n02, float n03, float n10, float n11, float n12, float n13,
			float n20, float n21, float n22, float n23, float n30, float n31, float n32, float n33) {
		applet.applyMatrix(n00, n01, n02, n03, n10, n11, n12, n13, n20, n21, n22, n23, n30, n31, n32, n33);
	}

	public PMatrix getMatrix() {
		return applet.getMatrix();
	}

	public PMatrix2D getMatrix(PMatrix2D target) {
		return applet.getMatrix(target);
	}

	public PMatrix3D getMatrix(PMatrix3D target) {
		return applet.getMatrix(target);
	}

	public void setMatrix(PMatrix source) {
		applet.setMatrix(source);
	}

	public void setMatrix(PMatrix2D source) {
		applet.setMatrix(source);
	}

	public void setMatrix(PMatrix3D source) {
		applet.setMatrix(source);
	}

	public void printMatrix() {
		applet.printMatrix();
	}

	public void beginCamera() {
		applet.beginCamera();
	}

	public void endCamera() {
		applet.endCamera();
	}

	public void camera() {
		applet.camera();
	}

	public void camera(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX,
			float upY, float upZ) {
		applet.camera(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
	}

	public void printCamera() {
		applet.printCamera();
	}

	public void ortho() {
		applet.ortho();
	}

	public void ortho(float left, float right, float bottom, float top) {
		applet.ortho(left, right, bottom, top);
	}

	public void ortho(float left, float right, float bottom, float top, float near, float far) {
		applet.ortho(left, right, bottom, top, near, far);
	}

	public void perspective() {
		applet.perspective();
	}

	public void perspective(float fovy, float aspect, float zNear, float zFar) {
		applet.perspective(fovy, aspect, zNear, zFar);
	}

	public void frustum(float left, float right, float bottom, float top, float near, float far) {
		applet.frustum(left, right, bottom, top, near, far);
	}

	public void printProjection() {
		applet.printProjection();
	}

	public float screenX(float x, float y) {
		return applet.screenX(x, y);
	}

	public float screenY(float x, float y) {
		return applet.screenY(x, y);
	}

	public float screenX(float x, float y, float z) {
		return applet.screenX(x, y, z);
	}

	public float screenY(float x, float y, float z) {
		return applet.screenY(x, y, z);
	}

	public float screenZ(float x, float y, float z) {
		return applet.screenZ(x, y, z);
	}

	public float modelX(float x, float y, float z) {
		return applet.modelX(x, y, z);
	}

	public float modelY(float x, float y, float z) {
		return applet.modelY(x, y, z);
	}

	public float modelZ(float x, float y, float z) {
		return applet.modelZ(x, y, z);
	}

	public void pushStyle() {
		applet.pushStyle();
	}

	public void popStyle() {
		applet.popStyle();
	}

	public void style(PStyle s) {
		applet.style(s);
	}

	public void strokeWeight(float weight) {
		applet.strokeWeight(weight);
	}

	public void strokeJoin(int join) {
		applet.strokeJoin(join);
	}

	public void strokeCap(int cap) {
		applet.strokeCap(cap);
	}

	public void noStroke() {
		applet.noStroke();
	}

	public void stroke(int rgb) {
		applet.stroke(rgb);
	}

	public void stroke(int rgb, float alpha) {
		applet.stroke(rgb, alpha);
	}

	public void stroke(float gray) {
		applet.stroke(gray);
	}

	public void stroke(float gray, float alpha) {
		applet.stroke(gray, alpha);
	}

	public void stroke(float v1, float v2, float v3) {
		applet.stroke(v1, v2, v3);
	}

	public void stroke(float v1, float v2, float v3, float alpha) {
		applet.stroke(v1, v2, v3, alpha);
	}

	public void noTint() {
		applet.noTint();
	}

	public void tint(int rgb) {
		applet.tint(rgb);
	}

	public void tint(int rgb, float alpha) {
		applet.tint(rgb, alpha);
	}

	public void tint(float gray) {
		applet.tint(gray);
	}

	public void tint(float gray, float alpha) {
		applet.tint(gray, alpha);
	}

	public void tint(float v1, float v2, float v3) {
		applet.tint(v1, v2, v3);
	}

	public void tint(float v1, float v2, float v3, float alpha) {
		applet.tint(v1, v2, v3, alpha);
	}

	public void noFill() {
		applet.noFill();
	}

	public void fill(int rgb) {
		applet.fill(rgb);
	}

	public void fill(int rgb, float alpha) {
		applet.fill(rgb, alpha);
	}

	public void fill(float gray) {
		applet.fill(gray);
	}

	public void fill(float gray, float alpha) {
		applet.fill(gray, alpha);
	}

	public void fill(float v1, float v2, float v3) {
		applet.fill(v1, v2, v3);
	}

	public void fill(float v1, float v2, float v3, float alpha) {
		applet.fill(v1, v2, v3, alpha);
	}

	public void ambient(int rgb) {
		applet.ambient(rgb);
	}

	public void ambient(float gray) {
		applet.ambient(gray);
	}

	public void ambient(float v1, float v2, float v3) {
		applet.ambient(v1, v2, v3);
	}

	public void specular(int rgb) {
		applet.specular(rgb);
	}

	public void specular(float gray) {
		applet.specular(gray);
	}

	public void specular(float v1, float v2, float v3) {
		applet.specular(v1, v2, v3);
	}

	public void shininess(float shine) {
		applet.shininess(shine);
	}

	public void emissive(int rgb) {
		applet.emissive(rgb);
	}

	public void emissive(float gray) {
		applet.emissive(gray);
	}

	public void emissive(float v1, float v2, float v3) {
		applet.emissive(v1, v2, v3);
	}

	public void lights() {
		applet.lights();
	}

	public void noLights() {
		applet.noLights();
	}

	public void ambientLight(float v1, float v2, float v3) {
		applet.ambientLight(v1, v2, v3);
	}

	public void ambientLight(float v1, float v2, float v3, float x, float y, float z) {
		applet.ambientLight(v1, v2, v3, x, y, z);
	}

	public void directionalLight(float v1, float v2, float v3, float nx, float ny, float nz) {
		applet.directionalLight(v1, v2, v3, nx, ny, nz);
	}

	public void pointLight(float v1, float v2, float v3, float x, float y, float z) {
		applet.pointLight(v1, v2, v3, x, y, z);
	}

	public void spotLight(float v1, float v2, float v3, float x, float y, float z, float nx, float ny, float nz,
			float angle, float concentration) {
		applet.spotLight(v1, v2, v3, x, y, z, nx, ny, nz, angle, concentration);
	}

	public void lightFalloff(float constant, float linear, float quadratic) {
		applet.lightFalloff(constant, linear, quadratic);
	}

	public void lightSpecular(float v1, float v2, float v3) {
		applet.lightSpecular(v1, v2, v3);
	}

	public void background(int rgb) {
		applet.background(rgb);
	}

	public void background(int rgb, float alpha) {
		applet.background(rgb, alpha);
	}

	public void background(float gray) {
		applet.background(gray);
	}

	public void background(float gray, float alpha) {
		applet.background(gray, alpha);
	}

	public void background(float v1, float v2, float v3) {
		applet.background(v1, v2, v3);
	}

	public void background(float v1, float v2, float v3, float alpha) {
		applet.background(v1, v2, v3, alpha);
	}

	public void clear() {
		applet.clear();
	}

	public void background(PImage image) {
		applet.background(image);
	}

	public void colorMode(int mode) {
		applet.colorMode(mode);
	}

	public void colorMode(int mode, float max) {
		applet.colorMode(mode, max);
	}

	public void colorMode(int mode, float max1, float max2, float max3) {
		applet.colorMode(mode, max1, max2, max3);
	}

	public void colorMode(int mode, float max1, float max2, float max3, float maxA) {
		applet.colorMode(mode, max1, max2, max3, maxA);
	}

	public final float alpha(int rgb) {
		return applet.alpha(rgb);
	}

	public final float red(int rgb) {
		return applet.red(rgb);
	}

	public final float green(int rgb) {
		return applet.green(rgb);
	}

	public final float blue(int rgb) {
		return applet.blue(rgb);
	}

	public final float hue(int rgb) {
		return applet.hue(rgb);
	}

	public final float saturation(int rgb) {
		return applet.saturation(rgb);
	}

	public final float brightness(int rgb) {
		return applet.brightness(rgb);
	}

	public int get(int x, int y) {
		return applet.get(x, y);
	}

	public PImage get(int x, int y, int w, int h) {
		return applet.get(x, y, w, h);
	}

	public PImage get() {
		return applet.get();
	}

	public PImage copy() {
		return applet.copy();
	}

	public void set(int x, int y, int c) {
		applet.set(x, y, c);
	}

	public void set(int x, int y, PImage img) {
		applet.set(x, y, img);
	}

	public void mask(PImage img) {
		applet.mask(img);
	}

	public void filter(int kind) {
		applet.filter(kind);
	}

	public void filter(int kind, float param) {
		applet.filter(kind, param);
	}

	public void copy(int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh) {
		applet.copy(sx, sy, sw, sh, dx, dy, dw, dh);
	}

	public void copy(PImage src, int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh) {
		applet.copy(src, sx, sy, sw, sh, dx, dy, dw, dh);
	}

	public void blend(int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh, int mode) {
		applet.blend(sx, sy, sw, sh, dx, dy, dw, dh, mode);
	}

	public void blend(PImage src, int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh, int mode) {
		applet.blend(src, sx, sy, sw, sh, dx, dy, dw, dh, mode);
	}
	
	public int getHeight() {
		return applet.height;
	}
	
	public int getWidth() {
		return applet.width;
	}

	

}
