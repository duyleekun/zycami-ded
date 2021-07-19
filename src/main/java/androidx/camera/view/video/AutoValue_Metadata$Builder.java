/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package androidx.camera.view.video;

import android.location.Location;
import androidx.camera.view.video.AutoValue_Metadata;
import androidx.camera.view.video.Metadata;
import androidx.camera.view.video.Metadata$Builder;

public final class AutoValue_Metadata$Builder
extends Metadata$Builder {
    private Location location;

    public Metadata build() {
        Location location = this.location;
        AutoValue_Metadata autoValue_Metadata = new AutoValue_Metadata(location, null);
        return autoValue_Metadata;
    }

    public Metadata$Builder setLocation(Location location) {
        this.location = location;
        return this;
    }
}

