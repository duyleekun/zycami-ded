/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.perf.transport;

import android.content.Context;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.transport.RateLimiter$RateLimiterImpl;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.List;
import java.util.Random;

public final class RateLimiter {
    private final ConfigResolver configResolver;
    private boolean isLogcatEnabled;
    private RateLimiter$RateLimiterImpl mNetworkLimiter;
    private RateLimiter$RateLimiterImpl mTraceLimiter;
    private final float samplingBucketId;

    public RateLimiter(double d10, long l10, Clock clock, float f10, ConfigResolver configResolver) {
        float f11;
        RateLimiter rateLimiter = this;
        float f12 = f10;
        boolean bl2 = false;
        RateLimiter$RateLimiterImpl rateLimiter$RateLimiterImpl = null;
        this.isLogcatEnabled = false;
        this.mTraceLimiter = null;
        this.mNetworkLimiter = null;
        float f13 = 0.0f;
        float f14 = 0.0f - f10;
        float f15 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (f15 <= 0 && (f15 = (f11 = f10 - (f13 = 1.0f)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) < 0) {
            bl2 = true;
        }
        Utils.checkArgument(bl2, "Sampling bucket ID should be in range [0.0f, 1.0f).");
        rateLimiter.samplingBucketId = f12;
        rateLimiter.configResolver = configResolver;
        boolean bl3 = rateLimiter.isLogcatEnabled;
        rateLimiter.mTraceLimiter = rateLimiter$RateLimiterImpl = new RateLimiter$RateLimiterImpl(d10, l10, clock, configResolver, "Trace", bl3);
        bl3 = rateLimiter.isLogcatEnabled;
        rateLimiter.mNetworkLimiter = rateLimiter$RateLimiterImpl = new RateLimiter$RateLimiterImpl(d10, l10, clock, configResolver, "Network", bl3);
    }

    public RateLimiter(Context context, double d10, long l10) {
        boolean bl2;
        Clock clock = new Clock();
        float f10 = RateLimiter.getSamplingBucketId();
        ConfigResolver configResolver = ConfigResolver.getInstance();
        this(d10, l10, clock, f10, configResolver);
        this.isLogcatEnabled = bl2 = Utils.isDebugLoggingEnabled(context);
    }

    public static float getSamplingBucketId() {
        Random random = new Random();
        return random.nextFloat();
    }

    private boolean hasVerboseSessions(List object) {
        Object object2;
        int n10 = object.size();
        boolean bl2 = false;
        if (n10 > 0 && (n10 = ((PerfSession)(object2 = (PerfSession)object.get(0))).getSessionVerbosityCount()) > 0 && (object = ((PerfSession)object.get(0)).getSessionVerbosity(0)) == (object2 = SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS)) {
            bl2 = true;
        }
        return bl2;
    }

    private boolean isDeviceAllowedToSendNetworkEvents() {
        float f10 = this.samplingBucketId;
        ConfigResolver configResolver = this.configResolver;
        float f11 = configResolver.getNetworkRequestSamplingRate();
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            object = true;
            f11 = Float.MIN_VALUE;
        } else {
            object = false;
            f11 = 0.0f;
            configResolver = null;
        }
        return (boolean)object;
    }

    private boolean isDeviceAllowedToSendTraces() {
        float f10 = this.samplingBucketId;
        ConfigResolver configResolver = this.configResolver;
        float f11 = configResolver.getTraceSamplingRate();
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            object = true;
            f11 = Float.MIN_VALUE;
        } else {
            object = false;
            f11 = 0.0f;
            configResolver = null;
        }
        return (boolean)object;
    }

    public void changeRate(boolean bl2) {
        this.mTraceLimiter.changeRate(bl2);
        this.mNetworkLimiter.changeRate(bl2);
    }

    public boolean check(PerfMetric perfMetric) {
        List list;
        boolean bl2 = perfMetric.hasTraceMetric();
        if (bl2 && !(bl2 = this.isDeviceAllowedToSendTraces()) && !(bl2 = this.hasVerboseSessions(list = perfMetric.getTraceMetric().getPerfSessionsList()))) {
            return false;
        }
        bl2 = perfMetric.hasNetworkRequestMetric();
        if (bl2 && !(bl2 = this.isDeviceAllowedToSendNetworkEvents()) && !(bl2 = this.hasVerboseSessions(list = perfMetric.getNetworkRequestMetric().getPerfSessionsList()))) {
            return false;
        }
        bl2 = this.isRateLimited(perfMetric);
        if (!bl2) {
            return true;
        }
        bl2 = perfMetric.hasNetworkRequestMetric();
        if (bl2) {
            return this.mNetworkLimiter.check(perfMetric);
        }
        bl2 = perfMetric.hasTraceMetric();
        if (bl2) {
            return this.mTraceLimiter.check(perfMetric);
        }
        return false;
    }

    public boolean getIsDeviceAllowedToSendNetworkEvents() {
        return this.isDeviceAllowedToSendNetworkEvents();
    }

    public boolean getIsDeviceAllowedToSendTraces() {
        return this.isDeviceAllowedToSendTraces();
    }

    public boolean isRateLimited(PerfMetric perfMetric) {
        String string2;
        Object object;
        int n10 = perfMetric.hasTraceMetric();
        if (n10 != 0 && ((n10 = ((String)(object = perfMetric.getTraceMetric().getName())).equals(string2 = Constants$TraceNames.FOREGROUND_TRACE_NAME.toString())) != 0 || (n10 = (int)(((String)(object = perfMetric.getTraceMetric().getName())).equals(string2 = Constants$TraceNames.BACKGROUND_TRACE_NAME.toString()) ? 1 : 0)) != 0) && (n10 = ((TraceMetric)(object = perfMetric.getTraceMetric())).getCountersCount()) > 0) {
            return false;
        }
        boolean bl2 = perfMetric.hasGaugeMetric();
        return !bl2;
    }
}

