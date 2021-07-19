/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.perf.config;

import android.content.Context;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.config.ConfigurationConstants$CollectionDeactivated;
import com.google.firebase.perf.config.ConfigurationConstants$CollectionEnabled;
import com.google.firebase.perf.config.ConfigurationConstants$LogSourceName;
import com.google.firebase.perf.config.ConfigurationConstants$NetworkEventCountBackground;
import com.google.firebase.perf.config.ConfigurationConstants$NetworkEventCountForeground;
import com.google.firebase.perf.config.ConfigurationConstants$NetworkRequestSamplingRate;
import com.google.firebase.perf.config.ConfigurationConstants$RateLimitSec;
import com.google.firebase.perf.config.ConfigurationConstants$SdkDisabledVersions;
import com.google.firebase.perf.config.ConfigurationConstants$SdkEnabled;
import com.google.firebase.perf.config.ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs;
import com.google.firebase.perf.config.ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs;
import com.google.firebase.perf.config.ConfigurationConstants$SessionsMaxDurationMinutes;
import com.google.firebase.perf.config.ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs;
import com.google.firebase.perf.config.ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs;
import com.google.firebase.perf.config.ConfigurationConstants$SessionsSamplingRate;
import com.google.firebase.perf.config.ConfigurationConstants$TraceEventCountBackground;
import com.google.firebase.perf.config.ConfigurationConstants$TraceEventCountForeground;
import com.google.firebase.perf.config.ConfigurationConstants$TraceSamplingRate;
import com.google.firebase.perf.config.ConfigurationFlag;
import com.google.firebase.perf.config.DeviceCacheManager;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.Utils;

public class ConfigResolver {
    private static volatile ConfigResolver configResolver;
    private static final AndroidLogger logger;
    private DeviceCacheManager deviceCacheManager;
    private ImmutableBundle metadataBundle;
    private RemoteConfigManager remoteConfigManager;

    static {
        logger = AndroidLogger.getInstance();
    }

    public ConfigResolver(RemoteConfigManager remoteConfigManager, ImmutableBundle immutableBundle, DeviceCacheManager deviceCacheManager) {
        if (remoteConfigManager == null) {
            remoteConfigManager = RemoteConfigManager.getInstance();
        }
        this.remoteConfigManager = remoteConfigManager;
        if (immutableBundle == null) {
            immutableBundle = new ImmutableBundle();
        }
        this.metadataBundle = immutableBundle;
        if (deviceCacheManager == null) {
            deviceCacheManager = DeviceCacheManager.getInstance();
        }
        this.deviceCacheManager = deviceCacheManager;
    }

    public static void clearInstance() {
        configResolver = null;
    }

    private Optional getDeviceCacheBoolean(ConfigurationFlag object) {
        DeviceCacheManager deviceCacheManager = this.deviceCacheManager;
        object = ((ConfigurationFlag)object).getDeviceCacheFlag();
        return deviceCacheManager.getBoolean((String)object);
    }

    private Optional getDeviceCacheFloat(ConfigurationFlag object) {
        DeviceCacheManager deviceCacheManager = this.deviceCacheManager;
        object = ((ConfigurationFlag)object).getDeviceCacheFlag();
        return deviceCacheManager.getFloat((String)object);
    }

    private Optional getDeviceCacheLong(ConfigurationFlag object) {
        DeviceCacheManager deviceCacheManager = this.deviceCacheManager;
        object = ((ConfigurationFlag)object).getDeviceCacheFlag();
        return deviceCacheManager.getLong((String)object);
    }

    private Optional getDeviceCacheString(ConfigurationFlag object) {
        DeviceCacheManager deviceCacheManager = this.deviceCacheManager;
        object = ((ConfigurationFlag)object).getDeviceCacheFlag();
        return deviceCacheManager.getString((String)object);
    }

    public static ConfigResolver getInstance() {
        Class<ConfigResolver> clazz = ConfigResolver.class;
        synchronized (clazz) {
            ConfigResolver configResolver = ConfigResolver.configResolver;
            if (configResolver == null) {
                ConfigResolver.configResolver = configResolver = new ConfigResolver(null, null, null);
            }
            configResolver = ConfigResolver.configResolver;
            return configResolver;
        }
    }

