/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask;
import com.alibaba.sdk.android.oss.model.PartETag;
import java.util.Comparator;

public class BaseMultipartUploadTask$2
implements Comparator {
    public final /* synthetic */ BaseMultipartUploadTask this$0;

    public BaseMultipartUploadTask$2(BaseMultipartUploadTask baseMultipartUploadTask) {
        this.this$0 = baseMultipartUploadTask;
    }

    public int compare(PartETag partETag, PartETag partETag2) {
        int n10;
        int n11;
        int n12 = partETag.getPartNumber();
        if (n12 < (n11 = partETag2.getPartNumber())) {
            return -1;
        }
        int n13 = partETag.getPartNumber();
        if (n13 > (n10 = partETag2.getPartNumber())) {
            return 1;
        }
        return 0;
    }
}

