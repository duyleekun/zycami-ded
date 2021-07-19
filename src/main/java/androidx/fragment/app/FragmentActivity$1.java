/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;

public class FragmentActivity$1
implements SavedStateRegistry$SavedStateProvider {
    public final /* synthetic */ FragmentActivity this$0;

    public FragmentActivity$1(FragmentActivity fragmentActivity) {
        this.this$0 = fragmentActivity;
    }

    public Bundle saveState() {
        Bundle bundle = new Bundle();
        this.this$0.markFragmentsCreated();
        LifecycleRegistry lifecycleRegistry = this.this$0.mFragmentLifecycleRegistry;
        Object object = Lifecycle$Event.ON_STOP;
        lifecycleRegistry.handleLifecycleEvent((Lifecycle$Event)((Object)object));
        lifecycleRegistry = this.this$0.mFragments.saveAllState();
        if (lifecycleRegistry != null) {
            object = "android:support:fragments";
            bundle.putParcelable((String)object, (Parcelable)lifecycleRegistry);
        }
        return bundle;
    }
}

