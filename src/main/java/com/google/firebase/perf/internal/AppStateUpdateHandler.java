/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.internal;

import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.AppStateMonitor$AppStateCallback;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;

public abstract class AppStateUpdateHandler
implements AppStateMonitor$AppStateCallback {
    private AppStateMonitor mAppStateMonitor;
    private boolean mIsRegisteredForAppState;
    private ApplicationProcessState mState;
    private WeakReference mWeakRef;

    public AppStateUpdateHandler() {
        AppStateMonitor appStateMonitor = AppStateMonitor.getInstance();
        this(appStateMonitor);
    }

    public AppStateUpdateHandler(AppStateMonitor weakReference) {
        ApplicationProcessState applicationProcessState;
        this.mState = applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.mIsRegisteredForAppState = false;
        this.mAppStateMonitor = weakReference;
        this.mWeakRef = weakReference = new WeakReference<AppStateUpdateHandler>(this);
    }

    public ApplicationProcessState getAppState() {
        return this.mState;
    }

    public void incrementTsnsCount(int n10) {
        this.mAppStateMonitor.incrementTsnsCount(n10);
    }

    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        ApplicationProcessState applicationProcessState2 = this.mState;
        ApplicationProcessState applicationProcessState3 = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        if (applicationProcessState2 == applicationProcessState3) {
            this.mState = applicationProcessState;
        } else if (applicationProcessState2 != applicationProcessState && applicationProcessState != applicationProcessState3) {
            this.mState = applicationProcessState = ApplicationProcessState.FOREGROUND_BACKGROUND;
        }
    }

    public void registerForAppState() {
        boolean bl2 = this.mIsRegisteredForAppState;
        if (bl2) {
            return;
        }
        Object object = this.mAppStateMonitor.getAppState();
        this.mState = object;
        object = this.mAppStateMonitor;
        WeakReference weakReference = this.mWeakRef;
        ((AppStateMonitor)object).registerForAppState(weakReference);
        this.mIsRegisteredForAppState = true;
    }

    public void unregisterForAppState() {
        boolean bl2 = this.mIsRegisteredForAppState;
        if (!bl2) {
            return;
        }
        AppStateMonitor appStateMonitor = this.mAppStateMonitor;
        WeakReference weakReference = this.mWeakRef;
        appStateMonitor.unregisterForAppState(weakReference);
        this.mIsRegisteredForAppState = false;
    }
}

