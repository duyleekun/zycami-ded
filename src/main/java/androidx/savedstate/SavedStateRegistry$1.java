/*
 * Decompiled with CFR 0.151.
 */
package androidx.savedstate;

import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;

public class SavedStateRegistry$1
implements GenericLifecycleObserver {
    public final /* synthetic */ SavedStateRegistry this$0;

    public SavedStateRegistry$1(SavedStateRegistry savedStateRegistry) {
        this.this$0 = savedStateRegistry;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event lifecycle$Event) {
        object = Lifecycle$Event.ON_START;
        if (lifecycle$Event == object) {
            boolean bl2;
            object = this.this$0;
            ((SavedStateRegistry)object).mAllowingSavingState = bl2 = true;
        } else {
            object = Lifecycle$Event.ON_STOP;
            if (lifecycle$Event == object) {
                object = this.this$0;
                boolean bl3 = false;
                lifecycle$Event = null;
                ((SavedStateRegistry)object).mAllowingSavingState = false;
            }
        }
    }
}

