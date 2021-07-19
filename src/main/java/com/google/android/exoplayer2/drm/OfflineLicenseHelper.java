/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.ConditionVariable
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.Pair
 */
package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$Builder;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.ExoMediaDrm$Provider;
import com.google.android.exoplayer2.drm.HttpMediaDrmCallback;
import com.google.android.exoplayer2.drm.KeysExpiredException;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.drm.WidevineUtil;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;
import java.util.UUID;

public final class OfflineLicenseHelper {
    private static final Format FORMAT_WITH_EMPTY_DRM_INIT_DATA;
    private final ConditionVariable conditionVariable;
    private final DefaultDrmSessionManager drmSessionManager;
    private final DrmSessionEventListener$EventDispatcher eventDispatcher;
    private final HandlerThread handlerThread;

    static {
        Format$Builder format$Builder = new Format$Builder();
        DrmInitData$SchemeData[] drmInitData$SchemeDataArray = new DrmInitData$SchemeData[]{};
        DrmInitData drmInitData = new DrmInitData(drmInitData$SchemeDataArray);
        FORMAT_WITH_EMPTY_DRM_INIT_DATA = format$Builder.setDrmInitData(drmInitData).build();
    }

    public OfflineLicenseHelper(DefaultDrmSessionManager defaultDrmSessionManager, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher) {
        Object object;
        this.drmSessionManager = defaultDrmSessionManager;
        this.eventDispatcher = drmSessionEventListener$EventDispatcher;
        super("ExoPlayer:OfflineLicenseHelper");
        this.handlerThread = defaultDrmSessionManager;
        defaultDrmSessionManager.start();
        this.conditionVariable = object = new ConditionVariable();
        super(this);
        defaultDrmSessionManager = defaultDrmSessionManager.getLooper();
        Handler handler = new Handler((Looper)defaultDrmSessionManager);
        drmSessionEventListener$EventDispatcher.addEventListener(handler, (DrmSessionEventListener)object);
    }

    public OfflineLicenseHelper(UUID object, ExoMediaDrm$Provider exoMediaDrm$Provider, MediaDrmCallback mediaDrmCallback, Map map, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher) {
        DefaultDrmSessionManager$Builder defaultDrmSessionManager$Builder = new DefaultDrmSessionManager$Builder();
        object = defaultDrmSessionManager$Builder.setUuidAndExoMediaDrmProvider((UUID)object, exoMediaDrm$Provider).setKeyRequestParameters(map).build(mediaDrmCallback);
        this((DefaultDrmSessionManager)object, drmSessionEventListener$EventDispatcher);
    }

    public static /* synthetic */ ConditionVariable access$000(OfflineLicenseHelper offlineLicenseHelper) {
        return offlineLicenseHelper.conditionVariable;
    }

    private byte[] blockingKeyRequest(int n10, byte[] object, Format object2) {
        this.drmSessionManager.prepare();
        Object object3 = this.openBlockingKeyRequest(n10, (byte[])object, (Format)object2);
        object = object3.getError();
        object2 = object3.getOfflineLicenseKeySetId();
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.eventDispatcher;
        object3.release(drmSessionEventListener$EventDispatcher);
        object3 = this.drmSessionManager;
        ((DefaultDrmSessionManager)object3).release();
        if (object == null) {
            return (byte[])Assertions.checkNotNull(object2);
        }
        throw object;
    }

    public static OfflineLicenseHelper newWidevineInstance(String string2, HttpDataSource.Factory factory, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher) {
        return OfflineLicenseHelper.newWidevineInstance(string2, false, factory, drmSessionEventListener$EventDispatcher);
    }

    public static OfflineLicenseHelper newWidevineInstance(String string2, boolean bl2, HttpDataSource.Factory factory, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher) {
        return OfflineLicenseHelper.newWidevineInstance(string2, bl2, factory, null, drmSessionEventListener$EventDispatcher);
    }

    public static OfflineLicenseHelper newWidevineInstance(String object, boolean bl2, HttpDataSource.Factory factory, Map object2, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher) {
        Object object3 = new DefaultDrmSessionManager$Builder();
        object2 = ((DefaultDrmSessionManager$Builder)object3).setKeyRequestParameters((Map)object2);
        object3 = new HttpMediaDrmCallback((String)object, bl2, factory);
        object = ((DefaultDrmSessionManager$Builder)object2).build((MediaDrmCallback)object3);
        OfflineLicenseHelper offlineLicenseHelper = new OfflineLicenseHelper((DefaultDrmSessionManager)object, drmSessionEventListener$EventDispatcher);
        return offlineLicenseHelper;
    }

    private DrmSession openBlockingKeyRequest(int n10, byte[] object, Format format) {
        Assertions.checkNotNull(format.drmInitData);
        this.drmSessionManager.setMode(n10, (byte[])object);
        this.conditionVariable.close();
        Object object2 = this.drmSessionManager;
        object = this.handlerThread.getLooper();
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.eventDispatcher;
        object2 = ((DefaultDrmSessionManager)object2).acquireSession((Looper)object, drmSessionEventListener$EventDispatcher, format);
        this.conditionVariable.block();
        return (DrmSession)Assertions.checkNotNull(object2);
    }

    public byte[] downloadLicense(Format object) {
        synchronized (this) {
            int n10;
            block7: {
                DrmInitData drmInitData = ((Format)object).drmInitData;
                if (drmInitData != null) {
                    n10 = 1;
                    break block7;
                }
                n10 = 0;
                drmInitData = null;
            }
            Assertions.checkArgument(n10 != 0);
            n10 = 2;
            object = this.blockingKeyRequest(n10, null, (Format)object);
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Pair getLicenseDurationRemainingSec(byte[] object) {
        synchronized (this) {
            Assertions.checkNotNull(object);
            Object object2 = this.drmSessionManager;
            ((DefaultDrmSessionManager)object2).prepare();
            int n10 = 1;
            Format format = FORMAT_WITH_EMPTY_DRM_INIT_DATA;
            object = this.openBlockingKeyRequest(n10, (byte[])object, format);
            object2 = object.getError();
            format = WidevineUtil.getLicenseDurationRemainingSec((DrmSession)object);
            DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.eventDispatcher;
            object.release(drmSessionEventListener$EventDispatcher);
            object = this.drmSessionManager;
            ((DefaultDrmSessionManager)object).release();
            if (object2 == null) {
                object = Assertions.checkNotNull(format);
                return (Pair)object;
            }
            object = ((Throwable)object2).getCause();
            boolean bl2 = object instanceof KeysExpiredException;
            if (!bl2) throw object2;
            long l10 = 0L;
            object = l10;
            object2 = l10;
            return Pair.create((Object)object, (Object)object2);
        }
    }

    public void release() {
        this.handlerThread.quit();
    }

    public void releaseLicense(byte[] byArray) {
        synchronized (this) {
            Assertions.checkNotNull(byArray);
            int n10 = 3;
            Format format = FORMAT_WITH_EMPTY_DRM_INIT_DATA;
            this.blockingKeyRequest(n10, byArray, format);
            return;
        }
    }

    public byte[] renewLicense(byte[] byArray) {
        synchronized (this) {
            Assertions.checkNotNull(byArray);
            int n10 = 2;
            Format format = FORMAT_WITH_EMPTY_DRM_INIT_DATA;
            byArray = this.blockingKeyRequest(n10, byArray, format);
            return byArray;
        }
    }
}

