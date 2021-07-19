/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

public class TXAudioEffectManager$AudioMusicParam {
    public long endTimeMS;
    public int id;
    public boolean isShortFile;
    public int loopCount;
    public String path;
    public boolean publish;
    public long startTimeMS;

    public TXAudioEffectManager$AudioMusicParam(int n10, String string2) {
        this.path = string2;
        this.id = n10;
        this.loopCount = 0;
        this.publish = false;
        this.isShortFile = false;
        this.startTimeMS = 0L;
        this.endTimeMS = -1;
    }
}

