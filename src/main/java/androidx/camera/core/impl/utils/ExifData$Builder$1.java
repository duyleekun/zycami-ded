/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifTag;
import java.util.Enumeration;
import java.util.HashMap;

public class ExifData$Builder$1
implements Enumeration {
    public int mIfdIndex = 0;

    public boolean hasMoreElements() {
        int n10 = this.mIfdIndex;
        ExifTag[][] exifTagArray = ExifData.EXIF_TAGS;
        int n11 = exifTagArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public HashMap nextElement() {
        int n10;
        HashMap<String, ExifTag[]> hashMap = new HashMap<String, ExifTag[]>();
        ExifTag[][] exifTagArray = ExifData.EXIF_TAGS;
        int n11 = this.mIfdIndex;
        for (ExifTag[] exifTagArray2 : exifTagArray[n11]) {
            String string2 = exifTagArray2.name;
            hashMap.put(string2, exifTagArray2);
        }
        this.mIfdIndex = n10 = this.mIfdIndex + 1;
        return hashMap;
    }
}