    private boolean getIsSdkEnabled() {
        Object object = ConfigurationConstants$SdkEnabled.getInstance();
        Optional optional = this.getRemoteConfigBoolean((ConfigurationFlag)object);
        boolean bl2 = optional.isAvailable();
        if (bl2) {
            Object object2 = this.remoteConfigManager;
            bl2 = ((RemoteConfigManager)object2).isLastFetchFailed();
            if (bl2) {
                return false;
            }
            object2 = this.deviceCacheManager;
            object = ((ConfigurationConstants$SdkEnabled)object).getDeviceCacheFlag();
            boolean bl3 = (Boolean)optional.get();
            ((DeviceCacheManager)object2).setValue((String)object, bl3);
            return (Boolean)optional.get();
        }
        optional = this.getDeviceCacheBoolean((ConfigurationFlag)object);
        bl2 = optional.isAvailable();
        if (bl2) {
            return (Boolean)optional.get();
        }
        return ((ConfigurationConstants$SdkEnabled)object).getDefault();
    }

    private boolean getIsSdkVersionDisabled() {
        Object object = ConfigurationConstants$SdkDisabledVersions.getInstance();
        Optional optional = this.getRemoteConfigString((ConfigurationFlag)object);
        boolean bl2 = optional.isAvailable();
        if (bl2) {
            DeviceCacheManager deviceCacheManager = this.deviceCacheManager;
            object = ((ConfigurationConstants$SdkDisabledVersions)object).getDeviceCacheFlag();
            String string2 = (String)optional.get();
            deviceCacheManager.setValue((String)object, string2);
            object = (String)optional.get();
            return this.isFireperfSdkVersionInList((String)object);
        }
        optional = this.getDeviceCacheString((ConfigurationFlag)object);
        bl2 = optional.isAvailable();
        if (bl2) {
            object = (String)optional.get();
            return this.isFireperfSdkVersionInList((String)object);
        }
        object = ((ConfigurationConstants$SdkDisabledVersions)object).getDefault();
        return this.isFireperfSdkVersionInList((String)object);
    }

    private Optional getMetadataBoolean(ConfigurationFlag object) {
        ImmutableBundle immutableBundle = this.metadataBundle;
        object = ((ConfigurationFlag)object).getMetadataFlag();
        return immutableBundle.getBoolean((String)object);
    }

    private Optional getMetadataFloat(ConfigurationFlag object) {
        ImmutableBundle immutableBundle = this.metadataBundle;
        object = ((ConfigurationFlag)object).getMetadataFlag();
        return immutableBundle.getFloat((String)object);
    }

    private Optional getMetadataLong(ConfigurationFlag object) {
        ImmutableBundle immutableBundle = this.metadataBundle;
        object = ((ConfigurationFlag)object).getMetadataFlag();
        return immutableBundle.getLong((String)object);
    }

    private Optional getRemoteConfigBoolean(ConfigurationFlag object) {
        RemoteConfigManager remoteConfigManager = this.remoteConfigManager;
        object = ((ConfigurationFlag)object).getRemoteConfigFlag();
        return remoteConfigManager.getBoolean((String)object);
    }

    private Optional getRemoteConfigFloat(ConfigurationFlag object) {
        RemoteConfigManager remoteConfigManager = this.remoteConfigManager;
        object = ((ConfigurationFlag)object).getRemoteConfigFlag();
        return remoteConfigManager.getFloat((String)object);
    }

    private Optional getRemoteConfigLong(ConfigurationFlag object) {
        RemoteConfigManager remoteConfigManager = this.remoteConfigManager;
        object = ((ConfigurationFlag)object).getRemoteConfigFlag();
        return remoteConfigManager.getLong((String)object);
    }

    private Optional getRemoteConfigString(ConfigurationFlag object) {
        RemoteConfigManager remoteConfigManager = this.remoteConfigManager;
        object = ((ConfigurationFlag)object).getRemoteConfigFlag();
        return remoteConfigManager.getString((String)object);
    }

