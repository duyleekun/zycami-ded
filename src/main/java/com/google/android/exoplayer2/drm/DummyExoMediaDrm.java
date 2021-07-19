/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaDrmException
 *  android.os.PersistableBundle
 */
package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnExpirationUpdateListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnKeyStatusChangeListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm$ProvisionRequest;
import com.google.android.exoplayer2.drm.UnsupportedMediaCrypto;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DummyExoMediaDrm
implements ExoMediaDrm {
    public static DummyExoMediaDrm getInstance() {
        DummyExoMediaDrm dummyExoMediaDrm = new DummyExoMediaDrm();
        return dummyExoMediaDrm;
    }

    public void acquire() {
    }

    public void closeSession(byte[] byArray) {
    }

    public ExoMediaCrypto createMediaCrypto(byte[] object) {
        object = new IllegalStateException;
        object();
        throw object;
    }

    public Class getExoMediaCryptoType() {
        return UnsupportedMediaCrypto.class;
    }

    public ExoMediaDrm$KeyRequest getKeyRequest(byte[] object, List list, int n10, HashMap hashMap) {
        object = new IllegalStateException;
        object();
        throw object;
    }

    public PersistableBundle getMetrics() {
        return null;
    }

    public byte[] getPropertyByteArray(String string2) {
        return Util.EMPTY_BYTE_ARRAY;
    }

    public String getPropertyString(String string2) {
        return "";
    }

    public ExoMediaDrm$ProvisionRequest getProvisionRequest() {
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public byte[] openSession() {
        MediaDrmException mediaDrmException = new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
        throw mediaDrmException;
    }

    public byte[] provideKeyResponse(byte[] object, byte[] byArray) {
        object = new IllegalStateException;
        object();
        throw object;
    }

    public void provideProvisionResponse(byte[] object) {
        object = new IllegalStateException;
        object();
        throw object;
    }

    public Map queryKeyStatus(byte[] object) {
        object = new IllegalStateException;
        object();
        throw object;
    }

    public void release() {
    }

    public void restoreKeys(byte[] object, byte[] byArray) {
        object = new IllegalStateException;
        object();
        throw object;
    }

    public void setOnEventListener(ExoMediaDrm$OnEventListener exoMediaDrm$OnEventListener) {
    }

    public void setOnExpirationUpdateListener(ExoMediaDrm$OnExpirationUpdateListener exoMediaDrm$OnExpirationUpdateListener) {
    }

    public void setOnKeyStatusChangeListener(ExoMediaDrm$OnKeyStatusChangeListener exoMediaDrm$OnKeyStatusChangeListener) {
    }

    public void setPropertyByteArray(String string2, byte[] byArray) {
    }

    public void setPropertyString(String string2, String string3) {
    }
}

