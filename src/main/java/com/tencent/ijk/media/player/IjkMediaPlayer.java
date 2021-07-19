/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.media.RingtoneManager
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Looper
 *  android.os.Message
 *  android.os.ParcelFileDescriptor
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.Surface
 *  android.view.SurfaceHolder
 */
package com.tencent.ijk.media.player;

import android.content.ContentResolver;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.ijk.media.player.AbstractMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IjkLibLoader;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.ijk.media.player.IjkMediaMeta$IjkStreamMeta;
import com.tencent.ijk.media.player.IjkMediaPlayer$1;
import com.tencent.ijk.media.player.IjkMediaPlayer$2;
import com.tencent.ijk.media.player.IjkMediaPlayer$DefaultMediaCodecSelector;
import com.tencent.ijk.media.player.IjkMediaPlayer$EventHandler;
import com.tencent.ijk.media.player.IjkMediaPlayer$OnControlMessageListener;
import com.tencent.ijk.media.player.IjkMediaPlayer$OnMediaCodecSelectListener;
import com.tencent.ijk.media.player.IjkMediaPlayer$OnNativeInvokeListener;
import com.tencent.ijk.media.player.MediaInfo;
import com.tencent.ijk.media.player.misc.IAndroidIO;
import com.tencent.ijk.media.player.misc.IMediaDataSource;
import com.tencent.ijk.media.player.misc.IjkTrackInfo;
import com.tencent.ijk.media.player.pragma.DebugLog;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Map;

