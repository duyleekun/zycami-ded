/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package androidx.camera.view.video;

import android.location.Location;
import androidx.camera.view.video.AutoValue_Metadata$1;
import androidx.camera.view.video.Metadata;

public final class AutoValue_Metadata
extends Metadata {
    private final Location location;

    private AutoValue_Metadata(Location location) {
        this.location = location;
    }

    public /* synthetic */ AutoValue_Metadata(Location location, AutoValue_Metadata$1 autoValue_Metadata$1) {
        this(location);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof Metadata;
        if (bl3) {
            object = (Metadata)object;
            Location location = this.location;
            object = ((Metadata)object).getLocation();
            if (location == null) {
                if (object != null) {
                    bl2 = false;
                }
            } else {
                bl2 = location.equals(object);
            }
            return bl2;
        }
        return false;
    }

    public Location getLocation() {
        return this.location;
    }

    public int hashCode() {
        int n10;
        Location location = this.location;
        if (location == null) {
            n10 = 0;
            location = null;
        } else {
            n10 = location.hashCode();
        }
        return n10 ^ 0xF4243;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Metadata{location=");
        Location location = this.location;
        stringBuilder.append(location);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

