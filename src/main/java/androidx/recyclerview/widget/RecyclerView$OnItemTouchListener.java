/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 */
package androidx.recyclerview.widget;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

public interface RecyclerView$OnItemTouchListener {
    public boolean onInterceptTouchEvent(RecyclerView var1, MotionEvent var2);

    public void onRequestDisallowInterceptTouchEvent(boolean var1);

    public void onTouchEvent(RecyclerView var1, MotionEvent var2);
}

