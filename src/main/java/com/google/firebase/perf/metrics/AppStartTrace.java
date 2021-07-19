/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 */
package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.provider.FirebasePerfProvider;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TraceMetric$Builder;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AppStartTrace
implements Application.ActivityLifecycleCallbacks {
    private static final long MAX_LATENCY_BEFORE_UI_INIT = TimeUnit.MINUTES.toMicros(1L);
    private static volatile AppStartTrace sInstance;
    private Context mAppContext;
    private WeakReference mAppStartActivity;
    private final Clock mClock;
    private boolean mIsStartFromBackground = false;
    private WeakReference mLaunchActivity;
    private Timer mOnCreateTime = null;
    private Timer mOnResumeTime = null;
    private Timer mOnStartTime = null;
    private boolean mRegistered = false;
    private boolean mTooLateToInitUI = false;
    private final TransportManager transportManager;

    public AppStartTrace(TransportManager transportManager, Clock clock) {
        this.transportManager = transportManager;
        this.mClock = clock;
    }

    public static /* synthetic */ Timer access$000(AppStartTrace appStartTrace) {
        return appStartTrace.mOnCreateTime;
    }

    public static /* synthetic */ boolean access$102(AppStartTrace appStartTrace, boolean bl2) {
        appStartTrace.mIsStartFromBackground = bl2;
        return bl2;
    }

    public static AppStartTrace getInstance() {
        Object object = sInstance;
        if (object != null) {
            object = sInstance;
        } else {
            object = TransportManager.getInstance();
            Clock clock = new Clock();
            object = AppStartTrace.getInstance((TransportManager)object, clock);
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AppStartTrace getInstance(TransportManager transportManager, Clock clock) {
        Object object = sInstance;
        if (object != null) return sInstance;
        object = AppStartTrace.class;
        synchronized (object) {
            AppStartTrace appStartTrace = sInstance;
            if (appStartTrace != null) return sInstance;
            sInstance = appStartTrace = new AppStartTrace(transportManager, clock);
            return sInstance;
        }
    }

    public static void setLauncherActivityOnCreateTime(String string2) {
    }

    public static void setLauncherActivityOnResumeTime(String string2) {
    }

    public static void setLauncherActivityOnStartTime(String string2) {
    }

    public Activity getAppStartActivity() {
        return (Activity)this.mAppStartActivity.get();
    }

    public Activity getLaunchActivity() {
        return (Activity)this.mLaunchActivity.get();
    }

    public Timer getOnCreateTime() {
        return this.mOnCreateTime;
    }

    public Timer getOnResumeTime() {
        return this.mOnResumeTime;
    }

    public Timer getOnStartTime() {
        return this.mOnStartTime;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onActivityCreated(Activity object, Bundle object2) {
        synchronized (this) {
            boolean bl2 = this.mIsStartFromBackground;
            if (!bl2 && (object2 = this.mOnCreateTime) == null) {
                long l10;
                Timer timer;
                WeakReference<Object> weakReference;
                this.mLaunchActivity = weakReference = new WeakReference<Object>(object);
                object = this.mClock;
                this.mOnCreateTime = object = ((Clock)object).getTime();
                object = FirebasePerfProvider.getAppStartTime();
                long l11 = ((Timer)object).getDurationMicros(timer = this.mOnCreateTime);
                long l12 = l11 - (l10 = MAX_LATENCY_BEFORE_UI_INIT);
                Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object3 > 0) {
                    object3 = 1;
                    this.mTooLateToInitUI = object3;
                }
                return;
            }
            return;
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onActivityResumed(Activity object) {
        synchronized (this) {
            Object object2;
            boolean bl2 = this.mIsStartFromBackground;
            if (!bl2 && (object2 = this.mOnResumeTime) == null && !(bl2 = this.mTooLateToInitUI)) {
                object2 = new WeakReference(object);
                this.mAppStartActivity = object2;
                object2 = this.mClock;
                this.mOnResumeTime = object2 = ((Clock)object2).getTime();
                object2 = FirebasePerfProvider.getAppStartTime();
                Object object3 = AndroidLogger.getInstance();
                Object object4 = new StringBuilder();
                Object object5 = "onResume(): ";
                ((StringBuilder)object4).append((String)object5);
                object = object.getClass();
                object = ((Class)object).getName();
                ((StringBuilder)object4).append((String)object);
                object = ": ";
                ((StringBuilder)object4).append((String)object);
                object = this.mOnResumeTime;
                long l10 = ((Timer)object2).getDurationMicros((Timer)object);
                ((StringBuilder)object4).append(l10);
                object = " microseconds";
                ((StringBuilder)object4).append((String)object);
                object = ((StringBuilder)object4).toString();
                ((AndroidLogger)object3).debug((String)object);
                object = TraceMetric.newBuilder();
                object3 = Constants$TraceNames.APP_START_TRACE_NAME;
                object3 = ((Constants$TraceNames)((Object)object3)).toString();
                object = ((TraceMetric$Builder)object).setName((String)object3);
                long l11 = ((Timer)object2).getMicros();
                object = ((TraceMetric$Builder)object).setClientStartTimeUs(l11);
                object3 = this.mOnResumeTime;
                l11 = ((Timer)object2).getDurationMicros((Timer)object3);
                object = ((TraceMetric$Builder)object).setDurationUs(l11);
                int n10 = 3;
                object3 = new ArrayList(n10);
                object4 = TraceMetric.newBuilder();
                object5 = Constants$TraceNames.ON_CREATE_TRACE_NAME;
                object5 = ((Constants$TraceNames)((Object)object5)).toString();
                object4 = ((TraceMetric$Builder)object4).setName((String)object5);
                l10 = ((Timer)object2).getMicros();
                object4 = ((TraceMetric$Builder)object4).setClientStartTimeUs(l10);
                object5 = this.mOnCreateTime;
                l10 = ((Timer)object2).getDurationMicros((Timer)object5);
                object2 = ((TraceMetric$Builder)object4).setDurationUs(l10);
                object2 = ((GeneratedMessageLite$Builder)object2).build();
                object2 = (TraceMetric)object2;
                object3.add(object2);
                object2 = TraceMetric.newBuilder();
                object4 = Constants$TraceNames.ON_START_TRACE_NAME;
                object4 = ((Constants$TraceNames)((Object)object4)).toString();
                object4 = ((TraceMetric$Builder)object2).setName((String)object4);
                object5 = this.mOnCreateTime;
                l10 = ((Timer)object5).getMicros();
                object4 = ((TraceMetric$Builder)object4).setClientStartTimeUs(l10);
                object5 = this.mOnCreateTime;
                Timer timer = this.mOnStartTime;
                l10 = ((Timer)object5).getDurationMicros(timer);
                ((TraceMetric$Builder)object4).setDurationUs(l10);
                object2 = ((GeneratedMessageLite$Builder)object2).build();
                object2 = (TraceMetric)object2;
                object3.add(object2);
                object2 = TraceMetric.newBuilder();
                object4 = Constants$TraceNames.ON_RESUME_TRACE_NAME;
                object4 = ((Constants$TraceNames)((Object)object4)).toString();
                object4 = ((TraceMetric$Builder)object2).setName((String)object4);
                object5 = this.mOnStartTime;
                l10 = ((Timer)object5).getMicros();
                object4 = ((TraceMetric$Builder)object4).setClientStartTimeUs(l10);
                object5 = this.mOnStartTime;
                timer = this.mOnResumeTime;
                l10 = ((Timer)object5).getDurationMicros(timer);
                ((TraceMetric$Builder)object4).setDurationUs(l10);
                object2 = ((GeneratedMessageLite$Builder)object2).build();
                object2 = (TraceMetric)object2;
                object3.add(object2);
                object2 = ((TraceMetric$Builder)object).addAllSubtraces((Iterable)object3);
                object3 = SessionManager.getInstance();
                object3 = ((SessionManager)object3).perfSession();
                object3 = ((com.google.firebase.perf.internal.PerfSession)object3).build();
                ((TraceMetric$Builder)object2).addPerfSessions((PerfSession)object3);
                object2 = this.transportManager;
                object = ((GeneratedMessageLite$Builder)object).build();
                object = (TraceMetric)object;
                object3 = ApplicationProcessState.FOREGROUND_BACKGROUND;
                ((TransportManager)object2).log((TraceMetric)object, (ApplicationProcessState)object3);
                boolean bl3 = this.mRegistered;
                if (bl3) {
                    this.unregisterActivityLifecycleCallbacks();
                }
                return;
            }
            return;
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onActivityStarted(Activity object) {
        synchronized (this) {
            boolean bl2 = this.mIsStartFromBackground;
            if (!bl2 && (object = this.mOnStartTime) == null && !(bl2 = this.mTooLateToInitUI)) {
                object = this.mClock;
                this.mOnStartTime = object = ((Clock)object).getTime();
                return;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void onActivityStopped(Activity activity) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerActivityLifecycleCallbacks(Context context) {
        synchronized (this) {
            boolean bl2 = this.mRegistered;
            if (bl2) {
                return;
            }
            bl2 = (context = context.getApplicationContext()) instanceof Application;
            if (bl2) {
                Context context2 = context;
                context2 = (Application)context;
                context2.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
                this.mRegistered = bl2 = true;
                this.mAppContext = context;
            }
            return;
        }
    }

    public void setIsStartFromBackground() {
        this.mIsStartFromBackground = true;
    }

    public void unregisterActivityLifecycleCallbacks() {
        synchronized (this) {
            boolean bl2;
            block7: {
                bl2 = this.mRegistered;
                if (bl2) break block7;
                return;
            }
            Context context = this.mAppContext;
            context = (Application)context;
            context.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
            bl2 = false;
            context = null;
            this.mRegistered = false;
            return;
        }
    }
}