public final class IjkMediaPlayer
extends AbstractMediaPlayer {
    public static final int FFP_PROPV_DECODER_AVCODEC = 1;
    public static final int FFP_PROPV_DECODER_MEDIACODEC = 2;
    public static final int FFP_PROPV_DECODER_UNKNOWN = 0;
    public static final int FFP_PROPV_DECODER_VIDEOTOOLBOX = 3;
    public static final int FFP_PROP_FLOAT_AVDELAY = 10004;
    public static final int FFP_PROP_FLOAT_AVDIFF = 10005;
    public static final int FFP_PROP_FLOAT_DROP_FRAME_RATE = 10007;
    public static final int FFP_PROP_FLOAT_PLAYBACK_RATE = 10003;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS = 20201;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY = 20203;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS = 20202;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_BYTES = 20008;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_DURATION = 20006;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_PACKETS = 20010;
    public static final int FFP_PROP_INT64_AUDIO_DECODER = 20004;
    public static final int FFP_PROP_INT64_BIT_RATE = 20100;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES = 20208;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS = 20206;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS = 20207;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS = 20205;
    public static final int FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION = 20300;
    public static final int FFP_PROP_INT64_LOGICAL_FILE_SIZE = 20209;
    public static final int FFP_PROP_INT64_SELECTED_AUDIO_STREAM = 20002;
    public static final int FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM = 20011;
    public static final int FFP_PROP_INT64_SELECTED_VIDEO_STREAM = 20001;
    public static final int FFP_PROP_INT64_TCP_SPEED = 20200;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT = 20204;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_BYTES = 20007;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_DURATION = 20005;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_PACKETS = 20009;
    public static final int FFP_PROP_INT64_VIDEO_DECODER = 20003;
    public static final int IJK_LOG_DEBUG = 3;
    public static final int IJK_LOG_DEFAULT = 1;
    public static final int IJK_LOG_ERROR = 6;
    public static final int IJK_LOG_FATAL = 7;
    public static final int IJK_LOG_INFO = 4;
    public static final int IJK_LOG_SILENT = 8;
    public static final int IJK_LOG_UNKNOWN = 0;
    public static final int IJK_LOG_VERBOSE = 2;
    public static final int IJK_LOG_WARN = 5;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_ERROR = 100;
    private static final int MEDIA_HEVC_VIDEO_DECODER_ERROR = 211;
    private static final int MEDIA_HLS_KEY_ERROR = 210;
    private static final int MEDIA_INFO = 200;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    public static final int MEDIA_SET_VIDEO_SAR = 10001;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_TIMED_TEXT = 99;
    private static final int MEDIA_VIDEO_DECODER_ERROR = 212;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND = 10001;
    public static final int PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND = 10002;
    public static final int SDL_FCC_RV16 = 909203026;
    public static final int SDL_FCC_RV32 = 842225234;
    public static final int SDL_FCC_YV12 = 842094169;
    private static final String TAG = "com.tencent.ijk.media.player.IjkMediaPlayer";
    private static volatile boolean mIsLibLoaded;
    private static volatile boolean mIsNativeInitialized;
    private static final IjkLibLoader sLocalLibLoader;
    private int mBitrateIndex;
    private String mDataSource;
    private IjkMediaPlayer$EventHandler mEventHandler;
    private int mListenerContext;
    private long mNativeAndroidIO;
    private long mNativeMediaDataSource;
    private long mNativeMediaPlayer;
    private int mNativeSurfaceTexture;
    private IjkMediaPlayer$OnControlMessageListener mOnControlMessageListener;
    private IjkMediaPlayer$OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    private IjkMediaPlayer$OnNativeInvokeListener mOnNativeInvokeListener;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private PowerManager.WakeLock mWakeLock;

    static {
        IjkMediaPlayer$1 ijkMediaPlayer$1 = new IjkMediaPlayer$1();
        sLocalLibLoader = ijkMediaPlayer$1;
        mIsLibLoaded = false;
        mIsNativeInitialized = false;
    }

    public IjkMediaPlayer() {
        IjkLibLoader ijkLibLoader = sLocalLibLoader;
        this(ijkLibLoader);
    }

    public IjkMediaPlayer(IjkLibLoader ijkLibLoader) {
        this.mWakeLock = null;
        this.initPlayer(ijkLibLoader);
    }

    private native String _getAudioCodecInfo();

    private static native String _getColorFormatName(int var0);

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native float _getPropertyFloat(int var1, float var2);

    private native long _getPropertyLong(int var1, long var2);

    private native String _getVideoCodecInfo();

    private native void _injectCacheNode(int var1, long var2, long var4, long var6, long var8);

    private native void _pause();

    private native void _release();

    private native void _reset();

    private native void _setAndroidIOCallback(IAndroidIO var1);

    private native void _setAudioVolume(int var1);

    private native void _setDataSource(IMediaDataSource var1);

    private native void _setDataSource(String var1, String[] var2, String[] var3);

    private native void _setDataSourceFd(int var1);

    private native void _setFrameAtTime(String var1, long var2, long var4, int var6, int var7);

    private native void _setLoopCount(int var1);

    private native void _setOption(int var1, String var2, long var3);

    private native void _setOption(int var1, String var2, String var3);

    private native void _setPropertyFloat(int var1, float var2);

    private native void _setPropertyLong(int var1, long var2);

    private native void _setStreamSelected(int var1, boolean var2);

    private native void _setVideoSurface(Surface var1);

    private native void _start();

    private native void _stop();

    public static /* synthetic */ void access$000(IjkMediaPlayer ijkMediaPlayer) {
        ijkMediaPlayer._release();
    }

    public static /* synthetic */ long access$100(IjkMediaPlayer ijkMediaPlayer) {
        return ijkMediaPlayer.mNativeMediaPlayer;
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public static /* synthetic */ void access$300(IjkMediaPlayer ijkMediaPlayer, boolean bl2) {
        ijkMediaPlayer.stayAwake(bl2);
    }

    public static /* synthetic */ int access$400(IjkMediaPlayer ijkMediaPlayer) {
        return ijkMediaPlayer.mVideoWidth;
    }

    public static /* synthetic */ int access$402(IjkMediaPlayer ijkMediaPlayer, int n10) {
        ijkMediaPlayer.mVideoWidth = n10;
        return n10;
    }

    public static /* synthetic */ int access$500(IjkMediaPlayer ijkMediaPlayer) {
        return ijkMediaPlayer.mVideoHeight;
    }

    public static /* synthetic */ int access$502(IjkMediaPlayer ijkMediaPlayer, int n10) {
        ijkMediaPlayer.mVideoHeight = n10;
        return n10;
    }

    public static /* synthetic */ int access$600(IjkMediaPlayer ijkMediaPlayer) {
        return ijkMediaPlayer.mVideoSarNum;
    }

    public static /* synthetic */ int access$602(IjkMediaPlayer ijkMediaPlayer, int n10) {
        ijkMediaPlayer.mVideoSarNum = n10;
        return n10;
    }

    public static /* synthetic */ int access$700(IjkMediaPlayer ijkMediaPlayer) {
        return ijkMediaPlayer.mVideoSarDen;
    }

    public static /* synthetic */ int access$702(IjkMediaPlayer ijkMediaPlayer, int n10) {
        ijkMediaPlayer.mVideoSarDen = n10;
        return n10;
    }

    public static String getColorFormatName(int n10) {
        return IjkMediaPlayer._getColorFormatName(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void initNativeOnce() {
        Class<IjkMediaPlayer> clazz = IjkMediaPlayer.class;
        synchronized (clazz) {
            boolean bl2 = mIsNativeInitialized;
            if (!bl2) {
                IjkMediaPlayer.native_init();
                mIsNativeInitialized = bl2 = true;
            }
            return;
        }
    }

    private void initPlayer(IjkLibLoader looper) {
        IjkMediaPlayer.loadLibrariesOnce((IjkLibLoader)looper);
        IjkMediaPlayer.initNativeOnce();
        looper = Looper.myLooper();
        if (looper != null) {
            IjkMediaPlayer$EventHandler ijkMediaPlayer$EventHandler;
            this.mEventHandler = ijkMediaPlayer$EventHandler = new IjkMediaPlayer$EventHandler(this, looper);
        } else {
            looper = Looper.getMainLooper();
            if (looper != null) {
                IjkMediaPlayer$EventHandler ijkMediaPlayer$EventHandler;
                this.mEventHandler = ijkMediaPlayer$EventHandler = new IjkMediaPlayer$EventHandler(this, looper);
            } else {
                looper = null;
                this.mEventHandler = null;
            }
        }
        looper = new Looper(this);
        this.native_setup(looper);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void loadLibrariesOnce(IjkLibLoader ijkLibLoader) {
        Class<IjkMediaPlayer> clazz = IjkMediaPlayer.class;
        synchronized (clazz) {
            boolean bl2 = mIsLibLoaded;
            if (!bl2) {
                boolean bl3;
                if (ijkLibLoader == null) {
                    ijkLibLoader = sLocalLibLoader;
                }
                String string2 = "txffmpeg";
                ijkLibLoader.loadLibrary(string2);
                string2 = "txsdl";
                ijkLibLoader.loadLibrary(string2);
                string2 = "txplayer";
                ijkLibLoader.loadLibrary(string2);
                mIsLibLoaded = bl3 = true;
            }
            return;
        }
    }

    private native void native_finalize();

    private static native void native_init();

    private native void native_message_loop(Object var1);

    public static native void native_profileBegin(String var0);

    public static native void native_profileEnd();

    public static native void native_setLogLevel(int var0);

    private native void native_setup(Object var1);

    private static boolean onNativeInvoke(Object object, int n10, Bundle bundle) {
        int n11;
        if (object != null && (n11 = object instanceof WeakReference) != 0) {
            if ((object = (IjkMediaPlayer)((WeakReference)object).get()) != null) {
                Object object2 = ((IjkMediaPlayer)object).mOnNativeInvokeListener;
                boolean bl2 = true;
                if (object2 != null && (n11 = (int)(object2.onNativeInvoke(n10, bundle) ? 1 : 0)) != 0) {
                    return bl2;
                }
                n11 = 131079;
                if (n10 != n11) {
                    return false;
                }
                object = ((IjkMediaPlayer)object).mOnControlMessageListener;
                if (object == null) {
                    return false;
                }
                object2 = "segment_index";
                n10 = bundle.getInt((String)object2, -1);
                if (n10 >= 0) {
                    if ((object = object.onControlResolveSegmentUrl(n10)) != null) {
                        bundle.putString("url", (String)object);
                        return bl2;
                    }
                    IOException iOException = new IOException("onNativeInvoke() = <NULL newUrl>");
                    object = new RuntimeException(iOException);
                    throw object;
                }
                object = new InvalidParameterException("onNativeInvoke(invalid segment index)");
                throw object;
            }
            object = new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
            throw object;
        }
        object = new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        throw object;
    }

    private static String onSelectCodec(Object object, String string2, int n10, int n11) {
        boolean bl2;
        IjkMediaPlayer$OnMediaCodecSelectListener ijkMediaPlayer$OnMediaCodecSelectListener = null;
        if (object != null && (bl2 = object instanceof WeakReference)) {
            if ((object = (IjkMediaPlayer)((WeakReference)object).get()) == null) {
                return null;
            }
            ijkMediaPlayer$OnMediaCodecSelectListener = ((IjkMediaPlayer)object).mOnMediaCodecSelectListener;
            if (ijkMediaPlayer$OnMediaCodecSelectListener == null) {
                ijkMediaPlayer$OnMediaCodecSelectListener = IjkMediaPlayer$DefaultMediaCodecSelector.sInstance;
            }
            return ijkMediaPlayer$OnMediaCodecSelectListener.onMediaCodecSelect((IMediaPlayer)object, string2, n10, n11);
        }
        return null;
    }

    private static void postEventFromNative(Object object, int n10, int n11, int n12, Object object2) {
        IjkMediaPlayer$EventHandler ijkMediaPlayer$EventHandler;
        if (object == null) {
            return;
        }
        if ((object = (IjkMediaPlayer)((WeakReference)object).get()) == null) {
            return;
        }
        int n13 = 200;
        if (n10 == n13 && n11 == (n13 = 2)) {
            ((IjkMediaPlayer)object).start();
        }
        if ((ijkMediaPlayer$EventHandler = ((IjkMediaPlayer)object).mEventHandler) != null) {
            Message message = ijkMediaPlayer$EventHandler.obtainMessage(n10, n11, n12, object2);
            object = ((IjkMediaPlayer)object).mEventHandler;
            object.sendMessage(message);
        }
    }

    private void setDataSource(FileDescriptor fileDescriptor, long l10, long l11) {
        this.setDataSource(fileDescriptor);
    }

    private void stayAwake(boolean bl2) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            boolean bl3;
            if (bl2 && !(bl3 = wakeLock.isHeld())) {
                wakeLock = this.mWakeLock;
                wakeLock.acquire();
            } else if (!bl2 && (bl3 = (wakeLock = this.mWakeLock).isHeld())) {
                wakeLock = this.mWakeLock;
                wakeLock.release();
            }
        }
        this.mStayAwake = bl2;
        this.updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            boolean bl2 = this.mScreenOnWhilePlaying;
            bl2 = bl2 && (bl2 = this.mStayAwake);
            surfaceHolder.setKeepScreenOn(bl2);
        }
    }

    public native void _prepareAsync();

    public native void _set_bitrate_index(int var1);

    public void deselectTrack(int n10) {
        this._setStreamSelected(n10, false);
    }

    public void finalize() {
        super.finalize();
        this.native_finalize();
    }

    public float getAVDelay() {
        return this._getPropertyFloat(10004, 0.0f);
    }

    public float getAVDiff() {
        return this._getPropertyFloat(10005, 0.0f);
    }

    public long getAsyncStatisticBufBackwards() {
        return this._getPropertyLong(20201, 0L);
    }

    public long getAsyncStatisticBufCapacity() {
        return this._getPropertyLong(20203, 0L);
    }

    public long getAsyncStatisticBufForwards() {
        return this._getPropertyLong(20202, 0L);
    }

    public long getAudioCachedBytes() {
        return this._getPropertyLong(20008, 0L);
    }

    public long getAudioCachedDuration() {
        return this._getPropertyLong(20006, 0L);
    }

    public long getAudioCachedPackets() {
        return this._getPropertyLong(20010, 0L);
    }

    public native int getAudioSessionId();

    public long getBitRate() {
        return this._getPropertyLong(20100, 0L);
    }

    public int getBitrateIndex() {
        return this.mBitrateIndex;
    }

    public long getCacheStatisticCountBytes() {
        return this._getPropertyLong(20208, 0L);
    }

    public long getCacheStatisticFileForwards() {
        return this._getPropertyLong(20206, 0L);
    }

    public long getCacheStatisticFilePos() {
        return this._getPropertyLong(20207, 0L);
    }

    public long getCacheStatisticPhysicalPos() {
        return this._getPropertyLong(20205, 0L);
    }

    public native long getCurrentPosition();

    public String getDataSource() {
        return this.mDataSource;
    }

    public float getDropFrameRate() {
        return this._getPropertyFloat(10007, 0.0f);
    }

    public native long getDuration();

    public long getFileSize() {
        return this._getPropertyLong(20209, 0L);
    }

    public MediaInfo getMediaInfo() {
        Bundle bundle;
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.mMediaPlayerName = "ijkplayer";
        Object object = this._getVideoCodecInfo();
        int n10 = TextUtils.isEmpty((CharSequence)object);
        String string2 = "";
        int n11 = 2;
        String string3 = ",";
        int n12 = 1;
        if (n10 == 0) {
            n10 = ((String[])(object = object.split(string3))).length;
            if (n10 >= n11) {
                bundle = object[0];
                mediaInfo.mVideoDecoder = bundle;
                object = object[n12];
                mediaInfo.mVideoDecoderImpl = object;
            } else {
                n10 = ((String[])object).length;
                if (n10 >= n12) {
                    object = object[0];
                    mediaInfo.mVideoDecoder = object;
                    mediaInfo.mVideoDecoderImpl = string2;
                }
            }
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object = this._getAudioCodecInfo()))) == 0) {
            n10 = ((Bundle)(object = object.split(string3))).length;
            if (n10 >= n11) {
                bundle = object[0];
                mediaInfo.mAudioDecoder = bundle;
                object = object[n12];
                mediaInfo.mAudioDecoderImpl = object;
            } else {
                n10 = ((Bundle)object).length;
                if (n10 >= n12) {
                    object = object[0];
                    mediaInfo.mAudioDecoder = object;
                    mediaInfo.mAudioDecoderImpl = string2;
                }
            }
        }
        object = this._getMediaMeta();
        object = IjkMediaMeta.parse(object);
        try {
            mediaInfo.mMeta = object;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return mediaInfo;
    }

    public Bundle getMediaMeta() {
        return this._getMediaMeta();
    }

    public float getRate() {
        return this.getSpeed();
    }

    public long getSeekLoadDuration() {
        return this._getPropertyLong(20300, 0L);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int getSelectedTrack(int n10) {
        long l10;
        int n11 = 1;
        long l11 = -1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return -1;
                }
                n10 = 20011;
                l10 = this._getPropertyLong(n10, l11);
                return (int)l10;
            }
            n10 = 20002;
            l10 = this._getPropertyLong(n10, l11);
            return (int)l10;
        }
        n10 = 20001;
        l10 = this._getPropertyLong(n10, l11);
        return (int)l10;
    }

    public float getSpeed() {
        return this._getPropertyFloat(10003, 0.0f);
    }

    public ArrayList getSupportedBitrates() {
        return this.getMediaInfo().mMeta.mBitrateItems;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public long getTcpSpeed() {
        return this._getPropertyLong(20200, 0L);
    }

    public IjkTrackInfo[] getTrackInfo() {
        Object object;
        Object object2 = this.getMediaMeta();
        ArrayList<IjkTrackInfo> arrayList = null;
        if (object2 == null) {
            return null;
        }
        if ((object2 = IjkMediaMeta.parse((Bundle)object2)) != null && (object = ((IjkMediaMeta)object2).mStreams) != null) {
            int n10;
            arrayList = new ArrayList<IjkTrackInfo>();
            object2 = ((IjkMediaMeta)object2).mStreams.iterator();
            while ((n10 = object2.hasNext()) != 0) {
                object = (IjkMediaMeta$IjkStreamMeta)object2.next();
                IjkTrackInfo ijkTrackInfo = new IjkTrackInfo((IjkMediaMeta$IjkStreamMeta)object);
                String string2 = ((IjkMediaMeta$IjkStreamMeta)object).mType;
                String string3 = "video";
                boolean bl2 = string2.equalsIgnoreCase(string3);
                if (bl2) {
                    n10 = 1;
                    ijkTrackInfo.setTrackType(n10);
                } else {
                    string2 = ((IjkMediaMeta$IjkStreamMeta)object).mType;
                    string3 = "audio";
                    bl2 = string2.equalsIgnoreCase(string3);
                    if (bl2) {
                        n10 = 2;
                        ijkTrackInfo.setTrackType(n10);
                    } else {
                        object = ((IjkMediaMeta$IjkStreamMeta)object).mType;
                        string2 = "timedtext";
                        n10 = (int)(((String)object).equalsIgnoreCase(string2) ? 1 : 0);
                        if (n10 != 0) {
                            n10 = 3;
                            ijkTrackInfo.setTrackType(n10);
                        }
                    }
                }
                arrayList.add(ijkTrackInfo);
            }
            object2 = new IjkTrackInfo[arrayList.size()];
            return (IjkTrackInfo[])arrayList.toArray((T[])object2);
        }
        return null;
    }

    public long getTrafficStatisticByteCount() {
        return this._getPropertyLong(20204, 0L);
    }

    public long getVideoCachedBytes() {
        return this._getPropertyLong(20007, 0L);
    }

    public long getVideoCachedDuration() {
        return this._getPropertyLong(20005, 0L);
    }

    public long getVideoCachedPackets() {
        return this._getPropertyLong(20009, 0L);
    }

    public float getVideoDecodeFramesPerSecond() {
        return this._getPropertyFloat(10001, 0.0f);
    }

    public int getVideoDecoder() {
        return (int)this._getPropertyLong(20003, 0L);
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public float getVideoOutputFramesPerSecond() {
        return this._getPropertyFloat(10002, 0.0f);
    }

    public int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    public int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public void injectCacheNode(int n10, long l10, long l11, long l12, long l13) {
        this._injectCacheNode(n10, l10, l11, l12, l13);
    }

    public boolean isLooping() {
        int n10;
        int n11 = this._getLoopCount();
        if (n11 == (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean isPlayable() {
        return true;
    }

    public native boolean isPlaying();

    public void pause() {
        this.stayAwake(false);
        this._pause();
    }

    public void prepareAsync() {
        this._prepareAsync();
    }

    public void release() {
        this.stayAwake(false);
        this.updateSurfaceScreenOn();
        this.resetListeners();
        IjkMediaPlayer$2 ijkMediaPlayer$2 = new IjkMediaPlayer$2(this);
        Thread thread = new Thread(ijkMediaPlayer$2);
        thread.start();
    }

    public void reset() {
        this.stayAwake(false);
        this._reset();
        this.mEventHandler.removeCallbacksAndMessages(null);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    public void resetListeners() {
        super.resetListeners();
        this.mOnMediaCodecSelectListener = null;
    }

    public native void seekTo(long var1);

    public void selectTrack(int n10) {
        this._setStreamSelected(n10, true);
    }

    public void setAndroidIOCallback(IAndroidIO iAndroidIO) {
        this._setAndroidIOCallback(iAndroidIO);
    }

    public void setAudioStreamType(int n10) {
    }

    public void setAudioVolume(int n10) {
        int n11;
        if (n10 < 0) {
            n10 = 0;
        }
        if (n10 > (n11 = 100)) {
            n10 = n11;
        }
        this._setAudioVolume(n10);
    }

    public void setBitrateIndex(int n10) {
        this.mBitrateIndex = n10;
        this._set_bitrate_index(n10);
    }

    public void setDataSource(Context context, Uri uri) {
        this.setDataSource(context, uri, null);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setDataSource(Context object, Uri uri, Map map) {
        void var3_10;
        Uri uri2;
        block13: {
            String string2;
            block14: {
                block12: {
                    Object object2;
                    block10: {
                        block11: {
                            int n10;
                            object2 = "file";
                            string2 = uri2.getScheme();
                            boolean bl2 = ((String)object2).equals(string2);
                            if (bl2) {
                                String string3 = uri2.getPath();
                                this.setDataSource(string3);
                                return;
                            }
                            object2 = "content";
                            boolean bl3 = ((String)object2).equals(string2);
                            if (bl3 && (bl3 = ((String)(object2 = "settings")).equals(string2 = uri2.getAuthority())) && (uri2 = RingtoneManager.getActualDefaultRingtoneUri((Context)object, (int)(n10 = RingtoneManager.getDefaultType((Uri)uri2)))) == null) {
                                FileNotFoundException fileNotFoundException = new FileNotFoundException("Failed to resolve default ringtone");
                                throw fileNotFoundException;
                            }
                            bl3 = false;
                            string2 = null;
                            ContentResolver contentResolver = object.getContentResolver();
                            object2 = "r";
                            string2 = contentResolver.openAssetFileDescriptor(uri2, (String)object2);
                            if (string2 != null) break block10;
                            if (string2 == null) break block11;
                            string2.close();
                        }
                        return;
                    }
                    try {
                        long l10 = string2.getDeclaredLength();
                        long l11 = 0L;
                        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                        if (l12 < 0) {
                            FileDescriptor fileDescriptor = string2.getFileDescriptor();
                            this.setDataSource(fileDescriptor);
                        } else {
                            FileDescriptor fileDescriptor = string2.getFileDescriptor();
                            l11 = string2.getStartOffset();
                            long l13 = string2.getDeclaredLength();
                            object2 = this;
                            this.setDataSource(fileDescriptor, l11, l13);
                        }
                        if (string2 == null) break block12;
                    }
                    catch (Throwable throwable) {
                        if (string2 != null) {
                            string2.close();
                        }
                        throw throwable;
                    }
                    catch (IOException iOException) {
                        if (string2 == null) break block13;
                        break block14;
                    }
                    catch (SecurityException securityException) {
                        if (string2 == null) break block13;
                    }
                    string2.close();
                }
                return;
            }
            string2.close();
        }
        Log.d((String)TAG, (String)"Couldn't open file on client side, trying server side");
        String string4 = uri2.toString();
        this.setDataSource(string4, (Map)var3_10);
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        this._setDataSource(iMediaDataSource);
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 12;
        if (n10 < n11) {
            Object object = fileDescriptor.getClass();
            String string2 = "descriptor";
            object = ((Class)object).getDeclaredField(string2);
            n11 = 1;
            ((Field)object).setAccessible(n11 != 0);
            try {
                int n12 = ((Field)object).getInt(fileDescriptor);
                this._setDataSourceFd(n12);
            }
            catch (IllegalAccessException illegalAccessException) {
                object = new RuntimeException(illegalAccessException);
                throw object;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                object = new RuntimeException(noSuchFieldException);
                throw object;
            }
        } else {
            fileDescriptor = ParcelFileDescriptor.dup((FileDescriptor)fileDescriptor);
            n10 = fileDescriptor.getFd();
            this._setDataSourceFd(n10);
        }
        return;
        finally {
            fileDescriptor.close();
        }
    }

    public void setDataSource(String string2) {
        this.mDataSource = string2;
        this._setDataSource(string2, null, null);
    }

    public void setDataSource(String string2, Map object) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            boolean bl3;
            StringBuilder stringBuilder = new StringBuilder();
            object = object.entrySet().iterator();
            while (bl3 = object.hasNext()) {
                Object object2 = object.next();
                String string3 = (String)object2.getKey();
                stringBuilder.append(string3);
                stringBuilder.append(":");
                string3 = (String)object2.getValue();
                int n10 = TextUtils.isEmpty((CharSequence)string3);
                if (n10 == 0) {
                    object2 = (String)object2.getValue();
                    stringBuilder.append((String)object2);
                }
                stringBuilder.append("\r\n");
                object2 = stringBuilder.toString();
                n10 = 1;
                this.setOption(n10, "headers", (String)object2);
                object2 = "protocol_whitelist";
                String string4 = "async,cache,crypto,file,http,https,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,ijktcphook,pipe,rtp,tcp,tls,udp,ijkurlhook,data,ijkhttpcache,ijklongurl";
                this.setOption(n10, (String)object2, string4);
            }
        }
        this.setDataSource(string2);
    }

    public void setDisplay(SurfaceHolder object) {
        this.mSurfaceHolder = object;
        object = object != null ? object.getSurface() : null;
        this._setVideoSurface((Surface)object);
        this.updateSurfaceScreenOn();
    }

    public void setKeepInBackground(boolean bl2) {
    }

    public void setLogEnabled(boolean bl2) {
    }

    public void setLooping(boolean bl2) {
        long l10 = (long)(bl2 ^= true);
        this.setOption(4, "loop", l10);
        this._setLoopCount((int)(bl2 ? 1 : 0));
    }

    public void setOnControlMessageListener(IjkMediaPlayer$OnControlMessageListener ijkMediaPlayer$OnControlMessageListener) {
        this.mOnControlMessageListener = ijkMediaPlayer$OnControlMessageListener;
    }

    public void setOnMediaCodecSelectListener(IjkMediaPlayer$OnMediaCodecSelectListener ijkMediaPlayer$OnMediaCodecSelectListener) {
        this.mOnMediaCodecSelectListener = ijkMediaPlayer$OnMediaCodecSelectListener;
    }

    public void setOnNativeInvokeListener(IjkMediaPlayer$OnNativeInvokeListener ijkMediaPlayer$OnNativeInvokeListener) {
        this.mOnNativeInvokeListener = ijkMediaPlayer$OnNativeInvokeListener;
    }

    public void setOption(int n10, String string2, long l10) {
        this._setOption(n10, string2, l10);
    }

    public void setOption(int n10, String string2, String string3) {
        this._setOption(n10, string2, string3);
    }

    public void setRate(float f10) {
        this.setSpeed(f10);
    }

    public void setScreenOnWhilePlaying(boolean bl2) {
        boolean bl3 = this.mScreenOnWhilePlaying;
        if (bl3 != bl2) {
            Object object;
            if (bl2 && (object = this.mSurfaceHolder) == null) {
                object = TAG;
                String string2 = "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder";
                DebugLog.w((String)object, string2);
            }
            this.mScreenOnWhilePlaying = bl2;
            this.updateSurfaceScreenOn();
        }
    }

    public void setSpeed(float f10) {
        this._setPropertyFloat(10003, f10);
    }

    public void setSurface(Surface surface) {
        boolean bl2 = this.mScreenOnWhilePlaying;
        if (bl2 && surface != null) {
            String string2 = TAG;
            String string3 = "setScreenOnWhilePlaying(true) is ineffective for Surface";
            DebugLog.w(string2, string3);
        }
        this.mSurfaceHolder = null;
        this._setVideoSurface(surface);
        this.updateSurfaceScreenOn();
        this.mSurface = surface;
    }

    public native void setVolume(float var1, float var2);

    public void setWakeMode(Context context, int n10) {
        int n11;
        Object object;
        boolean bl2;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            bl2 = wakeLock.isHeld();
            if (bl2) {
                bl2 = true;
                object = this.mWakeLock;
                object.release();
            } else {
                bl2 = false;
                wakeLock = null;
            }
            n11 = 0;
            object = null;
            this.mWakeLock = null;
        } else {
            bl2 = false;
            wakeLock = null;
        }
        context = (PowerManager)context.getSystemService("power");
        n11 = 0x20000000;
        object = IjkMediaPlayer.class.getName();
        context = context.newWakeLock(n10 |= n11, (String)object);
        this.mWakeLock = context;
        context.setReferenceCounted(false);
        if (bl2) {
            context = this.mWakeLock;
            context.acquire();
        }
    }

    public void start() {
        this.stayAwake(true);
        this._start();
    }

    public void stop() {
        this.stayAwake(false);
        this._stop();
    }
}

