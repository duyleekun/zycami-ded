/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.media;

import android.util.Log;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImpl$Builder;
import androidx.media.AudioAttributesImplBase;

public class AudioAttributesImplBase$Builder
implements AudioAttributesImpl$Builder {
    private int mContentType = 0;
    private int mFlags = 0;
    private int mLegacyStream = -1;
    private int mUsage = 0;

    public AudioAttributesImplBase$Builder() {
    }

    public AudioAttributesImplBase$Builder(AudioAttributesCompat audioAttributesCompat) {
        int n10;
        int n11;
        this.mUsage = n11 = audioAttributesCompat.getUsage();
        this.mContentType = n11 = audioAttributesCompat.getContentType();
        this.mFlags = n11 = audioAttributesCompat.getFlags();
        this.mLegacyStream = n10 = audioAttributesCompat.getRawLegacyStreamType();
    }

    /*
     * Handled duff style switch with additional control
     * Enabled aggressive block sorting
     */
    private AudioAttributesImplBase$Builder setInternalLegacyStreamType(int n10) {
        int n11 = 1;
        int n12 = 4;
        int n13 = Integer.MIN_VALUE;
        block13: do {
            switch (n13 == Integer.MIN_VALUE ? n10 : n13) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid stream type ");
                    stringBuilder.append(n10);
                    stringBuilder.append(" for AudioAttributesCompat");
                    String string2 = stringBuilder.toString();
                    String string3 = "AudioAttributesCompat";
                    Log.e((String)string3, (String)string2);
                    break;
                }
                case 10: {
                    this.mContentType = n11;
                    break;
                }
                case 9: {
                    this.mContentType = n12;
                    break;
                }
                case 8: {
                    this.mContentType = n12;
                    break;
                }
                case 7: {
                    int n14 = this.mFlags;
                    this.mFlags = n11 |= n14;
                    n13 = 1;
                    continue block13;
                }
                case 6: {
                    this.mContentType = n11;
                    this.mFlags = n11 = this.mFlags | n12;
                    break;
                }
                case 5: {
                    this.mContentType = n12;
                    break;
                }
                case 4: {
                    this.mContentType = n12;
                    break;
                }
                case 3: {
                    this.mContentType = n11 = 2;
                    break;
                }
                case 2: {
                    this.mContentType = n12;
                    break;
                }
                case 1: {
                    this.mContentType = n12;
                    break;
                }
                case 0: {
                    this.mContentType = n11;
                }
            }
            break;
        } while (true);
        this.mUsage = n10 = AudioAttributesImplBase.usageForStreamType(n10);
        return this;
    }

    public AudioAttributesImpl build() {
        int n10 = this.mContentType;
        int n11 = this.mFlags;
        int n12 = this.mUsage;
        int n13 = this.mLegacyStream;
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase(n10, n11, n12, n13);
        return audioAttributesImplBase;
    }

    public AudioAttributesImplBase$Builder setContentType(int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1) && n10 != (n11 = 2) && n10 != (n11 = 3) && n10 != (n11 = 4)) {
            n10 = 0;
            this.mContentType = 0;
        } else {
            this.mContentType = n10;
        }
        return this;
    }

    public AudioAttributesImplBase$Builder setFlags(int n10) {
        n10 &= 0x3FF;
        int n11 = this.mFlags;
        this.mFlags = n10 |= n11;
        return this;
    }

    public AudioAttributesImplBase$Builder setLegacyStreamType(int n10) {
        int n11 = 10;
        if (n10 != n11) {
            this.mLegacyStream = n10;
            return this.setInternalLegacyStreamType(n10);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        throw illegalArgumentException;
    }

    public AudioAttributesImplBase$Builder setUsage(int n10) {
        switch (n10) {
            default: {
                n10 = 0;
                this.mUsage = 0;
                break;
            }
            case 16: {
                this.mUsage = n10 = 12;
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                this.mUsage = n10;
            }
        }
        return this;
    }
}

