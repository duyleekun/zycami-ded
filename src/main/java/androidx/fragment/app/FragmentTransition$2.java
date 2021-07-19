/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.FragmentTransition;
import java.util.ArrayList;

public class FragmentTransition$2
implements Runnable {
    public final /* synthetic */ ArrayList val$exitingViews;

    public FragmentTransition$2(ArrayList arrayList) {
        this.val$exitingViews = arrayList;
    }

    public void run() {
        FragmentTransition.setViewVisibility(this.val$exitingViews, 4);
    }
}

