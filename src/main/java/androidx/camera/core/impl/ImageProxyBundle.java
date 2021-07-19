/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public interface ImageProxyBundle {
    public List getCaptureIds();

    public ListenableFuture getImageProxy(int var1);
}

