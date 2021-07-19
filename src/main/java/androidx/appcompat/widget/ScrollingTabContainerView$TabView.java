/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar$Tab;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.TooltipCompat;

public class ScrollingTabContainerView$TabView
extends LinearLayout {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
    private final int[] BG_ATTRS;
    private View mCustomView;
    private ImageView mIconView;
    private ActionBar$Tab mTab;
    private TextView mTextView;
    public final /* synthetic */ ScrollingTabContainerView this$0;

    public ScrollingTabContainerView$TabView(ScrollingTabContainerView object, Context context, ActionBar$Tab actionBar$Tab, boolean bl2) {
        int n10;
        this.this$0 = object;
        int n11 = R$attr.actionBarTabStyle;
        super(context, null, n11);
        int n12 = 1;
        int[] nArray = new int[n12];
        nArray[0] = n10 = 16842964;
        this.BG_ATTRS = nArray;
        this.mTab = actionBar$Tab;
        object = TintTypedArray.obtainStyledAttributes(context, null, nArray, n11, 0);
        boolean bl3 = ((TintTypedArray)object).hasValue(0);
        if (bl3) {
            context = ((TintTypedArray)object).getDrawable(0);
            this.setBackgroundDrawable((Drawable)context);
        }
        ((TintTypedArray)object).recycle();
        if (bl2) {
            n11 = 8388627;
            this.setGravity(n11);
        }
        this.update();
    }

    public void bindTab(ActionBar$Tab actionBar$Tab) {
        this.mTab = actionBar$Tab;
        this.update();
    }

    public ActionBar$Tab getTab() {
        return this.mTab;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ACCESSIBILITY_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)ACCESSIBILITY_CLASS_NAME);
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        ScrollingTabContainerView scrollingTabContainerView = this.this$0;
        n10 = scrollingTabContainerView.mMaxTabWidth;
        if (n10 > 0) {
            n10 = this.getMeasuredWidth();
            ScrollingTabContainerView scrollingTabContainerView2 = this.this$0;
            int n12 = scrollingTabContainerView2.mMaxTabWidth;
            if (n10 > n12) {
                n10 = View.MeasureSpec.makeMeasureSpec((int)n12, (int)0x40000000);
                super.onMeasure(n10, n11);
            }
        }
    }

    public void setSelected(boolean bl2) {
        boolean bl3 = this.isSelected();
        bl3 = bl3 != bl2;
        super.setSelected(bl2);
        if (bl3 && bl2) {
            int n10 = 4;
            this.sendAccessibilityEvent(n10);
        }
    }

    public void update() {
        ActionBar$Tab actionBar$Tab = this.mTab;
        View view = actionBar$Tab.getCustomView();
        int n10 = 8;
        CharSequence charSequence = null;
        if (view != null) {
            actionBar$Tab = view.getParent();
            if (actionBar$Tab != this) {
                if (actionBar$Tab != null) {
                    actionBar$Tab = (ViewGroup)actionBar$Tab;
                    actionBar$Tab.removeView(view);
                }
                this.addView(view);
            }
            this.mCustomView = view;
            actionBar$Tab = this.mTextView;
            if (actionBar$Tab != null) {
                actionBar$Tab.setVisibility(n10);
            }
            if ((actionBar$Tab = this.mIconView) != null) {
                actionBar$Tab.setVisibility(n10);
                actionBar$Tab = this.mIconView;
                actionBar$Tab.setImageDrawable(null);
            }
        } else {
            TextView textView;
            ImageView imageView;
            view = this.mCustomView;
            if (view != null) {
                this.removeView(view);
                this.mCustomView = null;
            }
            view = actionBar$Tab.getIcon();
            CharSequence charSequence2 = actionBar$Tab.getText();
            int n11 = 16;
            int n12 = -2;
            if (view != null) {
                imageView = this.mIconView;
                if (imageView == null) {
                    Context context = this.getContext();
                    imageView = new AppCompatImageView(context);
                    context = new LinearLayout.LayoutParams(n12, n12);
                    context.gravity = n11;
                    imageView.setLayoutParams((ViewGroup.LayoutParams)context);
                    this.addView((View)imageView, 0);
                    this.mIconView = imageView;
                }
                imageView = this.mIconView;
                imageView.setImageDrawable((Drawable)view);
                view = this.mIconView;
                view.setVisibility(0);
            } else {
                view = this.mIconView;
                if (view != null) {
                    view.setVisibility(n10);
                    view = this.mIconView;
                    view.setImageDrawable(null);
                }
            }
            boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence2) ^ true;
            if (bl2) {
                textView = this.mTextView;
                if (textView == null) {
                    imageView = this.getContext();
                    int n13 = R$attr.actionBarTabTextStyle;
                    textView = new AppCompatTextView((Context)imageView, null, n13);
                    imageView = TextUtils.TruncateAt.END;
                    textView.setEllipsize((TextUtils.TruncateAt)imageView);
                    imageView = new LinearLayout.LayoutParams(n12, n12);
                    imageView.gravity = n11;
                    textView.setLayoutParams((ViewGroup.LayoutParams)imageView);
                    this.addView((View)textView);
                    this.mTextView = textView;
                }
                this.mTextView.setText(charSequence2);
                textView = this.mTextView;
                textView.setVisibility(0);
            } else {
                charSequence2 = this.mTextView;
                if (charSequence2 != null) {
                    charSequence2.setVisibility(n10);
                    textView = this.mTextView;
                    textView.setText(null);
                }
            }
            textView = this.mIconView;
            if (textView != null) {
                charSequence2 = actionBar$Tab.getContentDescription();
                textView.setContentDescription(charSequence2);
            }
            if (!bl2) {
                charSequence = actionBar$Tab.getContentDescription();
            }
            TooltipCompat.setTooltipText((View)this, charSequence);
        }
    }
}

