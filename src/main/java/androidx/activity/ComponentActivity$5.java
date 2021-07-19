/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class ComponentActivity$5
implements LifecycleEventObserver {
    public final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$5(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        this.this$0.ensureViewModelStore();
        this.this$0.getLifecycle().removeObserver(this);
    }
}

