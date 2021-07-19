/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.util.download;

import com.zhiyun.editortemplate.util.DownloadState;
import java.io.Serializable;
import java.util.Objects;

public class DownloadEvent
implements Serializable {
    public boolean isSingleEvent;
    public DownloadState mDownloadState;
    public int mProgress;

    public DownloadEvent() {
    }

    public DownloadEvent(DownloadState downloadState) {
        this(downloadState, 0, false);
    }

    public DownloadEvent(DownloadState downloadState, int n10) {
        this(downloadState, n10, false);
    }

    public DownloadEvent(DownloadState downloadState, int n10, boolean bl2) {
        this.mDownloadState = downloadState;
        this.mProgress = n10;
        this.isSingleEvent = bl2;
    }

    public DownloadEvent clone() {
        DownloadState downloadState = this.mDownloadState;
        int n10 = this.mProgress;
        boolean bl2 = this.isSingleEvent;
        DownloadEvent downloadEvent = new DownloadEvent(downloadState, n10, bl2);
        return downloadEvent;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = this.getClass()) == (clazz = object.getClass())) {
            object = (DownloadEvent)object;
            int n10 = this.mProgress;
            int n11 = ((DownloadEvent)object).mProgress;
            if (n10 != n11 || (n10 = (int)(this.isSingleEvent ? 1 : 0)) != (n11 = (int)(((DownloadEvent)object).isSingleEvent ? 1 : 0)) || (object2 = this.mDownloadState) != (object = ((DownloadEvent)object).mDownloadState)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public DownloadState getDownloadState() {
        return this.mDownloadState;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int hashCode() {
        Object[] objectArray = new Object[3];
        Object object = this.mDownloadState;
        objectArray[0] = object;
        object = this.mProgress;
        objectArray[1] = object;
        object = this.isSingleEvent;
        objectArray[2] = object;
        return Objects.hash(objectArray);
    }

    public boolean isSingleEvent() {
        return this.isSingleEvent;
    }

    public void setDownloadState(DownloadState downloadState) {
        this.mDownloadState = downloadState;
    }

    public void setProgress(int n10) {
        this.mProgress = n10;
    }

    public void setSingleEvent(boolean bl2) {
        this.isSingleEvent = bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DownloadEvent{mDownloadState=");
        DownloadState downloadState = this.mDownloadState;
        stringBuilder.append((Object)downloadState);
        stringBuilder.append(", progress=");
        int bl2 = this.mProgress;
        stringBuilder.append(bl2);
        stringBuilder.append(", isSingleEvent=");
        boolean bl3 = this.isSingleEvent;
        stringBuilder.append(bl3);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

