/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  android.os.ParcelFileDescriptor
 */
package com.google.android.exoplayer2.transformer;

import android.content.Context;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.google.android.exoplayer2.DefaultLoadControl$Builder;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.SimpleExoPlayer$Builder;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$ParametersBuilder;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.transformer.Muxer;
import com.google.android.exoplayer2.transformer.Muxer$Factory;
import com.google.android.exoplayer2.transformer.MuxerWrapper;
import com.google.android.exoplayer2.transformer.ProgressHolder;
import com.google.android.exoplayer2.transformer.Transformation;
import com.google.android.exoplayer2.transformer.Transformer$1;
import com.google.android.exoplayer2.transformer.Transformer$Builder;
import com.google.android.exoplayer2.transformer.Transformer$Listener;
import com.google.android.exoplayer2.transformer.Transformer$TransformerAnalyticsListener;
import com.google.android.exoplayer2.transformer.Transformer$TransformerRenderersFactory;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;

public final class Transformer {
    public static final int PROGRESS_STATE_AVAILABLE = 1;
    public static final int PROGRESS_STATE_NO_TRANSFORMATION = 4;
    public static final int PROGRESS_STATE_UNAVAILABLE = 2;
    public static final int PROGRESS_STATE_WAITING_FOR_AVAILABILITY;
    private final Clock clock;
    private final Context context;
    private Transformer$Listener listener;
    private final Looper looper;
    private final MediaSourceFactory mediaSourceFactory;
    private final Muxer$Factory muxerFactory;
    private MuxerWrapper muxerWrapper;
    private SimpleExoPlayer player;
    private int progressState;
    private final Transformation transformation;

    private Transformer(Context context, MediaSourceFactory mediaSourceFactory, Muxer$Factory muxer$Factory, Transformation transformation, Transformer$Listener transformer$Listener, Looper looper, Clock clock) {
        boolean bl2 = transformation.removeAudio;
        bl2 = !bl2 || !(bl2 = transformation.removeVideo);
        Assertions.checkState(bl2, "Audio and video cannot both be removed.");
        this.context = context;
        this.mediaSourceFactory = mediaSourceFactory;
        this.muxerFactory = muxer$Factory;
        this.transformation = transformation;
        this.listener = transformer$Listener;
        this.looper = looper;
        this.clock = clock;
        this.progressState = 4;
    }

    public /* synthetic */ Transformer(Context context, MediaSourceFactory mediaSourceFactory, Muxer$Factory muxer$Factory, Transformation transformation, Transformer$Listener transformer$Listener, Looper looper, Clock clock, Transformer$1 transformer$1) {
        this(context, mediaSourceFactory, muxer$Factory, transformation, transformer$Listener, looper, clock);
    }

    public static /* synthetic */ Context access$000(Transformer transformer) {
        return transformer.context;
    }

    public static /* synthetic */ MediaSourceFactory access$100(Transformer transformer) {
        return transformer.mediaSourceFactory;
    }

    public static /* synthetic */ SimpleExoPlayer access$1000(Transformer transformer) {
        return transformer.player;
    }

    public static /* synthetic */ void access$1100(Transformer transformer, boolean bl2) {
        transformer.releaseResources(bl2);
    }

    public static /* synthetic */ Muxer$Factory access$200(Transformer transformer) {
        return transformer.muxerFactory;
    }

    public static /* synthetic */ Transformation access$300(Transformer transformer) {
        return transformer.transformation;
    }

    public static /* synthetic */ Transformer$Listener access$400(Transformer transformer) {
        return transformer.listener;
    }

    public static /* synthetic */ Looper access$500(Transformer transformer) {
        return transformer.looper;
    }

    public static /* synthetic */ Clock access$600(Transformer transformer) {
        return transformer.clock;
    }

    public static /* synthetic */ int access$900(Transformer transformer) {
        return transformer.progressState;
    }

    public static /* synthetic */ int access$902(Transformer transformer, int n10) {
        transformer.progressState = n10;
        return n10;
    }

    private void releaseResources(boolean bl2) {
        this.verifyApplicationThread();
        Object object = this.player;
        if (object != null) {
            ((SimpleExoPlayer)object).release();
            this.player = null;
        }
        if ((object = this.muxerWrapper) != null) {
            ((MuxerWrapper)object).release(bl2);
            this.muxerWrapper = null;
        }
        this.progressState = 4;
    }

