/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 *  android.os.Build
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import java.util.StringTokenizer;

public class VivoKTVHelper {
    private static final String KEY_EXT_SPKR = "vivo_ktv_ext_speaker";
    private static final String KEY_KTV_MODE = "vivo_ktv_mode";
    private static final String KEY_MIC_SRC = "vivo_ktv_rec_source";
    private static final String KEY_MIC_TYPE = "vivo_ktv_mic_type";
    private static final String KEY_PLAY_SRC = "vivo_ktv_play_source";
    private static final String KEY_PRESET = "vivo_ktv_preset_effect";
    private static final String KEY_VOL_MIC = "vivo_ktv_volume_mic";
    private static final String TAG = "VivoKTVHelper";
    private static VivoKTVHelper mVivoKTVHelper;
    private AudioManager mAudioManager;
    private Context mContext;
    private final Object mParamLock;

    public VivoKTVHelper(Context context) {
        Object object;
        this.mParamLock = object = new Object();
        this.mContext = context;
        context = (AudioManager)context.getSystemService("audio");
        this.mAudioManager = context;
    }

    public static VivoKTVHelper getInstance(Context context) {
        VivoKTVHelper vivoKTVHelper = mVivoKTVHelper;
        if (vivoKTVHelper == null) {
            mVivoKTVHelper = vivoKTVHelper = new VivoKTVHelper(context);
        }
        return mVivoKTVHelper;
    }

    private int getKTVParam(String string2) {
        boolean bl2;
        int n10;
        String string3;
        Object object;
        String string4 = Build.MODEL.trim();
        int n11 = string4.contains((CharSequence)(object = "vivo"));
        if (n11 != 0 && (n11 = ((StringTokenizer)(object = new StringTokenizer(string4 = this.mAudioManager.getParameters(string2), string3 = "="))).countTokens()) == (n10 = 2) && (bl2 = string2.equals(string4 = ((StringTokenizer)object).nextToken()))) {
            return Integer.parseInt(((StringTokenizer)object).nextToken().trim());
        }
        return 0;
    }

    public void closeKTVDevice() {
        this.mAudioManager.setParameters("vivo_ktv_mode=0");
    }

    public int getExtSpeakerParam() {
        return this.getKTVParam(KEY_EXT_SPKR);
    }

    public int getMicTypeParam() {
        return this.getKTVParam(KEY_MIC_TYPE);
    }

    public int getMicVolParam() {
        return this.getKTVParam(KEY_VOL_MIC);
    }

    public int getPlayFeedbackParam() {
        return this.getKTVParam(KEY_PLAY_SRC);
    }

    public int getPreModeParam() {
        return this.getKTVParam(KEY_PRESET);
    }

    public int getVoiceOutParam() {
        return this.getKTVParam(KEY_MIC_SRC);
    }

    public boolean isDeviceSupportKaraoke() {
        String string2 = Build.MODEL.trim();
        int n10 = string2.contains("vivo");
        if (n10) {
            int n11;
            int n12;
            String string3;
            string2 = this.mAudioManager;
            String string4 = KEY_MIC_TYPE;
            StringTokenizer stringTokenizer = new StringTokenizer(string2 = string2.getParameters(string4), string3 = "=");
            n10 = stringTokenizer.countTokens();
            if (n10 != (n12 = 2)) {
                return false;
            }
            string2 = stringTokenizer.nextToken();
            n10 = (int)(string2.equals(string4) ? 1 : 0);
            if (n10 && ((n10 = Integer.parseInt(string2 = stringTokenizer.nextToken())) == (n11 = 1) || !n10)) {
                return n11 != 0;
            }
        }
        return false;
    }

    public void openKTVDevice() {
        this.mAudioManager.setParameters("vivo_ktv_mode=1");
        this.isDeviceSupportKaraoke();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setExtSpeakerParam(int n10) {
        Object object = this.mParamLock;
        synchronized (object) {
            Object object2 = this.mAudioManager;
            if (object2 != null) {
                object2 = new StringBuilder();
                String string2 = KEY_EXT_SPKR;
                ((StringBuilder)object2).append(string2);
                string2 = "=";
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(n10);
                AudioManager audioManager = this.mAudioManager;
                object2 = ((StringBuilder)object2).toString();
                audioManager.setParameters((String)object2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setMicVolParam(int n10) {
        Object object = this.mParamLock;
        synchronized (object) {
            Object object2 = this.mAudioManager;
            if (object2 != null) {
                object2 = new StringBuilder();
                String string2 = KEY_VOL_MIC;
                ((StringBuilder)object2).append(string2);
                string2 = "=";
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(n10);
                AudioManager audioManager = this.mAudioManager;
                object2 = ((StringBuilder)object2).toString();
                audioManager.setParameters((String)object2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setPlayFeedbackParam(int n10) {
        Object object = this.mParamLock;
        synchronized (object) {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "vivo_ktv_play_source=";
                stringBuilder.append(string2);
                stringBuilder.append(n10);
                String string3 = stringBuilder.toString();
                audioManager.setParameters(string3);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setPreModeParam(int n10) {
        Object object = this.mParamLock;
        synchronized (object) {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "vivo_ktv_preset_effect=";
                stringBuilder.append(string2);
                stringBuilder.append(n10);
                String string3 = stringBuilder.toString();
                audioManager.setParameters(string3);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setVoiceOutParam(int n10) {
        Object object = this.mParamLock;
        synchronized (object) {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "vivo_ktv_rec_source=";
                stringBuilder.append(string2);
                stringBuilder.append(n10);
                String string3 = stringBuilder.toString();
                audioManager.setParameters(string3);
            }
            return;
        }
    }
}

