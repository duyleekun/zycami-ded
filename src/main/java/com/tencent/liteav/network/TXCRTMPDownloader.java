/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 */
package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.network.TXCRTMPDownloader$1;
import com.tencent.liteav.network.TXCRTMPDownloader$2;
import com.tencent.liteav.network.TXCRTMPDownloader$a;
import com.tencent.liteav.network.TXCStreamDownloader$DownloadStats;
import com.tencent.liteav.network.TXIStreamDownloader;
import com.tencent.liteav.network.TXIStreamDownloader$a;
import com.tencent.liteav.network.e;
import java.util.Vector;

public class TXCRTMPDownloader
extends TXIStreamDownloader {
    private final int MSG_EVENT;
    private final int MSG_RECONNECT;
    private final String TAG;
    private int mConnectCountQuic;
    private int mConnectCountTcp;
    private TXCRTMPDownloader$a mCurrentThread;
    private boolean mEnableNearestIP;
    private Handler mHandler;
    private boolean mHasTcpPlayUrl;
    private boolean mIsPlayRtmpAccStream;
    private int mLastNetworkType;
    private String mPlayUrl;
    private boolean mQuicChannel;
    private Object mRTMPThreadLock;
    private String mServerIp;
    private HandlerThread mThread;
    private Vector mVecPlayUrls;

    public TXCRTMPDownloader(Context object) {
        super((Context)object);
        this.TAG = "network.TXCRTMPDownloader";
        this.MSG_RECONNECT = 101;
        this.MSG_EVENT = 102;
        object = "";
        this.mPlayUrl = object;
        this.mQuicChannel = false;
        this.mServerIp = object;
        this.mCurrentThread = null;
        this.mRTMPThreadLock = null;
        this.mThread = null;
        this.mHandler = null;
        this.mIsPlayRtmpAccStream = false;
        this.mEnableNearestIP = false;
        this.mConnectCountQuic = 0;
        this.mConnectCountTcp = 0;
        this.mLastNetworkType = 0;
        super();
        this.mRTMPThreadLock = object;
    }

    public static /* synthetic */ long access$000(TXCRTMPDownloader tXCRTMPDownloader, String string2, String string3, String string4, boolean bl2, boolean bl3, boolean bl4) {
        return tXCRTMPDownloader.nativeInitRtmpHandler(string2, string3, string4, bl2, bl3, bl4);
    }

    public static /* synthetic */ void access$100(TXCRTMPDownloader tXCRTMPDownloader, long l10) {
        tXCRTMPDownloader.nativeStart(l10);
    }

    public static /* synthetic */ void access$200(TXCRTMPDownloader tXCRTMPDownloader, long l10) {
        tXCRTMPDownloader.nativeUninitRtmpHandler(l10);
    }

    public static /* synthetic */ void access$300(TXCRTMPDownloader tXCRTMPDownloader, long l10) {
        tXCRTMPDownloader.nativeStop(l10);
    }

    public static /* synthetic */ TXCStreamDownloader$DownloadStats access$400(TXCRTMPDownloader tXCRTMPDownloader, long l10) {
        return tXCRTMPDownloader.nativeGetStats(l10);
    }

    public static /* synthetic */ void access$500(TXCRTMPDownloader tXCRTMPDownloader, long l10, String string2) {
        tXCRTMPDownloader.nativeRequestKeyFrame(l10, string2);
    }

    public static /* synthetic */ void access$600(TXCRTMPDownloader tXCRTMPDownloader, boolean bl2) {
        tXCRTMPDownloader.internalReconnect(bl2);
    }

    public static /* synthetic */ void access$700(TXCRTMPDownloader tXCRTMPDownloader) {
        tXCRTMPDownloader.startInternal();
    }

    private void internalReconnect(boolean bl2) {
        Object object;
        String string2;
        Object object2;
        int n10;
        int n11 = this.mIsRunning;
        if (n11 == 0) {
            return;
        }
        n11 = this.mIsPlayRtmpAccStream;
        if (n11 != 0 && (n11 = this.mLastNetworkType) != (n10 = g.d(object2 = this.mApplicationContext))) {
            int n12;
            this.mLastNetworkType = n12 = g.d(this.mApplicationContext);
            TXIStreamDownloader$a tXIStreamDownloader$a = this.mRestartListener;
            if (tXIStreamDownloader$a != null) {
                tXIStreamDownloader$a.onRestartDownloader();
            }
            return;
        }
        n11 = (int)(this.mQuicChannel ? 1 : 0);
        n10 = this.mIsPlayRtmpAccStream;
        int n13 = 1;
        if (n10 != 0) {
            boolean bl3;
            int n14;
            n10 = (int)(this.mEnableNearestIP ? 1 : 0);
            string2 = null;
            if (n10 == 0) {
                boolean bl4 = false;
                object = null;
            }
            if (n11 != 0) {
                n14 = n13;
            }
            if (n14 != 0 && (object = this.mVecPlayUrls) != null && !(bl3 = ((Vector)object).isEmpty())) {
                boolean bl5;
                object = (e)this.mVecPlayUrls.get(0);
                this.mVecPlayUrls.remove(0);
                object2 = ((e)object).a;
                this.mPlayUrl = object2;
                this.mQuicChannel = bl5 = ((e)object).b;
            }
        }
        int n15 = 2103;
        if (n11 != 0 && (n11 = (int)(this.mHasTcpPlayUrl ? 1 : 0)) != 0) {
            this.sendNotifyEvent(n15);
            this.startInternal();
        } else {
            n11 = this.connectRetryTimes;
            n10 = this.connectRetryLimit;
            string2 = "network.TXCRTMPDownloader";
            if (n11 < n10) {
                this.connectRetryTimes = n11 += n13;
                CharSequence charSequence = new StringBuilder();
                charSequence.append("reconnect retry count:");
                n10 = this.connectRetryTimes;
                charSequence.append(n10);
                object2 = " limit:";
                charSequence.append((String)object2);
                n10 = this.connectRetryLimit;
                charSequence.append(n10);
                charSequence = charSequence.toString();
                TXCLog.i(string2, (String)charSequence);
                this.sendNotifyEvent(n15);
                this.startInternal();
            } else {
                object = "reconnect all times retried, send failed event ";
                TXCLog.e(string2, (String)object);
                int n16 = -2301;
                this.sendNotifyEvent(n16);
            }
        }
    }

    private native TXCStreamDownloader$DownloadStats nativeGetStats(long var1);

    private native long nativeInitRtmpHandler(String var1, String var2, String var3, boolean var4, boolean var5, boolean var6);

    private native void nativeRequestKeyFrame(long var1, String var3);

    private native void nativeStart(long var1);

    private native void nativeStop(long var1);

    private native void nativeUninitRtmpHandler(long var1);

    private void postReconnectMsg() {
        int n10;
        Message message = new Message();
        message.what = n10 = 101;
        Handler handler = this.mHandler;
        if (handler != null) {
            int n11 = this.connectRetryInterval * 1000;
            long l10 = n11;
            handler.sendMessageDelayed(message, l10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void reconnect(boolean bl2) {
        Runnable runnable;
        Object object = this.mRTMPThreadLock;
        synchronized (object) {
            runnable = this.mCurrentThread;
            if (runnable != null) {
                runnable.a();
                runnable = null;
                this.mCurrentThread = null;
            }
        }
        object = this.mHandler;
        if (object != null) {
            runnable = new TXCRTMPDownloader$1(this, bl2);
            bl2 = this.connectRetryInterval * 1000;
            long l10 = (long)bl2;
            object.postDelayed(runnable, l10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void startInternal() {
        int n10 = this.mQuicChannel;
        if (n10 != 0) {
            this.mConnectCountQuic = n10 = this.mConnectCountQuic + 1;
        } else {
            this.mConnectCountTcp = n10 = this.mConnectCountTcp + 1;
        }
        Object object = this.mRTMPThreadLock;
        synchronized (object) {
            TXCRTMPDownloader$a tXCRTMPDownloader$a;
            String string2 = this.mPlayUrl;
            boolean bl2 = this.mQuicChannel;
            this.mCurrentThread = tXCRTMPDownloader$a = new TXCRTMPDownloader$a(this, string2, bl2);
            tXCRTMPDownloader$a.start();
            return;
        }
    }

    public int getConnectCountQuic() {
        return this.mConnectCountQuic;
    }

    public int getConnectCountTcp() {
        return this.mConnectCountTcp;
    }

    public String getCurrentStreamUrl() {
        return this.mPlayUrl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TXCStreamDownloader$DownloadStats getDownloadStats() {
        Object object = this.mRTMPThreadLock;
        synchronized (object) {
            TXCRTMPDownloader$a tXCRTMPDownloader$a = this.mCurrentThread;
            if (tXCRTMPDownloader$a == null) return null;
            return tXCRTMPDownloader$a.b();
        }
    }

    public boolean isQuicChannel() {
        return this.mQuicChannel;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void requestKeyFrame(String string2) {
        Object object = this.mRTMPThreadLock;
        synchronized (object) {
            TXCRTMPDownloader$a tXCRTMPDownloader$a = this.mCurrentThread;
            if (tXCRTMPDownloader$a != null) {
                tXCRTMPDownloader$a.a(string2);
            }
            return;
        }
    }

    public void sendNotifyEvent(int n10) {
        int n11 = 1;
        if (n10 != 0 && n10 != n11) {
            super.sendNotifyEvent(n10);
        } else {
            if (n10 != n11) {
                n11 = 0;
            }
            this.reconnect(n11 != 0);
        }
    }

    public void sendNotifyEvent(int n10, String object) {
        boolean bl2 = ((String)object).isEmpty();
        if (bl2) {
            this.sendNotifyEvent(n10);
        } else {
            Bundle bundle = new Bundle();
            String string2 = "EVT_MSG";
            bundle.putString(string2, (String)object);
            long l10 = TXCTimeUtil.getTimeTick();
            bundle.putLong("EVT_TIME", l10);
            l10 = TXCTimeUtil.getUtcTimeTick();
            bundle.putLong("EVT_UTC_TIME", l10);
            object = this.mNotifyListener;
            if (object != null) {
                object.onNotifyEvent(n10, bundle);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public void startDownload(Vector object, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        boolean bl6 = this.mIsRunning;
        if (bl6) {
            return;
        }
        if (object != null && !(bl6 = object.isEmpty())) {
            Object object2;
            void var5_7;
            boolean bl7;
            this.mEnableMessage = bl7;
            this.mEnableMetaData = var5_7;
            this.mIsPlayRtmpAccStream = bl2;
            this.mEnableNearestIP = bl3;
            this.mVecPlayUrls = object;
            object = null;
            this.mHasTcpPlayUrl = false;
            bl2 = 0;
            Object object3 = null;
            while (true) {
                object2 = this.mVecPlayUrls;
                int n10 = ((Vector)object2).size();
                bl7 = true;
                if (bl2 >= n10) break;
                object2 = (e)this.mVecPlayUrls.elementAt(bl2);
                n10 = (int)(((e)object2).b ? 1 : 0);
                if (n10 == 0) {
                    this.mHasTcpPlayUrl = bl7;
                    break;
                }
                ++bl2;
            }
            object3 = (e)this.mVecPlayUrls.get(0);
            this.mVecPlayUrls.remove(0);
            this.mPlayUrl = object2 = ((e)object3).a;
            bl2 = (int)(((e)object3).b ? 1 : 0);
            this.mQuicChannel = bl2;
            this.mIsRunning = bl7;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("start pull with url:");
            object2 = this.mPlayUrl;
            ((StringBuilder)object3).append((String)object2);
            object2 = " quic:";
            ((StringBuilder)object3).append((String)object2);
            boolean bl8 = this.mQuicChannel;
            object2 = bl8 ? "yes" : "no";
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            object2 = "network.TXCRTMPDownloader";
            TXCLog.i((String)object2, (String)object3);
            this.mConnectCountQuic = 0;
            this.mConnectCountTcp = 0;
            this.connectRetryTimes = 0;
            object = this.mThread;
            if (object == null) {
                object3 = "RTMP_PULL";
                object = new HandlerThread((String)object3);
                this.mThread = object;
                object.start();
            }
            object3 = this.mThread.getLooper();
            object = new TXCRTMPDownloader$2(this, (Looper)object3);
            this.mHandler = object;
            this.startInternal();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stopDownload() {
        boolean bl2 = this.mIsRunning;
        if (!bl2) {
            return;
        }
        bl2 = false;
        this.mIsRunning = false;
        this.mVecPlayUrls.removeAllElements();
        Object var2_2 = null;
        this.mVecPlayUrls = null;
        this.mIsPlayRtmpAccStream = false;
        this.mEnableNearestIP = false;
        Object object = "stop pull";
        TXCLog.i("network.TXCRTMPDownloader", (String)object);
        Object object2 = this.mRTMPThreadLock;
        synchronized (object2) {
            object = this.mCurrentThread;
            if (object != null) {
                ((TXCRTMPDownloader$a)object).a();
                this.mCurrentThread = null;
            }
        }
        object2 = this.mThread;
        if (object2 != null) {
            object2.quit();
            this.mThread = null;
        }
        if ((object2 = this.mHandler) != null) {
            this.mHandler = null;
        }
    }
}