    private void startTransformation(MediaItem object, Muxer object2) {
        this.verifyApplicationThread();
        Object object3 = this.player;
        if (object3 == null) {
            this.muxerWrapper = object3 = new MuxerWrapper((Muxer)object2);
            Object object4 = this.context;
            object2 = new DefaultTrackSelector((Context)object4);
            Object object5 = this.context;
            object4 = new DefaultTrackSelector$ParametersBuilder((Context)object5);
            object4 = ((DefaultTrackSelector$ParametersBuilder)object4).setForceHighestSupportedBitrate(true).build();
            ((DefaultTrackSelector)object2).setParameters((DefaultTrackSelector$Parameters)object4);
            object4 = new DefaultLoadControl$Builder();
            int n10 = 50000;
            object4 = ((DefaultLoadControl$Builder)object4).setBufferDurationsMs(n10, n10, 250, 500).build();
            Object object6 = this.context;
            Transformation transformation = this.transformation;
            Transformer$TransformerRenderersFactory transformer$TransformerRenderersFactory = new Transformer$TransformerRenderersFactory((MuxerWrapper)object3, transformation);
            object5 = new SimpleExoPlayer$Builder((Context)object6, transformer$TransformerRenderersFactory);
            object6 = this.mediaSourceFactory;
            object2 = ((SimpleExoPlayer$Builder)object5).setMediaSourceFactory((MediaSourceFactory)object6).setTrackSelector((TrackSelector)object2).setLoadControl((LoadControl)object4);
            object4 = this.looper;
            object2 = ((SimpleExoPlayer$Builder)object2).setLooper((Looper)object4);
            object4 = this.clock;
            this.player = object2 = ((SimpleExoPlayer$Builder)object2).setClock((Clock)object4).build();
            ((SimpleExoPlayer)object2).setMediaItem((MediaItem)object);
            object2 = this.player;
            object4 = new Transformer$TransformerAnalyticsListener(this, (MediaItem)object, (MuxerWrapper)object3);
            ((SimpleExoPlayer)object2).addAnalyticsListener((AnalyticsListener)object4);
            this.player.prepare();
            this.progressState = 0;
            return;
        }
        object = new IllegalStateException("There is already a transformation in progress.");
        throw object;
    }

    private void verifyApplicationThread() {
        Looper looper;
        Object object = Looper.myLooper();
        if (object == (looper = this.looper)) {
            return;
        }
        object = new IllegalStateException("Transformer is accessed on the wrong thread.");
        throw object;
    }

    public Transformer$Builder buildUpon() {
        Transformer$Builder transformer$Builder = new Transformer$Builder(this, null);
        return transformer$Builder;
    }

    public void cancel() {
        this.releaseResources(true);
    }

    public Looper getApplicationLooper() {
        return this.looper;
    }

    public int getProgress(ProgressHolder progressHolder) {
        this.verifyApplicationThread();
        int n10 = this.progressState;
        int n11 = 1;
        if (n10 == n11) {
            Player player = (Player)Assertions.checkNotNull(this.player);
            long l10 = player.getDuration();
            long l11 = player.getCurrentPosition();
            long l12 = 100;
            l11 = l11 * l12 / l10;
            n10 = (int)l11;
            n11 = 99;
            progressHolder.progress = n10 = Math.min(n10, n11);
        }
        return this.progressState;
    }

    public void setListener(Transformer$Listener transformer$Listener) {
        this.verifyApplicationThread();
        this.listener = transformer$Listener;
    }

    public void startTransformation(MediaItem mediaItem, ParcelFileDescriptor object) {
        Muxer$Factory muxer$Factory = this.muxerFactory;
        String string2 = this.transformation.outputMimeType;
        object = muxer$Factory.create((ParcelFileDescriptor)object, string2);
        this.startTransformation(mediaItem, (Muxer)object);
    }

    public void startTransformation(MediaItem mediaItem, String object) {
        Muxer$Factory muxer$Factory = this.muxerFactory;
        String string2 = this.transformation.outputMimeType;
        object = muxer$Factory.create((String)object, string2);
        this.startTransformation(mediaItem, (Muxer)object);
    }
}

