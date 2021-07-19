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
import androidx.fragment.app.FragmentTransition$FragmentContainerTransition;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;

public class FragmentTransition$6
implements Runnable {
    public final /* synthetic */ Object val$enterTransition;
    public final /* synthetic */ Object val$finalSharedElementTransition;
    public final /* synthetic */ FragmentTransition$FragmentContainerTransition val$fragments;
    public final /* synthetic */ FragmentTransitionImpl val$impl;
    public final /* synthetic */ Rect val$inEpicenter;
    public final /* synthetic */ Fragment val$inFragment;
    public final /* synthetic */ boolean val$inIsPop;
    public final /* synthetic */ ArrayMap val$nameOverrides;
    public final /* synthetic */ View val$nonExistentView;
    public final /* synthetic */ Fragment val$outFragment;
    public final /* synthetic */ ArrayList val$sharedElementsIn;
    public final /* synthetic */ ArrayList val$sharedElementsOut;

    public FragmentTransition$6(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap arrayMap, Object object, FragmentTransition$FragmentContainerTransition fragmentContainerTransition, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean bl2, ArrayList arrayList2, Object object2, Rect rect) {
        this.val$impl = fragmentTransitionImpl;
        this.val$nameOverrides = arrayMap;
        this.val$finalSharedElementTransition = object;
        this.val$fragments = fragmentContainerTransition;
        this.val$sharedElementsIn = arrayList;
        this.val$nonExistentView = view;
        this.val$inFragment = fragment;
        this.val$outFragment = fragment2;
        this.val$inIsPop = bl2;
        this.val$sharedElementsOut = arrayList2;
        this.val$enterTransition = object2;
        this.val$inEpicenter = rect;
    }

    public void run() {
        Object object = this.val$impl;
        Object object2 = this.val$nameOverrides;
        Object object3 = this.val$finalSharedElementTransition;
        Object object4 = this.val$fragments;
        if ((object = FragmentTransition.captureInSharedElements((FragmentTransitionImpl)object, (ArrayMap)object2, object3, (FragmentTransition$FragmentContainerTransition)object4)) != null) {
            object2 = this.val$sharedElementsIn;
            object3 = ((ArrayMap)object).values();
            ((ArrayList)object2).addAll(object3);
            object2 = this.val$sharedElementsIn;
            object3 = this.val$nonExistentView;
            ((ArrayList)object2).add(object3);
        }
        object2 = this.val$inFragment;
        object3 = this.val$outFragment;
        boolean bl2 = this.val$inIsPop;
        ArrayList arrayList = null;
        FragmentTransition.callSharedElementStartEnd((Fragment)object2, (Fragment)object3, bl2, (ArrayMap)object, false);
        object2 = this.val$finalSharedElementTransition;
        if (object2 != null) {
            object3 = this.val$impl;
            object4 = this.val$sharedElementsOut;
            arrayList = this.val$sharedElementsIn;
            ((FragmentTransitionImpl)object3).swapSharedElementTargets(object2, (ArrayList)object4, arrayList);
            object2 = this.val$fragments;
            object3 = this.val$enterTransition;
            bl2 = this.val$inIsPop;
            object = FragmentTransition.getInEpicenterView((ArrayMap)object, (FragmentTransition$FragmentContainerTransition)object2, object3, bl2);
            if (object != null) {
                object2 = this.val$impl;
                object3 = this.val$inEpicenter;
                ((FragmentTransitionImpl)object2).getBoundsOnScreen((View)object, (Rect)object3);
            }
        }
    }
}

