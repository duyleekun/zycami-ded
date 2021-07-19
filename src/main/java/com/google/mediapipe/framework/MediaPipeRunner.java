/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.mediapipe.framework;

import android.content.Context;
import com.google.mediapipe.framework.AssetCache;
import com.google.mediapipe.framework.Graph;
import com.google.mediapipe.framework.MediaPipeException;

public abstract class MediaPipeRunner
extends Graph {
    public Context context;

    public MediaPipeRunner(Context context) {
        AssetCache.create(context);
        this.context = context;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void loadBinaryGraphFromAsset(String string2) {
        AssetCache assetCache;
        try {
            assetCache = AssetCache.getAssetCache();
        }
        catch (MediaPipeException mediaPipeException) {
            return;
        }
        string2 = assetCache.getAbsolutePathFromAsset(string2);
        this.loadBinaryGraph(string2);
    }

    public abstract void pause();

    public abstract void release();

    public void release(long l10) {
        this.release();
    }

    public abstract void resume();

    public abstract void start();
}

