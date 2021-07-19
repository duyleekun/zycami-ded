/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package androidx.viewpager2.widget;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.viewpager2.widget.CompositeOnPageChangeCallback;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$AccessibilityProvider;
import androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$3;

public class ViewPager2$PageAwareAccessibilityProvider
extends ViewPager2$AccessibilityProvider {
    private final AccessibilityViewCommand mActionPageBackward;
    private final AccessibilityViewCommand mActionPageForward;
    private RecyclerView$AdapterDataObserver mAdapterDataObserver;
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$PageAwareAccessibilityProvider(ViewPager2 object) {
        this.this$0 = object;
        super((ViewPager2)((Object)object), null);
        super(this);
        this.mActionPageForward = object;
        super(this);
        this.mActionPageBackward = object;
    }

    private void addCollectionInfo(AccessibilityNodeInfo object) {
        int n10;
        int n11;
        Object object2 = this.this$0.getAdapter();
        if (object2 != null) {
            object2 = this.this$0;
            n11 = ((ViewPager2)((Object)object2)).getOrientation();
            if (n11 == (n10 = 1)) {
                object2 = this.this$0.getAdapter();
                n11 = object2.getItemCount();
                n10 = 0;
            } else {
                n10 = this.this$0.getAdapter().getItemCount();
                n11 = 0;
                object2 = null;
            }
        } else {
            n11 = 0;
            object2 = null;
            n10 = 0;
        }
        object = AccessibilityNodeInfoCompat.wrap((AccessibilityNodeInfo)object);
        object2 = AccessibilityNodeInfoCompat$CollectionInfoCompat.obtain(n11, n10, false, 0);
        ((AccessibilityNodeInfoCompat)object).setCollectionInfo(object2);
    }

    private void addScrollActions(AccessibilityNodeInfo accessibilityNodeInfo) {
        ViewPager2 viewPager2;
        int n10;
        RecyclerView$Adapter recyclerView$Adapter = this.this$0.getAdapter();
        if (recyclerView$Adapter == null) {
            return;
        }
        int n11 = recyclerView$Adapter.getItemCount();
        if (n11 != 0 && (n10 = (viewPager2 = this.this$0).isUserInputEnabled()) != 0) {
            viewPager2 = this.this$0;
            n10 = viewPager2.mCurrentItem;
            if (n10 > 0) {
                n10 = 8192;
                accessibilityNodeInfo.addAction(n10);
            }
            viewPager2 = this.this$0;
            n10 = viewPager2.mCurrentItem;
            int n12 = 1;
            if (n10 < (n11 -= n12)) {
                n11 = 4096;
                accessibilityNodeInfo.addAction(n11);
            }
            accessibilityNodeInfo.setScrollable(n12 != 0);
        }
    }

    public boolean handlesGetAccessibilityClassName() {
        return true;
    }

    public boolean handlesPerformAccessibilityAction(int n10, Bundle bundle) {
        int n11 = 8192;
        n10 = n10 != n11 && n10 != (n11 = 4096) ? 0 : 1;
        return n10 != 0;
    }

    public void onAttachAdapter(RecyclerView$Adapter recyclerView$Adapter) {
        this.updatePageAccessibilityActions();
        if (recyclerView$Adapter != null) {
            RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = this.mAdapterDataObserver;
            recyclerView$Adapter.registerAdapterDataObserver(recyclerView$AdapterDataObserver);
        }
    }

    public void onDetachAdapter(RecyclerView$Adapter recyclerView$Adapter) {
        if (recyclerView$Adapter != null) {
            RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = this.mAdapterDataObserver;
            recyclerView$Adapter.unregisterAdapterDataObserver(recyclerView$AdapterDataObserver);
        }
    }

    public String onGetAccessibilityClassName() {
        boolean bl2 = this.handlesGetAccessibilityClassName();
        if (bl2) {
            return "androidx.viewpager.widget.ViewPager";
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public void onInitialize(CompositeOnPageChangeCallback object, RecyclerView recyclerView) {
        ViewCompat.setImportantForAccessibility((View)recyclerView, 2);
        this.mAdapterDataObserver = object = new ViewPager2$PageAwareAccessibilityProvider$3(this);
        object = this.this$0;
        int n10 = ViewCompat.getImportantForAccessibility((View)object);
        if (n10 == 0) {
            object = this.this$0;
            int n11 = 1;
            ViewCompat.setImportantForAccessibility((View)object, n11);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.addCollectionInfo(accessibilityNodeInfo);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            this.addScrollActions(accessibilityNodeInfo);
        }
    }

    public boolean onPerformAccessibilityAction(int n10, Bundle bundle) {
        int n11 = this.handlesPerformAccessibilityAction(n10, bundle);
        if (n11 != 0) {
            n11 = 8192;
            int n12 = 1;
            if (n10 == n11) {
                ViewPager2 viewPager2 = this.this$0;
                n10 = viewPager2.getCurrentItem() - n12;
            } else {
                ViewPager2 viewPager2 = this.this$0;
                n10 = viewPager2.getCurrentItem() + n12;
            }
            this.setCurrentItemFromAccessibilityCommand(n10);
            return n12 != 0;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public void onRestorePendingState() {
        this.updatePageAccessibilityActions();
    }

    public void onRvInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Object object = this.this$0;
        accessibilityEvent.setSource((View)object);
        object = this.onGetAccessibilityClassName();
        accessibilityEvent.setClassName((CharSequence)object);
    }

    public void onSetLayoutDirection() {
        this.updatePageAccessibilityActions();
    }

    public void onSetNewCurrentItem() {
        this.updatePageAccessibilityActions();
    }

    public void onSetOrientation() {
        this.updatePageAccessibilityActions();
    }

    public void onSetUserInputEnabled() {
        this.updatePageAccessibilityActions();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            ViewPager2 viewPager2 = this.this$0;
            n11 = 2048;
            viewPager2.sendAccessibilityEvent(n11);
        }
    }

    public void setCurrentItemFromAccessibilityCommand(int n10) {
        ViewPager2 viewPager2 = this.this$0;
        boolean bl2 = viewPager2.isUserInputEnabled();
        if (bl2) {
            viewPager2 = this.this$0;
            boolean bl3 = true;
            viewPager2.setCurrentItemInternal(n10, bl3);
        }
    }

    public void updatePageAccessibilityActions() {
        ViewPager2 viewPager2 = this.this$0;
        int n10 = 16908360;
        ViewCompat.removeAccessibilityAction((View)viewPager2, n10);
        int n11 = 16908361;
        float f10 = 2.3877434E-38f;
        ViewCompat.removeAccessibilityAction((View)viewPager2, n11);
        int n12 = 16908358;
        ViewCompat.removeAccessibilityAction((View)viewPager2, n12);
        int n13 = 16908359;
        ViewCompat.removeAccessibilityAction((View)viewPager2, n13);
        RecyclerView$Adapter recyclerView$Adapter = this.this$0.getAdapter();
        if (recyclerView$Adapter == null) {
            return;
        }
        recyclerView$Adapter = this.this$0.getAdapter();
        int n14 = recyclerView$Adapter.getItemCount();
        if (n14 == 0) {
            return;
        }
        ViewPager2 viewPager22 = this.this$0;
        int n15 = viewPager22.isUserInputEnabled();
        if (n15 == 0) {
            return;
        }
        viewPager22 = this.this$0;
        n15 = viewPager22.getOrientation();
        if (n15 == 0) {
            Object object = this.this$0;
            n12 = (int)(object.isRtl() ? 1 : 0);
            n13 = n12 != 0 ? n10 : n11;
            if (n12 != 0) {
                n10 = n11;
            }
            Object object2 = this.this$0;
            n11 = object2.mCurrentItem;
            if (n11 < (n14 += -1)) {
                object2 = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(n13, null);
                object = this.mActionPageForward;
                ViewCompat.replaceAccessibilityAction((View)viewPager2, (AccessibilityNodeInfoCompat$AccessibilityActionCompat)object2, null, (AccessibilityViewCommand)object);
            }
            object2 = this.this$0;
            n11 = object2.mCurrentItem;
            if (n11 > 0) {
                object2 = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(n10, null);
                AccessibilityViewCommand accessibilityViewCommand = this.mActionPageBackward;
                ViewCompat.replaceAccessibilityAction((View)viewPager2, (AccessibilityNodeInfoCompat$AccessibilityActionCompat)object2, null, accessibilityViewCommand);
            }
        } else {
            AccessibilityViewCommand accessibilityViewCommand;
            Object object = this.this$0;
            n10 = object.mCurrentItem;
            if (n10 < (n14 += -1)) {
                object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(n13, null);
                accessibilityViewCommand = this.mActionPageForward;
                ViewCompat.replaceAccessibilityAction((View)viewPager2, (AccessibilityNodeInfoCompat$AccessibilityActionCompat)object, null, accessibilityViewCommand);
            }
            object = this.this$0;
            n10 = object.mCurrentItem;
            if (n10 > 0) {
                object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(n12, null);
                accessibilityViewCommand = this.mActionPageBackward;
                ViewCompat.replaceAccessibilityAction((View)viewPager2, (AccessibilityNodeInfoCompat$AccessibilityActionCompat)object, null, accessibilityViewCommand);
            }
        }
    }
}