    private Long getRemoteConfigValue(ConfigurationFlag object) {
        String string2 = ((ConfigurationFlag)object).getRemoteConfigFlag();
        if (string2 == null) {
            object = (Long)((ConfigurationFlag)object).getDefault();
        } else {
            RemoteConfigManager remoteConfigManager = this.remoteConfigManager;
            object = (Long)((ConfigurationFlag)object).getDefault();
            object = (Long)remoteConfigManager.getRemoteConfigValueOrDefault(string2, object);
        }
        return object;
    }

    private boolean isEventCountValid(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private boolean isFireperfSdkVersionInList(String stringArray) {
        String string2 = stringArray.trim();
        int n10 = string2.isEmpty();
        if (n10 != 0) {
            return false;
        }
        string2 = ";";
        stringArray = stringArray.split(string2);
        n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3;
            String string4 = stringArray[i10].trim();
            boolean bl2 = string4.equals(string3 = BuildConfig.FIREPERF_VERSION_NAME);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    private boolean isGaugeCaptureFrequencyMsValid(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isSamplingRateValid(float f10) {
        void var4_8;
        float f11 = 0.0f;
        float f12 = 0.0f - f10;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object <= 0) {
            int n10 = 1065353216;
            f11 = 1.0f;
            float f13 = f10 - f11;
            Object object2 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
            if (object2 <= 0) {
                return (boolean)var4_8;
            }
        }
        boolean bl2 = false;
        return (boolean)var4_8;
    }

    private boolean isSessionsMaxDurationMinutesValid(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private boolean isTimeRangeSecValid(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public String getAndCacheLogSourceName() {
        Object object;
        ConfigurationConstants$LogSourceName configurationConstants$LogSourceName = ConfigurationConstants$LogSourceName.getInstance();
        Object object2 = BuildConfig.ENFORCE_DEFAULT_LOG_SRC;
        boolean bl2 = (Boolean)object2;
        if (bl2) {
            return configurationConstants$LogSourceName.getDefault();
        }
        object2 = configurationConstants$LogSourceName.getRemoteConfigFlag();
        long l10 = -1;
        if (object2 != null) {
            RemoteConfigManager remoteConfigManager = this.remoteConfigManager;
            object = l10;
            object2 = (Long)remoteConfigManager.getRemoteConfigValueOrDefault((String)object2, object);
            l10 = (Long)object2;
        }
        object2 = configurationConstants$LogSourceName.getDeviceCacheFlag();
        boolean bl3 = ConfigurationConstants$LogSourceName.isLogSourceKnown(l10);
        if (bl3 && (object = ConfigurationConstants$LogSourceName.getLogSourceName(l10)) != null) {
            this.deviceCacheManager.setValue((String)object2, (String)object);
            return object;
        }
        object2 = this.getDeviceCacheString(configurationConstants$LogSourceName);
        boolean bl4 = ((Optional)object2).isAvailable();
        if (bl4) {
            return (String)((Optional)object2).get();
        }
        return configurationConstants$LogSourceName.getDefault();
    }

    public Boolean getIsPerformanceCollectionDeactivated() {
        ConfigurationConstants$CollectionDeactivated configurationConstants$CollectionDeactivated = ConfigurationConstants$CollectionDeactivated.getInstance();
        Optional optional = this.getMetadataBoolean(configurationConstants$CollectionDeactivated);
        boolean bl2 = optional.isAvailable();
        if (bl2) {
            return (Boolean)optional.get();
        }
        return configurationConstants$CollectionDeactivated.getDefault();
    }

    public Boolean getIsPerformanceCollectionEnabled() {
        Object object = this.getIsPerformanceCollectionDeactivated();
        boolean bl2 = (Boolean)object;
        if (bl2) {
            return Boolean.FALSE;
        }
        object = ConfigurationConstants$CollectionEnabled.getInstance();
        Optional optional = this.getDeviceCacheBoolean((ConfigurationFlag)object);
        boolean bl3 = optional.isAvailable();
        if (bl3) {
            return (Boolean)optional.get();
        }
        boolean bl4 = ((Optional)(object = this.getMetadataBoolean((ConfigurationFlag)object))).isAvailable();
        if (bl4) {
            return (Boolean)((Optional)object).get();
        }
        logger.debug("CollectionEnabled metadata key unknown or value not found in manifest.");
        return null;
    }

    public boolean getIsServiceCollectionEnabled() {
        boolean bl2 = this.getIsSdkEnabled();
        bl2 = bl2 && !(bl2 = this.getIsSdkVersionDisabled());
        return bl2;
    }

    public long getNetworkEventCountBackground() {
        Object object;
        long l10;
        Object object2 = ConfigurationConstants$NetworkEventCountBackground.getInstance();
        Optional optional = this.getRemoteConfigLong((ConfigurationFlag)object2);
        boolean bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isEventCountValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$NetworkEventCountBackground)object2).getDeviceCacheFlag();
            long l11 = (Long)optional.get();
            ((DeviceCacheManager)object).setValue((String)object2, l11);
            return (Long)optional.get();
        }
        optional = this.getDeviceCacheLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isEventCountValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        return ((ConfigurationConstants$NetworkEventCountBackground)object2).getDefault();
    }

    public long getNetworkEventCountForeground() {
        Object object;
        long l10;
        Object object2 = ConfigurationConstants$NetworkEventCountForeground.getInstance();
        Optional optional = this.getRemoteConfigLong((ConfigurationFlag)object2);
        boolean bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isEventCountValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$NetworkEventCountForeground)object2).getDeviceCacheFlag();
            long l11 = (Long)optional.get();
            ((DeviceCacheManager)object).setValue((String)object2, l11);
            return (Long)optional.get();
        }
        optional = this.getDeviceCacheLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isEventCountValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        return ((ConfigurationConstants$NetworkEventCountForeground)object2).getDefault();
    }

    public float getNetworkRequestSamplingRate() {
        Object object;
        float f10;
        Object object2 = ConfigurationConstants$NetworkRequestSamplingRate.getInstance();
        Optional optional = this.getRemoteConfigFloat((ConfigurationFlag)object2);
        boolean bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isSamplingRateValid(f10 = ((Float)(object = (Float)optional.get())).floatValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$NetworkRequestSamplingRate)object2).getDeviceCacheFlag();
            float f11 = ((Float)optional.get()).floatValue();
            ((DeviceCacheManager)object).setValue((String)object2, f11);
            return ((Float)optional.get()).floatValue();
        }
        optional = this.getDeviceCacheFloat((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isSamplingRateValid(f10 = ((Float)(object = (Float)optional.get())).floatValue()))) {
            return ((Float)optional.get()).floatValue();
        }
        return ((ConfigurationConstants$NetworkRequestSamplingRate)object2).getDefault().floatValue();
    }

    public long getRateLimitSec() {
        Object object;
        long l10;
        Object object2 = ConfigurationConstants$RateLimitSec.getInstance();
        Optional optional = this.getRemoteConfigLong((ConfigurationFlag)object2);
        boolean bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isTimeRangeSecValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$RateLimitSec)object2).getDeviceCacheFlag();
            long l11 = (Long)optional.get();
            ((DeviceCacheManager)object).setValue((String)object2, l11);
            return (Long)optional.get();
        }
        optional = this.getDeviceCacheLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isTimeRangeSecValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        return ((ConfigurationConstants$RateLimitSec)object2).getDefault();
    }

    public long getSessionsCpuCaptureFrequencyBackgroundMs() {
        Object object;
        long l10;
        Object object2 = ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs.getInstance();
        Optional optional = this.getMetadataLong((ConfigurationFlag)object2);
        boolean bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isGaugeCaptureFrequencyMsValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        optional = this.getRemoteConfigLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isGaugeCaptureFrequencyMsValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs)object2).getDeviceCacheFlag();
            long l11 = (Long)optional.get();
            ((DeviceCacheManager)object).setValue((String)object2, l11);
            return (Long)optional.get();
        }
        optional = this.getDeviceCacheLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isGaugeCaptureFrequencyMsValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        return ((ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs)object2).getDefault();
    }

    public long getSessionsCpuCaptureFrequencyForegroundMs() {
        Object object;
        long l10;
        Object object2 = ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs.getInstance();
        Optional optional = this.getMetadataLong((ConfigurationFlag)object2);
        boolean bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isGaugeCaptureFrequencyMsValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        optional = this.getRemoteConfigLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isGaugeCaptureFrequencyMsValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs)object2).getDeviceCacheFlag();
            long l11 = (Long)optional.get();
            ((DeviceCacheManager)object).setValue((String)object2, l11);
            return (Long)optional.get();
        }
        optional = this.getDeviceCacheLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isGaugeCaptureFrequencyMsValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        return ((ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs)object2).getDefault();
    }

    public long getSessionsMaxDurationMinutes() {
        Object object;
        long l10;
        Object object2 = ConfigurationConstants$SessionsMaxDurationMinutes.getInstance();
        Optional optional = this.getMetadataLong((ConfigurationFlag)object2);
        boolean bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isSessionsMaxDurationMinutesValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        optional = this.getRemoteConfigLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isSessionsMaxDurationMinutesValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$SessionsMaxDurationMinutes)object2).getDeviceCacheFlag();
            long l11 = (Long)optional.get();
            ((DeviceCacheManager)object).setValue((String)object2, l11);
            return (Long)optional.get();
        }
        optional = this.getDeviceCacheLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isSessionsMaxDurationMinutesValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        return ((ConfigurationConstants$SessionsMaxDurationMinutes)object2).getDefault();
    }

    public long getSessionsMemoryCaptureFrequencyBackgroundMs() {
        Object object;
        long l10;
        Object object2 = ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs.getInstance();
        Optional optional = this.getMetadataLong((ConfigurationFlag)object2);
        boolean bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isGaugeCaptureFrequencyMsValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        optional = this.getRemoteConfigLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isGaugeCaptureFrequencyMsValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs)object2).getDeviceCacheFlag();
            long l11 = (Long)optional.get();
            ((DeviceCacheManager)object).setValue((String)object2, l11);
            return (Long)optional.get();
        }
        optional = this.getDeviceCacheLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isGaugeCaptureFrequencyMsValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        return ((ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs)object2).getDefault();
    }

    public long getSessionsMemoryCaptureFrequencyForegroundMs() {
        Object object;
        long l10;
        Object object2 = ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.getInstance();
        Optional optional = this.getMetadataLong((ConfigurationFlag)object2);
        boolean bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isGaugeCaptureFrequencyMsValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        optional = this.getRemoteConfigLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isGaugeCaptureFrequencyMsValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs)object2).getDeviceCacheFlag();
            long l11 = (Long)optional.get();
            ((DeviceCacheManager)object).setValue((String)object2, l11);
            return (Long)optional.get();
        }
        optional = this.getDeviceCacheLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isGaugeCaptureFrequencyMsValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        return ((ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs)object2).getDefault();
    }

    public float getSessionsSamplingRate() {
        Object object;
        float f10;
        Object object2 = ConfigurationConstants$SessionsSamplingRate.getInstance();
        Object object3 = this.getMetadataFloat((ConfigurationFlag)object2);
        boolean bl2 = ((Optional)object3).isAvailable();
        if (bl2) {
            object3 = (Float)((Optional)object3).get();
            float f11 = ((Float)object3).floatValue();
            f10 = 100.0f;
            bl2 = this.isSamplingRateValid(f11 /= f10);
            if (bl2) {
                return f11;
            }
        }
        if ((bl2 = ((Optional)(object3 = this.getRemoteConfigFloat((ConfigurationFlag)object2))).isAvailable()) && (bl2 = this.isSamplingRateValid(f10 = ((Float)(object = (Float)((Optional)object3).get())).floatValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$SessionsSamplingRate)object2).getDeviceCacheFlag();
            float f12 = ((Float)((Optional)object3).get()).floatValue();
            ((DeviceCacheManager)object).setValue((String)object2, f12);
            return ((Float)((Optional)object3).get()).floatValue();
        }
        object3 = this.getDeviceCacheFloat((ConfigurationFlag)object2);
        bl2 = ((Optional)object3).isAvailable();
        if (bl2 && (bl2 = this.isSamplingRateValid(f10 = ((Float)(object = (Float)((Optional)object3).get())).floatValue()))) {
            return ((Float)((Optional)object3).get()).floatValue();
        }
        return ((ConfigurationConstants$SessionsSamplingRate)object2).getDefault().floatValue();
    }

    public long getTraceEventCountBackground() {
        Object object;
        long l10;
        Object object2 = ConfigurationConstants$TraceEventCountBackground.getInstance();
        Optional optional = this.getRemoteConfigLong((ConfigurationFlag)object2);
        boolean bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isEventCountValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$TraceEventCountBackground)object2).getDeviceCacheFlag();
            long l11 = (Long)optional.get();
            ((DeviceCacheManager)object).setValue((String)object2, l11);
            return (Long)optional.get();
        }
        optional = this.getDeviceCacheLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isEventCountValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        return ((ConfigurationConstants$TraceEventCountBackground)object2).getDefault();
    }

    public long getTraceEventCountForeground() {
        Object object;
        long l10;
        Object object2 = ConfigurationConstants$TraceEventCountForeground.getInstance();
        Optional optional = this.getRemoteConfigLong((ConfigurationFlag)object2);
        boolean bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isEventCountValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$TraceEventCountForeground)object2).getDeviceCacheFlag();
            long l11 = (Long)optional.get();
            ((DeviceCacheManager)object).setValue((String)object2, l11);
            return (Long)optional.get();
        }
        optional = this.getDeviceCacheLong((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isEventCountValid(l10 = ((Long)(object = (Long)optional.get())).longValue()))) {
            return (Long)optional.get();
        }
        return ((ConfigurationConstants$TraceEventCountForeground)object2).getDefault();
    }

    public float getTraceSamplingRate() {
        Object object;
        float f10;
        Object object2 = ConfigurationConstants$TraceSamplingRate.getInstance();
        Optional optional = this.getRemoteConfigFloat((ConfigurationFlag)object2);
        boolean bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isSamplingRateValid(f10 = ((Float)(object = (Float)optional.get())).floatValue()))) {
            object = this.deviceCacheManager;
            object2 = ((ConfigurationConstants$TraceSamplingRate)object2).getDeviceCacheFlag();
            float f11 = ((Float)optional.get()).floatValue();
            ((DeviceCacheManager)object).setValue((String)object2, f11);
            return ((Float)optional.get()).floatValue();
        }
        optional = this.getDeviceCacheFloat((ConfigurationFlag)object2);
        bl2 = optional.isAvailable();
        if (bl2 && (bl2 = this.isSamplingRateValid(f10 = ((Float)(object = (Float)optional.get())).floatValue()))) {
            return ((Float)optional.get()).floatValue();
        }
        return ((ConfigurationConstants$TraceSamplingRate)object2).getDefault().floatValue();
    }

    public boolean isPerformanceMonitoringEnabled() {
        boolean bl2;
        Boolean bl3 = this.getIsPerformanceCollectionEnabled();
        boolean bl4 = true;
        if (bl3 != null && (bl2 = bl3.booleanValue()) != bl4 || !(bl2 = this.getIsServiceCollectionEnabled())) {
            bl4 = false;
        }
        return bl4;
    }

    public void setApplicationContext(Context context) {
        AndroidLogger androidLogger = logger;
        boolean bl2 = Utils.isDebugLoggingEnabled(context);
        androidLogger.setLogcatEnabled(bl2);
        this.deviceCacheManager.setContext(context);
    }

    public void setContentProviderContext(Context context) {
        context = context.getApplicationContext();
        this.setApplicationContext(context);
    }

    public void setIsPerformanceCollectionEnabled(Boolean object) {
        Object object2 = this.getIsPerformanceCollectionDeactivated();
        boolean bl2 = (Boolean)object2;
        if (bl2) {
            return;
        }
        object2 = ConfigurationConstants$CollectionEnabled.getInstance().getDeviceCacheFlag();
        if (object2 != null) {
            if (object != null) {
                DeviceCacheManager deviceCacheManager = this.deviceCacheManager;
                Boolean bl3 = Boolean.TRUE;
                boolean bl4 = bl3.equals(object);
                deviceCacheManager.setValue((String)object2, bl4);
            } else {
                object = this.deviceCacheManager;
                ((DeviceCacheManager)object).clear((String)object2);
            }
        }
    }

    public void setMetadataBundle(ImmutableBundle immutableBundle) {
        this.metadataBundle = immutableBundle;
    }
}

