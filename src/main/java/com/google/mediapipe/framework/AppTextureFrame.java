/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.framework;

import com.google.mediapipe.framework.GlSyncToken;
import com.google.mediapipe.framework.TextureFrame;

public class AppTextureFrame
implements TextureFrame {
    private int height;
    private boolean inUse = false;
    private boolean legacyInUse = false;
    private GlSyncToken releaseSyncToken = null;
    private int textureName;
    private long timestamp = Long.MIN_VALUE;
    private int width;

    public AppTextureFrame(int n10, int n11, int n12) {
        this.textureName = n10;
        this.width = n11;
        this.height = n12;
    }

    public void finalize() {
        GlSyncToken glSyncToken = this.releaseSyncToken;
        if (glSyncToken != null) {
            glSyncToken.release();
            glSyncToken = null;
            this.releaseSyncToken = null;
        }
    }

    public int getHeight() {
        return this.height;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean getInUse() {
        synchronized (this) {
            return this.legacyInUse;
        }
    }

    public int getTextureName() {
        return this.textureName;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getWidth() {
        return this.width;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        synchronized (this) {
            Object var1_1 = null;
            this.inUse = false;
            this.legacyInUse = false;
            this.notifyAll();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release(GlSyncToken glSyncToken) {
        synchronized (this) {
            GlSyncToken glSyncToken2 = this.releaseSyncToken;
            if (glSyncToken2 != null) {
                glSyncToken2.release();
                glSyncToken2 = null;
                this.releaseSyncToken = null;
            }
            this.releaseSyncToken = glSyncToken;
            glSyncToken = null;
            this.legacyInUse = false;
            this.notifyAll();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setInUse() {
        synchronized (this) {
            boolean bl2;
            GlSyncToken glSyncToken = this.releaseSyncToken;
            if (glSyncToken != null) {
                glSyncToken.release();
                bl2 = false;
                glSyncToken = null;
                this.releaseSyncToken = null;
            }
            this.inUse = bl2 = true;
            this.legacyInUse = bl2;
            return;
        }
    }

    public void setTimestamp(long l10) {
        this.timestamp = l10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void waitUntilReleased() {
        synchronized (this) {
            GlSyncToken glSyncToken;
            boolean bl2;
            while ((bl2 = this.inUse) && (glSyncToken = this.releaseSyncToken) == null) {
                this.wait();
            }
            glSyncToken = this.releaseSyncToken;
            if (glSyncToken != null) {
                glSyncToken.waitOnCpu();
                glSyncToken = this.releaseSyncToken;
                glSyncToken.release();
                bl2 = false;
                glSyncToken = null;
                this.inUse = false;
                bl2 = false;
                glSyncToken = null;
                this.releaseSyncToken = null;
            }
            return;
        }
    }
}

