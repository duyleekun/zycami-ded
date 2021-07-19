/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$Span;
import java.util.Arrays;

public class StaggeredGridLayoutManager$AnchorInfo {
    public boolean mInvalidateOffsets;
    public boolean mLayoutFromEnd;
    public int mOffset;
    public int mPosition;
    public int[] mSpanReferenceLines;
    public boolean mValid;
    public final /* synthetic */ StaggeredGridLayoutManager this$0;

    public StaggeredGridLayoutManager$AnchorInfo(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.this$0 = staggeredGridLayoutManager;
        this.reset();
    }

    public void assignCoordinateFromPadding() {
        int n10 = this.mLayoutFromEnd;
        if (n10 != 0) {
            OrientationHelper orientationHelper = this.this$0.mPrimaryOrientation;
            n10 = orientationHelper.getEndAfterPadding();
        } else {
            OrientationHelper orientationHelper = this.this$0.mPrimaryOrientation;
            n10 = orientationHelper.getStartAfterPadding();
        }
        this.mOffset = n10;
    }

    public void assignCoordinateFromPadding(int n10) {
        int n11 = this.mLayoutFromEnd;
        if (n11 != 0) {
            OrientationHelper orientationHelper = this.this$0.mPrimaryOrientation;
            this.mOffset = n11 = orientationHelper.getEndAfterPadding() - n10;
        } else {
            OrientationHelper orientationHelper = this.this$0.mPrimaryOrientation;
            this.mOffset = n11 = orientationHelper.getStartAfterPadding() + n10;
        }
    }

    public void reset() {
        int n10;
        this.mPosition = n10 = -1;
        this.mOffset = -1 << -1;
        this.mLayoutFromEnd = false;
        this.mInvalidateOffsets = false;
        this.mValid = false;
        int[] nArray = this.mSpanReferenceLines;
        if (nArray != null) {
            Arrays.fill(nArray, n10);
        }
    }

    public void saveSpanReferenceLines(StaggeredGridLayoutManager$Span[] staggeredGridLayoutManager$SpanArray) {
        int n10;
        int n11 = staggeredGridLayoutManager$SpanArray.length;
        int[] nArray = this.mSpanReferenceLines;
        if (nArray == null || (n10 = nArray.length) < n11) {
            n10 = this.this$0.mSpans.length;
            this.mSpanReferenceLines = nArray = new int[n10];
        }
        nArray = null;
        for (n10 = 0; n10 < n11; ++n10) {
            int n12;
            int[] nArray2 = this.mSpanReferenceLines;
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = staggeredGridLayoutManager$SpanArray[n10];
            int n13 = -1 << -1;
            nArray2[n10] = n12 = staggeredGridLayoutManager$Span.getStartLine(n13);
        }
    }
}

