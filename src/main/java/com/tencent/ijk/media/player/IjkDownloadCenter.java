/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 */
package com.tencent.ijk.media.player;

import android.os.Looper;
import android.os.Message;
import com.tencent.ijk.media.player.IjkDownloadCenter$1;
import com.tencent.ijk.media.player.IjkDownloadCenter$EventHandler;
import com.tencent.ijk.media.player.IjkDownloadCenter$NativeEvent;
import com.tencent.ijk.media.player.IjkDownloadCenter$OnDownloadListener;
import com.tencent.ijk.media.player.IjkDownloadMedia;
import com.tencent.ijk.media.player.IjkLibLoader;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class IjkDownloadCenter {
    private static final int DC_PROP_LONG_DOWNLOAD_SIZE = 1003;
    private static final int DC_PROP_LONG_SIZE = 1002;
    private static final int DC_PROP_LONG_SPEED = 1004;
    private static final int DC_PROP_STRING_URL = 1001;
    private static final int MSG_ERROR = 500;
    private static final int MSG_FINISH = 600;
    private static final int MSG_PROGRESS = 900;
    private static final int MSG_RESUME = 100;
    private static final int MSG_STOP = 300;
    private static final String TAG = "IjkDownloadCenter";
    private static IjkDownloadCenter instance;
    private static volatile boolean mIsLibLoaded = false;
    private static final IjkLibLoader sLocalLibLoader;
    private IjkDownloadCenter$EventHandler mEventHandler;
    public Map mHeaders;
    private IjkDownloadCenter$OnDownloadListener mListener;

    static {
        IjkDownloadCenter$1 ijkDownloadCenter$1 = new IjkDownloadCenter$1();
        sLocalLibLoader = ijkDownloadCenter$1;
    }

    public IjkDownloadCenter() {
        IjkLibLoader ijkLibLoader = sLocalLibLoader;
        this(ijkLibLoader);
    }

    public IjkDownloadCenter(IjkLibLoader weakReference) {
        IjkDownloadCenter.loadLibrariesOnce((IjkLibLoader)((Object)weakReference));
        weakReference = Looper.getMainLooper();
        if (weakReference != null) {
            IjkDownloadCenter$EventHandler ijkDownloadCenter$EventHandler;
            this.mEventHandler = ijkDownloadCenter$EventHandler = new IjkDownloadCenter$EventHandler(this, (Looper)weakReference);
        } else {
            weakReference = null;
            this.mEventHandler = null;
        }
        weakReference = new WeakReference<IjkDownloadCenter>(this);
        this.native_download_setup(weakReference);
    }

    public static /* synthetic */ IjkDownloadCenter$OnDownloadListener access$000(IjkDownloadCenter ijkDownloadCenter) {
        return ijkDownloadCenter.mListener;
    }

    private native int download_get_task_prop_long(int var1, int var2);

    private native String download_get_task_prop_string(int var1, int var2);

    public static IjkDownloadCenter getInstance() {
        IjkDownloadCenter ijkDownloadCenter = instance;
        if (ijkDownloadCenter == null) {
            instance = ijkDownloadCenter = new IjkDownloadCenter();
        }
        return instance;
    }

    private static int hlsVerifyForNative(Object object, int n10, String string2, byte[] byArray) {
        if (object == null) {
            return 0;
        }
        if ((object = (IjkDownloadCenter)((WeakReference)object).get()) == null) {
            return 0;
        }
        IjkDownloadMedia ijkDownloadMedia = ((IjkDownloadCenter)object).convertMedia(n10);
        return ((IjkDownloadCenter)object).mListener.hlsKeyVerify((IjkDownloadCenter)object, ijkDownloadMedia, string2, byArray);
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

    private native void native_download_free();

    private native int native_download_hls_start(String var1, String var2, String var3);

    private native void native_download_setup(Object var1);

    private native void native_download_stop(int var1);

    private static void postEventFromNative(Object object, int n10, int n11, int n12, Object object2) {
        if (object == null) {
            return;
        }
        if ((object = (IjkDownloadCenter)((WeakReference)object).get()) == null) {
            return;
        }
        Object object3 = ((IjkDownloadCenter)object).mEventHandler;
        if (object3 != null) {
            IjkDownloadMedia ijkDownloadMedia;
            object3 = new IjkDownloadCenter$NativeEvent(null);
            ((IjkDownloadCenter$NativeEvent)object3).media = ijkDownloadMedia = ((IjkDownloadCenter)object).convertMedia(n11);
            ((IjkDownloadCenter$NativeEvent)object3).error = n12;
            if (object2 != null) {
                object2 = (String)object2;
                ((IjkDownloadCenter$NativeEvent)object3).reason = object2;
            }
            object2 = ((IjkDownloadCenter)object).mEventHandler;
            Message message = object2.obtainMessage(n10, n11, n12, object3);
            object = ((IjkDownloadCenter)object).mEventHandler;
            object.sendMessage(message);
        }
    }

    public IjkDownloadMedia convertMedia(int n10) {
        int n11;
        int n12 = 1001;
        String string2 = this.download_get_task_prop_string(n12, n10);
        if (string2 == null) {
            return null;
        }
        IjkDownloadMedia ijkDownloadMedia = new IjkDownloadMedia();
        ijkDownloadMedia.size = n11 = this.download_get_task_prop_long(1002, n10);
        ijkDownloadMedia.downloadSize = n11 = this.download_get_task_prop_long(1003, n10);
        ijkDownloadMedia.speed = n11 = this.download_get_task_prop_long(1004, n10);
        ijkDownloadMedia.url = string2;
        ijkDownloadMedia.tid = n10;
        return ijkDownloadMedia;
    }

    public int downloadHls(String string2, String string3) {
        Object object = this.mHeaders;
        Object object2 = "";
        if (object != null) {
            boolean bl2;
            object = object.keySet().iterator();
            while (bl2 = object.hasNext()) {
                String string4 = (String)object.next();
                int n10 = 1;
                Map map = null;
                int n11 = 2;
                String string5 = "%s: %s";
                if (object2 == null) {
                    object2 = new Object[n11];
                    object2[0] = string4;
                    map = this.mHeaders;
                    string4 = map.get(string4);
                    object2[n10] = string4;
                    object2 = String.format(string5, object2);
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object2);
                stringBuilder.append("\r\n");
                object2 = new Object[n11];
                object2[0] = string4;
                map = this.mHeaders;
                string4 = map.get(string4);
                object2[n10] = string4;
                object2 = String.format(string5, object2);
                stringBuilder.append((String)object2);
                object2 = stringBuilder.toString();
            }
        }
        return this.native_download_hls_start(string2, string3, (String)object2);
    }

    public void finalize() {
        try {
            this.native_download_free();
            return;
        }
        finally {
            super.finalize();
        }
    }

    public void setHeaders(Map map) {
        this.mHeaders = map;
    }

    public IjkDownloadCenter setListener(IjkDownloadCenter$OnDownloadListener ijkDownloadCenter$OnDownloadListener) {
        this.mListener = ijkDownloadCenter$OnDownloadListener;
        return this;
    }

    public void stop(int n10) {
        this.native_download_stop(n10);
    }
}

