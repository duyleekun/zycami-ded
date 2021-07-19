/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioFormat
 */
package com.google.mediapipe.components;

import android.media.AudioFormat;
import com.google.mediapipe.components.AudioDataConsumer;
import com.google.mediapipe.components.FrameProcessor;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketCallback;
import com.google.mediapipe.framework.PacketGetter;
import java.nio.ByteBuffer;
import java.util.Iterator;

public class FrameProcessor$2
implements PacketCallback {
    public final /* synthetic */ FrameProcessor this$0;
    public final /* synthetic */ AudioFormat val$audioFormat;

    public FrameProcessor$2(FrameProcessor frameProcessor, AudioFormat audioFormat) {
        this.this$0 = frameProcessor;
        this.val$audioFormat = audioFormat;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void process(Packet packet) {
        Iterator iterator2;
        synchronized (this) {
            iterator2 = this.this$0;
            iterator2 = FrameProcessor.access$100((FrameProcessor)((Object)iterator2));
        }
        iterator2 = iterator2.iterator();
        boolean bl2;
        while (bl2 = iterator2.hasNext()) {
            AudioDataConsumer audioDataConsumer = (AudioDataConsumer)iterator2.next();
            ByteBuffer byteBuffer = ByteBuffer.wrap(PacketGetter.getAudioByteData(packet));
            long l10 = packet.getTimestamp();
            AudioFormat audioFormat = this.val$audioFormat;
            audioDataConsumer.onNewAudioData(byteBuffer, l10, audioFormat);
        }
        return;
    }
}

