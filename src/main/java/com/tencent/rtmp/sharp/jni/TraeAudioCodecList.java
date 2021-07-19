/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.sharp.jni;

import com.tencent.rtmp.sharp.jni.AudioDecoder;
import com.tencent.rtmp.sharp.jni.TraeAudioCodecList$CodecInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioCodecList {
    private ArrayList _sessionInfoList;
    private ReentrantLock mLock;

    public TraeAudioCodecList() {
        Serializable serializable;
        this._sessionInfoList = serializable = new Serializable();
        this.mLock = serializable;
    }

    public TraeAudioCodecList$CodecInfo add(long l10) {
        TraeAudioCodecList$CodecInfo traeAudioCodecList$CodecInfo = this.find(l10);
        if (traeAudioCodecList$CodecInfo != null) {
            return traeAudioCodecList$CodecInfo;
        }
        traeAudioCodecList$CodecInfo = new TraeAudioCodecList$CodecInfo(this);
        traeAudioCodecList$CodecInfo.sessionId = l10;
        Object object = new AudioDecoder();
        traeAudioCodecList$CodecInfo.audioDecoder = object;
        object = new byte[3840];
        traeAudioCodecList$CodecInfo._tempBufdec = (byte[])object;
        this.mLock.lock();
        this._sessionInfoList.add(traeAudioCodecList$CodecInfo);
        this.mLock.unlock();
        return this.find(l10);
    }

    public TraeAudioCodecList$CodecInfo find(long l10) {
        Object object;
        block2: {
            int n10;
            this.mLock.lock();
            for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this._sessionInfoList)).size()); ++i10) {
                object = (TraeAudioCodecList$CodecInfo)this._sessionInfoList.get(i10);
                long l11 = ((TraeAudioCodecList$CodecInfo)object).sessionId;
                long l12 = l11 - l10;
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 != false) {
                    continue;
                }
                break block2;
            }
            n10 = 0;
            object = null;
        }
        this.mLock.unlock();
        return object;
    }

    public void remove(long l10) {
        Object object;
        int n10;
        this.mLock.lock();
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this._sessionInfoList)).size()); ++i10) {
            object = (TraeAudioCodecList$CodecInfo)this._sessionInfoList.get(i10);
            long l11 = ((TraeAudioCodecList$CodecInfo)object).sessionId;
            long l12 = l11 - l10;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) continue;
            ArrayList arrayList = this._sessionInfoList;
            arrayList.remove(i10);
            break;
        }
        this.mLock.unlock();
    }
}

