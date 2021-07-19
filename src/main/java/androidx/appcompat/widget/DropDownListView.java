/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AbsListView
 *  android.widget.ListAdapter
 *  android.widget.ListView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.DropDownListView$GateKeeperDrawable;
import androidx.appcompat.widget.DropDownListView$ResolveHoverRunnable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;

public class DropDownListView
extends ListView {
    public static final int INVALID_POSITION = 255;
    public static final int NO_POSITION = 255;
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private Field mIsChildViewEnabled;
    private boolean mListSelectionHidden;
    private int mMotionPosition;
    public DropDownListView$ResolveHoverRunnable mResolveHoverRunnable;
    private ListViewAutoScrollHelper mScrollHelper;
    private int mSelectionBottomPadding;
    private int mSelectionLeftPadding;
    private int mSelectionRightPadding;
    private int mSelectionTopPadding;
    private DropDownListView$GateKeeperDrawable mSelector;
    private final Rect mSelectorRect;

    public DropDownListView(Context object, boolean bl2) {
        int n10 = R$attr.dropDownListViewStyle;
        super((Context)object, null, n10);
        super();
        this.mSelectorRect = object;
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mHijackFocus = bl2;
        this.setCacheColorHint(0);
        object = AbsListView.class;
        String string2 = "mIsChildViewEnabled";
        object = ((Class)object).getDeclaredField(string2);
        this.mIsChildViewEnabled = object;
        bl2 = true;
        try {
            ((Field)object).setAccessible(bl2);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
        }
    }

    private void clearPressedItem() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = null;
        this.mDrawsInPressedState = false;
        this.setPressed(false);
        this.drawableStateChanged();
        int n10 = this.mMotionPosition;
        int n11 = this.getFirstVisiblePosition();
        View view = this.getChildAt(n10 -= n11);
        if (view != null) {
            view.setPressed(false);
        }
        if ((viewPropertyAnimatorCompat = this.mClickAnimation) != null) {
            viewPropertyAnimatorCompat.cancel();
            viewPropertyAnimatorCompat = null;
            this.mClickAnimation = null;
        }
    }

    private void clickPressedItem(View view, int n10) {
        long l10 = this.getItemIdAtPosition(n10);
        this.performItemClick(view, n10, l10);
    }

    private void drawSelectorCompat(Canvas canvas) {
        Rect rect = this.mSelectorRect;
        boolean bl2 = rect.isEmpty();
        if (!bl2 && (rect = this.getSelector()) != null) {
            Rect rect2 = this.mSelectorRect;
            rect.setBounds(rect2);
            rect.draw(canvas);
        }
    }

    private void positionSelectorCompat(int n10, View object) {
        block9: {
            int n11;
            boolean bl2;
            Object object2;
            block10: {
                object2 = this.mSelectorRect;
                int n12 = object.getLeft();
                int n13 = object.getTop();
                int n14 = object.getRight();
                int n15 = object.getBottom();
                object2.set(n12, n13, n14, n15);
                n12 = ((Rect)object2).left;
                n13 = this.mSelectionLeftPadding;
                ((Rect)object2).left = n12 -= n13;
                n12 = ((Rect)object2).top;
                n13 = this.mSelectionTopPadding;
                ((Rect)object2).top = n12 -= n13;
                n12 = ((Rect)object2).right;
                n13 = this.mSelectionRightPadding;
                ((Rect)object2).right = n12 += n13;
                n12 = ((Rect)object2).bottom;
                n13 = this.mSelectionBottomPadding;
                ((Rect)object2).bottom = n12 += n13;
                object2 = this.mIsChildViewEnabled;
                bl2 = ((Field)object2).getBoolean((Object)this);
                n11 = object.isEnabled();
                if (n11 == bl2) break block9;
                object = this.mIsChildViewEnabled;
                if (!bl2) {
                    bl2 = true;
                    break block10;
                }
                bl2 = false;
                object2 = null;
            }
            object2 = bl2;
            ((Field)object).set((Object)this, object2);
            n11 = -1;
            if (n10 == n11) break block9;
            try {
                this.refreshDrawableState();
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
    }

    private void positionSelectorLikeFocusCompat(int n10, View view) {
        int n11;
        Drawable drawable2 = this.getSelector();
        int n12 = 1;
        n11 = drawable2 != null && n10 != (n11 = -1) ? n12 : 0;
        if (n11 != 0) {
            drawable2.setVisible(false, false);
        }
        this.positionSelectorCompat(n10, view);
        if (n11 != 0) {
            Rect rect = this.mSelectorRect;
            float f10 = rect.exactCenterX();
            float f11 = rect.exactCenterY();
            n11 = this.getVisibility();
            if (n11 != 0) {
                n12 = 0;
            }
            drawable2.setVisible(n12 != 0, false);
            DrawableCompat.setHotspot(drawable2, f10, f11);
        }
    }

    private void positionSelectorLikeTouchCompat(int n10, View view, float f10, float f11) {
        int n11;
        this.positionSelectorLikeFocusCompat(n10, view);
        view = this.getSelector();
        if (view != null && n10 != (n11 = -1)) {
            DrawableCompat.setHotspot((Drawable)view, f10, f11);
        }
    }

    private void setPressedItem(View view, int n10, float f10, float f11) {
        View view2;
        int n11;
        boolean bl2;
        this.mDrawsInPressedState = bl2 = true;
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 21;
        if (n12 >= n13) {
            this.drawableHotspotChanged(f10, f11);
        }
        if ((n11 = this.isPressed()) == 0) {
            this.setPressed(bl2);
        }
        this.layoutChildren();
        n11 = this.mMotionPosition;
        int n14 = -1;
        float f12 = 0.0f / 0.0f;
        if (n11 != n14 && (view2 = this.getChildAt(n11 -= (n14 = this.getFirstVisiblePosition()))) != null && view2 != view && (n14 = (int)(view2.isPressed() ? 1 : 0)) != 0) {
            view2.setPressed(false);
        }
        this.mMotionPosition = n10;
        n11 = view.getLeft();
        float f13 = n11;
        f13 = f10 - f13;
        n14 = view.getTop();
        f12 = n14;
        f12 = f11 - f12;
        if (n12 >= n13) {
            view.drawableHotspotChanged(f13, f12);
        }
        if ((n12 = (int)(view.isPressed() ? 1 : 0)) == 0) {
            view.setPressed(bl2);
        }
        this.positionSelectorLikeTouchCompat(n10, view, f10, f11);
        this.setSelectorEnabled(false);
        this.refreshDrawableState();
    }

    private void setSelectorEnabled(boolean bl2) {
        DropDownListView$GateKeeperDrawable dropDownListView$GateKeeperDrawable = this.mSelector;
        if (dropDownListView$GateKeeperDrawable != null) {
            dropDownListView$GateKeeperDrawable.setEnabled(bl2);
        }
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState;
    }

    private void updateSelectorStateCompat() {
        boolean bl2;
        Drawable drawable2 = this.getSelector();
        if (drawable2 != null && (bl2 = this.touchModeDrawsInPressedStateCompat()) && (bl2 = this.isPressed())) {
            int[] nArray = this.getDrawableState();
            drawable2.setState(nArray);
        }
    }

    public void dispatchDraw(Canvas canvas) {
        this.drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }

    public void drawableStateChanged() {
        DropDownListView$ResolveHoverRunnable dropDownListView$ResolveHoverRunnable = this.mResolveHoverRunnable;
        if (dropDownListView$ResolveHoverRunnable != null) {
            return;
        }
        super.drawableStateChanged();
        this.setSelectorEnabled(true);
        this.updateSelectorStateCompat();
    }

    public boolean hasFocus() {
        boolean bl2 = this.mHijackFocus;
        bl2 = bl2 || (bl2 = super.hasFocus());
        return bl2;
    }

    public boolean hasWindowFocus() {
        boolean bl2 = this.mHijackFocus;
        bl2 = bl2 || (bl2 = super.hasWindowFocus());
        return bl2;
    }

    public boolean isFocused() {
        boolean bl2 = this.mHijackFocus;
        bl2 = bl2 || (bl2 = super.isFocused());
        return bl2;
    }

    public boolean isInTouchMode() {
        boolean bl2 = this.mHijackFocus;
        bl2 = bl2 && (bl2 = this.mListSelectionHidden) || (bl2 = super.isInTouchMode());
        return bl2;
    }

    public int lookForSelectablePosition(int n10, boolean bl2) {
        int n11;
        ListAdapter listAdapter = this.getAdapter();
        int n12 = -1;
        if (listAdapter != null && (n11 = this.isInTouchMode()) == 0) {
            n11 = listAdapter.getCount();
            ListAdapter listAdapter2 = this.getAdapter();
            boolean bl3 = listAdapter2.areAllItemsEnabled();
            if (!bl3) {
                if (bl2) {
                    boolean bl4;
                    boolean bl5 = false;
                    for (n10 = Math.max(0, n10); n10 < n11 && !(bl4 = listAdapter.isEnabled(n10)); ++n10) {
                    }
                } else {
                    boolean bl6;
                    int n13 = n11 + -1;
                    for (n10 = Math.min(n10, n13); n10 >= 0 && !(bl6 = listAdapter.isEnabled(n10)); n10 += -1) {
                    }
                }
                if (n10 >= 0 && n10 < n11) {
                    return n10;
                }
                return n12;
            }
            if (n10 >= 0 && n10 < n11) {
                return n10;
            }
        }
        return n12;
    }

    public int measureHeightOfChildrenCompat(int n10, int n11, int n12, int n13, int n14) {
        n11 = this.getListPaddingTop();
        n12 = this.getListPaddingBottom();
        int n15 = this.getDividerHeight();
        Drawable drawable2 = this.getDivider();
        ListAdapter listAdapter = this.getAdapter();
        if (listAdapter == null) {
            return n11 + n12;
        }
        n11 += n12;
        n12 = 0;
        if (n15 <= 0 || drawable2 == null) {
            n15 = 0;
        }
        int n16 = listAdapter.getCount();
        int n17 = 0;
        int n18 = 0;
        View view = null;
        for (int i10 = 0; i10 < n16; ++i10) {
            ViewGroup.LayoutParams layoutParams;
            int n19 = listAdapter.getItemViewType(i10);
            if (n19 != n17) {
                view = null;
                n17 = n19;
            }
            if ((layoutParams = (view = listAdapter.getView(i10, view, (ViewGroup)this)).getLayoutParams()) == null) {
                layoutParams = this.generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if ((n19 = layoutParams.height) > 0) {
                int n20 = 0x40000000;
                n19 = View.MeasureSpec.makeMeasureSpec((int)n19, (int)n20);
            } else {
                n19 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
            }
            view.measure(n10, n19);
            view.forceLayout();
            if (i10 > 0) {
                n11 += n15;
            }
            if ((n11 += (n19 = view.getMeasuredHeight())) >= n13) {
                if (n14 >= 0 && i10 > n14 && n18 > 0 && n11 != n13) {
                    n13 = n18;
                }
                return n13;
            }
            if (n14 < 0 || i10 < n14) continue;
            n18 = n11;
        }
        return n11;
    }

    public void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    /*
     * Unable to fully structure code
     */
    public boolean onForwardedEvent(MotionEvent var1_1, int var2_2) {
        block11: {
            block12: {
                var3_3 = var1_1.getActionMasked();
                var4_4 = 1;
                var5_5 = 1.4E-45f;
                if (var3_3 != var4_4) {
                    var6_6 = 2;
                    if (var3_3 != var6_6) {
                        var2_2 = 3;
                        var7_7 = 4.2E-45f;
                        if (var3_3 != var2_2) lbl-1000:
                        // 3 sources

                        {
                            while (true) {
                                var2_2 = 0;
                                var8_8 = null;
                                var7_7 = 0.0f;
                                var6_6 = var4_4;
                                break block11;
                                break;
                            }
                        }
lbl16:
                        // 3 sources

                        while (true) {
                            var2_2 = 0;
                            var8_8 = null;
                            var7_7 = 0.0f;
                            var6_6 = 0;
                            var9_9 = null;
                            break block11;
                            break;
                        }
                    }
                    var6_6 = var4_4;
                } else {
                    var6_6 = 0;
                    var9_9 = null;
                }
                ** while ((var2_2 = var1_1.findPointerIndex((int)var2_2)) < 0)
lbl28:
                // 1 sources

                var10_10 = var1_1.getX(var2_2);
                var11_11 = (int)var10_10;
                var12_12 = this.pointToPosition(var11_11, var2_2 = (int)(var7_7 = var1_1.getY(var2_2)));
                if (var12_12 != (var13_13 = -1)) break block12;
                var2_2 = var4_4;
                var7_7 = var5_5;
                break block11;
            }
            var6_6 = this.getFirstVisiblePosition();
            var6_6 = var12_12 - var6_6;
            var9_9 = this.getChildAt(var6_6);
            var10_10 = var11_11;
            var7_7 = var2_2;
            this.setPressedItem(var9_9, var12_12, var10_10, var7_7);
            if (var3_3 != var4_4) ** GOTO lbl-1000
            this.clickPressedItem(var9_9, var12_12);
            ** while (true)
        }
        if (var6_6 == 0 || var2_2 != 0) {
            this.clearPressedItem();
        }
        if (var6_6 != 0) {
            var8_8 = this.mScrollHelper;
            if (var8_8 == null) {
                this.mScrollHelper = var8_8 = new ListViewAutoScrollHelper(this);
            }
            this.mScrollHelper.setEnabled((boolean)var4_4);
            var8_8 = this.mScrollHelper;
            var8_8.onTouch((View)this, (MotionEvent)var1_1);
        } else {
            var1_1 = this.mScrollHelper;
            if (var1_1 != null) {
                var1_1.setEnabled(false);
            }
        }
        return (boolean)var6_6;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        DropDownListView$ResolveHoverRunnable dropDownListView$ResolveHoverRunnable;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            return super.onHoverEvent(motionEvent);
        }
        n10 = motionEvent.getActionMasked();
        if (n10 == (n11 = 10) && (dropDownListView$ResolveHoverRunnable = this.mResolveHoverRunnable) == null) {
            this.mResolveHoverRunnable = dropDownListView$ResolveHoverRunnable = new DropDownListView$ResolveHoverRunnable(this);
            dropDownListView$ResolveHoverRunnable.post();
        }
        n11 = super.onHoverEvent(motionEvent) ? 1 : 0;
        int n12 = 9;
        int n13 = -1;
        if (n10 != n12 && n10 != (n12 = 7)) {
            this.setSelection(n13);
        } else {
            float f10 = motionEvent.getX();
            n10 = (int)f10;
            float f11 = motionEvent.getY();
            int n14 = (int)f11;
            if ((n14 = this.pointToPosition(n10, n14)) != n13 && n14 != (n10 = this.getSelectedItemPosition())) {
                n10 = this.getFirstVisiblePosition();
                View view = this.getChildAt(n10 = n14 - n10);
                n12 = view.isEnabled() ? 1 : 0;
                if (n12 != 0) {
                    n10 = view.getTop();
                    n12 = this.getTop();
                    this.setSelectionFromTop(n14, n10 -= n12);
                }
                this.updateSelectorStateCompat();
            }
        }
        return n11 != 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        if (n10 == 0) {
            float f10 = motionEvent.getX();
            n10 = (int)f10;
            float f11 = motionEvent.getY();
            int n11 = (int)f11;
            this.mMotionPosition = n10 = this.pointToPosition(n10, n11);
        }
        DropDownListView$ResolveHoverRunnable dropDownListView$ResolveHoverRunnable = this.mResolveHoverRunnable;
        if (dropDownListView$ResolveHoverRunnable != null) {
            dropDownListView$ResolveHoverRunnable.cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean bl2) {
        this.mListSelectionHidden = bl2;
    }

    public void setSelector(Drawable drawable2) {
        int n10;
        DropDownListView$GateKeeperDrawable dropDownListView$GateKeeperDrawable = drawable2 != null ? new DropDownListView$GateKeeperDrawable(drawable2) : null;
        this.mSelector = dropDownListView$GateKeeperDrawable;
        super.setSelector((Drawable)dropDownListView$GateKeeperDrawable);
        dropDownListView$GateKeeperDrawable = new Rect();
        if (drawable2 != null) {
            drawable2.getPadding((Rect)dropDownListView$GateKeeperDrawable);
        }
        this.mSelectionLeftPadding = n10 = ((Rect)dropDownListView$GateKeeperDrawable).left;
        this.mSelectionTopPadding = n10 = ((Rect)dropDownListView$GateKeeperDrawable).top;
        this.mSelectionRightPadding = n10 = ((Rect)dropDownListView$GateKeeperDrawable).right;
        this.mSelectionBottomPadding = n10 = ((Rect)dropDownListView$GateKeeperDrawable).bottom;
    }
}

