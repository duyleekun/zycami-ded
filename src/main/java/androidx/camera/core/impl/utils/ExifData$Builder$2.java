/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifData$Builder;
import androidx.camera.core.impl.utils.ExifTag;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ExifData$Builder$2
implements Enumeration {
    public int mIfdIndex = 0;
    public final /* synthetic */ ExifData$Builder this$0;

    public ExifData$Builder$2(ExifData$Builder exifData$Builder) {
        this.this$0 = exifData$Builder;
    }

    public boolean hasMoreElements() {
        int n10 = this.mIfdIndex;
        ExifTag[][] exifTagArray = ExifData.EXIF_TAGS;
        int n11 = exifTagArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public Map nextElement() {
        int n10;
        this.mIfdIndex = n10 = this.mIfdIndex + 1;
        HashMap hashMap = new HashMap();
        return hashMap;
    }
}

