/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzen;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class zzdo
implements zzen {
    private transient Map zzme;

    public boolean containsValue(Object object) {
        boolean bl2;
        Iterator iterator2 = this.zzcc().values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Collection collection = (Collection)iterator2.next();
            bl2 = collection.contains(object);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof zzen;
        if (bl2) {
            object = (zzen)object;
            Map map = this.zzcc();
            object = object.zzcc();
            return map.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.zzcc().hashCode();
    }

    public String toString() {
        return this.zzcc().toString();
    }

    public Map zzcc() {
        Map map = this.zzme;
        if (map == null) {
            this.zzme = map = this.zzcd();
        }
        return map;
    }

    public abstract Map zzcd();
}

