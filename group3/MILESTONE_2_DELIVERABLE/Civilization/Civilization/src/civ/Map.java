package civ;

public class Map
{
    //Assuming that tiles are square, we need to set this so the mapView
    //can determine how large to paint tiles.
    private int tileSize;
    private int mapWidth;
    private int mapHeight;
    private Tile[][] tileSet;
    
    
    public Map()
    {
        
    }

    public Map(Tile[][] tiles)
    {
        this.mapWidth = tiles.length;
        this.mapHeight = mapWidth > 0?tiles[0].length:0;
        this.tileSet = tiles;
    }


    public int getTileSize()
    {
        return tileSize;
    }

    public int getMapWidth()
    {
        return mapWidth;
    }

    public int getMapHeight()
    {
        return mapHeight;
    }

    public Tile tileAt(MapLocation location) throws IllegalArgumentException
    {
        return this.tileAt(location.x, location.y);
    }

    public Tile tileAt(int x, int y) throws IllegalArgumentException
    {
        //Remember that the map wraps around width wise,
        if(x < -(this.mapWidth-1) || x > this.mapWidth-1)
            throw new IllegalArgumentException("x Coordinate was not within map boundaries");
        if(y < 0 || y > this.mapHeight-1)
            throw new IllegalArgumentException("y Coordinate was not within map boundaries");
        else return this.tileSet[x<0?mapWidth-x:x][y];
    }




    
    
}
