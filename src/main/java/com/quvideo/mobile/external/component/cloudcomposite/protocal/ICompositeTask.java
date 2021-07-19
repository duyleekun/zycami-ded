/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudcomposite.protocal;

import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener$State;

public interface ICompositeTask {
    public int cancelUpload();

    public void forceMake();

    public OnCompositeListener.State getState();

    public void release();
}

