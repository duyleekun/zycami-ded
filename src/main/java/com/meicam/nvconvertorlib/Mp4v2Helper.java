/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.nvconvertorlib;

import com.meicam.nvconvertorlib.NvVideoFrame;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class Mp4v2Helper {
    public static final int NvBuffeFlug_Audio_Config_Data = 2;
    public static final int NvBuffeFlug_Audio_EOS = 64;
    public static final int NvBuffeFlug_Audio_Sample_Data = 16;
    public static final int NvBuffeFlug_SYNC_FRAME = 1;
    public static final int NvBuffeFlug_Video_Config_Data = 4;
    public static final int NvBuffeFlug_Video_EOS = 32;
    public static final int NvBuffeFlug_Video_Sample_Data = 8;
    private long m_Mp4v2handler = 0L;
    private NvVideoFrame m_MpLastSampleBuffer = null;

    static {
        System.loadLibrary("NvConvertNW");
    }

    public Mp4v2Helper() {
        long l10;
        this.m_Mp4v2handler = l10 = this.CreateHandler();
    }

    private native void AddTrack(long var1, ByteBuffer var3, int var4, int var5, int var6, int var7, float var8, int var9, int var10);

    private native long CloseFile(long var1);

    private native long CreateHandler();

    private native boolean OpenFile(long var1, String var3);

    private native void RealeaseHandler(long var1);

    private native void WriteSampleData(long var1, ByteBuffer var3, int var4, int var5, long var6, int var8, boolean var9);

    public void AddAudioTrack(ByteBuffer byteBuffer, int n10, int n11) {
        long l10 = this.m_Mp4v2handler;
        this.AddTrack(l10, byteBuffer, n10, 1, 0, 0, 0.0f, 0, n11);
    }

    public void AddVideoTrack(ByteBuffer byteBuffer, int n10, int n11, int n12, float f10, int n13, boolean bl2) {
        if (bl2) {
            long l10 = this.m_Mp4v2handler;
            int n14 = 2;
            this.AddTrack(l10, byteBuffer, n10, n14, n11, n12, f10, n13, 0);
        } else {
            long l11 = this.m_Mp4v2handler;
            int n15 = 3;
            this.AddTrack(l11, byteBuffer, n10, n15, n11, n12, f10, n13, 0);
        }
    }

    public void CloseFile() {
        long l10 = this.m_Mp4v2handler;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        NvVideoFrame nvVideoFrame = this.m_MpLastSampleBuffer;
        if (nvVideoFrame != null) {
            int n10 = nvVideoFrame.buffer.limit();
            l11 = this.m_Mp4v2handler;
            nvVideoFrame = this.m_MpLastSampleBuffer;
            ByteBuffer byteBuffer = nvVideoFrame.buffer;
            int n11 = nvVideoFrame.bufferFlags;
            long l13 = -1;
            boolean bl2 = true;
            this.WriteSampleData(l11, byteBuffer, n11, 0, l13, n10, bl2);
        }
        l10 = this.m_Mp4v2handler;
        this.CloseFile(l10);
    }

    public boolean OpenMediaFile(String string2) {
        long l10 = this.m_Mp4v2handler;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return false;
        }
        this.m_MpLastSampleBuffer = null;
        return this.OpenFile(l10, string2);
    }

    public void WriteAudioFrameData(ByteBuffer byteBuffer, int n10, long l10) {
        int n11 = byteBuffer.limit();
        long l11 = this.m_Mp4v2handler;
        this.WriteSampleData(l11, byteBuffer, n10, 0, l10, n11, false);
    }

    public void WriteVideoFrameData(ByteBuffer byteBuffer, int n10, long l10) {
        NvVideoFrame nvVideoFrame = this.m_MpLastSampleBuffer;
        if (nvVideoFrame == null) {
            this.m_MpLastSampleBuffer = nvVideoFrame = new NvVideoFrame();
            nvVideoFrame.bufferFlags = n10;
            nvVideoFrame.streamTime = l10;
            long l11 = 0L;
            long l12 = l10 - l11;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) {
                nvVideoFrame.streamTime = l11;
            }
            nvVideoFrame.buffer = byteBuffer;
            return;
        }
        int n11 = nvVideoFrame.buffer.limit();
        nvVideoFrame = this.m_MpLastSampleBuffer;
        long l13 = nvVideoFrame.streamTime;
        long l14 = l10 - l13;
        long l15 = this.m_Mp4v2handler;
        ByteBuffer byteBuffer2 = nvVideoFrame.buffer;
        int n12 = nvVideoFrame.bufferFlags;
        this.WriteSampleData(l15, byteBuffer2, n12, 0, l14, n11, true);
        this.m_MpLastSampleBuffer = nvVideoFrame = new NvVideoFrame();
        nvVideoFrame.bufferFlags = n10;
        nvVideoFrame.streamTime = l10;
        nvVideoFrame.buffer = byteBuffer;
    }

    public void finalize() {
        long l10 = this.m_Mp4v2handler;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.RealeaseHandler(l10);
        }
        this.m_Mp4v2handler = l11;
        super.finalize();
    }

    public void writeFileTrailer(long l10) {
        Object object = this.m_MpLastSampleBuffer;
        if (object != null) {
            object = ((NvVideoFrame)object).buffer;
            int n10 = ((Buffer)object).limit();
            long l11 = -1;
            NvVideoFrame nvVideoFrame = this.m_MpLastSampleBuffer;
            long l12 = nvVideoFrame.streamTime;
            long l13 = l10 - l12;
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            long l14 = object2 > 0 ? (l10 -= l12) : l11;
            l10 = this.m_Mp4v2handler;
            ByteBuffer byteBuffer = nvVideoFrame.buffer;
            object2 = nvVideoFrame.bufferFlags;
            boolean bl2 = true;
            this.WriteSampleData(l10, byteBuffer, (int)object2, 0, l14, n10, bl2);
            this.m_MpLastSampleBuffer = null;
        }
    }
}

