package com.tcg.rpg.entity;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.tcg.rpg.MyCamera;

public class World {

	private Array<Rectangle> bounds;

	private TiledMap tileMap;
	private float tileSize;
	private OrthogonalTiledMapRenderer tmr;

	private float widthInTiles;
	private float width;
	private float heightInTiles;
	private float height;
	
	public World() {
		bounds = new Array<Rectangle>();
		createLayer();
	}
	
	private void createLayer() {
		tileMap = new TmxMapLoader().load("maps/test.tmx");
		tmr = new OrthogonalTiledMapRenderer(tileMap);
		tileSize = tileMap.getProperties().get("tilewidth", Integer.class);
		
		TiledMapTileLayer ground;
		
		ground = (TiledMapTileLayer) tileMap.getLayers().get("inpassable");		

		widthInTiles = ground.getWidth();
		width = widthInTiles *  tileSize;
		
		heightInTiles = ground.getHeight();
		height = heightInTiles * tileSize;
		createLayer(ground, bounds);
	}
	
	private void createLayer(TiledMapTileLayer layer, Array<Rectangle> rect) {

		for(int row = 0; row < layer.getHeight(); row++) {
			for(int col = 0; col < layer.getWidth(); col++) {

				Cell cell = layer.getCell(col, row);
				
				// check if cell exists
				if(cell == null) continue;
				if(cell.getTile() == null) continue;
				
				rect.add(new Rectangle(col * tileSize, row * tileSize, tileSize, tileSize));
			}
		}
	}
	
	public void draw(MyCamera cam) {
		tmr.setView(cam);
		tmr.render();
	}
	

	public Array<Rectangle> getBounds() {
		return bounds;
	}

	public void setBounds(Array<Rectangle> bounds) {
		this.bounds = bounds;
	}

	public float getWidthInTiles() {
		return widthInTiles;
	}

	public void setWidthInTiles(float widthInTiles) {
		this.widthInTiles = widthInTiles;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeightInTiles() {
		return heightInTiles;
	}

	public void setHeightInTiles(float heightInTiles) {
		this.heightInTiles = heightInTiles;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
