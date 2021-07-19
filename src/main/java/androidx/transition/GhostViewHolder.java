/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 */
package androidx.transition;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.transition.GhostViewPort;
import androidx.transition.R$id;
import androidx.transition.ViewGroupUtils;
import java.util.ArrayList;

public class GhostViewHolder
extends FrameLayout {
    private boolean mAttached;
    private ViewGroup mParent;

    public GhostViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        super(context);
        this.setClipChildren(false);
        this.mParent = viewGroup;
        int n10 = R$id.ghost_view_holder;
        viewGroup.setTag(n10, (Object)this);
        ViewGroupUtils.getOverlay(this.mParent).add((View)this);
        this.mAttached = true;
    }

    public static GhostViewHolder getHolder(ViewGroup viewGroup) {
        int n10 = R$id.ghost_view_holder;
        return (GhostViewHolder)((Object)viewGroup.getTag(n10));
    }

    private int getInsertIndex(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int n10 = this.getChildCount() + -1;
        int n11 = 0;
        while (n11 <= n10) {
            int n12 = (n11 + n10) / 2;
            View view = ((GhostViewPort)this.getChildAt((int)n12)).mView;
            GhostViewHolder.getParents(view, arrayList2);
            boolean bl2 = GhostViewHolder.isOnTop(arrayList, arrayList2);
            if (bl2) {
                n11 = ++n12;
            } else {
                n10 = n12 += -1;
            }
            arrayList2.clear();
        }
        return n11;
    }

    private static void getParents(View view, ArrayList arrayList) {
        ViewParent viewParent = view.getParent();
        boolean bl2 = viewParent instanceof ViewGroup;
        if (bl2) {
            viewParent = (View)viewParent;
            GhostViewHolder.getParents((View)viewParent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean isOnTop(View view, View view2) {
        boolean bl2;
        block4: {
            float f10;
            float f11;
            ViewGroup viewGroup = (ViewGroup)view.getParent();
            int n10 = viewGroup.getChildCount();
            int n11 = Build.VERSION.SDK_INT;
            bl2 = false;
            boolean bl3 = true;
            int n12 = 21;
            float f12 = 2.9E-44f;
            if (n11 >= n12 && (n11 = (int)((f11 = (f10 = view.getZ()) - (f12 = view2.getZ())) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) != 0) {
                float f13;
                float f14 = view.getZ();
                float f15 = f14 - (f13 = view2.getZ());
                Object object = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
                if (object > 0) {
                    bl2 = bl3;
                }
                return bl2;
            }
            f10 = 0.0f;
            for (n11 = 0; n11 < n10; ++n11) {
                n12 = ViewGroupUtils.getChildDrawingOrder(viewGroup, n11);
                View view3 = viewGroup.getChildAt(n12);
                if (view3 != view) {
                    if (view3 == view2) break;
                    continue;
                }
                break block4;
            }
            bl2 = bl3;
        }
        return bl2;
    }

    private static boolean isOnTop(ArrayList arrayList, ArrayList arrayList2) {
        boolean bl2 = arrayList.isEmpty();
        int n10 = 1;
        if (!bl2 && !(bl2 = arrayList2.isEmpty())) {
            Object e10;
            bl2 = false;
            Object e11 = arrayList.get(0);
            if (e11 == (e10 = arrayList2.get(0))) {
                int n11 = arrayList.size();
                int n12 = arrayList2.size();
                n11 = Math.min(n11, n12);
                for (n12 = n10; n12 < n11; ++n12) {
                    View view;
                    View view2 = (View)arrayList.get(n12);
                    if (view2 == (view = (View)arrayList2.get(n12))) continue;
                    return GhostViewHolder.isOnTop(view2, view);
                }
                int n13 = arrayList2.size();
                if (n13 != n11) {
                    n10 = 0;
                }
            }
        }
        return n10 != 0;
    }

    public void addGhostView(GhostViewPort ghostViewPort) {
        int n10;
        ArrayList arrayList = new ArrayList();
        View view = ghostViewPort.mView;
        GhostViewHolder.getParents(view, arrayList);
        int n11 = this.getInsertIndex(arrayList);
        if (n11 >= 0 && n11 < (n10 = this.getChildCount())) {
            this.addView((View)ghostViewPort, n11);
        } else {
            this.addView((View)ghostViewPort);
        }
    }

    public void onViewAdded(View object) {
        boolean bl2 = this.mAttached;
        if (bl2) {
            super.onViewAdded(object);
            return;
        }
        object = new IllegalStateException("This GhostViewHolder is detached!");
        throw object;
    }

    public void onViewRemoved(View object) {
        int n10;
        View view;
        super.onViewRemoved((View)object);
        int n11 = this.getChildCount();
        int n12 = 1;
        if (n11 == n12 && (view = this.getChildAt(0)) == object || (n10 = this.getChildCount()) == 0) {
            object = this.mParent;
            n11 = R$id.ghost_view_holder;
            n12 = 0;
            object.setTag(n11, null);
            object = ViewGroupUtils.getOverlay(this.mParent);
            object.remove((View)this);
            this.mAttached = false;
        }
    }

    public void popToOverlayTop() {
        boolean bl2 = this.mAttached;
        if (bl2) {
            ViewGroupUtils.getOverlay(this.mParent).remove((View)this);
            ViewGroupUtils.getOverlay(this.mParent).add((View)this);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("This GhostViewHolder is detached!");
        throw illegalStateException;
    }
}

