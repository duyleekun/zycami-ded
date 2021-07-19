/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$State;

public class LinearLayoutManager$AnchorInfo {
    public int mCoordinate;
    public boolean mLayoutFromEnd;
    public OrientationHelper mOrientationHelper;
    public int mPosition;
    public boolean mValid;

    public LinearLayoutManager$AnchorInfo() {
        this.reset();
    }

    public void assignCoordinateFromPadding() {
        int n10 = this.mLayoutFromEnd;
        if (n10 != 0) {
            OrientationHelper orientationHelper = this.mOrientationHelper;
            n10 = orientationHelper.getEndAfterPadding();
        } else {
            OrientationHelper orientationHelper = this.mOrientationHelper;
            n10 = orientationHelper.getStartAfterPadding();
        }
        this.mCoordinate = n10;
    }

    public void assignFromView(View view, int n10) {
        int n11 = this.mLayoutFromEnd;
        if (n11 != 0) {
            int n12 = this.mOrientationHelper.getDecoratedEnd(view);
            OrientationHelper orientationHelper = this.mOrientationHelper;
            n11 = orientationHelper.getTotalSpaceChange();
            this.mCoordinate = n12 += n11;
        } else {
            int n13;
            OrientationHelper orientationHelper = this.mOrientationHelper;
            this.mCoordinate = n13 = orientationHelper.getDecoratedStart(view);
        }
        this.mPosition = n10;
    }

    public void assignFromViewAndKeepVisibleRect(View object, int n10) {
        OrientationHelper orientationHelper = this.mOrientationHelper;
        int n11 = orientationHelper.getTotalSpaceChange();
        if (n11 >= 0) {
            this.assignFromView((View)object, n10);
            return;
        }
        this.mPosition = n10;
        n10 = (int)(this.mLayoutFromEnd ? 1 : 0);
        if (n10 != 0) {
            OrientationHelper orientationHelper2 = this.mOrientationHelper;
            n10 = orientationHelper2.getEndAfterPadding() - n11;
            n11 = this.mOrientationHelper.getDecoratedEnd((View)object);
            n10 -= n11;
            orientationHelper = this.mOrientationHelper;
            this.mCoordinate = n11 = orientationHelper.getEndAfterPadding() - n10;
            if (n10 > 0) {
                int n12;
                n11 = this.mOrientationHelper.getDecoratedMeasurement((View)object);
                int n13 = this.mCoordinate - n11;
                orientationHelper = this.mOrientationHelper;
                n11 = orientationHelper.getStartAfterPadding();
                OrientationHelper orientationHelper3 = this.mOrientationHelper;
                if ((n13 -= (n11 += (n12 = Math.min(orientationHelper3.getDecoratedStart((View)object) - n11, 0)))) < 0) {
                    n12 = this.mCoordinate;
                    n11 = -n13;
                    n10 = Math.min(n10, n11);
                    this.mCoordinate = n12 += n10;
                }
            }
        } else {
            OrientationHelper orientationHelper4 = this.mOrientationHelper;
            n10 = orientationHelper4.getDecoratedStart((View)object);
            OrientationHelper orientationHelper5 = this.mOrientationHelper;
            int n14 = orientationHelper5.getStartAfterPadding();
            n14 = n10 - n14;
            this.mCoordinate = n10;
            if (n14 > 0) {
                int n15 = this.mOrientationHelper.getDecoratedMeasurement((View)object);
                n10 += n15;
                OrientationHelper orientationHelper6 = this.mOrientationHelper;
                n15 = orientationHelper6.getEndAfterPadding() - n11;
                orientationHelper = this.mOrientationHelper;
                int n16 = orientationHelper.getDecoratedEnd((View)object);
                n15 -= n16;
                object = this.mOrientationHelper;
                n16 = ((OrientationHelper)object).getEndAfterPadding();
                n11 = Math.min(0, n15);
                if ((n16 = n16 - n11 - n10) < 0) {
                    n10 = this.mCoordinate;
                    n16 = -n16;
                    n16 = Math.min(n14, n16);
                    this.mCoordinate = n10 -= n16;
                }
            }
        }
    }

    public boolean isViewValidAsAnchor(View object, RecyclerView$State recyclerView$State) {
        int n10;
        int n11;
        int n12;
        boolean n122 = ((RecyclerView$LayoutParams)((Object)(object = (RecyclerView$LayoutParams)object.getLayoutParams()))).isItemRemoved();
        if (!n122 && (n12 = ((RecyclerView$LayoutParams)((Object)object)).getViewLayoutPosition()) >= 0 && (n11 = ((RecyclerView$LayoutParams)((Object)object)).getViewLayoutPosition()) < (n10 = recyclerView$State.getItemCount())) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    public void reset() {
        this.mPosition = -1;
        this.mCoordinate = -1 << -1;
        this.mLayoutFromEnd = false;
        this.mValid = false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AnchorInfo{mPosition=");
        int bl2 = this.mPosition;
        stringBuilder.append(bl2);
        stringBuilder.append(", mCoordinate=");
        int n10 = this.mCoordinate;
        stringBuilder.append(n10);
        stringBuilder.append(", mLayoutFromEnd=");
        boolean bl3 = this.mLayoutFromEnd;
        stringBuilder.append(bl3);
        stringBuilder.append(", mValid=");
        boolean bl4 = this.mValid;
        stringBuilder.append(bl4);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

