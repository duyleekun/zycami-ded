/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentStateAdapter$5
implements LifecycleEventObserver {
    public final /* synthetic */ FragmentStateAdapter this$0;
    public final /* synthetic */ Handler val$handler;
    public final /* synthetic */ Runnable val$runnable;

    public FragmentStateAdapter$5(FragmentStateAdapter fragmentStateAdapter, Handler handler, Runnable runnable) {
        this.this$0 = fragmentStateAdapter;
        this.val$handler = handler;
        this.val$runnable = runnable;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event lifecycle$Event) {
        Object object2 = Lifecycle$Event.ON_DESTROY;
        if (lifecycle$Event == object2) {
            lifecycle$Event = this.val$handler;
            object2 = this.val$runnable;
            lifecycle$Event.removeCallbacks((Runnable)object2);
            object = object.getLifecycle();
            ((Lifecycle)object).removeObserver(this);
        }
    }
}

