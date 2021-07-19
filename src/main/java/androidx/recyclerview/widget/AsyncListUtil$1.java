/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.recyclerview.widget;

import android.util.Log;
import androidx.recyclerview.widget.AsyncListUtil;
import androidx.recyclerview.widget.AsyncListUtil$ViewCallback;
import androidx.recyclerview.widget.ThreadUtil$BackgroundCallback;
import androidx.recyclerview.widget.ThreadUtil$MainThreadCallback;
import androidx.recyclerview.widget.TileList;
import androidx.recyclerview.widget.TileList$Tile;

public class AsyncListUtil$1
implements ThreadUtil$MainThreadCallback {
    public final /* synthetic */ AsyncListUtil this$0;

    public AsyncListUtil$1(AsyncListUtil asyncListUtil) {
        this.this$0 = asyncListUtil;
    }

    private boolean isRequestedGeneration(int n10) {
        AsyncListUtil asyncListUtil = this.this$0;
        int n11 = asyncListUtil.mRequestedGeneration;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    private void recycleAllTiles() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((TileList)(object = this.this$0.mTileList)).size()); ++i10) {
            object = this.this$0;
            ThreadUtil$BackgroundCallback threadUtil$BackgroundCallback = ((AsyncListUtil)object).mBackgroundProxy;
            object = ((AsyncListUtil)object).mTileList.getAtIndex(i10);
            threadUtil$BackgroundCallback.recycleTile((TileList$Tile)object);
        }
        this.this$0.mTileList.clear();
    }

    public void addTile(int n10, TileList$Tile tileList$Tile) {
        Object object;
        int n11;
        Object object2;
        if ((n10 = (int)(this.isRequestedGeneration(n10) ? 1 : 0)) == 0) {
            this.this$0.mBackgroundProxy.recycleTile(tileList$Tile);
            return;
        }
        TileList$Tile tileList$Tile2 = this.this$0.mTileList.addOrReplace(tileList$Tile);
        if (tileList$Tile2 != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("duplicate tile @");
            n11 = tileList$Tile2.mStartPosition;
            ((StringBuilder)object2).append(n11);
            object2 = ((StringBuilder)object2).toString();
            object = "AsyncListUtil";
            Log.e((String)object, (String)object2);
            object2 = this.this$0.mBackgroundProxy;
            object2.recycleTile(tileList$Tile2);
        }
        n10 = tileList$Tile.mStartPosition;
        int n12 = tileList$Tile.mItemCount;
        n10 += n12;
        n12 = 0;
        object2 = null;
        while (n12 < (n11 = (object = this.this$0.mMissingPositions).size())) {
            int n13 = tileList$Tile.mStartPosition;
            object = this.this$0.mMissingPositions;
            n11 = object.keyAt(n12);
            if (n13 <= n11 && n11 < n10) {
                this.this$0.mMissingPositions.removeAt(n12);
                AsyncListUtil$ViewCallback asyncListUtil$ViewCallback = this.this$0.mViewCallback;
                asyncListUtil$ViewCallback.onItemLoaded(n11);
                continue;
            }
            ++n12;
        }
    }

    public void removeTile(int n10, int n11) {
        if ((n10 = (int)(this.isRequestedGeneration(n10) ? 1 : 0)) == 0) {
            return;
        }
        Object object = this.this$0.mTileList.removeAtPos(n11);
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("tile not found @");
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            Log.e((String)"AsyncListUtil", (String)object);
            return;
        }
        this.this$0.mBackgroundProxy.recycleTile((TileList$Tile)object);
    }

    public void updateItemCount(int n10, int n11) {
        if ((n10 = (int)(this.isRequestedGeneration(n10) ? 1 : 0)) == 0) {
            return;
        }
        AsyncListUtil asyncListUtil = this.this$0;
        asyncListUtil.mItemCount = n11;
        asyncListUtil.mViewCallback.onDataRefresh();
        asyncListUtil = this.this$0;
        asyncListUtil.mDisplayedGeneration = n11 = asyncListUtil.mRequestedGeneration;
        this.recycleAllTiles();
        asyncListUtil = this.this$0;
        asyncListUtil.mAllowScrollHints = false;
        asyncListUtil.updateRange();
    }
}

