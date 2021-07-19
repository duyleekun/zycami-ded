/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.EdgeEffect
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerView$EdgeEffectFactory {
    public static final int DIRECTION_BOTTOM = 3;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_TOP = 1;

    public EdgeEffect createEdgeEffect(RecyclerView recyclerView, int n10) {
        recyclerView = recyclerView.getContext();
        EdgeEffect edgeEffect = new EdgeEffect((Context)recyclerView);
        return edgeEffect;
    }
}

