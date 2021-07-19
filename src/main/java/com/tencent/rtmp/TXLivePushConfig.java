/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.a.c;
import java.util.HashMap;

public class TXLivePushConfig {
    public static final int DEFAULT_MAX_VIDEO_BITRATE = 1200;
    public static final int DEFAULT_MIN_VIDEO_BITRATE = 800;
    public int mAudioBitrate;
    public int mAudioChannels;
    public String mAudioPreProcessFuncName;
    public String mAudioPreProcessLibrary;
    public int mAudioSample = 48000;
    public boolean mAutoAdjustBitrate;
    public int mAutoAdjustStrategy;
    public int mBeautyLevel;
    public int mConnectRetryCount;
    public int mConnectRetryInterval;
    public int mCustomModeType = 0;
    public boolean mEnableAec;
    public boolean mEnableAgc;
    public boolean mEnableAns;
    public boolean mEnableAudioPreview;
    public boolean mEnableHighResolutionCapture;
    public boolean mEnableNearestIP;
    public boolean mEnablePureAudioPush;
    public boolean mEnableScreenCaptureAutoRotate;
    public boolean mEnableVideoHardEncoderMainProfile;
    public boolean mEnableZoom;
    public int mEyeScaleLevel;
    public int mFaceSlimLevel;
    public boolean mFrontCamera;
    public int mHardwareAccel;
    public int mHomeOrientation;
    public int mLocalVideoMirrorType;
    public int mMaxVideoBitrate;
    public HashMap mMetaData;
    public int mMinVideoBitrate;
    public int mPauseFlag;
    public int mPauseFps;
    public Bitmap mPauseImg;
    public int mPauseTime;
    public int mRtmpChannelType;
    public int mRuddyLevel;
    public boolean mTouchFocus;
    public int mVideoBitrate;
    public int mVideoEncodeGop;
    public boolean mVideoEncoderXMirror;
    public int mVideoFPS;
    public String mVideoPreProcessFuncName;
    public String mVideoPreProcessLibrary;
    public c mVideoResolution;
    public int mVolumeType;
    public Bitmap mWatermark;
    public float mWatermarkWidth;
    public int mWatermarkX;
    public float mWatermarkXF;
    public int mWatermarkY;
    public float mWatermarkYF;
    public int mWhiteningLevel;

    public TXLivePushConfig() {
        int n10;
        c c10;
        int n11;
        this.mAudioChannels = n11 = 1;
        this.mVideoFPS = 20;
        this.mVideoResolution = c10 = c.c;
        this.mVideoBitrate = 1200;
        this.mMaxVideoBitrate = 1500;
        this.mMinVideoBitrate = 800;
        this.mBeautyLevel = 0;
        this.mWhiteningLevel = 0;
        this.mRuddyLevel = 0;
        this.mEyeScaleLevel = 0;
        this.mFaceSlimLevel = 0;
        this.mConnectRetryCount = n10 = 3;
        this.mConnectRetryInterval = n10;
        this.mWatermarkX = 0;
        this.mWatermarkY = 0;
        this.mWatermarkXF = 0.0f;
        this.mWatermarkYF = 0.0f;
        this.mWatermarkWidth = -1.0f;
        this.mVideoEncodeGop = n10;
        this.mVideoEncoderXMirror = false;
        this.mEnableHighResolutionCapture = n11;
        this.mEnableVideoHardEncoderMainProfile = n11;
        this.mFrontCamera = n11;
        this.mAutoAdjustBitrate = false;
        this.mAutoAdjustStrategy = 0;
        this.mHardwareAccel = 2;
        this.mTouchFocus = n11;
        this.mEnableZoom = false;
        this.mHomeOrientation = n11;
        this.mPauseImg = null;
        this.mPauseTime = 300;
        this.mPauseFps = 5;
        this.mPauseFlag = n11;
        this.mEnableAec = false;
        this.mEnableAgc = false;
        this.mEnableAns = false;
        this.mEnableAudioPreview = false;
        this.mEnableScreenCaptureAutoRotate = false;
        this.mEnablePureAudioPush = false;
        this.mEnableNearestIP = n11;
        this.mVolumeType = 0;
        this.mLocalVideoMirrorType = 0;
        this.mRtmpChannelType = 0;
    }

