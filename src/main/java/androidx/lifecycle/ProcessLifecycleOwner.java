/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Handler
 */
package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ProcessLifecycleOwner$1;
import androidx.lifecycle.ProcessLifecycleOwner$2;
import androidx.lifecycle.ProcessLifecycleOwner$3;
import androidx.lifecycle.ReportFragment$ActivityInitializationListener;

public class ProcessLifecycleOwner
implements LifecycleOwner {
    public static final long TIMEOUT_MS = 700L;
    private static final ProcessLifecycleOwner sInstance;
    private Runnable mDelayedPauseRunnable;
    private Handler mHandler;
    public ReportFragment$ActivityInitializationListener mInitializationListener;
    private boolean mPauseSent;
    private final LifecycleRegistry mRegistry;
    private int mResumedCounter = 0;
    private int mStartedCounter = 0;
    private boolean mStopSent;

    static {
        ProcessLifecycleOwner processLifecycleOwner;
        sInstance = processLifecycleOwner = new ProcessLifecycleOwner();
    }

    private ProcessLifecycleOwner() {
        boolean bl2;
        this.mPauseSent = bl2 = true;
        this.mStopSent = bl2;
        Object object = new LifecycleRegistry(this);
        this.mRegistry = object;
        this.mDelayedPauseRunnable = object = new ProcessLifecycleOwner$1(this);
        this.mInitializationListener = object = new ProcessLifecycleOwner$2(this);
    }

    public static LifecycleOwner get() {
        return sInstance;
    }

    public static void init(Context context) {
        sInstance.attach(context);
    }

    public void activityPaused() {
        int n10;
        this.mResumedCounter = n10 = this.mResumedCounter + -1;
        if (n10 == 0) {
            Handler handler = this.mHandler;
            Runnable runnable = this.mDelayedPauseRunnable;
            long l10 = 700L;
            handler.postDelayed(runnable, l10);
        }
    }

    public void activityResumed() {
        int n10 = this.mResumedCounter;
        int n11 = 1;
        this.mResumedCounter = n10 += n11;
        if (n10 == n11) {
            n10 = (int)(this.mPauseSent ? 1 : 0);
            if (n10 != 0) {
                LifecycleRegistry lifecycleRegistry = this.mRegistry;
                Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_RESUME;
                lifecycleRegistry.handleLifecycleEvent(lifecycle$Event);
                n10 = 0;
                lifecycleRegistry = null;
                this.mPauseSent = false;
            } else {
                Handler handler = this.mHandler;
                Runnable runnable = this.mDelayedPauseRunnable;
                handler.removeCallbacks(runnable);
            }
        }
    }

    public void activityStarted() {
        int n10 = this.mStartedCounter;
        int n11 = 1;
        this.mStartedCounter = n10 += n11;
        if (n10 == n11 && (n10 = (int)(this.mStopSent ? 1 : 0)) != 0) {
            LifecycleRegistry lifecycleRegistry = this.mRegistry;
            Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_START;
            lifecycleRegistry.handleLifecycleEvent(lifecycle$Event);
            n10 = 0;
            lifecycleRegistry = null;
            this.mStopSent = false;
        }
    }

    public void activityStopped() {
        int n10;
        this.mStartedCounter = n10 = this.mStartedCounter + -1;
        this.dispatchStopIfNeeded();
    }

    public void attach(Context context) {
        Object object = new Handler();
        this.mHandler = object;
        object = this.mRegistry;
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_CREATE;
        ((LifecycleRegistry)object).handleLifecycleEvent(lifecycle$Event);
        context = (Application)context.getApplicationContext();
        object = new ProcessLifecycleOwner$3(this);
        context.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)object);
    }

    public void dispatchPauseIfNeeded() {
        int n10 = this.mResumedCounter;
        if (n10 == 0) {
            n10 = 1;
            this.mPauseSent = n10;
            LifecycleRegistry lifecycleRegistry = this.mRegistry;
            Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_PAUSE;
            lifecycleRegistry.handleLifecycleEvent(lifecycle$Event);
        }
    }

    public void dispatchStopIfNeeded() {
        int n10 = this.mStartedCounter;
        if (n10 == 0 && (n10 = (int)(this.mPauseSent ? 1 : 0)) != 0) {
            LifecycleRegistry lifecycleRegistry = this.mRegistry;
            Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_STOP;
            lifecycleRegistry.handleLifecycleEvent(lifecycle$Event);
            n10 = 1;
            this.mStopSent = n10;
        }
    }

    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }
}

