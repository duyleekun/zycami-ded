/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.core.view;

import android.view.View;
import androidx.core.view.NestedScrollingParent;

public interface NestedScrollingParent2
extends NestedScrollingParent {
    public void onNestedPreScroll(View var1, int var2, int var3, int[] var4, int var5);

    public void onNestedScroll(View var1, int var2, int var3, int var4, int var5, int var6);

    public void onNestedScrollAccepted(View var1, View var2, int var3, int var4);

    public boolean onStartNestedScroll(View var1, View var2, int var3, int var4);

    public void onStopNestedScroll(View var1, int var2);
}

