/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 */
package com.tencent.liteav.videoencoder;

import org.json.JSONArray;

public class TXSVideoEncoderParam {
    public boolean annexb;
    public boolean appendSpsPps;
    public boolean bLimitFps;
    public boolean bMultiRef;
    public long baseFrameIndex;
    public long baseGopIndex;
    public int bitrate;
    public boolean enableBFrame;
    public boolean enableBlackList;
    public boolean enableEGL14;
    public JSONArray encFmt;
    public int encodeType;
    public int encoderMode;
    public int encoderProfile;
    public boolean forceSetBitrateMode;
    public int fps = 20;
    public boolean fullIFrame;
    public Object glContext;
    public int gop = 3;
    public int height = 0;
    public boolean realTime;
    public boolean record;
    public int streamType;
    public boolean syncOutput;
    public int width = 0;

    public TXSVideoEncoderParam() {
        long l10;
        int n10;
        this.encoderProfile = n10 = 1;
        this.encoderMode = n10;
        this.enableBFrame = false;
        this.glContext = null;
        this.realTime = false;
        this.annexb = false;
        this.appendSpsPps = n10;
        this.fullIFrame = false;
        this.syncOutput = false;
        this.enableEGL14 = false;
        this.enableBlackList = n10;
        this.record = false;
        this.baseFrameIndex = l10 = 0L;
        this.baseGopIndex = l10;
        this.streamType = 0;
        this.bMultiRef = false;
        this.bitrate = 0;
        this.bLimitFps = false;
        this.encodeType = 0;
        this.forceSetBitrateMode = false;
        this.encFmt = null;
    }
}

