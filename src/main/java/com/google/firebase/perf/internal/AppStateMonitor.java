/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.Window
 */
package com.google.firebase.perf.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import androidx.core.app.FrameMetricsAggregator;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.AppStateMonitor$AppStateCallback;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TraceMetric$Builder;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AppStateMonitor
implements Application.ActivityLifecycleCallbacks {
    private static final String FRAME_METRICS_AGGREGATOR_CLASSNAME = "androidx.core.app.FrameMetricsAggregator";
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static volatile AppStateMonitor sInstance;
    private boolean hasFrameMetricsAggregator;
    private final WeakHashMap mActivity2ScreenTrace;
    private Set mClients;
    private final Clock mClock;
    private ConfigResolver mConfigResolver;
    private ApplicationProcessState mCurrentState;
    private FrameMetricsAggregator mFrameMetricsAggregator;
    private boolean mIsColdStart;
    private final Map mMetrics;
    private boolean mRegistered = false;
    private Timer mResumeTime;
    private final WeakHashMap mResumed;
    private Timer mStopTime;
    private AtomicInteger mTsnsCount;
    private final TransportManager transportManager;

    public AppStateMonitor(TransportManager object, Clock clock) {
        boolean bl2;
        WeakHashMap weakHashMap;
        boolean bl3;
        this.mIsColdStart = bl3 = true;
        HashSet hashSet = new HashSet();
        this.mResumed = hashSet;
        this.mMetrics = hashSet;
        hashSet = new HashSet(0);
        this.mTsnsCount = hashSet;
        hashSet = ApplicationProcessState.BACKGROUND;
        this.mCurrentState = hashSet;
        this.mClients = hashSet = new HashSet();
        this.hasFrameMetricsAggregator = false;
        this.mActivity2ScreenTrace = weakHashMap = new WeakHashMap();
        this.transportManager = object;
        this.mClock = clock;
        this.mConfigResolver = object = ConfigResolver.getInstance();
        this.hasFrameMetricsAggregator = bl2 = this.hasFrameMetricsAggregatorClass();
        if (bl2) {
            this.mFrameMetricsAggregator = object = new FrameMetricsAggregator();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AppStateMonitor getInstance() {
        Object object = sInstance;
        if (object != null) return sInstance;
        object = AppStateMonitor.class;
        synchronized (object) {
            AppStateMonitor appStateMonitor = sInstance;
            if (appStateMonitor != null) return sInstance;
            TransportManager transportManager = TransportManager.getInstance();
            Clock clock = new Clock();
            sInstance = appStateMonitor = new AppStateMonitor(transportManager, clock);
            return sInstance;
        }
    }

    public static String getScreenTraceName(Activity object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_st_");
        object = object.getClass().getSimpleName();
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    private boolean hasFrameMetricsAggregatorClass() {
        String string2 = FRAME_METRICS_AGGREGATOR_CLASSNAME;
        try {
            Class.forName(string2);
            return true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isScreenTraceSupported(Activity activity) {
        int n10 = this.hasFrameMetricsAggregator;
        if (n10 == 0) return 0 != 0;
        Window window = activity.getWindow();
        if (window == null) return 0 != 0;
        activity = activity.getWindow().getAttributes();
        int n11 = activity.flags;
        n10 = 0x1000000;
        if ((n11 &= n10) == 0) return 0 != 0;
        return 1 != 0;
    }

    private void sendScreenTrace(Activity object) {
        boolean bl2;
        long l10;
        int n10;
        int n11;
        int n12;
        StringBuilder stringBuilder;
        Object object2 = this.mActivity2ScreenTrace;
        boolean bl3 = ((WeakHashMap)object2).containsKey(object);
        if (!bl3) {
            return;
        }
        object2 = (Trace)this.mActivity2ScreenTrace.get(object);
        if (object2 == null) {
            return;
        }
        this.mActivity2ScreenTrace.remove(object);
        Object object3 = this.mFrameMetricsAggregator.remove((Activity)object);
        if (object3 != null && (object3 = object3[0]) != null) {
            int n13;
            int n14 = 0;
            stringBuilder = null;
            n12 = 0;
            n11 = 0;
            for (n10 = 0; n10 < (n13 = object3.size()); ++n10) {
                n13 = object3.keyAt(n10);
                int n15 = object3.valueAt(n10);
                n14 += n15;
                int n16 = 700;
                if (n13 > n16) {
                    n11 += n15;
                }
                if (n13 <= (n16 = 16)) continue;
                n12 += n15;
            }
            n10 = n14;
        } else {
            n12 = 0;
            n11 = 0;
        }
        if (n10 > 0) {
            object3 = Constants$CounterNames.FRAMES_TOTAL.toString();
            l10 = n10;
            ((Trace)object2).putMetric((String)object3, l10);
        }
        if (n12 > 0) {
            object3 = Constants$CounterNames.FRAMES_SLOW.toString();
            l10 = n12;
            ((Trace)object2).putMetric((String)object3, l10);
        }
        if (n11 > 0) {
            object3 = Constants$CounterNames.FRAMES_FROZEN.toString();
            l10 = n11;
            ((Trace)object2).putMetric((String)object3, l10);
        }
        if (bl2 = Utils.isDebugLoggingEnabled((Context)(object3 = object.getApplicationContext()))) {
            object3 = logger;
            stringBuilder = new StringBuilder();
            String string2 = "sendScreenTrace name:";
            stringBuilder.append(string2);
            object = AppStateMonitor.getScreenTraceName(object);
            stringBuilder.append((String)object);
            stringBuilder.append(" _fr_tot:");
            stringBuilder.append(n10);
            stringBuilder.append(" _fr_slo:");
            stringBuilder.append(n12);
            stringBuilder.append(" _fr_fzn:");
            stringBuilder.append(n11);
            object = stringBuilder.toString();
            ((AndroidLogger)object3).debug((String)object);
        }
        ((Trace)object2).stop();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void sendSessionLog(String object, Timer object2, Timer object3) {
        Object object4 = this.mConfigResolver;
        boolean bl2 = ((ConfigResolver)object4).isPerformanceMonitoringEnabled();
        if (!bl2) {
            return;
        }
        object4 = TraceMetric.newBuilder();
        object = ((TraceMetric$Builder)object4).setName((String)object);
        long l10 = ((Timer)object2).getMicros();
        object = ((TraceMetric$Builder)object).setClientStartTimeUs(l10);
        long l11 = ((Timer)object2).getDurationMicros((Timer)object3);
        object = ((TraceMetric$Builder)object).setDurationUs(l11);
        object2 = SessionManager.getInstance().perfSession().build();
        object = ((TraceMetric$Builder)object).addPerfSessions((PerfSession)object2);
        object2 = this.mTsnsCount;
        int n10 = ((AtomicInteger)object2).getAndSet(0);
        object3 = this.mMetrics;
        synchronized (object3) {
            object4 = this.mMetrics;
            ((TraceMetric$Builder)object).putAllCounters((Map)object4);
            if (n10 != 0) {
                object4 = Constants$CounterNames.TRACE_STARTED_NOT_STOPPED;
                object4 = ((Constants$CounterNames)((Object)object4)).toString();
                long l12 = n10;
                ((TraceMetric$Builder)object).putCounters((String)object4, l12);
            }
            object2 = this.mMetrics;
            object2.clear();
        }
        object2 = this.transportManager;
        object = (TraceMetric)((GeneratedMessageLite$Builder)object).build();
        object3 = ApplicationProcessState.FOREGROUND_BACKGROUND;
        ((TransportManager)object2).log((TraceMetric)object, (ApplicationProcessState)object3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void updateAppState(ApplicationProcessState object) {
        this.mCurrentState = object;
        object = this.mClients;
        synchronized (object) {
            Object object2 = this.mClients;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                object3 = (WeakReference)object3;
                object3 = ((Reference)object3).get();
                if ((object3 = (AppStateMonitor$AppStateCallback)object3) != null) {
                    ApplicationProcessState applicationProcessState = this.mCurrentState;
                    object3.onUpdateAppState(applicationProcessState);
                    continue;
                }
                object2.remove();
            }
            return;
        }
    }

    public WeakHashMap getActivity2ScreenTrace() {
        return this.mActivity2ScreenTrace;
    }

    public ApplicationProcessState getAppState() {
        return this.mCurrentState;
    }

    public Timer getPauseTime() {
        return this.mStopTime;
    }

    public Timer getResumeTime() {
        return this.mResumeTime;
    }

    public WeakHashMap getResumed() {
        return this.mResumed;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void incrementCount(String string2, long l10) {
        Map map = this.mMetrics;
        synchronized (map) {
            Object object = this.mMetrics;
            object = object.get(string2);
            object = (Long)object;
            if (object == null) {
                object = this.mMetrics;
                Long l11 = l10;
                object.put(string2, l11);
            } else {
                Map map2 = this.mMetrics;
                long l12 = (Long)object + l10;
                Long l13 = l12;
                map2.put(string2, l13);
            }
            return;
        }
    }

    public void incrementTsnsCount(int n10) {
        this.mTsnsCount.addAndGet(n10);
    }

    public boolean isColdStart() {
        return this.mIsColdStart;
    }

    public boolean isForeground() {
        boolean bl2;
        ApplicationProcessState applicationProcessState = this.mCurrentState;
        ApplicationProcessState applicationProcessState2 = ApplicationProcessState.FOREGROUND;
        if (applicationProcessState == applicationProcessState2) {
            bl2 = true;
        } else {
            bl2 = false;
            applicationProcessState = null;
        }
        return bl2;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
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
        Object object2 = Boolean.TRUE;
        synchronized (this) {
            Object object3 = this.mResumed;
            boolean bl2 = ((WeakHashMap)object3).isEmpty();
            if (bl2) {
                object3 = this.mClock;
                this.mResumeTime = object3 = ((Clock)object3).getTime();
                object3 = this.mResumed;
                ((WeakHashMap)object3).put(object, object2);
                object = ApplicationProcessState.FOREGROUND;
                this.updateAppState((ApplicationProcessState)object);
                boolean bl3 = this.mIsColdStart;
                if (bl3) {
                    bl3 = false;
                    object = null;
                    this.mIsColdStart = false;
                } else {
                    object = Constants$TraceNames.BACKGROUND_TRACE_NAME;
                    object = ((Constants$TraceNames)((Object)object)).toString();
                    object2 = this.mStopTime;
                    object3 = this.mResumeTime;
                    this.sendSessionLog((String)object, (Timer)object2, (Timer)object3);
                }
            } else {
                object3 = this.mResumed;
                ((WeakHashMap)object3).put(object, object2);
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
    public void onActivityStarted(Activity activity) {
        synchronized (this) {
            Object object;
            boolean bl2 = this.isScreenTraceSupported(activity);
            if (bl2 && (bl2 = ((ConfigResolver)(object = this.mConfigResolver)).isPerformanceMonitoringEnabled())) {
                object = this.mFrameMetricsAggregator;
                ((FrameMetricsAggregator)object).add(activity);
                Object object2 = AppStateMonitor.getScreenTraceName(activity);
                TransportManager transportManager = this.transportManager;
                Clock clock = this.mClock;
                object = new Trace((String)object2, transportManager, clock, this);
                ((Trace)object).start();
                object2 = this.mActivity2ScreenTrace;
                ((WeakHashMap)object2).put(activity, object);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onActivityStopped(Activity object) {
        synchronized (this) {
            Object object2;
            boolean bl2 = this.isScreenTraceSupported((Activity)object);
            if (bl2) {
                this.sendScreenTrace((Activity)object);
            }
            if (bl2 = ((WeakHashMap)(object2 = this.mResumed)).containsKey(object)) {
                object2 = this.mResumed;
                ((WeakHashMap)object2).remove(object);
                object = this.mResumed;
                boolean bl3 = ((WeakHashMap)object).isEmpty();
                if (bl3) {
                    object = this.mClock;
                    this.mStopTime = object = ((Clock)object).getTime();
                    object = ApplicationProcessState.BACKGROUND;
                    this.updateAppState((ApplicationProcessState)object);
                    object = Constants$TraceNames.FOREGROUND_TRACE_NAME;
                    object = ((Constants$TraceNames)((Object)object)).toString();
                    object2 = this.mResumeTime;
                    Timer timer = this.mStopTime;
                    this.sendSessionLog((String)object, (Timer)object2, timer);
                }
            }
            return;
        }
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
                boolean bl3;
                context = (Application)context;
                context.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
                this.mRegistered = bl3 = true;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerForAppState(WeakReference weakReference) {
        Set set = this.mClients;
        synchronized (set) {
            Set set2 = this.mClients;
            set2.add(weakReference);
            return;
        }
    }

    public void setIsColdStart(boolean bl2) {
        this.mIsColdStart = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregisterActivityLifecycleCallbacks(Context context) {
        synchronized (this) {
            boolean bl2 = this.mRegistered;
            if (!bl2) {
                return;
            }
            bl2 = (context = context.getApplicationContext()) instanceof Application;
            if (bl2) {
                context = (Application)context;
                context.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
                context = null;
                this.mRegistered = false;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregisterForAppState(WeakReference weakReference) {
        Set set = this.mClients;
        synchronized (set) {
            Set set2 = this.mClients;
            set2.remove(weakReference);
            return;
        }
    }
}

