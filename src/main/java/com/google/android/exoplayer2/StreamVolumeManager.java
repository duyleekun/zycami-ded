/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.media.AudioManager
 *  android.os.Handler
 */
package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.StreamVolumeManager$Listener;
import com.google.android.exoplayer2.StreamVolumeManager$VolumeChangeReceiver;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public final class StreamVolumeManager {
    private static final String TAG = "StreamVolumeManager";
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private static final int VOLUME_FLAGS = 1;
    private final Context applicationContext;
    private final AudioManager audioManager;
    private final Handler eventHandler;
    private final StreamVolumeManager$Listener listener;
    private boolean muted;
    private StreamVolumeManager$VolumeChangeReceiver receiver;
    private int streamType;
    private int volume;

    public StreamVolumeManager(Context context, Handler object, StreamVolumeManager$Listener object2) {
        boolean bl2;
        int n10;
        this.applicationContext = context = context.getApplicationContext();
        this.eventHandler = object;
        this.listener = object2;
        object = (AudioManager)Assertions.checkStateNotNull((AudioManager)context.getSystemService("audio"));
        this.audioManager = object;
        this.streamType = n10 = 3;
        this.volume = n10 = StreamVolumeManager.getVolumeFromManager((AudioManager)object, n10);
        n10 = this.streamType;
        this.muted = bl2 = StreamVolumeManager.getMutedFromManager((AudioManager)object, n10);
        n10 = 0;
        super(this, null);
        String string2 = VOLUME_CHANGED_ACTION;
        super(string2);
        context.registerReceiver((BroadcastReceiver)object, (IntentFilter)object2);
        try {
            this.receiver = object;
        }
        catch (RuntimeException runtimeException) {
            object = TAG;
            object2 = "Error registering stream volume receiver";
            Log.w((String)object, (String)object2, runtimeException);
        }
    }

    public static /* synthetic */ Handler access$100(StreamVolumeManager streamVolumeManager) {
        return streamVolumeManager.eventHandler;
    }

    public static /* synthetic */ void access$200(StreamVolumeManager streamVolumeManager) {
        streamVolumeManager.updateVolumeAndNotifyIfChanged();
    }

    private static boolean getMutedFromManager(AudioManager audioManager, int n10) {
        int n11 = Util.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            return audioManager.isStreamMute(n10);
        }
        int n13 = StreamVolumeManager.getVolumeFromManager(audioManager, n10);
        if (!n13) {
            n13 = 1;
        } else {
            n13 = 0;
            audioManager = null;
        }
        return n13 != 0;
    }

    private static int getVolumeFromManager(AudioManager audioManager, int n10) {
        try {
            return audioManager.getStreamVolume(n10);
        }
        catch (RuntimeException runtimeException) {
            StringBuilder stringBuilder = new StringBuilder(60);
            stringBuilder.append("Could not retrieve stream volume for stream type ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            Log.w(TAG, string2, runtimeException);
            return audioManager.getStreamMaxVolume(n10);
        }
    }

    private void updateVolumeAndNotifyIfChanged() {
        AudioManager audioManager = this.audioManager;
        int n10 = this.streamType;
        int n11 = StreamVolumeManager.getVolumeFromManager(audioManager, n10);
        AudioManager audioManager2 = this.audioManager;
        int n12 = this.streamType;
        n10 = (int)(StreamVolumeManager.getMutedFromManager(audioManager2, n12) ? 1 : 0);
        n12 = this.volume;
        if (n12 != n11 || (n12 = (int)(this.muted ? 1 : 0)) != n10) {
            this.volume = n11;
            this.muted = n10;
            StreamVolumeManager$Listener streamVolumeManager$Listener = this.listener;
            streamVolumeManager$Listener.onStreamVolumeChanged(n11, n10 != 0);
        }
    }

    public void decreaseVolume() {
        int n10 = this.volume;
        int n11 = this.getMinVolume();
        if (n10 <= n11) {
            return;
        }
        AudioManager audioManager = this.audioManager;
        n11 = this.streamType;
        audioManager.adjustStreamVolume(n11, -1, 1);
        this.updateVolumeAndNotifyIfChanged();
    }

    public int getMaxVolume() {
        AudioManager audioManager = this.audioManager;
        int n10 = this.streamType;
        return audioManager.getStreamMaxVolume(n10);
    }

    public int getMinVolume() {
        int n10 = Util.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            AudioManager audioManager = this.audioManager;
            n11 = this.streamType;
            n10 = audioManager.getStreamMinVolume(n11);
        } else {
            n10 = 0;
            Object var3_4 = null;
        }
        return n10;
    }

    public int getVolume() {
        return this.volume;
    }

    public void increaseVolume() {
        int n10 = this.volume;
        int n11 = this.getMaxVolume();
        if (n10 >= n11) {
            return;
        }
        AudioManager audioManager = this.audioManager;
        n11 = this.streamType;
        int n12 = 1;
        audioManager.adjustStreamVolume(n11, n12, n12);
        this.updateVolumeAndNotifyIfChanged();
    }

    public boolean isMuted() {
        return this.muted;
    }

    public void release() {
        StreamVolumeManager$VolumeChangeReceiver streamVolumeManager$VolumeChangeReceiver = this.receiver;
        if (streamVolumeManager$VolumeChangeReceiver != null) {
            Object object = this.applicationContext;
            try {
                object.unregisterReceiver((BroadcastReceiver)streamVolumeManager$VolumeChangeReceiver);
            }
            catch (RuntimeException runtimeException) {
                object = TAG;
                String string2 = "Error unregistering stream volume receiver";
                Log.w((String)object, string2, runtimeException);
            }
            streamVolumeManager$VolumeChangeReceiver = null;
            this.receiver = null;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void setMuted(boolean bl2) {
        int n10 = Util.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            void var1_4;
            AudioManager audioManager = this.audioManager;
            n11 = this.streamType;
            if (bl2) {
                int n12 = -100;
            } else {
                int n13 = 100;
            }
            int n14 = 1;
            audioManager.adjustStreamVolume(n11, (int)var1_4, n14);
        } else {
            AudioManager audioManager = this.audioManager;
            n11 = this.streamType;
            audioManager.setStreamMute(n11, bl2);
        }
        this.updateVolumeAndNotifyIfChanged();
    }

    public void setStreamType(int n10) {
        int n11 = this.streamType;
        if (n11 == n10) {
            return;
        }
        this.streamType = n10;
        this.updateVolumeAndNotifyIfChanged();
        this.listener.onStreamTypeChanged(n10);
    }

    public void setVolume(int n10) {
        int n11 = this.getMinVolume();
        if (n10 >= n11 && n10 <= (n11 = this.getMaxVolume())) {
            AudioManager audioManager = this.audioManager;
            int n12 = this.streamType;
            int n13 = 1;
            audioManager.setStreamVolume(n12, n10, n13);
            this.updateVolumeAndNotifyIfChanged();
        }
    }
}

