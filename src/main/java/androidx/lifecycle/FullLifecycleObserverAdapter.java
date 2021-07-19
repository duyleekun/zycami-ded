/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.FullLifecycleObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter$1;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class FullLifecycleObserverAdapter
implements LifecycleEventObserver {
    private final FullLifecycleObserver mFullLifecycleObserver;
    private final LifecycleEventObserver mLifecycleEventObserver;

    public FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver, LifecycleEventObserver lifecycleEventObserver) {
        this.mFullLifecycleObserver = fullLifecycleObserver;
        this.mLifecycleEventObserver = lifecycleEventObserver;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event lifecycle$Event) {
        Object object2 = FullLifecycleObserverAdapter$1.$SwitchMap$androidx$lifecycle$Lifecycle$Event;
        int n10 = lifecycle$Event.ordinal();
        int n11 = object2[n10];
        switch (n11) {
            default: {
                break;
            }
            case 7: {
                object = new IllegalArgumentException("ON_ANY must not been send by anybody");
                throw object;
            }
            case 6: {
                object2 = this.mFullLifecycleObserver;
                object2.onDestroy((LifecycleOwner)object);
                break;
            }
            case 5: {
                object2 = this.mFullLifecycleObserver;
                object2.onStop((LifecycleOwner)object);
                break;
            }
            case 4: {
                object2 = this.mFullLifecycleObserver;
                object2.onPause((LifecycleOwner)object);
                break;
            }
            case 3: {
                object2 = this.mFullLifecycleObserver;
                object2.onResume((LifecycleOwner)object);
                break;
            }
            case 2: {
                object2 = this.mFullLifecycleObserver;
                object2.onStart((LifecycleOwner)object);
                break;
            }
            case 1: {
                object2 = this.mFullLifecycleObserver;
                object2.onCreate((LifecycleOwner)object);
            }
        }
        object2 = this.mLifecycleEventObserver;
        if (object2 != null) {
            object2.onStateChanged((LifecycleOwner)object, lifecycle$Event);
        }
    }
}

