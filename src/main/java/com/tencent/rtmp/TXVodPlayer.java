/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.view.Surface
 */
package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.h;
import com.tencent.liteav.m;
import com.tencent.liteav.network.f;
import com.tencent.liteav.network.g;
import com.tencent.liteav.network.i;
import com.tencent.liteav.network.j;
import com.tencent.liteav.q;
import com.tencent.liteav.txcvodplayer.TextureRenderView;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener;
import com.tencent.rtmp.TXPlayerAuthBuilder;
import com.tencent.rtmp.TXVodPlayConfig;
import com.tencent.rtmp.TXVodPlayer$1;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;

public class TXVodPlayer
implements b,
g {
    public static final int PLAYER_TYPE_EXO = 1;
    public static final int PLAYER_TYPE_FFPLAY = 0;
    public static final String TAG = "TXVodPlayer";
    private int mAudioPlayoutVolume = 100;
    private boolean mAutoPlay;
    private int mBitrateIndex;
    private TXVodPlayConfig mConfig;
    private Context mContext;
    private boolean mEnableHWDec = false;
    private boolean mIsGainAudioFocus;
    private boolean mIsGetPlayInfo;
    private ITXLivePlayListener mListener;
    private boolean mLoop;
    private boolean mMirror;
    private boolean mMute = false;
    private f mNetApi;
    private ITXVodPlayListener mNewListener;
    private String mPlayUrl = "";
    private m mPlayer;
    private float mRate;
    private int mRenderMode;
    private int mRenderRotation;
    private boolean mSnapshotRunning;
    public float mStartTime;
    private Surface mSurface;
    private TXCloudVideoView mTXCloudVideoView;
    private TextureRenderView mTextureView;
    private String mToken;

    public TXVodPlayer(Context context) {
        boolean bl2;
        this.mIsGainAudioFocus = bl2 = true;
        this.mAutoPlay = bl2;
        this.mRate = 1.0f;
        this.mSnapshotRunning = false;
        this.mListener = null;
        this.mNewListener = null;
        this.mContext = context = context.getApplicationContext();
        TXCCommonUtil.setAppContext(context);
        TXCLog.init();
    }

    public static /* synthetic */ boolean access$002(TXVodPlayer tXVodPlayer, boolean bl2) {
        tXVodPlayer.mSnapshotRunning = bl2;
        return bl2;
    }

    private String checkPlayUrl(String string2) {
        String string3 = TAG;
        Object object = "http";
        boolean bl2 = string2.startsWith((String)object);
        if (bl2) {
            object = "UTF-8";
            object = string2.getBytes((String)object);
            int n10 = ((Object)object).length;
            CharSequence charSequence = new StringBuilder(n10);
            n10 = 0;
            int n11 = 0;
            while (true) {
                char c10;
                block23: {
                    block22: {
                        c10 = ((Object)object).length;
                        if (n11 >= c10) break;
                        c10 = (char)object[n11];
                        if (c10 >= 0) break block22;
                        c10 = (char)(object[n11] + 256);
                        break block23;
                    }
                    c10 = (char)object[n11];
                }
                char c11 = ' ';
                char c12 = '%';
                if (c10 > c11 && c10 < (c11 = '\u007f') && c10 != (c11 = '\"') && c10 != c12 && c10 != (c11 = '<') && c10 != (c11 = '>') && c10 != (c11 = '[') && c10 != (c11 = '}') && c10 != (c11 = '\\') && c10 != (c11 = ']') && c10 != (c11 = '^') && c10 != (c11 = '`') && c10 != (c11 = '{') && c10 != (c11 = '|')) {
                    c10 = c10;
                    ((StringBuilder)charSequence).append(c10);
                } else {
                    if (c10 == c12) {
                        object = "URL has been transcoded";
                        TXCLog.w(string3, (String)object);
                        return string2;
                    }
                    String string4 = "%%%02X";
                    c12 = '\u0001';
                    Object[] objectArray = new Object[c12];
                    Object object2 = (int)c10;
                    objectArray[0] = object2;
                    object2 = String.format(string4, objectArray);
                    ((StringBuilder)charSequence).append((String)object2);
                }
                ++n11;
            }
            try {
                string2 = ((StringBuilder)charSequence).toString();
            }
            catch (Exception exception) {
                charSequence = "get utf-8 string failed.";
                TXCLog.e(string3, (String)charSequence, exception);
            }
        }
        return string2.trim();
    }

    private boolean isAVCDecBlacklistDevices() {
        String string2 = Build.MANUFACTURER;
        String string3 = "HUAWEI";
        boolean bl2 = string2.equalsIgnoreCase(string3);
        return bl2 && (bl2 = (string2 = Build.MODEL).equalsIgnoreCase(string3 = "Che2-TL00"));
    }

    private void postBitmapToMainThread(TXLivePlayer$ITXSnapshotListener tXLivePlayer$ITXSnapshotListener, Bitmap bitmap) {
        if (tXLivePlayer$ITXSnapshotListener == null) {
            return;
        }
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = new TXVodPlayer$1(this, tXLivePlayer$ITXSnapshotListener, bitmap);
        handler.post((Runnable)object);
    }

    public boolean enableHardwareDecode(boolean bl2) {
        if (bl2) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 18;
            String string2 = "HardwareDecode";
            if (n10 < n11) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("enableHardwareDecode failed, android system build.version = ");
                charSequence.append(n10);
                charSequence.append(", the minimum build.version should be 18(android 4.3 or later)");
                charSequence = charSequence.toString();
                TXCLog.e(string2, (String)charSequence);
                return false;
            }
            n10 = (int)(this.isAVCDecBlacklistDevices() ? 1 : 0);
            if (n10 != 0) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("enableHardwareDecode failed, MANUFACTURER = ");
                String string3 = Build.MANUFACTURER;
                charSequence.append(string3);
                charSequence.append(", MODEL");
                string3 = Build.MODEL;
                charSequence.append(string3);
                charSequence = charSequence.toString();
                TXCLog.e(string2, (String)charSequence);
                return false;
            }
        }
        this.mEnableHWDec = bl2;
        this.updateConfig();
        return true;
    }

    public int getBitrateIndex() {
        m m10 = this.mPlayer;
        if (m10 != null) {
            return m10.o();
        }
        return 0;
    }

    public float getBufferDuration() {
        m m10 = this.mPlayer;
        if (m10 != null) {
            return m10.j();
        }
        return 0.0f;
    }

    public float getCurrentPlaybackTime() {
        m m10 = this.mPlayer;
        if (m10 != null) {
            return m10.h();
        }
        return 0.0f;
    }

    public float getDuration() {
        m m10 = this.mPlayer;
        if (m10 != null) {
            return m10.k();
        }
        return 0.0f;
    }

    public int getHeight() {
        m m10 = this.mPlayer;
        if (m10 != null) {
            return m10.n();
        }
        return 0;
    }

    public float getPlayableDuration() {
        m m10 = this.mPlayer;
        if (m10 != null) {
            return m10.l();
        }
        return 0.0f;
    }

    public ArrayList getSupportedBitrates() {
        Object object = this.mPlayer;
        if (object != null) {
            return ((m)object).p();
        }
        object = new Object();
        return object;
    }

    public int getWidth() {
        m m10 = this.mPlayer;
        if (m10 != null) {
            return m10.m();
        }
        return 0;
    }

    public boolean isLoop() {
        return this.mLoop;
    }

    public boolean isPlaying() {
        m m10 = this.mPlayer;
        if (m10 != null) {
            return m10.c();
        }
        return false;
    }

    public void onNetFailed(f object, String string2, int n10) {
        f f10 = this.mNetApi;
        if (object != f10) {
            return;
        }
        this.mIsGetPlayInfo = false;
        object = new Bundle();
        object.putInt("EVT_ID", 2010);
        long l10 = TXCTimeUtil.getTimeTick();
        object.putLong("EVT_TIME", l10);
        l10 = TXCTimeUtil.getUtcTimeTick();
        object.putLong("EVT_UTC_TIME", l10);
        object.putString("EVT_MSG", string2);
        object.putInt("EVT_PARAM1", n10);
        this.onNotifyEvent(-2306, (Bundle)object);
        object = new StringBuilder();
        ((StringBuilder)object).append("onNetFailed: eventId: -2306 description:");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        TXCLog.i(TAG, (String)object);
    }

    public void onNetSuccess(f object) {
        Object object2 = this.mNetApi;
        if (object != object2) {
            return;
        }
        object = ((f)object).a();
        boolean bl2 = this.mIsGetPlayInfo;
        if (!bl2) {
            object2 = ((i)object).a();
            this.startPlay((String)object2);
        }
        bl2 = false;
        this.mIsGetPlayInfo = false;
        object2 = new Bundle();
        int n10 = 2010;
        object2.putInt("EVT_ID", n10);
        long l10 = TXCTimeUtil.getTimeTick();
        object2.putLong("EVT_TIME", l10);
        l10 = TXCTimeUtil.getUtcTimeTick();
        object2.putLong("EVT_UTC_TIME", l10);
        object2.putString("EVT_MSG", "Requested file information successfully");
        Object object3 = ((i)object).a();
        object2.putString("EVT_PLAY_URL", (String)object3);
        object3 = ((i)object).b();
        object2.putString("EVT_PLAY_COVER_URL", (String)object3);
        object3 = ((i)object).f();
        object2.putString("EVT_PLAY_NAME", (String)object3);
        object3 = ((i)object).g();
        String string2 = "EVT_PLAY_DESCRIPTION";
        object2.putString(string2, (String)object3);
        object3 = ((i)object).d();
        if (object3 != null) {
            object = ((i)object).d();
            int n11 = ((j)object).c();
            object3 = "EVT_PLAY_DURATION";
            object2.putInt((String)object3, n11);
        }
        this.onNotifyEvent(n10, (Bundle)object2);
        TXCLog.i(TAG, "onNetSuccess: Requested file information successfully");
    }

    public void onNotifyEvent(int n10, Bundle bundle) {
        Object object = null;
        int n11 = 15001;
        if (n10 == n11) {
            Object object2 = this.mTXCloudVideoView;
            if (object2 != null) {
                n11 = 0;
                Object var6_6 = null;
                object2.setLogText(bundle, null, 0);
            }
            if ((object2 = this.mListener) != null) {
                object2.onNetStatus(bundle);
            }
            if ((object2 = this.mNewListener) != null) {
                object2.onNetStatus(this, bundle);
            }
        } else {
            TXCloudVideoView tXCloudVideoView = this.mTXCloudVideoView;
            if (tXCloudVideoView != null) {
                tXCloudVideoView.setLogText(null, bundle, n10);
            }
            if ((object = this.mListener) != null) {
                object.onPlayEvent(n10, bundle);
            }
            if ((object = this.mNewListener) != null) {
                object.onPlayEvent(this, n10, bundle);
            }
        }
    }

    public void pause() {
        String string2 = "pause";
        TXCLog.i(TAG, string2);
        m m10 = this.mPlayer;
        if (m10 != null) {
            m10.a();
        }
    }

    public void resume() {
        String string2 = "resume";
        TXCLog.i(TAG, string2);
        m m10 = this.mPlayer;
        if (m10 != null) {
            m10.b();
        }
    }

    public void seek(float f10) {
        m m10 = this.mPlayer;
        if (m10 != null) {
            m10.a(f10);
        }
    }

    public void seek(int n10) {
        m m10 = this.mPlayer;
        if (m10 != null) {
            m10.e(n10);
        }
    }

    public void setAudioPlayoutVolume(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setAudioPlayoutVolume:");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        this.mAudioPlayoutVolume = n10;
        object = this.mPlayer;
        if (object != null) {
            ((m)object).f(n10);
        }
    }

    public void setAutoPlay(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setAutoPlay:");
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        this.mAutoPlay = bl2;
        object = this.mPlayer;
        if (object != null) {
            ((m)object).e(bl2);
        }
    }

    public void setBitrateIndex(int n10) {
        m m10 = this.mPlayer;
        if (m10 != null) {
            m10.g(n10);
        }
        this.mBitrateIndex = n10;
    }

    public void setConfig(TXVodPlayConfig object) {
        this.mConfig = object;
        if (object == null) {
            this.mConfig = object = new TXVodPlayConfig();
        }
        if ((object = this.mPlayer) != null) {
            int n10;
            int n11;
            if ((object = ((q)object).q()) == null) {
                object = new h();
            }
            Object object2 = this.mConfig;
            ((h)object).e = n11 = ((TXVodPlayConfig)object2).mConnectRetryCount;
            ((h)object).f = n11 = ((TXVodPlayConfig)object2).mConnectRetryInterval;
            ((h)object).r = n11 = ((TXVodPlayConfig)object2).mTimeout;
            n11 = (int)(this.mEnableHWDec ? 1 : 0);
            ((h)object).h = n11;
            Object object3 = ((TXVodPlayConfig)object2).mCacheFolderPath;
            ((h)object).n = object3;
            ((h)object).o = n11 = ((TXVodPlayConfig)object2).mMaxCacheItems;
            ((h)object).p = n11 = ((TXVodPlayConfig)object2).mPlayerType;
            ((h)object).q = object3 = ((TXVodPlayConfig)object2).mHeaders;
            n11 = (int)(((TXVodPlayConfig)object2).enableAccurateSeek ? 1 : 0);
            ((h)object).s = n11;
            n11 = (int)(((TXVodPlayConfig)object2).autoRotate ? 1 : 0);
            ((h)object).t = n11;
            n11 = (int)(((TXVodPlayConfig)object2).smoothSwitchBitrate ? 1 : 0);
            ((h)object).u = n11;
            ((h)object).v = object3 = ((TXVodPlayConfig)object2).cacheMp4ExtName;
            ((h)object).w = n11 = ((TXVodPlayConfig)object2).progressInterval;
            ((h)object).x = n10 = ((TXVodPlayConfig)object2).maxBufferSize;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("setConfig [connectRetryCount:");
            n11 = this.mConfig.mConnectRetryCount;
            ((StringBuilder)object2).append(n11);
            ((StringBuilder)object2).append("(default 3 times)][connectRetryInterval:");
            n11 = this.mConfig.mConnectRetryInterval;
            ((StringBuilder)object2).append(n11);
            ((StringBuilder)object2).append("(default 3s,min:3s max:30s)][vodTimeout:");
            n11 = this.mConfig.mTimeout;
            ((StringBuilder)object2).append(n11);
            ((StringBuilder)object2).append("(default 10s)][enableHardwareDecoder:");
            n11 = (int)(this.mEnableHWDec ? 1 : 0);
            ((StringBuilder)object2).append(n11 != 0);
            ((StringBuilder)object2).append("(default false)][cacheFolderPath for mp4/HLS:");
            object3 = this.mConfig.mCacheFolderPath;
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append("][maxCacheItems:");
            n11 = this.mConfig.mMaxCacheItems;
            ((StringBuilder)object2).append(n11);
            ((StringBuilder)object2).append("][enableAccurateSeek:");
            n11 = (int)(this.mConfig.enableAccurateSeek ? 1 : 0);
            ((StringBuilder)object2).append(n11 != 0);
            ((StringBuilder)object2).append("(default true)][autoRotate:");
            n11 = this.mConfig.autoRotate;
            ((StringBuilder)object2).append(n11 != 0);
            ((StringBuilder)object2).append("(default true)][HLS smoothSwitchBitrate:");
            n11 = this.mConfig.smoothSwitchBitrate;
            ((StringBuilder)object2).append(n11 != 0);
            ((StringBuilder)object2).append("(default false)][progressInterval:");
            n11 = this.mConfig.progressInterval;
            ((StringBuilder)object2).append(n11);
            ((StringBuilder)object2).append("(default 0.5s)][preload maxBufferSize:");
            n11 = this.mConfig.maxBufferSize;
            ((StringBuilder)object2).append(n11);
            ((StringBuilder)object2).append("]");
            object2 = ((StringBuilder)object2).toString();
            object3 = TAG;
            TXCLog.i((String)object3, (String)object2);
            object2 = this.mPlayer;
            ((m)object2).a((h)object);
        }
    }

    public void setLoop(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setLoop:");
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        this.mLoop = bl2;
        object = this.mPlayer;
        if (object != null) {
            ((m)object).f(bl2);
        }
    }

    public void setMirror(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setMirror:");
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        object = this.mPlayer;
        if (object != null) {
            ((m)object).g(bl2);
        }
        this.mMirror = bl2;
    }

    public void setMute(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setMute:");
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        this.mMute = bl2;
        object = this.mPlayer;
        if (object != null) {
            ((m)object).b(bl2);
        }
    }

    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        this.mListener = iTXLivePlayListener;
    }

    public void setPlayerView(TextureRenderView textureRenderView) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setPlayerView TextureRenderView:");
        ((StringBuilder)object).append(textureRenderView);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        this.mTextureView = textureRenderView;
        object = this.mPlayer;
        if (object != null) {
            ((m)object).a(textureRenderView);
        }
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setPlayerView TXCloudVideoView:");
        ((StringBuilder)object).append((Object)tXCloudVideoView);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        this.mTXCloudVideoView = tXCloudVideoView;
        object = this.mPlayer;
        if (object != null) {
            ((m)object).a(tXCloudVideoView);
        }
    }

    public void setRate(float f10) {
        this.mRate = f10;
        m m10 = this.mPlayer;
        if (m10 != null) {
            m10.b(f10);
        }
    }

    public void setRenderMode(int n10) {
        this.mRenderMode = n10;
        m m10 = this.mPlayer;
        if (m10 != null) {
            m10.a(n10);
        }
    }

    public void setRenderRotation(int n10) {
        this.mRenderRotation = n10;
        m m10 = this.mPlayer;
        if (m10 != null) {
            m10.b(n10);
        }
    }

    public boolean setRequestAudioFocus(boolean bl2) {
        this.mIsGainAudioFocus = bl2;
        m m10 = this.mPlayer;
        if (m10 != null) {
            return m10.d(bl2);
        }
        return true;
    }

    public void setStartTime(float f10) {
        this.mStartTime = f10;
    }

    public void setSurface(Surface surface) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setSurface Surface:");
        ((StringBuilder)object).append(surface);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        this.mSurface = surface;
        object = this.mPlayer;
        if (object != null) {
            ((m)object).a(surface);
        }
    }

    public void setToken(String string2) {
        this.mToken = string2;
    }

    public void setVodListener(ITXVodPlayListener iTXVodPlayListener) {
        this.mNewListener = iTXVodPlayListener;
    }

    public void snapshot(TXLivePlayer$ITXSnapshotListener tXLivePlayer$ITXSnapshotListener) {
        int n10 = this.mSnapshotRunning;
        if (n10 == 0 && tXLivePlayer$ITXSnapshotListener != null) {
            n10 = 1;
            float f10 = Float.MIN_VALUE;
            this.mSnapshotRunning = n10;
            m m10 = this.mPlayer;
            float f11 = 0.0f;
            if (m10 != null) {
                m10 = m10.d();
            } else {
                n10 = 0;
                m10 = null;
                f10 = 0.0f;
            }
            if (m10 != null) {
                Object object = m10.getBitmap();
                if (object != null) {
                    Matrix matrix = m10.getTransform(null);
                    n10 = this.mMirror;
                    if (n10 != 0) {
                        n10 = -1082130432;
                        f10 = -1.0f;
                        f11 = 1.0f;
                        matrix.postScale(f10, f11);
                    }
                    int n11 = object.getWidth();
                    int n12 = object.getHeight();
                    boolean bl2 = true;
                    m10 = Bitmap.createBitmap((Bitmap)object, (int)0, (int)0, (int)n11, (int)n12, (Matrix)matrix, (boolean)bl2);
                    object.recycle();
                    object = m10;
                }
                this.postBitmapToMainThread(tXLivePlayer$ITXSnapshotListener, (Bitmap)object);
            } else {
                tXLivePlayer$ITXSnapshotListener = null;
                this.mSnapshotRunning = false;
            }
        }
    }

    public int startPlay(TXPlayerAuthBuilder tXPlayerAuthBuilder) {
        Object object = new f();
        this.mNetApi = object;
        int n10 = tXPlayerAuthBuilder.isHttps;
        ((f)object).a(n10 != 0);
        this.mNetApi.a(this);
        object = new StringBuilder();
        ((StringBuilder)object).append("startPlay [FileId:");
        String string2 = tXPlayerAuthBuilder.fileId;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("][Timeout:");
        string2 = tXPlayerAuthBuilder.timeout;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("][Unique identification request:");
        string2 = tXPlayerAuthBuilder.us;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("][Trial duration:");
        n10 = tXPlayerAuthBuilder.exper;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("][Sign:");
        string2 = tXPlayerAuthBuilder.sign;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("]");
        object = ((StringBuilder)object).toString();
        TXCLog.i(TAG, (String)object);
        f f10 = this.mNetApi;
        int n11 = tXPlayerAuthBuilder.appId;
        String string3 = tXPlayerAuthBuilder.fileId;
        String string4 = tXPlayerAuthBuilder.timeout;
        String string5 = tXPlayerAuthBuilder.us;
        int n12 = tXPlayerAuthBuilder.exper;
        String string6 = tXPlayerAuthBuilder.sign;
        return f10.a(n11, string3, string4, string5, n12, string6);
    }

    public int startPlay(String object) {
        int n10;
        Object object2 = TAG;
        if (object != null && (n10 = TextUtils.isEmpty((CharSequence)object)) == 0) {
            CharSequence charSequence;
            int n11;
            TXCDRApi.initCrashReport(this.mContext);
            n10 = this.mBitrateIndex;
            this.stopPlay(false);
            this.mBitrateIndex = n10;
            Object object3 = this.mToken;
            if (object3 != null && (object3 = Uri.parse((String)object).getPath()) != null && (n11 = ((String[])(object3 = ((String)object3).split((String)(charSequence = "/")))).length) > 0) {
                n11 = ((String[])object3).length + -1;
                object3 = object3[n11];
                n10 = ((String)object).lastIndexOf((String)object3);
                charSequence = new StringBuilder();
                String string2 = ((String)object).substring(0, n10);
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append("voddrm.token.");
                string2 = this.mToken;
                ((StringBuilder)charSequence).append(string2);
                string2 = ".";
                ((StringBuilder)charSequence).append(string2);
                object = ((String)object).substring(n10);
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
            }
            this.mPlayUrl = object = this.checkPlayUrl((String)object);
            object = "===========================================================================================================================================================";
            TXCLog.i((String)object2, (String)object);
            TXCLog.i((String)object2, (String)object);
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("=====  StartPlay url = ");
            charSequence = this.mPlayUrl;
            ((StringBuilder)object3).append((String)charSequence);
            ((StringBuilder)object3).append(" SDKVersion = ");
            n11 = TXCCommonUtil.getSDKID();
            ((StringBuilder)object3).append(n11);
            ((StringBuilder)object3).append(" , ");
            charSequence = TXCCommonUtil.getSDKVersionStr();
            ((StringBuilder)object3).append((String)charSequence);
            charSequence = "    ======";
            ((StringBuilder)object3).append((String)charSequence);
            object3 = ((StringBuilder)object3).toString();
            TXCLog.i((String)object2, (String)object3);
            TXCLog.i((String)object2, (String)object);
            TXCLog.i((String)object2, (String)object);
            object = this.mPlayer;
            if (object == null) {
                object2 = this.mContext;
                this.mPlayer = object = new m((Context)object2);
            }
            this.updateConfig();
            object = this.mTXCloudVideoView;
            if (object != null) {
                ((TXCloudVideoView)((Object)object)).clearLog();
                this.mTXCloudVideoView.setVisibility(0);
                object = this.mPlayer;
                object2 = this.mTXCloudVideoView;
                ((m)object).a((TXCloudVideoView)((Object)object2));
            } else {
                object = this.mSurface;
                if (object != null) {
                    object2 = this.mPlayer;
                    ((m)object2).a((Surface)object);
                } else {
                    object = this.mTextureView;
                    if (object != null) {
                        object2 = this.mPlayer;
                        ((m)object2).a((TextureRenderView)object);
                    }
                }
            }
            object = this.mPlayer;
            int bl2 = this.mBitrateIndex;
            ((m)object).g(bl2);
            this.mPlayer.a(this);
            object = this.mPlayer;
            boolean bl3 = this.mIsGainAudioFocus;
            ((m)object).d(bl3);
            object = this.mPlayer;
            boolean bl4 = this.mAutoPlay;
            ((m)object).e(bl4);
            object = this.mPlayer;
            float f10 = this.mStartTime;
            ((m)object).c(f10);
            object = this.mPlayer;
            object2 = this.mPlayUrl;
            ((m)object).a((String)object2, 0);
            object = this.mPlayer;
            boolean bl5 = this.mMute;
            ((m)object).b(bl5);
            object = this.mPlayer;
            int n12 = this.mAudioPlayoutVolume;
            ((m)object).f(n12);
            object = this.mPlayer;
            f10 = this.mRate;
            ((m)object).b(f10);
            object = this.mPlayer;
            int n13 = this.mRenderRotation;
            ((m)object).b(n13);
            object = this.mPlayer;
            int n14 = this.mRenderMode;
            ((m)object).a(n14);
            object = this.mPlayer;
            boolean bl6 = this.mLoop;
            ((m)object).f(bl6);
            boolean bl7 = this.mMirror;
            this.setMirror(bl7);
            return 0;
        }
        TXCLog.i((String)object2, "startPlay playUrl is empty");
        return -1;
    }

    public int stopPlay(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("stopPlay needClearLastImg:");
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        if (bl2 && (object = this.mTXCloudVideoView) != null) {
            int n10 = 8;
            object.setVisibility(n10);
        }
        if ((object = this.mPlayer) != null) {
            ((m)object).a(bl2);
        }
        this.mPlayUrl = "";
        f f10 = this.mNetApi;
        if (f10 != null) {
            object = null;
            f10.a((g)null);
            this.mNetApi = null;
        }
        this.mBitrateIndex = 0;
        this.mIsGetPlayInfo = false;
        return 0;
    }

    public void updateConfig() {
        TXVodPlayConfig tXVodPlayConfig = this.mConfig;
        this.setConfig(tXVodPlayConfig);
    }
}

