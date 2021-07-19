/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package com.zhiyun.nvseditor.data;

import android.util.Size;
import d.v.h.f.a;
import java.util.List;

public class NvsTimelineData {
    private int mAspectRadio;
    private boolean mGlobalFilterEnable;
    private boolean mGlobalFrameEffectEnable;
    private a mGlobalFrameEffectInfo;
    private boolean mGlobalMusicMute;
    private float mGlobalMusicVolume;
    private boolean mGlobalMusicVolumeEnable;
    private boolean mGlobalRecordMute;
    private float mGlobalRecordVolume;
    private boolean mGlobalRecordVolumeEnable;
    private int mGlobalRotationMode;
    private boolean mGlobalRotationModeEnable;
    private double mGlobalSpeed;
    private boolean mGlobalSpeedEnable;
    private boolean mGlobalVideoMute;
    private float mGlobalVideoVolume;
    private boolean mGlobalVideoVolumeEnable;
    private int mGlobalZoomMode;
    private boolean mGlobalZoomModeEnable;
    private List mMediaInfoList;
    private List mMusicInfoList;
    private List mPasteInfoList;
    private List mRecordInfoList;
    private Size mResolutionSize;
    private List mTextInfoList;
    private String mWaterMarkPath;

    public NvsTimelineData() {
        Cloneable cloneable;
        float f10;
        this.mGlobalVideoVolume = f10 = 1.0f;
        this.mGlobalMusicVolume = f10;
        this.mGlobalRecordVolume = f10;
        this.mMediaInfoList = cloneable = new Cloneable();
        this.mMusicInfoList = cloneable = new Cloneable();
        this.mRecordInfoList = cloneable = new Cloneable();
        this.mPasteInfoList = cloneable = new Cloneable();
        this.mTextInfoList = cloneable = new Cloneable();
        this.mGlobalFrameEffectInfo = cloneable;
    }

    public int getAspectRadio() {
        return this.mAspectRadio;
    }

    public a getGlobalFrameEffectInfo() {
        return this.mGlobalFrameEffectInfo;
    }

    public float getGlobalMusicVolume() {
        return this.mGlobalMusicVolume;
    }

    public float getGlobalRecordVolume() {
        return this.mGlobalRecordVolume;
    }

    public int getGlobalRotationMode() {
        return this.mGlobalRotationMode;
    }

    public double getGlobalSpeed() {
        return this.mGlobalSpeed;
    }

    public float getGlobalVideoVolume() {
        return this.mGlobalVideoVolume;
    }

    public int getGlobalZoomMode() {
        return this.mGlobalZoomMode;
    }

    public List getMediaInfoList() {
        return this.mMediaInfoList;
    }

    public List getMusicInfoList() {
        return this.mMusicInfoList;
    }

    public List getPasteInfoList() {
        return this.mPasteInfoList;
    }

    public List getRecordInfoList() {
        return this.mRecordInfoList;
    }

    public Size getResolutionSize() {
        return this.mResolutionSize;
    }

    public List getTextInfoList() {
        return this.mTextInfoList;
    }

    public String getWaterMarkPath() {
        return this.mWaterMarkPath;
    }

    public boolean isGlobalFilterEnable() {
        return this.mGlobalFilterEnable;
    }

    public boolean isGlobalFrameEffectEnable() {
        return this.mGlobalFrameEffectEnable;
    }

    public boolean isGlobalMusicMute() {
        return this.mGlobalMusicMute;
    }

    public boolean isGlobalMusicVolumeEnable() {
        return this.mGlobalMusicVolumeEnable;
    }

    public boolean isGlobalRecordMute() {
        return this.mGlobalRecordMute;
    }

    public boolean isGlobalRecordVolumeEnable() {
        return this.mGlobalRecordVolumeEnable;
    }

    public boolean isGlobalRotationModeEnable() {
        return this.mGlobalRotationModeEnable;
    }

    public boolean isGlobalSpeedEnable() {
        return this.mGlobalSpeedEnable;
    }

