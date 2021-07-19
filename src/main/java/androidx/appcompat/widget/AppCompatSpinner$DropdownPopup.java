/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.SpinnerAdapter
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatSpinner$DropdownPopup$2;
import androidx.appcompat.widget.AppCompatSpinner$DropdownPopup$3;
import androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.view.ViewCompat;

public class AppCompatSpinner$DropdownPopup
extends ListPopupWindow
implements AppCompatSpinner$SpinnerPopup {
    public ListAdapter mAdapter;
    private CharSequence mHintText;
    private int mOriginalHorizontalOffset;
    private final Rect mVisibleRect;
    public final /* synthetic */ AppCompatSpinner this$0;

    public AppCompatSpinner$DropdownPopup(AppCompatSpinner appCompatSpinner, Context object, AttributeSet attributeSet, int n10) {
        this.this$0 = appCompatSpinner;
        super((Context)object, attributeSet, n10);
        super();
        this.mVisibleRect = object;
        this.setAnchorView((View)appCompatSpinner);
        this.setModal(true);
        this.setPromptPosition(0);
        super(this, appCompatSpinner);
        this.setOnItemClickListener((AdapterView.OnItemClickListener)object);
    }

    public static /* synthetic */ void access$001(AppCompatSpinner$DropdownPopup appCompatSpinner$DropdownPopup) {
        super.show();
    }

    public void computeContentWidth() {
        int n10;
        int n11;
        Object object = this.getBackground();
        int n12 = 0;
        Rect rect = null;
        if (object != null) {
            rect = this.this$0.mTempRect;
            object.getPadding(rect);
            object = this.this$0;
            n11 = ViewUtils.isLayoutRtl((View)object);
            if (n11 != 0) {
                object = this.this$0.mTempRect;
                n11 = object.right;
            } else {
                object = this.this$0.mTempRect;
                n11 = -object.left;
            }
            n12 = n11;
        } else {
            object = this.this$0.mTempRect;
            object.right = 0;
            object.left = 0;
        }
        object = this.this$0;
        n11 = object.getPaddingLeft();
        AppCompatSpinner appCompatSpinner = this.this$0;
        int n13 = appCompatSpinner.getPaddingRight();
        AppCompatSpinner appCompatSpinner2 = this.this$0;
        int n14 = appCompatSpinner2.getWidth();
        AppCompatSpinner appCompatSpinner3 = this.this$0;
        int n15 = appCompatSpinner3.mDropDownWidth;
        int n16 = -2;
        if (n15 == n16) {
            SpinnerAdapter spinnerAdapter = (SpinnerAdapter)this.mAdapter;
            Drawable drawable2 = this.getBackground();
            n10 = appCompatSpinner3.compatMeasureContentWidth(spinnerAdapter, drawable2);
            spinnerAdapter = this.this$0.getContext().getResources().getDisplayMetrics();
            n15 = spinnerAdapter.widthPixels;
            drawable2 = this.this$0.mTempRect;
            int n17 = drawable2.left;
            n15 -= n17;
            n16 = drawable2.right;
            if (n10 > (n15 -= n16)) {
                n10 = n15;
            }
            n15 = n14 - n11 - n13;
            n10 = Math.max(n10, n15);
            this.setContentWidth(n10);
        } else {
            n10 = -1;
            if (n15 == n10) {
                n10 = n14 - n11 - n13;
                this.setContentWidth(n10);
            } else {
                this.setContentWidth(n15);
            }
        }
        appCompatSpinner3 = this.this$0;
        n10 = (int)(ViewUtils.isLayoutRtl((View)appCompatSpinner3) ? 1 : 0);
        if (n10 != 0) {
            n14 -= n13;
            n11 = this.getWidth();
            n14 -= n11;
            n11 = this.getHorizontalOriginalOffset();
            n12 += (n14 -= n11);
        } else {
            n13 = this.getHorizontalOriginalOffset();
            n12 += (n11 += n13);
        }
        this.setHorizontalOffset(n12);
    }

    public CharSequence getHintText() {
        return this.mHintText;
    }

    public int getHorizontalOriginalOffset() {
        return this.mOriginalHorizontalOffset;
    }

    public boolean isVisibleToUser(View view) {
        Rect rect;
        boolean bl2;
        boolean bl3 = ViewCompat.isAttachedToWindow(view);
        if (bl3 && (bl2 = view.getGlobalVisibleRect(rect = this.mVisibleRect))) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.mAdapter = listAdapter;
    }

    public void setHorizontalOriginalOffset(int n10) {
        this.mOriginalHorizontalOffset = n10;
    }

    public void setPromptText(CharSequence charSequence) {
        this.mHintText = charSequence;
    }

    public void show(int n10, int n11) {
        boolean bl2 = this.isShowing();
        this.computeContentWidth();
        int n12 = 2;
        this.setInputMethodMode(n12);
        super.show();
        ListView listView = this.getListView();
        listView.setChoiceMode(1);
        int n13 = Build.VERSION.SDK_INT;
        int n14 = 17;
        if (n13 >= n14) {
            listView.setTextDirection(n10);
            listView.setTextAlignment(n11);
        }
        Object object = this.this$0;
        n10 = object.getSelectedItemPosition();
        this.setSelection(n10);
        if (bl2) {
            return;
        }
        object = this.this$0.getViewTreeObserver();
        if (object != null) {
            AppCompatSpinner$DropdownPopup$2 appCompatSpinner$DropdownPopup$2 = new AppCompatSpinner$DropdownPopup$2(this);
            object.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)appCompatSpinner$DropdownPopup$2);
            object = new AppCompatSpinner$DropdownPopup$3(this, appCompatSpinner$DropdownPopup$2);
            this.setOnDismissListener((PopupWindow.OnDismissListener)object);
        }
    }
}

