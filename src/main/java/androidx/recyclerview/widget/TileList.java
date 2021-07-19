/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.TileList$Tile;

public class TileList {
    public TileList$Tile mLastAccessedTile;
    public final int mTileSize;
    private final SparseArray mTiles;

    public TileList(int n10) {
        SparseArray sparseArray;
        this.mTiles = sparseArray = new SparseArray(10);
        this.mTileSize = n10;
    }

    public TileList$Tile addOrReplace(TileList$Tile tileList$Tile) {
        Object object = this.mTiles;
        int n10 = tileList$Tile.mStartPosition;
        int n11 = object.indexOfKey(n10);
        if (n11 < 0) {
            object = this.mTiles;
            n10 = tileList$Tile.mStartPosition;
            object.put(n10, (Object)tileList$Tile);
            return null;
        }
        TileList$Tile tileList$Tile2 = (TileList$Tile)this.mTiles.valueAt(n11);
        SparseArray sparseArray = this.mTiles;
        sparseArray.setValueAt(n11, (Object)tileList$Tile);
        object = this.mLastAccessedTile;
        if (object == tileList$Tile2) {
            this.mLastAccessedTile = tileList$Tile;
        }
        return tileList$Tile2;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public TileList$Tile getAtIndex(int n10) {
        SparseArray sparseArray;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (sparseArray = this.mTiles).size())) {
            return (TileList$Tile)this.mTiles.valueAt(n10);
        }
        return null;
    }

    public Object getItemAt(int n10) {
        int n11;
        TileList$Tile tileList$Tile = this.mLastAccessedTile;
        if (tileList$Tile == null || (n11 = (int)(tileList$Tile.containsPosition(n10) ? 1 : 0)) == 0) {
            n11 = this.mTileSize;
            n11 = n10 % n11;
            n11 = n10 - n11;
            SparseArray sparseArray = this.mTiles;
            if ((n11 = sparseArray.indexOfKey(n11)) < 0) {
                return null;
            }
            sparseArray = this.mTiles;
            this.mLastAccessedTile = tileList$Tile = (TileList$Tile)sparseArray.valueAt(n11);
        }
        return this.mLastAccessedTile.getByPosition(n10);
    }

    public TileList$Tile removeAtPos(int n10) {
        TileList$Tile tileList$Tile = this.mLastAccessedTile;
        TileList$Tile tileList$Tile2 = (TileList$Tile)this.mTiles.get(n10);
        if (tileList$Tile == tileList$Tile2) {
            tileList$Tile = null;
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(n10);
        return tileList$Tile2;
    }

    public int size() {
        return this.mTiles.size();
    }
}

