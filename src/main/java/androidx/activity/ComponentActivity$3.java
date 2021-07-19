/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class ComponentActivity$3
implements LifecycleEventObserver {
    public final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$3(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event lifecycle$Event) {
        object = Lifecycle$Event.ON_STOP;
        if (lifecycle$Event == object && (object = (object = this.this$0.getWindow()) != null ? object.peekDecorView() : null) != null) {
            object.cancelPendingInputEvents();
        }
    }
}

