/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package androidx.camera.view.video;

import android.location.Location;
import androidx.camera.view.video.AutoValue_Metadata$Builder;
import androidx.camera.view.video.Metadata$Builder;

public abstract class Metadata {
    public static Metadata$Builder builder() {
        AutoValue_Metadata$Builder autoValue_Metadata$Builder = new AutoValue_Metadata$Builder();
        return autoValue_Metadata$Builder;
    }

    public abstract Location getLocation();
}

