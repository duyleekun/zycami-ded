/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public class LinearLayoutManager$LayoutChunkResult {
    public int mConsumed;
    public boolean mFinished;
    public boolean mFocusable;
    public boolean mIgnoreConsumed;

    public void resetInternal() {
        this.mConsumed = 0;
        this.mFinished = false;
        this.mIgnoreConsumed = false;
        this.mFocusable = false;
    }
}

