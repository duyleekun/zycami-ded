/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.NotProvisionedException
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.Pair
 */
package com.google.android.exoplayer2.drm;

import android.media.NotProvisionedException;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DefaultDrmSession$ProvisioningManager;
import com.google.android.exoplayer2.drm.DefaultDrmSession$ReferenceCountListener;
import com.google.android.exoplayer2.drm.DefaultDrmSession$RequestHandler;
import com.google.android.exoplayer2.drm.DefaultDrmSession$ResponseHandler;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSession$DrmSessionException;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest;
import com.google.android.exoplayer2.drm.ExoMediaDrm$ProvisionRequest;
import com.google.android.exoplayer2.drm.KeysExpiredException;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.drm.WidevineUtil;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Consumer;
import com.google.android.exoplayer2.util.CopyOnWriteMultiset;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.g0.a;
import d.h.a.a.g0.b;
import d.h.a.a.g0.c;
import d.h.a.a.g0.k;
import d.h.a.a.g0.p;
import d.h.a.a.g0.q;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DefaultDrmSession
implements DrmSession {
    private static final int MAX_LICENSE_DURATION_TO_RENEW_SECONDS = 60;
    private static final int MSG_KEYS = 1;
    private static final int MSG_PROVISION = 0;
    private static final String TAG = "DefaultDrmSession";
    public final MediaDrmCallback callback;
    private ExoMediaDrm$KeyRequest currentKeyRequest;
    private ExoMediaDrm$ProvisionRequest currentProvisionRequest;
    private final CopyOnWriteMultiset eventDispatchers;
    private final boolean isPlaceholderSession;
    private final HashMap keyRequestParameters;
    private DrmSession$DrmSessionException lastException;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private ExoMediaCrypto mediaCrypto;
    private final ExoMediaDrm mediaDrm;
    private final int mode;
    private byte[] offlineLicenseKeySetId;
    private final boolean playClearSamplesWithoutKeys;
    private final DefaultDrmSession$ProvisioningManager provisioningManager;
    private int referenceCount;
    private final DefaultDrmSession$ReferenceCountListener referenceCountListener;
    private DefaultDrmSession$RequestHandler requestHandler;
    private HandlerThread requestHandlerThread;
    public final DefaultDrmSession$ResponseHandler responseHandler;
    public final List schemeDatas;
    private byte[] sessionId;
    private int state;
    public final UUID uuid;

    public DefaultDrmSession(UUID object, ExoMediaDrm exoMediaDrm, DefaultDrmSession$ProvisioningManager defaultDrmSession$ProvisioningManager, DefaultDrmSession$ReferenceCountListener defaultDrmSession$ReferenceCountListener, List list, int n10, boolean bl2, boolean bl3, byte[] byArray, HashMap hashMap, MediaDrmCallback mediaDrmCallback, Looper looper, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        int n11 = 1;
        if (n10 == n11 || n10 == (n11 = 3)) {
            Assertions.checkNotNull(byArray);
        }
        this.uuid = object;
        this.provisioningManager = defaultDrmSession$ProvisioningManager;
        this.referenceCountListener = defaultDrmSession$ReferenceCountListener;
        this.mediaDrm = exoMediaDrm;
        this.mode = n10;
        this.playClearSamplesWithoutKeys = bl2;
        this.isPlaceholderSession = bl3;
        if (byArray != null) {
            this.offlineLicenseKeySetId = byArray;
            object = null;
            this.schemeDatas = null;
        } else {
            this.schemeDatas = object = Collections.unmodifiableList((List)Assertions.checkNotNull(list));
        }
        this.keyRequestParameters = hashMap;
        this.callback = mediaDrmCallback;
        this.eventDispatchers = object = new CopyOnWriteMultiset();
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.state = 2;
        object = new DefaultDrmSession$ResponseHandler(this, looper);
        this.responseHandler = object;
    }

    public static /* synthetic */ void a(Exception exception, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher) {
        drmSessionEventListener$EventDispatcher.drmSessionManagerError(exception);
    }

    public static /* synthetic */ void access$000(DefaultDrmSession defaultDrmSession, Object object, Object object2) {
        defaultDrmSession.onProvisionResponse(object, object2);
    }

    public static /* synthetic */ void access$100(DefaultDrmSession defaultDrmSession, Object object, Object object2) {
        defaultDrmSession.onKeyResponse(object, object2);
    }

    public static /* synthetic */ LoadErrorHandlingPolicy access$200(DefaultDrmSession defaultDrmSession) {
        return defaultDrmSession.loadErrorHandlingPolicy;
    }

    private void dispatchEvent(Consumer consumer) {
        boolean bl2;
        Iterator iterator2 = this.eventDispatchers.elementSet().iterator();
        while (bl2 = iterator2.hasNext()) {
            DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = (DrmSessionEventListener$EventDispatcher)iterator2.next();
            consumer.accept(drmSessionEventListener$EventDispatcher);
        }
    }

    private void doLicense(boolean object) {
        int n10 = this.isPlaceholderSession;
        if (n10 != 0) {
            return;
        }
        byte[] byArray = (byte[])Util.castNonNull(this.sessionId);
        int n11 = this.mode;
        int n12 = 1;
        int n13 = 2;
        if (n11 != 0 && n11 != n12) {
            if (n11 != n13) {
                n10 = 3;
                if (n11 == n10) {
                    Assertions.checkNotNull(this.offlineLicenseKeySetId);
                    byte[] byArray2 = this.sessionId;
                    Assertions.checkNotNull(byArray2);
                    n11 = (int)(this.restoreKeys() ? 1 : 0);
                    if (n11 != 0) {
                        byArray2 = this.offlineLicenseKeySetId;
                        this.postKeyRequest(byArray2, n10, (boolean)object);
                    }
                }
            } else {
                byte[] byArray3 = this.offlineLicenseKeySetId;
                if (byArray3 == null || (n11 = (int)(this.restoreKeys() ? 1 : 0)) != 0) {
                    this.postKeyRequest(byArray, n13, (boolean)object);
                }
            }
        } else {
            Object object2 = this.offlineLicenseKeySetId;
            if (object2 == null) {
                this.postKeyRequest(byArray, n12, (boolean)object);
            } else {
                n11 = this.state;
                n12 = 4;
                if (n11 == n12 || (n11 = (int)(this.restoreKeys() ? 1 : 0)) != 0) {
                    long l10;
                    long l11;
                    long l12 = this.getLicenseDurationRemainingSec();
                    n11 = this.mode;
                    if (n11 == 0 && (n11 = (int)((l11 = l12 - (l10 = (long)60)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) <= 0) {
                        n11 = 88;
                        CharSequence charSequence = new StringBuilder(n11);
                        charSequence.append("Offline license has expired or will expire soon. Remaining seconds: ");
                        charSequence.append(l12);
                        object2 = charSequence.toString();
                        charSequence = TAG;
                        Log.d((String)charSequence, (String)object2);
                        this.postKeyRequest(byArray, n13, (boolean)object);
                    } else {
                        long l13 = 0L;
                        long l14 = l12 - l13;
                        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                        if (object <= 0) {
                            KeysExpiredException keysExpiredException = new KeysExpiredException();
                            this.onError(keysExpiredException);
                        } else {
                            this.state = n12;
                            q q10 = q.a;
                            this.dispatchEvent(q10);
                        }
                    }
                }
            }
        }
    }

    private long getLicenseDurationRemainingSec() {
        UUID uUID = C.WIDEVINE_UUID;
        UUID uUID2 = this.uuid;
        boolean bl2 = uUID.equals(uUID2);
        if (!bl2) {
            return Long.MAX_VALUE;
        }
        uUID = (Pair)Assertions.checkNotNull(WidevineUtil.getLicenseDurationRemainingSec(this));
        long l10 = (Long)((Pair)uUID).first;
        long l11 = (Long)((Pair)uUID).second;
        return Math.min(l10, l11);
    }

    private boolean isOpen() {
        int n10 = this.state;
        int n11 = 3;
        n10 = n10 != n11 && n10 != (n11 = 4) ? 0 : 1;
        return n10 != 0;
    }

    private void onError(Exception exception) {
        Object object = new DrmSession$DrmSessionException(exception);
        this.lastException = object;
        object = new c(exception);
        this.dispatchEvent((Consumer)object);
        int n10 = this.state;
        int n11 = 4;
        if (n10 != n11) {
            this.state = n10 = 1;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onKeyResponse(Object object, Object object2) {
        Object object3 = this.currentKeyRequest;
        if (object != object3) return;
        int n10 = this.isOpen();
        if (n10 == 0) {
            return;
        }
        object = null;
        this.currentKeyRequest = null;
        n10 = object2 instanceof Exception;
        if (n10 != 0) {
            object2 = (Exception)object2;
            this.onKeysError((Exception)object2);
            return;
        }
        try {
            object2 = (byte[])object2;
            n10 = this.mode;
            int n11 = 3;
            if (n10 == n11) {
                object = this.mediaDrm;
                object3 = this.offlineLicenseKeySetId;
                object3 = Util.castNonNull(object3);
                object3 = (byte[])object3;
                object.provideKeyResponse((byte[])object3, (byte[])object2);
                object = b.a;
                this.dispatchEvent((Consumer)object);
                return;
            }
            object = this.mediaDrm;
            object3 = this.sessionId;
            object = object.provideKeyResponse((byte[])object3, (byte[])object2);
            int n12 = this.mode;
            n11 = 2;
            if ((n12 == n11 || n12 == 0 && (object2 = (Object)this.offlineLicenseKeySetId) != null) && object != null && (n12 = ((Object)object).length) != 0) {
                this.offlineLicenseKeySetId = (byte[])object;
            }
            this.state = n10 = 4;
            object = p.a;
            this.dispatchEvent((Consumer)object);
            return;
        }
        catch (Exception exception) {
            this.onKeysError(exception);
        }
    }

    private void onKeysError(Exception object) {
        boolean bl2 = object instanceof NotProvisionedException;
        if (bl2) {
            object = this.provisioningManager;
            object.provisionRequired(this);
        } else {
            this.onError((Exception)object);
        }
    }

    private void onKeysRequired() {
        int n10;
        int n11 = this.mode;
        if (n11 == 0 && (n11 = this.state) == (n10 = 4)) {
            Util.castNonNull(this.sessionId);
            n11 = 0;
            this.doLicense(false);
        }
    }

    private void onProvisionResponse(Object object, Object object2) {
        int n10;
        int n11;
        ExoMediaDrm$ProvisionRequest exoMediaDrm$ProvisionRequest = this.currentProvisionRequest;
        if (object == exoMediaDrm$ProvisionRequest && ((n11 = this.state) == (n10 = 2) || (n11 = (int)(this.isOpen() ? 1 : 0)) != 0)) {
            object = null;
            this.currentProvisionRequest = null;
            n11 = object2 instanceof Exception;
            if (n11 != 0) {
                object = this.provisioningManager;
                object2 = (Exception)object2;
                object.onProvisionError((Exception)object2);
                return;
            }
            object = this.mediaDrm;
            object2 = (byte[])object2;
            try {
                object.provideProvisionResponse((byte[])object2);
                this.provisioningManager.onProvisionCompleted();
                return;
            }
            catch (Exception exception) {
                object2 = this.provisioningManager;
                object2.onProvisionError(exception);
            }
        }
    }

    private boolean openInternal(boolean bl2) {
        block12: {
            int n10 = this.isOpen();
            boolean bl3 = true;
            if (n10 != 0) {
                return bl3;
            }
            Object object = this.mediaDrm;
            object = object.openSession();
            this.sessionId = (byte[])object;
            ExoMediaDrm exoMediaDrm = this.mediaDrm;
            object = exoMediaDrm.createMediaCrypto((byte[])object);
            this.mediaCrypto = object;
            object = k.a;
            this.dispatchEvent((Consumer)object);
            n10 = 3;
            this.state = n10;
            object = this.sessionId;
            try {
                Assertions.checkNotNull(object);
                return bl3;
            }
            catch (Exception exception) {
                this.onError(exception);
            }
            catch (NotProvisionedException notProvisionedException) {
                if (bl2) {
                    DefaultDrmSession$ProvisioningManager defaultDrmSession$ProvisioningManager = this.provisioningManager;
                    defaultDrmSession$ProvisioningManager.provisionRequired(this);
                    break block12;
                }
                this.onError((Exception)((Object)notProvisionedException));
            }
        }
        return false;
    }

    private void postKeyRequest(byte[] object, int n10, boolean bl2) {
        Object object2 = this.mediaDrm;
        List list = this.schemeDatas;
        HashMap hashMap = this.keyRequestParameters;
        object = object2.getKeyRequest((byte[])object, list, n10, hashMap);
        this.currentKeyRequest = object;
        object = (Object)this.requestHandler;
        object = Util.castNonNull(object);
        object = (Object)((DefaultDrmSession$RequestHandler)((Object)object));
        n10 = 1;
        object2 = this.currentKeyRequest;
        object2 = Assertions.checkNotNull(object2);
        try {
            ((DefaultDrmSession$RequestHandler)((Object)object)).post(n10, object2, bl2);
        }
        catch (Exception exception) {
            this.onKeysError(exception);
        }
    }

    private boolean restoreKeys() {
        ExoMediaDrm exoMediaDrm;
        try {
            exoMediaDrm = this.mediaDrm;
        }
        catch (Exception exception) {
            Log.e(TAG, "Error trying to restore keys.", exception);
            this.onError(exception);
            return false;
        }
        byte[] byArray = this.sessionId;
        byte[] byArray2 = this.offlineLicenseKeySetId;
        exoMediaDrm.restoreKeys(byArray, byArray2);
        return true;
    }

    public void acquire(DrmSessionEventListener$EventDispatcher object) {
        CopyOnWriteMultiset copyOnWriteMultiset;
        int n10 = this.referenceCount;
        int n11 = 0;
        int n12 = 1;
        if (n10 >= 0) {
            n10 = n12;
        } else {
            n10 = 0;
            copyOnWriteMultiset = null;
        }
        Assertions.checkState(n10 != 0);
        if (object != null) {
            copyOnWriteMultiset = this.eventDispatchers;
            copyOnWriteMultiset.add(object);
        }
        n10 = this.referenceCount + n12;
        this.referenceCount = n10;
        if (n10 == n12) {
            int n13 = this.state;
            n10 = 2;
            if (n13 == n10) {
                n11 = n12;
            }
            Assertions.checkState(n11 != 0);
            object = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.requestHandlerThread = object;
            object.start();
            copyOnWriteMultiset = this.requestHandlerThread.getLooper();
            object = new DefaultDrmSession$RequestHandler(this, (Looper)copyOnWriteMultiset);
            this.requestHandler = object;
            n13 = (int)(this.openInternal(n12 != 0) ? 1 : 0);
            if (n13 != 0) {
                this.doLicense(n12 != 0);
            }
        } else if (object != null && (n10 = (int)(this.isOpen() ? 1 : 0))) {
            ((DrmSessionEventListener$EventDispatcher)object).drmSessionAcquired();
        }
        object = this.referenceCountListener;
        n10 = this.referenceCount;
        object.onReferenceCountIncremented(this, n10);
    }

    public final DrmSession$DrmSessionException getError() {
        DrmSession$DrmSessionException drmSession$DrmSessionException;
        int n10 = this.state;
        int n11 = 1;
        if (n10 == n11) {
            drmSession$DrmSessionException = this.lastException;
        } else {
            n10 = 0;
            drmSession$DrmSessionException = null;
        }
        return drmSession$DrmSessionException;
    }

    public final ExoMediaCrypto getMediaCrypto() {
        return this.mediaCrypto;
    }

    public byte[] getOfflineLicenseKeySetId() {
        return this.offlineLicenseKeySetId;
    }

    public final UUID getSchemeUuid() {
        return this.uuid;
    }

    public final int getState() {
        return this.state;
    }

    public boolean hasSessionId(byte[] byArray) {
        return Arrays.equals(this.sessionId, byArray);
    }

    public void onMediaDrmEvent(int n10) {
        int n11 = 2;
        if (n10 == n11) {
            this.onKeysRequired();
        }
    }

    public void onProvisionCompleted() {
        boolean bl2 = this.openInternal(false);
        if (bl2) {
            bl2 = true;
            this.doLicense(bl2);
        }
    }

    public void onProvisionError(Exception exception) {
        this.onError(exception);
    }

    public boolean playClearSamplesWithoutKeys() {
        return this.playClearSamplesWithoutKeys;
    }

    public void provision() {
        Object object = this.mediaDrm.getProvisionRequest();
        this.currentProvisionRequest = object;
        object = (DefaultDrmSession$RequestHandler)((Object)Util.castNonNull((Object)this.requestHandler));
        Object object2 = Assertions.checkNotNull(this.currentProvisionRequest);
        ((DefaultDrmSession$RequestHandler)((Object)object)).post(0, object2, true);
    }

    public Map queryKeyStatus() {
        Object object = this.sessionId;
        if (object == null) {
            object = null;
        } else {
            ExoMediaDrm exoMediaDrm = this.mediaDrm;
            object = exoMediaDrm.queryKeyStatus((byte[])object);
        }
        return object;
    }

    public void release(DrmSessionEventListener$EventDispatcher object) {
        Object object2;
        int n10 = this.referenceCount;
        int n11 = 1;
        ExoMediaDrm exoMediaDrm = null;
        if (n10 > 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        Assertions.checkState(n10 != 0);
        this.referenceCount = n10 = this.referenceCount - n11;
        if (n10 == 0) {
            this.state = 0;
            object2 = (DefaultDrmSession$ResponseHandler)((Object)Util.castNonNull((Object)this.responseHandler));
            n11 = 0;
            object2.removeCallbacksAndMessages(null);
            ((DefaultDrmSession$RequestHandler)((Object)Util.castNonNull((Object)this.requestHandler))).release();
            this.requestHandler = null;
            ((HandlerThread)Util.castNonNull(this.requestHandlerThread)).quit();
            this.requestHandlerThread = null;
            this.mediaCrypto = null;
            this.lastException = null;
            this.currentKeyRequest = null;
            this.currentProvisionRequest = null;
            object2 = this.sessionId;
            if (object2 != null) {
                exoMediaDrm = this.mediaDrm;
                exoMediaDrm.closeSession((byte[])object2);
                this.sessionId = null;
            }
            object2 = a.a;
            this.dispatchEvent((Consumer)object2);
        }
        if (object != null) {
            n10 = (int)(this.isOpen() ? 1 : 0);
            if (n10 != 0) {
                ((DrmSessionEventListener$EventDispatcher)object).drmSessionReleased();
            }
            object2 = this.eventDispatchers;
            ((CopyOnWriteMultiset)object2).remove(object);
        }
        object = this.referenceCountListener;
        n10 = this.referenceCount;
        object.onReferenceCountDecremented(this, n10);
    }
}

