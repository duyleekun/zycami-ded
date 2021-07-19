/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 */
package com.mob.tools.utils;

import android.content.Context;
import android.media.AudioManager;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public class AudioHelper {
    public static final int ALARM_RING = 4;
    public static final int CALL_RING = 2;
    public static final int MEDIA_RING = 3;
    public static final int SYSTEM_RING = 1;
    private static AudioHelper audioHelper;
    private AudioManager audioManager;
    private Context context;
    private int currentAlarmVoice;
    private int currentCommonVoice;
    private int currentMediaVoice;
    private int currentRingVoice;

    private AudioHelper(Context context) {
        this.context = context = context.getApplicationContext();
        context = (AudioManager)context.getSystemService("audio");
        this.audioManager = context;
    }

    public static AudioHelper getInstance(Context context) {
        AudioHelper audioHelper = AudioHelper.audioHelper;
        if (audioHelper == null) {
            AudioHelper.audioHelper = audioHelper = new AudioHelper(context);
        }
        return AudioHelper.audioHelper;
    }

    private int getLastVoice(int n10) {
        Object[] objectArray = null;
        int n11 = 1;
        n11 = n10 == n11 ? this.currentCommonVoice : (n10 == (n11 = 3) ? this.currentMediaVoice : (n10 == (n11 = 2) ? this.currentRingVoice : (n10 == (n11 = 4) ? this.currentAlarmVoice : 0)));
        NLog nLog = MobLog.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Voice Type:");
        stringBuilder.append(n10);
        stringBuilder.append("Last Count:");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        objectArray = new Object[]{};
        nLog.d(string2, objectArray);
        return n11;
    }

    private void getVioce() {
        int n10;
        AudioManager audioManager;
        int n11;
        AudioManager audioManager2;
        int n12;
        Object[] objectArray;
        Object object = this.audioManager;
        int n13 = 1;
        int n14 = object.getStreamVolume(n13);
        if (n14 > 0) {
            this.currentCommonVoice = n14;
        }
        if ((n13 = (objectArray = this.audioManager).getStreamVolume(n12 = 2)) > 0) {
            this.currentRingVoice = n13;
        }
        if ((n12 = (audioManager2 = this.audioManager).getStreamVolume(n11 = 3)) > 0) {
            this.currentMediaVoice = n12;
        }
        if ((n11 = (audioManager = this.audioManager).getStreamVolume(n10 = 4)) > 0) {
            this.currentAlarmVoice = n11;
        }
        NLog nLog = MobLog.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("System Ring\uff1a");
        stringBuilder.append(n14);
        stringBuilder.append(" Call Ring\uff1a");
        stringBuilder.append(n13);
        stringBuilder.append(" Media Ring\uff1a");
        stringBuilder.append(n12);
        stringBuilder.append("Alarm Ring\uff1a");
        stringBuilder.append(n11);
        object = stringBuilder.toString();
        objectArray = new Object[]{};
        nLog.d(object, objectArray);
    }

    public void addVoice(int n10, int n11) {
        this.audioManager.adjustStreamVolume(n10, n11, 8);
    }

    public boolean checkMusicActivity() {
        boolean bl2 = this.audioManager.isMusicActive();
        NLog nLog = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Music Action:");
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        nLog.d(charSequence, objectArray);
        return bl2;
    }

    public int getAudioMode() {
        block5: {
            AudioManager audioManager = this.audioManager;
            try {
                int n10 = audioManager.getRingerMode();
                if (n10 != 0) {
                    int n11 = 1;
                    if (n10 == n11) {
                        return n11;
                    }
                    break block5;
                }
                return 0;
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.w(throwable);
            }
        }
        return 2;
    }

    public void recoveryVoice(int n10) {
        AudioManager audioManager = this.audioManager;
        int n11 = this.getLastVoice(n10);
        audioManager.setStreamVolume(n10, n11, 8);
    }

    public void setQuietMode(int n10) {
        NLog nLog;
        block5: {
            this.getVioce();
            nLog = this.audioManager;
            int n11 = nLog.getStreamVolume(n10);
            if (n11 != 0) break block5;
            return;
        }
        nLog = this.audioManager;
        int n12 = 8;
        try {
            nLog.setStreamVolume(n10, 0, n12);
        }
        catch (Throwable throwable) {
            nLog = MobLog.getInstance();
            nLog.w(throwable);
        }
    }

    public void setSilentMode() {
        this.audioManager.setStreamVolume(2, 0, 8);
        this.audioManager.setRingerMode(0);
    }
}

