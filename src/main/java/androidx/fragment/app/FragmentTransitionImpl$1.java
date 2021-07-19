/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;

public class FragmentTransitionImpl$1
implements Runnable {
    public final /* synthetic */ FragmentTransitionImpl this$0;
    public final /* synthetic */ ArrayList val$inNames;
    public final /* synthetic */ int val$numSharedElements;
    public final /* synthetic */ ArrayList val$outNames;
    public final /* synthetic */ ArrayList val$sharedElementsIn;
    public final /* synthetic */ ArrayList val$sharedElementsOut;

    public FragmentTransitionImpl$1(FragmentTransitionImpl fragmentTransitionImpl, int n10, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.this$0 = fragmentTransitionImpl;
        this.val$numSharedElements = n10;
        this.val$sharedElementsIn = arrayList;
        this.val$inNames = arrayList2;
        this.val$sharedElementsOut = arrayList3;
        this.val$outNames = arrayList4;
    }

    public void run() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.val$numSharedElements); ++i10) {
            View view = (View)this.val$sharedElementsIn.get(i10);
            String string2 = (String)this.val$inNames.get(i10);
            ViewCompat.setTransitionName(view, string2);
            view = (View)this.val$sharedElementsOut.get(i10);
            string2 = (String)this.val$outNames.get(i10);
            ViewCompat.setTransitionName(view, string2);
        }
    }
}

