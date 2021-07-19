/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.gauges;

import com.google.firebase.perf.gauges.MemoryGaugeCollector$$Lambda$1;
import com.google.firebase.perf.gauges.MemoryGaugeCollector$$Lambda$4;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.AndroidMemoryReading;
import com.google.firebase.perf.v1.AndroidMemoryReading$Builder;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MemoryGaugeCollector {
    public static final long INVALID_MEMORY_COLLECTION_FREQUENCY = 255L;
    private static final int UNSET_MEMORY_METRIC_COLLECTION_RATE = 255;
    private static final AndroidLogger logger;
    private static final MemoryGaugeCollector sharedInstance;
    private long memoryMetricCollectionRateMs;
    private final ScheduledExecutorService memoryMetricCollectorExecutor;
    private ScheduledFuture memoryMetricCollectorJob;
    public final ConcurrentLinkedQueue memoryMetricReadings;
    private final Runtime runtime;

    static {
        MemoryGaugeCollector memoryGaugeCollector;
        logger = AndroidLogger.getInstance();
        sharedInstance = memoryGaugeCollector = new MemoryGaugeCollector();
    }

    private MemoryGaugeCollector() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Runtime runtime = Runtime.getRuntime();
        this(scheduledExecutorService, runtime);
    }

    public MemoryGaugeCollector(ScheduledExecutorService concurrentLinkedQueue, Runtime runtime) {
        this.memoryMetricCollectorJob = null;
        this.memoryMetricCollectionRateMs = -1;
        this.memoryMetricCollectorExecutor = concurrentLinkedQueue;
        this.memoryMetricReadings = concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.runtime = runtime;
    }

    private int getCurrentUsedAppJavaHeapMemoryKb() {
        StorageUnit storageUnit = StorageUnit.BYTES;
        long l10 = this.runtime.totalMemory();
        long l11 = this.runtime.freeMemory();
        return Utils.saturatedIntCast(storageUnit.toKilobytes(l10 -= l11));
    }

    public static MemoryGaugeCollector getInstance() {
        return sharedInstance;
    }

    public static boolean isInvalidCollectionFrequency(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object <= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public static /* synthetic */ void lambda$scheduleMemoryMetricCollectionOnce$1(MemoryGaugeCollector object, Timer object2) {
        if ((object2 = ((MemoryGaugeCollector)object).syncCollectMemoryMetric((Timer)object2)) != null) {
            object = ((MemoryGaugeCollector)object).memoryMetricReadings;
            ((ConcurrentLinkedQueue)object).add(object2);
        }
    }

    public static /* synthetic */ void lambda$scheduleMemoryMetricCollectionWithRate$0(MemoryGaugeCollector object, Timer object2) {
        if ((object2 = ((MemoryGaugeCollector)object).syncCollectMemoryMetric((Timer)object2)) != null) {
            object = ((MemoryGaugeCollector)object).memoryMetricReadings;
            ((ConcurrentLinkedQueue)object).add(object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void scheduleMemoryMetricCollectionOnce(Timer object) {
        synchronized (this) {
            Throwable throwable2;
            block5: {
                try {
                    try {
                        ScheduledExecutorService scheduledExecutorService = this.memoryMetricCollectorExecutor;
                        object = MemoryGaugeCollector$$Lambda$4.lambdaFactory$(this, (Timer)object);
                        long l10 = 0L;
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        scheduledExecutorService.schedule((Runnable)object, l10, timeUnit);
                    }
                    catch (RejectedExecutionException rejectedExecutionException) {
                        AndroidLogger androidLogger = logger;
                        StringBuilder stringBuilder = new StringBuilder();
                        String string2 = "Unable to collect Memory Metric: ";
                        stringBuilder.append(string2);
                        String string3 = rejectedExecutionException.getMessage();
                        stringBuilder.append(string3);
                        string3 = stringBuilder.toString();
                        androidLogger.warn(string3);
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void scheduleMemoryMetricCollectionWithRate(long l10, Timer object) {
        synchronized (this) {
            Object object2;
            Object object3;
            this.memoryMetricCollectionRateMs = l10;
            try {
                object3 = this.memoryMetricCollectorExecutor;
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                AndroidLogger androidLogger = logger;
                object = new StringBuilder();
                object3 = "Unable to start collecting Memory Metrics: ";
                ((StringBuilder)object).append((String)object3);
                object2 = rejectedExecutionException.getMessage();
                ((StringBuilder)object).append((String)object2);
                object2 = ((StringBuilder)object).toString();
                androidLogger.warn((String)object2);
                return;
            }
            Runnable runnable = MemoryGaugeCollector$$Lambda$1.lambdaFactory$(this, (Timer)object);
            long l11 = 0L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.memoryMetricCollectorJob = object2 = object3.scheduleAtFixedRate(runnable, l11, l10, timeUnit);
            return;
        }
    }

    private AndroidMemoryReading syncCollectMemoryMetric(Timer object) {
        if (object == null) {
            return null;
        }
        long l10 = ((Timer)object).getCurrentTimestampMicros();
        object = AndroidMemoryReading.newBuilder().setClientTimeUs(l10);
        int n10 = this.getCurrentUsedAppJavaHeapMemoryKb();
        return (AndroidMemoryReading)((AndroidMemoryReading$Builder)object).setUsedAppJavaHeapMemoryKb(n10).build();
    }

    public void collectOnce(Timer timer) {
        this.scheduleMemoryMetricCollectionOnce(timer);
    }

    public void startCollecting(long l10, Timer timer) {
        Object object = MemoryGaugeCollector.isInvalidCollectionFrequency(l10);
        if (object) {
            return;
        }
        ScheduledFuture scheduledFuture = this.memoryMetricCollectorJob;
        if (scheduledFuture != null) {
            long l11 = this.memoryMetricCollectionRateMs;
            long l12 = l11 - l10;
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object) {
                this.stopCollecting();
                this.scheduleMemoryMetricCollectionWithRate(l10, timer);
            }
            return;
        }
        this.scheduleMemoryMetricCollectionWithRate(l10, timer);
    }

    public void stopCollecting() {
        ScheduledFuture scheduledFuture = this.memoryMetricCollectorJob;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.memoryMetricCollectorJob = null;
        this.memoryMetricCollectionRateMs = -1;
    }
}

