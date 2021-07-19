/*
 * Decompiled with CFR 0.151.
 */
package com.cdv.io;

public class NvAndroidMediaFileInfo$MediaInfo {
    public long audioStreamDurationUs;
    public int channelCount;
    public int colorTransfer;
    public int frameRate;
    public boolean hasAudioStream;
    public boolean hasVideoStream = false;
    public int height;
    public String mime;
    public int rotation;
    public int sampleRate;
    public long videoStreamDurationUs;
    public int width;

    public NvAndroidMediaFileInfo$MediaInfo() {
        long l10;
        this.videoStreamDurationUs = l10 = 0L;
        this.height = 0;
        this.width = 0;
        this.rotation = 0;
        this.frameRate = 0;
        this.hasAudioStream = false;
        this.audioStreamDurationUs = l10;
        this.channelCount = 0;
        this.sampleRate = 0;
        this.colorTransfer = 3;
    }
}

