/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMMessageInterval$AVIMMessageIntervalBound;

public class AVIMMessageInterval {
    public AVIMMessageInterval$AVIMMessageIntervalBound endIntervalBound;
    public AVIMMessageInterval$AVIMMessageIntervalBound startIntervalBound;

    public AVIMMessageInterval(AVIMMessageInterval$AVIMMessageIntervalBound aVIMMessageInterval$AVIMMessageIntervalBound, AVIMMessageInterval$AVIMMessageIntervalBound aVIMMessageInterval$AVIMMessageIntervalBound2) {
        this.startIntervalBound = aVIMMessageInterval$AVIMMessageIntervalBound;
        this.endIntervalBound = aVIMMessageInterval$AVIMMessageIntervalBound2;
    }

    public static AVIMMessageInterval$AVIMMessageIntervalBound createBound(String string2, long l10, boolean bl2) {
        AVIMMessageInterval$AVIMMessageIntervalBound aVIMMessageInterval$AVIMMessageIntervalBound = new AVIMMessageInterval$AVIMMessageIntervalBound(string2, l10, bl2, null);
        return aVIMMessageInterval$AVIMMessageIntervalBound;
    }
}

