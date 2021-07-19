/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import com.tencent.rtmp.sharp.jni.TraeAudioSession;
import com.tencent.rtmp.sharp.jni.TraeAudioSessionHost$SessionInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost {
    private ArrayList _sessionInfoList;
    private ReentrantLock mLock;

    public TraeAudioSessionHost() {
        Serializable serializable;
        this._sessionInfoList = serializable = new Serializable();
        this.mLock = serializable;
    }

    public void add(TraeAudioSession traeAudioSession, long l10, Context object) {
        object = this.find(l10);
        if (object != null) {
            return;
        }
        object = new TraeAudioSessionHost$SessionInfo(this);
        object.sessionId = l10;
        object._traeAs = traeAudioSession;
        this.mLock.lock();
        this._sessionInfoList.add(object);
        this.mLock.unlock();
    }

    public TraeAudioSessionHost$SessionInfo find(long l10) {
        Object object;
        block2: {
            int n10;
            this.mLock.lock();
            for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this._sessionInfoList)).size()); ++i10) {
                object = (TraeAudioSessionHost$SessionInfo)this._sessionInfoList.get(i10);
                long l11 = ((TraeAudioSessionHost$SessionInfo)object).sessionId;
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
            object = (TraeAudioSessionHost$SessionInfo)this._sessionInfoList.get(i10);
            long l11 = ((TraeAudioSessionHost$SessionInfo)object).sessionId;
            long l12 = l11 - l10;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) continue;
            ArrayList arrayList = this._sessionInfoList;
            arrayList.remove(i10);
            break;
        }
        this.mLock.unlock();
    }

    public void sendToAudioSessionMessage(Intent intent) {
        Object object;
        int n10;
        this.mLock.lock();
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this._sessionInfoList)).size()); ++i10) {
            object = ((TraeAudioSessionHost$SessionInfo)this._sessionInfoList.get((int)i10))._traeAs;
            ((TraeAudioSession)((Object)object)).onReceiveCallback(intent);
        }
        this.mLock.unlock();
    }
}

