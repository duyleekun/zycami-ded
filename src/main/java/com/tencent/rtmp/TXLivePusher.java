/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.view.Surface
 */
package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher$AudioCustomProcessListener;
import com.tencent.rtmp.TXLivePusher$ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher$ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher$OnBGMNotify;
import com.tencent.rtmp.TXLivePusher$VideoCustomProcessListener;
import com.tencent.rtmp.b;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon$ITXVideoRecordListener;

public class TXLivePusher {
    public static final int RGB_BGRA = 4;
    public static final int RGB_RGBA = 5;
    public static final int YUV_420P = 3;
    public static final int YUV_420SP = 1;
    public static final int YUV_420YpCbCr = 2;
    private b mTXTxLivePusherImpl;

    public TXLivePusher(Context context) {
        b b10;
        this.mTXTxLivePusherImpl = b10 = new b(context);
    }

    public void enableAudioVolumeEvaluation(int n10) {
        this.mTXTxLivePusherImpl.f(n10);
    }

    public TXAudioEffectManager getAudioEffectManager() {
        return TXAudioEffectManagerImpl.getAutoCacheHolder();
    }

    public TXBeautyManager getBeautyManager() {
        return this.mTXTxLivePusherImpl.r();
    }

    public TXLivePushConfig getConfig() {
        return this.mTXTxLivePusherImpl.i();
    }

    public int getMaxZoom() {
        return this.mTXTxLivePusherImpl.q();
    }

    public int getMusicDuration(String string2) {
        return this.mTXTxLivePusherImpl.c(string2);
    }

    public boolean isPushing() {
        return this.mTXTxLivePusherImpl.m();
    }

    public void onLogRecord(String string2) {
        this.mTXTxLivePusherImpl.e(string2);
    }

    public boolean pauseBGM() {
        return this.mTXTxLivePusherImpl.u();
    }

    public void pausePusher() {
        this.mTXTxLivePusherImpl.k();
    }

    public boolean playBGM(String string2) {
        return this.mTXTxLivePusherImpl.b(string2);
    }

    public boolean resumeBGM() {
        return this.mTXTxLivePusherImpl.v();
    }

    public void resumePusher() {
        this.mTXTxLivePusherImpl.l();
    }

    public void sendCustomPCMData(byte[] byArray) {
        this.mTXTxLivePusherImpl.a(byArray);
    }

    public int sendCustomVideoData(byte[] byArray, int n10, int n11, int n12) {
        return this.mTXTxLivePusherImpl.a(byArray, n10, n11, n12);
    }

    public int sendCustomVideoTexture(int n10, int n11, int n12) {
        return this.mTXTxLivePusherImpl.b(n10, n11, n12);
    }

    public void sendMessage(byte[] byArray) {
        this.mTXTxLivePusherImpl.c(byArray);
    }

    public boolean sendMessageEx(byte[] byArray) {
        return this.mTXTxLivePusherImpl.b(byArray);
    }

    public void setAudioProcessListener(TXLivePusher$AudioCustomProcessListener tXLivePusher$AudioCustomProcessListener) {
        this.mTXTxLivePusherImpl.a(tXLivePusher$AudioCustomProcessListener);
    }

    public void setAudioVolumeEvaluationListener(TXLivePusher$ITXAudioVolumeEvaluationListener tXLivePusher$ITXAudioVolumeEvaluationListener) {
        this.mTXTxLivePusherImpl.a(tXLivePusher$ITXAudioVolumeEvaluationListener);
    }

    public void setBGMNofify(TXLivePusher$OnBGMNotify tXLivePusher$OnBGMNotify) {
        this.mTXTxLivePusherImpl.a(tXLivePusher$OnBGMNotify);
    }

    public void setBGMPitch(float f10) {
        this.mTXTxLivePusherImpl.d(f10);
    }

    public boolean setBGMPosition(int n10) {
        return this.mTXTxLivePusherImpl.c(n10);
    }

    public boolean setBGMVolume(float f10) {
        return this.mTXTxLivePusherImpl.b(f10);
    }

    public boolean setBeautyFilter(int n10, int n11, int n12, int n13) {
        return this.mTXTxLivePusherImpl.a(n10, n11, n12, n13);
    }

    public void setChinLevel(int n10) {
        TXBeautyManager tXBeautyManager = this.getBeautyManager();
        float f10 = n10;
        tXBeautyManager.setChinLevel(f10);
    }

    public void setConfig(TXLivePushConfig tXLivePushConfig) {
        this.mTXTxLivePusherImpl.a(tXLivePushConfig);
    }

    public void setExposureCompensation(float f10) {
        this.mTXTxLivePusherImpl.a(f10);
    }

