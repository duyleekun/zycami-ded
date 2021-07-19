/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.media.Image
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy$PlaneProxy;

public interface ImageProxy
extends AutoCloseable {
    public void close();

    public Rect getCropRect();

    public int getFormat();

    public int getHeight();

    public Image getImage();

    public ImageInfo getImageInfo();

    public ImageProxy$PlaneProxy[] getPlanes();

    public int getWidth();

    public void setCropRect(Rect var1);
}