    public boolean isGlobalVideoMute() {
        return this.mGlobalVideoMute;
    }

    public boolean isGlobalVideoVolumeEnable() {
        return this.mGlobalVideoVolumeEnable;
    }

    public boolean isGlobalZoomModeEnable() {
        return this.mGlobalZoomModeEnable;
    }

    public NvsTimelineData setAspectRadio(int n10) {
        this.mAspectRadio = n10;
        return this;
    }

    public NvsTimelineData setGlobalFilterEnable(boolean bl2) {
        this.mGlobalFilterEnable = bl2;
        return this;
    }

    public NvsTimelineData setGlobalFrameEffectEnable(boolean bl2) {
        this.mGlobalFrameEffectEnable = bl2;
        return this;
    }

    public NvsTimelineData setGlobalFrameEffectInfo(a a10) {
        this.mGlobalFrameEffectInfo = a10;
        return this;
    }

    public NvsTimelineData setGlobalMusicMute(boolean bl2) {
        this.mGlobalMusicMute = bl2;
        return this;
    }

    public NvsTimelineData setGlobalMusicVolume(float f10) {
        this.mGlobalMusicVolume = f10;
        return this;
    }

    public NvsTimelineData setGlobalMusicVolumeEnable(boolean bl2) {
        this.mGlobalMusicVolumeEnable = bl2;
        return this;
    }

    public NvsTimelineData setGlobalRecordMute(boolean bl2) {
        this.mGlobalRecordMute = bl2;
        return this;
    }

    public NvsTimelineData setGlobalRecordVolume(float f10) {
        this.mGlobalRecordVolume = f10;
        return this;
    }

    public NvsTimelineData setGlobalRecordVolumeEnable(boolean bl2) {
        this.mGlobalRecordVolumeEnable = bl2;
        return this;
    }

    public NvsTimelineData setGlobalRotationMode(int n10) {
        this.mGlobalRotationMode = n10;
        return this;
    }

    public NvsTimelineData setGlobalRotationModeEnable(boolean bl2) {
        this.mGlobalRotationModeEnable = bl2;
        return this;
    }

    public NvsTimelineData setGlobalSpeed(double d10) {
        this.mGlobalSpeed = d10;
        return this;
    }

    public NvsTimelineData setGlobalSpeedEnable(boolean bl2) {
        this.mGlobalSpeedEnable = bl2;
        return this;
    }

    public NvsTimelineData setGlobalVideoMute(boolean bl2) {
        this.mGlobalVideoMute = bl2;
        return this;
    }

    public NvsTimelineData setGlobalVideoVolume(float f10) {
        this.mGlobalVideoVolume = f10;
        return this;
    }

    public NvsTimelineData setGlobalVideoVolumeEnable(boolean bl2) {
        this.mGlobalVideoVolumeEnable = bl2;
        return this;
    }

    public NvsTimelineData setGlobalZoomMode(int n10) {
        this.mGlobalZoomMode = n10;
        return this;
    }

    public NvsTimelineData setGlobalZoomModeEnable(boolean bl2) {
        this.mGlobalZoomModeEnable = bl2;
        return this;
    }

    public NvsTimelineData setMediaInfoList(List list) {
        this.mMediaInfoList = list;
        return this;
    }

    public NvsTimelineData setMusicInfoList(List list) {
        this.mMusicInfoList = list;
        return this;
    }

    public NvsTimelineData setPasteInfoList(List list) {
        this.mPasteInfoList = list;
        return this;
    }

    public NvsTimelineData setRecordInfoList(List list) {
        this.mRecordInfoList = list;
        return this;
    }

    public NvsTimelineData setResolutionSize(Size size) {
        this.mResolutionSize = size;
        return this;
    }

    public NvsTimelineData setTextInfoList(List list) {
        this.mTextInfoList = list;
        return this;
    }

    public NvsTimelineData setWaterMarkPath(String string2) {
        this.mWaterMarkPath = string2;
        return this;
    }
}

