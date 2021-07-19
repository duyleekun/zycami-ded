/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.sharp.jni.AudioSessionDuplicate$1;
import com.tencent.rtmp.sharp.jni.TraeAudioSession;
import com.tencent.rtmp.sharp.jni.TraeAudioSession$ITraeAudioCallback;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AudioSessionDuplicate {
    private static final String TAG = "AudioSessionDuplicate";
    private static TraeAudioSession _as;
    private static boolean _preDone;
    private static Condition _precon;
    private static ReentrantLock _prelock;
    private static String[] mDeviceList;
    private static int playoutDeviceType;
    private static boolean usingJava;

    static {
        ReentrantLock reentrantLock;
        _prelock = reentrantLock = new ReentrantLock();
        _precon = reentrantLock.newCondition();
        _preDone = false;
        usingJava = true;
        mDeviceList = null;
        playoutDeviceType = 0;
    }

    public static void DeleteAudioSessionDuplicate() {
        String string2 = " DeleteAudioSessionDuplicate...";
        TXCLog.i(TAG, string2);
        TraeAudioSession traeAudioSession = _as;
        if (traeAudioSession != null) {
            traeAudioSession.voiceCallPostprocess();
            _as.release();
            traeAudioSession = null;
            _as = null;
        }
    }

    public static void NewAudioSessionDuplicate(Context context) {
        Object object = " NewAudioSessionDuplicate...";
        TXCLog.i(TAG, (String)object);
        TraeAudioSession traeAudioSession = _as;
        if (traeAudioSession == null) {
            object = new AudioSessionDuplicate$1();
            _as = traeAudioSession = new TraeAudioSession(context, (TraeAudioSession$ITraeAudioCallback)object);
        }
    }

    public static /* synthetic */ ReentrantLock access$000() {
        return _prelock;
    }

    public static /* synthetic */ boolean access$102(boolean bl2) {
        _preDone = bl2;
        return bl2;
    }

    public static /* synthetic */ Condition access$200() {
        return _precon;
    }

    public static /* synthetic */ String[] access$302(String[] stringArray) {
        mDeviceList = stringArray;
        return stringArray;
    }

    public static /* synthetic */ boolean access$400() {
        return usingJava;
    }

    public static /* synthetic */ void access$500(String string2) {
        AudioSessionDuplicate.onOutputChanage(string2);
    }

    private static void onOutputChanage(String string2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("device: ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        String string3 = TAG;
        TXCLog.i(string3, (String)charSequence);
        charSequence = "DEVICE_EARPHONE";
        boolean bl2 = string2.equals(charSequence);
        if (bl2) {
            int n10;
            playoutDeviceType = n10 = 1;
        } else {
            charSequence = "DEVICE_SPEAKERPHONE";
            bl2 = string2.equals(charSequence);
            if (bl2) {
                int n11;
                playoutDeviceType = n11 = 2;
            } else {
                charSequence = "DEVICE_WIREDHEADSET";
                bl2 = string2.equals(charSequence);
                if (bl2) {
                    int n12;
                    playoutDeviceType = n12 = 3;
                } else {
                    charSequence = "DEVICE_BLUETOOTHHEADSET";
                    int n13 = string2.equals(charSequence);
                    if (n13 != 0) {
                        playoutDeviceType = n13 = 4;
                    } else {
                        n13 = 0;
                        string2 = null;
                        playoutDeviceType = 0;
                    }
                }
            }
        }
        TXCAudioEngineJNI.nativeSetPlayoutDevice(playoutDeviceType);
    }
}