    public void enableAEC(boolean bl2) {
        this.mEnableAec = bl2;
    }

    public void enableAGC(boolean bl2) {
        this.mEnableAgc = bl2;
    }

    public void enableANS(boolean bl2) {
        this.mEnableAns = bl2;
    }

    public void enableAudioEarMonitoring(boolean bl2) {
        this.mEnableAudioPreview = bl2;
    }

    public void enableHighResolutionCaptureMode(boolean bl2) {
        this.mEnableHighResolutionCapture = bl2;
    }

    public void enableNearestIP(boolean bl2) {
        this.mEnableNearestIP = bl2;
    }

    public void enablePureAudioPush(boolean bl2) {
        this.mEnablePureAudioPush = bl2;
    }

    public void enableScreenCaptureAutoRotate(boolean bl2) {
        this.mEnableScreenCaptureAutoRotate = bl2;
    }

    public void enableVideoHardEncoderMainProfile(boolean bl2) {
        this.mEnableVideoHardEncoderMainProfile = bl2;
    }

    public void setAudioChannels(int n10) {
        this.mAudioChannels = n10;
    }

    public void setAudioSampleRate(int n10) {
        this.mAudioSample = n10;
    }

    public void setAutoAdjustBitrate(boolean bl2) {
        this.mAutoAdjustBitrate = bl2;
    }

    public void setAutoAdjustStrategy(int n10) {
        this.mAutoAdjustStrategy = n10;
    }

    public void setBeautyFilter(int n10, int n11, int n12) {
        this.mBeautyLevel = n10;
        this.mWhiteningLevel = n11;
        this.mRuddyLevel = n12;
    }

    public void setConnectRetryCount(int n10) {
        this.mConnectRetryCount = n10;
    }

    public void setConnectRetryInterval(int n10) {
        this.mConnectRetryInterval = n10;
    }

    public void setCustomAudioPreProcessLibrary(String string2, String string3) {
        this.mAudioPreProcessLibrary = string2;
        this.mAudioPreProcessFuncName = string3;
    }

    public void setCustomModeType(int n10) {
        this.mCustomModeType = n10;
    }

    public void setCustomVideoPreProcessLibrary(String string2, String string3) {
        this.mVideoPreProcessLibrary = string2;
        this.mVideoPreProcessFuncName = string3;
    }

    public void setEnableZoom(boolean bl2) {
        this.mEnableZoom = bl2;
    }

    public void setEyeScaleLevel(int n10) {
        this.mEyeScaleLevel = n10;
    }

    public void setFaceSlimLevel(int n10) {
        this.mFaceSlimLevel = n10;
    }

    public void setFrontCamera(boolean bl2) {
        this.mFrontCamera = bl2;
    }

    public void setHardwareAcceleration(int n10) {
        int n11 = 2;
        if (n10 < 0) {
            n10 = n11;
        }
        if (n10 <= n11) {
            n11 = n10;
        }
        this.mHardwareAccel = n11;
    }

    public void setHomeOrientation(int n10) {
        this.mHomeOrientation = n10;
    }

    public void setLocalVideoMirrorType(int n10) {
        this.mLocalVideoMirrorType = n10;
    }

    public void setMaxVideoBitrate(int n10) {
        this.mMaxVideoBitrate = n10;
    }

    public void setMetaData(HashMap hashMap) {
        this.mMetaData = hashMap;
    }

    public void setMinVideoBitrate(int n10) {
        this.mMinVideoBitrate = n10;
    }

    public void setPauseFlag(int n10) {
        this.mPauseFlag = n10;
    }

    public void setPauseImg(int n10, int n11) {
        this.mPauseTime = n10;
        this.mPauseFps = n11;
    }

