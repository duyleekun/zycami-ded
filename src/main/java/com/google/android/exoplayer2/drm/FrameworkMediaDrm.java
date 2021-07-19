/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaDrm
 *  android.media.MediaDrm$KeyStatus
 *  android.media.MediaDrm$OnEventListener
 *  android.media.MediaDrm$OnExpirationUpdateListener
 *  android.media.MediaDrm$OnKeyStatusChangeListener
 *  android.media.UnsupportedSchemeException
 *  android.os.PersistableBundle
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import android.os.PersistableBundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ClearKeyUtil;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
import com.google.android.exoplayer2.drm.DummyExoMediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest;
import com.google.android.exoplayer2.drm.ExoMediaDrm$KeyStatus;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnExpirationUpdateListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnKeyStatusChangeListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm$Provider;
import com.google.android.exoplayer2.drm.ExoMediaDrm$ProvisionRequest;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import d.h.a.a.g0.l;
import d.h.a.a.g0.m;
import d.h.a.a.g0.n;
import d.h.a.a.g0.o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class FrameworkMediaDrm
implements ExoMediaDrm {
    private static final String CENC_SCHEME_MIME_TYPE = "cenc";
    public static final ExoMediaDrm$Provider DEFAULT_PROVIDER = m.a;
    private static final String MOCK_LA_URL = "<LA_URL>https://x</LA_URL>";
    private static final String MOCK_LA_URL_VALUE = "https://x";
    private static final String TAG = "FrameworkMediaDrm";
    private static final int UTF_16_BYTES_PER_CHARACTER = 2;
    private final MediaDrm mediaDrm;
    private int referenceCount;
    private final UUID uuid;

    private FrameworkMediaDrm(UUID uUID) {
        MediaDrm mediaDrm;
        Assertions.checkNotNull(uUID);
        boolean bl2 = C.COMMON_PSSH_UUID.equals(uUID);
        int n10 = 1;
        Assertions.checkArgument(bl2 ^= n10, "Use C.CLEARKEY_UUID instead");
        this.uuid = uUID;
        UUID uUID2 = FrameworkMediaDrm.adjustUuid(uUID);
        this.mediaDrm = mediaDrm = new MediaDrm(uUID2);
        this.referenceCount = n10;
        UUID uUID3 = C.WIDEVINE_UUID;
        boolean bl3 = uUID3.equals(uUID);
        if (bl3 && (bl3 = FrameworkMediaDrm.needsForceWidevineL3Workaround())) {
            FrameworkMediaDrm.forceWidevineL3(mediaDrm);
        }
    }

    private /* synthetic */ void a(ExoMediaDrm$OnEventListener exoMediaDrm$OnEventListener, MediaDrm mediaDrm, byte[] byArray, int n10, int n11, byte[] byArray2) {
        exoMediaDrm$OnEventListener.onEvent(this, byArray, n10, n11, byArray2);
    }

    private static byte[] addLaUrlAttributeIfMissing(byte[] object) {
        Object object2 = new ParsableByteArray((byte[])object);
        int s10 = ((ParsableByteArray)object2).readLittleEndianInt();
        int n10 = ((ParsableByteArray)object2).readLittleEndianShort();
        short s11 = ((ParsableByteArray)object2).readLittleEndianShort();
        Object object3 = TAG;
        int n11 = 1;
        if (n10 == n11 && s11 == n11) {
            CharSequence charSequence;
            n11 = ((ParsableByteArray)object2).readLittleEndianShort();
            Charset charset = Charsets.UTF_16LE;
            if ((n11 = (int)(((String)(object2 = ((ParsableByteArray)object2).readString(n11, charset))).contains(charSequence = "<LA_URL>") ? 1 : 0)) != 0) {
                return object;
            }
            object = "</DATA>";
            int n12 = ((String)object2).indexOf((String)object);
            if (n12 == (n11 = -1)) {
                charSequence = "Could not find the </DATA> tag. Skipping LA_URL workaround.";
                Log.w((String)object3, (String)charSequence);
            }
            object3 = ((String)object2).substring(0, n12);
            object = ((String)object2).substring(n12);
            int n13 = String.valueOf(object3).length() + 26;
            n11 = String.valueOf(object).length();
            charSequence = new StringBuilder(n13 += n11);
            ((StringBuilder)charSequence).append((String)object3);
            ((StringBuilder)charSequence).append(MOCK_LA_URL);
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            int n14 = s10 + 52;
            object2 = ByteBuffer.allocate(n14);
            object3 = ByteOrder.LITTLE_ENDIAN;
            ((ByteBuffer)object2).order((ByteOrder)object3);
            ((ByteBuffer)object2).putInt(n14);
            short s12 = (short)n10;
            ((ByteBuffer)object2).putShort(s12);
            short s13 = s11;
            ((ByteBuffer)object2).putShort(s13);
            short s14 = (short)(object.length() * 2);
            ((ByteBuffer)object2).putShort(s14);
            object = object.getBytes(charset);
            ((ByteBuffer)object2).put((byte[])object);
            return ((ByteBuffer)object2).array();
        }
        Log.i((String)object3, "Unexpected record count or type. Skipping LA_URL workaround.");
        return object;
    }

    private static byte[] adjustRequestData(UUID uUID, byte[] byArray) {
        UUID uUID2 = C.CLEARKEY_UUID;
        boolean bl2 = uUID2.equals(uUID);
        if (bl2) {
            return ClearKeyUtil.adjustRequestData(byArray);
        }
        return byArray;
    }

    private static byte[] adjustRequestInitData(UUID object, byte[] byArray) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        int n10;
        int n11;
        Object object2;
        Object object3 = C.PLAYREADY_UUID;
        boolean n112 = ((UUID)object3).equals(object);
        if (n112) {
            object2 = PsshAtomUtil.parseSchemeSpecificData(byArray, (UUID)object);
            if (object2 != null) {
                byArray = object2;
            }
            byArray = FrameworkMediaDrm.addLaUrlAttributeIfMissing(byArray);
            byArray = PsshAtomUtil.buildPsshAtom((UUID)object3, byArray);
        }
        if (((n11 = Util.SDK_INT) < (n10 = 23) && (bl6 = (object2 = (Object)C.WIDEVINE_UUID).equals(object)) || (bl5 = ((UUID)object3).equals(object)) && (bl5 = (object2 = "Amazon").equals(object3 = Util.MANUFACTURER)) && ((bl4 = (object2 = "AFTB").equals(object3 = Util.MODEL)) || (bl3 = (object2 = "AFTS").equals(object3)) || (bl2 = (object2 = "AFTM").equals(object3)) || (bl5 = (object2 = "AFTT").equals(object3)))) && (object = (Object)PsshAtomUtil.parseSchemeSpecificData(byArray, (UUID)object)) != null) {
            return object;
        }
        return byArray;
    }

    private static String adjustRequestMimeType(UUID object, String string2) {
        UUID uUID;
        boolean bl2;
        int n10 = Util.SDK_INT;
        int n11 = 26;
        if (n10 < n11 && (bl2 = (uUID = C.CLEARKEY_UUID).equals(object)) && ((bl2 = ((String)(object = "video/mp4")).equals(string2)) || (bl2 = ((String)(object = "audio/mp4")).equals(string2)))) {
            return CENC_SCHEME_MIME_TYPE;
        }
        return string2;
    }

    private static UUID adjustUuid(UUID uUID) {
        UUID uUID2;
        int n10 = Util.SDK_INT;
        int n11 = 27;
        if (n10 < n11 && (n10 = (int)((uUID2 = C.CLEARKEY_UUID).equals(uUID) ? 1 : 0)) != 0) {
            uUID = C.COMMON_PSSH_UUID;
        }
        return uUID;
    }

    private /* synthetic */ void c(ExoMediaDrm$OnExpirationUpdateListener exoMediaDrm$OnExpirationUpdateListener, MediaDrm mediaDrm, byte[] byArray, long l10) {
        exoMediaDrm$OnExpirationUpdateListener.onExpirationUpdate(this, byArray, l10);
    }

    private /* synthetic */ void e(ExoMediaDrm$OnKeyStatusChangeListener exoMediaDrm$OnKeyStatusChangeListener, MediaDrm object, byte[] byArray, List object2, boolean bl2) {
        boolean bl3;
        object = new ArrayList();
        object2 = object2.iterator();
        while (bl3 = object2.hasNext()) {
            Object object3 = (MediaDrm.KeyStatus)object2.next();
            int n10 = object3.getStatusCode();
            object3 = object3.getKeyId();
            ExoMediaDrm$KeyStatus exoMediaDrm$KeyStatus = new ExoMediaDrm$KeyStatus(n10, (byte[])object3);
            object.add(exoMediaDrm$KeyStatus);
        }
        exoMediaDrm$OnKeyStatusChangeListener.onKeyStatusChange(this, byArray, (List)object, bl2);
    }

    private static void forceWidevineL3(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    public static /* synthetic */ ExoMediaDrm g(UUID object) {
        try {
            return FrameworkMediaDrm.newInstance((UUID)object);
        }
        catch (UnsupportedDrmException unsupportedDrmException) {
            object = String.valueOf(object);
            int n10 = String.valueOf(object).length() + 53;
            StringBuilder stringBuilder = new StringBuilder(n10);
            stringBuilder.append("Failed to instantiate a FrameworkMediaDrm for uuid: ");
            stringBuilder.append((String)object);
            stringBuilder.append(".");
            object = stringBuilder.toString();
            Log.e(TAG, (String)object);
            object = new DummyExoMediaDrm();
            return object;
        }
    }

    private static DrmInitData$SchemeData getSchemeData(UUID object, List list) {
        int n10;
        byte[] byArray;
        int n11;
        Object object2;
        int n12 = C.WIDEVINE_UUID.equals(object);
        if (n12 == 0) {
            return (DrmInitData$SchemeData)list.get(0);
        }
        n12 = Util.SDK_INT;
        int n13 = 28;
        int n14 = 1;
        if (n12 >= n13 && (n12 = list.size()) > n14) {
            Object object3;
            block8: {
                object = (DrmInitData$SchemeData)list.get(0);
                object2 = null;
                n11 = 0;
                byArray = null;
                for (n13 = 0; n13 < (n10 = list.size()); ++n13) {
                    object3 = (DrmInitData$SchemeData)list.get(n13);
                    byte[] byArray2 = (byte[])Assertions.checkNotNull(((DrmInitData$SchemeData)object3).data);
                    String string2 = ((DrmInitData$SchemeData)object3).mimeType;
                    String string3 = ((DrmInitData$SchemeData)object).mimeType;
                    boolean bl2 = Util.areEqual(string2, string3);
                    if (bl2 && (n10 = (int)(Util.areEqual(object3 = ((DrmInitData$SchemeData)object3).licenseServerUrl, string2 = ((DrmInitData$SchemeData)object).licenseServerUrl) ? 1 : 0)) != 0 && (n10 = (int)(PsshAtomUtil.isPsshAtom(byArray2) ? 1 : 0)) != 0) {
                        n10 = byArray2.length;
                        n11 += n10;
                        continue;
                    }
                    n13 = 0;
                    object2 = null;
                    break block8;
                }
                n13 = n14;
            }
            if (n13 != 0) {
                object2 = new byte[n11];
                n11 = 0;
                byArray = null;
                for (n14 = 0; n14 < (n10 = list.size()); ++n14) {
                    object3 = (byte[])Assertions.checkNotNull(((DrmInitData$SchemeData)list.get((int)n14)).data);
                    int n15 = ((Object)object3).length;
                    System.arraycopy(object3, 0, object2, n11, n15);
                    n11 += n15;
                }
                return ((DrmInitData$SchemeData)object).copyWithData((byte[])object2);
            }
        }
        object = null;
        for (n12 = 0; n12 < (n13 = list.size()); ++n12) {
            object2 = (DrmInitData$SchemeData)list.get(n12);
            byArray = (byte[])Assertions.checkNotNull(((DrmInitData$SchemeData)object2).data);
            n11 = PsshAtomUtil.parseVersion(byArray);
            n10 = Util.SDK_INT;
            int n16 = 23;
            if (n10 < n16 && n11 == 0) {
                return object2;
            }
            if (n10 < n16 || n11 != n14) continue;
            return object2;
        }
        return (DrmInitData$SchemeData)list.get(0);
    }

    public static boolean isCryptoSchemeSupported(UUID uUID) {
        return MediaDrm.isCryptoSchemeSupported((UUID)FrameworkMediaDrm.adjustUuid(uUID));
    }

    private static boolean needsForceWidevineL3Workaround() {
        String string2 = Util.MODEL;
        return "ASUS_Z00AD".equals(string2);
    }

    public static FrameworkMediaDrm newInstance(UUID uUID) {
        Object object;
        try {
            object = new FrameworkMediaDrm(uUID);
            return object;
        }
        catch (Exception exception) {
            object = new UnsupportedDrmException(2, exception);
            throw object;
        }
        catch (UnsupportedSchemeException unsupportedSchemeException) {
            object = new UnsupportedDrmException(1, (Exception)((Object)unsupportedSchemeException));
            throw object;
        }
    }

    public void acquire() {
        synchronized (this) {
            int n10;
            int n11;
            block6: {
                n11 = this.referenceCount;
                n10 = 1;
                if (n11 > 0) {
                    n11 = n10;
                    break block6;
                }
                n11 = 0;
                Object var3_3 = null;
            }
            Assertions.checkState(n11 != 0);
            n11 = this.referenceCount + n10;
            this.referenceCount = n11;
            return;
        }
    }

    public /* synthetic */ void b(ExoMediaDrm$OnEventListener exoMediaDrm$OnEventListener, MediaDrm mediaDrm, byte[] byArray, int n10, int n11, byte[] byArray2) {
        this.a(exoMediaDrm$OnEventListener, mediaDrm, byArray, n10, n11, byArray2);
    }

    public void closeSession(byte[] byArray) {
        this.mediaDrm.closeSession(byArray);
    }

    public FrameworkMediaCrypto createMediaCrypto(byte[] byArray) {
        Object object;
        Object object2;
        int n10 = Util.SDK_INT;
        int n11 = 21;
        if (n10 < n11 && (n10 = (int)(((UUID)(object2 = C.WIDEVINE_UUID)).equals(object = this.uuid) ? 1 : 0)) && (n10 = ((String)(object = "L3")).equals(object2 = this.getPropertyString("securityLevel")))) {
            n10 = 1;
        } else {
            n10 = 0;
            object2 = null;
        }
        UUID uUID = FrameworkMediaDrm.adjustUuid(this.uuid);
        object = new FrameworkMediaCrypto(uUID, byArray, n10 != 0);
        return object;
    }

    public /* synthetic */ void d(ExoMediaDrm$OnExpirationUpdateListener exoMediaDrm$OnExpirationUpdateListener, MediaDrm mediaDrm, byte[] byArray, long l10) {
        this.c(exoMediaDrm$OnExpirationUpdateListener, mediaDrm, byArray, l10);
    }

    public /* synthetic */ void f(ExoMediaDrm$OnKeyStatusChangeListener exoMediaDrm$OnKeyStatusChangeListener, MediaDrm mediaDrm, byte[] byArray, List list, boolean bl2) {
        this.e(exoMediaDrm$OnKeyStatusChangeListener, mediaDrm, byArray, list, bl2);
    }

    public Class getExoMediaCryptoType() {
        return FrameworkMediaCrypto.class;
    }

    public ExoMediaDrm$KeyRequest getKeyRequest(byte[] object, List object2, int n10, HashMap object3) {
        int n11;
        boolean bl2;
        boolean bl3;
        Object object4;
        Object object5;
        Object object6;
        int n112 = 0;
        DrmInitData$SchemeData drmInitData$SchemeData = null;
        if (object2 != null) {
            drmInitData$SchemeData = FrameworkMediaDrm.getSchemeData(this.uuid, (List)object2);
            object2 = this.uuid;
            Object object7 = (byte[])Assertions.checkNotNull(drmInitData$SchemeData.data);
            object2 = FrameworkMediaDrm.adjustRequestInitData((UUID)object2, object7);
            object7 = this.uuid;
            object6 = drmInitData$SchemeData.mimeType;
            object7 = FrameworkMediaDrm.adjustRequestMimeType((UUID)object7, (String)object6);
            object5 = object2;
            object4 = object7;
        } else {
            object5 = null;
            object4 = null;
        }
        object6 = this.mediaDrm;
        object = object6.getKeyRequest((byte[])object, object5, object4, n10, (HashMap)object3);
        object2 = this.uuid;
        Object object8 = object.getData();
        object2 = FrameworkMediaDrm.adjustRequestData((UUID)object2, object8);
        object8 = object.getDefaultUrl();
        object3 = MOCK_LA_URL_VALUE;
        boolean n12 = ((String)object3).equals(object8);
        if (n12) {
            object8 = "";
        }
        if ((bl3 = TextUtils.isEmpty((CharSequence)object8)) && drmInitData$SchemeData != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object3 = drmInitData$SchemeData.licenseServerUrl)))) {
            object8 = drmInitData$SchemeData.licenseServerUrl;
        }
        int n13 = (n11 = Util.SDK_INT) >= (n112 = 23) ? object.getRequestType() : -1 << -1;
        object3 = new ExoMediaDrm$KeyRequest((byte[])object2, (String)object8, n13);
        return object3;
    }

    public PersistableBundle getMetrics() {
        int n10 = Util.SDK_INT;
        int n11 = 28;
        if (n10 < n11) {
            return null;
        }
        return this.mediaDrm.getMetrics();
    }

    public byte[] getPropertyByteArray(String string2) {
        return this.mediaDrm.getPropertyByteArray(string2);
    }

    public String getPropertyString(String string2) {
        return this.mediaDrm.getPropertyString(string2);
    }

    public ExoMediaDrm$ProvisionRequest getProvisionRequest() {
        Object object = this.mediaDrm.getProvisionRequest();
        byte[] byArray = object.getData();
        object = object.getDefaultUrl();
        ExoMediaDrm$ProvisionRequest exoMediaDrm$ProvisionRequest = new ExoMediaDrm$ProvisionRequest(byArray, (String)object);
        return exoMediaDrm$ProvisionRequest;
    }

    public byte[] openSession() {
        return this.mediaDrm.openSession();
    }

    public byte[] provideKeyResponse(byte[] byArray, byte[] byArray2) {
        UUID uUID = C.CLEARKEY_UUID;
        UUID uUID2 = this.uuid;
        boolean bl2 = uUID.equals(uUID2);
        if (bl2) {
            byArray2 = ClearKeyUtil.adjustResponseData(byArray2);
        }
        return this.mediaDrm.provideKeyResponse(byArray, byArray2);
    }

    public void provideProvisionResponse(byte[] byArray) {
        this.mediaDrm.provideProvisionResponse(byArray);
    }

    public Map queryKeyStatus(byte[] byArray) {
        return this.mediaDrm.queryKeyStatus(byArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        synchronized (this) {
            int n10;
            this.referenceCount = n10 = this.referenceCount + -1;
            if (n10 == 0) {
                MediaDrm mediaDrm = this.mediaDrm;
                mediaDrm.release();
            }
            return;
        }
    }

    public void restoreKeys(byte[] byArray, byte[] byArray2) {
        this.mediaDrm.restoreKeys(byArray, byArray2);
    }

    public void setOnEventListener(ExoMediaDrm$OnEventListener object) {
        MediaDrm mediaDrm = this.mediaDrm;
        if (object == null) {
            object = null;
        } else {
            n n10 = new n(this, (ExoMediaDrm$OnEventListener)object);
            object = n10;
        }
        mediaDrm.setOnEventListener((MediaDrm.OnEventListener)object);
    }

    public void setOnExpirationUpdateListener(ExoMediaDrm$OnExpirationUpdateListener object) {
        int n10 = Util.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            MediaDrm mediaDrm = this.mediaDrm;
            n11 = 0;
            o o10 = object == null ? null : new o(this, (ExoMediaDrm$OnExpirationUpdateListener)object);
            mediaDrm.setOnExpirationUpdateListener((MediaDrm.OnExpirationUpdateListener)o10, null);
            return;
        }
        object = new UnsupportedOperationException();
        throw object;
    }

    public void setOnKeyStatusChangeListener(ExoMediaDrm$OnKeyStatusChangeListener object) {
        int n10 = Util.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            MediaDrm mediaDrm = this.mediaDrm;
            n11 = 0;
            l l10 = object == null ? null : new l(this, (ExoMediaDrm$OnKeyStatusChangeListener)object);
            mediaDrm.setOnKeyStatusChangeListener((MediaDrm.OnKeyStatusChangeListener)l10, null);
            return;
        }
        object = new UnsupportedOperationException();
        throw object;
    }

    public void setPropertyByteArray(String string2, byte[] byArray) {
        this.mediaDrm.setPropertyByteArray(string2, byArray);
    }

    public void setPropertyString(String string2, String string3) {
        this.mediaDrm.setPropertyString(string2, string3);
    }
}

