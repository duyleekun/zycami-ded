/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model;

import java.lang.constant.Constable;
import java.util.Objects;

public class SplashAdWatch {
    private boolean isWatched;
    private int watchId;
    private long watchTime;

    public SplashAdWatch(int n10) {
        this.watchId = n10;
    }

    public SplashAdWatch(int n10, boolean bl2, long l10) {
        this.watchId = n10;
        this.isWatched = bl2;
        this.watchTime = l10;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<?> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = this.getClass()) == (clazz = object.getClass())) {
            long l10;
            long l11;
            long l12;
            long l13;
            object = (SplashAdWatch)object;
            int n10 = this.watchId;
            int n11 = ((SplashAdWatch)object).watchId;
            if (n10 != n11 || (n10 = (int)(this.isWatched ? 1 : 0)) != (n11 = (int)(((SplashAdWatch)object).isWatched ? 1 : 0)) || (l13 = (l12 = (l11 = this.watchTime) - (l10 = ((SplashAdWatch)object).watchTime)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getWatchId() {
        return this.watchId;
    }

    public long getWatchTime() {
        return this.watchTime;
    }

    public int hashCode() {
        Object[] objectArray = new Object[3];
        Constable constable = this.watchId;
        objectArray[0] = constable;
        constable = Boolean.valueOf(this.isWatched);
        objectArray[1] = constable;
        constable = this.watchTime;
        objectArray[2] = constable;
        return Objects.hash(objectArray);
    }

    public boolean isWatched() {
        return this.isWatched;
    }

    public void setWatchId(int n10) {
        this.watchId = n10;
    }

    public void setWatchTime(long l10) {
        this.watchTime = l10;
    }

    public void setWatched(boolean bl2) {
        this.isWatched = bl2;
    }
}

