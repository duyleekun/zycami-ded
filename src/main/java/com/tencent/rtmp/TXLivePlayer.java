/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Surface
 */
package com.tencent.rtmp;

import android.content.Context;
import android.view.Surface;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer$ITXAudioRawDataListener;
import com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer$ITXLivePlayVideoRenderListener;
import com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener;
import com.tencent.rtmp.TXLivePlayer$ITXVideoRawDataListener;
import com.tencent.rtmp.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon$ITXVideoRecordListener;

public class TXLivePlayer {
    public static final int PLAY_TYPE_LIVE_FLV = 1;
    public static final int PLAY_TYPE_LIVE_RTMP = 0;
    public static final int PLAY_TYPE_LIVE_RTMP_ACC = 5;
    public static final int PLAY_TYPE_LOCAL_VIDEO = 6;
    public static final int PLAY_TYPE_VOD_FLV = 2;
    public static final int PLAY_TYPE_VOD_HLS = 3;
    public static final int PLAY_TYPE_VOD_MP4 = 4;
    public static final String TAG = "TXLivePlayer";
    private a mTXLivePlayerImpl;

    public TXLivePlayer(Context context) {
        a a10;
        this.mTXLivePlayerImpl = a10 = new a(context);
    }

    public boolean addVideoRawData(byte[] byArray) {
        return this.mTXLivePlayerImpl.a(byArray);
    }

    public void callExperimentalAPI(String string2) {
        this.mTXLivePlayerImpl.b(string2);
    }

    public void enableAudioVolumeEvaluation(int n10) {
        this.mTXLivePlayerImpl.e(n10);
    }

    public boolean enableHardwareDecode(boolean bl2) {
        return this.mTXLivePlayerImpl.b(bl2);
    }

    public boolean isPlaying() {
        return this.mTXLivePlayerImpl.a();
    }

    public void pause() {
        this.mTXLivePlayerImpl.b();
    }

    public int prepareLiveSeek(String string2, int n10) {
        return this.mTXLivePlayerImpl.b(string2, n10);
    }

    public void resume() {
        this.mTXLivePlayerImpl.c();
    }

    public int resumeLive() {
        return this.mTXLivePlayerImpl.e();
    }

    public void seek(int n10) {
        this.mTXLivePlayerImpl.g(n10);
    }

    public void setAudioRawDataListener(TXLivePlayer$ITXAudioRawDataListener tXLivePlayer$ITXAudioRawDataListener) {
        this.mTXLivePlayerImpl.a(tXLivePlayer$ITXAudioRawDataListener);
    }

    public void setAudioRoute(int n10) {
        this.mTXLivePlayerImpl.d(n10);
    }

    public void setAudioVolumeEvaluationListener(TXLivePlayer$ITXAudioVolumeEvaluationListener tXLivePlayer$ITXAudioVolumeEvaluationListener) {
        this.mTXLivePlayerImpl.a(tXLivePlayer$ITXAudioVolumeEvaluationListener);
    }

    public void setAutoPlay(boolean bl2) {
        this.mTXLivePlayerImpl.d(bl2);
    }

    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        this.mTXLivePlayerImpl.a(tXLivePlayConfig);
    }

    public void setMute(boolean bl2) {
        this.mTXLivePlayerImpl.c(bl2);
    }

    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        this.mTXLivePlayerImpl.a(iTXLivePlayListener);
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        this.mTXLivePlayerImpl.a(tXCloudVideoView);
    }

    public void setRate(float f10) {
        this.mTXLivePlayerImpl.a(f10);
    }

    public void setRenderMode(int n10) {
        this.mTXLivePlayerImpl.a(n10);
    }

    public void setRenderRotation(int n10) {
        this.mTXLivePlayerImpl.b(n10);
    }

    public void setSurface(Surface surface) {
        this.mTXLivePlayerImpl.a(surface);
    }

    public void setSurfaceSize(int n10, int n11) {
        this.mTXLivePlayerImpl.a(n10, n11);
    }

    public void setVideoRawDataListener(TXLivePlayer$ITXVideoRawDataListener tXLivePlayer$ITXVideoRawDataListener) {
        this.mTXLivePlayerImpl.a(tXLivePlayer$ITXVideoRawDataListener);
    }

    public void setVideoRecordListener(TXRecordCommon$ITXVideoRecordListener tXRecordCommon$ITXVideoRecordListener) {
        this.mTXLivePlayerImpl.a(tXRecordCommon$ITXVideoRecordListener);
    }

    public int setVideoRenderListener(TXLivePlayer$ITXLivePlayVideoRenderListener tXLivePlayer$ITXLivePlayVideoRenderListener, Object object) {
        return this.mTXLivePlayerImpl.a(tXLivePlayer$ITXLivePlayVideoRenderListener, object);
    }

    public void setVolume(int n10) {
        this.mTXLivePlayerImpl.c(n10);
    }

    public void snapshot(TXLivePlayer$ITXSnapshotListener tXLivePlayer$ITXSnapshotListener) {
        this.mTXLivePlayerImpl.a(tXLivePlayer$ITXSnapshotListener);
    }

    public int startPlay(String string2, int n10) {
        return this.mTXLivePlayerImpl.a(string2, n10);
    }

    public int startRecord(int n10) {
        return this.mTXLivePlayerImpl.f(n10);
    }

    public int stopPlay(boolean bl2) {
        return this.mTXLivePlayerImpl.a(bl2);
    }

    public int stopRecord() {
        return this.mTXLivePlayerImpl.d();
    }

    public int switchStream(String string2) {
        return this.mTXLivePlayerImpl.a(string2);
    }
}

