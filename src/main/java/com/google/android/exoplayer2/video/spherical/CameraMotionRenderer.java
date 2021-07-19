/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.nio.ByteBuffer;

public final class CameraMotionRenderer
extends BaseRenderer {
    private static final int SAMPLE_WINDOW_DURATION_US = 100000;
    private static final String TAG = "CameraMotionRenderer";
    private final DecoderInputBuffer buffer;
    private long lastTimestampUs;
    private CameraMotionListener listener;
    private long offsetUs;
    private final ParsableByteArray scratch;

    public CameraMotionRenderer() {
        super(6);
        Object object = new DecoderInputBuffer(1);
        this.buffer = object;
        this.scratch = object = new ParsableByteArray();
    }

    private float[] parseMetadata(ByteBuffer byteBuffer) {
        int n10;
        int n11 = byteBuffer.remaining();
        if (n11 != (n10 = 16)) {
            return null;
        }
        Object object = this.scratch;
        byte[] byArray = byteBuffer.array();
        int n12 = byteBuffer.limit();
        ((ParsableByteArray)object).reset(byArray, n12);
        object = this.scratch;
        int n13 = byteBuffer.arrayOffset() + 4;
        ((ParsableByteArray)object).setPosition(n13);
        n13 = 3;
        object = new float[n13];
        byArray = null;
        for (n10 = 0; n10 < n13; ++n10) {
            ParsableByteArray parsableByteArray = this.scratch;
            n12 = parsableByteArray.readLittleEndianInt();
            float f10 = Float.intBitsToFloat(n12);
            object[n10] = f10;
        }
        return object;
    }

    private void resetListener() {
        CameraMotionListener cameraMotionListener = this.listener;
        if (cameraMotionListener != null) {
            cameraMotionListener.onCameraMotionReset();
        }
    }

    public String getName() {
        return TAG;
    }

    public void handleMessage(int n10, Object object) {
        int n11 = 7;
        if (n10 == n11) {
            this.listener = object = (CameraMotionListener)object;
        } else {
            super.handleMessage(n10, object);
        }
    }

    public boolean isEnded() {
        return this.hasReadStreamToEnd();
    }

    public boolean isReady() {
        return true;
    }

    public void onDisabled() {
        this.resetListener();
    }

    public void onPositionReset(long l10, boolean bl2) {
        this.lastTimestampUs = Long.MIN_VALUE;
        this.resetListener();
    }

    public void onStreamChanged(Format[] formatArray, long l10, long l11) {
        this.offsetUs = l11;
    }

    public void render(long l10, long l11) {
        long l12;
        long l13;
        int n10;
        while ((n10 = this.hasReadStreamToEnd()) == 0 && (n10 = (l13 = (l11 = this.lastTimestampUs) - (l12 = 100000L + l10)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0) {
            this.buffer.clear();
            Object object = this.getFormatHolder();
            Object object2 = this.buffer;
            n10 = this.readSource((FormatHolder)object, (DecoderInputBuffer)object2, false);
            int n11 = -4;
            if (n10 != n11 || (n10 = (int)(((Buffer)(object = this.buffer)).isEndOfStream() ? 1 : 0)) != 0) break;
            object = this.buffer;
            this.lastTimestampUs = l12 = ((DecoderInputBuffer)object).timeUs;
            object2 = this.listener;
            if (object2 == null || (n10 = (int)(((Buffer)object).isDecodeOnly() ? 1 : 0)) != 0) continue;
            this.buffer.flip();
            object = (ByteBuffer)Util.castNonNull(this.buffer.data);
            object = this.parseMetadata((ByteBuffer)object);
            if (object == null) continue;
            object2 = (CameraMotionListener)Util.castNonNull(this.listener);
            l12 = this.lastTimestampUs;
            long l14 = this.offsetUs;
            object2.onCameraMotion(l12 -= l14, (float[])object);
        }
    }

    public int supportsFormat(Format object) {
        String string2 = "application/x-camera-motion";
        object = ((Format)object).sampleMimeType;
        int n10 = string2.equals(object);
        if (n10 != 0) {
            n10 = RendererCapabilities.create(4);
        } else {
            object = null;
            n10 = RendererCapabilities.create(0);
        }
        return n10;
    }
}

