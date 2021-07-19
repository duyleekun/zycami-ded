/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;

public class ComponentActivity$4
implements LifecycleEventObserver {
    public final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$4(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event lifecycle$Event) {
        object = Lifecycle$Event.ON_DESTROY;
        if (lifecycle$Event == object) {
            this.this$0.mContextAwareHelper.clearAvailableContext();
            object = this.this$0;
            boolean bl2 = object.isChangingConfigurations();
            if (!bl2) {
                object = this.this$0.getViewModelStore();
                ((ViewModelStore)object).clear();
            }
        }
    }
}

