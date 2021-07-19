/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package com.meicam.nvconvertorlib;

import android.os.Message;
import com.meicam.nvconvertorlib.Logger;
import com.meicam.nvconvertorlib.Mp4v2Helper;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter;
import com.meicam.nvconvertorlib.NvVideoFrame;
import com.meicam.nvconvertorlib.NvVideoResolution;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class NvAndroidSurfaceFileWriter$5
implements Runnable {
    public final /* synthetic */ NvAndroidSurfaceFileWriter this$0;

    public NvAndroidSurfaceFileWriter$5(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter) {
        this.this$0 = nvAndroidSurfaceFileWriter;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        int n10;
        boolean bl2;
        Object object2;
        NvAndroidSurfaceFileWriter$5 nvAndroidSurfaceFileWriter$5;
        block22: {
            nvAndroidSurfaceFileWriter$5 = this;
            object2 = this.this$0;
            int n11 = NvAndroidSurfaceFileWriter.access$800((NvAndroidSurfaceFileWriter)object2);
            int n12 = 1;
            long l10 = 0L;
            int n13 = 0;
            Object object3 = null;
            int n14 = n12;
            int n15 = n12;
            long l11 = l10;
            long l12 = l10;
            bl2 = false;
            n10 = n11 ^= n12;
            while (true) {
                block30: {
                    block27: {
                        block23: {
                            block29: {
                                block28: {
                                    long l13;
                                    int n16;
                                    Object object4;
                                    block26: {
                                        CharSequence charSequence;
                                        block25: {
                                            block24: {
                                                object2 = nvAndroidSurfaceFileWriter$5.this$0;
                                                boolean bl3 = ((NvAndroidSurfaceFileWriter)object2).mRelease;
                                                if (bl3) break;
                                                bl3 = false;
                                                object4 = null;
                                                Object object5 = ((NvAndroidSurfaceFileWriter)object2).m_mp4muxSyncObject;
                                                synchronized (object5) {
                                                    block20: {
                                                        object2 = nvAndroidSurfaceFileWriter$5.this$0;
                                                        object2 = ((NvAndroidSurfaceFileWriter)object2).m_mp4MuxBuffer;
                                                        n11 = ((ArrayList)object2).size();
                                                        if (n11 == 0) {
                                                            Object object6;
                                                            block21: {
                                                                object2 = "wait";
                                                                object6 = "m_mp4muxSyncObject";
                                                                try {
                                                                    Logger.e((String)object2, object6);
                                                                    object2 = nvAndroidSurfaceFileWriter$5.this$0;
                                                                    object2 = ((NvAndroidSurfaceFileWriter)object2).m_mp4muxSyncObject;
                                                                    object2.wait();
                                                                    object2 = nvAndroidSurfaceFileWriter$5.this$0;
                                                                    object2 = ((NvAndroidSurfaceFileWriter)object2).m_mp4MuxBuffer;
                                                                    n11 = ((ArrayList)object2).size();
                                                                    if (n11 <= 0) break block20;
                                                                    object2 = nvAndroidSurfaceFileWriter$5.this$0;
                                                                    object2 = ((NvAndroidSurfaceFileWriter)object2).m_mp4MuxBuffer;
                                                                    object6 = object2 = ((ArrayList)object2).get(0);
                                                                    object6 = (NvVideoFrame)object2;
                                                                }
                                                                catch (InterruptedException interruptedException) {
                                                                    // empty catch block
                                                                    break block21;
                                                                }
                                                                try {
                                                                    object2 = nvAndroidSurfaceFileWriter$5.this$0;
                                                                    NvAndroidSurfaceFileWriter.access$902((NvAndroidSurfaceFileWriter)object2, (NvVideoFrame)object6);
                                                                    object2 = nvAndroidSurfaceFileWriter$5.this$0;
                                                                    object2 = ((NvAndroidSurfaceFileWriter)object2).m_mp4MuxBuffer;
                                                                    ((ArrayList)object2).remove(0);
                                                                    object4 = object6;
                                                                    break block20;
                                                                }
                                                                catch (InterruptedException interruptedException) {
                                                                    object4 = object6;
                                                                }
                                                            }
                                                            object6 = "SurfaceFileWriter";
                                                            charSequence = new StringBuilder();
                                                            object = "";
                                                            charSequence.append((String)object);
                                                            object = ((Throwable)object2).getMessage();
                                                            charSequence.append((String)object);
                                                            object = charSequence.toString();
                                                            Logger.e((String)object6, object);
                                                            ((Throwable)object2).printStackTrace();
                                                        } else {
                                                            object2 = nvAndroidSurfaceFileWriter$5.this$0;
                                                            object2 = ((NvAndroidSurfaceFileWriter)object2).m_mp4MuxBuffer;
                                                            object4 = object2 = ((ArrayList)object2).get(0);
                                                            object4 = (NvVideoFrame)object2;
                                                            object2 = nvAndroidSurfaceFileWriter$5.this$0;
                                                            NvAndroidSurfaceFileWriter.access$902((NvAndroidSurfaceFileWriter)object2, (NvVideoFrame)object4);
                                                            object2 = nvAndroidSurfaceFileWriter$5.this$0;
                                                            object2 = ((NvAndroidSurfaceFileWriter)object2).m_mp4MuxBuffer;
                                                            ((ArrayList)object2).remove(0);
                                                        }
                                                    }
                                                    if (object4 == null) break block23;
                                                }
                                                n11 = ((NvVideoFrame)object4).bufferFlags;
                                                n12 = n11 & 4;
                                                if (n12 <= 0) break block24;
                                                int n17 = ((NvVideoFrame)object4).buffer.limit();
                                                object2 = nvAndroidSurfaceFileWriter$5.this$0;
                                                object = ((NvAndroidSurfaceFileWriter)object2).m_MediaMuxer;
                                                object4 = ((NvVideoFrame)object4).buffer;
                                                object5 = ((NvAndroidSurfaceFileWriter)object2).m_videoRes;
                                                int n18 = ((NvVideoResolution)object5).imageWidth;
                                                n16 = ((NvVideoResolution)object5).imageHeight;
                                                int n19 = ((NvAndroidSurfaceFileWriter)object2).m_avgFps;
                                                float f10 = n19;
                                                n13 = ((NvAndroidSurfaceFileWriter)object2).m_rotation;
                                                n11 = (int)(((NvAndroidSurfaceFileWriter)object2).m_isAVC ? 1 : 0);
                                                ((Mp4v2Helper)object).AddVideoTrack((ByteBuffer)object4, n17, n18, n16, f10, n13, n11 != 0);
                                                break block23;
                                            }
                                            n12 = n11 & 2;
                                            if (n12 <= 0) break block25;
                                            object2 = ((NvVideoFrame)object4).buffer;
                                            n11 = ((Buffer)object2).limit();
                                            object = nvAndroidSurfaceFileWriter$5.this$0;
                                            object3 = ((NvAndroidSurfaceFileWriter)object).m_MediaMuxer;
                                            object4 = ((NvVideoFrame)object4).buffer;
                                            n12 = NvAndroidSurfaceFileWriter.access$1000((NvAndroidSurfaceFileWriter)object);
                                            ((Mp4v2Helper)object3).AddAudioTrack((ByteBuffer)object4, n11, n12);
                                            break block23;
                                        }
                                        n12 = n11 & 8;
                                        if (n12 <= 0) break block26;
                                        if ((n11 &= 1) > 0) {
                                            n11 = 1;
                                        } else {
                                            n11 = 0;
                                            object2 = null;
                                        }
                                        if (n15 != 0) {
                                            l12 = ((NvVideoFrame)object4).streamTime;
                                            object = nvAndroidSurfaceFileWriter$5.this$0;
                                            NvAndroidSurfaceFileWriter.access$902((NvAndroidSurfaceFileWriter)object, (NvVideoFrame)object4);
                                            n15 = 0;
                                        }
                                        long l14 = ((NvVideoFrame)object4).streamTime - l12;
                                        NvAndroidSurfaceFileWriter.access$902(nvAndroidSurfaceFileWriter$5.this$0, (NvVideoFrame)object4);
                                        object3 = new StringBuilder();
                                        charSequence = "WriteVideoFrameData flags: ";
                                        ((StringBuilder)object3).append((String)charSequence);
                                        ((StringBuilder)object3).append(n11);
                                        object3 = ((StringBuilder)object3).toString();
                                        Logger.e("SurfaceFileWriter", object3);
                                        object = nvAndroidSurfaceFileWriter$5.this$0.m_MediaMuxer;
                                        object3 = ((NvVideoFrame)object4).buffer;
                                        ((Mp4v2Helper)object).WriteVideoFrameData((ByteBuffer)object3, n11, l14);
                                        double d10 = l14;
                                        object2 = nvAndroidSurfaceFileWriter$5.this$0;
                                        long l15 = ((NvAndroidSurfaceFileWriter)object2).m_endTime;
                                        n13 = n10;
                                        l13 = ((NvAndroidSurfaceFileWriter)object2).m_startTime;
                                        double d11 = l15 -= l13;
                                        d10 /= d11;
                                        l13 = 0x3FF0000000000000L;
                                        d11 = Math.max(Math.min(d10, 1.0), 0.0) * 100.0;
                                        d10 = 0.5;
                                        n11 = (int)(d11 += d10);
                                        object = new Message();
                                        ((Message)object).what = n10 = 1;
                                        ((Message)object).arg1 = n11;
                                        object2 = nvAndroidSurfaceFileWriter$5.this$0.m_processEventHandler;
                                        object2.sendMessage((Message)object);
                                        break block27;
                                    }
                                    n13 = n10;
                                    n12 = n11 & 0x10;
                                    if (n12 <= 0) break block28;
                                    if (n14 != 0) {
                                        l11 = ((NvVideoFrame)object4).streamTime;
                                        n14 = 0;
                                    }
                                    l13 = ((NvVideoFrame)object4).streamTime - l11;
                                    NvAndroidSurfaceFileWriter.access$902(nvAndroidSurfaceFileWriter$5.this$0, (NvVideoFrame)object4);
                                    object2 = nvAndroidSurfaceFileWriter$5.this$0.m_MediaMuxer;
                                    object4 = ((NvVideoFrame)object4).buffer;
                                    n16 = 1;
                                    ((Mp4v2Helper)object2).WriteAudioFrameData((ByteBuffer)object4, n16, l13);
                                    break block27;
                                }
                                n12 = n11 & 0x20;
                                if (n12 <= 0) break block29;
                                bl2 = true;
                                break block30;
                            }
                            if ((n11 &= 0x40) <= 0) break block27;
                            n10 = 1;
                            break block30;
                        }
                        n13 = n10;
                    }
                    n10 = n13;
                }
                if (!bl2 || n10 == 0) {
                    n12 = 1;
                    n13 = 0;
                    object3 = null;
                    continue;
                }
                break block22;
                break;
            }
            n13 = n10;
        }
        object2 = nvAndroidSurfaceFileWriter$5.this$0;
        object = ((NvAndroidSurfaceFileWriter)object2).m_writeCompleteObject;
        synchronized (object) {
            if (bl2 && n10 != 0) {
                object2 = "SurfaceFileWriter";
                String string2 = "run:  m_writeCompleted = true";
                Logger.e((String)object2, string2);
                object2 = nvAndroidSurfaceFileWriter$5.this$0;
                n10 = 1;
                ((NvAndroidSurfaceFileWriter)object2).m_writeCompleted = n10;
                object2 = ((NvAndroidSurfaceFileWriter)object2).m_writeCompleteObject;
                object2.notifyAll();
            }
        }
        nvAndroidSurfaceFileWriter$5.this$0.FlushWriter();
        object2 = NvAndroidSurfaceFileWriter.access$700(nvAndroidSurfaceFileWriter$5.this$0);
        if (object2 != null) {
            object2 = NvAndroidSurfaceFileWriter.access$700(nvAndroidSurfaceFileWriter$5.this$0);
            object2.finish();
        }
    }
}

