/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.Uri
 *  android.provider.Settings$Global
 */
package com.google.android.exoplayer2.audio;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.provider.Settings;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class AudioCapabilities {
    public static final AudioCapabilities DEFAULT_AUDIO_CAPABILITIES;
    private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
    private static final AudioCapabilities EXTERNAL_SURROUND_SOUND_CAPABILITIES;
    private static final String EXTERNAL_SURROUND_SOUND_KEY = "external_surround_sound_enabled";
    private final int maxChannelCount;
    private final int[] supportedEncodings;

    static {
        AudioCapabilities audioCapabilities;
        int[] nArray = new int[]{2};
        int n10 = 8;
        DEFAULT_AUDIO_CAPABILITIES = audioCapabilities = new AudioCapabilities(nArray, n10);
        int[] nArray2 = nArray = new int[3];
        nArray[0] = 2;
        nArray2[1] = 5;
        nArray2[2] = 6;
        EXTERNAL_SURROUND_SOUND_CAPABILITIES = audioCapabilities = new AudioCapabilities(nArray, n10);
    }

    public AudioCapabilities(int[] nArray, int n10) {
        if (nArray != null) {
            int n11 = nArray.length;
            nArray = Arrays.copyOf(nArray, n11);
            this.supportedEncodings = nArray;
            Arrays.sort(nArray);
        } else {
            nArray = new int[]{};
            this.supportedEncodings = nArray;
        }
        this.maxChannelCount = n10;
    }

    private static boolean deviceMaySetExternalSurroundSoundGlobalSetting() {
        String string2;
        String string3;
        int n10 = Util.SDK_INT;
        int n11 = 17;
        if (n10 >= n11 && (n10 = (string3 = "Amazon").equals(string2 = Util.MANUFACTURER))) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        return n10 != 0;
    }

    public static AudioCapabilities getCapabilities(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.media.action.HDMI_AUDIO_PLUG");
        intentFilter = context.registerReceiver(null, intentFilter);
        return AudioCapabilities.getCapabilities(context, (Intent)intentFilter);
    }

    public static AudioCapabilities getCapabilities(Context object, Intent intent) {
        Object object2;
        int n10;
        int n11 = AudioCapabilities.deviceMaySetExternalSurroundSoundGlobalSetting();
        if (n11 != 0 && (n10 = Settings.Global.getInt((ContentResolver)(object = object.getContentResolver()), (String)(object2 = EXTERNAL_SURROUND_SOUND_KEY), (int)0)) == (n11 = 1)) {
            return EXTERNAL_SURROUND_SOUND_CAPABILITIES;
        }
        if (intent != null && (n10 = intent.getIntExtra((String)(object = "android.media.extra.AUDIO_PLUG_STATE"), 0)) != 0) {
            object2 = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
            int n12 = intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8);
            object = new AudioCapabilities((int[])object2, n12);
            return object;
        }
        return DEFAULT_AUDIO_CAPABILITIES;
    }

    public static Uri getExternalSurroundSoundGlobalSettingUri() {
        Uri uri;
        boolean bl2 = AudioCapabilities.deviceMaySetExternalSurroundSoundGlobalSetting();
        if (bl2) {
            uri = Settings.Global.getUriFor((String)EXTERNAL_SURROUND_SOUND_KEY);
        } else {
            bl2 = false;
            uri = null;
        }
        return uri;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n11 = object instanceof AudioCapabilities;
        if (n11 == 0) {
            return false;
        }
        object = (AudioCapabilities)object;
        int[] nArray = this.supportedEncodings;
        int[] nArray2 = ((AudioCapabilities)object).supportedEncodings;
        n11 = Arrays.equals(nArray, nArray2);
        if (n11 == 0 || (n11 = this.maxChannelCount) != (n10 = ((AudioCapabilities)object).maxChannelCount)) {
            bl2 = false;
        }
        return bl2;
    }

    public int getMaxChannelCount() {
        return this.maxChannelCount;
    }

    public int hashCode() {
        int n10 = this.maxChannelCount;
        int n11 = Arrays.hashCode(this.supportedEncodings) * 31;
        return n10 + n11;
    }

    public boolean supportsEncoding(int n10) {
        int[] nArray = this.supportedEncodings;
        n10 = (n10 = Arrays.binarySearch(nArray, n10)) >= 0 ? 1 : 0;
        return n10 != 0;
    }

    public String toString() {
        int n10 = this.maxChannelCount;
        String string2 = Arrays.toString(this.supportedEncodings);
        int n11 = String.valueOf(string2).length() + 67;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append("AudioCapabilities[maxChannelCount=");
        stringBuilder.append(n10);
        stringBuilder.append(", supportedEncodings=");
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

