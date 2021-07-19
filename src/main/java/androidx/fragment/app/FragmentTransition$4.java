/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.fragment.app;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;

public class FragmentTransition$4
implements Runnable {
    public final /* synthetic */ Object val$enterTransition;
    public final /* synthetic */ ArrayList val$enteringViews;
    public final /* synthetic */ Object val$exitTransition;
    public final /* synthetic */ ArrayList val$exitingViews;
    public final /* synthetic */ FragmentTransitionImpl val$impl;
    public final /* synthetic */ Fragment val$inFragment;
    public final /* synthetic */ View val$nonExistentView;
    public final /* synthetic */ ArrayList val$sharedElementsIn;

    public FragmentTransition$4(Object object, FragmentTransitionImpl fragmentTransitionImpl, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object object2) {
        this.val$enterTransition = object;
        this.val$impl = fragmentTransitionImpl;
        this.val$nonExistentView = view;
        this.val$inFragment = fragment;
        this.val$sharedElementsIn = arrayList;
        this.val$enteringViews = arrayList2;
        this.val$exitingViews = arrayList3;
        this.val$exitTransition = object2;
    }

    public void run() {
        ArrayList arrayList;
        Object object;
        Object object2;
        Object object3 = this.val$enterTransition;
        if (object3 != null) {
            object2 = this.val$impl;
            object = this.val$nonExistentView;
            ((FragmentTransitionImpl)object2).removeTarget(object3, (View)object);
            object3 = this.val$impl;
            object2 = this.val$enterTransition;
            object = this.val$inFragment;
            arrayList = this.val$sharedElementsIn;
            View view = this.val$nonExistentView;
            object3 = FragmentTransition.configureEnteringExitingViews((FragmentTransitionImpl)object3, object2, (Fragment)object, arrayList, view);
            object2 = this.val$enteringViews;
            ((ArrayList)object2).addAll(object3);
        }
        if ((object3 = this.val$exitingViews) != null) {
            object3 = this.val$exitTransition;
            if (object3 != null) {
                object3 = new ArrayList();
                object2 = this.val$nonExistentView;
                ((ArrayList)object3).add(object2);
                object2 = this.val$impl;
                object = this.val$exitTransition;
                arrayList = this.val$exitingViews;
                ((FragmentTransitionImpl)object2).replaceTargets(object, arrayList, (ArrayList)object3);
            }
            this.val$exitingViews.clear();
            object3 = this.val$exitingViews;
            object2 = this.val$nonExistentView;
            ((ArrayList)object3).add(object2);
        }
    }
}

