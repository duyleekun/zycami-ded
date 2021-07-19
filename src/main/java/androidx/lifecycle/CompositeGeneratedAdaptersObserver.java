/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class CompositeGeneratedAdaptersObserver
implements LifecycleEventObserver {
    private final GeneratedAdapter[] mGeneratedAdapters;

    public CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapterArray) {
        this.mGeneratedAdapters = generatedAdapterArray;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        GeneratedAdapter[] generatedAdapterArray = this.mGeneratedAdapters;
        int n10 = generatedAdapterArray.length;
        int n11 = 0;
        GeneratedAdapter generatedAdapter = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            GeneratedAdapter generatedAdapter2 = generatedAdapterArray[i10];
            generatedAdapter2.callMethods(lifecycleOwner, lifecycle$Event, false, methodCallsLogger);
        }
        generatedAdapterArray = this.mGeneratedAdapters;
        n10 = generatedAdapterArray.length;
        while (n11 < n10) {
            generatedAdapter = generatedAdapterArray[n11];
            boolean bl2 = true;
            generatedAdapter.callMethods(lifecycleOwner, lifecycle$Event, bl2, methodCallsLogger);
            ++n11;
        }
    }
}

