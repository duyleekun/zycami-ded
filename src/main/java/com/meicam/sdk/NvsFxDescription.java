/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsUtils;
import java.util.List;

public class NvsFxDescription {
    public long m_fxDescription = 0L;

    private native List nativeGetAllParamsInfo(long var1);

    private native String nativeGetName(long var1);

    public List getAllParamsInfo() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_fxDescription;
        return this.nativeGetAllParamsInfo(l10);
    }

    public String getName() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_fxDescription;
        return this.nativeGetName(l10);
    }

    public void setFxDescription(long l10) {
        this.m_fxDescription = l10;
    }
}

