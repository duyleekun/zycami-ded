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
import java.util.Map;

public class FragmentTransitionImpl$2
implements Runnable {
    public final /* synthetic */ FragmentTransitionImpl this$0;
    public final /* synthetic */ Map val$nameOverrides;
    public final /* synthetic */ ArrayList val$sharedElementsIn;

    public FragmentTransitionImpl$2(FragmentTransitionImpl fragmentTransitionImpl, ArrayList arrayList, Map map) {
        this.this$0 = fragmentTransitionImpl;
        this.val$sharedElementsIn = arrayList;
        this.val$nameOverrides = map;
    }

    public void run() {
        ArrayList arrayList = this.val$sharedElementsIn;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = (View)this.val$sharedElementsIn.get(i10);
            String string2 = ViewCompat.getTransitionName(view);
            if (string2 == null) continue;
            Map map = this.val$nameOverrides;
            string2 = FragmentTransitionImpl.findKeyForValue(map, string2);
            ViewCompat.setTransitionName(view, string2);
        }
    }
}

