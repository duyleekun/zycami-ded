/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.dnn;

import org.opencv.core.Mat;
import org.opencv.dnn.Model;
import org.opencv.dnn.Net;

public class SegmentationModel
extends Model {
    public SegmentationModel(long l10) {
        super(l10);
    }

    public SegmentationModel(String string2) {
        long l10 = SegmentationModel.SegmentationModel_2(string2);
        super(l10);
    }

    public SegmentationModel(String string2, String string3) {
        long l10 = SegmentationModel.SegmentationModel_1(string2, string3);
        super(l10);
    }

    public SegmentationModel(Net net) {
        long l10 = SegmentationModel.SegmentationModel_0(net.a);
        super(l10);
    }

    private static native long SegmentationModel_0(long var0);

    private static native long SegmentationModel_1(String var0, String var1);

    private static native long SegmentationModel_2(String var0);

    public static SegmentationModel b0(long l10) {
        SegmentationModel segmentationModel = new SegmentationModel(l10);
        return segmentationModel;
    }

    private static native void delete(long var0);

    private static native void segment_0(long var0, long var2, long var4);

    public void c0(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        SegmentationModel.segment_0(l10, l11, l12);
    }

    public void finalize() {
        SegmentationModel.delete(this.a);
    }
}

