/*
 * Decompiled with CFR 0.151.
 */
package androidx.media;

import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesImpl;
import java.util.Arrays;

public class AudioAttributesImplBase
implements AudioAttributesImpl {
    public int mContentType = 0;
    public int mFlags = 0;
    public int mLegacyStream = -1;
    public int mUsage = 0;

    public AudioAttributesImplBase() {
    }

    public AudioAttributesImplBase(int n10, int n11, int n12, int n13) {
        this.mContentType = n10;
        this.mFlags = n11;
        this.mUsage = n12;
        this.mLegacyStream = n13;
    }

    public static int usageForStreamType(int n10) {
        int n11 = 2;
        switch (n10) {
            default: {
                return 0;
            }
            case 10: {
                return 11;
            }
            case 8: {
                return 3;
            }
            case 6: {
                return n11;
            }
            case 5: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 3: {
                return 1;
            }
            case 2: {
                return 6;
            }
            case 1: 
            case 7: {
                return 13;
            }
            case 0: 
        }
        return n11;
    }

    public boolean equals(Object object) {
        int n10;
        int n11 = object instanceof AudioAttributesImplBase;
        boolean bl2 = false;
        if (n11 == 0) {
            return false;
        }
        n11 = this.mContentType;
        int n12 = ((AudioAttributesImplBase)(object = (AudioAttributesImplBase)object)).getContentType();
        if (n11 == n12 && (n11 = this.mFlags) == (n12 = ((AudioAttributesImplBase)object).getFlags()) && (n11 = this.mUsage) == (n12 = ((AudioAttributesImplBase)object).getUsage()) && (n11 = this.mLegacyStream) == (n10 = ((AudioAttributesImplBase)object).mLegacyStream)) {
            bl2 = true;
        }
        return bl2;
    }

    public Object getAudioAttributes() {
        return null;
    }

    public int getContentType() {
        return this.mContentType;
    }

    public int getFlags() {
        int n10;
        int n11 = this.mFlags;
        int n12 = this.getLegacyStreamType();
        if (n12 == (n10 = 6)) {
            n11 |= 4;
        } else {
            n10 = 7;
            if (n12 == n10) {
                n11 |= 1;
            }
        }
        return n11 & 0x111;
    }

    public int getLegacyStreamType() {
        int n10 = this.mLegacyStream;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n11 = this.mFlags;
        int n12 = this.mUsage;
        return AudioAttributesCompat.toVolumeStreamType(false, n11, n12);
    }

    public int getRawLegacyStreamType() {
        return this.mLegacyStream;
    }

    public int getUsage() {
        return this.mUsage;
    }

    public int getVolumeControlStream() {
        int n10 = this.mFlags;
        int n11 = this.mUsage;
        return AudioAttributesCompat.toVolumeStreamType(true, n10, n11);
    }

    public int hashCode() {
        Object[] objectArray = new Object[4];
        Integer n10 = this.mContentType;
        objectArray[0] = n10;
        n10 = this.mFlags;
        objectArray[1] = n10;
        n10 = this.mUsage;
        objectArray[2] = n10;
        n10 = this.mLegacyStream;
        objectArray[3] = n10;
        return Arrays.hashCode(objectArray);
    }

    public String toString() {
        String string2 = "AudioAttributesCompat:";
        StringBuilder stringBuilder = new StringBuilder(string2);
        int n10 = this.mLegacyStream;
        int n11 = -1;
        if (n10 != n11) {
            stringBuilder.append(" stream=");
            n10 = this.mLegacyStream;
            stringBuilder.append(n10);
            string2 = " derived";
            stringBuilder.append(string2);
        }
        stringBuilder.append(" usage=");
        string2 = AudioAttributesCompat.usageToString(this.mUsage);
        stringBuilder.append(string2);
        stringBuilder.append(" content=");
        n10 = this.mContentType;
        stringBuilder.append(n10);
        stringBuilder.append(" flags=0x");
        string2 = Integer.toHexString(this.mFlags).toUpperCase();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

