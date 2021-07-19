/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList$Tile;

public interface ThreadUtil$BackgroundCallback {
    public void loadTile(int var1, int var2);

    public void recycleTile(TileList$Tile var1);

    public void refresh(int var1);

    public void updateRange(int var1, int var2, int var3, int var4, int var5);
}

