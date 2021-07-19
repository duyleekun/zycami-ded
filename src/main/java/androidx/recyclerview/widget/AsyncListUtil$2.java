/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.SparseBooleanArray
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.recyclerview.widget.AsyncListUtil;
import androidx.recyclerview.widget.AsyncListUtil$DataCallback;
import androidx.recyclerview.widget.ThreadUtil$BackgroundCallback;
import androidx.recyclerview.widget.ThreadUtil$MainThreadCallback;
import androidx.recyclerview.widget.TileList$Tile;

public class AsyncListUtil$2
implements ThreadUtil$BackgroundCallback {
    private int mFirstRequiredTileStart;
    private int mGeneration;
    private int mItemCount;
    private int mLastRequiredTileStart;
    public final SparseBooleanArray mLoadedTiles;
    private TileList$Tile mRecycledRoot;
    public final /* synthetic */ AsyncListUtil this$0;

    public AsyncListUtil$2(AsyncListUtil asyncListUtil) {
        this.this$0 = asyncListUtil;
        this.mLoadedTiles = asyncListUtil;
    }

    private TileList$Tile acquireTile() {
        TileList$Tile tileList$Tile = this.mRecycledRoot;
        if (tileList$Tile != null) {
            TileList$Tile tileList$Tile2;
            this.mRecycledRoot = tileList$Tile2 = tileList$Tile.mNext;
            return tileList$Tile;
        }
        AsyncListUtil asyncListUtil = this.this$0;
        Class clazz = asyncListUtil.mTClass;
        int n10 = asyncListUtil.mTileSize;
        tileList$Tile = new TileList$Tile(clazz, n10);
        return tileList$Tile;
    }

    private void addTile(TileList$Tile tileList$Tile) {
        Object object = this.mLoadedTiles;
        int n10 = tileList$Tile.mStartPosition;
        object.put(n10, true);
        object = this.this$0.mMainThreadProxy;
        n10 = this.mGeneration;
        object.addTile(n10, tileList$Tile);
    }

    private void flushTileCache(int n10) {
        SparseBooleanArray sparseBooleanArray;
        int n11;
        AsyncListUtil$DataCallback asyncListUtil$DataCallback = this.this$0.mDataCallback;
        int n12 = asyncListUtil$DataCallback.getMaxCachedTiles();
        while ((n11 = (sparseBooleanArray = this.mLoadedTiles).size()) >= n12) {
            int n13;
            sparseBooleanArray = this.mLoadedTiles;
            n11 = sparseBooleanArray.keyAt(0);
            SparseBooleanArray sparseBooleanArray2 = this.mLoadedTiles;
            int n14 = sparseBooleanArray2.size();
            int n15 = 1;
            int n16 = sparseBooleanArray2.keyAt(n14 -= n15);
            n14 = this.mFirstRequiredTileStart - n11;
            int n17 = this.mLastRequiredTileStart;
            n17 = n16 - n17;
            if (n14 > 0 && (n14 >= n17 || n10 == (n13 = 2))) {
                this.removeTile(n11);
                continue;
            }
            if (n17 <= 0 || n14 >= n17 && n10 != n15) break;
            this.removeTile(n16);
        }
    }

    private int getTileStart(int n10) {
        int n11 = this.this$0.mTileSize;
        n11 = n10 % n11;
        return n10 - n11;
    }

    private boolean isTileLoaded(int n10) {
        return this.mLoadedTiles.get(n10);
    }

    private void log(String string2, Object ... objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[BKGR] ");
        string2 = String.format(string2, objectArray);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        Log.d((String)"AsyncListUtil", (String)string2);
    }

    private void removeTile(int n10) {
        this.mLoadedTiles.delete(n10);
        ThreadUtil$MainThreadCallback threadUtil$MainThreadCallback = this.this$0.mMainThreadProxy;
        int n11 = this.mGeneration;
        threadUtil$MainThreadCallback.removeTile(n11, n10);
    }

    private void requestTiles(int n10, int n11, int n12, boolean bl2) {
        int n13;
        for (int i10 = n10; i10 <= n11; i10 += n13) {
            n13 = bl2 ? n11 + n10 - i10 : i10;
            ThreadUtil$BackgroundCallback threadUtil$BackgroundCallback = this.this$0.mBackgroundProxy;
            threadUtil$BackgroundCallback.loadTile(n13, n12);
            AsyncListUtil asyncListUtil = this.this$0;
            n13 = asyncListUtil.mTileSize;
        }
    }

    public void loadTile(int n10, int n11) {
        boolean bl2 = this.isTileLoaded(n10);
        if (bl2) {
            return;
        }
        TileList$Tile tileList$Tile = this.acquireTile();
        tileList$Tile.mStartPosition = n10;
        int n12 = this.this$0.mTileSize;
        int n13 = this.mItemCount - n10;
        tileList$Tile.mItemCount = n10 = Math.min(n12, n13);
        AsyncListUtil$DataCallback asyncListUtil$DataCallback = this.this$0.mDataCallback;
        Object[] objectArray = tileList$Tile.mItems;
        int n14 = tileList$Tile.mStartPosition;
        asyncListUtil$DataCallback.fillData(objectArray, n14, n10);
        this.flushTileCache(n11);
        this.addTile(tileList$Tile);
    }

    public void recycleTile(TileList$Tile tileList$Tile) {
        Object object = this.this$0.mDataCallback;
        Object[] objectArray = tileList$Tile.mItems;
        int n10 = tileList$Tile.mItemCount;
        ((AsyncListUtil$DataCallback)object).recycleData(objectArray, n10);
        tileList$Tile.mNext = object = this.mRecycledRoot;
        this.mRecycledRoot = tileList$Tile;
    }

    public void refresh(int n10) {
        this.mGeneration = n10;
        this.mLoadedTiles.clear();
        this.mItemCount = n10 = this.this$0.mDataCallback.refreshData();
        ThreadUtil$MainThreadCallback threadUtil$MainThreadCallback = this.this$0.mMainThreadProxy;
        int n11 = this.mGeneration;
        threadUtil$MainThreadCallback.updateItemCount(n11, n10);
    }

    public void updateRange(int n10, int n11, int n12, int n13, int n14) {
        if (n10 > n11) {
            return;
        }
        n10 = this.getTileStart(n10);
        n11 = this.getTileStart(n11);
        this.mFirstRequiredTileStart = n12 = this.getTileStart(n12);
        this.mLastRequiredTileStart = n12 = this.getTileStart(n13);
        n13 = 0;
        int n15 = 1;
        if (n14 == n15) {
            n10 = this.mFirstRequiredTileStart;
            this.requestTiles(n10, n11, n14, n15 != 0);
            AsyncListUtil asyncListUtil = this.this$0;
            n10 = asyncListUtil.mTileSize;
            n11 += n10;
            n10 = this.mLastRequiredTileStart;
            this.requestTiles(n11, n10, n14, false);
        } else {
            this.requestTiles(n10, n12, n14, false);
            n11 = this.mFirstRequiredTileStart;
            AsyncListUtil asyncListUtil = this.this$0;
            n12 = asyncListUtil.mTileSize;
            this.requestTiles(n11, n10 -= n12, n14, n15 != 0);
        }
    }
}

