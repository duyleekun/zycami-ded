/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 */
package com.google.firebase.perf.transport;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.AppStateMonitor$AppStateCallback;
import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.transport.FlgTransport;
import com.google.firebase.perf.transport.PendingPerfEvent;
import com.google.firebase.perf.transport.RateLimiter;
import com.google.firebase.perf.transport.TransportManager$$Lambda$1;
import com.google.firebase.perf.transport.TransportManager$$Lambda$2;
import com.google.firebase.perf.transport.TransportManager$$Lambda$3;
import com.google.firebase.perf.transport.TransportManager$$Lambda$4;
import com.google.firebase.perf.transport.TransportManager$$Lambda$5;
import com.google.firebase.perf.transport.TransportManager$$Lambda$6;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.AndroidApplicationInfo$Builder;
import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo$Builder;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfMetric$Builder;
import com.google.firebase.perf.v1.PerfMetricOrBuilder;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public class TransportManager
implements AppStateMonitor$AppStateCallback {
    private static final int CORE_POOL_SIZE = 0;
    private static final String KEY_AVAILABLE_GAUGES_FOR_CACHING = "KEY_AVAILABLE_GAUGES_FOR_CACHING";
    private static final String KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING = "KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING";
    private static final String KEY_AVAILABLE_TRACES_FOR_CACHING = "KEY_AVAILABLE_TRACES_FOR_CACHING";
    private static final int MAX_GAUGE_METRICS_CACHE_SIZE = 50;
    private static final int MAX_NETWORK_REQUEST_METRICS_CACHE_SIZE = 50;
    private static final int MAX_POOL_SIZE = 1;
    private static final int MAX_TRACE_METRICS_CACHE_SIZE = 50;
    private static final TransportManager instance;
    private static final AndroidLogger logger;
    private Context appContext;
    private AppStateMonitor appStateMonitor;
    private final ApplicationInfo$Builder applicationInfoBuilder;
    private final Map cacheMap;
    private ConfigResolver configResolver;
    private ExecutorService executorService;
    private FirebaseApp firebaseApp;
    private FirebaseInstallationsApi firebaseInstallationsApi;
    private FirebasePerformance firebasePerformance;
    private FlgTransport flgTransport;
    private Provider flgTransportFactoryProvider;
    private boolean isForegroundState;
    private final AtomicBoolean isTransportInitialized;
    private final ConcurrentLinkedQueue pendingEventsQueue;
    private RateLimiter rateLimiter;

    static {
        TransportManager transportManager;
        logger = AndroidLogger.getInstance();
        instance = transportManager = new TransportManager();
    }

    private TransportManager() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(false);
        this.isTransportInitialized = concurrentHashMap;
        this.isForegroundState = false;
        this.pendingEventsQueue = concurrentHashMap;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        Serializable serializable = concurrentHashMap;
        concurrentHashMap = new ConcurrentHashMap(0, 1, 10, timeUnit, linkedBlockingQueue);
        this.executorService = concurrentHashMap;
        concurrentHashMap = ApplicationInfo.newBuilder();
        this.applicationInfoBuilder = concurrentHashMap;
        this.cacheMap = concurrentHashMap = new ConcurrentHashMap();
        serializable = 50;
        concurrentHashMap.put(KEY_AVAILABLE_TRACES_FOR_CACHING, serializable);
        concurrentHashMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, serializable);
        concurrentHashMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, serializable);
    }

    public static /* synthetic */ void access$lambda$0(TransportManager transportManager) {
        transportManager.syncInit();
    }

    private void dispatchLog(PerfMetric perfMetric) {
        AndroidLogger androidLogger = logger;
        Object[] objectArray = new Object[1];
        String string2 = TransportManager.getLogcatMsg(perfMetric);
        objectArray[0] = string2;
        androidLogger.info("Logging %s", objectArray);
        this.flgTransport.log(perfMetric);
    }

    private void finishInitialization() {
        boolean bl2;
        Object object = this.appStateMonitor;
        Object object2 = instance;
        Object object3 = new WeakReference(object2);
        ((AppStateMonitor)object).registerForAppState((WeakReference)object3);
        object = this.applicationInfoBuilder;
        object3 = this.firebaseApp.getOptions().getApplicationId();
        object = ((ApplicationInfo$Builder)object).setGoogleAppId((String)object3);
        object3 = AndroidApplicationInfo.newBuilder();
        object2 = this.appContext.getPackageName();
        object3 = ((AndroidApplicationInfo$Builder)object3).setPackageName((String)object2);
        object2 = BuildConfig.FIREPERF_VERSION_NAME;
        object3 = ((AndroidApplicationInfo$Builder)object3).setSdkVersion((String)object2);
        object2 = TransportManager.getVersionName(this.appContext);
        object3 = ((AndroidApplicationInfo$Builder)object3).setVersionName((String)object2);
        ((ApplicationInfo$Builder)object).setAndroidAppInfo((AndroidApplicationInfo$Builder)object3);
        object = this.isTransportInitialized;
        boolean bl3 = true;
        ((AtomicBoolean)object).set(bl3);
        while (!(bl2 = ((ConcurrentLinkedQueue)(object = this.pendingEventsQueue)).isEmpty())) {
            object = (PendingPerfEvent)this.pendingEventsQueue.poll();
            if (object == null) continue;
            object3 = this.executorService;
            object = TransportManager$$Lambda$2.lambdaFactory$(this, (PendingPerfEvent)object);
            object3.execute((Runnable)object);
        }
    }

    private Map getGlobalCustomAttributes() {
        this.updateFirebasePerformanceIfPossibleAndNeeded();
        Map map = this.firebasePerformance;
        map = map != null ? ((FirebasePerformance)((Object)map)).getAttributes() : Collections.emptyMap();
        return map;
    }

    public static TransportManager getInstance() {
        return instance;
    }

    private static String getLogcatMsg(GaugeMetric object) {
        Locale locale = Locale.ENGLISH;
        Object[] objectArray = new Object[3];
        Comparable<Boolean> comparable = ((GaugeMetric)object).hasGaugeMetadata();
        objectArray[0] = comparable;
        comparable = ((GaugeMetric)object).getCpuMetricReadingsCount();
        objectArray[1] = comparable;
        objectArray[2] = object = Integer.valueOf(((GaugeMetric)object).getAndroidMemoryReadingsCount());
        return String.format(locale, "gauges (hasMetadata: %b, cpuGaugeCount: %d, memoryGaugeCount: %d)", objectArray);
    }

    private static String getLogcatMsg(NetworkRequestMetric object) {
        String string2;
        boolean bl2 = ((NetworkRequestMetric)object).hasTimeToResponseCompletedUs();
        long l10 = bl2 ? ((NetworkRequestMetric)object).getTimeToResponseCompletedUs() : 0L;
        boolean n10 = ((NetworkRequestMetric)object).hasHttpResponseCode();
        if (n10) {
            int n11 = ((NetworkRequestMetric)object).getHttpResponseCode();
            string2 = String.valueOf(n11);
        } else {
            string2 = "UNKNOWN";
        }
        Locale locale = Locale.ENGLISH;
        Object[] objectArray = new Object[3];
        objectArray[0] = object = ((NetworkRequestMetric)object).getUrl();
        objectArray[1] = string2;
        Double d10 = (double)l10 / 1000.0;
        objectArray[2] = d10;
        return String.format(locale, "network request trace: %s (responseCode: %s, responseTime: %.4fms)", objectArray);
    }

    private static String getLogcatMsg(PerfMetricOrBuilder perfMetricOrBuilder) {
        boolean bl2 = perfMetricOrBuilder.hasTraceMetric();
        if (bl2) {
            return TransportManager.getLogcatMsg(perfMetricOrBuilder.getTraceMetric());
        }
        bl2 = perfMetricOrBuilder.hasNetworkRequestMetric();
        if (bl2) {
            return TransportManager.getLogcatMsg(perfMetricOrBuilder.getNetworkRequestMetric());
        }
        bl2 = perfMetricOrBuilder.hasGaugeMetric();
        if (bl2) {
            return TransportManager.getLogcatMsg(perfMetricOrBuilder.getGaugeMetric());
        }
        return "log";
    }

    private static String getLogcatMsg(TraceMetric object) {
        long l10 = ((TraceMetric)object).getDurationUs();
        Locale locale = Locale.ENGLISH;
        Object[] objectArray = new Object[]{object = ((TraceMetric)object).getName(), object = Double.valueOf((double)l10 / 1000.0)};
        return String.format(locale, "trace metric: %s (duration: %.4fms)", objectArray);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String getVersionName(Context object) {
        PackageManager packageManager;
        String string2 = "";
        try {
            packageManager = object.getPackageManager();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return string2;
        }
        String string3 = object.getPackageName();
        PackageInfo packageInfo = packageManager.getPackageInfo(string3, 0);
        String string4 = packageInfo.versionName;
        if (string4 != null) return string4;
        return string2;
    }

    private void incrementDropCount(PerfMetric object) {
        boolean bl2 = ((PerfMetric)object).hasTraceMetric();
        long l10 = 1L;
        if (bl2) {
            object = this.appStateMonitor;
            String string2 = Constants$CounterNames.TRACE_EVENT_RATE_LIMITED.toString();
            ((AppStateMonitor)object).incrementCount(string2, l10);
        } else {
            boolean bl3 = ((PerfMetric)object).hasNetworkRequestMetric();
            if (bl3) {
                object = this.appStateMonitor;
                String string3 = Constants$CounterNames.NETWORK_TRACE_EVENT_RATE_LIMITED.toString();
                ((AppStateMonitor)object).incrementCount(string3, l10);
            }
        }
    }

    private boolean isAllowedToCache(PerfMetricOrBuilder object) {
        Object object2 = this.cacheMap;
        Object object3 = KEY_AVAILABLE_TRACES_FOR_CACHING;
        object2 = (Integer)object2.get(object3);
        int n10 = (Integer)object2;
        Object object4 = this.cacheMap;
        Object[] objectArray = "KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING";
        object4 = (Integer)object4.get(objectArray);
        int n11 = (Integer)object4;
        Object object5 = this.cacheMap;
        String string2 = KEY_AVAILABLE_GAUGES_FOR_CACHING;
        object5 = (Integer)object5.get(string2);
        int n12 = (Integer)object5;
        boolean bl2 = object.hasTraceMetric();
        int n13 = 1;
        if (bl2 && n10 > 0) {
            object = this.cacheMap;
            object2 = n10 - n13;
            object.put(object3, object2);
            return n13 != 0;
        }
        boolean bl3 = object.hasNetworkRequestMetric();
        if (bl3 && n11 > 0) {
            object = this.cacheMap;
            object2 = n11 - n13;
            object.put(objectArray, object2);
            return n13 != 0;
        }
        bl3 = object.hasGaugeMetric();
        if (bl3 && n12 > 0) {
            object = this.cacheMap;
            object2 = n12 - n13;
            object.put(string2, object2);
            return n13 != 0;
        }
        object3 = logger;
        objectArray = new Object[4];
        objectArray[0] = object = TransportManager.getLogcatMsg((PerfMetricOrBuilder)object);
        objectArray[n13] = object = Integer.valueOf(n10);
        objectArray[2] = object2 = Integer.valueOf(n11);
        objectArray[3] = object2 = Integer.valueOf(n12);
        ((AndroidLogger)object3).debug("%s is not allowed to cache. Cache exhausted the limit (availableTracesForCaching: %d, availableNetworkRequestsForCaching: %d, availableGaugesForCaching: %d).", objectArray);
        return false;
    }

    private boolean isAllowedToDispatch(PerfMetric object) {
        Object object2 = this.configResolver;
        boolean bl2 = ((ConfigResolver)object2).isPerformanceMonitoringEnabled();
        int n10 = 1;
        if (!bl2) {
            object2 = logger;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = TransportManager.getLogcatMsg((PerfMetricOrBuilder)object);
            ((AndroidLogger)object2).info("Performance collection is not enabled, dropping %s", objectArray);
            return false;
        }
        object2 = ((PerfMetric)object).getApplicationInfo();
        bl2 = ((ApplicationInfo)object2).hasAppInstanceId();
        if (!bl2) {
            object2 = logger;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = TransportManager.getLogcatMsg((PerfMetricOrBuilder)object);
            ((AndroidLogger)object2).warn("App Instance ID is null or empty, dropping %s", objectArray);
            return false;
        }
        object2 = this.appContext;
        bl2 = PerfMetricValidator.isValid((PerfMetric)object, (Context)object2);
        if (!bl2) {
            object2 = logger;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = TransportManager.getLogcatMsg((PerfMetricOrBuilder)object);
            ((AndroidLogger)object2).warn("Unable to process the PerfMetric (%s) due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values.", objectArray);
            return false;
        }
        object2 = this.rateLimiter;
        bl2 = ((RateLimiter)object2).check((PerfMetric)object);
        if (!bl2) {
            this.incrementDropCount((PerfMetric)object);
            bl2 = ((PerfMetric)object).hasTraceMetric();
            String string2 = "Rate Limited - %s";
            if (bl2) {
                object2 = logger;
                Object[] objectArray = new Object[n10];
                objectArray[0] = object = TransportManager.getLogcatMsg(((PerfMetric)object).getTraceMetric());
                ((AndroidLogger)object2).info(string2, objectArray);
            } else {
                bl2 = ((PerfMetric)object).hasNetworkRequestMetric();
                if (bl2) {
                    object2 = logger;
                    Object[] objectArray = new Object[n10];
                    objectArray[0] = object = TransportManager.getLogcatMsg(((PerfMetric)object).getNetworkRequestMetric());
                    ((AndroidLogger)object2).info(string2, objectArray);
                }
            }
            return false;
        }
        return n10 != 0;
    }

    public static /* synthetic */ void lambda$finishInitialization$0(TransportManager transportManager, PendingPerfEvent object) {
        PerfMetric$Builder perfMetric$Builder = ((PendingPerfEvent)object).perfMetricBuilder;
        object = ((PendingPerfEvent)object).appState;
        transportManager.syncLog(perfMetric$Builder, (ApplicationProcessState)object);
    }

    public static /* synthetic */ void lambda$log$2(TransportManager transportManager, TraceMetric messageLiteOrBuilder, ApplicationProcessState applicationProcessState) {
        messageLiteOrBuilder = PerfMetric.newBuilder().setTraceMetric((TraceMetric)messageLiteOrBuilder);
        transportManager.syncLog((PerfMetric$Builder)messageLiteOrBuilder, applicationProcessState);
    }

    public static /* synthetic */ void lambda$log$3(TransportManager transportManager, NetworkRequestMetric messageLiteOrBuilder, ApplicationProcessState applicationProcessState) {
        messageLiteOrBuilder = PerfMetric.newBuilder().setNetworkRequestMetric((NetworkRequestMetric)messageLiteOrBuilder);
        transportManager.syncLog((PerfMetric$Builder)messageLiteOrBuilder, applicationProcessState);
    }

    public static /* synthetic */ void lambda$log$4(TransportManager transportManager, GaugeMetric messageLiteOrBuilder, ApplicationProcessState applicationProcessState) {
        messageLiteOrBuilder = PerfMetric.newBuilder().setGaugeMetric((GaugeMetric)messageLiteOrBuilder);
        transportManager.syncLog((PerfMetric$Builder)messageLiteOrBuilder, applicationProcessState);
    }

    public static /* synthetic */ void lambda$onUpdateAppState$1(TransportManager transportManager) {
        RateLimiter rateLimiter = transportManager.rateLimiter;
        boolean bl2 = transportManager.isForegroundState;
        rateLimiter.changeRate(bl2);
    }

    private PerfMetric setApplicationInfoAndBuild(PerfMetric$Builder perfMetric$Builder, ApplicationProcessState object) {
        this.updateFirebaseInstallationIdIfPossibleAndNeeded();
        Object object2 = this.applicationInfoBuilder;
        object = ((ApplicationInfo$Builder)object2).setApplicationProcessState((ApplicationProcessState)object);
        boolean bl2 = perfMetric$Builder.hasTraceMetric();
        if (bl2) {
            object = (ApplicationInfo$Builder)((GeneratedMessageLite$Builder)object).clone();
            object2 = this.getGlobalCustomAttributes();
            object = ((ApplicationInfo$Builder)object).putAllCustomAttributes((Map)object2);
        }
        return (PerfMetric)perfMetric$Builder.setApplicationInfo((ApplicationInfo$Builder)object).build();
    }

    private void syncInit() {
        Object object;
        this.appContext = object = this.firebaseApp.getApplicationContext();
        object = ConfigResolver.getInstance();
        this.configResolver = object;
        Object object2 = this.appContext;
        Object object3 = object;
        object = new RateLimiter((Context)object2, 100.0, 500L);
        this.rateLimiter = object;
        object = AppStateMonitor.getInstance();
        this.appStateMonitor = object;
        object3 = this.flgTransportFactoryProvider;
        object2 = this.configResolver.getAndCacheLogSourceName();
        object = new FlgTransport((Provider)object3, (String)object2);
        this.flgTransport = object;
        this.finishInitialization();
    }

    private void syncLog(PerfMetric$Builder object, ApplicationProcessState applicationProcessState) {
        boolean bl2 = this.isInitialized();
        if (!bl2) {
            bl2 = this.isAllowedToCache((PerfMetricOrBuilder)object);
            if (bl2) {
                Object object2 = logger;
                int n10 = 1;
                Object object3 = new Object[n10];
                String string2 = TransportManager.getLogcatMsg((PerfMetricOrBuilder)object);
                object3[0] = string2;
                String string3 = "Transport is not initialized yet, %s will be queued for to be dispatched later";
                ((AndroidLogger)object2).debug(string3, object3);
                object2 = this.pendingEventsQueue;
                object3 = new PendingPerfEvent((PerfMetric$Builder)object, applicationProcessState);
                ((ConcurrentLinkedQueue)object2).add(object3);
            }
            return;
        }
        boolean bl3 = this.isAllowedToDispatch((PerfMetric)(object = this.setApplicationInfoAndBuild((PerfMetric$Builder)object, applicationProcessState)));
        if (bl3) {
            this.dispatchLog((PerfMetric)object);
            object = SessionManager.getInstance();
            ((SessionManager)object).updatePerfSessionIfExpired();
        }
    }

    private void updateFirebaseInstallationIdIfPossibleAndNeeded() {
        Object object = this.configResolver;
        boolean bl2 = ((ConfigResolver)object).isPerformanceMonitoringEnabled();
        if (bl2) {
            object = this.applicationInfoBuilder;
            bl2 = ((ApplicationInfo$Builder)object).hasAppInstanceId();
            if (bl2 && !(bl2 = this.isForegroundState)) {
                return;
            }
            bl2 = false;
            object = null;
            boolean bl3 = false;
            Object object2 = null;
            int n10 = 1;
            Object object3 = this.firebaseInstallationsApi;
            object3 = object3.getId();
            long l10 = 60000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            object3 = Tasks.await((Task)object3, l10, timeUnit);
            try {
                object = object3 = (String)object3;
            }
            catch (TimeoutException timeoutException) {
                AndroidLogger androidLogger = logger;
                Object[] objectArray = new Object[n10];
                String string2 = timeoutException.getMessage();
                objectArray[0] = string2;
                object2 = "Task to retrieve Installation Id is timed out: %s";
                androidLogger.error((String)object2, objectArray);
            }
            catch (InterruptedException interruptedException) {
                AndroidLogger androidLogger = logger;
                Object[] objectArray = new Object[n10];
                String string3 = interruptedException.getMessage();
                objectArray[0] = string3;
                object2 = "Task to retrieve Installation Id is interrupted: %s";
                androidLogger.error((String)object2, objectArray);
            }
            catch (ExecutionException executionException) {
                AndroidLogger androidLogger = logger;
                Object[] objectArray = new Object[n10];
                String string4 = executionException.getMessage();
                objectArray[0] = string4;
                object2 = "Unable to retrieve Installation Id: %s";
                androidLogger.error((String)object2, objectArray);
            }
            bl3 = TextUtils.isEmpty((CharSequence)object);
            if (!bl3) {
                object2 = this.applicationInfoBuilder;
                ((ApplicationInfo$Builder)object2).setAppInstanceId((String)object);
            } else {
                object = logger;
                object2 = "Firebase Installation Id is empty, contact Firebase Support for debugging.";
                ((AndroidLogger)object).warn((String)object2);
            }
        }
    }

    private void updateFirebasePerformanceIfPossibleAndNeeded() {
        boolean bl2;
        FirebasePerformance firebasePerformance = this.firebasePerformance;
        if (firebasePerformance == null && (bl2 = this.isInitialized())) {
            this.firebasePerformance = firebasePerformance = FirebasePerformance.getInstance();
        }
    }

    public void clearAppInstanceId() {
        this.applicationInfoBuilder.clearAppInstanceId();
    }

    public ConcurrentLinkedQueue getPendingEventsQueue() {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.pendingEventsQueue;
        ConcurrentLinkedQueue concurrentLinkedQueue2 = new ConcurrentLinkedQueue(concurrentLinkedQueue);
        return concurrentLinkedQueue2;
    }

    public void initialize(FirebaseApp object, FirebaseInstallationsApi object2, Provider provider) {
        this.firebaseApp = object;
        this.firebaseInstallationsApi = object2;
        this.flgTransportFactoryProvider = provider;
        object = this.executorService;
        object2 = TransportManager$$Lambda$1.lambdaFactory$(this);
        object.execute((Runnable)object2);
    }

    public void initializeForTest(FirebaseApp object, FirebasePerformance object2, FirebaseInstallationsApi firebaseInstallationsApi, Provider provider, ConfigResolver configResolver, RateLimiter rateLimiter, AppStateMonitor appStateMonitor, FlgTransport flgTransport, ExecutorService executorService) {
        this.firebaseApp = object;
        object = ((FirebaseApp)object).getApplicationContext();
        this.appContext = object;
        this.firebasePerformance = object2;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.flgTransportFactoryProvider = provider;
        this.configResolver = configResolver;
        this.rateLimiter = rateLimiter;
        this.appStateMonitor = appStateMonitor;
        this.flgTransport = flgTransport;
        this.executorService = executorService;
        object = this.cacheMap;
        object2 = 50;
        object.put(KEY_AVAILABLE_TRACES_FOR_CACHING, object2);
        this.cacheMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, object2);
        this.cacheMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, object2);
        this.finishInitialization();
    }

    public boolean isInitialized() {
        return this.isTransportInitialized.get();
    }

    public void log(GaugeMetric gaugeMetric) {
        ApplicationProcessState applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.log(gaugeMetric, applicationProcessState);
    }

    public void log(GaugeMetric object, ApplicationProcessState applicationProcessState) {
        ExecutorService executorService = this.executorService;
        object = TransportManager$$Lambda$6.lambdaFactory$(this, (GaugeMetric)object, applicationProcessState);
        executorService.execute((Runnable)object);
    }

    public void log(NetworkRequestMetric networkRequestMetric) {
        ApplicationProcessState applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.log(networkRequestMetric, applicationProcessState);
    }

    public void log(NetworkRequestMetric object, ApplicationProcessState applicationProcessState) {
        ExecutorService executorService = this.executorService;
        object = TransportManager$$Lambda$5.lambdaFactory$(this, (NetworkRequestMetric)object, applicationProcessState);
        executorService.execute((Runnable)object);
    }

    public void log(TraceMetric traceMetric) {
        ApplicationProcessState applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.log(traceMetric, applicationProcessState);
    }

    public void log(TraceMetric object, ApplicationProcessState applicationProcessState) {
        ExecutorService executorService = this.executorService;
        object = TransportManager$$Lambda$4.lambdaFactory$(this, (TraceMetric)object, applicationProcessState);
        executorService.execute((Runnable)object);
    }

    public void onUpdateAppState(ApplicationProcessState object) {
        boolean bl2;
        Object object2 = ApplicationProcessState.FOREGROUND;
        if (object == object2) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        this.isForegroundState = bl2;
        bl2 = this.isInitialized();
        if (bl2) {
            object = this.executorService;
            object2 = TransportManager$$Lambda$3.lambdaFactory$(this);
            object.execute((Runnable)object2);
        }
    }

    public void setInitialized(boolean bl2) {
        this.isTransportInitialized.set(bl2);
    }
}

