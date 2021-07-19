/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.exoplayer2.upstream;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class DefaultBandwidthMeter$Builder {
    private Clock clock;
    private final Context context;
    private Map initialBitrateEstimates;
    private boolean resetOnNetworkTypeChange;
    private int slidingWindowMaxWeight;

    public DefaultBandwidthMeter$Builder(Context object) {
        Context context = object == null ? null : object.getApplicationContext();
        this.context = context;
        object = DefaultBandwidthMeter$Builder.getInitialBitrateEstimatesForCountry(Util.getCountryCode(object));
        this.initialBitrateEstimates = object;
        this.slidingWindowMaxWeight = 2000;
        object = Clock.DEFAULT;
        this.clock = object;
        this.resetOnNetworkTypeChange = true;
    }

    private static ImmutableList getCountryGroupIndices(String object) {
        Serializable serializable = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS;
        boolean bl2 = ((AbstractCollection)(object = serializable.get(object))).isEmpty();
        if (bl2) {
            int n10 = 2;
            serializable = Integer.valueOf(n10);
            Integer n11 = n10;
            Integer n12 = n10;
            Integer n13 = n10;
            object = n10;
            object = ImmutableList.of(serializable, n11, n12, n13, object);
        }
        return object;
    }

    private static Map getInitialBitrateEstimatesForCountry(String object) {
        object = DefaultBandwidthMeter$Builder.getCountryGroupIndices((String)object);
        HashMap<Serializable, Object> hashMap = new HashMap<Serializable, Object>(6);
        Number number = 0;
        Serializable serializable = Long.valueOf(1000000L);
        hashMap.put(number, serializable);
        int n10 = 2;
        serializable = Integer.valueOf(n10);
        ImmutableList immutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI;
        int n11 = (Integer)object.get(0);
        Number number2 = (Long)immutableList.get(n11);
        hashMap.put(serializable, number2);
        int n12 = 3;
        number2 = n12;
        Serializable serializable2 = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G;
        int n13 = (Integer)object.get(1);
        serializable2 = (Long)serializable2.get(n13);
        hashMap.put(number2, serializable2);
        n11 = 4;
        serializable2 = Integer.valueOf(n11);
        ImmutableList immutableList2 = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G;
        n10 = (Integer)object.get(n10);
        number = (Long)immutableList2.get(n10);
        hashMap.put(serializable2, number);
        number = 5;
        serializable2 = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G;
        n12 = (Integer)object.get(n12);
        serializable = (Long)serializable2.get(n12);
        hashMap.put(number, serializable);
        number = 9;
        serializable = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA;
        n11 = (Integer)object.get(n11);
        serializable = (Long)serializable.get(n11);
        hashMap.put(number, serializable);
        number = 7;
        int n14 = (Integer)object.get(0);
        object = (Long)immutableList.get(n14);
        hashMap.put(number, object);
        return hashMap;
    }

    public DefaultBandwidthMeter build() {
        Context context = this.context;
        Map map = this.initialBitrateEstimates;
        int n10 = this.slidingWindowMaxWeight;
        Clock clock = this.clock;
        boolean bl2 = this.resetOnNetworkTypeChange;
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter(context, map, n10, clock, bl2, null);
        return defaultBandwidthMeter;
    }

    public DefaultBandwidthMeter$Builder setClock(Clock clock) {
        this.clock = clock;
        return this;
    }

    public DefaultBandwidthMeter$Builder setInitialBitrateEstimate(int n10, long l10) {
        Map map = this.initialBitrateEstimates;
        Integer n11 = n10;
        Long l11 = l10;
        map.put(n11, l11);
        return this;
    }

    public DefaultBandwidthMeter$Builder setInitialBitrateEstimate(long l10) {
        int n10;
        Iterator iterator2 = this.initialBitrateEstimates.keySet().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            Integer n11 = (Integer)iterator2.next();
            n10 = n11;
            this.setInitialBitrateEstimate(n10, l10);
        }
        return this;
    }

    public DefaultBandwidthMeter$Builder setInitialBitrateEstimate(String object) {
        this.initialBitrateEstimates = object = DefaultBandwidthMeter$Builder.getInitialBitrateEstimatesForCountry(Util.toUpperInvariant((String)object));
        return this;
    }

    public DefaultBandwidthMeter$Builder setResetOnNetworkTypeChange(boolean bl2) {
        this.resetOnNetworkTypeChange = bl2;
        return this;
    }

    public DefaultBandwidthMeter$Builder setSlidingWindowMaxWeight(int n10) {
        this.slidingWindowMaxWeight = n10;
        return this;
    }
}

