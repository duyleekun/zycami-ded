/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.ExifData$Builder;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ExifData$Builder$3
implements Enumeration {
    public final Enumeration mMapEnumeration;
    public final /* synthetic */ ExifData$Builder this$0;

    public ExifData$Builder$3(ExifData$Builder object) {
        this.this$0 = object;
        this.mMapEnumeration = object = Collections.enumeration(((ExifData$Builder)object).mAttributes);
    }

    public boolean hasMoreElements() {
        return this.mMapEnumeration.hasMoreElements();
    }

    public Map nextElement() {
        Map map = (Map)this.mMapEnumeration.nextElement();
        HashMap hashMap = new HashMap(map);
        return hashMap;
    }
}

