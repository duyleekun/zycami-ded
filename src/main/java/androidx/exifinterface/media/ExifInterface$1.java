/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaDataSource
 */
package androidx.exifinterface.media;

import android.media.MediaDataSource;
import androidx.exifinterface.media.ExifInterface;
import androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream;
import java.io.IOException;

public class ExifInterface$1
extends MediaDataSource {
    public long mPosition;
    public final /* synthetic */ ExifInterface this$0;
    public final /* synthetic */ ExifInterface$ByteOrderedDataInputStream val$in;

    public ExifInterface$1(ExifInterface exifInterface, ExifInterface$ByteOrderedDataInputStream byteOrderedDataInputStream) {
        this.this$0 = exifInterface;
        this.val$in = byteOrderedDataInputStream;
    }

    public void close() {
    }

    public long getSize() {
        return -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int readAt(long l10, byte[] byArray, int n10, int n11) {
        if (n11 == 0) {
            return 0;
        }
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n12 = -1;
        if (l12 < 0) {
            return n12;
        }
        try {
            ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream;
            int n13;
            long l13 = this.mPosition;
            l12 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
            if (l12 != false) {
                ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream2;
                long l14;
                long l15;
                Object object = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
                if (object >= 0 && (l15 = (l14 = l10 - (l13 += (l11 = (long)(exifInterface$ByteOrderedDataInputStream2 = this.val$in).available()))) == 0L ? 0 : (l14 < 0L ? -1 : 1)) >= 0) {
                    return n12;
                }
                exifInterface$ByteOrderedDataInputStream2 = this.val$in;
                exifInterface$ByteOrderedDataInputStream2.seek(l10);
                this.mPosition = l10;
            }
            if (n11 > (n13 = (exifInterface$ByteOrderedDataInputStream = this.val$in).available())) {
                exifInterface$ByteOrderedDataInputStream = this.val$in;
                n11 = exifInterface$ByteOrderedDataInputStream.available();
            }
            if ((n13 = (exifInterface$ByteOrderedDataInputStream = this.val$in).read(byArray, n10, n11)) >= 0) {
                long l16 = this.mPosition;
                long l17 = n13;
                this.mPosition = l16 += l17;
                return n13;
            }
        }
        catch (IOException iOException) {}
        this.mPosition = -1;
        return n12;
    }
}

