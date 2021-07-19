/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;

public class AVIMException
extends AVException {
    public int appCode;

    public AVIMException(int n10, int n11, String string2) {
        super(n10, string2);
        this.appCode = n11;
    }

    public AVIMException(int n10, AVException throwable) {
        String string2 = throwable.getMessage();
        throwable = throwable.getCause();
        super(string2, throwable);
        this.appCode = n10;
    }

    public AVIMException(int n10, String string2) {
        super(n10, string2);
    }

    public AVIMException(int n10, String string2, Throwable throwable) {
        super(string2, throwable);
        this.appCode = n10;
    }

    public AVIMException(int n10, Throwable throwable) {
        super(throwable);
        this.appCode = n10;
    }

    public AVIMException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public AVIMException(Throwable throwable) {
        super(throwable);
        boolean bl2 = throwable instanceof AVIMException;
        if (bl2) {
            int n10;
            throwable = (AVIMException)throwable;
            this.appCode = n10 = ((AVIMException)throwable).getAppCode();
        }
    }

    public static AVIMException wrapperAVException(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        boolean bl2 = throwable instanceof AVIMException;
        if (bl2) {
            return (AVIMException)throwable;
        }
        AVIMException aVIMException = new AVIMException(throwable);
        return aVIMException;
    }

    public int getAppCode() {
        return this.appCode;
    }

    public void setAppCode(int n10) {
        this.appCode = n10;
    }
}