    public void setPauseImg(Bitmap bitmap) {
        this.mPauseImg = bitmap;
    }

    public void setRtmpChannelType(int n10) {
        this.mRtmpChannelType = n10;
    }

    public void setTouchFocus(boolean bl2) {
        this.mTouchFocus = bl2;
    }

    public void setVideoBitrate(int n10) {
        this.mVideoBitrate = n10;
    }

    public void setVideoEncodeGop(int n10) {
        this.mVideoEncodeGop = n10;
    }

    public void setVideoEncoderXMirror(boolean bl2) {
        this.mVideoEncoderXMirror = bl2;
    }

    public void setVideoFPS(int n10) {
        this.mVideoFPS = n10;
    }

    public void setVideoResolution(int n10) {
        int n11 = 30;
        if (n10 != n11) {
            n11 = 31;
            if (n10 != n11) {
                switch (n10) {
                    default: {
                        break;
                    }
                    case 19: {
                        c c10;
                        this.mVideoResolution = c10 = c.u;
                        break;
                    }
                    case 18: {
                        c c11;
                        this.mVideoResolution = c11 = c.t;
                        break;
                    }
                    case 17: {
                        c c12;
                        this.mVideoResolution = c12 = c.s;
                        break;
                    }
                    case 16: {
                        c c13;
                        this.mVideoResolution = c13 = c.r;
                        break;
                    }
                    case 15: {
                        c c14;
                        this.mVideoResolution = c14 = c.q;
                        break;
                    }
                    case 14: {
                        c c15;
                        this.mVideoResolution = c15 = c.p;
                        break;
                    }
                    case 13: {
                        c c16;
                        this.mVideoResolution = c16 = c.o;
                        break;
                    }
                    case 12: {
                        c c17;
                        this.mVideoResolution = c17 = c.n;
                        break;
                    }
                    case 11: {
                        c c18;
                        this.mVideoResolution = c18 = c.m;
                        break;
                    }
                    case 10: {
                        c c19;
                        this.mVideoResolution = c19 = c.l;
                        break;
                    }
                    case 9: {
                        c c20;
                        this.mVideoResolution = c20 = c.k;
                        break;
                    }
                    case 8: {
                        c c21;
                        this.mVideoResolution = c21 = c.j;
                        break;
                    }
                    case 7: {
                        c c22;
                        this.mVideoResolution = c22 = c.i;
                        break;
                    }
                    case 6: {
                        c c23;
                        this.mVideoResolution = c23 = c.h;
                        break;
                    }
                    case 5: {
                        c c24;
                        this.mVideoResolution = c24 = c.g;
                        break;
                    }
                    case 4: {
                        c c25;
                        this.mVideoResolution = c25 = c.f;
                        break;
                    }
                    case 3: {
                        c c26;
                        this.mVideoResolution = c26 = c.e;
                        break;
                    }
                    case 2: {
                        c c27;
                        this.mVideoResolution = c27 = c.d;
                        break;
                    }
                    case 1: {
                        c c28;
                        this.mVideoResolution = c28 = c.c;
                        break;
                    }
                    case 0: {
                        c c29;
                        this.mVideoResolution = c29 = c.b;
                        break;
                    }
                }
            } else {
                c c30;
                this.mVideoResolution = c30 = c.x;
            }
        } else {
            c c31;
            this.mVideoResolution = c31 = c.w;
        }
    }

    public void setVolumeType(int n10) {
        this.mVolumeType = n10;
    }

    public void setWatermark(Bitmap bitmap, float f10, float f11, float f12) {
        this.mWatermark = bitmap;
        this.mWatermarkXF = f10;
        this.mWatermarkYF = f11;
        this.mWatermarkWidth = f12;
    }

    public void setWatermark(Bitmap bitmap, int n10, int n11) {
        this.mWatermark = bitmap;
        this.mWatermarkX = n10;
        this.mWatermarkY = n11;
    }
}

