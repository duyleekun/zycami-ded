/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;

public class NavController$1
implements LifecycleEventObserver {
    public final /* synthetic */ NavController this$0;

    public NavController$1(NavController navController) {
        this.this$0 = navController;
    }

    public void onStateChanged(LifecycleOwner iterator2, Lifecycle$Event lifecycle$Event) {
        iterator2 = this.this$0;
        Object object = ((NavController)iterator2).mGraph;
        if (object != null) {
            boolean bl2;
            iterator2 = ((NavController)iterator2).mBackStack.iterator();
            while (bl2 = iterator2.hasNext()) {
                object = (NavBackStackEntry)iterator2.next();
                ((NavBackStackEntry)object).handleLifecycleEvent(lifecycle$Event);
            }
        }
    }
}

