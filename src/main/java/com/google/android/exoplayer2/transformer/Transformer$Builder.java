/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 */
package com.google.android.exoplayer2.transformer;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.transformer.FrameworkMuxer$Factory;
import com.google.android.exoplayer2.transformer.Muxer$Factory;
import com.google.android.exoplayer2.transformer.Transformation;
import com.google.android.exoplayer2.transformer.Transformer;
import com.google.android.exoplayer2.transformer.Transformer$1;
import com.google.android.exoplayer2.transformer.Transformer$Builder$1;
import com.google.android.exoplayer2.transformer.Transformer$Listener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;

public final class Transformer$Builder {
    private Clock clock;
    private Context context;
    private boolean flattenForSlowMotion;
    private Transformer$Listener listener;
    private Looper looper;
    private MediaSourceFactory mediaSourceFactory;
    private Muxer$Factory muxerFactory;
    private String outputMimeType;
    private boolean removeAudio;
    private boolean removeVideo;

    public Transformer$Builder() {
        Object object = new FrameworkMuxer$Factory();
        this.muxerFactory = object;
        this.outputMimeType = "video/mp4";
        this.listener = object = new Transformer$Builder$1(this);
        object = Util.getCurrentOrMainLooper();
        this.looper = object;
        this.clock = object = Clock.DEFAULT;
    }

    private Transformer$Builder(Transformer object) {
        boolean bl2;
        Object object2;
        this.context = object2 = Transformer.access$000((Transformer)object);
        object2 = Transformer.access$100((Transformer)object);
        this.mediaSourceFactory = object2;
        object2 = Transformer.access$200((Transformer)object);
        this.muxerFactory = object2;
        this.removeAudio = bl2 = Transformer.access$300((Transformer)object).removeAudio;
        this.removeVideo = bl2 = Transformer.access$300((Transformer)object).removeVideo;
        this.flattenForSlowMotion = bl2 = Transformer.access$300((Transformer)object).flattenForSlowMotion;
        object2 = Transformer.access$300((Transformer)object).outputMimeType;
        this.outputMimeType = object2;
        object2 = Transformer.access$400((Transformer)object);
        this.listener = object2;
        object2 = Transformer.access$500((Transformer)object);
        this.looper = object2;
        this.clock = object = Transformer.access$600((Transformer)object);
    }

    public /* synthetic */ Transformer$Builder(Transformer transformer, Transformer$1 transformer$1) {
        this(transformer);
    }

    public Transformer build() {
        Object object;
        Object object2;
        Assertions.checkStateNotNull(this.context);
        Object object3 = this.mediaSourceFactory;
        if (object3 == null) {
            object3 = new DefaultExtractorsFactory();
            boolean bl2 = this.flattenForSlowMotion;
            if (bl2) {
                int n10 = 4;
                ((DefaultExtractorsFactory)object3).setMp4ExtractorFlags(n10);
            }
            object2 = this.context;
            this.mediaSourceFactory = object = new DefaultMediaSourceFactory((Context)object2, (ExtractorsFactory)object3);
        }
        object3 = this.muxerFactory;
        object = this.outputMimeType;
        boolean bl2 = object3.supportsOutputMimeType((String)object);
        object = "Unsupported output MIME type: ";
        object2 = String.valueOf(this.outputMimeType);
        int n11 = ((String)object2).length();
        object = n11 != 0 ? ((String)object).concat((String)object2) : (object2 = new String((String)object));
        Assertions.checkState(bl2, object);
        bl2 = this.removeAudio;
        boolean bl3 = this.removeVideo;
        boolean bl4 = this.flattenForSlowMotion;
        String string2 = this.outputMimeType;
        Transformation transformation = new Transformation(bl2, bl3, bl4, string2);
        string2 = this.context;
        MediaSourceFactory mediaSourceFactory = this.mediaSourceFactory;
        Muxer$Factory muxer$Factory = this.muxerFactory;
        Transformer$Listener transformer$Listener = this.listener;
        Looper looper = this.looper;
        Clock clock = this.clock;
        object2 = object3;
        object3 = new Transformer((Context)string2, mediaSourceFactory, muxer$Factory, transformation, transformer$Listener, looper, clock, null);
        return object3;
    }

    public Transformer$Builder setClock(Clock clock) {
        this.clock = clock;
        return this;
    }

    public Transformer$Builder setContext(Context context) {
        this.context = context = context.getApplicationContext();
        return this;
    }

    public Transformer$Builder setFlattenForSlowMotion(boolean bl2) {
        this.flattenForSlowMotion = bl2;
        return this;
    }

    public Transformer$Builder setListener(Transformer$Listener transformer$Listener) {
        this.listener = transformer$Listener;
        return this;
    }

    public Transformer$Builder setLooper(Looper looper) {
        this.looper = looper;
        return this;
    }

    public Transformer$Builder setMediaSourceFactory(MediaSourceFactory mediaSourceFactory) {
        this.mediaSourceFactory = mediaSourceFactory;
        return this;
    }

    public Transformer$Builder setMuxerFactory(Muxer$Factory muxer$Factory) {
        this.muxerFactory = muxer$Factory;
        return this;
    }

    public Transformer$Builder setOutputMimeType(String string2) {
        this.outputMimeType = string2;
        return this;
    }

    public Transformer$Builder setRemoveAudio(boolean bl2) {
        this.removeAudio = bl2;
        return this;
    }

    public Transformer$Builder setRemoveVideo(boolean bl2) {
        this.removeVideo = bl2;
        return this;
    }
}

