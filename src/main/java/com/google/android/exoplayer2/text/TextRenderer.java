/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public final class TextRenderer
extends BaseRenderer
implements Handler.Callback {
    private static final int MSG_UPDATE_OUTPUT = 0;
    private static final int REPLACEMENT_STATE_NONE = 0;
    private static final int REPLACEMENT_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REPLACEMENT_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "TextRenderer";
    private SubtitleDecoder decoder;
    private final SubtitleDecoderFactory decoderFactory;
    private int decoderReplacementState;
    private final FormatHolder formatHolder;
    private boolean inputStreamEnded;
    private SubtitleInputBuffer nextInputBuffer;
    private SubtitleOutputBuffer nextSubtitle;
    private int nextSubtitleEventIndex;
    private final TextOutput output;
    private final Handler outputHandler;
    private boolean outputStreamEnded;
    private Format streamFormat;
    private SubtitleOutputBuffer subtitle;
    private boolean waitingForKeyFrame;

    public TextRenderer(TextOutput textOutput, Looper looper) {
        SubtitleDecoderFactory subtitleDecoderFactory = SubtitleDecoderFactory.DEFAULT;
        this(textOutput, looper, subtitleDecoderFactory);
    }

    public TextRenderer(TextOutput object, Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        int n10 = 3;
        super(n10);
        object = (TextOutput)Assertions.checkNotNull(object);
        this.output = object;
        object = looper == null ? null : Util.createHandler(looper, this);
        this.outputHandler = object;
        this.decoderFactory = subtitleDecoderFactory;
        this.formatHolder = object = new FormatHolder();
    }

    private void clearOutput() {
        List list = Collections.emptyList();
        this.updateOutput(list);
    }

    private long getNextEventTime() {
        int n10 = this.nextSubtitleEventIndex;
        long l10 = Long.MAX_VALUE;
        int n11 = -1;
        if (n10 == n11) {
            return l10;
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.subtitle;
        Assertions.checkNotNull(subtitleOutputBuffer);
        n10 = this.nextSubtitleEventIndex;
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.subtitle;
        n11 = subtitleOutputBuffer2.getEventTimeCount();
        if (n10 < n11) {
            subtitleOutputBuffer = this.subtitle;
            int n12 = this.nextSubtitleEventIndex;
            l10 = subtitleOutputBuffer.getEventTime(n12);
        }
        return l10;
    }

    private void handleDecoderError(SubtitleDecoderException subtitleDecoderException) {
        String string2 = String.valueOf(this.streamFormat);
        int n10 = String.valueOf(string2).length() + 39;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Subtitle decoding failed. streamFormat=");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        Log.e(TAG, string2, subtitleDecoderException);
        this.clearOutput();
        this.replaceDecoder();
    }

    private void initDecoder() {
        this.waitingForKeyFrame = true;
        Object object = this.decoderFactory;
        Format format = (Format)Assertions.checkNotNull(this.streamFormat);
        this.decoder = object = object.createDecoder(format);
    }

    private void invokeUpdateOutputInternal(List list) {
        this.output.onCues(list);
    }

    private void releaseBuffers() {
        int n10;
        this.nextInputBuffer = null;
        this.nextSubtitleEventIndex = n10 = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.subtitle;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.release();
            this.subtitle = null;
        }
        if ((subtitleOutputBuffer = this.nextSubtitle) != null) {
            subtitleOutputBuffer.release();
            this.nextSubtitle = null;
        }
    }

    private void releaseDecoder() {
        this.releaseBuffers();
        ((SubtitleDecoder)Assertions.checkNotNull(this.decoder)).release();
        this.decoder = null;
        this.decoderReplacementState = 0;
    }

    private void replaceDecoder() {
        this.releaseDecoder();
        this.initDecoder();
    }

    private void updateOutput(List list) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            list = handler.obtainMessage(0, (Object)list);
            list.sendToTarget();
        } else {
            this.invokeUpdateOutputInternal(list);
        }
    }

    public String getName() {
        return TAG;
    }

    public boolean handleMessage(Message object) {
        int n10 = object.what;
        if (n10 == 0) {
            object = (List)object.obj;
            this.invokeUpdateOutputInternal((List)object);
            return true;
        }
        object = new IllegalStateException();
        throw object;
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        return true;
    }

    public void onDisabled() {
        this.streamFormat = null;
        this.clearOutput();
        this.releaseDecoder();
    }

    public void onPositionReset(long l10, boolean bl2) {
        this.clearOutput();
        SubtitleDecoder subtitleDecoder = null;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        int n10 = this.decoderReplacementState;
        if (n10 != 0) {
            this.replaceDecoder();
        } else {
            this.releaseBuffers();
            subtitleDecoder = (SubtitleDecoder)Assertions.checkNotNull(this.decoder);
            subtitleDecoder.flush();
        }
    }

    public void onStreamChanged(Format[] object, long l10, long l11) {
        this.streamFormat = object = object[0];
        object = this.decoder;
        if (object != null) {
            int n10;
            this.decoderReplacementState = n10 = 1;
        } else {
            this.initDecoder();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void render(long l10, long l11) {
        int n10;
        Object object;
        SubtitleOutputBuffer subtitleOutputBuffer;
        long l12;
        int n11;
        int n12 = this.outputStreamEnded;
        if (n12 != 0) {
            return;
        }
        Object object2 = this.nextSubtitle;
        if (object2 == null) {
            object2 = (SubtitleDecoder)Assertions.checkNotNull(this.decoder);
            object2.setPositionUs(l10);
            try {
                object2 = this.decoder;
                object2 = Assertions.checkNotNull(object2);
                object2 = (SubtitleDecoder)object2;
                object2 = object2.dequeueOutputBuffer();
                this.nextSubtitle = object2 = (SubtitleOutputBuffer)object2;
            }
            catch (SubtitleDecoderException subtitleDecoderException) {
                this.handleDecoderError(subtitleDecoderException);
                return;
            }
        }
        if ((n12 = this.getState()) != (n11 = 2)) {
            return;
        }
        object2 = this.subtitle;
        int n13 = 1;
        if (object2 != null) {
            long l13 = this.getNextEventTime();
            n12 = 0;
            object2 = null;
            while ((l12 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1)) <= 0) {
                this.nextSubtitleEventIndex = n12 = this.nextSubtitleEventIndex + n13;
                l13 = this.getNextEventTime();
                n12 = n13;
            }
        } else {
            n12 = 0;
            object2 = null;
        }
        if ((subtitleOutputBuffer = this.nextSubtitle) != null) {
            long l14;
            boolean bl2 = subtitleOutputBuffer.isEndOfStream();
            if (bl2) {
                long l15;
                long l16;
                if (n12 == 0 && (l12 = (l16 = (l14 = this.getNextEventTime()) - (l15 = Long.MAX_VALUE)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) == false) {
                    l12 = this.decoderReplacementState;
                    if (l12 == n11) {
                        this.replaceDecoder();
                    } else {
                        this.releaseBuffers();
                        this.outputStreamEnded = n13;
                    }
                }
            } else {
                l14 = subtitleOutputBuffer.timeUs;
                long l17 = l14 - l10;
                Object object3 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                if (object3 <= 0) {
                    object2 = this.subtitle;
                    if (object2 != null) {
                        ((OutputBuffer)object2).release();
                    }
                    this.nextSubtitleEventIndex = n12 = subtitleOutputBuffer.getNextEventTimeIndex(l10);
                    this.subtitle = subtitleOutputBuffer;
                    this.nextSubtitle = null;
                    n12 = n13;
                }
            }
        }
        if (n12 != 0) {
            Assertions.checkNotNull(this.subtitle);
            object2 = this.subtitle;
            object = ((SubtitleOutputBuffer)object2).getCues(l10);
            this.updateOutput((List)object);
        }
        if ((n10 = this.decoderReplacementState) == n11) {
            return;
        }
        try {
            while ((n10 = (int)(this.inputStreamEnded ? 1 : 0)) == 0) {
                Object object4;
                int n14;
                object = this.nextInputBuffer;
                if (object == null) {
                    object = this.decoder;
                    object = Assertions.checkNotNull(object);
                    object = (SubtitleDecoder)object;
                    object = object.dequeueInputBuffer();
                    if ((object = (SubtitleInputBuffer)object) == null) {
                        return;
                    }
                    this.nextInputBuffer = object;
                }
                if ((n14 = this.decoderReplacementState) == n13) {
                    n14 = 4;
                    ((Buffer)object).setFlags(n14);
                    object4 = this.decoder;
                    object4 = Assertions.checkNotNull(object4);
                    object4 = (SubtitleDecoder)object4;
                    object4.queueInputBuffer(object);
                    this.nextInputBuffer = null;
                    this.decoderReplacementState = n11;
                    return;
                }
                object4 = this.formatHolder;
                n14 = this.readSource((FormatHolder)object4, (DecoderInputBuffer)object, false);
                if (n14 == (n12 = -4)) {
                    n14 = (int)(((Buffer)object).isEndOfStream() ? 1 : 0);
                    if (n14 != 0) {
                        this.inputStreamEnded = n13;
                        this.waitingForKeyFrame = false;
                    } else {
                        long l18;
                        object4 = this.formatHolder;
                        object4 = ((FormatHolder)object4).format;
                        if (object4 == null) {
                            return;
                        }
                        ((SubtitleInputBuffer)object).subsampleOffsetUs = l18 = ((Format)object4).subsampleOffsetUs;
                        ((DecoderInputBuffer)object).flip();
                        n14 = (int)(this.waitingForKeyFrame ? 1 : 0);
                        n12 = (int)(((Buffer)object).isKeyFrame() ? 1 : 0);
                        if (n12 == 0) {
                            n12 = n13;
                        } else {
                            n12 = 0;
                            object2 = null;
                        }
                        this.waitingForKeyFrame = n14 &= n12;
                    }
                    if ((n14 = (int)(this.waitingForKeyFrame ? 1 : 0)) != 0) continue;
                    object4 = this.decoder;
                    object4 = Assertions.checkNotNull(object4);
                    object4 = (SubtitleDecoder)object4;
                    object4.queueInputBuffer(object);
                    this.nextInputBuffer = null;
                    continue;
                }
                n10 = -3;
                if (n14 != n10) continue;
                return;
            }
            return;
        }
        catch (SubtitleDecoderException subtitleDecoderException) {
            this.handleDecoderError(subtitleDecoderException);
        }
    }

    public int supportsFormat(Format object) {
        SubtitleDecoderFactory subtitleDecoderFactory = this.decoderFactory;
        boolean bl2 = subtitleDecoderFactory.supportsFormat((Format)object);
        if (bl2) {
            object = ((Format)object).exoMediaCryptoType;
            int n10 = object == null ? 4 : 2;
            return RendererCapabilities.create(n10);
        }
        object = ((Format)object).sampleMimeType;
        boolean bl3 = MimeTypes.isText((String)object);
        if (bl3) {
            return RendererCapabilities.create(1);
        }
        return RendererCapabilities.create(0);
    }
}

