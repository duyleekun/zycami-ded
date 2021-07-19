/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 */
package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.a;
import com.tencent.liteav.network.TXCStreamDownloader$DownloadStats;
import com.tencent.liteav.network.TXIStreamDownloader$a;
import com.tencent.liteav.network.h;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public abstract class TXIStreamDownloader {
    public int connectRetryInterval;
    public int connectRetryLimit;
    public int connectRetryTimes;
    public Context mApplicationContext = null;
    public boolean mEnableMessage;
    public boolean mEnableMetaData;
    public String mFlvSessionKey;
    public Map mHeaders;
    public boolean mIsRunning = false;
    public h mListener = null;
    public b mNotifyListener = null;
    public String mOriginUrl;
    public TXIStreamDownloader$a mRestartListener = null;
    public String mUserID;

    public TXIStreamDownloader(Context context) {
        int n10;
        String string2;
        this.mOriginUrl = string2 = "";
        this.connectRetryTimes = 0;
        this.connectRetryLimit = n10 = 3;
        this.connectRetryInterval = n10;
        this.mEnableMessage = false;
        this.mEnableMetaData = false;
        this.mFlvSessionKey = string2;
        this.mUserID = string2;
        this.mApplicationContext = context;
    }

    public void PushAudioFrame(byte[] byArray, int n10, long l10, int n11) {
    }

    public void PushVideoFrame(byte[] byArray, int n10, long l10, long l11, int n11) {
    }

    public int getConnectCountQuic() {
        return 0;
    }

    public int getConnectCountTcp() {
        return 0;
    }

    public String getCurrentStreamUrl() {
        return null;
    }

    public long getCurrentTS() {
        return 0L;
    }

    public TXCStreamDownloader$DownloadStats getDownloadStats() {
        return null;
    }

    public String getFlvSessionKey() {
        return this.mFlvSessionKey;
    }

    public long getLastIFrameTS() {
        return 0L;
    }

    public String getRealStreamUrl() {
        return null;
    }

    public boolean isQuicChannel() {
        return false;
    }

    public void onRecvAudioData(byte[] object, int n10, int n11, int n12) {
        Object object2 = this.mListener;
        if (object2 != null) {
            long l10;
            object2 = new a();
            ((a)object2).f = object;
            ((a)object2).e = l10 = (long)n10;
            int n13 = 10;
            n10 = 2;
            if (n11 == n13) {
                n13 = 1;
                ((a)object2).d = n12 == n13 ? n10 : (n13 = 3);
                n13 = ((a)object2).d;
                if (n13 == n10) {
                    ((a)object2).c = n13 = 16;
                }
            }
            if (n11 == n10) {
                ((a)object2).d = n13 = 5;
            }
            ((a)object2).h = n11;
            ((a)object2).g = n12;
            object = this.mListener;
            object.onPullAudio((a)object2);
        }
    }

    public void onRecvMetaData(HashMap object) {
        b b10;
        int n10;
        if (object != null && (n10 = ((HashMap)object).size()) > 0 && (b10 = this.mNotifyListener) != null) {
            b10 = new Bundle();
            String string2 = "EVT_GET_METADATA";
            b10.putSerializable(string2, (Serializable)object);
            object = this.mNotifyListener;
            int n11 = 2028;
            object.onNotifyEvent(n11, (Bundle)b10);
        }
    }

    public void onRecvSEIData(byte[] object) {
        b b10;
        int n10;
        if (object != null && (n10 = ((byte[])object).length) > 0 && (b10 = this.mNotifyListener) != null) {
            b10 = new Bundle();
            String string2 = "EVT_GET_MSG";
            b10.putByteArray(string2, (byte[])object);
            object = this.mNotifyListener;
            int n11 = 2012;
            object.onNotifyEvent(n11, (Bundle)b10);
        }
    }

    public void onRecvVideoData(byte[] object, int n10, long l10, long l11, int n11) {
        Object object2 = this.mListener;
        if (object2 != null) {
            object2 = new TXSNALPacket();
            ((TXSNALPacket)object2).nalData = object;
            ((TXSNALPacket)object2).nalType = n10;
            ((TXSNALPacket)object2).dts = l10;
            ((TXSNALPacket)object2).pts = l11;
            ((TXSNALPacket)object2).codecId = n11;
            object = this.mListener;
            object.onPullNAL((TXSNALPacket)object2);
        }
    }

    public void requestKeyFrame(String string2) {
    }

    public void sendNotifyEvent(int n10) {
        b b10 = this.mNotifyListener;
        if (b10 != null) {
            b10.onNotifyEvent(n10, null);
        }
    }

    public void sendNotifyEvent(int n10, String object) {
        b b10 = this.mNotifyListener;
        if (b10 != null) {
            b10 = new Bundle();
            String string2 = "EVT_MSG";
            b10.putString(string2, (String)object);
            object = this.mNotifyListener;
            object.onNotifyEvent(n10, (Bundle)b10);
        }
    }

    public void setFlvSessionKey(String string2) {
        this.mFlvSessionKey = string2;
    }

    public void setHeaders(Map map) {
        this.mHeaders = map;
    }

    public void setListener(h h10) {
        this.mListener = h10;
    }

    public void setNotifyListener(b b10) {
        this.mNotifyListener = b10;
    }

    public void setOriginUrl(String string2) {
        this.mOriginUrl = string2;
    }

    public void setRestartListener(TXIStreamDownloader$a tXIStreamDownloader$a) {
        this.mRestartListener = tXIStreamDownloader$a;
    }

    public void setUserID(String string2) {
        this.mUserID = string2;
    }

    public abstract void startDownload(Vector var1, boolean var2, boolean var3, boolean var4, boolean var5);

    public abstract void stopDownload();
}

