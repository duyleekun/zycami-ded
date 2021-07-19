/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.media;

import android.os.Build;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImpl$Builder;
import androidx.media.AudioAttributesImplApi21$Builder;
import androidx.media.AudioAttributesImplApi26$Builder;
import androidx.media.AudioAttributesImplBase$Builder;

public class AudioAttributesCompat$Builder {
    public final AudioAttributesImpl$Builder mBuilderImpl;

    public AudioAttributesCompat$Builder() {
        int n10 = AudioAttributesCompat.sForceLegacyBehavior;
        if (n10 != 0) {
            AudioAttributesImplBase$Builder audioAttributesImplBase$Builder = new AudioAttributesImplBase$Builder();
            this.mBuilderImpl = audioAttributesImplBase$Builder;
        } else {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            if (n10 >= n11) {
                AudioAttributesImplApi26$Builder audioAttributesImplApi26$Builder = new AudioAttributesImplApi26$Builder();
                this.mBuilderImpl = audioAttributesImplApi26$Builder;
            } else {
                n11 = 21;
                if (n10 >= n11) {
                    AudioAttributesImplApi21$Builder audioAttributesImplApi21$Builder = new AudioAttributesImplApi21$Builder();
                    this.mBuilderImpl = audioAttributesImplApi21$Builder;
                } else {
                    AudioAttributesImplBase$Builder audioAttributesImplBase$Builder = new AudioAttributesImplBase$Builder();
                    this.mBuilderImpl = audioAttributesImplBase$Builder;
                }
            }
        }
    }

    public AudioAttributesCompat$Builder(AudioAttributesCompat object) {
        int n10 = AudioAttributesCompat.sForceLegacyBehavior;
        if (n10 != 0) {
            AudioAttributesImplBase$Builder audioAttributesImplBase$Builder = new AudioAttributesImplBase$Builder((AudioAttributesCompat)object);
            this.mBuilderImpl = audioAttributesImplBase$Builder;
        } else {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            if (n10 >= n11) {
                object = ((AudioAttributesCompat)object).unwrap();
                AudioAttributesImplApi26$Builder audioAttributesImplApi26$Builder = new AudioAttributesImplApi26$Builder(object);
                this.mBuilderImpl = audioAttributesImplApi26$Builder;
            } else {
                n11 = 21;
                if (n10 >= n11) {
                    object = ((AudioAttributesCompat)object).unwrap();
                    AudioAttributesImplApi21$Builder audioAttributesImplApi21$Builder = new AudioAttributesImplApi21$Builder(object);
                    this.mBuilderImpl = audioAttributesImplApi21$Builder;
                } else {
                    AudioAttributesImplBase$Builder audioAttributesImplBase$Builder = new AudioAttributesImplBase$Builder((AudioAttributesCompat)object);
                    this.mBuilderImpl = audioAttributesImplBase$Builder;
                }
            }
        }
    }

    public AudioAttributesCompat build() {
        AudioAttributesImpl audioAttributesImpl = this.mBuilderImpl.build();
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat(audioAttributesImpl);
        return audioAttributesCompat;
    }

    public AudioAttributesCompat$Builder setContentType(int n10) {
        this.mBuilderImpl.setContentType(n10);
        return this;
    }

    public AudioAttributesCompat$Builder setFlags(int n10) {
        this.mBuilderImpl.setFlags(n10);
        return this;
    }

    public AudioAttributesCompat$Builder setLegacyStreamType(int n10) {
        this.mBuilderImpl.setLegacyStreamType(n10);
        return this;
    }

    public AudioAttributesCompat$Builder setUsage(int n10) {
        this.mBuilderImpl.setUsage(n10);
        return this;
    }
}

