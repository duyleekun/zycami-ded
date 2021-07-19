/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.text.TextUtils
 */
package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCFLVDownloader$1;
import com.tencent.liteav.network.TXCStreamDownloader$DownloadStats;
import com.tencent.liteav.network.TXIStreamDownloader;
import com.tencent.liteav.network.e;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;
import javax.net.ssl.SSLException;

public class TXCFLVDownloader
extends TXIStreamDownloader {
    private final int CONNECT_TIMEOUT;
    private final int FLV_HEAD_SIZE;
    private final int MAX_FRAME_SIZE;
    private final int MSG_CONNECT;
    private final int MSG_DISCONNECT;
    private final int MSG_QUIT;
    private final int MSG_RECONNECT;
    private final int MSG_RECV_DATA;
    private final int MSG_RESUME;
    private final int MSG_SEEK;
    private final int READ_STREAM_SIZE;
    public final String TAG;
    private HttpURLConnection mConnection;
    private long mContentLength;
    private long mCurrentNalTs;
    private long mDownloadedSize;
    private long mFLVParser;
    private Handler mFlvHandler;
    private HandlerThread mFlvThread;
    private boolean mHandleDataInJava;
    private boolean mHasReceivedFirstAudio;
    private boolean mHasReceivedFirstVideo;
    private InputStream mInputStream;
    private long mLastIFramelTs;
    private byte[] mPacketBytes;
    private String mPlayUrl;
    private boolean mRecvData;
    private WeakReference mRefFLVDownloader;
    private TXCStreamDownloader$DownloadStats mStats;
    private boolean mStopJitter;

    public TXCFLVDownloader(Context object) {
        super((Context)object);
        long l10;
        long l11;
        object = "network.TXCFLVDownloader";
        this.TAG = object;
        this.FLV_HEAD_SIZE = 9;
        this.MAX_FRAME_SIZE = 0x100000;
        this.MSG_CONNECT = 100;
        this.MSG_RECV_DATA = 101;
        this.MSG_DISCONNECT = 102;
        this.MSG_RECONNECT = 103;
        this.MSG_SEEK = 104;
        this.MSG_RESUME = 105;
        this.MSG_QUIT = 106;
        this.CONNECT_TIMEOUT = 8000;
        this.READ_STREAM_SIZE = 1388;
        this.mFlvThread = null;
        this.mFlvHandler = null;
        this.mInputStream = null;
        this.mConnection = null;
        this.mPacketBytes = null;
        this.mRecvData = false;
        this.mContentLength = l11 = 0L;
        this.mDownloadedSize = l11;
        this.mHandleDataInJava = false;
        this.mFLVParser = l11;
        this.mCurrentNalTs = l11;
        this.mLastIFramelTs = l11;
        this.mStopJitter = true;
        this.mPlayUrl = "";
        this.mHasReceivedFirstVideo = false;
        this.mHasReceivedFirstAudio = false;
        this.mStats = null;
        this.mRefFLVDownloader = null;
        Object object2 = new TXCStreamDownloader$DownloadStats();
        this.mStats = object2;
        ((TXCStreamDownloader$DownloadStats)object2).afterParseAudioBytes = l11;
        ((TXCStreamDownloader$DownloadStats)object2).dnsTS = l11;
        ((TXCStreamDownloader$DownloadStats)object2).startTS = l10 = TXCTimeUtil.getTimeTick();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("new flv download ");
        ((StringBuilder)object2).append(this);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i((String)object, (String)object2);
    }

    public TXCFLVDownloader(Context object, TXCFLVDownloader object2) {
        super((Context)object);
        long l10;
        long l11;
        object = "network.TXCFLVDownloader";
        this.TAG = object;
        this.FLV_HEAD_SIZE = 9;
        this.MAX_FRAME_SIZE = 0x100000;
        this.MSG_CONNECT = 100;
        this.MSG_RECV_DATA = 101;
        this.MSG_DISCONNECT = 102;
        this.MSG_RECONNECT = 103;
        this.MSG_SEEK = 104;
        this.MSG_RESUME = 105;
        this.MSG_QUIT = 106;
        this.CONNECT_TIMEOUT = 8000;
        this.READ_STREAM_SIZE = 1388;
        this.mFlvThread = null;
        this.mFlvHandler = null;
        this.mInputStream = null;
        this.mConnection = null;
        this.mPacketBytes = null;
        this.mRecvData = false;
        this.mContentLength = l11 = 0L;
        this.mDownloadedSize = l11;
        this.mHandleDataInJava = false;
        this.mFLVParser = l11;
        this.mCurrentNalTs = l11;
        this.mLastIFramelTs = l11;
        this.mStopJitter = true;
        this.mPlayUrl = "";
        this.mHasReceivedFirstVideo = false;
        this.mHasReceivedFirstAudio = false;
        this.mStats = null;
        this.mRefFLVDownloader = null;
        WeakReference<TXCFLVDownloader> weakReference = new WeakReference<TXCFLVDownloader>();
        this.mStats = weakReference;
        ((TXCStreamDownloader$DownloadStats)weakReference).afterParseAudioBytes = l11;
        ((TXCStreamDownloader$DownloadStats)weakReference).dnsTS = l11;
        ((TXCStreamDownloader$DownloadStats)weakReference).startTS = l10 = TXCTimeUtil.getTimeTick();
        this.mRefFLVDownloader = weakReference = new WeakReference<TXCFLVDownloader>((TXCFLVDownloader)object2);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("new multi flv download ");
        ((StringBuilder)object2).append(this);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i((String)object, (String)object2);
    }

    public static /* synthetic */ void access$000(TXCFLVDownloader tXCFLVDownloader) {
        tXCFLVDownloader.processMsgConnect();
    }

    public static /* synthetic */ void access$100(TXCFLVDownloader tXCFLVDownloader) {
        tXCFLVDownloader.processMsgRecvData();
    }

    public static /* synthetic */ void access$200(TXCFLVDownloader tXCFLVDownloader) {
        tXCFLVDownloader.processMsgDisConnect();
    }

    public static /* synthetic */ void access$300(TXCFLVDownloader tXCFLVDownloader) {
        tXCFLVDownloader.processMsgReconnect();
    }

    private void connect() {
        long l10;
        int n10;
        Object object = this.mConnection;
        if (object != null) {
            ((HttpURLConnection)object).disconnect();
            n10 = 0;
            object = null;
            this.mConnection = null;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("[FirstFramePath][Network] TXCFLVDownloader: start network connect. instance:");
        int n11 = this.hashCode();
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(" url:");
        String string2 = this.mPlayUrl;
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        string2 = "network.TXCFLVDownloader";
        TXCLog.i(string2, (String)object);
        long l11 = System.currentTimeMillis();
        Object object2 = this.mPlayUrl;
        object = new URL((String)object2);
        this.mConnection = object = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(((URL)object).openConnection()));
        object = this.mStats;
        ((TXCStreamDownloader$DownloadStats)object).dnsTS = l10 = TXCTimeUtil.getTimeTick();
        object = this.mConnection;
        int n12 = 8000;
        ((URLConnection)object).setConnectTimeout(n12);
        this.mConnection.setReadTimeout(n12);
        object = this.mConnection;
        object2 = "Accept-Encoding";
        Object object3 = "identity";
        ((URLConnection)object).setRequestProperty((String)object2, (String)object3);
        object = this.mConnection;
        n12 = 1;
        ((HttpURLConnection)object).setInstanceFollowRedirects(n12 != 0);
        object = this.mHeaders;
        if (object != null) {
            object = object.entrySet().iterator();
            while ((n12 = object.hasNext()) != 0) {
                object2 = object.next();
                object3 = this.mConnection;
                String string3 = (String)object2.getKey();
                object2 = (String)object2.getValue();
                ((URLConnection)object3).setRequestProperty(string3, (String)object2);
            }
        }
        object = this.mConnection;
        ((URLConnection)object).connect();
        n10 = 200;
        object2 = this.mConnection;
        n12 = ((HttpURLConnection)object2).getResponseCode();
        if (n10 == n12) {
            object = this.mStats;
            ((TXCStreamDownloader$DownloadStats)object).connTS = l10 = TXCTimeUtil.getTimeTick();
        } else {
            object = this.mStats;
            object2 = this.mConnection;
            ((TXCStreamDownloader$DownloadStats)object).errorCode = n12 = ((HttpURLConnection)object2).getResponseCode();
        }
        this.mInputStream = object = this.mConnection.getInputStream();
        object = new byte[1388];
        this.mPacketBytes = (byte[])object;
        this.mRecvData = false;
        this.mContentLength = l10 = (long)this.mConnection.getContentLength();
        this.mDownloadedSize = 0L;
        object = this.mStats;
        ((TXCStreamDownloader$DownloadStats)object).serverIP = object2 = InetAddress.getByName(this.mConnection.getURL().getHost()).getHostAddress();
        object = new StringBuilder();
        ((StringBuilder)object).append("connect server success,ServerIp:");
        object2 = this.mStats.serverIP;
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        TXCLog.i(string2, (String)object);
        l10 = System.currentTimeMillis() - l11;
        Object object4 = new StringBuilder();
        ((StringBuilder)object4).append("[FirstFramePath][Network] TXCFLVDownloader: connect server success. instance:");
        int n13 = this.hashCode();
        ((StringBuilder)object4).append(n13);
        ((StringBuilder)object4).append(" ip:");
        Object object5 = this.mStats.serverIP;
        ((StringBuilder)object4).append((String)object5);
        ((StringBuilder)object4).append(" cost:");
        ((StringBuilder)object4).append(l10);
        ((StringBuilder)object4).append(" rspCode:");
        object5 = this.mStats;
        n13 = ((TXCStreamDownloader$DownloadStats)object5).errorCode;
        ((StringBuilder)object4).append(n13);
        object4 = ((StringBuilder)object4).toString();
        TXCLog.i(string2, (String)object4);
        int n14 = 2001;
        this.sendNotifyEvent(n14, (String)object);
        object = this.mConnection.getHeaderField("X-Tlive-SpanId");
        object4 = this.mStats;
        ((TXCStreamDownloader$DownloadStats)object4).flvSessionKey = object;
        object = this.mFlvSessionKey;
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 == 0) {
            object = this.mConnection;
            object4 = this.mFlvSessionKey;
            if ((object = ((URLConnection)object).getHeaderField((String)object4)) != null) {
                object4 = new StringBuilder();
                object5 = "receive flvSessionKey ";
                ((StringBuilder)object4).append((String)object5);
                ((StringBuilder)object4).append((String)object);
                object4 = ((StringBuilder)object4).toString();
                TXCLog.i(string2, (String)object4);
                n11 = 2031;
                this.sendNotifyEvent(n11, (String)object);
            }
        }
    }

    private void disconnect() {
        TXCLog.i("network.TXCFLVDownloader", "[Network]FLVDownloader disconnect.");
        Object object = this.mConnection;
        if (object != null) {
            ((HttpURLConnection)object).disconnect();
            this.mConnection = null;
        }
        if ((object = this.mInputStream) != null) {
            ((InputStream)object).close();
            this.mInputStream = null;
        }
    }

    private native void nativeCleanData(long var1);

    private native int nativeGetAudioBytes(long var1);

    private native int nativeGetVideoBytes(long var1);

    private native int nativeGetVideoGop(long var1);

    private native long nativeInitFlvHander(String var1, int var2, boolean var3, boolean var4);

    private native long nativeInitFlvHanderByRef(long var1);

    private native int nativeParseData(long var1, byte[] var3, int var4);

    private native void nativeUninitFlvhander(long var1, boolean var3);

    private void onRecvFirstAudioData() {
        boolean bl2 = this.mHasReceivedFirstAudio;
        if (!bl2) {
            long l10;
            this.mHasReceivedFirstAudio = bl2 = true;
            Object object = this.mStats;
            ((TXCStreamDownloader$DownloadStats)object).firstAudioTS = l10 = TXCTimeUtil.getTimeTick();
            object = new StringBuilder();
            ((StringBuilder)object).append("[FirstFramePath][Network][Audio] TXCFlvDownloader: recv first audio frame. instance:");
            int n10 = this.hashCode();
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            String string2 = "network.TXCFLVDownloader";
            TXCLog.i(string2, (String)object);
        }
    }

    private void onRecvFirstVideoData() {
        boolean bl2 = this.mHasReceivedFirstVideo;
        if (!bl2) {
            long l10;
            this.mHasReceivedFirstVideo = bl2 = true;
            Object object = this.mStats;
            ((TXCStreamDownloader$DownloadStats)object).firstVideoTS = l10 = TXCTimeUtil.getTimeTick();
            object = new StringBuilder();
            ((StringBuilder)object).append("[FirstFramePath][Network][Video] TXCFlvDownloader: recv first video frame. instance:");
            int n10 = this.hashCode();
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            String string2 = "network.TXCFLVDownloader";
            TXCLog.i(string2, (String)object);
        }
    }

    private void postConnectMsg() {
        Message message = null;
        this.mInputStream = null;
        HttpURLConnection httpURLConnection = this.mConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.mConnection = null;
        }
        message = new Message();
        message.what = 100;
        message.arg1 = 0;
        httpURLConnection = this.mFlvHandler;
        if (httpURLConnection != null) {
            httpURLConnection.sendMessage(message);
        }
    }

    private void postDisconnectMsg() {
        Handler handler = this.mFlvHandler;
        if (handler != null) {
            int n10 = 102;
            handler.sendEmptyMessage(n10);
        }
    }

    private void postReconnectMsg() {
        Handler handler = this.mFlvHandler;
        if (handler != null) {
            int n10 = 103;
            int n11 = this.connectRetryInterval * 1000;
            long l10 = n11;
            handler.sendEmptyMessageDelayed(n10, l10);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void processMsgConnect() {
        block10: {
            block12: {
                block11: {
                    var1_1 = "network.TXCFLVDownloader";
                    var2_2 = -1 != 0;
                    try {
                        this.connect();
                        var3_3 = this.mFLVParser;
                        var5_4 = 0L;
                    }
                    catch (Error var8_11) {
                        TXCLog.e((String)var1_1, "[Network]error, reconnect");
                        this.mStats.errorCode = var2_2;
                        var1_1 = this.mStats;
                        var1_1.errorInfo = var7_6 = var8_11.toString();
                        var8_11.printStackTrace();
                        this.postReconnectMsg();
                        return;
                    }
                    catch (Exception var8_12) {
                        TXCLog.e((String)var1_1, "[Network]exception, reconnect");
                        this.mStats.errorCode = var2_2;
                        var1_1 = this.mStats;
                        var1_1.errorInfo = var7_7 = var8_12.toString();
                        var8_12.printStackTrace();
                        this.postReconnectMsg();
                        return;
                    }
                    catch (FileNotFoundException var8_13) {
                        TXCLog.e((String)var1_1, "[Network]file not found, reconnect");
                        this.mStats.errorCode = var2_2;
                        var1_1 = this.mStats;
                        var1_1.errorInfo = var7_8 = var8_13.toString();
                        var8_13.printStackTrace();
                        this.postReconnectMsg();
                        return;
                    }
                    catch (SocketTimeoutException var8_14) {
                        TXCLog.e((String)var1_1, "[Network]socket timeout, reconnect");
                        this.mStats.errorCode = var2_2;
                        var1_1 = this.mStats;
                        var1_1.errorInfo = var7_9 = var8_14.toString();
                        this.postReconnectMsg();
                        return;
                    }
                    var2_2 = (boolean)(var3_3 == var5_4 ? 0 : (var3_3 < var5_4 ? -1 : 1));
                    if (var2_2) break block10;
                    var7_5 = this.mRefFLVDownloader;
                    var8_10 = null;
                    if (var7_5 == null) break block11;
                    if ((var7_5 = (TXCFLVDownloader)var7_5.get()) == null) ** GOTO lbl38
                    var9_15 = var7_5.mIsRunning;
                    if (var9_15) {
                        var10_16 /* !! */  = new StringBuilder();
                        var11_18 = "[Network]init flv parser with old downloader:";
                        var10_16 /* !! */ .append(var11_18);
                        var12_20 = var7_5.hashCode();
                        var10_16 /* !! */ .append(var12_20);
                        var10_16 /* !! */  = var10_16 /* !! */ .toString();
                        TXCLog.i((String)var1_1, (String)var10_16 /* !! */ );
                        var7_5.mStopJitter = false;
                        var13_21 = var7_5.mFLVParser;
                    } else {
                        var10_17 = new StringBuilder();
                        var11_19 = "[Network]old downloader:";
                        var10_17.append(var11_19);
                        var2_2 = var7_5.hashCode();
                        var10_17.append((int)var2_2);
                        var10_17.append(" isn't running now. just create new parser.");
                        var7_5 = var10_17.toString();
                        TXCLog.e((String)var1_1, (String)var7_5);
lbl38:
                        // 2 sources

                        var13_21 = var5_4;
                    }
                    var2_2 = false;
                    var7_5 = null;
                    this.mRefFLVDownloader = null;
                    break block12;
                }
                var13_21 = var5_4;
            }
            var2_2 = (boolean)(var13_21 == var5_4 ? 0 : (var13_21 < var5_4 ? -1 : 1));
            if (var2_2) {
                var7_5 = new StringBuilder();
                var8_10 = "[Network]init flv parser with reference parse:";
                var7_5.append(var8_10);
                var7_5.append(var13_21);
                var7_5 = var7_5.toString();
                TXCLog.i((String)var1_1, (String)var7_5);
                this.mFLVParser = var15_22 = this.nativeInitFlvHanderByRef(var13_21);
            } else {
                var7_5 = "[Network]init flv parser.";
                TXCLog.i((String)var1_1, (String)var7_5);
                var1_1 = this.mUserID;
                var2_2 = this.mEnableMessage;
                var17_24 = this.mEnableMetaData;
                this.mFLVParser = var15_23 = this.nativeInitFlvHander((String)var1_1, 0, var2_2, var17_24);
            }
        }
        if ((var1_1 = this.mFlvHandler) != null) {
            var2_2 = 101 != 0;
            var1_1.sendEmptyMessage((int)var2_2);
        }
        return;
    }

    private void processMsgDisConnect() {
        try {
            this.disconnect();
        }
        catch (Exception exception) {
            String string2 = "network.TXCFLVDownloader";
            String string3 = "disconnect failed.";
            TXCLog.e(string2, string3, exception);
        }
        long l10 = this.mFLVParser;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            l12 = (long)this.mStopJitter;
            this.nativeUninitFlvhander(l10, (boolean)l12);
            this.mFLVParser = l11;
        }
    }

    private void processMsgReconnect() {
        boolean bl2 = this.mStopJitter;
        if (bl2) {
            this.reconnect();
        } else {
            Object object = new StringBuilder();
            ((StringBuilder)object).append("ignore processMsgReconnect when start multi stream switch");
            ((StringBuilder)object).append(this);
            object = ((StringBuilder)object).toString();
            String string2 = "network.TXCFLVDownloader";
            TXCLog.i(string2, (String)object);
            object = this.mRestartListener;
            if (object != null) {
                object.onOldStreamStop();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void processMsgRecvData() {
        Object object = "network.TXCFLVDownloader";
        Object object2 = this.mInputStream;
        if (object2 == null) return;
        String string2 = null;
        int n10 = -1;
        try {
            int n11;
            Object object3 = this.mPacketBytes;
            int n12 = 1388;
            int n13 = 0;
            Object object4 = null;
            int n14 = ((InputStream)object2).read((byte[])object3, 0, n12);
            if (n14 > 0) {
                long l10;
                long l11;
                long l12;
                String string3;
                long l13 = this.mDownloadedSize;
                long l14 = n14;
                this.mDownloadedSize = l13 += l14;
                n11 = (int)(this.mRecvData ? 1 : 0);
                if (n11 == 0) {
                    n11 = 1;
                    this.mRecvData = n11;
                    object3 = new StringBuilder();
                    string3 = "[FirstFramePath][Network] TXCFLVDownloader: recv first data packet. instance:";
                    ((StringBuilder)object3).append(string3);
                    n12 = this.hashCode();
                    ((StringBuilder)object3).append(n12);
                    object3 = ((StringBuilder)object3).toString();
                    TXCLog.i((String)object, (String)object3);
                }
                if ((l12 = (l11 = (l13 = this.mFLVParser) - (l10 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
                    object4 = this.mStats;
                    ((TXCStreamDownloader$DownloadStats)object4).beforeParseVideoBytes = l10 = ((TXCStreamDownloader$DownloadStats)object4).beforeParseVideoBytes + l14;
                    object4 = this.mPacketBytes;
                    n13 = this.nativeParseData(l13, (byte[])object4, n14);
                    object2 = this.mStats;
                    l13 = this.mFLVParser;
                    n11 = this.nativeGetVideoBytes(l13);
                    ((TXCStreamDownloader$DownloadStats)object2).afterParseVideoBytes = l13 = (long)n11;
                    object2 = this.mStats;
                    l13 = this.mFLVParser;
                    n11 = this.nativeGetAudioBytes(l13);
                    ((TXCStreamDownloader$DownloadStats)object2).afterParseAudioBytes = l13 = (long)n11;
                    object2 = this.mStats;
                    l13 = this.mFLVParser;
                    n11 = this.nativeGetVideoGop(l13);
                    ((TXCStreamDownloader$DownloadStats)object2).videoGop = l13 = (long)n11;
                }
                if (n13 > (n14 = 0x100000)) {
                    object3 = new StringBuilder();
                    string3 = "[Network]flv play parse frame: ";
                    ((StringBuilder)object3).append(string3);
                    ((StringBuilder)object3).append(n13);
                    string3 = " > ";
                    ((StringBuilder)object3).append(string3);
                    ((StringBuilder)object3).append(n14);
                    object2 = ",start reconnect";
                    ((StringBuilder)object3).append((String)object2);
                    object2 = ((StringBuilder)object3).toString();
                    TXCLog.e((String)object, (String)object2);
                    this.postReconnectMsg();
                    return;
                }
            } else if (n14 < 0) {
                object3 = new StringBuilder;
                object3 = new StringBuilder();
                String string4 = "[Network]http read: ";
                ((StringBuilder)object3).append(string4);
                ((StringBuilder)object3).append(n14);
                object2 = " < 0, start reconnect";
                ((StringBuilder)object3).append((String)object2);
                object2 = ((StringBuilder)object3).toString();
                TXCLog.e((String)object, (String)object2);
                this.postReconnectMsg();
                return;
            }
            if ((object2 = this.mFlvHandler) == null) return;
            n11 = 101;
            object2.sendEmptyMessage(n11);
            return;
        }
        catch (Error error) {
            String string5;
            String string6 = "[Network]error";
            TXCLog.e((String)object, string6);
            object = this.mStats;
            ((TXCStreamDownloader$DownloadStats)object).errorCode = n10;
            ((TXCStreamDownloader$DownloadStats)object).errorInfo = string5 = error.toString();
            error.printStackTrace();
            this.mInputStream = null;
            this.mConnection = null;
            return;
        }
        catch (Exception exception) {
            String string7;
            String string8 = "[Network]exception";
            TXCLog.e((String)object, string8);
            object = this.mStats;
            ((TXCStreamDownloader$DownloadStats)object).errorCode = n10;
            ((TXCStreamDownloader$DownloadStats)object).errorInfo = string7 = exception.toString();
            exception.printStackTrace();
            this.mInputStream = null;
            this.mConnection = null;
            return;
        }
        catch (EOFException eOFException) {
            String string9;
            string2 = "[Network]eof exception start reconnect";
            TXCLog.e((String)object, string2);
            object = this.mStats;
            ((TXCStreamDownloader$DownloadStats)object).errorCode = n10;
            ((TXCStreamDownloader$DownloadStats)object).errorInfo = string9 = eOFException.toString();
            this.postReconnectMsg();
            return;
        }
        catch (SSLException sSLException) {
            String string10;
            string2 = "[Network]ssl exception start reconnect";
            TXCLog.e((String)object, string2);
            object = this.mStats;
            ((TXCStreamDownloader$DownloadStats)object).errorCode = n10;
            ((TXCStreamDownloader$DownloadStats)object).errorInfo = string10 = sSLException.toString();
            this.postReconnectMsg();
            return;
        }
        catch (SocketException socketException) {
            String string11;
            string2 = "[Network]socket exception start reconnect";
            TXCLog.e((String)object, string2);
            object = this.mStats;
            ((TXCStreamDownloader$DownloadStats)object).errorCode = n10;
            ((TXCStreamDownloader$DownloadStats)object).errorInfo = string11 = socketException.toString();
            this.postReconnectMsg();
            return;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            String string12;
            string2 = "[Network]socket timeout start reconnect";
            TXCLog.e((String)object, string2);
            object = this.mStats;
            ((TXCStreamDownloader$DownloadStats)object).errorCode = n10;
            ((TXCStreamDownloader$DownloadStats)object).errorInfo = string12 = socketTimeoutException.toString();
            this.postReconnectMsg();
        }
    }

    private void reconnect() {
        this.processMsgDisConnect();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("ServerIp:");
        CharSequence charSequence2 = this.mStats.serverIP;
        charSequence.append((String)charSequence2);
        charSequence.append(",errCode:");
        int n10 = this.mStats.errorCode;
        charSequence.append(n10);
        charSequence.append(",errInfo:");
        charSequence2 = this.mStats.errorInfo;
        charSequence.append((String)charSequence2);
        charSequence = charSequence.toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("reconnect:");
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        String string2 = "network.TXCFLVDownloader";
        TXCLog.i(string2, (String)charSequence2);
        n10 = this.connectRetryTimes;
        int n11 = this.connectRetryLimit;
        if (n10 < n11) {
            this.connectRetryTimes = ++n10;
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append("[Network] start reconnect, times:");
            n11 = this.connectRetryTimes;
            ((StringBuilder)charSequence2).append(n11);
            String string3 = " limit:";
            ((StringBuilder)charSequence2).append(string3);
            n11 = this.connectRetryLimit;
            ((StringBuilder)charSequence2).append(n11);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            TXCLog.i(string2, (String)charSequence2);
            this.processMsgConnect();
            n10 = 2103;
            this.sendNotifyEvent(n10, (String)charSequence);
        } else {
            charSequence2 = new StringBuilder();
            String string4 = "[Network] reconnect fail. all times retried. limit:";
            ((StringBuilder)charSequence2).append(string4);
            n11 = this.connectRetryLimit;
            ((StringBuilder)charSequence2).append(n11);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            TXCLog.i(string2, (String)charSequence2);
            n10 = -2301;
            this.sendNotifyEvent(n10, (String)charSequence);
        }
    }

    private void startInternal() {
        Object object;
        Object object2 = this.mFlvThread;
        if (object2 == null) {
            object2 = new HandlerThread("FlvThread");
            this.mFlvThread = object2;
            object2.start();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("[Network] flv downloader thread id:");
            long l10 = this.mFlvThread.getId();
            ((StringBuilder)object2).append(l10);
            ((StringBuilder)object2).append(" instance:");
            int n10 = this.hashCode();
            ((StringBuilder)object2).append(n10);
            object2 = ((StringBuilder)object2).toString();
            object = "network.TXCFLVDownloader";
            TXCLog.i((String)object, (String)object2);
        }
        if ((object2 = this.mFlvHandler) == null) {
            object = this.mFlvThread.getLooper();
            object2 = new TXCFLVDownloader$1(this, (Looper)object);
            this.mFlvHandler = object2;
        }
        this.postConnectMsg();
    }

    public void PushAudioFrame(byte[] byArray, int n10, long l10, int n11) {
        long l11 = this.mFLVParser;
        this.nativePushAudioFrame(l11, byArray, n10, l10, n11);
    }

    public void PushVideoFrame(byte[] byArray, int n10, long l10, long l11, int n11) {
        long l12 = this.mFLVParser;
        this.nativePushVideoFrame(l12, byArray, n10, l10, l11, n11);
    }

    public long getCurrentTS() {
        return this.mCurrentNalTs;
    }

    public TXCStreamDownloader$DownloadStats getDownloadStats() {
        int n10;
        String string2;
        long l10;
        TXCStreamDownloader$DownloadStats tXCStreamDownloader$DownloadStats = new TXCStreamDownloader$DownloadStats();
        Object object = this.mStats;
        tXCStreamDownloader$DownloadStats.afterParseAudioBytes = l10 = ((TXCStreamDownloader$DownloadStats)object).afterParseAudioBytes;
        tXCStreamDownloader$DownloadStats.afterParseVideoBytes = l10 = ((TXCStreamDownloader$DownloadStats)object).afterParseVideoBytes;
        tXCStreamDownloader$DownloadStats.beforeParseVideoBytes = l10 = ((TXCStreamDownloader$DownloadStats)object).beforeParseVideoBytes;
        tXCStreamDownloader$DownloadStats.beforeParseAudioBytes = l10 = ((TXCStreamDownloader$DownloadStats)object).beforeParseAudioBytes;
        tXCStreamDownloader$DownloadStats.videoGop = l10 = ((TXCStreamDownloader$DownloadStats)object).videoGop;
        tXCStreamDownloader$DownloadStats.startTS = l10 = ((TXCStreamDownloader$DownloadStats)object).startTS;
        tXCStreamDownloader$DownloadStats.dnsTS = l10 = ((TXCStreamDownloader$DownloadStats)object).dnsTS;
        tXCStreamDownloader$DownloadStats.connTS = l10 = ((TXCStreamDownloader$DownloadStats)object).connTS;
        tXCStreamDownloader$DownloadStats.firstAudioTS = l10 = ((TXCStreamDownloader$DownloadStats)object).firstAudioTS;
        tXCStreamDownloader$DownloadStats.firstVideoTS = l10 = ((TXCStreamDownloader$DownloadStats)object).firstVideoTS;
        tXCStreamDownloader$DownloadStats.serverIP = string2 = ((TXCStreamDownloader$DownloadStats)object).serverIP;
        tXCStreamDownloader$DownloadStats.flvSessionKey = string2 = ((TXCStreamDownloader$DownloadStats)object).flvSessionKey;
        tXCStreamDownloader$DownloadStats.errorCode = n10 = ((TXCStreamDownloader$DownloadStats)object).errorCode;
        tXCStreamDownloader$DownloadStats.errorInfo = object = ((TXCStreamDownloader$DownloadStats)object).errorInfo;
        return tXCStreamDownloader$DownloadStats;
    }

    public long getLastIFrameTS() {
        return this.mLastIFramelTs;
    }

    public String getRealStreamUrl() {
        HttpURLConnection httpURLConnection = this.mConnection;
        if (httpURLConnection != null) {
            return httpURLConnection.getURL().toString();
        }
        return null;
    }

    public native void nativePushAudioFrame(long var1, byte[] var3, int var4, long var5, int var7);

    public native void nativePushVideoFrame(long var1, byte[] var3, int var4, long var5, long var7, int var9);

    public void onRecvAudioData(byte[] byArray, int n10, int n11, int n12) {
        long l10;
        Object object;
        boolean bl2 = this.mHasReceivedFirstAudio;
        if (!bl2) {
            this.mHasReceivedFirstAudio = bl2 = true;
            object = this.mStats;
            ((TXCStreamDownloader$DownloadStats)object).firstAudioTS = l10 = TXCTimeUtil.getTimeTick();
            object = new StringBuilder();
            ((StringBuilder)object).append("[FirstFramePath][Network][Audio] TXCFlvDownloader: recv first audio frame. instance:");
            int n13 = this.hashCode();
            ((StringBuilder)object).append(n13);
            object = ((StringBuilder)object).toString();
            String string2 = "network.TXCFLVDownloader";
            TXCLog.i(string2, (String)object);
        }
        object = this.mStats;
        l10 = ((TXCStreamDownloader$DownloadStats)object).afterParseAudioBytes;
        long l11 = byArray.length;
        ((TXCStreamDownloader$DownloadStats)object).afterParseAudioBytes = l10 += l11;
        super.onRecvAudioData(byArray, n10, n11, n12);
    }

    public void onRecvVideoData(byte[] byArray, int n10, long l10, long l11, int n11) {
        long l12;
        Object object;
        boolean bl2 = this.mHasReceivedFirstVideo;
        if (!bl2) {
            this.mHasReceivedFirstVideo = bl2 = true;
            object = this.mStats;
            ((TXCStreamDownloader$DownloadStats)object).firstVideoTS = l12 = TXCTimeUtil.getTimeTick();
            object = new StringBuilder();
            ((StringBuilder)object).append("[FirstFramePath][Network][Video] TXCFlvDownloader: recv first video frame. instance:");
            int n12 = this.hashCode();
            ((StringBuilder)object).append(n12);
            object = ((StringBuilder)object).toString();
            String string2 = "network.TXCFLVDownloader";
            TXCLog.i(string2, (String)object);
        }
        object = this.mStats;
        l12 = ((TXCStreamDownloader$DownloadStats)object).afterParseVideoBytes;
        long l13 = byArray.length;
        ((TXCStreamDownloader$DownloadStats)object).afterParseVideoBytes = l12 += l13;
        super.onRecvVideoData(byArray, n10, l10, l11, n11);
    }

    public void recvData(boolean bl2) {
        this.mHandleDataInJava = bl2;
    }

    public void startDownload(Vector object, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        bl2 = this.mIsRunning;
        if (bl2) {
            return;
        }
        if (object != null && !(bl2 = ((Vector)object).isEmpty())) {
            this.mEnableMessage = bl4;
            this.mEnableMetaData = bl5;
            this.mIsRunning = true;
            bl2 = false;
            this.mPlayUrl = object = ((e)object.get((int)0)).a;
            object = new StringBuilder();
            ((StringBuilder)object).append("start pull with url ");
            String string2 = this.mPlayUrl;
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            string2 = "network.TXCFLVDownloader";
            TXCLog.i(string2, (String)object);
            this.startInternal();
        }
    }

    public void stopDownload() {
        block7: {
            boolean bl2 = this.mIsRunning;
            if (!bl2) {
                return;
            }
            bl2 = false;
            this.mIsRunning = false;
            String string2 = "network.TXCFLVDownloader";
            String string3 = "stop pull";
            TXCLog.i(string2, string3);
            string3 = this.mFlvHandler;
            if (string3 == null) break block7;
            String string4 = null;
            string3.removeCallbacksAndMessages(null);
            string3 = this.mFlvHandler;
            int n10 = 102;
            string3.sendEmptyMessage(n10);
            string3 = this.mFlvHandler;
            n10 = 106;
            string3.sendEmptyMessage(n10);
            try {
                this.mFlvHandler = null;
            }
            catch (Exception exception) {
                string4 = "stop download failed.";
                TXCLog.e(string2, string4, exception);
            }
        }
    }
}

