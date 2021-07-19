/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

public class GapWorker$Task {
    public int distanceToItem;
    public boolean immediate;
    public int position;
    public RecyclerView view;
    public int viewVelocity;

    public void clear() {
        this.immediate = false;
        this.viewVelocity = 0;
        this.distanceToItem = 0;
        this.view = null;
        this.position = 0;
    }
}

