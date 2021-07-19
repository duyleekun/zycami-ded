/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.face;

import androidx.lifecycle.LifecycleObserver;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import java.io.Closeable;

public interface FaceDetector
extends LifecycleObserver,
Closeable {
    public void close();

    public Task process(InputImage var1);
}

