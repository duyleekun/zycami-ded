/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.widget.TextView
 */
package com.google.android.exoplayer2.ui;

import android.os.Looper;
import android.widget.TextView;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Locale;

public class DebugTextViewHelper
implements Player$EventListener,
Runnable {
    private static final int REFRESH_INTERVAL_MS = 1000;
    private final SimpleExoPlayer player;
    private boolean started;
    private final TextView textView;

    public DebugTextViewHelper(SimpleExoPlayer simpleExoPlayer, TextView textView) {
        boolean bl2;
        Looper looper = simpleExoPlayer.getApplicationLooper();
        Looper looper2 = Looper.getMainLooper();
        if (looper == looper2) {
            bl2 = true;
        } else {
            bl2 = false;
            looper = null;
        }
        Assertions.checkArgument(bl2);
        this.player = simpleExoPlayer;
        this.textView = textView;
    }

    private static String getDecoderCountersBufferCountString(DecoderCounters decoderCounters) {
        if (decoderCounters == null) {
            return "";
        }
        decoderCounters.ensureUpdated();
        int n10 = decoderCounters.skippedInputBufferCount;
        int n11 = decoderCounters.skippedOutputBufferCount;
        int n12 = decoderCounters.renderedOutputBufferCount;
        int n13 = decoderCounters.droppedBufferCount;
        int n14 = decoderCounters.maxConsecutiveDroppedBufferCount;
        int n15 = decoderCounters.droppedToKeyframeCount;
        StringBuilder stringBuilder = new StringBuilder(93);
        stringBuilder.append(" sib:");
        stringBuilder.append(n10);
        stringBuilder.append(" sb:");
        stringBuilder.append(n11);
        stringBuilder.append(" rb:");
        stringBuilder.append(n12);
        stringBuilder.append(" db:");
        stringBuilder.append(n13);
        stringBuilder.append(" mcdb:");
        stringBuilder.append(n14);
        stringBuilder.append(" dk:");
        stringBuilder.append(n15);
        return stringBuilder.toString();
    }

    private static String getPixelAspectRatioString(float f10) {
        Object object;
        float f11;
        float f12 = -1.0f;
        float f13 = f10 - f12;
        Object object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object2 != false && (object2 = (f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
            String string2 = " par:";
            Locale locale = Locale.US;
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = Float.valueOf(f10);
            object = String.valueOf(String.format(locale, "%.02f", objectArray));
            int n11 = ((String)object).length();
            object = n11 != 0 ? string2.concat((String)object) : new String(string2);
        } else {
            object = "";
        }
        return object;
    }

    private static String getVideoFrameProcessingOffsetAverageString(long l10, int n10) {
        if (n10 == 0) {
            return "N/A";
        }
        double d10 = l10;
        double d11 = n10;
        return String.valueOf((long)(d10 / d11));
    }

    public String getAudioString() {
        Format format = this.player.getAudioFormat();
        Object object = this.player.getAudioDecoderCounters();
        if (format != null && object != null) {
            String string2 = format.sampleMimeType;
            String string3 = format.id;
            int n10 = format.sampleRate;
            int n11 = format.channelCount;
            object = DebugTextViewHelper.getDecoderCountersBufferCountString((DecoderCounters)object);
            int n12 = String.valueOf(string2).length() + 36;
            int n13 = String.valueOf(string3).length();
            n12 += n13;
            n13 = String.valueOf(object).length();
            StringBuilder stringBuilder = new StringBuilder(n12 += n13);
            stringBuilder.append("\n");
            stringBuilder.append(string2);
            stringBuilder.append("(id:");
            stringBuilder.append(string3);
            stringBuilder.append(" hz:");
            stringBuilder.append(n10);
            stringBuilder.append(" ch:");
            stringBuilder.append(n11);
            stringBuilder.append((String)object);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
        return "";
    }

    public String getDebugString() {
        String string2 = this.getPlayerStateString();
        String string3 = this.getVideoString();
        String string4 = this.getAudioString();
        int n10 = String.valueOf(string2).length();
        int n11 = String.valueOf(string3).length();
        n10 += n11;
        n11 = String.valueOf(string4).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public String getPlayerStateString() {
        int n10;
        Object object = this.player;
        int n11 = ((SimpleExoPlayer)object).getPlaybackState();
        int n12 = 3;
        int n13 = 2;
        int n14 = 1;
        object = n11 != n14 ? (n11 != n13 ? (n11 != n12 ? (n11 != (n10 = 4) ? "unknown" : "ended") : "ready") : "buffering") : "idle";
        Object[] objectArray = new Object[n12];
        Boolean bl2 = this.player.getPlayWhenReady();
        objectArray[0] = bl2;
        objectArray[n14] = object;
        objectArray[n13] = object = Integer.valueOf(this.player.getCurrentWindowIndex());
        return String.format("playWhenReady:%s playbackState:%s window:%s", objectArray);
    }

    public String getVideoString() {
        Object object = this.player.getVideoFormat();
        Object object2 = this.player.getVideoDecoderCounters();
        if (object != null && object2 != null) {
            String string2 = ((Format)object).sampleMimeType;
            String string3 = ((Format)object).id;
            int n10 = ((Format)object).width;
            int n11 = ((Format)object).height;
            object = DebugTextViewHelper.getPixelAspectRatioString(((Format)object).pixelWidthHeightRatio);
            String string4 = DebugTextViewHelper.getDecoderCountersBufferCountString((DecoderCounters)object2);
            long l10 = ((DecoderCounters)object2).totalVideoFrameProcessingOffsetUs;
            int n12 = ((DecoderCounters)object2).videoFrameProcessingOffsetCount;
            object2 = DebugTextViewHelper.getVideoFrameProcessingOffsetAverageString(l10, n12);
            int n13 = String.valueOf(string2).length() + 39;
            int n14 = String.valueOf(string3).length();
            n13 += n14;
            n14 = String.valueOf(object).length();
            n13 += n14;
            n14 = String.valueOf(string4).length();
            n13 += n14;
            n14 = String.valueOf(object2).length();
            StringBuilder stringBuilder = new StringBuilder(n13 += n14);
            stringBuilder.append("\n");
            stringBuilder.append(string2);
            stringBuilder.append("(id:");
            stringBuilder.append(string3);
            stringBuilder.append(" r:");
            stringBuilder.append(n10);
            stringBuilder.append("x");
            stringBuilder.append(n11);
            stringBuilder.append((String)object);
            stringBuilder.append(string4);
            stringBuilder.append(" vfpo: ");
            stringBuilder.append((String)object2);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
        return "";
    }

    public final void onPlayWhenReadyChanged(boolean bl2, int n10) {
        this.updateAndPost();
    }

    public final void onPlaybackStateChanged(int n10) {
        this.updateAndPost();
    }

    public final void onPositionDiscontinuity(int n10) {
        this.updateAndPost();
    }

    public final void run() {
        this.updateAndPost();
    }

    public final void start() {
        boolean bl2 = this.started;
        if (bl2) {
            return;
        }
        this.started = true;
        this.player.addListener(this);
        this.updateAndPost();
    }

    public final void stop() {
        boolean bl2 = this.started;
        if (!bl2) {
            return;
        }
        this.started = false;
        this.player.removeListener(this);
        this.textView.removeCallbacks((Runnable)this);
    }

    public final void updateAndPost() {
        TextView textView = this.textView;
        String string2 = this.getDebugString();
        textView.setText((CharSequence)string2);
        this.textView.removeCallbacks((Runnable)this);
        this.textView.postDelayed((Runnable)this, 1000L);
    }
}

