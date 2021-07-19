/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 */
package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi21$Builder;
import androidx.media.AudioAttributesImplApi26;

public class AudioAttributesImplApi26$Builder
extends AudioAttributesImplApi21$Builder {
    public AudioAttributesImplApi26$Builder() {
    }

    public AudioAttributesImplApi26$Builder(Object object) {
        super(object);
    }

    public AudioAttributesImpl build() {
        AudioAttributes audioAttributes = this.mFwkBuilder.build();
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26(audioAttributes);
        return audioAttributesImplApi26;
    }

    public AudioAttributesImplApi26$Builder setUsage(int n10) {
        this.mFwkBuilder.setUsage(n10);
        return this;
    }
}

