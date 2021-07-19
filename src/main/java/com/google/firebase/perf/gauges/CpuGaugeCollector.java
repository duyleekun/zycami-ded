/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Process
 *  android.system.Os
 *  android.system.OsConstants
 */
package com.google.firebase.perf.gauges;

import android.os.Build;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.google.firebase.perf.gauges.CpuGaugeCollector$$Lambda$1;
import com.google.firebase.perf.gauges.CpuGaugeCollector$$Lambda$2;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.CpuMetricReading;
import com.google.firebase.perf.v1.CpuMetricReading$Builder;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CpuGaugeCollector {
    private static final int CSTIME_POSITION_IN_PROC_PID_STAT = 16;
    private static final int CUTIME_POSITION_IN_PROC_PID_STAT = 15;
    public static final long INVALID_CPU_COLLECTION_FREQUENCY = 255L;
    private static final int INVALID_SC_PER_CPU_CLOCK_TICK = 255;
    private static final long MICROSECONDS_PER_SECOND = 0L;
    private static final int STIME_POSITION_IN_PROC_PID_STAT = 14;
    private static final int UNSET_CPU_METRIC_COLLECTION_RATE = 255;
    private static final int UTIME_POSITION_IN_PROC_PID_STAT = 13;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static CpuGaugeCollector sharedInstance;
    private final long clockTicksPerSecond;
    private long cpuMetricCollectionRateMs = -1;
    private final ScheduledExecutorService cpuMetricCollectorExecutor;
    private ScheduledFuture cpuMetricCollectorJob = null;
    public final ConcurrentLinkedQueue cpuMetricReadings;
    private final String procFileName;

    static {
        MICROSECONDS_PER_SECOND = TimeUnit.SECONDS.toMicros(1L);
        sharedInstance = null;
    }

    private CpuGaugeCollector() {
        long l10;
        Object object = new ConcurrentLinkedQueue();
        this.cpuMetricReadings = object;
        this.cpuMetricCollectorExecutor = object = Executors.newSingleThreadScheduledExecutor();
        int n10 = Process.myPid();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/proc/");
        object = Integer.toString(n10);
        stringBuilder.append((String)object);
        stringBuilder.append("/stat");
        this.procFileName = object = stringBuilder.toString();
        this.clockTicksPerSecond = l10 = this.getClockTicksPerSecond();
    }

    public CpuGaugeCollector(ScheduledExecutorService scheduledExecutorService, String string2, long l10) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        this.cpuMetricReadings = concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.cpuMetricCollectorExecutor = scheduledExecutorService;
        this.procFileName = string2;
        this.clockTicksPerSecond = l10;
    }

    private long convertClockTicksToMicroseconds(long l10) {
        double d10 = l10;
        double d11 = this.clockTicksPerSecond;
        d10 /= d11;
        d11 = MICROSECONDS_PER_SECOND;
        return Math.round(d10 * d11);
    }

    private long getClockTicksPerSecond() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return Os.sysconf((int)OsConstants._SC_CLK_TCK);
        }
        return -1;
    }

    public static CpuGaugeCollector getInstance() {
        CpuGaugeCollector cpuGaugeCollector = sharedInstance;
        if (cpuGaugeCollector == null) {
            sharedInstance = cpuGaugeCollector = new CpuGaugeCollector();
        }
        return sharedInstance;
    }

    public static boolean isInvalidCollectionFrequency(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object <= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public static /* synthetic */ void lambda$scheduleCpuMetricCollectionOnce$1(CpuGaugeCollector object, Timer object2) {
        if ((object2 = ((CpuGaugeCollector)object).syncCollectCpuMetric((Timer)object2)) != null) {
            object = ((CpuGaugeCollector)object).cpuMetricReadings;
            ((ConcurrentLinkedQueue)object).add(object2);
        }
    }

    public static /* synthetic */ void lambda$scheduleCpuMetricCollectionWithRate$0(CpuGaugeCollector object, Timer object2) {
        if ((object2 = ((CpuGaugeCollector)object).syncCollectCpuMetric((Timer)object2)) != null) {
            object = ((CpuGaugeCollector)object).cpuMetricReadings;
            ((ConcurrentLinkedQueue)object).add(object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void scheduleCpuMetricCollectionOnce(Timer object) {
        synchronized (this) {
            Throwable throwable2;
            block5: {
                try {
                    try {
                        ScheduledExecutorService scheduledExecutorService = this.cpuMetricCollectorExecutor;
                        object = CpuGaugeCollector$$Lambda$2.lambdaFactory$(this, (Timer)object);
                        long l10 = 0L;
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        scheduledExecutorService.schedule((Runnable)object, l10, timeUnit);
                    }
                    catch (RejectedExecutionException rejectedExecutionException) {
                        AndroidLogger androidLogger = logger;
                        StringBuilder stringBuilder = new StringBuilder();
                        String string2 = "Unable to collect Cpu Metric: ";
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
    private void scheduleCpuMetricCollectionWithRate(long l10, Timer object) {
        synchronized (this) {
            Object object2;
            Object object3;
            this.cpuMetricCollectionRateMs = l10;
            try {
                object3 = this.cpuMetricCollectorExecutor;
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                AndroidLogger androidLogger = logger;
                object = new StringBuilder();
                object3 = "Unable to start collecting Cpu Metrics: ";
                ((StringBuilder)object).append((String)object3);
                object2 = rejectedExecutionException.getMessage();
                ((StringBuilder)object).append((String)object2);
                object2 = ((StringBuilder)object).toString();
                androidLogger.warn((String)object2);
                return;
            }
            Runnable runnable = CpuGaugeCollector$$Lambda$1.lambdaFactory$(this, (Timer)object);
            long l11 = 0L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.cpuMetricCollectorJob = object2 = object3.scheduleAtFixedRate(runnable, l11, l10, timeUnit);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private CpuMetricReading syncCollectCpuMetric(Timer object) {
        if (object == null) {
            return null;
        }
        String string2 = this.procFileName;
        Object object2 = new FileReader(string2);
        Object object3 = new BufferedReader((Reader)object2);
        {
            String string3;
            block13: {
                catch (NullPointerException nullPointerException) {
                    break block13;
                }
                catch (NumberFormatException numberFormatException) {
                    break block13;
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    // empty catch block
                    break block13;
                }
                catch (IOException iOException) {
                    object3 = logger;
                    object2 = new StringBuilder();
                    string2 = "Unable to read 'proc/[pid]/stat' file: ";
                    ((StringBuilder)object2).append(string2);
                    String string4 = iOException.getMessage();
                    ((StringBuilder)object2).append(string4);
                    string4 = ((StringBuilder)object2).toString();
                    ((AndroidLogger)object3).warn(string4);
                    return null;
                }
                try {
                    long l10 = ((Timer)object).getCurrentTimestampMicros();
                    object = ((BufferedReader)object3).readLine();
                    Object object4 = " ";
                    object = ((String)object).split((String)object4);
                    int n10 = 13;
                    object4 = object[n10];
                    long l11 = Long.parseLong((String)object4);
                    int n11 = 15;
                    Object object5 = object[n11];
                    long l12 = Long.parseLong((String)object5);
                    int n12 = 14;
                    Object object6 = object[n12];
                    long l13 = Long.parseLong((String)object6);
                    int n13 = 16;
                    object = object[n13];
                    long l14 = Long.parseLong((String)object);
                    object = CpuMetricReading.newBuilder();
                    object = ((CpuMetricReading$Builder)object).setClientTimeUs(l10);
                    l10 = this.convertClockTicksToMicroseconds(l13 += l14);
                    object = ((CpuMetricReading$Builder)object).setSystemTimeUs(l10);
                    l10 = this.convertClockTicksToMicroseconds(l11 += l12);
                    object = ((CpuMetricReading$Builder)object).setUserTimeUs(l10);
                    object = ((GeneratedMessageLite$Builder)object).build();
                    object = (CpuMetricReading)object;
                }
                catch (Throwable throwable) {}
                {
                    ((BufferedReader)object3).close();
                    return object;
                }
                try {
                    ((BufferedReader)object3).close();
                }
                catch (Throwable throwable) {
                    throw throwable;
                }
                {
                    throw throwable;
                }
            }
            object3 = logger;
            object2 = new StringBuilder();
            string2 = "Unexpected '/proc/[pid]/stat' file format encountered: ";
            ((StringBuilder)object2).append(string2);
            string3 = ((Throwable)((Object)string3)).getMessage();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            ((AndroidLogger)object3).warn(string3);
            return null;
        }
    }

    public void collectOnce(Timer timer) {
        this.scheduleCpuMetricCollectionOnce(timer);
    }

    public void startCollecting(long l10, Timer timer) {
        long l11;
        Object object;
        long l12 = this.clockTicksPerSecond;
        long l13 = -1;
        long l14 = l12 - l13;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 != false && (object = (l11 = l12 - (l13 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            object = CpuGaugeCollector.isInvalidCollectionFrequency(l10);
            if (object != false) {
                return;
            }
            ScheduledFuture scheduledFuture = this.cpuMetricCollectorJob;
            if (scheduledFuture != null) {
                l12 = this.cpuMetricCollectionRateMs;
                long l15 = l12 - l10;
                object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object != false) {
                    this.stopCollecting();
                    this.scheduleCpuMetricCollectionWithRate(l10, timer);
                }
                return;
            }
            this.scheduleCpuMetricCollectionWithRate(l10, timer);
        }
    }

    public void stopCollecting() {
        ScheduledFuture scheduledFuture = this.cpuMetricCollectorJob;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.cpuMetricCollectorJob = null;
        this.cpuMetricCollectionRateMs = -1;
    }
}

