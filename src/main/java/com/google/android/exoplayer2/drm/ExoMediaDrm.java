/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.PersistableBundle
 */
package com.google.android.exoplayer2.drm;

import android.os.PersistableBundle;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnExpirationUpdateListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnKeyStatusChangeListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm$ProvisionRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ExoMediaDrm {
    public static final int EVENT_KEY_EXPIRED = 3;
    public static final int EVENT_KEY_REQUIRED = 2;
    public static final int EVENT_PROVISION_REQUIRED = 1;
    public static final int KEY_TYPE_OFFLINE = 2;
    public static final int KEY_TYPE_RELEASE = 3;
    public static final int KEY_TYPE_STREAMING = 1;

    public void acquire();

    public void closeSession(byte[] var1);

    public ExoMediaCrypto createMediaCrypto(byte[] var1);

    public Class getExoMediaCryptoType();

    public ExoMediaDrm$KeyRequest getKeyRequest(byte[] var1, List var2, int var3, HashMap var4);

    public PersistableBundle getMetrics();

    public byte[] getPropertyByteArray(String var1);

    public String getPropertyString(String var1);

    public ExoMediaDrm$ProvisionRequest getProvisionRequest();

    public byte[] openSession();

    public byte[] provideKeyResponse(byte[] var1, byte[] var2);

    public void provideProvisionResponse(byte[] var1);

    public Map queryKeyStatus(byte[] var1);

    public void release();

    public void restoreKeys(byte[] var1, byte[] var2);

    public void setOnEventListener(ExoMediaDrm$OnEventListener var1);

    public void setOnExpirationUpdateListener(ExoMediaDrm$OnExpirationUpdateListener var1);

    public void setOnKeyStatusChangeListener(ExoMediaDrm$OnKeyStatusChangeListener var1);

    public void setPropertyByteArray(String var1, byte[] var2);

    public void setPropertyString(String var1, String var2);
}

