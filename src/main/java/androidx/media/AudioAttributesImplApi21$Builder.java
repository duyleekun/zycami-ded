/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.media.AudioAttributes$Builder
 */
package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImpl$Builder;
import androidx.media.AudioAttributesImplApi21;

public class AudioAttributesImplApi21$Builder
implements AudioAttributesImpl$Builder {
    public final AudioAttributes.Builder mFwkBuilder;

    public AudioAttributesImplApi21$Builder() {
        AudioAttributes.Builder builder;
        this.mFwkBuilder = builder = new AudioAttributes.Builder();
    }

    public AudioAttributesImplApi21$Builder(Object object) {
        AudioAttributes.Builder builder;
        object = (AudioAttributes)object;
        this.mFwkBuilder = builder = new AudioAttributes.Builder((AudioAttributes)object);
    }

    public AudioAttributesImpl build() {
        AudioAttributes audioAttributes = this.mFwkBuilder.build();
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21(audioAttributes);
        return audioAttributesImplApi21;
    }

    public AudioAttributesImplApi21$Builder setContentType(int n10) {
        this.mFwkBuilder.setContentType(n10);
        return this;
    }

    public AudioAttributesImplApi21$Builder setFlags(int n10) {
        this.mFwkBuilder.setFlags(n10);
        return this;
    }

    public AudioAttributesImplApi21$Builder setLegacyStreamType(int n10) {
        this.mFwkBuilder.setLegacyStreamType(n10);
        return this;
    }

    public AudioAttributesImplApi21$Builder setUsage(int n10) {
        int n11 = 16;
        if (n10 == n11) {
            n10 = 12;
        }
        this.mFwkBuilder.setUsage(n10);
        return this;
    }
}

