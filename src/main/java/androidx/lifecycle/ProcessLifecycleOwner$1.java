/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.ProcessLifecycleOwner;

public class ProcessLifecycleOwner$1
implements Runnable {
    public final /* synthetic */ ProcessLifecycleOwner this$0;

    public ProcessLifecycleOwner$1(ProcessLifecycleOwner processLifecycleOwner) {
        this.this$0 = processLifecycleOwner;
    }

    public void run() {
        this.this$0.dispatchPauseIfNeeded();
        this.this$0.dispatchStopIfNeeded();
    }
}

