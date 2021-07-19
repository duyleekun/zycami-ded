/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 */
package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.network.TXCFLVDownloader;
import com.tencent.liteav.network.TXCRTMPDownloader;
import com.tencent.liteav.network.TXCStreamDownloader$1;
import com.tencent.liteav.network.TXCStreamDownloader$2;
import com.tencent.liteav.network.TXCStreamDownloader$3;
import com.tencent.liteav.network.TXCStreamDownloader$DownloadStats;
import com.tencent.liteav.network.TXCStreamDownloader$a;
import com.tencent.liteav.network.TXIStreamDownloader;
import com.tencent.liteav.network.TXIStreamDownloader$a;
import com.tencent.liteav.network.d;
import com.tencent.liteav.network.d$a;
import com.tencent.liteav.network.e;
import com.tencent.liteav.network.h;
import com.tencent.liteav.network.k;
import com.tencent.liteav.network.k$a;
import java.util.Map;
import java.util.Vector;

public class TXCStreamDownloader
extends com.tencent.liteav.basic.module.a
implements b,
TXIStreamDownloader$a,
d$a,
h {
    public static final String TAG = "TXCStreamDownloader";
    private k mAccUrlFetcher;
    private Context mApplicationContext;
    private int mChannelType;
    private long mCurrentNalTs;
    private int mDownloadFormat;
    private TXIStreamDownloader mDownloader;
    private boolean mDownloaderRunning;
    private boolean mEnableMessage;
    private boolean mEnableMetaData;
    private boolean mEnableNearestIP;
    private String mFlvSessionKey;
    private Handler mHandler;
    public Map mHeaders;
    private TXCStreamDownloader$DownloadStats mLastDownloadStats;
    private long mLastIFramelTs;
    private long mLastTimeStamp;
    private h mListener;
    private byte[] mListenerLock;
    private b mNotifyListener;
    private String mOriginPlayUrl;
    private boolean mRecvFirstNal;
    private Runnable mReportNetStatusRunnalbe;
    private d mStreamSwitcher;
    private long mSwitchStartTime;

    static {
        g.f();
    }

    public TXCStreamDownloader(Context context, int n10) {
        k k10;
        long l10;
        int n11;
        int n12 = 0;
        this.mDownloader = null;
        this.mListener = null;
        String string2 = null;
        Object object = new byte[]{};
        this.mListenerLock = object;
        this.mNotifyListener = null;
        this.mDownloaderRunning = false;
        object = "";
        this.mOriginPlayUrl = object;
        this.mEnableNearestIP = false;
        this.mChannelType = 0;
        this.mEnableMessage = false;
        this.mEnableMetaData = false;
        this.mFlvSessionKey = object;
        this.mDownloadFormat = n11 = 1;
        this.mHandler = null;
        this.mLastTimeStamp = l10 = 0L;
        this.mLastDownloadStats = null;
        this.mRecvFirstNal = false;
        this.mSwitchStartTime = l10;
        this.mCurrentNalTs = l10;
        this.mLastIFramelTs = l10;
        this.mStreamSwitcher = null;
        Object object2 = new TXCStreamDownloader$3(this);
        this.mReportNetStatusRunnalbe = object2;
        if (n10 == 0) {
            this.mDownloader = object2 = new TXCFLVDownloader(context);
            string2 = this.mFlvSessionKey;
            ((TXIStreamDownloader)object2).setFlvSessionKey(string2);
        } else if (n10 == n11 || n10 == (n12 = 4)) {
            this.mDownloader = object2 = new TXCRTMPDownloader(context);
        }
        object2 = this.mDownloader;
        if (object2 != null) {
            ((TXIStreamDownloader)object2).setListener(this);
            this.mDownloader.setNotifyListener(this);
            object2 = this.mDownloader;
            ((TXIStreamDownloader)object2).setRestartListener(this);
        }
        this.mDownloadFormat = n10;
        this.mAccUrlFetcher = k10 = new k(context);
        this.mApplicationContext = context;
        if (context != null) {
            k10 = this.mApplicationContext.getMainLooper();
            super((Looper)k10);
            this.mHandler = context;
        }
    }

    public static /* synthetic */ String access$000(TXCStreamDownloader tXCStreamDownloader) {
        return tXCStreamDownloader.mOriginPlayUrl;
    }

    public static /* synthetic */ boolean access$100(TXCStreamDownloader tXCStreamDownloader) {
        return tXCStreamDownloader.mEnableNearestIP;
    }

    public static /* synthetic */ Context access$1000(TXCStreamDownloader tXCStreamDownloader) {
        return tXCStreamDownloader.mApplicationContext;
    }

    public static /* synthetic */ void access$1100(TXCStreamDownloader tXCStreamDownloader) {
        tXCStreamDownloader.reportNetStatus();
    }

    public static /* synthetic */ int access$200(TXCStreamDownloader tXCStreamDownloader) {
        return tXCStreamDownloader.mChannelType;
    }

    public static /* synthetic */ boolean access$300(TXCStreamDownloader tXCStreamDownloader) {
        return tXCStreamDownloader.mEnableMessage;
    }

    public static /* synthetic */ boolean access$400(TXCStreamDownloader tXCStreamDownloader) {
        return tXCStreamDownloader.mEnableMetaData;
    }

    public static /* synthetic */ boolean access$500(TXCStreamDownloader tXCStreamDownloader) {
        return tXCStreamDownloader.mDownloaderRunning;
    }

    public static /* synthetic */ TXIStreamDownloader access$600(TXCStreamDownloader tXCStreamDownloader) {
        return tXCStreamDownloader.mDownloader;
    }

    public static /* synthetic */ Handler access$700(TXCStreamDownloader tXCStreamDownloader) {
        return tXCStreamDownloader.mHandler;
    }

    public static /* synthetic */ Runnable access$800(TXCStreamDownloader tXCStreamDownloader) {
        return tXCStreamDownloader.mReportNetStatusRunnalbe;
    }

    public static /* synthetic */ k access$900(TXCStreamDownloader tXCStreamDownloader) {
        return tXCStreamDownloader.mAccUrlFetcher;
    }

    private TXCStreamDownloader$DownloadStats getDownloadStats() {
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            return tXIStreamDownloader.getDownloadStats();
        }
        return null;
    }

    private TXCStreamDownloader$a getRealTimeStreamInfo() {
        int n10;
        Object object;
        boolean bl2;
        Object object2 = this.mAccUrlFetcher;
        if (object2 != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((k)object2).a())))) {
            object2 = new TXCStreamDownloader$a();
            ((TXCStreamDownloader$a)object2).b = object = this.mAccUrlFetcher.a();
            ((TXCStreamDownloader$a)object2).c = object = this.mAccUrlFetcher.b();
            ((TXCStreamDownloader$a)object2).d = n10 = this.mAccUrlFetcher.c();
            ((TXCStreamDownloader$a)object2).e = object = this.mAccUrlFetcher.d();
        } else {
            bl2 = false;
            object2 = null;
        }
        object = this.mDownloader;
        if (object != null && object2 != null) {
            ((TXCStreamDownloader$a)object2).a = object = ((TXIStreamDownloader)object).getCurrentStreamUrl();
            object = this.mDownloader;
            ((TXCStreamDownloader$a)object2).f = n10 = ((TXIStreamDownloader)object).isQuicChannel();
        }
        return object2;
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

    private native String nativeGetRTMPProxyUserId();

    private void playStreamWithRawUrl(String string2, boolean bl2) {
        Object object = this.mDownloader;
        if (object != null) {
            Object object2;
            TXIStreamDownloader tXIStreamDownloader;
            Object object3;
            int n10;
            int n11;
            if (string2 != null && ((n11 = (int)(string2.startsWith((String)(object = "http://")) ? 1 : 0)) != 0 || (n11 = (int)(string2.startsWith((String)(object = "https://")) ? 1 : 0)) != 0) && (n11 = (int)(string2.contains((CharSequence)(object = ".flv")) ? 1 : 0)) != 0) {
                object = this.mDownloader;
                n10 = ((TXIStreamDownloader)object).connectRetryLimit;
                n11 = ((TXIStreamDownloader)object).connectRetryInterval;
                this.mDownloader = null;
                object3 = this.mApplicationContext;
                this.mDownloader = tXIStreamDownloader = new TXCFLVDownloader((Context)object3);
                object3 = this.mFlvSessionKey;
                tXIStreamDownloader.setFlvSessionKey((String)object3);
                this.mDownloader.setListener(this);
                this.mDownloader.setNotifyListener(this);
                this.mDownloader.setRestartListener(this);
                tXIStreamDownloader = this.mDownloader;
                tXIStreamDownloader.connectRetryLimit = n10;
                tXIStreamDownloader.connectRetryInterval = n11;
                object = this.mHeaders;
                tXIStreamDownloader.setHeaders((Map)object);
                object = this.mDownloader;
                object2 = this.getID();
                ((TXIStreamDownloader)object).setUserID((String)object2);
            }
            n11 = 7112;
            long l10 = 1L;
            object2 = l10;
            this.setStatusValue(n11, object2);
            object3 = new Vector();
            n10 = 0;
            object2 = null;
            object = new e(string2, false);
            object3.add(object);
            object = this.mDownloader;
            ((TXIStreamDownloader)object).setOriginUrl(string2);
            tXIStreamDownloader = this.mDownloader;
            tXIStreamDownloader.startDownload((Vector)object3, false, false, bl2, bl2);
        }
    }

    private void reportNetStatus() {
        this.reportNetStatusInternal();
        Handler handler = this.mHandler;
        Runnable runnable = this.mReportNetStatusRunnalbe;
        handler.postDelayed(runnable, 2000L);
    }

    private void reportNetStatusInternal() {
        int n10;
        Object object;
        int n11;
        long l10;
        long l11;
        Object object2;
        TXCStreamDownloader tXCStreamDownloader = this;
        long l12 = TXCTimeUtil.getTimeTick();
        long l13 = this.mLastTimeStamp;
        long l14 = l12 - l13;
        TXCStreamDownloader$DownloadStats tXCStreamDownloader$DownloadStats = this.getDownloadStats();
        TXCStreamDownloader$a tXCStreamDownloader$a = this.getRealTimeStreamInfo();
        if (tXCStreamDownloader$DownloadStats != null) {
            Long l15;
            int n12;
            long l16;
            long l17;
            object2 = this.mLastDownloadStats;
            long l18 = 0L;
            if (object2 != null) {
                l11 = ((TXCStreamDownloader$DownloadStats)object2).afterParseVideoBytes;
                l10 = tXCStreamDownloader$DownloadStats.afterParseVideoBytes;
                object2 = this;
                l17 = l14;
                l16 = this.getSpeed(l11, l10, l14);
                l11 = this.mLastDownloadStats.afterParseAudioBytes;
                l10 = tXCStreamDownloader$DownloadStats.afterParseAudioBytes;
                object2 = this;
                object2 = this.getSpeed(l11, l10, l14);
                l13 = (Long)object2;
            } else {
                l13 = l18;
                l16 = l18;
            }
            n11 = (int)(l16 == l18 ? 0 : (l16 < l18 ? -1 : 1));
            if (n11 > 0 || (n11 = (int)(l13 == l18 ? 0 : (l13 < l18 ? -1 : 1))) > 0) {
                TXIStreamDownloader tXIStreamDownloader = tXCStreamDownloader.mDownloader;
                n12 = 0;
                l15 = null;
                tXIStreamDownloader.connectRetryTimes = 0;
            }
            l15 = l16;
            tXCStreamDownloader.setStatusValue(7101, l15);
            object2 = l13;
            tXCStreamDownloader.setStatusValue(7102, object2);
            object = tXCStreamDownloader$DownloadStats.firstVideoTS;
            tXCStreamDownloader.setStatusValue(7103, object);
            object = tXCStreamDownloader$DownloadStats.firstAudioTS;
            tXCStreamDownloader.setStatusValue(7104, object);
            n10 = 7120;
            l11 = tXCStreamDownloader$DownloadStats.videoGop;
            object = l11;
            tXCStreamDownloader.setStatusValue(n10, object);
            l13 = 1L;
            n11 = 7111;
            n12 = 7106;
            int n13 = 7105;
            if (tXCStreamDownloader$a != null) {
                int n14 = tXCStreamDownloader$a.d;
                l17 = n14;
                Long l19 = l17;
                tXCStreamDownloader.setStatusValue(n13, l19);
                String string2 = tXCStreamDownloader$a.e;
                tXCStreamDownloader.setStatusValue(n12, string2);
                n12 = (int)(tXCStreamDownloader$a.f ? 1 : 0);
                if (n12 != 0) {
                    l13 = 2;
                }
                object2 = l13;
                tXCStreamDownloader.setStatusValue(n11, object2);
                object = tXCStreamDownloader$a.a;
                tXCStreamDownloader.setStatusValue(7116, object);
                object = tXCStreamDownloader$a.b;
                tXCStreamDownloader.setStatusValue(7117, object);
                n10 = 7118;
                object = tXCStreamDownloader$a.c;
                tXCStreamDownloader.setStatusValue(n10, object);
            } else {
                int n15 = tXCStreamDownloader$DownloadStats.errorCode;
                l17 = n15;
                Long l20 = l17;
                tXCStreamDownloader.setStatusValue(n13, l20);
                String string3 = tXCStreamDownloader$DownloadStats.errorInfo;
                tXCStreamDownloader.setStatusValue(n12, string3);
                object2 = l13;
                tXCStreamDownloader.setStatusValue(n11, object2);
            }
            object = tXCStreamDownloader$DownloadStats.startTS;
            tXCStreamDownloader.setStatusValue(7107, object);
            object = tXCStreamDownloader$DownloadStats.dnsTS;
            tXCStreamDownloader.setStatusValue(7108, object);
            l11 = tXCStreamDownloader$DownloadStats.connTS;
            object = l11;
            tXCStreamDownloader.setStatusValue(7109, object);
            n10 = 7110;
            object = String.valueOf(tXCStreamDownloader$DownloadStats.serverIP);
            tXCStreamDownloader.setStatusValue(n10, object);
        }
        if ((object2 = tXCStreamDownloader.mDownloader) != null) {
            n10 = ((TXIStreamDownloader)object2).getConnectCountQuic();
            int n16 = tXCStreamDownloader.mDownloader.getConnectCountTcp();
            n11 = 7114;
            l10 = n10 + 1;
            object2 = l10;
            tXCStreamDownloader.setStatusValue(n11, object2);
            l11 = ++n16;
            object = l11;
            tXCStreamDownloader.setStatusValue(7115, object);
            object = tXCStreamDownloader.mDownloader.getRealStreamUrl();
            tXCStreamDownloader.setStatusValue(7119, object);
            n10 = 7121;
            object = String.valueOf(tXCStreamDownloader.mDownloader.getFlvSessionKey());
            tXCStreamDownloader.setStatusValue(n10, object);
        }
        tXCStreamDownloader.mLastTimeStamp = l12;
        tXCStreamDownloader.mLastDownloadStats = tXCStreamDownloader$DownloadStats;
    }

    private void tryResetRetryCount() {
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.connectRetryTimes = 0;
        }
    }

    public String getRTMPProxyUserId() {
        return this.nativeGetRTMPProxyUserId();
    }

    public void onNotifyEvent(int n10, Bundle bundle) {
        int n11;
        TXCStreamDownloader tXCStreamDownloader = this;
        int n12 = n10;
        Object object = bundle;
        Object object2 = this.mNotifyListener;
        int n13 = 2001;
        if (object2 != null) {
            String string2;
            Bundle bundle2 = new Bundle();
            int n14 = 3007;
            int n15 = 3006;
            int n16 = 3003;
            int n17 = 3002;
            int n18 = -2301;
            int n19 = 3010;
            int n20 = -2308;
            String string3 = "EVT_MSG";
            if (n10 != n20) {
                int n21 = 2012;
                if (n10 != n21) {
                    n21 = 2028;
                    if (n10 != n21 && n10 != (n21 = 2031)) {
                        n21 = 2103;
                        if (n10 != n21) {
                            if (n10 != n19) {
                                n21 = -2302;
                                if (n10 != n21) {
                                    if (n10 != n18) {
                                        if (n10 != n13) {
                                            n21 = 2002;
                                            if (n10 != n21) {
                                                if (n10 != n17) {
                                                    if (n10 != n16) {
                                                        if (n10 != n15) {
                                                            if (n10 != n14) {
                                                                CharSequence charSequence = new StringBuilder();
                                                                String string4 = "UNKNOWN event = ";
                                                                charSequence.append(string4);
                                                                charSequence.append(n10);
                                                                charSequence = charSequence.toString();
                                                                bundle2.putString(string3, (String)charSequence);
                                                            } else {
                                                                String string5 = "Read data error";
                                                                bundle2.putString(string3, string5);
                                                            }
                                                        } else {
                                                            String string6 = "Write data error";
                                                            bundle2.putString(string3, string6);
                                                        }
                                                    } else {
                                                        String string7 = "RTMP handshake failed";
                                                        bundle2.putString(string3, string7);
                                                    }
                                                } else {
                                                    String string8 = "Failed to connect server";
                                                    bundle2.putString(string3, string8);
                                                }
                                            } else {
                                                String string9 = "begin receiving stream";
                                                bundle2.putString(string3, string9);
                                            }
                                        } else {
                                            String string10 = "connection SUCCESS";
                                            bundle2.putString(string3, string10);
                                        }
                                    } else {
                                        String string11 = "failed to connect server for several times, abort connection";
                                        bundle2.putString(string3, string11);
                                    }
                                } else {
                                    String string12 = "Failed to get accelerated pull address";
                                    bundle2.putString(string3, string12);
                                }
                            } else {
                                String string13 = "No video at this stream address";
                                bundle2.putString(string3, string13);
                            }
                        } else {
                            String string14 = "retry connecting stream server";
                            bundle2.putString(string3, string14);
                        }
                    } else {
                        bundle2 = object;
                    }
                } else {
                    String string15 = "EVT_GET_MSG";
                    byte[] byArray = bundle.getByteArray(string15);
                    if (byArray != null && (n13 = byArray.length) > 0) {
                        bundle2.putByteArray(string15, byArray);
                    }
                }
            } else {
                string2 = "The server rejected the connection request";
                bundle2.putString(string3, string2);
            }
            string2 = "";
            if (object != null) {
                string2 = object.getString(string3, string2);
            }
            if (string2 != null && (n11 = (int)(string2.isEmpty() ? 1 : 0)) == 0) {
                bundle2.putString(string3, string2);
            }
            long l10 = TXCTimeUtil.getTimeTick();
            bundle2.putLong("EVT_TIME", l10);
            l10 = TXCTimeUtil.getUtcTimeTick();
            object = "EVT_UTC_TIME";
            bundle2.putLong((String)object, l10);
            object2.onNotifyEvent(n12, bundle2);
            n11 = 3001;
            if (n12 == n11 || n12 == n17 || n12 == n16 || n12 == (n11 = 3004) || n12 == (n11 = 3005) || n12 == n15 || n12 == n14 || n12 == (n11 = 3008) || n12 == (n11 = 3009) || n12 == n19 || n12 == (n11 = 2101) || n12 == (n11 = 2102) || n12 == (n11 = 2109) || n12 == (n11 = 2110) || n12 == n18 || n12 == (n11 = -2304) || n12 == n20 || n12 == (n11 = -2309)) {
                n11 = 7105;
                object2 = n10;
                tXCStreamDownloader.setStatusValue(n11, object2);
                if (bundle2 != null) {
                    n11 = 7106;
                    object2 = bundle2.getString(string3);
                    tXCStreamDownloader.setStatusValue(n11, object2);
                }
            }
            n11 = 2001;
        } else {
            n11 = n13;
        }
        if (n12 == n11) {
            this.reportNetStatusInternal();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onOldStreamStop() {
        byte[] byArray = this.mListenerLock;
        synchronized (byArray) {
            d d10 = this.mStreamSwitcher;
            if (d10 != null) {
                d10.b();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onPullAudio(com.tencent.liteav.basic.structs.a a10) {
        this.tryResetRetryCount();
        byte[] byArray = this.mListenerLock;
        synchronized (byArray) {
            Object object = this.mListener;
            if (object != null) {
                object.onPullAudio(a10);
            }
            if ((object = this.mDownloader) != null) {
                byte[] byArray2 = a10.f;
                int n10 = a10.h;
                long l10 = a10.e;
                int n11 = a10.g;
                ((TXIStreamDownloader)object).PushAudioFrame(byArray2, n10, l10, n11);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onPullNAL(TXSNALPacket tXSNALPacket) {
        this.tryResetRetryCount();
        boolean bl2 = this.mRecvFirstNal;
        if (!bl2) {
            this.reportNetStatusInternal();
            this.mRecvFirstNal = bl2 = true;
        }
        byte[] byArray = this.mListenerLock;
        synchronized (byArray) {
            Object object;
            long l10;
            this.mCurrentNalTs = l10 = tXSNALPacket.pts;
            int n10 = tXSNALPacket.nalType;
            if (n10 == 0) {
                this.mLastIFramelTs = l10;
            }
            if ((object = this.mListener) != null) {
                object.onPullNAL(tXSNALPacket);
            }
            if ((object = this.mDownloader) != null) {
                byte[] byArray2 = tXSNALPacket.nalData;
                n10 = tXSNALPacket.nalType;
                long l11 = tXSNALPacket.dts;
                long l12 = tXSNALPacket.pts;
                int n11 = tXSNALPacket.codecId;
                ((TXIStreamDownloader)object).PushVideoFrame(byArray2, n10, l11, l12, n11);
            }
            return;
        }
    }

    public void onRestartDownloader() {
        Handler handler = this.mHandler;
        if (handler != null) {
            TXCStreamDownloader$1 tXCStreamDownloader$1 = new TXCStreamDownloader$1(this);
            handler.post((Runnable)tXCStreamDownloader$1);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSwitchFinish(TXIStreamDownloader object, boolean bl2) {
        byte[] byArray = this.mListenerLock;
        synchronized (byArray) {
            long l10;
            long l11 = System.currentTimeMillis();
            long l12 = this.mSwitchStartTime;
            int n10 = (int)(l11 -= l12);
            this.mSwitchStartTime = l10 = 0L;
            Object object2 = new Bundle();
            String string2 = "EVT_TIME";
            long l13 = TXCTimeUtil.getTimeTick();
            object2.putLong(string2, l13);
            string2 = "EVT_UTC_TIME";
            l13 = TXCTimeUtil.getUtcTimeTick();
            object2.putLong(string2, l13);
            if (bl2) {
                this.mDownloader = object;
                ((TXIStreamDownloader)object).setListener(this);
                object = this.mDownloader;
                ((TXIStreamDownloader)object).setNotifyListener(this);
                object = this.mDownloader;
                ((TXIStreamDownloader)object).setRestartListener(this);
                object = "EVT_ID";
                bl2 = 2015;
                object2.putInt((String)object, (int)(bl2 ? 1 : 0));
                object = "EVT_MSG";
                string2 = "Switched resolution successfully";
                object2.putCharSequence((String)object, (CharSequence)string2);
                object = this.mNotifyListener;
                if (object != null) {
                    object.onNotifyEvent((int)(bl2 ? 1 : 0), (Bundle)object2);
                }
                object = this.mApplicationContext;
                bl2 = a.bx;
                object2 = "";
                TXCDRApi.txReportDAU((Context)object, (int)(bl2 ? 1 : 0), n10, (String)object2);
            } else {
                object = "EVT_ID";
                bl2 = -2307;
                object2.putInt((String)object, (int)(bl2 ? 1 : 0));
                object = "EVT_MSG";
                String string3 = "Failed to switch resolution";
                object2.putCharSequence((String)object, (CharSequence)string3);
                object = this.mNotifyListener;
                if (object != null) {
                    object.onNotifyEvent((int)(bl2 ? 1 : 0), (Bundle)object2);
                }
                object = this.mApplicationContext;
                bl2 = a.by;
                TXCDRApi.txReportDAU((Context)object, (int)(bl2 ? 1 : 0));
            }
            object = null;
            this.mStreamSwitcher = null;
            return;
        }
    }

    public void requestKeyFrame(String string2) {
        Object object;
        boolean bl2 = this.mDownloaderRunning;
        if (bl2 && string2 != null && (bl2 = string2.startsWith((String)(object = "room"))) && (object = this.mDownloader) != null) {
            ((TXIStreamDownloader)object).requestKeyFrame(string2);
        }
    }

    public void setFlvSessionKey(String string2) {
        this.mFlvSessionKey = string2;
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.setFlvSessionKey(string2);
        }
    }

    public void setHeaders(Map map) {
        this.mHeaders = map;
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.setHeaders(map);
        }
    }

    public void setID(String string2) {
        super.setID(string2);
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.setUserID(string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setListener(h h10) {
        byte[] byArray = this.mListenerLock;
        synchronized (byArray) {
            this.mListener = h10;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setNotifyListener(b b10) {
        byte[] byArray = this.mListenerLock;
        synchronized (byArray) {
            this.mNotifyListener = b10;
            return;
        }
    }

    public void setRetryInterval(int n10) {
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.connectRetryInterval = n10;
        }
    }

    public void setRetryTimes(int n10) {
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.connectRetryLimit = n10;
        }
    }

    public int start(String string2, boolean bl2, int n10, boolean bl3, boolean bl4) {
        int n11;
        TXCStreamDownloader tXCStreamDownloader = this;
        Object object = string2;
        int n12 = n10;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("start url:");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(",enableNearestIP:");
        ((StringBuilder)object2).append(bl2);
        ((StringBuilder)object2).append(",channeyType:");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(",enableMessage:");
        ((StringBuilder)object2).append(bl3);
        ((StringBuilder)object2).append(",enableMetaData:");
        ((StringBuilder)object2).append(bl4);
        object2 = ((StringBuilder)object2).toString();
        Object object3 = "TXCStreamDownloader";
        TXCLog.i((String)object3, (String)object2);
        this.mDownloaderRunning = n11 = 1;
        this.mRecvFirstNal = false;
        this.mOriginPlayUrl = string2;
        this.mEnableNearestIP = bl2;
        this.mChannelType = n10;
        this.mEnableMessage = bl3;
        this.mEnableMetaData = bl4;
        long l10 = 0L;
        Object object4 = l10;
        int n13 = 7113;
        this.setStatusValue(n13, object4);
        this.setStatusValue(7114, object4);
        int n14 = 7115;
        this.setStatusValue(n14, object4);
        object4 = "room";
        int n15 = string2.startsWith((String)object4);
        long l11 = 2000L;
        int n16 = 7112;
        long l12 = 1L;
        Long l13 = l12;
        if (n15 != 0) {
            this.setStatusValue(n13, l13);
            l10 = 2;
            Object object5 = l10;
            this.setStatusValue(n16, object5);
            object5 = this.mDownloader;
            if (object5 != null) {
                object5 = new Vector();
                e e10 = new e(string2, n11 != 0);
                ((Vector)object5).add(e10);
                this.mDownloader.setOriginUrl(string2);
                object = this.mDownloader;
                object2 = this.getID();
                ((TXIStreamDownloader)object).setUserID((String)object2);
                object = this.mDownloader;
                n11 = 0;
                object2 = null;
                e10 = null;
                ((TXIStreamDownloader)object).startDownload((Vector)object5, false, false, bl3, bl4);
            }
            if ((object = tXCStreamDownloader.mHandler) != null) {
                object5 = tXCStreamDownloader.mReportNetStatusRunnalbe;
                object.postDelayed((Runnable)object5, l11);
            }
            return 0;
        }
        n15 = 4;
        if (bl2 && (n13 = this.mDownloadFormat) == n15) {
            object2 = this.mAccUrlFetcher;
            Object object6 = new TXCStreamDownloader$2(this, string2, bl3, bl4);
            int n17 = ((k)object2).a(string2, n10, (k$a)object6);
            if (n17 != 0) {
                Object object7;
                n12 = -1;
                if (n17 == n12) {
                    object7 = this.mApplicationContext;
                    n11 = a.au;
                    object6 = "invalid playUrl";
                    TXCDRApi.txReportDAU((Context)object7, n11, n17, (String)object6);
                } else {
                    n12 = -2;
                    if (n17 == n12) {
                        object7 = this.mApplicationContext;
                        n11 = a.au;
                        object6 = "invalid streamID";
                        TXCDRApi.txReportDAU((Context)object7, n11, n17, (String)object6);
                    } else {
                        n12 = -3;
                        if (n17 == n12) {
                            object7 = this.mApplicationContext;
                            n11 = a.au;
                            object6 = "invalid signature";
                            TXCDRApi.txReportDAU((Context)object7, n11, n17, (String)object6);
                        }
                    }
                }
                object7 = new StringBuilder();
                object2 = "getAccelerateStreamPlayUrl failed, result = ";
                ((StringBuilder)object7).append((String)object2);
                ((StringBuilder)object7).append(n17);
                ((StringBuilder)object7).append(", play stream with raw url");
                object = ((StringBuilder)object7).toString();
                TXCLog.e((String)object3, (String)object);
                n12 = 0;
                object7 = null;
                tXCStreamDownloader.onNotifyEvent(-2302, null);
                n17 = -2301;
                tXCStreamDownloader.onNotifyEvent(n17, null);
            }
            return 0;
        }
        Object object8 = tXCStreamDownloader.mDownloader;
        if (object8 != null) {
            tXCStreamDownloader.setStatusValue(n16, l13);
            object8 = new Vector();
            object3 = new e((String)object, false);
            ((Vector)object8).add(object3);
            object3 = tXCStreamDownloader.mDownloader;
            ((TXIStreamDownloader)object3).setOriginUrl((String)object);
            object = tXCStreamDownloader.mDownloader;
            int n18 = tXCStreamDownloader.mDownloadFormat;
            if (n18 != n15) {
                n11 = 0;
                object2 = null;
            }
            ((TXIStreamDownloader)object).startDownload((Vector)object8, n11 != 0, bl2, bl3, bl4);
            object = tXCStreamDownloader.mHandler;
            if (object != null) {
                object8 = tXCStreamDownloader.mReportNetStatusRunnalbe;
                object.postDelayed((Runnable)object8, l11);
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stop() {
        Object object;
        this.mDownloaderRunning = false;
        this.mRecvFirstNal = false;
        Object object2 = this.mDownloader;
        if (object2 != null) {
            ((TXIStreamDownloader)object2).stopDownload();
        }
        if ((object2 = this.mHandler) != null) {
            object = this.mReportNetStatusRunnalbe;
            object2.removeCallbacks((Runnable)object);
        }
        object2 = this.mListenerLock;
        synchronized (object2) {
            object = this.mStreamSwitcher;
            if (object != null) {
                ((d)object).a(null);
                object = this.mStreamSwitcher;
                ((d)object).a();
                this.mStreamSwitcher = null;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean switchStream(String string2) {
        byte[] byArray = this.mListenerLock;
        synchronized (byArray) {
            int n10;
            Object object = this.mStreamSwitcher;
            if (object == null && (object = this.mDownloader) != null && (n10 = object instanceof TXCFLVDownloader) != 0) {
                long l10;
                int n11;
                Context context = this.mApplicationContext;
                object = (TXCFLVDownloader)object;
                TXCFLVDownloader tXCFLVDownloader = new TXCFLVDownloader(context, (TXCFLVDownloader)object);
                object = this.mDownloader;
                tXCFLVDownloader.connectRetryLimit = n10 = ((TXIStreamDownloader)object).connectRetryLimit;
                tXCFLVDownloader.connectRetryInterval = n11 = ((TXIStreamDownloader)object).connectRetryInterval;
                object = this.mHeaders;
                tXCFLVDownloader.setHeaders((Map)object);
                object = this.getID();
                tXCFLVDownloader.setUserID((String)object);
                object = this.mFlvSessionKey;
                tXCFLVDownloader.setFlvSessionKey((String)object);
                this.mStreamSwitcher = object = new d(this);
                ((d)object).a(this);
                d d10 = this.mStreamSwitcher;
                TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
                long l11 = this.mCurrentNalTs;
                long l12 = this.mLastIFramelTs;
                d10.a(tXIStreamDownloader, tXCFLVDownloader, l11, l12, string2);
                this.mSwitchStartTime = l10 = System.currentTimeMillis();
                return true;
            }
            string2 = "TXCStreamDownloader";
            object = "stream_switch stream is changing ignore this change";
            TXCLog.w(string2, (String)object);
            return false;
        }
    }
}

