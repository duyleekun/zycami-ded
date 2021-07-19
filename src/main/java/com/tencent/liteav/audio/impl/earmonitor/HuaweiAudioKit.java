/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 */
package com.tencent.liteav.audio.impl.earmonitor;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit$ParameName;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit$FeatureType;
import com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit$1;
import com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit$2;
import com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit$3;
import com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit$4;
import com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit$5;
import com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit$6;
import com.tencent.liteav.audio.impl.earmonitor.TXSystemAudioKit;
import com.tencent.liteav.audio.impl.earmonitor.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.i;
import com.tencent.liteav.basic.util.i$a;
import d.j.e.a.b.b.c;
import java.util.concurrent.TimeUnit;

public class HuaweiAudioKit
implements c,
TXSystemAudioKit,
i$a {
    private static final int BACKGROUND_CHECK_INTERVAL = 0;
    private static final String TAG = "HuaweiAudioKit";
    private a mAudioKitCallback;
    private i mBackgroundCheckTimer;
    private HwAudioKit mHwAudioKit;
    private boolean mIsAudioKitIniting;
    private boolean mIsBackgroundWhenLastCheck;
    private boolean mIsEarMonitoringEnabled;
    private HwAudioKaraokeFeatureKit mKaraokeKit;
    private final Handler mUiHandler;

    static {
        BACKGROUND_CHECK_INTERVAL = (int)TimeUnit.SECONDS.toMillis(1L);
    }

    public HuaweiAudioKit() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.mUiHandler = handler = new Handler(looper);
        this.mIsAudioKitIniting = false;
        this.mIsEarMonitoringEnabled = false;
        this.mIsBackgroundWhenLastCheck = false;
    }

    public static /* synthetic */ HwAudioKit access$000(HuaweiAudioKit huaweiAudioKit) {
        return huaweiAudioKit.mHwAudioKit;
    }

    public static /* synthetic */ HwAudioKit access$002(HuaweiAudioKit huaweiAudioKit, HwAudioKit hwAudioKit) {
        huaweiAudioKit.mHwAudioKit = hwAudioKit;
        return hwAudioKit;
    }

    public static /* synthetic */ boolean access$102(HuaweiAudioKit huaweiAudioKit, boolean bl2) {
        huaweiAudioKit.mIsAudioKitIniting = bl2;
        return bl2;
    }

    public static /* synthetic */ a access$202(HuaweiAudioKit huaweiAudioKit, a a10) {
        huaweiAudioKit.mAudioKitCallback = a10;
        return a10;
    }

    public static /* synthetic */ HwAudioKaraokeFeatureKit access$300(HuaweiAudioKit huaweiAudioKit) {
        return huaweiAudioKit.mKaraokeKit;
    }

    public static /* synthetic */ HwAudioKaraokeFeatureKit access$302(HuaweiAudioKit huaweiAudioKit, HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit) {
        huaweiAudioKit.mKaraokeKit = hwAudioKaraokeFeatureKit;
        return hwAudioKaraokeFeatureKit;
    }

    public static /* synthetic */ void access$400(HuaweiAudioKit huaweiAudioKit) {
        huaweiAudioKit.startTimer();
    }

    public static /* synthetic */ void access$500(HuaweiAudioKit huaweiAudioKit) {
        huaweiAudioKit.startSystemEarMonitoringInternal();
    }

    public static /* synthetic */ void access$600(HuaweiAudioKit huaweiAudioKit) {
        huaweiAudioKit.stopTimer();
    }

    public static /* synthetic */ void access$700(HuaweiAudioKit huaweiAudioKit) {
        huaweiAudioKit.stopSystemEarMonitoringInternal();
    }

    public static /* synthetic */ void access$800(HuaweiAudioKit huaweiAudioKit, int n10) {
        huaweiAudioKit.setSystemEarMonitoringVolumeInternal(n10);
    }

    public static /* synthetic */ void access$900(HuaweiAudioKit huaweiAudioKit, int n10) {
        huaweiAudioKit.dealWithAudioKitResultInternal(n10);
    }

    private void dealWithAudioKitResultInternal(int n10) {
        Object object;
        int n11 = 1;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object = Integer.valueOf(n10);
        object = TAG;
        String string2 = "on audio kit callback: %d";
        TXCLog.i((String)object, string2, objectArray);
        if (n10 == 0) {
            HwAudioKit$FeatureType hwAudioKit$FeatureType;
            this.mIsAudioKitIniting = false;
            Object object2 = this.mAudioKitCallback;
            if (object2 != null) {
                object2.onAudioKitInitFinished(this, n11 != 0);
            }
            if ((n10 = (int)(((HwAudioKit)(object2 = this.mHwAudioKit)).p(hwAudioKit$FeatureType = HwAudioKit$FeatureType.HWAUDIO_FEATURE_KARAOKE) ? 1 : 0)) != 0) {
                this.mKaraokeKit = object2 = (HwAudioKaraokeFeatureKit)this.mHwAudioKit.l(hwAudioKit$FeatureType);
            } else {
                object2 = this.mAudioKitCallback;
                if (object2 != null) {
                    object2.onEarMonitoringInitialized(this, false);
                }
            }
        } else {
            int n12 = 1000;
            if (n10 == n12) {
                a a10 = this.mAudioKitCallback;
                if (a10 != null) {
                    a10.onEarMonitoringInitialized(this, n11 != 0);
                }
            } else {
                a a11;
                n11 = 1805;
                if (n10 != n11 && (a11 = this.mAudioKitCallback) != null) {
                    n11 = this.mIsAudioKitIniting;
                    if (n11) {
                        a11.onAudioKitInitFinished(this, false);
                        this.mIsAudioKitIniting = false;
                    } else {
                        a11.onAudioKitError(this);
                    }
                }
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isAppInBackground() {
        boolean bl2 = false;
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState((ActivityManager.RunningAppProcessInfo)runningAppProcessInfo);
            int n10 = runningAppProcessInfo.importance;
            int n11 = 100;
            if (n10 == n11) return bl2;
            return true;
        }
        catch (Exception exception) {
            return bl2;
        }
    }

    private void setSystemEarMonitoringVolumeInternal(int n10) {
        Object object;
        int n11 = 2;
        Object object2 = new Object[n11];
        object2[0] = object = Integer.valueOf(n10);
        object = this.mKaraokeKit;
        int n12 = 1;
        object2[n12] = object;
        object = TAG;
        String string2 = "setSystemEarMonitoringVolumeInternal: %d, kit: %s";
        TXCLog.i((String)object, string2, (Object[])object2);
        object2 = this.mKaraokeKit;
        if (object2 != null) {
            object = HwAudioKaraokeFeatureKit$ParameName.CMD_SET_VOCAL_VOLUME_BASE;
            n10 = ((HwAudioKaraokeFeatureKit)object2).s((HwAudioKaraokeFeatureKit$ParameName)((Object)object), n10);
            n11 = 1806;
            int n13 = -2;
            if (n10 == n11 || n10 == n13) {
                this.dealWithAudioKitResultInternal(n13);
            }
        }
    }

    private void startSystemEarMonitoringInternal() {
        int n10;
        Object object;
        int n11 = 1;
        Object object2 = new Object[n11];
        object2[0] = object = this.mKaraokeKit;
        object = TAG;
        String string2 = "startSystemEarMonitoring kit: %s";
        TXCLog.i((String)object, string2, (Object[])object2);
        object2 = this.mKaraokeKit;
        if (object2 == null) {
            return;
        }
        int n12 = ((HwAudioKaraokeFeatureKit)object2).m(n11 != 0);
        if (n12 != 0 && n12 != (n10 = 1805)) {
            n11 = 1003;
            this.dealWithAudioKitResultInternal(n11);
        } else {
            this.mIsEarMonitoringEnabled = n11;
        }
    }

    private void startTimer() {
        i i10 = this.mBackgroundCheckTimer;
        if (i10 != null) {
            return;
        }
        TXCLog.i(TAG, "start background checking timer");
        Looper looper = Looper.getMainLooper();
        this.mBackgroundCheckTimer = i10 = new i(looper, this);
        int n10 = BACKGROUND_CHECK_INTERVAL;
        i10.a(0, n10);
    }

    private void stopSystemEarMonitoringInternal() {
        String string2 = "stopSystemEarMonitoring";
        TXCLog.i(TAG, string2);
        HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this.mKaraokeKit;
        if (hwAudioKaraokeFeatureKit != null) {
            string2 = null;
            hwAudioKaraokeFeatureKit.m(false);
            this.mIsEarMonitoringEnabled = false;
        }
    }

    private void stopTimer() {
        i i10 = this.mBackgroundCheckTimer;
        if (i10 != null) {
            String string2 = "stop background checking timer";
            TXCLog.i(TAG, string2);
            this.mBackgroundCheckTimer.a();
            i10 = null;
            this.mBackgroundCheckTimer = null;
        }
    }

    public void initialize(Context context, a a10) {
        Handler handler = this.mUiHandler;
        HuaweiAudioKit$1 huaweiAudioKit$1 = new HuaweiAudioKit$1(this, a10, context);
        handler.post((Runnable)huaweiAudioKit$1);
    }

    public void onResult(int n10) {
        Handler handler = this.mUiHandler;
        HuaweiAudioKit$6 huaweiAudioKit$6 = new HuaweiAudioKit$6(this, n10);
        handler.post((Runnable)huaweiAudioKit$6);
    }

    public void onTimeout() {
        boolean bl2 = this.isAppInBackground();
        boolean bl3 = this.mIsEarMonitoringEnabled;
        if (bl3 && (bl3 = this.mIsBackgroundWhenLastCheck) && !bl2) {
            this.stopSystemEarMonitoringInternal();
            this.startSystemEarMonitoringInternal();
        } else if (bl2 && !(bl3 = this.mIsBackgroundWhenLastCheck)) {
            String string2 = TAG;
            String string3 = "app has gone to background.";
            TXCLog.i(string2, string3);
        }
        this.mIsBackgroundWhenLastCheck = bl2;
    }

    public void setSystemEarMonitoringVolume(int n10) {
        Handler handler = this.mUiHandler;
        HuaweiAudioKit$5 huaweiAudioKit$5 = new HuaweiAudioKit$5(this, n10);
        handler.post((Runnable)huaweiAudioKit$5);
    }

    public void startSystemEarMonitoring() {
        Handler handler = this.mUiHandler;
        HuaweiAudioKit$3 huaweiAudioKit$3 = new HuaweiAudioKit$3(this);
        handler.post((Runnable)huaweiAudioKit$3);
    }

    public void stopSystemEarMonitoring() {
        Handler handler = this.mUiHandler;
        HuaweiAudioKit$4 huaweiAudioKit$4 = new HuaweiAudioKit$4(this);
        handler.post((Runnable)huaweiAudioKit$4);
    }

    public void uninitialize() {
        Handler handler = this.mUiHandler;
        HuaweiAudioKit$2 huaweiAudioKit$2 = new HuaweiAudioKit$2(this);
        handler.post((Runnable)huaweiAudioKit$2);
    }
}

