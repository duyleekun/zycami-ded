/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.perf.internal;

import android.content.Context;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.gauges.CpuGaugeCollector;
import com.google.firebase.perf.gauges.MemoryGaugeCollector;
import com.google.firebase.perf.internal.GaugeManager$$Lambda$1;
import com.google.firebase.perf.internal.GaugeManager$$Lambda$2;
import com.google.firebase.perf.internal.GaugeManager$1;
import com.google.firebase.perf.internal.GaugeMetadataManager;
import com.google.firebase.perf.internal.PerfSession;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.AndroidMemoryReading;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.CpuMetricReading;
import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.GaugeMetadata$Builder;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.GaugeMetric$Builder;
import com.google.firebase.perf.v1.GaugeMetricOrBuilder;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class GaugeManager {
    private static final long APPROX_NUMBER_OF_DATA_POINTS_PER_GAUGE_METRIC = 20L;
    private static final long INVALID_GAUGE_COLLECTION_FREQUENCY = 255L;
    private static final long TIME_TO_WAIT_BEFORE_FLUSHING_GAUGES_QUEUE_MS = 20L;
    private static final AndroidLogger logger;
    private static GaugeManager sharedInstance;
    private ApplicationProcessState applicationProcessState;
    private final ConfigResolver configResolver;
    private final CpuGaugeCollector cpuGaugeCollector;
    private ScheduledFuture gaugeManagerDataCollectionJob;
    private final ScheduledExecutorService gaugeManagerExecutor;
    private GaugeMetadataManager gaugeMetadataManager;
    private final MemoryGaugeCollector memoryGaugeCollector;
    private String sessionId;
    private final TransportManager transportManager;

    static {
        GaugeManager gaugeManager;
        logger = AndroidLogger.getInstance();
        sharedInstance = gaugeManager = new GaugeManager();
    }

    private GaugeManager() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        TransportManager transportManager = TransportManager.getInstance();
        ConfigResolver configResolver = ConfigResolver.getInstance();
        CpuGaugeCollector cpuGaugeCollector = CpuGaugeCollector.getInstance();
        MemoryGaugeCollector memoryGaugeCollector = MemoryGaugeCollector.getInstance();
        this(scheduledExecutorService, transportManager, configResolver, null, cpuGaugeCollector, memoryGaugeCollector);
    }

    public GaugeManager(ScheduledExecutorService scheduledExecutorService, TransportManager transportManager, ConfigResolver configResolver, GaugeMetadataManager gaugeMetadataManager, CpuGaugeCollector cpuGaugeCollector, MemoryGaugeCollector memoryGaugeCollector) {
        ApplicationProcessState applicationProcessState;
        this.applicationProcessState = applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.sessionId = null;
        this.gaugeManagerDataCollectionJob = null;
        this.gaugeManagerExecutor = scheduledExecutorService;
        this.transportManager = transportManager;
        this.configResolver = configResolver;
        this.gaugeMetadataManager = gaugeMetadataManager;
        this.cpuGaugeCollector = cpuGaugeCollector;
        this.memoryGaugeCollector = memoryGaugeCollector;
    }

    private static void collectGaugeMetricOnce(CpuGaugeCollector cpuGaugeCollector, MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        cpuGaugeCollector.collectOnce(timer);
        memoryGaugeCollector.collectOnce(timer);
    }

    private long getCpuGaugeCollectionFrequencyMs(ApplicationProcessState object) {
        long l10;
        int[] nArray = GaugeManager$1.$SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState;
        int n10 = ((Enum)object).ordinal();
        n10 = nArray[n10];
        int n11 = 1;
        long l11 = -1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                l10 = l11;
            } else {
                object = this.configResolver;
                l10 = ((ConfigResolver)object).getSessionsCpuCaptureFrequencyForegroundMs();
            }
        } else {
            object = this.configResolver;
            l10 = ((ConfigResolver)object).getSessionsCpuCaptureFrequencyBackgroundMs();
        }
        n10 = (int)(CpuGaugeCollector.isInvalidCollectionFrequency(l10) ? 1 : 0);
        if (n10 != 0) {
            return l11;
        }
        return l10;
    }

    private GaugeMetadata getGaugeMetadata() {
        GaugeMetadata$Builder gaugeMetadata$Builder = GaugeMetadata.newBuilder();
        String string2 = this.gaugeMetadataManager.getProcessName();
        gaugeMetadata$Builder = gaugeMetadata$Builder.setProcessName(string2);
        int n10 = this.gaugeMetadataManager.getDeviceRamSizeKb();
        gaugeMetadata$Builder = gaugeMetadata$Builder.setDeviceRamSizeKb(n10);
        n10 = this.gaugeMetadataManager.getMaxAppJavaHeapMemoryKb();
        gaugeMetadata$Builder = gaugeMetadata$Builder.setMaxAppJavaHeapMemoryKb(n10);
        n10 = this.gaugeMetadataManager.getMaxEncouragedAppJavaHeapMemoryKb();
        return (GaugeMetadata)gaugeMetadata$Builder.setMaxEncouragedAppJavaHeapMemoryKb(n10).build();
    }

    public static GaugeManager getInstance() {
        Class<GaugeManager> clazz = GaugeManager.class;
        synchronized (clazz) {
            GaugeManager gaugeManager = sharedInstance;
            return gaugeManager;
        }
    }

    private long getMemoryGaugeCollectionFrequencyMs(ApplicationProcessState object) {
        long l10;
        int[] nArray = GaugeManager$1.$SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState;
        int n10 = ((Enum)object).ordinal();
        n10 = nArray[n10];
        int n11 = 1;
        long l11 = -1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                l10 = l11;
            } else {
                object = this.configResolver;
                l10 = ((ConfigResolver)object).getSessionsMemoryCaptureFrequencyForegroundMs();
            }
        } else {
            object = this.configResolver;
            l10 = ((ConfigResolver)object).getSessionsMemoryCaptureFrequencyBackgroundMs();
        }
        n10 = (int)(MemoryGaugeCollector.isInvalidCollectionFrequency(l10) ? 1 : 0);
        if (n10 != 0) {
            return l11;
        }
        return l10;
    }

    public static /* synthetic */ void lambda$startCollectingGauges$0(GaugeManager gaugeManager, String string2, ApplicationProcessState applicationProcessState) {
        gaugeManager.syncFlush(string2, applicationProcessState);
    }

    public static /* synthetic */ void lambda$stopCollectingGauges$1(GaugeManager gaugeManager, String string2, ApplicationProcessState applicationProcessState) {
        gaugeManager.syncFlush(string2, applicationProcessState);
    }

    private boolean startCollectingCpuMetrics(long l10, Timer timer) {
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            logger.debug("Invalid Cpu Metrics collection frequency. Did not collect Cpu Metrics.");
            return false;
        }
        this.cpuGaugeCollector.startCollecting(l10, timer);
        return true;
    }

    private long startCollectingGauges(ApplicationProcessState applicationProcessState, Timer timer) {
        long l10 = this.getCpuGaugeCollectionFrequencyMs(applicationProcessState);
        boolean bl2 = this.startCollectingCpuMetrics(l10, timer);
        long l11 = -1;
        if (!bl2) {
            l10 = l11;
        }
        long l12 = this.getMemoryGaugeCollectionFrequencyMs(applicationProcessState);
        Object object = this.startCollectingMemoryMetrics(l12, timer);
        if (object) {
            long l13;
            object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            l10 = !object ? l12 : (l13 = Math.min(l10, l12));
        }
        return l10;
    }

    private boolean startCollectingMemoryMetrics(long l10, Timer timer) {
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            logger.debug("Invalid Memory Metrics collection frequency. Did not collect Memory Metrics.");
            return false;
        }
        this.memoryGaugeCollector.startCollecting(l10, timer);
        return true;
    }

    private void syncFlush(String object, ApplicationProcessState applicationProcessState) {
        Object object2;
        boolean bl2;
        GaugeMetricOrBuilder gaugeMetricOrBuilder = GaugeMetric.newBuilder();
        while (!(bl2 = ((ConcurrentLinkedQueue)(object2 = this.cpuGaugeCollector.cpuMetricReadings)).isEmpty())) {
            object2 = (CpuMetricReading)this.cpuGaugeCollector.cpuMetricReadings.poll();
            gaugeMetricOrBuilder.addCpuMetricReadings((CpuMetricReading)object2);
        }
        while (!(bl2 = ((ConcurrentLinkedQueue)(object2 = this.memoryGaugeCollector.memoryMetricReadings)).isEmpty())) {
            object2 = (AndroidMemoryReading)this.memoryGaugeCollector.memoryMetricReadings.poll();
            gaugeMetricOrBuilder.addAndroidMemoryReadings((AndroidMemoryReading)object2);
        }
        gaugeMetricOrBuilder.setSessionId((String)object);
        object = this.transportManager;
        gaugeMetricOrBuilder = (GaugeMetric)gaugeMetricOrBuilder.build();
        ((TransportManager)object).log((GaugeMetric)gaugeMetricOrBuilder, applicationProcessState);
    }

    public void collectGaugeMetricOnce(Timer timer) {
        CpuGaugeCollector cpuGaugeCollector = this.cpuGaugeCollector;
        MemoryGaugeCollector memoryGaugeCollector = this.memoryGaugeCollector;
        GaugeManager.collectGaugeMetricOnce(cpuGaugeCollector, memoryGaugeCollector, timer);
    }

    public boolean logGaugeMetadata(String object, ApplicationProcessState applicationProcessState) {
        Object object2 = this.gaugeMetadataManager;
        if (object2 != null) {
            object = GaugeMetric.newBuilder().setSessionId((String)object);
            object2 = this.getGaugeMetadata();
            object = (GaugeMetric)((GaugeMetric$Builder)object).setGaugeMetadata((GaugeMetadata)object2).build();
            this.transportManager.log((GaugeMetric)object, applicationProcessState);
            return true;
        }
        return false;
    }

    public void setApplicationContext(Context context) {
        GaugeMetadataManager gaugeMetadataManager;
        this.gaugeMetadataManager = gaugeMetadataManager = new GaugeMetadataManager(context);
    }

    public void startCollectingGauges(PerfSession scheduledFuture, ApplicationProcessState object) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object2 = this.sessionId;
        if (object2 != null) {
            this.stopCollectingGauges();
        }
        if ((l13 = (l12 = (l11 = this.startCollectingGauges((ApplicationProcessState)object, (Timer)(object2 = ((PerfSession)((Object)scheduledFuture)).getTimer()))) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            logger.warn("Invalid gauge collection frequency. Unable to start collecting Gauges.");
            return;
        }
        scheduledFuture = ((PerfSession)((Object)scheduledFuture)).sessionId();
        this.sessionId = scheduledFuture;
        this.applicationProcessState = object;
        ScheduledExecutorService scheduledExecutorService = this.gaugeManagerExecutor;
        Runnable runnable = GaugeManager$$Lambda$1.lambdaFactory$(this, (String)((Object)scheduledFuture), (ApplicationProcessState)object);
        long l14 = 20;
        long l15 = l11 * l14;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(runnable, l15, l15, timeUnit);
        try {
            this.gaugeManagerDataCollectionJob = scheduledFuture;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            object = logger;
            object2 = new StringBuilder();
            String string2 = "Unable to start collecting Gauges: ";
            ((StringBuilder)object2).append(string2);
            String string3 = rejectedExecutionException.getMessage();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            ((AndroidLogger)object).warn(string3);
        }
    }

    public void stopCollectingGauges() {
        Object object = this.sessionId;
        if (object == null) {
            return;
        }
        Enum enum_ = this.applicationProcessState;
        this.cpuGaugeCollector.stopCollecting();
        this.memoryGaugeCollector.stopCollecting();
        Object object2 = this.gaugeManagerDataCollectionJob;
        if (object2 != null) {
            object2.cancel(false);
        }
        object2 = this.gaugeManagerExecutor;
        object = GaugeManager$$Lambda$2.lambdaFactory$(this, (String)object, (ApplicationProcessState)enum_);
        enum_ = TimeUnit.MILLISECONDS;
        object2.schedule((Runnable)object, (long)20, (TimeUnit)enum_);
        this.sessionId = null;
        this.applicationProcessState = object = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
    }
}

