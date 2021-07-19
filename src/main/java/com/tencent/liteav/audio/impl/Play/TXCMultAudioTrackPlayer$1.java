/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioTrack
 */
package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import android.media.AudioTrack;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer$AudioTrackThread;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Arrays;

public class TXCMultAudioTrackPlayer$1
extends TXCMultAudioTrackPlayer$AudioTrackThread {
    public final /* synthetic */ TXCMultAudioTrackPlayer this$0;

    public TXCMultAudioTrackPlayer$1(TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer, String string2) {
        this.this$0 = tXCMultAudioTrackPlayer;
        super(tXCMultAudioTrackPlayer, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        StringBuilder stringBuilder;
        int n10;
        AudioTrack audioTrack;
        int n11;
        int n12;
        Object object2;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        int n18;
        int n19;
        Object object3;
        try {
            object3 = this.this$0;
            n19 = TXCMultAudioTrackPlayer.access$100((TXCMultAudioTrackPlayer)object3);
            int n20 = 3;
            n18 = 1;
            n17 = 2;
            n16 = n19 == n18 ? n17 : n20;
            object3 = this.this$0;
            n19 = TXCMultAudioTrackPlayer.access$200((TXCMultAudioTrackPlayer)object3);
            n15 = 8;
            n14 = n19 == n15 ? n20 : n17;
            object3 = this.this$0;
            n19 = TXCMultAudioTrackPlayer.access$300((TXCMultAudioTrackPlayer)object3);
            n19 = AudioTrack.getMinBufferSize((int)n19, (int)n16, (int)n14);
            n13 = 3;
            object2 = this.this$0;
            n12 = TXCMultAudioTrackPlayer.access$300((TXCMultAudioTrackPlayer)object2);
            n11 = 1;
            object2 = audioTrack;
            n10 = n19;
            audioTrack = new AudioTrack(n13, n12, n16, n14, n19, n11);
            object2 = TXCMultAudioTrackPlayer.access$400();
            stringBuilder = new StringBuilder();
            object = "create audio track, samplerate:";
            stringBuilder.append((String)object);
            object = this.this$0;
            n12 = TXCMultAudioTrackPlayer.access$300((TXCMultAudioTrackPlayer)object);
            stringBuilder.append(n12);
            object = ", channels:";
            stringBuilder.append((String)object);
            object = this.this$0;
            n12 = TXCMultAudioTrackPlayer.access$100((TXCMultAudioTrackPlayer)object);
            stringBuilder.append(n12);
            object = ", bits:";
            stringBuilder.append((String)object);
            object = this.this$0;
            n12 = TXCMultAudioTrackPlayer.access$200((TXCMultAudioTrackPlayer)object);
            stringBuilder.append(n12);
            object = " mMinBufferLength:";
            stringBuilder.append((String)object);
            stringBuilder.append(n19);
            object3 = stringBuilder.toString();
            TXCLog.i((String)object2, (String)object3);
        }
        catch (Exception exception) {
            TXCLog.e(TXCMultAudioTrackPlayer.access$400(), "create AudioTrack failed.", exception);
            return;
        }
        try {
            audioTrack.play();
        }
        catch (Exception exception) {
            TXCLog.e(TXCMultAudioTrackPlayer.access$400(), "start play failed.", exception);
            return;
        }
        TXCMultAudioTrackPlayer.access$502(this.this$0, n18 != 0);
        object3 = this.this$0;
        Context context = TXCMultAudioTrackPlayer.access$600((TXCMultAudioTrackPlayer)object3);
        n15 = TXCMultAudioTrackPlayer.access$700(this.this$0);
        ((TXCMultAudioTrackPlayer)object3).setAudioMode(context, n15);
        n19 = 800;
        n18 = 100;
        n15 = 0;
        object2 = null;
        n13 = 0;
        stringBuilder = null;
        while ((n12 = (int)(this.mIsLooping ? 1 : 0)) != 0) {
            object = TXCMultAudioTrackPlayer.access$800(this.this$0);
            if (object != null && (n16 = ((Object)object).length) > 0) {
                long l10 = 0L;
                Object object4 = this.this$0;
                n10 = TXCMultAudioTrackPlayer.access$300((TXCMultAudioTrackPlayer)object4);
                Object object5 = this.this$0;
                n11 = TXCMultAudioTrackPlayer.access$100((TXCMultAudioTrackPlayer)object5);
                TXCAudioEngine.onCorePlayPcmData((byte[])object, l10, n10, n11);
                Object object6 = this.this$0;
                n16 = (int)(TXCMultAudioTrackPlayer.access$900((TXCMultAudioTrackPlayer)object6) ? 1 : 0);
                if (n16 != 0) {
                    Arrays.fill((byte[])object, (byte)0);
                }
                if (n18 != 0 && n13 < n19) {
                    n16 = ((Object)object).length / n17;
                    short[] sArray = new short[n16];
                    object4 = ByteBuffer.wrap((byte[])object);
                    object5 = ByteOrder.LITTLE_ENDIAN;
                    ((ByteBuffer)object4).order((ByteOrder)object5).asShortBuffer().get(sArray);
                    object4 = null;
                    for (n10 = 0; n10 < n16; ++n10) {
                        sArray[n10] = n11 = (int)((short)(sArray[n10] / n18));
                    }
                    object6 = ByteBuffer.wrap((byte[])object);
                    object4 = ByteOrder.LITTLE_ENDIAN;
                    object6 = ((ByteBuffer)object6).order((ByteOrder)object4).asShortBuffer();
                    ((ShortBuffer)object6).put(sArray);
                    n16 = ((Object)object).length;
                    TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer = this.this$0;
                    n14 = TXCMultAudioTrackPlayer.access$300(tXCMultAudioTrackPlayer) * n17 / 1000;
                    n16 = 800 - (n13 += (n16 /= n14));
                    n18 = n18 * n16 / n19;
                }
                n16 = ((Object)object).length;
                audioTrack.write((byte[])object, 0, n16);
                continue;
            }
            long l11 = 5;
            try {
                Thread.sleep(l11);
            }
            catch (InterruptedException interruptedException) {}
        }
        try {
            audioTrack.pause();
            audioTrack.flush();
            audioTrack.stop();
            audioTrack.release();
        }
        catch (Exception exception) {
            String string2 = TXCMultAudioTrackPlayer.access$400();
            String string3 = "stop AudioTrack failed.";
            TXCLog.e(string2, string3, exception);
        }
        TXCLog.e(TXCMultAudioTrackPlayer.access$400(), "mult-player thread stop finish!");
    }
}

