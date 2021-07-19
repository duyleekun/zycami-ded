/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 */
package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionImpl;

public class FragmentTransition$5
implements Runnable {
    public final /* synthetic */ Rect val$epicenter;
    public final /* synthetic */ View val$epicenterView;
    public final /* synthetic */ FragmentTransitionImpl val$impl;
    public final /* synthetic */ Fragment val$inFragment;
    public final /* synthetic */ boolean val$inIsPop;
    public final /* synthetic */ ArrayMap val$inSharedElements;
    public final /* synthetic */ Fragment val$outFragment;

    public FragmentTransition$5(Fragment fragment, Fragment fragment2, boolean bl2, ArrayMap arrayMap, View view, FragmentTransitionImpl fragmentTransitionImpl, Rect rect) {
        this.val$inFragment = fragment;
        this.val$outFragment = fragment2;
        this.val$inIsPop = bl2;
        this.val$inSharedElements = arrayMap;
        this.val$epicenterView = view;
        this.val$impl = fragmentTransitionImpl;
        this.val$epicenter = rect;
    }

    public void run() {
        Fragment fragment = this.val$inFragment;
        Object object = this.val$outFragment;
        boolean bl2 = this.val$inIsPop;
        ArrayMap arrayMap = this.val$inSharedElements;
        FragmentTransition.callSharedElementStartEnd(fragment, (Fragment)object, bl2, arrayMap, false);
        fragment = this.val$epicenterView;
        if (fragment != null) {
            object = this.val$impl;
            Rect rect = this.val$epicenter;
            ((FragmentTransitionImpl)object).getBoundsOnScreen((View)fragment, rect);
        }
    }
}

