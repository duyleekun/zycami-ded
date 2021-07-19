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
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.network.TXCStreamUploader$1;
import com.tencent.liteav.network.TXCStreamUploader$2;
import com.tencent.liteav.network.TXCStreamUploader$3;
import com.tencent.liteav.network.TXCStreamUploader$RtmpProxyUserInfo;
import com.tencent.liteav.network.TXCStreamUploader$UploadStats;
import com.tencent.liteav.network.TXCStreamUploader$a;
import com.tencent.liteav.network.TXCStreamUploader$b;
import com.tencent.liteav.network.a;
import com.tencent.liteav.network.b;
import com.tencent.liteav.network.c;
import com.tencent.liteav.network.l;
import com.tencent.liteav.network.m;
import com.tencent.liteav.network.n;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class TXCStreamUploader
extends com.tencent.liteav.basic.module.a
implements b {
    public static final int RTMPSENDSTRATEGY_LIVE = 1;
    public static final int RTMPSENDSTRATEGY_REALTIME_QUIC = 3;
    public static final int RTMPSENDSTRATEGY_REALTIME_TCP = 2;
    public static final String TAG = "TXCStreamUploader";
    public static final int TXE_UPLOAD_MODE_AUDIO_ONLY = 1;
    public static final int TXE_UPLOAD_MODE_LINK_MIC = 2;
    public static final int TXE_UPLOAD_MODE_REAL_TIME = 0;
    public static final int TXE_UPLOAD_PROTOCOL_AV = 1;
    public static final int TXE_UPLOAD_PROTOCOL_RTMP;
    private final int MSG_EVENT;
    private final int MSG_RECONNECT;
    private final int MSG_REPORT_STATUS;
    private final int MSG_RTMPPROXY_HEARTBEAT;
    private boolean mAudioMuted;
    private int mChannelType;
    private int mConnectCountQuic;
    private int mConnectCountTcp;
    private long mConnectSuccessTimeStamps;
    private Context mContext;
    private int mCurrentRecordIdx;
    private boolean mEnableNearestIP;
    private long mGoodPushTime;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private c mIntelligentRoute;
    private ArrayList mIpList;
    private boolean mIsPushing;
    private int mLastNetworkType;
    private long mLastTimeStamp;
    private TXCStreamUploader$UploadStats mLastUploadStats;
    public HashMap mMetaData;
    private WeakReference mNotifyListener;
    private l mParam;
    private boolean mQuicChannel;
    private int mRetryCount;
    private long mRtmpMsgRecvThreadInstance;
    private Object mRtmpMsgRecvThreadLock;
    private boolean mRtmpProxyEnable;
    private int mRtmpProxyIPIndex;
    private Vector mRtmpProxyIPList;
    private long mRtmpProxyInstance;
    private Object mRtmpProxyLock;
    private TXCStreamUploader$a mRtmpProxyParam;
    private String mRtmpUrl;
    private Thread mThread;
    private Object mThreadLock;
    private n mUploadQualityReport;
    private long mUploaderInstance;
    private Vector mVecPendingNAL;

    static {
        g.f();
    }

    public TXCStreamUploader(Context context, l object) {
        int n10;
        long l10;
        boolean bl2;
        String string2;
        long l11;
        this.mUploaderInstance = l11 = 0L;
        this.mThread = null;
        this.mThreadLock = null;
        this.mIsPushing = false;
        this.mRtmpUrl = string2 = "";
        this.mQuicChannel = false;
        this.mChannelType = 0;
        this.mEnableNearestIP = bl2 = true;
        this.mIntelligentRoute = null;
        this.mLastNetworkType = 0;
        this.mNotifyListener = null;
        this.mContext = null;
        this.mIpList = null;
        this.mCurrentRecordIdx = 0;
        this.mRetryCount = 0;
        this.mConnectSuccessTimeStamps = l11;
        this.mGoodPushTime = l10 = 30000L;
        this.mHandlerThread = null;
        this.mHandler = null;
        this.MSG_RECONNECT = 101;
        this.MSG_EVENT = 102;
        this.MSG_REPORT_STATUS = 103;
        this.MSG_RTMPPROXY_HEARTBEAT = n10 = 104;
        this.mLastTimeStamp = l11;
        this.mLastUploadStats = null;
        Object object2 = new Vector();
        this.mVecPendingNAL = object2;
        this.mParam = null;
        this.mConnectCountQuic = 0;
        this.mConnectCountTcp = 0;
        this.mUploadQualityReport = null;
        this.mRtmpProxyEnable = false;
        this.mAudioMuted = false;
        this.mRtmpProxyParam = object2 = new TXCStreamUploader$a(this);
        object2 = new Vector();
        this.mRtmpProxyIPList = object2;
        this.mRtmpProxyIPIndex = 0;
        this.mRtmpProxyInstance = l11;
        this.mRtmpMsgRecvThreadInstance = l11;
        this.mRtmpProxyLock = object2 = new Object();
        this.mRtmpMsgRecvThreadLock = object2 = new Object();
        this.mContext = context;
        if (object == null) {
            object = new l();
            ((l)object).a = 0;
            ((l)object).g = n10 = 3;
            ((l)object).f = n10;
            ((l)object).h = 40;
            ((l)object).i = n10 = 1000;
            ((l)object).j = bl2;
        }
        this.mParam = object;
        this.mThreadLock = object = new Object();
        this.mIntelligentRoute = object = new c();
        ((c)object).a = this;
        this.mUploaderInstance = l11;
        this.mRetryCount = 0;
        this.mCurrentRecordIdx = 0;
        this.mIpList = null;
        this.mIsPushing = false;
        this.mThread = null;
        this.mRtmpUrl = null;
        this.mLastNetworkType = 0;
        this.mHandlerThread = null;
        this.mUploadQualityReport = object = new n(context);
        m.a().a(context);
    }

    public static /* synthetic */ void access$000(TXCStreamUploader tXCStreamUploader, String string2, boolean bl2, int n10) {
        tXCStreamUploader.startPushTask(string2, bl2, n10);
    }

    public static /* synthetic */ void access$100(TXCStreamUploader tXCStreamUploader) {
        tXCStreamUploader.reportNetStatus();
    }

    public static /* synthetic */ boolean access$1000(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mQuicChannel;
    }

    public static /* synthetic */ boolean access$1002(TXCStreamUploader tXCStreamUploader, boolean bl2) {
        tXCStreamUploader.mQuicChannel = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$1100(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mRtmpProxyEnable;
    }

    public static /* synthetic */ ArrayList access$1200(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mIpList;
    }

    public static /* synthetic */ boolean access$1300(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mAudioMuted;
    }

    public static /* synthetic */ long access$1400(TXCStreamUploader tXCStreamUploader, String string2, String string3, boolean bl2, int n10, int n11, int n12, int n13, int n14, int n15, int n16, boolean bl3, int n17, HashMap hashMap) {
        return tXCStreamUploader.nativeInitUploader(string2, string3, bl2, n10, n11, n12, n13, n14, n15, n16, bl3, n17, hashMap);
    }

    public static /* synthetic */ void access$1500(TXCStreamUploader tXCStreamUploader, long l10, boolean bl2, int n10, int n11) {
        tXCStreamUploader.nativeSetVideoDropParams(l10, bl2, n10, n11);
    }

    public static /* synthetic */ Vector access$1600(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mVecPendingNAL;
    }

    public static /* synthetic */ void access$1700(TXCStreamUploader tXCStreamUploader, long l10, byte[] byArray, int n10, long l11, long l12, long l13) {
        tXCStreamUploader.nativePushNAL(l10, byArray, n10, l11, l12, l13);
    }

    public static /* synthetic */ Object access$1800(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mRtmpProxyLock;
    }

    public static /* synthetic */ long access$1900(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mRtmpProxyInstance;
    }

    public static /* synthetic */ long access$1902(TXCStreamUploader tXCStreamUploader, long l10) {
        tXCStreamUploader.mRtmpProxyInstance = l10;
        return l10;
    }

    public static /* synthetic */ void access$200(TXCStreamUploader tXCStreamUploader) {
        tXCStreamUploader.rtmpProxySendHeartBeat();
    }

    public static /* synthetic */ TXCStreamUploader$a access$2000(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mRtmpProxyParam;
    }

    public static /* synthetic */ long access$2100(TXCStreamUploader tXCStreamUploader, long l10, long l11, String string2, long l12, String string3, long l13, long l14, String string4, boolean bl2, String string5) {
        return tXCStreamUploader.nativeInitRtmpProxyInstance(l10, l11, string2, l12, string3, l13, l14, string4, bl2, string5);
    }

    public static /* synthetic */ Object access$2200(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mRtmpMsgRecvThreadLock;
    }

    public static /* synthetic */ long access$2300(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mRtmpMsgRecvThreadInstance;
    }

    public static /* synthetic */ long access$2302(TXCStreamUploader tXCStreamUploader, long l10) {
        tXCStreamUploader.mRtmpMsgRecvThreadInstance = l10;
        return l10;
    }

    public static /* synthetic */ long access$2400(TXCStreamUploader tXCStreamUploader, long l10, long l11) {
        return tXCStreamUploader.nativeInitRtmpMsgRecvThreadInstance(l10, l11);
    }

    public static /* synthetic */ void access$2500(TXCStreamUploader tXCStreamUploader, long l10) {
        tXCStreamUploader.nativeOnThreadRun(l10);
    }

    public static /* synthetic */ void access$2600(TXCStreamUploader tXCStreamUploader, long l10) {
        tXCStreamUploader.nativeRtmpMsgRecvThreadStop(l10);
    }

    public static /* synthetic */ void access$2700(TXCStreamUploader tXCStreamUploader, long l10) {
        tXCStreamUploader.nativeUninitRtmpMsgRecvThreadInstance(l10);
    }

    public static /* synthetic */ void access$2800(TXCStreamUploader tXCStreamUploader, long l10) {
        tXCStreamUploader.nativeUninitRtmpProxyInstance(l10);
    }

    public static /* synthetic */ void access$2900(TXCStreamUploader tXCStreamUploader, long l10) {
        tXCStreamUploader.nativeUninitUploader(l10);
    }

    public static /* synthetic */ Handler access$300(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mHandler;
    }

    public static /* synthetic */ void access$3000(TXCStreamUploader tXCStreamUploader, boolean bl2) {
        tXCStreamUploader.internalReconnect(bl2);
    }

    public static /* synthetic */ long access$400(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mUploaderInstance;
    }

    public static /* synthetic */ long access$402(TXCStreamUploader tXCStreamUploader, long l10) {
        tXCStreamUploader.mUploaderInstance = l10;
        return l10;
    }

    public static /* synthetic */ n access$500(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mUploadQualityReport;
    }

    public static /* synthetic */ l access$600(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mParam;
    }

    public static /* synthetic */ String access$700(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mRtmpUrl;
    }

    public static /* synthetic */ String access$800(TXCStreamUploader tXCStreamUploader, String string2) {
        return tXCStreamUploader.getAddressFromUrl(string2);
    }

    public static /* synthetic */ Object access$900(TXCStreamUploader tXCStreamUploader) {
        return tXCStreamUploader.mThreadLock;
    }

    private String getAddressFromUrl(String string2) {
        int n10;
        String string3;
        int n11;
        if (string2 != null && (n11 = string2.indexOf(string3 = "://")) != (n10 = -1)) {
            n11 += 3;
            if ((n11 = (string2 = string2.substring(n11)).indexOf(string3 = "/")) != n10) {
                return string2.substring(0, n11);
            }
        }
        return "";
    }

    private boolean getNextRtmpProxyIP() {
        int n10;
        long l10;
        Object object = this.mRtmpProxyParam;
        object.f = 234L;
        object.g = l10 = (long)80;
        object = this.mRtmpProxyIPList;
        int n11 = 0;
        if (object != null && (n10 = object.size()) > 0) {
            int n12;
            n10 = this.mRtmpProxyIPIndex;
            Object object2 = this.mRtmpProxyIPList;
            int n13 = ((Vector)object2).size();
            if (n10 >= n13) {
                this.mRtmpProxyIPIndex = 0;
                return false;
            }
            object = this.mRtmpUrl;
            object2 = "://";
            n13 = ((String[])(object = object.split((String)object2))).length;
            if (n13 < (n12 = 2)) {
                return false;
            }
            n11 = 1;
            object2 = object[n11];
            n10 = object[n11].indexOf("/");
            object = ((String)object2).substring(n10);
            object2 = this.mRtmpProxyIPList;
            n12 = this.mRtmpProxyIPIndex;
            this.mRtmpProxyParam.h = object2 = (String)((Vector)object2).get(n12);
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "room://";
            stringBuilder.append(string2);
            stringBuilder.append((String)object2);
            stringBuilder.append((String)object);
            this.mRtmpUrl = object = stringBuilder.toString();
            this.mQuicChannel = n11;
            this.mRtmpProxyIPIndex = n10 = this.mRtmpProxyIPIndex + n11;
        }
        return n11 != 0;
    }

    private HashMap getParamsFromUrl(String object) {
        int n10;
        Object string2;
        int n11;
        int n12;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string3 = "[?]";
        if ((object = ((String)object).split(string3)) != null && (n12 = ((Object)object).length) >= (n11 = 2) && (string2 = object[n12 = 1]) != null && (n10 = ((String)(string2 = object[n12])).length()) != 0) {
            object = object[n12];
            string2 = "[&]";
            for (String string4 : ((String)object).split((String)string2)) {
                String[] stringArray;
                int n13;
                String string5 = "=";
                int n14 = string4.indexOf(string5);
                if (n14 == (n13 = -1) || (n14 = (stringArray = string4.split(string5 = "[=]")).length) != n11) continue;
                string5 = stringArray[0];
                String string6 = stringArray[n12];
                hashMap.put(string5, string6);
            }
        }
        return hashMap;
    }

    private TXCStreamUploader$b getRtmpRealConnectInfo() {
        int n10 = this.mEnableNearestIP;
        String string2 = null;
        if (n10 == 0) {
            String string3 = this.mRtmpUrl;
            TXCStreamUploader$b tXCStreamUploader$b = new TXCStreamUploader$b(this, string3, false);
            return tXCStreamUploader$b;
        }
        Object object = this.mIpList;
        if (object == null) {
            String string4 = this.mRtmpUrl;
            object = new TXCStreamUploader$b(this, string4, false);
            return object;
        }
        int n11 = this.mCurrentRecordIdx;
        n10 = ((ArrayList)object).size();
        if (n11 < n10 && (n10 = this.mCurrentRecordIdx) >= 0) {
            int n12;
            String string5;
            int n13;
            object = (a)this.mIpList.get(n10);
            Object object2 = this.mRtmpUrl;
            String string6 = "://";
            int n14 = ((String[])(object2 = object2.split(string6))).length;
            if (n14 < (n13 = 2)) {
                object2 = this.mRtmpUrl;
                object = new TXCStreamUploader$b(this, (String)object2, false);
                return object;
            }
            n14 = 1;
            String[] stringArray = object2[n14];
            String string7 = "/";
            stringArray = stringArray.split(string7);
            Object object3 = ((a)object).a;
            String string8 = ":";
            int n15 = ((String[])(object3 = ((String)object3).split(string8))).length;
            if (n15 > n14 && (n15 = (int)(((String)(object3 = ((a)object).a)).startsWith(string5 = "[") ? 1 : 0)) == 0) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string5);
                string8 = ((a)object).a;
                ((StringBuilder)object3).append(string8);
                ((StringBuilder)object3).append("]:");
                string8 = ((a)object).b;
                ((StringBuilder)object3).append(string8);
                stringArray[0] = object3 = ((StringBuilder)object3).toString();
            } else {
                object3 = new StringBuilder();
                string5 = ((a)object).a;
                ((StringBuilder)object3).append(string5);
                ((StringBuilder)object3).append(string8);
                string8 = ((a)object).b;
                ((StringBuilder)object3).append(string8);
                stringArray[0] = object3 = ((StringBuilder)object3).toString();
            }
            string8 = stringArray[0];
            object3 = new StringBuilder(string8);
            while (n14 < (n12 = stringArray.length)) {
                ((StringBuilder)object3).append(string7);
                string8 = stringArray[n14];
                ((StringBuilder)object3).append(string8);
                ++n14;
            }
            StringBuilder stringBuilder = new StringBuilder();
            string2 = object2[0];
            stringBuilder.append(string2);
            stringBuilder.append(string6);
            string2 = ((StringBuilder)object3).toString();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            n10 = (int)(((a)object).c ? 1 : 0);
            object2 = new TXCStreamUploader$b(this, string2, n10 != 0);
            return object2;
        }
        String string9 = this.mRtmpUrl;
        object = new TXCStreamUploader$b(this, string9, false);
        return object;
    }

    private Long getSpeed(long l10, long l11, long l12) {
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object <= 0) {
            l11 -= l10;
        }
        l10 = 0L;
        object = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        if (object > 0) {
            l11 = l11 * (long)8 * 1000L;
            l10 = l11 / (l12 *= 1024L);
        }
        return l10;
    }

    private void internalReconnect(boolean bl2) {
        TXCStreamUploader tXCStreamUploader = this;
        int n10 = this.mIsPushing;
        if (!n10) {
            return;
        }
        n10 = this.mRtmpProxyEnable;
        int n11 = -1324;
        String string2 = ")";
        Object object = " to ";
        CharSequence charSequence = "reconnect network switch from ";
        String string3 = " retry limit:";
        int n12 = 3;
        int n13 = 1102;
        String string4 = "";
        String string5 = TAG;
        int n14 = 2;
        int n15 = 1;
        if (n10) {
            n10 = this.mLastNetworkType;
            Object object2 = this.mContext;
            int n16 = g.d(object2);
            if (n10 != n16) {
                Object object3 = new StringBuilder();
                object3.append((String)charSequence);
                n11 = this.mLastNetworkType;
                object3.append(n11);
                object3.append((String)object);
                n11 = g.d(this.mContext);
                object3.append(n11);
                object3 = object3.toString();
                TXCLog.e(string5, (String)object3);
                n10 = g.d(this.mContext);
                this.mLastNetworkType = n10;
                this.mRetryCount = 0;
                Monitor.a(n14, "WebrtcRoom: need enter again by user", string4, 0);
                object3 = new Object[]{};
                object3 = String.format("Network type has changed. Need to re-enter the room", object3);
                this.sendNotifyEvent(1021, (String)object3);
                return;
            }
            n10 = this.mRetryCount;
            object = this.mParam;
            int n17 = ((l)object).f;
            charSequence = "Network: reconnecting to upload server with quic.[addr:%s][retryCount:%d][retryLimit:%d]";
            if (n10 < n17) {
                Object object4;
                this.mRetryCount = n10 += n15;
                Object object5 = new Object[n12];
                object5[0] = object = this.mRtmpProxyParam.h;
                object5[n15] = object4 = Integer.valueOf(n10);
                n10 = this.mParam.f;
                object5[n14] = object4 = Integer.valueOf(n10);
                object4 = String.format((String)charSequence, object5);
                Monitor.a(n14, (String)object4, string4, 0);
                object2 = this.mRtmpUrl;
                int n18 = 91003;
                long l10 = -1;
                long l11 = -1;
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("reconnect rtmp-proxy server(econnect retry count:");
                n11 = this.mRetryCount;
                ((StringBuilder)object4).append(n11);
                ((StringBuilder)object4).append(string3);
                object5 = this.mParam;
                n11 = object5.f;
                ((StringBuilder)object4).append(n11);
                ((StringBuilder)object4).append(string2);
                String string6 = ((StringBuilder)object4).toString();
                TXCEventRecorderProxy.a((String)object2, n18, l10, l11, string6, 0);
                this.sendNotifyEvent(n13);
                object4 = this.mRtmpUrl;
                n11 = (int)(this.mQuicChannel ? 1 : 0);
                this.startPushTask((String)object4, n11 != 0, 0);
            } else {
                n10 = (int)(this.getNextRtmpProxyIP() ? 1 : 0);
                if (n10) {
                    Object object6;
                    this.mRetryCount = 0;
                    Object object7 = new Object[n12];
                    object7[0] = object6 = this.mRtmpProxyParam.h;
                    object7[n15] = object6 = Integer.valueOf(0);
                    object7[n14] = object6 = Integer.valueOf(this.mParam.f);
                    object7 = String.format((String)charSequence, object7);
                    Monitor.a(n14, (String)object7, string4, 0);
                    this.sendNotifyEvent(n13);
                    object7 = this.mRtmpUrl;
                    n11 = (int)(this.mQuicChannel ? 1 : 0);
                    this.startPushTask((String)object7, n11 != 0, 0);
                } else {
                    string2 = this.mRtmpUrl;
                    n17 = 91002;
                    long l12 = -1;
                    long l13 = -1;
                    string5 = null;
                    string4 = "connect rtmp-proxy server failed(try all addresses)";
                    TXCEventRecorderProxy.a(string2, n17, l12, l13, string4, 0);
                    this.sendNotifyEvent(n11);
                }
            }
        } else {
            String string7;
            long l14;
            long l15;
            int n19;
            Object object8;
            int n20;
            Object object9 = this.mUploadQualityReport;
            ((n)object9).c();
            n10 = (int)(this.mEnableNearestIP ? 1 : 0);
            if (n10 && (n10 = this.mLastNetworkType) != (n20 = g.d(object8 = this.mContext))) {
                object9 = new StringBuilder();
                ((StringBuilder)object9).append((String)charSequence);
                n11 = this.mLastNetworkType;
                ((StringBuilder)object9).append(n11);
                ((StringBuilder)object9).append((String)object);
                n11 = g.d(this.mContext);
                ((StringBuilder)object9).append(n11);
                object9 = ((StringBuilder)object9).toString();
                TXCLog.e(string5, (String)object9);
                n10 = g.d(this.mContext);
                this.mLastNetworkType = n10;
                object9 = this.mIntelligentRoute;
                String string8 = this.mRtmpUrl;
                int n21 = this.mChannelType;
                ((c)object9).a(string8, n21);
                this.mRetryCount = 0;
                return;
            }
            n10 = (int)(tXCStreamUploader.mEnableNearestIP ? 1 : 0);
            if (!n10) {
                n10 = 0;
                object9 = null;
            } else {
                n10 = (int)(bl2 ? 1 : 0);
            }
            int n22 = tXCStreamUploader.mQuicChannel;
            if (n22 == n15) {
                n10 = n15;
            }
            if (n10 == n15 && !(n10 = (int)(tXCStreamUploader.nextRecordIdx(n15 != 0) ? 1 : 0))) {
                object9 = "reconnect: try all addresses failed";
                TXCLog.e(string5, (String)object9);
                object8 = tXCStreamUploader.mRtmpUrl;
                n19 = 91002;
                l15 = -1;
                l14 = -1;
                string7 = "connect upload server failed(try all addresses failed)";
                TXCEventRecorderProxy.a((String)object8, n19, l15, l14, string7, 0);
            }
            object9 = this.getRtmpRealConnectInfo();
            object = ((TXCStreamUploader$b)object9).a;
            object = tXCStreamUploader.getAddressFromUrl((String)object);
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("reconnect change ip: ");
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(" enableNearestIP: ");
            n20 = (int)(tXCStreamUploader.mEnableNearestIP ? 1 : 0);
            ((StringBuilder)charSequence).append(n20 != 0);
            object8 = " last channel type: ";
            ((StringBuilder)charSequence).append((String)object8);
            n20 = tXCStreamUploader.mQuicChannel;
            object8 = n20 != 0 ? "Q Channel" : "TCP";
            ((StringBuilder)charSequence).append((String)object8);
            charSequence = ((StringBuilder)charSequence).toString();
            TXCLog.e(string5, (String)charSequence);
            int n23 = tXCStreamUploader.mQuicChannel;
            if (n23 == n15) {
                TXCLog.e(string5, "reconnect last channel type is Q Channel\uff0cignore retry limit");
                Object object10 = new Object[n15];
                object10[0] = object;
                string2 = "Network: reconnecting to upload server with quic.[addr:%s]";
                object10 = String.format(string2, object10);
                Monitor.a(n14, (String)object10, string4, 0);
                object10 = ((TXCStreamUploader$b)object9).a;
                n10 = (int)(((TXCStreamUploader$b)object9).b ? 1 : 0);
                tXCStreamUploader.startPushTask((String)object10, n10 != 0, 0);
                tXCStreamUploader.sendNotifyEvent(n13);
            } else {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("reconnect retry count:");
                n20 = tXCStreamUploader.mRetryCount;
                ((StringBuilder)charSequence).append(n20);
                ((StringBuilder)charSequence).append(string3);
                n20 = tXCStreamUploader.mParam.f;
                ((StringBuilder)charSequence).append(n20);
                charSequence = ((StringBuilder)charSequence).toString();
                TXCLog.e(string5, (String)charSequence);
                n23 = tXCStreamUploader.mRetryCount;
                object8 = tXCStreamUploader.mParam;
                n20 = object8.f;
                if (n23 < n20) {
                    tXCStreamUploader.mRetryCount = n23 += n15;
                    Object object11 = new Object[n12];
                    object11[0] = object;
                    object11[n15] = object = Integer.valueOf(n23);
                    object11[n14] = object = Integer.valueOf(tXCStreamUploader.mParam.f);
                    object11 = String.format("Network: reconnecting to upload server with tcp.[addr:%s][retryCount:%d][retryLimit:%d]", (Object[])object11);
                    Monitor.a(n14, (String)object11, string4, 0);
                    object8 = tXCStreamUploader.mRtmpUrl;
                    n19 = 91003;
                    l15 = -1;
                    l14 = -1;
                    object11 = new StringBuilder();
                    ((StringBuilder)object11).append("reconnect upload server:(retry count:");
                    n22 = tXCStreamUploader.mRetryCount;
                    ((StringBuilder)object11).append(n22);
                    ((StringBuilder)object11).append(string3);
                    object = tXCStreamUploader.mParam;
                    n22 = ((l)object).f;
                    ((StringBuilder)object11).append(n22);
                    ((StringBuilder)object11).append(string2);
                    string7 = ((StringBuilder)object11).toString();
                    TXCEventRecorderProxy.a((String)object8, n19, l15, l14, string7, 0);
                    object11 = ((TXCStreamUploader$b)object9).a;
                    n10 = ((TXCStreamUploader$b)object9).b;
                    tXCStreamUploader.startPushTask((String)object11, n10 != 0, 0);
                    tXCStreamUploader.sendNotifyEvent(n13);
                } else {
                    object9 = "reconnect: try all times failed";
                    TXCLog.e(string5, (String)object9);
                    String string9 = tXCStreamUploader.mRtmpUrl;
                    n15 = 91002;
                    long l16 = -1;
                    long l17 = -1;
                    String string10 = "connect upload server failed(try all times failed)";
                    TXCEventRecorderProxy.a(string9, n15, l16, l17, string10, 0);
                    tXCStreamUploader.sendNotifyEvent(n11);
                }
            }
        }
    }

    private boolean isQCloudStreamUrl(String string2) {
        boolean bl2;
        int n10;
        String string3;
        int n11;
        return string2 != null && (n11 = string2.length()) != 0 && (n11 = string2.indexOf(string3 = "://")) != (n10 = -1) && (string2 = string2.substring(n11 += 3)) != null && (bl2 = string2.startsWith(string3 = "cloud.tencent.com"));
    }

    private native void nativeCacheJNIParams();

    private native void nativeEnableDrop(long var1, boolean var3);

    private native TXCStreamUploader$UploadStats nativeGetStats(long var1);

    private native long nativeInitRtmpMsgRecvThreadInstance(long var1, long var3);

    private native long nativeInitRtmpProxyInstance(long var1, long var3, String var5, long var6, String var8, long var9, long var11, String var13, boolean var14, String var15);

    private native long nativeInitUploader(String var1, String var2, boolean var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, boolean var11, int var12, HashMap var13);

    private native void nativeOnThreadRun(long var1);

    private native void nativePushAAC(long var1, byte[] var3, long var4);

    private native void nativePushNAL(long var1, byte[] var3, int var4, long var5, long var7, long var9);

    private native void nativeReleaseJNIParams();

    private native void nativeRtmpMsgRecvThreadStart(long var1);

    private native void nativeRtmpMsgRecvThreadStop(long var1);

    private native void nativeRtmpProxyEnterRoom(long var1);

    private native void nativeRtmpProxyLeaveRoom(long var1);

    private native void nativeRtmpProxySendHeartBeat(long var1, long var3, long var5, long var7, long var9, long var11, long var13, long var15, long var17, long var19, long var21);

    private native void nativeSendRtmpProxyMsg(long var1, byte[] var3);

    private native void nativeSetSendStrategy(long var1, int var3, boolean var4);

    private native void nativeSetVideoDropParams(long var1, boolean var3, int var4, int var5);

    private native void nativeStopPush(long var1);

    private native void nativeUninitRtmpMsgRecvThreadInstance(long var1);

    private native void nativeUninitRtmpProxyInstance(long var1);

    private native void nativeUninitUploader(long var1);

    private boolean nextRecordIdx(boolean n10) {
        int n11;
        ArrayList arrayList = this.mIpList;
        if (arrayList != null && (n11 = arrayList.size()) != 0) {
            ArrayList arrayList2;
            int n12;
            n11 = 1;
            if (n10 == n11) {
                Object object = this.mIpList;
                n12 = this.mCurrentRecordIdx;
                object = (a)((ArrayList)object).get(n12);
                ((a)object).e = n12 = ((a)object).e + n11;
            }
            if ((n10 = this.mCurrentRecordIdx + n11) < (n12 = (arrayList2 = this.mIpList).size())) {
                this.mCurrentRecordIdx = n10 = this.mCurrentRecordIdx + n11;
                return n11 != 0;
            }
        }
        return false;
    }

    private void onRtmpProxyRoomEvent(int n10, int n11) {
        int n12 = 1;
        if (n10 == n12) {
            Object object;
            Object object2 = new Object[n12];
            object2[0] = object = Integer.valueOf(n11);
            object = "Already in room\uff0c[%d]";
            object2 = String.format((String)object, object2);
            n11 = 1018;
            this.sendNotifyEvent(n11, (String)object2);
        } else {
            int n13 = 2;
            if (n10 == n13) {
                Object object;
                Object object3 = new Object[n12];
                object3[0] = object = Integer.valueOf(n11);
                object = "Not in the room\uff0c[%d]";
                object3 = String.format((String)object, object3);
                n11 = 1019;
                this.sendNotifyEvent(n11, (String)object3);
            }
        }
    }

    private void onRtmpProxyUserListPushed(TXCStreamUploader$RtmpProxyUserInfo[] object) {
        Object object2;
        if (object == null) {
            return;
        }
        int n10 = this.mIsPushing;
        if (n10 == 0) {
            return;
        }
        n10 = this.mRtmpProxyEnable;
        if (n10 != 0 && (object2 = this.mRtmpProxyParam) != null) {
            object2 = new JSONArray();
            String string2 = new JSONArray();
            int n11 = 0;
            String string3 = null;
            while (true) {
                block28: {
                    JSONObject jSONObject;
                    block27: {
                        int n12 = ((TXCStreamUploader$RtmpProxyUserInfo[])object).length;
                        if (n11 >= n12) break;
                        jSONObject = new JSONObject();
                        String string4 = "userid";
                        Object object3 = object[n11];
                        object3 = object3.account;
                        jSONObject.put(string4, object3);
                        string4 = "playurl";
                        object3 = object[n11];
                        object3 = object3.playUrl;
                        jSONObject.put(string4, object3);
                        string4 = object[n11];
                        int n13 = ((TXCStreamUploader$RtmpProxyUserInfo)string4).stmType;
                        if (n13 != 0) break block27;
                        object2.put((Object)jSONObject);
                        break block28;
                    }
                    string2.put((Object)jSONObject);
                }
                ++n11;
            }
            object = new JSONObject();
            string3 = "userlist";
            object.put(string3, object2);
            object2 = "userlist_aux";
            object.put((String)object2, (Object)string2);
            n10 = 1020;
            object = object.toString();
            try {
                this.sendNotifyEvent(n10, (String)object);
            }
            catch (Exception exception) {
                object2 = "TXCStreamUploader";
                string2 = "build json object failed.";
                TXCLog.e((String)object2, string2, exception);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onSendRtmpProxyMsg(byte[] byArray) {
        Object object = this.mThreadLock;
        synchronized (object) {
            long l10 = this.mUploaderInstance;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 != false) {
                this.nativeSendRtmpProxyMsg(l10, byArray);
            }
            return;
        }
    }

    private void parseProxyInfo(String string2) {
        Object object;
        int n10;
        TXCStreamUploader tXCStreamUploader = this;
        String string3 = string2;
        Object object2 = "_";
        Object object3 = "Key";
        if (string2 != null && (n10 = string2.length()) != 0 && (n10 = (int)(string2.startsWith((String)(object = "room")) ? 1 : 0)) != 0) {
            String string4;
            boolean bl2;
            boolean bl3;
            Object object4;
            boolean bl4;
            object = this.mRtmpProxyParam;
            ((TXCStreamUploader$a)object).i = bl4 = this.isQCloudStreamUrl(string2);
            Object object5 = this.getParamsFromUrl(string2);
            if (object5 == null) {
                return;
            }
            object = "sdkappid";
            boolean bl5 = ((HashMap)object5).containsKey(object);
            if (bl5) {
                long l10;
                object4 = this.mRtmpProxyParam;
                object = Long.valueOf((String)((HashMap)object5).get(object));
                ((TXCStreamUploader$a)object4).a = l10 = ((Long)object).longValue();
            }
            if ((bl5 = ((HashMap)object5).containsKey(object = "roomid")) && (bl3 = ((HashMap)object5).containsKey(object4 = "userid")) && (bl2 = ((HashMap)object5).containsKey(string4 = "roomsig"))) {
                String string5;
                block85: {
                    block84: {
                        block82: {
                            Object object6;
                            block80: {
                                block81: {
                                    block79: {
                                        long l11;
                                        object6 = tXCStreamUploader.mRtmpProxyParam;
                                        ((TXCStreamUploader$a)object6).d = l11 = Long.valueOf((String)((HashMap)object5).get(object)).longValue();
                                        object = tXCStreamUploader.mRtmpProxyParam;
                                        ((TXCStreamUploader$a)object).c = object4 = (String)((HashMap)object5).get(object4);
                                        object = "bizbuf";
                                        bl5 = ((HashMap)object5).containsKey(object);
                                        object6 = "UTF-8";
                                        string5 = "TXCStreamUploader";
                                        if (bl5) {
                                            object = ((HashMap)object5).get(object);
                                            object = (String)object;
                                            object4 = tXCStreamUploader.mRtmpProxyParam;
                                            object = URLDecoder.decode((String)object, (String)object6);
                                            try {
                                                ((TXCStreamUploader$a)object4).j = object;
                                            }
                                            catch (Exception exception) {
                                                object4 = "decode bizbuf failed.";
                                                TXCLog.e(string5, (String)object4, exception);
                                            }
                                        }
                                        object = ((HashMap)object5).get(string4);
                                        object = (String)object;
                                        object = URLDecoder.decode((String)object, (String)object6);
                                        object5 = new JSONObject((String)object);
                                        object = tXCStreamUploader.mRtmpProxyParam;
                                        long l12 = 0L;
                                        ((TXCStreamUploader$a)object).b = l12;
                                        n10 = (int)(object5.has((String)object3) ? 1 : 0);
                                        if (n10 != 0) break block79;
                                        return;
                                    }
                                    object = tXCStreamUploader.mRtmpProxyParam;
                                    object3 = object5.optString((String)object3);
                                    ((TXCStreamUploader$a)object).e = object3;
                                    object = "RtmpProxy";
                                    object = object5.optJSONObject((String)object);
                                    object3 = "Type";
                                    object4 = "Port";
                                    string4 = "Ip";
                                    if (object == null) break block80;
                                    bl2 = object.has(string4);
                                    if (!bl2) break block81;
                                    bl2 = object.has((String)object4);
                                    if (!bl2) break block81;
                                    bl2 = object.has((String)object3);
                                    if (bl2) break block80;
                                }
                                return;
                            }
                            object6 = "AccessList";
                            object5 = object5.optJSONArray((String)object6);
                            bl2 = false;
                            object6 = null;
                            if (object5 == null) break block82;
                            int n11 = object5.length();
                            if (n11 <= 0) break block82;
                            n11 = 0;
                            while (true) {
                                block83: {
                                    int n12 = object5.length();
                                    if (n11 >= n12) break;
                                    Object object7 = object5.getJSONObject(n11);
                                    if (object7 == null) break block83;
                                    boolean bl6 = object7.has(string4);
                                    if (!bl6) break block83;
                                    bl6 = object7.has((String)object4);
                                    if (!bl6) break block83;
                                    bl6 = object7.has((String)object3);
                                    if (!bl6) break block83;
                                    String string6 = object7.optString(string4);
                                    long l13 = object7.optLong((String)object4);
                                    long l14 = object7.optLong((String)object3);
                                    long l15 = 2;
                                    n12 = (int)(l14 == l15 ? 0 : (l14 < l15 ? -1 : 1));
                                    if (n12 == 0) {
                                        object7 = tXCStreamUploader.mRtmpProxyIPList;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append(string6);
                                        string6 = ":";
                                        stringBuilder.append(string6);
                                        stringBuilder.append(l13);
                                        string6 = stringBuilder.toString();
                                        ((Vector)object7).add(string6);
                                    }
                                }
                                ++n11;
                            }
                        }
                        object3 = tXCStreamUploader.mRtmpProxyParam;
                        int n13 = ((TXCStreamUploader$a)object3).i;
                        if (n13 == 0) break block84;
                        if (object == null) {
                            return;
                        }
                        object3 = "?";
                        n13 = string3.indexOf((String)object3);
                        string3 = string3.substring(0, n13);
                        object3 = new StringBuilder();
                        object5 = tXCStreamUploader.mRtmpProxyParam;
                        long l16 = ((TXCStreamUploader$a)object5).a;
                        ((StringBuilder)object3).append(l16);
                        ((StringBuilder)object3).append((String)object2);
                        object5 = tXCStreamUploader.mRtmpProxyParam;
                        l16 = ((TXCStreamUploader$a)object5).d;
                        ((StringBuilder)object3).append(l16);
                        ((StringBuilder)object3).append((String)object2);
                        object2 = tXCStreamUploader.mRtmpProxyParam;
                        object2 = ((TXCStreamUploader$a)object2).c;
                        ((StringBuilder)object3).append((String)object2);
                        object2 = ((StringBuilder)object3).toString();
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append(string3);
                        string3 = "/webrtc/";
                        ((StringBuilder)object3).append(string3);
                        ((StringBuilder)object3).append((String)object2);
                        string3 = "?real_rtmp_ip=";
                        ((StringBuilder)object3).append(string3);
                        string3 = object.optString(string4);
                        ((StringBuilder)object3).append(string3);
                        string3 = "&real_rtmp_port=";
                        ((StringBuilder)object3).append(string3);
                        long l17 = object.optLong((String)object4);
                        ((StringBuilder)object3).append(l17);
                        object = "&tinyid=";
                        ((StringBuilder)object3).append((String)object);
                        object = tXCStreamUploader.mRtmpProxyParam;
                        l17 = ((TXCStreamUploader$a)object).b;
                        ((StringBuilder)object3).append(l17);
                        object = "&srctinyid=0";
                        ((StringBuilder)object3).append((String)object);
                        object = ((StringBuilder)object3).toString();
                        tXCStreamUploader.mRtmpUrl = object;
                        this.getNextRtmpProxyIP();
                        break block85;
                    }
                    tXCStreamUploader.mRtmpUrl = string3;
                    tXCStreamUploader.mQuicChannel = false;
                }
                n10 = 1;
                try {
                    tXCStreamUploader.mRtmpProxyEnable = n10;
                }
                catch (Exception exception) {
                    string3 = "parse proxy info failed.";
                    TXCLog.e(string5, string3, exception);
                }
            }
        }
    }

    private void postReconnectMsg(String string2, boolean bl2, int n10) {
        int n11;
        Message message = new Message();
        message.what = n11 = 101;
        message.obj = string2;
        int n12 = bl2 ? 2 : 1;
        message.arg1 = n12;
        string2 = this.mHandler;
        if (string2 != null) {
            long l10 = n10;
            string2.sendMessageDelayed(message, l10);
        }
    }

    private void reconnect(boolean bl2) {
        this.stopPushTask();
        Handler handler = this.mHandler;
        if (handler != null) {
            TXCStreamUploader$3 tXCStreamUploader$3 = new TXCStreamUploader$3(this, bl2);
            l l10 = this.mParam;
            int n10 = l10.g * 1000;
            long l11 = n10;
            handler.postDelayed((Runnable)tXCStreamUploader$3, l11);
        }
    }

    private void reportNetStatus() {
        int n10;
        long l10;
        long l11;
        long l12;
        Object object;
        TXCStreamUploader tXCStreamUploader = this;
        long l13 = TXCTimeUtil.getTimeTick();
        long l14 = this.mLastTimeStamp;
        long l15 = l13 - l14;
        TXCStreamUploader$UploadStats tXCStreamUploader$UploadStats = this.getUploadStats();
        int n11 = 7007;
        int n12 = 7006;
        int n13 = 7005;
        l14 = 0L;
        Object object2 = l14;
        if (tXCStreamUploader$UploadStats != null) {
            long l16;
            int n14;
            object2 = this.mLastUploadStats;
            if (object2 != null) {
                long l17 = ((TXCStreamUploader$UploadStats)object2).inVideoBytes;
                long l18 = tXCStreamUploader$UploadStats.inVideoBytes;
                object = this;
                n14 = n13;
                l16 = l15;
                long l19 = this.getSpeed(l17, l18, l15);
                l17 = this.mLastUploadStats.inAudioBytes;
                l18 = tXCStreamUploader$UploadStats.inAudioBytes;
                object = this;
                l12 = this.getSpeed(l17, l18, l15);
                l17 = this.mLastUploadStats.outVideoBytes;
                l18 = tXCStreamUploader$UploadStats.outVideoBytes;
                object = this;
                l11 = this.getSpeed(l17, l18, l15);
                l17 = this.mLastUploadStats.outAudioBytes;
                l18 = tXCStreamUploader$UploadStats.outAudioBytes;
                object = this;
                object = this.getSpeed(l17, l18, l15);
                l10 = (Long)object;
                l14 = l19;
            } else {
                n14 = n13;
                l10 = l14;
                l12 = l14;
                l11 = l14;
            }
            Object object3 = tXCStreamUploader$UploadStats.videoCacheLen;
            tXCStreamUploader.setStatusValue(n14, object3);
            object3 = tXCStreamUploader$UploadStats.audioCacheLen;
            tXCStreamUploader.setStatusValue(n12, object3);
            object3 = tXCStreamUploader$UploadStats.videoDropCount;
            tXCStreamUploader.setStatusValue(n11, object3);
            long l20 = tXCStreamUploader$UploadStats.audioDropCount;
            object3 = l20;
            tXCStreamUploader.setStatusValue(7008, object3);
            Object object4 = tXCStreamUploader$UploadStats.bandwidthEst;
            tXCStreamUploader.setStatusValue(7021, object4);
            object4 = tXCStreamUploader$UploadStats.startTS;
            tXCStreamUploader.setStatusValue(7009, object4);
            object4 = tXCStreamUploader$UploadStats.dnsTS;
            tXCStreamUploader.setStatusValue(7010, object4);
            l16 = tXCStreamUploader$UploadStats.connTS;
            object4 = l16;
            tXCStreamUploader.setStatusValue(7011, object4);
            object4 = String.valueOf(tXCStreamUploader$UploadStats.serverIP);
            tXCStreamUploader.setStatusValue(7012, object4);
            n10 = 7013;
            n13 = (int)(tXCStreamUploader.mQuicChannel ? 1 : 0);
            l16 = n13 != 0 ? (long)2 : 1L;
            object4 = l16;
            tXCStreamUploader.setStatusValue(n10, object4);
            object4 = tXCStreamUploader$UploadStats.connectionID;
            tXCStreamUploader.setStatusValue(7014, object4);
            n10 = 7015;
            object4 = tXCStreamUploader$UploadStats.connectionStats;
            tXCStreamUploader.setStatusValue(n10, object4);
            object3 = tXCStreamUploader.mUploadQualityReport;
            l16 = tXCStreamUploader$UploadStats.videoDropCount;
            l15 = tXCStreamUploader$UploadStats.audioDropCount;
            ((n)object3).a(l16, l15);
            object3 = tXCStreamUploader.mUploadQualityReport;
            l16 = tXCStreamUploader$UploadStats.videoCacheLen;
            l15 = tXCStreamUploader$UploadStats.audioCacheLen;
            ((n)object3).b(l16, l15);
        } else {
            int n15 = n13;
            this.setStatusValue(n13, object2);
            this.setStatusValue(n12, object2);
            this.setStatusValue(n11, object2);
            int n16 = 7008;
            this.setStatusValue(n16, object2);
            l10 = l14;
            l12 = l14;
            l11 = l14;
        }
        n10 = 7001;
        object = l14;
        tXCStreamUploader.setStatusValue(n10, object);
        Long l21 = l12;
        tXCStreamUploader.setStatusValue(7002, l21);
        l21 = l11;
        tXCStreamUploader.setStatusValue(7003, l21);
        int n17 = 7004;
        l21 = l10;
        tXCStreamUploader.setStatusValue(n17, l21);
        tXCStreamUploader.mLastTimeStamp = l13;
        tXCStreamUploader.mLastUploadStats = tXCStreamUploader$UploadStats;
        object = tXCStreamUploader.mHandler;
        if (object != null) {
            int n18 = 103;
            l10 = 2000L;
            object.sendEmptyMessageDelayed(n18, l10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void rtmpProxySendHeartBeat() {
        Object object = g.a();
        long l10 = object[0] / 10;
        long l11 = object[1] / 10;
        long l12 = TXCStatus.c(this.getID(), 7004);
        long l13 = TXCStatus.c(this.getID(), 7003);
        long l14 = TXCStatus.c(this.getID(), 1001);
        long l15 = TXCStatus.c(this.getID(), 4001);
        object = this.getID();
        int n10 = 7006;
        long l16 = TXCStatus.c((String)object, n10);
        Object object2 = this.getID();
        long l17 = l16;
        l16 = TXCStatus.c((String)object2, 7005);
        object2 = this.getID();
        long l18 = l16;
        l16 = TXCStatus.c((String)object2, 7008);
        object2 = this.getID();
        long l19 = l16;
        int n11 = TXCStatus.c((String)object2, 7007);
        l16 = n11;
        object2 = this.mRtmpProxyLock;
        synchronized (object2) {
            long l20 = l15;
            try {
                l15 = this.mRtmpProxyInstance;
            }
            finally {
                Object object3 = object2;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void sendNotifyEvent(int n10) {
        Object object;
        WeakReference weakReference;
        long l10;
        block21: {
            block22: {
                block23: {
                    block24: {
                        block25: {
                            block26: {
                                block27: {
                                    block28: {
                                        block29: {
                                            block30: {
                                                if (n10 == 0) {
                                                    n10 = 0;
                                                    Object var2_2 = null;
                                                    this.reconnect(false);
                                                    return;
                                                }
                                                int n11 = 1;
                                                if (n10 == n11) {
                                                    this.reconnect(n11 != 0);
                                                    return;
                                                }
                                                n11 = 1001;
                                                if (n10 == n11) {
                                                    this.mConnectSuccessTimeStamps = l10 = TXCTimeUtil.getTimeTick();
                                                }
                                                l10 = 2000L;
                                                int n12 = 104;
                                                int n13 = 1026;
                                                if (n10 == n13) {
                                                    long l11;
                                                    n10 = (int)(this.mRtmpProxyEnable ? 1 : 0);
                                                    if (n10 == 0) return;
                                                    Object object2 = this.mRtmpMsgRecvThreadLock;
                                                    synchronized (object2) {
                                                        l11 = this.mRtmpMsgRecvThreadInstance;
                                                        this.nativeRtmpMsgRecvThreadStart(l11);
                                                    }
                                                    Object object3 = this.mRtmpProxyLock;
                                                    synchronized (object3) {
                                                        l11 = this.mRtmpProxyInstance;
                                                        this.nativeRtmpProxyEnterRoom(l11);
                                                    }
                                                    object2 = this.mHandler;
                                                    if (object2 == null) return;
                                                    object2.sendEmptyMessageDelayed(n12, l10);
                                                    return;
                                                }
                                                weakReference = this.mNotifyListener;
                                                if (weakReference == null) return;
                                                weakReference = new Bundle();
                                                int n14 = -2308;
                                                if (n10 == n14) break block22;
                                                n14 = -1307;
                                                if (n10 == n14) break block23;
                                                if (n10 == n13) {
                                                    long l12;
                                                    n10 = (int)(this.mRtmpProxyEnable ? 1 : 0);
                                                    if (n10 == 0) return;
                                                    Object object4 = this.mRtmpMsgRecvThreadLock;
                                                    synchronized (object4) {
                                                        l12 = this.mRtmpMsgRecvThreadInstance;
                                                        this.nativeRtmpMsgRecvThreadStart(l12);
                                                    }
                                                    Object object5 = this.mRtmpProxyLock;
                                                    synchronized (object5) {
                                                        l12 = this.mRtmpProxyInstance;
                                                        this.nativeRtmpProxyEnterRoom(l12);
                                                    }
                                                    object4 = this.mHandler;
                                                    if (object4 == null) return;
                                                    object4.sendEmptyMessageDelayed(n12, l10);
                                                    return;
                                                }
                                                int n15 = 3003;
                                                if (n10 == n15) break block24;
                                                n15 = -1325;
                                                if (n10 == n15) break block25;
                                                n15 = -1324;
                                                if (n10 == n15) break block26;
                                                if (n10 == n11) break block27;
                                                n11 = 1002;
                                                if (n10 == n11) break block28;
                                                n11 = 1101;
                                                if (n10 == n11) break block29;
                                                n11 = 1102;
                                                if (n10 == n11) break block30;
                                                n11 = 3008;
                                                if (n10 != n11) {
                                                    n11 = 3009;
                                                    if (n10 != n11) {
                                                        object = "EVT_MSG";
                                                        String string2 = "UNKNOWN";
                                                        weakReference.putString((String)object, string2);
                                                        break block21;
                                                    } else {
                                                        object = "EVT_MSG";
                                                        String string3 = "Failed to connect server";
                                                        weakReference.putString((String)object, string3);
                                                    }
                                                    break block21;
                                                } else {
                                                    object = "EVT_MSG";
                                                    String string4 = "No data is sent for more than 30s. Actively disconnect";
                                                    weakReference.putString((String)object, string4);
                                                }
                                                break block21;
                                            }
                                            object = "EVT_MSG";
                                            String string5 = "Enables network reconnection";
                                            weakReference.putString((String)object, string5);
                                            break block21;
                                        }
                                        object = "EVT_MSG";
                                        String string6 = "Insufficient upstream bandwidth. Data transmission is not timely";
                                        weakReference.putString((String)object, string6);
                                        break block21;
                                    }
                                    object = "EVT_MSG";
                                    String string7 = "rtmp start push stream";
                                    weakReference.putString((String)object, string7);
                                    break block21;
                                }
                                object = "EVT_MSG";
                                String string8 = "Already connected to rtmp server";
                                weakReference.putString((String)object, string8);
                                break block21;
                            }
                            object = "EVT_MSG";
                            String string9 = "Failed to connect all IPs, abort connection.";
                            weakReference.putString((String)object, string9);
                            break block21;
                        }
                        object = "EVT_MSG";
                        String string10 = "No internet. Please check if WiFi or mobile data is turned on";
                        weakReference.putString((String)object, string10);
                        break block21;
                    }
                    object = "EVT_MSG";
                    String string11 = "RTMP servers handshake failed";
                    weakReference.putString((String)object, string11);
                    break block21;
                }
                object = "EVT_MSG";
                String string12 = "failed to connect server for several times, abort connection";
                weakReference.putString((String)object, string12);
                break block21;
            }
            object = "EVT_MSG";
            String string13 = "The server rejects the connection request. It may be that the push URL has been occupied or expired, or the anti-leech link is wrong.";
            weakReference.putString((String)object, string13);
        }
        l10 = TXCTimeUtil.getTimeTick();
        weakReference.putLong("EVT_TIME", l10);
        l10 = TXCTimeUtil.getUtcTimeTick();
        weakReference.putLong("EVT_UTC_TIME", l10);
        object = this.mNotifyListener;
        g.a((WeakReference)object, n10, (Bundle)weakReference);
    }

    private void sendNotifyEvent(int n10, String object) {
        long l10;
        Object object2;
        boolean bl2;
        if (object != null && !(bl2 = ((String)object).isEmpty())) {
            object2 = new Bundle();
            String string2 = "EVT_MSG";
            object2.putString(string2, (String)object);
            l10 = TXCTimeUtil.getTimeTick();
            object2.putLong("EVT_TIME", l10);
            l10 = TXCTimeUtil.getUtcTimeTick();
            object2.putLong("EVT_UTC_TIME", l10);
            object = this.mNotifyListener;
            g.a((WeakReference)object, n10, (Bundle)object2);
        } else {
            this.sendNotifyEvent(n10);
        }
        int n11 = 1002;
        if (n10 == n11) {
            TXCStreamUploader$UploadStats tXCStreamUploader$UploadStats = this.getUploadStats();
            if (tXCStreamUploader$UploadStats != null) {
                object2 = this.mUploadQualityReport;
                l10 = tXCStreamUploader$UploadStats.dnsparseTimeCost;
                long l11 = tXCStreamUploader$UploadStats.connectTimeCost;
                long l12 = tXCStreamUploader$UploadStats.handshakeTimeCost;
                ((n)object2).a(l10, l11, l12);
            }
        } else {
            n11 = 1101;
            if (n10 == n11) {
                n n12 = this.mUploadQualityReport;
                n12.d();
            }
        }
    }

    private void startPushTask(String string2, boolean n10, int n11) {
        Object object = "TXCStreamUploader";
        Object object2 = "start push task";
        TXCLog.i((String)object, (String)object2);
        n11 = (int)(this.mQuicChannel ? 1 : 0);
        int n12 = 1;
        if (n11 != n10 && n11 == n12) {
            Object object3;
            n11 = 2;
            Object object4 = new Object[n11];
            object4[0] = object3 = Integer.valueOf(this.mRetryCount);
            int n13 = this.mParam.f;
            object4[n12] = object3 = Integer.valueOf(n13);
            object4 = String.format("Network: switch push channel from quic to tcp.[retryCount:%d][retryLimit:%d]", object4);
            object3 = "";
            Monitor.a(n11, (String)object4, (String)object3, 0);
        }
        if (n10 != 0) {
            int n14;
            n11 = 7017;
            this.mConnectCountQuic = n14 = this.mConnectCountQuic + n12;
            long l10 = n14;
            object2 = l10;
            this.setStatusValue(n11, object2);
        } else {
            int n15;
            n11 = 7018;
            this.mConnectCountTcp = n15 = this.mConnectCountTcp + n12;
            long l11 = n15;
            object2 = l11;
            this.setStatusValue(n11, object2);
        }
        this.mThread = object = new TXCStreamUploader$2(this, "RTMPUpload", n10 != 0, string2);
        ((Thread)object).start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void stopPushTask() {
        Object object = "stop push task";
        TXCLog.i("TXCStreamUploader", (String)object);
        Object object2 = this.mThreadLock;
        synchronized (object2) {
            object = this.mVecPendingNAL;
            ((Vector)object).removeAllElements();
            long l10 = this.mUploaderInstance;
            this.nativeStopPush(l10);
            return;
        }
    }

    private void tryResetRetryCount() {
        long l10 = this.mConnectSuccessTimeStamps;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l10 = TXCTimeUtil.getTimeTick();
            long l13 = this.mConnectSuccessTimeStamps;
            l10 -= l13;
            l l14 = this.mParam;
            int n10 = l14.f;
            int n11 = l14.g + 13;
            l13 = n10 = n10 * n11 * 1000;
            long l15 = l10 - l13;
            object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object > 0) {
                object = 0;
                this.mRetryCount = 0;
                this.mConnectSuccessTimeStamps = l11;
                String string2 = "TXCStreamUploader";
                String string3 = "reset retry count";
                TXCLog.i(string2, string3);
            }
        }
    }

    public String getConfusionIP(String string2) {
        String string3;
        int n10;
        int n11;
        CharSequence charSequence;
        int n12;
        if (string2 != null && (n12 = string2.indexOf((String)(charSequence = "."))) != (n11 = -1) && (n10 = (string3 = string2.substring(++n12)).indexOf((String)charSequence)) != n11) {
            string2 = string3.substring(++n10);
            charSequence = new StringBuilder();
            string3 = "A.B.";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TXCStreamUploader$UploadStats getUploadStats() {
        Object object = this.mThreadLock;
        synchronized (object) {
            long l10 = this.mUploaderInstance;
            TXCStreamUploader$UploadStats tXCStreamUploader$UploadStats = this.nativeGetStats(l10);
            if (tXCStreamUploader$UploadStats != null) {
                boolean bl2 = this.mQuicChannel;
                boolean bl3 = true;
                long l11 = bl2 == bl3 ? (long)2 : 1L;
                tXCStreamUploader$UploadStats.channelType = l11;
            }
            return tXCStreamUploader$UploadStats;
        }
    }

    public int init() {
        return 0;
    }

    /*
     * Unable to fully structure code
     */
    public void onFetchDone(int var1_1, ArrayList var2_2) {
        var3_3 = this.mIsPushing;
        if (!var3_3) {
            return;
        }
        var3_3 = false;
        if (var2_2 == null) ** GOTO lbl-1000
        var4_4 = new StringBuilder();
        var4_4.append("onFetchDone: code = ");
        var4_4.append(var1_1);
        var4_4.append(" ip count = ");
        var5_5 = var2_2.size();
        var4_4.append(var5_5);
        var4_4 = var4_4.toString();
        var6_6 = "TXCStreamUploader";
        TXCLog.e((String)var6_6, (String)var4_4);
        if (var1_1 == 0) {
            this.mIpList = var2_2;
            var1_1 = var2_2.size();
            this.mCurrentRecordIdx = 0;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 = 0;
            var7_7 = null;
        }
        if (var1_1 > 0) {
            var7_7 = this.mIpList.iterator();
            var2_2 = "";
            var8_8 = 0;
            var4_4 = null;
            while ((var5_5 = (int)var7_7.hasNext()) != 0) {
                var6_6 = (a)var7_7.next();
                if (var6_6 != null && (var9_9 = var6_6.c) != 0 && (var10_10 = var6_6.a) != null && (var9_9 = var10_10.length()) > 0) {
                    ++var8_8;
                }
                if (var6_6 == null) continue;
                var10_10 = new StringBuilder();
                var10_10.append((String)var2_2);
                var10_10.append(" ");
                var2_2 = var6_6.a;
                var2_2 = this.getConfusionIP((String)var2_2);
                var10_10.append((String)var2_2);
                var10_10.append(":");
                var2_2 = var6_6.b;
                var10_10.append((String)var2_2);
                var2_2 = var10_10.toString();
            }
            var11_11 = var8_8;
            var4_4 = var11_11;
            this.setStatusValue(7016, var4_4);
            var1_1 = 7019;
            var4_4 = new StringBuilder();
            var6_6 = "{";
            var4_4.append((String)var6_6);
            var4_4.append((String)var2_2);
            var4_4.append(" }");
            var2_2 = var4_4.toString();
            this.setStatusValue(var1_1, var2_2);
        }
        var7_7 = this.getRtmpRealConnectInfo();
        var2_2 = var7_7.a;
        var1_1 = (int)var7_7.b;
        this.postReconnectMsg((String)var2_2, (boolean)var1_1, 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void pushAAC(byte[] byArray, long l10) {
        this.tryResetRetryCount();
        Object object = this.mThreadLock;
        synchronized (object) {
            boolean bl2 = this.mAudioMuted;
            if (!bl2 || !(bl2 = this.mRtmpProxyEnable)) {
                long l11 = this.mUploaderInstance;
                this.nativePushAAC(l11, byArray, l10);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void pushNAL(TXSNALPacket tXSNALPacket) {
        this.tryResetRetryCount();
        Object object = this.mThreadLock;
        synchronized (object) {
            long l10 = this.mUploaderInstance;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 != false) {
                byte[] byArray;
                if (tXSNALPacket != null && (byArray = tXSNALPacket.nalData) != null && (l12 = (long)byArray.length) > 0) {
                    int n10 = tXSNALPacket.nalType;
                    long l13 = tXSNALPacket.frameIndex;
                    long l14 = tXSNALPacket.pts;
                    long l15 = tXSNALPacket.dts;
                    TXCStreamUploader tXCStreamUploader = this;
                    this.nativePushNAL(l10, byArray, n10, l13, l14, l15);
                }
            } else {
                Vector vector;
                l12 = tXSNALPacket.nalType;
                if (l12 == false) {
                    vector = this.mVecPendingNAL;
                    vector.removeAllElements();
                }
                vector = this.mVecPendingNAL;
                vector.add(tXSNALPacket);
            }
            return;
        }
    }

    public void setAudioInfo(int n10, int n11) {
        l l10 = this.mParam;
        if (l10 != null) {
            l10.d = n11;
            l10.e = n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setAudioMute(boolean bl2) {
        Object object = this.mThreadLock;
        synchronized (object) {
            long l10;
            long l11;
            long l12;
            this.mAudioMuted = bl2;
            bl2 = this.mRtmpProxyEnable;
            if (bl2 && (bl2 = (l12 = (l11 = this.mUploaderInstance) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
                l l13 = this.mParam;
                bl2 = l13.m;
                bl2 = bl2 ? ((bl2 = this.mQuicChannel) ? 3 : 2) : true;
                this.nativeSetSendStrategy(l11, (int)(bl2 ? 1 : 0), false);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setDropEanble(boolean bl2) {
        Object object = "TXCStreamUploader";
        CharSequence charSequence = new StringBuilder();
        String string2 = "drop enable ";
        charSequence.append(string2);
        string2 = bl2 ? "yes" : "no";
        charSequence.append(string2);
        charSequence = charSequence.toString();
        TXCLog.i((String)object, (String)charSequence);
        object = this.mThreadLock;
        synchronized (object) {
            long l10 = this.mUploaderInstance;
            this.nativeEnableDrop(l10, bl2);
            return;
        }
    }

    public void setMetaData(HashMap hashMap) {
        this.mMetaData = hashMap;
    }

    public void setMode(int n10) {
        l l10 = this.mParam;
        if (l10 != null) {
            l10.a = n10;
        }
    }

    public void setNotifyListener(com.tencent.liteav.basic.b.b b10) {
        WeakReference<com.tencent.liteav.basic.b.b> weakReference;
        this.mNotifyListener = weakReference = new WeakReference<com.tencent.liteav.basic.b.b>(b10);
    }

    public void setRetryInterval(int n10) {
        l l10 = this.mParam;
        if (l10 != null) {
            l10.g = n10;
        }
    }

    public void setRetryTimes(int n10) {
        l l10 = this.mParam;
        if (l10 != null) {
            l10.f = n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setSendStrategy(boolean bl2, boolean bl3) {
        ArrayList arrayList;
        float f10;
        Object object = this.mParam;
        ((l)object).m = bl2;
        ((l)object).n = bl3;
        object = this.mUploadQualityReport;
        ((n)object).a(bl2);
        int n10 = 1;
        float f11 = Float.MIN_VALUE;
        if (bl2) {
            bl2 = this.mQuicChannel;
            if (bl2) {
                bl2 = 3;
                f10 = 4.2E-45f;
            } else {
                bl2 = 2;
                f10 = 2.8E-45f;
            }
        } else {
            bl2 = n10;
            f10 = f11;
        }
        int n11 = this.mRtmpProxyEnable;
        if (n11 != 0 || (arrayList = this.mIpList) != null && (n11 = arrayList.size()) != 0) {
            n10 = bl2;
            f11 = f10;
        }
        Object object2 = this.mThreadLock;
        synchronized (object2) {
            long l10 = this.mUploaderInstance;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 != false) {
                this.nativeSetSendStrategy(l10, n10, bl3);
            }
        }
        Long l13 = n10;
        this.setStatusValue(7020, l13);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setVideoDropParams(boolean bl2, int n10, int n11) {
        Object object = "TXCStreamUploader";
        Object object2 = new StringBuilder();
        Object object3 = "drop params wait i frame:";
        ((StringBuilder)object2).append((String)object3);
        object3 = bl2 ? "yes" : "no";
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(" max video count:");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(" max video cache time: ");
        ((StringBuilder)object2).append(n11);
        object3 = " ms";
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i((String)object, (String)object2);
        object = this.mThreadLock;
        synchronized (object) {
            object2 = this.mParam;
            ((l)object2).j = bl2;
            ((l)object2).h = n10;
            ((l)object2).i = n11;
            long l10 = this.mUploaderInstance;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 != false) {
                object3 = this;
                this.nativeSetVideoDropParams(l10, bl2, n10, n11);
            }
            return;
        }
    }

    public String start(String string2, boolean n10, int n11) {
        long l10;
        int n12 = this.mIsPushing;
        int n13 = 1;
        if (n12 == n13) {
            return this.mRtmpUrl;
        }
        this.mIsPushing = n13;
        this.mConnectSuccessTimeStamps = l10 = 0L;
        this.mRetryCount = 0;
        this.mRtmpUrl = string2;
        this.mChannelType = n11;
        this.mConnectCountQuic = 0;
        this.mConnectCountTcp = 0;
        this.mRtmpProxyEnable = false;
        this.mRtmpProxyParam.a();
        Vector vector = this.mRtmpProxyIPList;
        vector.clear();
        this.mRtmpProxyIPIndex = 0;
        this.mRtmpProxyInstance = l10;
        this.mRtmpMsgRecvThreadInstance = l10;
        Long l11 = l10;
        this.setStatusValue(7016, l11);
        l11 = l10;
        this.setStatusValue(7017, l11);
        int n14 = 7018;
        Object object = l10;
        this.setStatusValue(n14, object);
        this.mUploadQualityReport.a();
        object = new StringBuilder();
        ((StringBuilder)object).append("start push with url:");
        String string3 = this.mRtmpUrl;
        ((StringBuilder)object).append(string3);
        string3 = " enable nearest ip:";
        ((StringBuilder)object).append(string3);
        string3 = n10 != 0 ? "yes" : "no";
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append("channel type:");
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        string3 = "TXCStreamUploader";
        TXCLog.i(string3, (String)object);
        object = this.mContext;
        n12 = g.d((Context)object);
        if (n12 == 0) {
            this.sendNotifyEvent(-1325);
            return this.mRtmpUrl;
        }
        this.mEnableNearestIP = n10;
        Object object2 = this.mHandlerThread;
        if (object2 == null) {
            object = "RTMP_PUSH";
            object2 = new HandlerThread((String)object);
            this.mHandlerThread = object2;
            object2.start();
        }
        object = this.mHandlerThread.getLooper();
        object2 = new TXCStreamUploader$1(this, (Looper)object);
        this.mHandler = object2;
        this.parseProxyInfo(string2);
        n10 = this.mRtmpProxyEnable;
        if (n10 != 0) {
            int n15;
            this.mLastNetworkType = n15 = g.d(this.mContext);
            this.nativeCacheJNIParams();
            string2 = this.mRtmpUrl;
            n10 = this.mQuicChannel;
            this.startPushTask(string2, n10 != 0, 0);
        } else {
            n10 = this.mEnableNearestIP;
            if (n10 != 0 && (n10 = this.mLastNetworkType) != (n12 = g.d((Context)(object = this.mContext)))) {
                TXCLog.i(string3, "fetching nearest ip list");
                this.mLastNetworkType = n10 = g.d(this.mContext);
                object2 = this.mIntelligentRoute;
                ((c)object2).a(string2, n11);
            } else {
                string2 = this.mRtmpUrl;
                n10 = this.mQuicChannel;
                this.startPushTask(string2, n10 != 0, 0);
            }
        }
        this.mHandler.sendEmptyMessageDelayed(103, 2000L);
        return this.mRtmpUrl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stop() {
        long l10;
        boolean bl2 = this.mIsPushing;
        if (!bl2) {
            return;
        }
        this.mIsPushing = false;
        Object object = "TXCStreamUploader";
        String string2 = "stop push";
        TXCLog.i((String)object, string2);
        bl2 = this.mRtmpProxyEnable;
        if (bl2) {
            object = this.mRtmpProxyLock;
            synchronized (object) {
                l10 = this.mRtmpProxyInstance;
                this.nativeRtmpProxyLeaveRoom(l10);
            }
        }
        object = this.mThreadLock;
        synchronized (object) {
            l10 = this.mUploaderInstance;
            this.nativeStopPush(l10);
        }
        object = this.mHandlerThread;
        string2 = null;
        if (object != null) {
            object = object.getLooper();
            object.quit();
            this.mHandlerThread = null;
        }
        if ((object = this.mHandler) != null) {
            this.mHandler = null;
        }
        if (bl2 = this.mRtmpProxyEnable) {
            this.nativeReleaseJNIParams();
        }
        this.mUploadQualityReport.c();
        this.mUploadQualityReport.a();
    }
}

