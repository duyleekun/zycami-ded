/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.ViewBoundsCheck$BoundFlags;
import androidx.recyclerview.widget.ViewBoundsCheck$Callback;

public class ViewBoundsCheck {
    public static final int CVE_PVE_POS = 12;
    public static final int CVE_PVS_POS = 8;
    public static final int CVS_PVE_POS = 4;
    public static final int CVS_PVS_POS = 0;
    public static final int EQ = 2;
    public static final int FLAG_CVE_EQ_PVE = 8192;
    public static final int FLAG_CVE_EQ_PVS = 512;
    public static final int FLAG_CVE_GT_PVE = 4096;
    public static final int FLAG_CVE_GT_PVS = 256;
    public static final int FLAG_CVE_LT_PVE = 16384;
    public static final int FLAG_CVE_LT_PVS = 1024;
    public static final int FLAG_CVS_EQ_PVE = 32;
    public static final int FLAG_CVS_EQ_PVS = 2;
    public static final int FLAG_CVS_GT_PVE = 16;
    public static final int FLAG_CVS_GT_PVS = 1;
    public static final int FLAG_CVS_LT_PVE = 64;
    public static final int FLAG_CVS_LT_PVS = 4;
    public static final int GT = 1;
    public static final int LT = 4;
    public static final int MASK = 7;
    public ViewBoundsCheck$BoundFlags mBoundFlags;
    public final ViewBoundsCheck$Callback mCallback;

    public ViewBoundsCheck(ViewBoundsCheck$Callback object) {
        this.mCallback = object;
        this.mBoundFlags = object = new ViewBoundsCheck$BoundFlags();
    }

    public View findOneViewWithinBoundFlags(int n10, int n11, int n12, int n13) {
        ViewBoundsCheck$Callback viewBoundsCheck$Callback = this.mCallback;
        int n14 = viewBoundsCheck$Callback.getParentStart();
        ViewBoundsCheck$Callback viewBoundsCheck$Callback2 = this.mCallback;
        int n15 = viewBoundsCheck$Callback2.getParentEnd();
        int n16 = n11 > n10 ? 1 : -1;
        View view = null;
        while (n10 != n11) {
            View view2 = this.mCallback.getChildAt(n10);
            Object object = this.mCallback;
            int n17 = object.getChildStart(view2);
            ViewBoundsCheck$Callback viewBoundsCheck$Callback3 = this.mCallback;
            int n18 = viewBoundsCheck$Callback3.getChildEnd(view2);
            ViewBoundsCheck$BoundFlags viewBoundsCheck$BoundFlags = this.mBoundFlags;
            viewBoundsCheck$BoundFlags.setBounds(n14, n15, n17, n18);
            if (n12 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(n12);
                object = this.mBoundFlags;
                n17 = (int)(((ViewBoundsCheck$BoundFlags)object).boundsMatch() ? 1 : 0);
                if (n17 != 0) {
                    return view2;
                }
            }
            if (n13 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(n13);
                object = this.mBoundFlags;
                n17 = (int)(((ViewBoundsCheck$BoundFlags)object).boundsMatch() ? 1 : 0);
                if (n17 != 0) {
                    view = view2;
                }
            }
            n10 += n16;
        }
        return view;
    }

    public boolean isViewWithinBoundFlags(View view, int n10) {
        ViewBoundsCheck$BoundFlags viewBoundsCheck$BoundFlags = this.mBoundFlags;
        ViewBoundsCheck$Callback viewBoundsCheck$Callback = this.mCallback;
        int n11 = viewBoundsCheck$Callback.getParentStart();
        ViewBoundsCheck$Callback viewBoundsCheck$Callback2 = this.mCallback;
        int n12 = viewBoundsCheck$Callback2.getParentEnd();
        ViewBoundsCheck$Callback viewBoundsCheck$Callback3 = this.mCallback;
        int n13 = viewBoundsCheck$Callback3.getChildStart(view);
        ViewBoundsCheck$Callback viewBoundsCheck$Callback4 = this.mCallback;
        int n14 = viewBoundsCheck$Callback4.getChildEnd(view);
        viewBoundsCheck$BoundFlags.setBounds(n11, n12, n13, n14);
        if (n10 != 0) {
            this.mBoundFlags.resetFlags();
            this.mBoundFlags.addFlags(n10);
            return this.mBoundFlags.boundsMatch();
        }
        return false;
    }
}

