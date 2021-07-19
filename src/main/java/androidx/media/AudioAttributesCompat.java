/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.os.Build$VERSION
 *  android.util.SparseIntArray
 */
package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi21;
import androidx.media.AudioAttributesImplApi26;
import androidx.versionedparcelable.VersionedParcelable;

public class AudioAttributesCompat
implements VersionedParcelable {
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    public static final int FLAG_ALL = 1023;
    public static final int FLAG_ALL_PUBLIC = 273;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    public static final int FLAG_BEACON = 8;
    public static final int FLAG_BYPASS_INTERRUPTION_POLICY = 64;
    public static final int FLAG_BYPASS_MUTE = 128;
    public static final int FLAG_DEEP_BUFFER = 512;
    public static final int FLAG_HW_AV_SYNC = 16;
    public static final int FLAG_HW_HOTWORD = 32;
    public static final int FLAG_LOW_LATENCY = 256;
    public static final int FLAG_SCO = 4;
    public static final int FLAG_SECURE = 2;
    public static final int INVALID_STREAM_TYPE = 255;
    private static final int[] SDK_USAGES;
    private static final int SUPPRESSIBLE_CALL = 2;
    private static final int SUPPRESSIBLE_NOTIFICATION = 1;
    private static final SparseIntArray SUPPRESSIBLE_USAGES;
    public static final String TAG = "AudioAttributesCompat";
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    public static final int USAGE_VIRTUAL_SOURCE = 15;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;
    public static boolean sForceLegacyBehavior;
    public AudioAttributesImpl mImpl;

    static {
        Object object;
        SUPPRESSIBLE_USAGES = object = new SparseIntArray();
        int n10 = 1;
        object.put(5, n10);
        int n11 = 2;
        object.put(6, n11);
        object.put(7, n11);
        object.put(8, n10);
        object.put(9, n10);
        object.put(10, n10);
        Object object2 = object = (Object)new int[16];
        object2[0] = (SparseIntArray)false;
        object2[1] = (SparseIntArray)true;
        object2[2] = (SparseIntArray)2;
        object2[3] = (SparseIntArray)3;
        object2[4] = (SparseIntArray)4;
        object2[5] = (SparseIntArray)5;
        object2[6] = (SparseIntArray)6;
        object2[7] = (SparseIntArray)7;
        object2[8] = (SparseIntArray)8;
        object2[9] = (SparseIntArray)9;
        object2[10] = (SparseIntArray)10;
        object2[11] = (SparseIntArray)11;
        object2[12] = (SparseIntArray)12;
        object2[13] = (SparseIntArray)13;
        object2[14] = (SparseIntArray)14;
        object2[15] = (SparseIntArray)16;
        SDK_USAGES = (int[])object;
    }

    public AudioAttributesCompat() {
    }

    public AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.mImpl = audioAttributesImpl;
    }

    public static void setForceLegacyBehavior(boolean bl2) {
        sForceLegacyBehavior = bl2;
    }

    public static int toVolumeStreamType(boolean bl2, int n10, int n11) {
        int n12 = n10 & 1;
        int n13 = 1;
        if (n12 == n13) {
            if (!bl2) {
                n13 = 7;
            }
            return n13;
        }
        n12 = 4;
        int n14 = 0;
        if ((n10 &= n12) == n12) {
            if (!bl2) {
                n14 = 6;
            }
            return n14;
        }
        n10 = 3;
        switch (n11) {
            default: {
                if (bl2) break;
                return n10;
            }
            case 13: {
                return n13;
            }
            case 11: {
                return 10;
            }
            case 6: {
                return 2;
            }
            case 5: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return 5;
            }
            case 4: {
                return n12;
            }
            case 3: {
                if (!bl2) {
                    n14 = 8;
                }
            }
            case 2: {
                return n14;
            }
            case 0: 
            case 1: 
            case 12: 
            case 14: 
            case 16: {
                return n10;
            }
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Unknown usage value ");
        charSequence.append(n11);
        charSequence.append(" in audio attributes");
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public static String usageToString(int n10) {
        switch (n10) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown usage ");
                stringBuilder.append(n10);
                return stringBuilder.toString();
            }
            case 16: {
                return "USAGE_ASSISTANT";
            }
            case 14: {
                return "USAGE_GAME";
            }
            case 13: {
                return "USAGE_ASSISTANCE_SONIFICATION";
            }
            case 12: {
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            }
            case 11: {
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            }
            case 10: {
                return "USAGE_NOTIFICATION_EVENT";
            }
            case 9: {
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            }
            case 8: {
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            }
            case 7: {
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            }
            case 6: {
                return "USAGE_NOTIFICATION_RINGTONE";
            }
            case 5: {
                return "USAGE_NOTIFICATION";
            }
            case 4: {
                return "USAGE_ALARM";
            }
            case 3: {
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            }
            case 2: {
                return "USAGE_VOICE_COMMUNICATION";
            }
            case 1: {
                return "USAGE_MEDIA";
            }
            case 0: 
        }
        return "USAGE_UNKNOWN";
    }

    public static AudioAttributesCompat wrap(Object object) {
        int n10 = sForceLegacyBehavior;
        AudioAttributesImplApi21 audioAttributesImplApi21 = null;
        if (n10 != 0) {
            return null;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            object = (AudioAttributes)object;
            audioAttributesImplApi21 = new AudioAttributesImplApi26((AudioAttributes)object);
            AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat(audioAttributesImplApi21);
            return audioAttributesCompat;
        }
        n11 = 21;
        if (n10 >= n11) {
            object = (AudioAttributes)object;
            audioAttributesImplApi21 = new AudioAttributesImplApi21((AudioAttributes)object);
            AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat(audioAttributesImplApi21);
            return audioAttributesCompat;
        }
        return null;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof AudioAttributesCompat;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        object = (AudioAttributesCompat)object;
        AudioAttributesImpl audioAttributesImpl = this.mImpl;
        if (audioAttributesImpl == null) {
            object = ((AudioAttributesCompat)object).mImpl;
            if (object == null) {
                bl3 = true;
            }
            return bl3;
        }
        object = ((AudioAttributesCompat)object).mImpl;
        return audioAttributesImpl.equals(object);
    }

    public int getContentType() {
        return this.mImpl.getContentType();
    }

    public int getFlags() {
        return this.mImpl.getFlags();
    }

    public int getLegacyStreamType() {
        return this.mImpl.getLegacyStreamType();
    }

    public int getRawLegacyStreamType() {
        return this.mImpl.getRawLegacyStreamType();
    }

    public int getUsage() {
        return this.mImpl.getUsage();
    }

    public int getVolumeControlStream() {
        return this.mImpl.getVolumeControlStream();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    public Object unwrap() {
        return this.mImpl.getAudioAttributes();
    }
}

