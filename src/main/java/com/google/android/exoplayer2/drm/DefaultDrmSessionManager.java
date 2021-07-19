/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ResourceBusyException
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.exoplayer2.drm;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$1;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$MediaDrmEventListener;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$MediaDrmHandler;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$MissingSchemeDataException;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$ProvisioningManagerImpl;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$ReferenceCountListenerImpl;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSession$DrmSessionException;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ErrorStateDrmSession;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm$AppManagedProvider;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm$Provider;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.drm.UnsupportedMediaCrypto;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class DefaultDrmSessionManager
implements DrmSessionManager {
    public static final long DEFAULT_SESSION_KEEPALIVE_MS = 300000L;
    public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
    private static final String TAG = "DefaultDrmSessionMgr";
    private final MediaDrmCallback callback;
    private ExoMediaDrm exoMediaDrm;
    private final ExoMediaDrm$Provider exoMediaDrmProvider;
    private final Set keepaliveSessions;
    private final HashMap keyRequestParameters;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    public volatile DefaultDrmSessionManager$MediaDrmHandler mediaDrmHandler;
    private int mode;
    private final boolean multiSession;
    private DefaultDrmSession noMultiSessionDrmSession;
    private byte[] offlineLicenseKeySetId;
    private DefaultDrmSession placeholderDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private Looper playbackLooper;
    private int prepareCallsCount;
    private final DefaultDrmSessionManager$ProvisioningManagerImpl provisioningManagerImpl;
    private final List provisioningSessions;
    private final DefaultDrmSessionManager$ReferenceCountListenerImpl referenceCountListener;
    private final long sessionKeepaliveMs;
    private Handler sessionReleasingHandler;
    private final List sessions;
    private final int[] useDrmSessionsForClearContentTrackTypes;
    private final UUID uuid;

    private DefaultDrmSessionManager(UUID collection, ExoMediaDrm$Provider exoMediaDrm$Provider, MediaDrmCallback mediaDrmCallback, HashMap hashMap, boolean bl2, int[] nArray, boolean bl3, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long l10) {
        Assertions.checkNotNull(collection);
        Assertions.checkArgument(C.COMMON_PSSH_UUID.equals(collection) ^ true, "Use C.CLEARKEY_UUID instead");
        this.uuid = collection;
        this.exoMediaDrmProvider = exoMediaDrm$Provider;
        this.callback = mediaDrmCallback;
        this.keyRequestParameters = hashMap;
        this.multiSession = bl2;
        this.useDrmSessionsForClearContentTrackTypes = nArray;
        this.playClearSamplesWithoutKeys = bl3;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        collection = new Collection(this, null);
        this.provisioningManagerImpl = collection;
        collection = new Collection(this, null);
        this.referenceCountListener = collection;
        this.mode = 0;
        this.sessions = collection = new Collection();
        this.provisioningSessions = collection = new Collection();
        collection = Sets.newIdentityHashSet();
        this.keepaliveSessions = collection;
        this.sessionKeepaliveMs = l10;
    }

    public /* synthetic */ DefaultDrmSessionManager(UUID uUID, ExoMediaDrm$Provider exoMediaDrm$Provider, MediaDrmCallback mediaDrmCallback, HashMap hashMap, boolean bl2, int[] nArray, boolean bl3, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long l10, DefaultDrmSessionManager$1 defaultDrmSessionManager$1) {
        this(uUID, exoMediaDrm$Provider, mediaDrmCallback, hashMap, bl2, nArray, bl3, loadErrorHandlingPolicy, l10);
    }

    public DefaultDrmSessionManager(UUID uUID, ExoMediaDrm exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        this(uUID, exoMediaDrm, mediaDrmCallback, hashMap, false, 3);
    }

    public DefaultDrmSessionManager(UUID uUID, ExoMediaDrm exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap hashMap, boolean bl2) {
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        this(uUID, exoMediaDrm, mediaDrmCallback, hashMap, bl2, 3);
    }

    public DefaultDrmSessionManager(UUID uUID, ExoMediaDrm exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap hashMap, boolean bl2, int n10) {
        HashMap hashMap2;
        Object object = exoMediaDrm;
        ExoMediaDrm$AppManagedProvider exoMediaDrm$AppManagedProvider = new ExoMediaDrm$AppManagedProvider(exoMediaDrm);
        if (hashMap == null) {
            object = new HashMap();
            hashMap2 = object;
        } else {
            hashMap2 = hashMap;
        }
        int[] nArray = new int[]{};
        DefaultLoadErrorHandlingPolicy defaultLoadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy(n10);
        object = this;
        this(uUID, exoMediaDrm$AppManagedProvider, mediaDrmCallback, hashMap2, bl2, nArray, false, defaultLoadErrorHandlingPolicy, 300000L);
    }

    public static /* synthetic */ DefaultDrmSession access$1000(DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.placeholderDrmSession;
    }

    public static /* synthetic */ DefaultDrmSession access$1002(DefaultDrmSessionManager defaultDrmSessionManager, DefaultDrmSession defaultDrmSession) {
        defaultDrmSessionManager.placeholderDrmSession = defaultDrmSession;
        return defaultDrmSession;
    }

    public static /* synthetic */ DefaultDrmSession access$1100(DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.noMultiSessionDrmSession;
    }

    public static /* synthetic */ DefaultDrmSession access$1102(DefaultDrmSessionManager defaultDrmSessionManager, DefaultDrmSession defaultDrmSession) {
        defaultDrmSessionManager.noMultiSessionDrmSession = defaultDrmSession;
        return defaultDrmSession;
    }

    public static /* synthetic */ List access$500(DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.sessions;
    }

    public static /* synthetic */ List access$600(DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.provisioningSessions;
    }

    public static /* synthetic */ long access$700(DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.sessionKeepaliveMs;
    }

    public static /* synthetic */ Set access$800(DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.keepaliveSessions;
    }

    public static /* synthetic */ Handler access$900(DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.sessionReleasingHandler;
    }

    private boolean canAcquireSession(DrmInitData object) {
        boolean bl2;
        Object object2 = this.offlineLicenseKeySetId;
        int n10 = 1;
        if (object2 != null) {
            return n10 != 0;
        }
        object2 = this.uuid;
        boolean n11 = (object2 = (Object)DefaultDrmSessionManager.getSchemeDatas((DrmInitData)object, (UUID)object2, n10 != 0)).isEmpty();
        if (n11) {
            Object object3;
            boolean bl3;
            int n12 = ((DrmInitData)object).schemeDataCount;
            if (n12 == n10 && (bl3 = ((DrmInitData$SchemeData)(object2 = ((DrmInitData)object).get(0))).matches((UUID)(object3 = C.COMMON_PSSH_UUID)))) {
                object2 = String.valueOf(this.uuid);
                int n13 = String.valueOf(object2).length() + 72;
                StringBuilder stringBuilder = new StringBuilder(n13);
                stringBuilder.append("DrmInitData only contains common PSSH SchemeData. Assuming support for: ");
                stringBuilder.append((String)object2);
                object2 = stringBuilder.toString();
                object3 = TAG;
                Log.w((String)object3, (String)object2);
            } else {
                return false;
            }
        }
        if ((object = ((DrmInitData)object).schemeType) != null && !(bl2 = ((String)(object2 = "cenc")).equals(object))) {
            boolean bl4;
            object2 = "cbcs";
            boolean bl5 = ((String)object2).equals(object);
            if (bl5) {
                int n14 = Util.SDK_INT;
                int n15 = 25;
                if (n14 < n15) {
                    n10 = 0;
                }
                return n10 != 0;
            }
            object2 = "cbc1";
            boolean bl6 = ((String)object2).equals(object);
            if (!bl6 && !(bl4 = ((String)(object2 = "cens")).equals(object))) {
                return n10 != 0;
            }
            return false;
        }
        return n10 != 0;
    }

    private DefaultDrmSession createAndAcquireSession(List list, boolean bl2, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher) {
        DefaultDrmSession defaultDrmSession;
        Object object;
        Assertions.checkNotNull(this.exoMediaDrm);
        boolean bl3 = this.playClearSamplesWithoutKeys;
        boolean bl4 = bl3 | bl2;
        UUID uUID = this.uuid;
        ExoMediaDrm exoMediaDrm = this.exoMediaDrm;
        DefaultDrmSessionManager$ProvisioningManagerImpl defaultDrmSessionManager$ProvisioningManagerImpl = this.provisioningManagerImpl;
        DefaultDrmSessionManager$ReferenceCountListenerImpl defaultDrmSessionManager$ReferenceCountListenerImpl = this.referenceCountListener;
        int n10 = this.mode;
        byte[] byArray = this.offlineLicenseKeySetId;
        HashMap hashMap = this.keyRequestParameters;
        MediaDrmCallback mediaDrmCallback = this.callback;
        Object object2 = object = Assertions.checkNotNull(this.playbackLooper);
        object2 = (Looper)object;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        object = defaultDrmSession;
        defaultDrmSession = new DefaultDrmSession(uUID, exoMediaDrm, defaultDrmSessionManager$ProvisioningManagerImpl, defaultDrmSessionManager$ReferenceCountListenerImpl, list, n10, bl4, bl2, byArray, hashMap, mediaDrmCallback, (Looper)object2, loadErrorHandlingPolicy);
        object = drmSessionEventListener$EventDispatcher;
        defaultDrmSession.acquire(drmSessionEventListener$EventDispatcher);
        long l10 = this.sessionKeepaliveMs;
        long l11 = -9223372036854775807L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            l12 = 0;
            object = null;
            defaultDrmSession.acquire(null);
        }
        return defaultDrmSession;
    }

    private DefaultDrmSession createAndAcquireSessionWithRetry(List list, boolean bl2, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher) {
        Object object;
        int n10;
        DefaultDrmSession defaultDrmSession = this.createAndAcquireSession(list, bl2, drmSessionEventListener$EventDispatcher);
        int n11 = defaultDrmSession.getState();
        if (n11 == (n10 = 1) && ((n11 = Util.SDK_INT) < (n10 = 19) || (n11 = (object = ((DrmSession$DrmSessionException)Assertions.checkNotNull(defaultDrmSession.getError())).getCause()) instanceof ResourceBusyException) != 0) && (n11 = (int)((object = this.keepaliveSessions).isEmpty() ? 1 : 0)) == 0) {
            object = ImmutableSet.copyOf((Collection)this.keepaliveSessions).iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                DrmSession drmSession = (DrmSession)object.next();
                drmSession.release(null);
            }
            defaultDrmSession.release(drmSessionEventListener$EventDispatcher);
            long l10 = this.sessionKeepaliveMs;
            long l11 = -9223372036854775807L;
            n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            if (n11 != 0) {
                defaultDrmSession.release(null);
            }
            defaultDrmSession = this.createAndAcquireSession(list, bl2, drmSessionEventListener$EventDispatcher);
        }
        return defaultDrmSession;
    }

    private static List getSchemeDatas(DrmInitData drmInitData, UUID uUID, boolean bl2) {
        int n10;
        int n11 = drmInitData.schemeDataCount;
        ArrayList<DrmInitData$SchemeData> arrayList = new ArrayList<DrmInitData$SchemeData>(n11);
        n11 = 0;
        for (int i10 = 0; i10 < (n10 = drmInitData.schemeDataCount); ++i10) {
            Object object;
            DrmInitData$SchemeData drmInitData$SchemeData = drmInitData.get(i10);
            boolean bl3 = drmInitData$SchemeData.matches(uUID);
            if (!(bl3 || (bl3 = ((UUID)(object = C.CLEARKEY_UUID)).equals(uUID)) && (bl3 = drmInitData$SchemeData.matches((UUID)(object = C.COMMON_PSSH_UUID))))) {
                bl3 = false;
                object = null;
            } else {
                bl3 = true;
            }
            if (!bl3 || (object = (Object)drmInitData$SchemeData.data) == null && !bl2) continue;
            arrayList.add(drmInitData$SchemeData);
        }
        return arrayList;
    }

    private void initPlaybackLooper(Looper looper) {
        Looper looper2 = this.playbackLooper;
        if (looper2 == null) {
            this.playbackLooper = looper;
            looper2 = new Handler(looper);
            this.sessionReleasingHandler = looper2;
        } else {
            boolean bl2;
            if (looper2 == looper) {
                bl2 = true;
            } else {
                bl2 = false;
                looper = null;
            }
            Assertions.checkState(bl2);
        }
    }

    private DrmSession maybeAcquirePlaceholderSession(int n10) {
        Object object;
        Object object2 = (ExoMediaDrm)Assertions.checkNotNull(this.exoMediaDrm);
        Object object3 = FrameworkMediaCrypto.class;
        Class clazz = object2.getExoMediaCryptoType();
        int n11 = object3.equals(clazz);
        int n12 = 1;
        if (n11 != 0 && (n11 = FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) != 0) {
            n11 = n12;
        } else {
            n11 = 0;
            object3 = null;
        }
        if (n11 == 0 && (n10 = Util.linearSearch((int[])(object3 = (Object)this.useDrmSessionsForClearContentTrackTypes), n10)) != (n11 = -1) && (n10 = (int)((object = UnsupportedMediaCrypto.class).equals(object2 = object2.getExoMediaCryptoType()) ? 1 : 0)) == 0) {
            object = this.placeholderDrmSession;
            if (object == null) {
                object = ImmutableList.of();
                object = this.createAndAcquireSessionWithRetry((List)object, n12 != 0, null);
                object2 = this.sessions;
                object2.add(object);
                this.placeholderDrmSession = object;
            } else {
                ((DefaultDrmSession)object).acquire(null);
            }
            return this.placeholderDrmSession;
        }
        return null;
    }

    private void maybeCreateMediaDrmHandler(Looper looper) {
        DefaultDrmSessionManager$MediaDrmHandler defaultDrmSessionManager$MediaDrmHandler = this.mediaDrmHandler;
        if (defaultDrmSessionManager$MediaDrmHandler == null) {
            this.mediaDrmHandler = defaultDrmSessionManager$MediaDrmHandler = new DefaultDrmSessionManager$MediaDrmHandler(this, looper);
        }
    }

    public DrmSession acquireSession(Looper object, DrmSessionEventListener$EventDispatcher object2, Format object3) {
        boolean bl2;
        boolean bl3;
        this.initPlaybackLooper((Looper)object);
        this.maybeCreateMediaDrmHandler((Looper)object);
        object = ((Format)object3).drmInitData;
        if (object == null) {
            int n10 = MimeTypes.getTrackType(((Format)object3).sampleMimeType);
            return this.maybeAcquirePlaceholderSession(n10);
        }
        object3 = this.offlineLicenseKeySetId;
        DefaultDrmSession defaultDrmSession = null;
        if (object3 == null) {
            object = (DrmInitData)Assertions.checkNotNull(object);
            object3 = this.uuid;
            bl3 = (object = DefaultDrmSessionManager.getSchemeDatas((DrmInitData)object, (UUID)object3, false)).isEmpty();
            if (bl3) {
                object3 = this.uuid;
                object = new DefaultDrmSessionManager$MissingSchemeDataException((UUID)object3, null);
                if (object2 != null) {
                    ((DrmSessionEventListener$EventDispatcher)object2).drmSessionManagerError((Exception)object);
                }
                object3 = new DrmSession$DrmSessionException((Throwable)object);
                object2 = new ErrorStateDrmSession((DrmSession$DrmSessionException)object3);
                return object2;
            }
        } else {
            bl2 = false;
            object = null;
        }
        if (!(bl3 = this.multiSession)) {
            defaultDrmSession = this.noMultiSessionDrmSession;
        } else {
            boolean bl4;
            object3 = this.sessions.iterator();
            while (bl4 = object3.hasNext()) {
                DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession)object3.next();
                List list = defaultDrmSession2.schemeDatas;
                boolean bl5 = Util.areEqual(list, object);
                if (!bl5) continue;
                defaultDrmSession = defaultDrmSession2;
                break;
            }
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = this.createAndAcquireSessionWithRetry((List)object, false, (DrmSessionEventListener$EventDispatcher)object2);
            bl2 = this.multiSession;
            if (!bl2) {
                this.noMultiSessionDrmSession = defaultDrmSession;
            }
            object = this.sessions;
            object.add(defaultDrmSession);
        } else {
            defaultDrmSession.acquire((DrmSessionEventListener$EventDispatcher)object2);
        }
        return defaultDrmSession;
    }

    public Class getExoMediaCryptoType(Format object) {
        Class<UnsupportedMediaCrypto> clazz = ((ExoMediaDrm)Assertions.checkNotNull(this.exoMediaDrm)).getExoMediaCryptoType();
        Object object2 = ((Format)object).drmInitData;
        if (object2 == null) {
            int n10;
            object = ((Format)object).sampleMimeType;
            int n11 = MimeTypes.getTrackType((String)object);
            object2 = this.useDrmSessionsForClearContentTrackTypes;
            if ((n11 = Util.linearSearch((int[])object2, n11)) == (n10 = -1)) {
                clazz = null;
            }
            return clazz;
        }
        boolean bl2 = this.canAcquireSession((DrmInitData)object2);
        if (!bl2) {
            clazz = UnsupportedMediaCrypto.class;
        }
        return clazz;
    }

    public final void prepare() {
        int n10;
        int n11 = this.prepareCallsCount;
        this.prepareCallsCount = n10 = n11 + 1;
        if (n11 != 0) {
            return;
        }
        Object object = this.exoMediaDrm;
        if (object == null) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        Assertions.checkState(n11 != 0);
        object = this.exoMediaDrmProvider;
        Object object2 = this.uuid;
        this.exoMediaDrm = object = object.acquireExoMediaDrm((UUID)object2);
        object2 = new DefaultDrmSessionManager$MediaDrmEventListener(this, null);
        object.setOnEventListener((ExoMediaDrm$OnEventListener)object2);
    }

    public final void release() {
        int n10;
        this.prepareCallsCount = n10 = this.prepareCallsCount + -1;
        if (n10 != 0) {
            return;
        }
        long l10 = this.sessionKeepaliveMs;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n10 != 0) {
            int n11;
            List list = this.sessions;
            ArrayList arrayList = new ArrayList(list);
            list = null;
            for (int i10 = 0; i10 < (n11 = arrayList.size()); ++i10) {
                DefaultDrmSession defaultDrmSession = (DefaultDrmSession)arrayList.get(i10);
                defaultDrmSession.release(null);
            }
        }
        ((ExoMediaDrm)Assertions.checkNotNull(this.exoMediaDrm)).release();
        this.exoMediaDrm = null;
    }

    public void setMode(int n10, byte[] byArray) {
        List list = this.sessions;
        Assertions.checkState(list.isEmpty());
        int n11 = 1;
        if (n10 == n11 || n10 == (n11 = 3)) {
            Assertions.checkNotNull(byArray);
        }
        this.mode = n10;
        this.offlineLicenseKeySetId = byArray;
    }
}

