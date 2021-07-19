/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageWriter
 *  android.os.Build$VERSION
 *  android.view.Surface
 */
package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.camera.core.internal.compat.ImageWriterCompatApi26Impl;
import androidx.camera.core.internal.compat.ImageWriterCompatApi29Impl;

public final class ImageWriterCompat {
    private ImageWriterCompat() {
    }

    public static ImageWriter newInstance(Surface object, int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 26;
        if (n12 >= n13) {
            return ImageWriterCompatApi26Impl.newInstance(object, n10, n11);
        }
        n13 = 29;
        if (n12 >= n13) {
            return ImageWriterCompatApi29Impl.newInstance(object, n10, n11);
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Unable to call newInstance(Surface, int, int) on API ");
        charSequence.append(n12);
        charSequence.append(". Version 26 or higher required.");
        charSequence = charSequence.toString();
        object = new RuntimeException((String)charSequence);
        throw object;
    }
}

