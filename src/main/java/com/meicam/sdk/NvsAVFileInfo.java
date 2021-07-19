/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsAudioStreamInfo;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsSize;
import com.meicam.sdk.NvsVideoStreamInfo;

public class NvsAVFileInfo {
    public static final int AUDIO_MAX_STREAM_COUNT = 4;
    public static final int AV_FILE_TYPE_AUDIO = 1;
    public static final int AV_FILE_TYPE_AUDIOVIDEO = 0;
    public static final int AV_FILE_TYPE_IMAGE = 2;
    public static final int AV_FILE_TYPE_UNKNOWN = 255;
    public NvsAudioStreamInfo[] m_audioStreamInfo;
    public long m_dataRate;
    public long m_duration;
    public int m_numAudioStreams;
    public int m_numVideoStreams;
    public int m_type;
    public NvsVideoStreamInfo m_videoStreamInfo;

    public NvsAVFileInfo() {
        NvsAudioStreamInfo[] nvsAudioStreamInfoArray = new NvsAudioStreamInfo[4];
        this.m_audioStreamInfo = nvsAudioStreamInfoArray;
    }

    public int getAVFileType() {
        return this.m_type;
    }

    public int getAudioStreamChannelCount(int n10) {
        int n11 = this.m_numAudioStreams;
        if (n10 < n11) {
            return this.m_audioStreamInfo[n10].channelCount;
        }
        return 0;
    }

    public boolean getAudioStreamCodecSupport(int n10) {
        int n11 = this.m_numAudioStreams;
        if (n10 < n11) {
            return this.m_audioStreamInfo[n10].codecSupported;
        }
        return false;
    }

    public int getAudioStreamCount() {
        return this.m_numAudioStreams;
    }

    public long getAudioStreamDuration(int n10) {
        int n11 = this.m_numAudioStreams;
        if (n10 < n11) {
            return this.m_audioStreamInfo[n10].duration;
        }
        return 0L;
    }

    public int getAudioStreamSampleRate(int n10) {
        int n11 = this.m_numAudioStreams;
        if (n10 < n11) {
            return this.m_audioStreamInfo[n10].sampleRate;
        }
        return 0;
    }

    public long getDataRate() {
        return this.m_dataRate;
    }

    public long getDuration() {
        return this.m_duration;
    }

    public int getVideoStreamCodecType(int n10) {
        int n11 = this.m_numVideoStreams;
        if (n10 < n11) {
            return this.m_videoStreamInfo.videoCodecType;
        }
        return 0;
    }

    public int getVideoStreamColorTranfer(int n10) {
        int n11 = this.m_numVideoStreams;
        if (n10 < n11) {
            return this.m_videoStreamInfo.colorTransfer;
        }
        return 0;
    }

    public int getVideoStreamComponentBitCount(int n10) {
        int n11 = this.m_numVideoStreams;
        if (n10 < n11) {
            return this.m_videoStreamInfo.componentBitCount;
        }
        return 8;
    }

    public int getVideoStreamCount() {
        return this.m_numVideoStreams;
    }

    public NvsSize getVideoStreamDimension(int n10) {
        NvsSize nvsSize = new NvsSize(0, 0);
        int n11 = this.m_numVideoStreams;
        if (n10 < n11) {
            NvsVideoStreamInfo nvsVideoStreamInfo = this.m_videoStreamInfo;
            nvsSize.width = n11 = nvsVideoStreamInfo.imageWidth;
            nvsSize.height = n10 = nvsVideoStreamInfo.imageHeight;
        }
        return nvsSize;
    }

    public long getVideoStreamDuration(int n10) {
        int n11 = this.m_numVideoStreams;
        if (n10 < n11) {
            return this.m_videoStreamInfo.duration;
        }
        return 0L;
    }

    public NvsRational getVideoStreamFrameRate(int n10) {
        int n11 = 1;
        NvsRational nvsRational = new NvsRational(n11, n11);
        n11 = this.m_numVideoStreams;
        if (n10 < n11) {
            NvsRational nvsRational2 = this.m_videoStreamInfo.frameRate;
            nvsRational.num = n11 = nvsRational2.num;
            nvsRational.den = n10 = nvsRational2.den;
        }
        return nvsRational;
    }

    public NvsRational getVideoStreamPixelAspectRatio(int n10) {
        int n11 = 1;
        NvsRational nvsRational = new NvsRational(n11, n11);
        n11 = this.m_numVideoStreams;
        if (n10 < n11) {
            NvsRational nvsRational2 = this.m_videoStreamInfo.pixelAspectRatio;
            nvsRational.num = n11 = nvsRational2.num;
            nvsRational.den = n10 = nvsRational2.den;
        }
        return nvsRational;
    }

    public int getVideoStreamRotation(int n10) {
        int n11 = this.m_numVideoStreams;
        if (n10 < n11) {
            return this.m_videoStreamInfo.displayRotation;
        }
        return 0;
    }

    public void setAudioStreamInfo(int n10, NvsAudioStreamInfo nvsAudioStreamInfo) {
        int n11 = this.m_numAudioStreams;
        if (n10 < n11) {
            NvsAudioStreamInfo[] nvsAudioStreamInfoArray = this.m_audioStreamInfo;
            nvsAudioStreamInfoArray[n10] = nvsAudioStreamInfo;
        }
    }
}

