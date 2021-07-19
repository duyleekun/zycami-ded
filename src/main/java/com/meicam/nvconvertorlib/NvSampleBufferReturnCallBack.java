/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.nvconvertorlib;

import com.meicam.nvconvertorlib.NvVideoFrame;

public interface NvSampleBufferReturnCallBack {
    public void finish();

    public void returnToPool(NvVideoFrame var1);
}