    public void setEyeScaleLevel(int n10) {
        TXBeautyManager tXBeautyManager = this.getBeautyManager();
        float f10 = n10;
        tXBeautyManager.setEyeScaleLevel(f10);
    }

    public void setFaceShortLevel(int n10) {
        TXBeautyManager tXBeautyManager = this.getBeautyManager();
        float f10 = n10;
        tXBeautyManager.setFaceShortLevel(f10);
    }

    public void setFaceSlimLevel(int n10) {
        TXBeautyManager tXBeautyManager = this.getBeautyManager();
        float f10 = n10;
        tXBeautyManager.setFaceSlimLevel(f10);
    }

    public void setFaceVLevel(int n10) {
        TXBeautyManager tXBeautyManager = this.getBeautyManager();
        float f10 = n10;
        tXBeautyManager.setFaceVLevel(f10);
    }

    public void setFilter(Bitmap bitmap) {
        this.getBeautyManager().setFilter(bitmap);
    }

    public void setFocusPosition(float f10, float f11) {
        this.mTXTxLivePusherImpl.a(f10, f11);
    }

    public boolean setGreenScreenFile(String string2) {
        this.getBeautyManager().setGreenScreenFile(string2);
        return true;
    }

    public boolean setMicVolume(float f10) {
        return this.mTXTxLivePusherImpl.c(f10);
    }

    public boolean setMirror(boolean bl2) {
        return this.mTXTxLivePusherImpl.c(bl2);
    }

    public void setMotionMute(boolean bl2) {
        this.getBeautyManager().setMotionMute(bl2);
    }

    public void setMotionTmpl(String string2) {
        this.getBeautyManager().setMotionTmpl(string2);
    }

    public void setMute(boolean bl2) {
        this.mTXTxLivePusherImpl.e(bl2);
    }

    public void setNoseSlimLevel(int n10) {
        TXBeautyManager tXBeautyManager = this.getBeautyManager();
        float f10 = n10;
        tXBeautyManager.setNoseSlimLevel(f10);
    }

    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        this.mTXTxLivePusherImpl.a(iTXLivePushListener);
    }

    public void setRenderRotation(int n10) {
        this.mTXTxLivePusherImpl.a(n10);
    }

    public void setReverb(int n10) {
        this.mTXTxLivePusherImpl.d(n10);
    }

    public void setSpecialRatio(float f10) {
        this.getBeautyManager().setFilterStrength(f10);
    }

    public void setSurface(Surface surface) {
        this.mTXTxLivePusherImpl.a(surface);
    }

    public void setSurfaceSize(int n10, int n11) {
        this.mTXTxLivePusherImpl.a(n10, n11);
    }

    public void setVideoProcessListener(TXLivePusher$VideoCustomProcessListener tXLivePusher$VideoCustomProcessListener) {
        this.mTXTxLivePusherImpl.a(tXLivePusher$VideoCustomProcessListener);
    }

    public void setVideoQuality(int n10, boolean bl2, boolean bl3) {
        this.mTXTxLivePusherImpl.a(n10, bl2, bl3);
    }

    public void setVideoRecordListener(TXRecordCommon$ITXVideoRecordListener tXRecordCommon$ITXVideoRecordListener) {
        this.mTXTxLivePusherImpl.a(tXRecordCommon$ITXVideoRecordListener);
    }

    public void setVoiceChangerType(int n10) {
        this.mTXTxLivePusherImpl.e(n10);
    }

    public boolean setZoom(int n10) {
        return this.mTXTxLivePusherImpl.b(n10);
    }

    public void snapshot(TXLivePusher$ITXSnapshotListener tXLivePusher$ITXSnapshotListener) {
        this.mTXTxLivePusherImpl.a(tXLivePusher$ITXSnapshotListener);
    }

    public void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        this.mTXTxLivePusherImpl.a(tXCloudVideoView);
    }

    public int startPusher(String string2) {
        return this.mTXTxLivePusherImpl.a(string2);
    }

    public int startRecord(String string2) {
        return this.mTXTxLivePusherImpl.d(string2);
    }

    public void startScreenCapture() {
        this.mTXTxLivePusherImpl.n();
    }

    public boolean stopBGM() {
        return this.mTXTxLivePusherImpl.s();
    }

    public void stopCameraPreview(boolean bl2) {
        this.mTXTxLivePusherImpl.b(bl2);
    }

    public void stopPusher() {
        this.mTXTxLivePusherImpl.j();
    }

    public void stopRecord() {
        this.mTXTxLivePusherImpl.w();
    }

    public void stopScreenCapture() {
        this.mTXTxLivePusherImpl.o();
    }

    public void switchCamera() {
        this.mTXTxLivePusherImpl.p();
    }

    public boolean turnOnFlashLight(boolean bl2) {
        return this.mTXTxLivePusherImpl.d(bl2);
    }
}

