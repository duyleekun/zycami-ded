/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaDrm$Provider;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class DefaultDrmSessionManager$Builder {
    private ExoMediaDrm$Provider exoMediaDrmProvider;
    private final HashMap keyRequestParameters;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private boolean multiSession;
    private boolean playClearSamplesWithoutKeys;
    private long sessionKeepaliveMs;
    private int[] useDrmSessionsForClearContentTrackTypes;
    private UUID uuid;

    public DefaultDrmSessionManager$Builder() {
        Object object = new HashMap();
        this.keyRequestParameters = object;
        object = C.WIDEVINE_UUID;
        this.uuid = object;
        this.exoMediaDrmProvider = object = FrameworkMediaDrm.DEFAULT_PROVIDER;
        this.loadErrorHandlingPolicy = object = new DefaultLoadErrorHandlingPolicy();
        object = new int[0];
        this.useDrmSessionsForClearContentTrackTypes = (int[])object;
        this.sessionKeepaliveMs = 300000L;
    }

    public DefaultDrmSessionManager build(MediaDrmCallback mediaDrmCallback) {
        UUID uUID = this.uuid;
        ExoMediaDrm$Provider exoMediaDrm$Provider = this.exoMediaDrmProvider;
        HashMap hashMap = this.keyRequestParameters;
        boolean bl2 = this.multiSession;
        int[] nArray = this.useDrmSessionsForClearContentTrackTypes;
        boolean bl3 = this.playClearSamplesWithoutKeys;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        long l10 = this.sessionKeepaliveMs;
        DefaultDrmSessionManager defaultDrmSessionManager = new DefaultDrmSessionManager(uUID, exoMediaDrm$Provider, mediaDrmCallback, hashMap, bl2, nArray, bl3, loadErrorHandlingPolicy, l10, null);
        return defaultDrmSessionManager;
    }

    public DefaultDrmSessionManager$Builder setKeyRequestParameters(Map map) {
        HashMap hashMap = this.keyRequestParameters;
        hashMap.clear();
        if (map != null) {
            hashMap = this.keyRequestParameters;
            hashMap.putAll(map);
        }
        return this;
    }

    public DefaultDrmSessionManager$Builder setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy = (LoadErrorHandlingPolicy)Assertions.checkNotNull(loadErrorHandlingPolicy);
        return this;
    }

    public DefaultDrmSessionManager$Builder setMultiSession(boolean bl2) {
        this.multiSession = bl2;
        return this;
    }

    public DefaultDrmSessionManager$Builder setPlayClearSamplesWithoutKeys(boolean bl2) {
        this.playClearSamplesWithoutKeys = bl2;
        return this;
    }

    public DefaultDrmSessionManager$Builder setSessionKeepaliveMs(long l10) {
        long l11;
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object <= 0 && (object = (l11 = l10 - (l12 = -9223372036854775807L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false ? (Object)0 : (Object)1;
        Assertions.checkArgument((boolean)object);
        this.sessionKeepaliveMs = l10;
        return this;
    }

    public DefaultDrmSessionManager$Builder setUseDrmSessionsForClearContent(int ... nArray) {
        for (int n10 : nArray) {
            int n11 = 2;
            int n12 = 1;
            if (n10 != n11 && n10 != n12) {
                n12 = 0;
            }
            Assertions.checkArgument(n12 != 0);
        }
        nArray = (int[])nArray.clone();
        this.useDrmSessionsForClearContentTrackTypes = nArray;
        return this;
    }

    public DefaultDrmSessionManager$Builder setUuidAndExoMediaDrmProvider(UUID object, ExoMediaDrm$Provider exoMediaDrm$Provider) {
        object = (UUID)Assertions.checkNotNull(object);
        this.uuid = object;
        this.exoMediaDrmProvider = object = (ExoMediaDrm$Provider)Assertions.checkNotNull(exoMediaDrm$Provider);
        return this;
    }
}

