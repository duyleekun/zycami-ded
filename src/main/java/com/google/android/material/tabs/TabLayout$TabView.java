/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build$VERSION
 *  android.text.Layout
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package com.google.android.material.tabs;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar$Tab;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$layout;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout$Tab;

public class TabLayout$TabView
extends LinearLayout {
    private Drawable baseBackgroundDrawable;
    private ImageView customIconView;
    private TextView customTextView;
    private View customView;
    private int defaultMaxLines;
    private ImageView iconView;
    private TabLayout$Tab tab;
    private TextView textView;
    public final /* synthetic */ TabLayout this$0;

    public TabLayout$TabView(TabLayout object, Context context) {
        this.this$0 = object;
        super(context);
        this.defaultMaxLines = 2;
        this.updateBackgroundDrawable(context);
        int n10 = ((TabLayout)object).tabPaddingStart;
        int n11 = ((TabLayout)object).tabPaddingTop;
        int n12 = ((TabLayout)object).tabPaddingEnd;
        int n13 = ((TabLayout)object).tabPaddingBottom;
        ViewCompat.setPaddingRelative((View)this, n10, n11, n12, n13);
        this.setGravity(17);
        int n14 = ((TabLayout)object).inlineLabel;
        n10 = 1;
        int n15 = n14 ^ n10;
        this.setOrientation(n15);
        this.setClickable(n10 != 0);
        object = PointerIconCompat.getSystemIcon(this.getContext(), 1002);
        ViewCompat.setPointerIcon((View)this, (PointerIconCompat)object);
    }

    public static /* synthetic */ void access$000(TabLayout$TabView tabLayout$TabView, Context context) {
        tabLayout$TabView.updateBackgroundDrawable(context);
    }

    public static /* synthetic */ void access$300(TabLayout$TabView tabLayout$TabView, Canvas canvas) {
        tabLayout$TabView.drawBackground(canvas);
    }

    public static /* synthetic */ int access$500(TabLayout$TabView tabLayout$TabView) {
        return tabLayout$TabView.getContentWidth();
    }

    private float approximateLineWidth(Layout layout2, int n10, float f10) {
        float f11 = layout2.getLineWidth(n10);
        float f12 = layout2.getPaint().getTextSize();
        return f11 * (f10 /= f12);
    }

    private void drawBackground(Canvas canvas) {
        Drawable drawable2 = this.baseBackgroundDrawable;
        if (drawable2 != null) {
            int n10 = this.getLeft();
            int n11 = this.getTop();
            int n12 = this.getRight();
            int n13 = this.getBottom();
            drawable2.setBounds(n10, n11, n12, n13);
            drawable2 = this.baseBackgroundDrawable;
            drawable2.draw(canvas);
        }
    }

    private int getContentWidth() {
        int n10 = 3;
        View[] viewArray = new View[n10];
        TextView textView = this.textView;
        viewArray[0] = textView;
        textView = this.iconView;
        int n11 = 1;
        viewArray[n11] = textView;
        textView = this.customView;
        viewArray[2] = textView;
        int n12 = 0;
        textView = null;
        int n13 = 0;
        int n14 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n15;
            View view = viewArray[i10];
            if (view == null || (n15 = view.getVisibility()) != 0) continue;
            if (n14 != 0) {
                n15 = view.getLeft();
                n13 = Math.min(n13, n15);
            } else {
                n13 = view.getLeft();
            }
            if (n14 != 0) {
                n14 = view.getRight();
                n12 = Math.max(n12, n14);
            } else {
                n12 = view.getRight();
            }
            n14 = n11;
        }
        return n12 - n13;
    }

    private void updateBackgroundDrawable(Context object) {
        int n10;
        Object object2 = this.this$0;
        int n11 = object2.tabBackgroundResId;
        Drawable drawable2 = null;
        if (n11 != 0) {
            object = AppCompatResources.getDrawable(object, n11);
            this.baseBackgroundDrawable = object;
            if (object != null && (n10 = object.isStateful()) != 0) {
                object = this.baseBackgroundDrawable;
                object2 = this.getDrawableState();
                object.setState((int[])object2);
            }
        } else {
            this.baseBackgroundDrawable = null;
        }
        object = new GradientDrawable();
        n11 = 0;
        object2 = null;
        object.setColor(0);
        ColorStateList colorStateList = this.this$0.tabRippleColorStateList;
        if (colorStateList != null) {
            colorStateList = new GradientDrawable();
            colorStateList.setCornerRadius(1.0E-5f);
            int n12 = -1;
            colorStateList.setColor(n12);
            Drawable[] drawableArray = RippleUtils.convertToRippleDrawableColor(this.this$0.tabRippleColorStateList);
            int n13 = Build.VERSION.SDK_INT;
            int n14 = 21;
            if (n13 >= n14) {
                TabLayout tabLayout = this.this$0;
                n13 = (int)(tabLayout.unboundedRipple ? 1 : 0);
                if (n13 != 0) {
                    n10 = 0;
                    object = null;
                }
                if (n13 == 0) {
                    drawable2 = colorStateList;
                }
                object2 = new RippleDrawable((ColorStateList)drawableArray, (Drawable)object, drawable2);
                object = object2;
            } else {
                drawable2 = DrawableCompat.wrap((Drawable)colorStateList);
                DrawableCompat.setTintList(drawable2, (ColorStateList)drawableArray);
                n12 = 2;
                drawableArray = new Drawable[n12];
                drawableArray[0] = object;
                n10 = 1;
                drawableArray[n10] = drawable2;
                colorStateList = new LayerDrawable(drawableArray);
                object = colorStateList;
            }
        }
        ViewCompat.setBackground((View)this, (Drawable)object);
        this.this$0.invalidate();
    }

    private void updateTextAndIcon(TextView object, ImageView imageView) {
        int n10;
        boolean bl2;
        TabLayout$Tab tabLayout$Tab = this.tab;
        Object object2 = null;
        if (tabLayout$Tab != null && (tabLayout$Tab = tabLayout$Tab.getIcon()) != null) {
            tabLayout$Tab = DrawableCompat.wrap(this.tab.getIcon()).mutate();
        } else {
            bl2 = false;
            tabLayout$Tab = null;
        }
        Object object3 = this.tab;
        if (object3 != null) {
            object3 = ((TabLayout$Tab)object3).getText();
        } else {
            n10 = 0;
            object3 = null;
        }
        int n11 = 8;
        if (imageView != null) {
            if (tabLayout$Tab != null) {
                imageView.setImageDrawable((Drawable)tabLayout$Tab);
                imageView.setVisibility(0);
                this.setVisibility(0);
            } else {
                imageView.setVisibility(n11);
                imageView.setImageDrawable(null);
            }
        }
        bl2 = TextUtils.isEmpty((CharSequence)object3) ^ true;
        if (object != null) {
            if (bl2) {
                object.setText((CharSequence)object3);
                object.setVisibility(0);
                this.setVisibility(0);
            } else {
                object.setVisibility(n11);
                object.setText(null);
            }
        }
        if (imageView != null) {
            object = (ViewGroup.MarginLayoutParams)imageView.getLayoutParams();
            if (bl2 && (n10 = imageView.getVisibility()) == 0) {
                object3 = this.this$0;
                n10 = ((TabLayout)((Object)object3)).dpToPx(n11);
            } else {
                n10 = 0;
                object3 = null;
            }
            TabLayout tabLayout = this.this$0;
            n11 = (int)(tabLayout.inlineLabel ? 1 : 0);
            if (n11 != 0) {
                n11 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams)object);
                if (n10 != n11) {
                    MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams)object, n10);
                    object.bottomMargin = 0;
                    imageView.setLayoutParams((ViewGroup.LayoutParams)object);
                    imageView.requestLayout();
                }
            } else {
                n11 = object.bottomMargin;
                if (n10 != n11) {
                    object.bottomMargin = n10;
                    MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams)object, 0);
                    imageView.setLayoutParams((ViewGroup.LayoutParams)object);
                    imageView.requestLayout();
                }
            }
        }
        object = (object = this.tab) != null ? TabLayout$Tab.access$100((TabLayout$Tab)object) : null;
        if (!bl2) {
            object2 = object;
        }
        TooltipCompat.setTooltipText((View)this, (CharSequence)object2);
    }

    public void drawableStateChanged() {
        boolean bl2;
        super.drawableStateChanged();
        Object object = this.getDrawableState();
        Drawable drawable2 = this.baseBackgroundDrawable;
        boolean bl3 = false;
        if (drawable2 != null && (bl2 = drawable2.isStateful())) {
            drawable2 = this.baseBackgroundDrawable;
            boolean bl4 = drawable2.setState(object);
            bl3 = false | bl4;
        }
        if (bl3) {
            this.invalidate();
            object = (Object)this.this$0;
            object.invalidate();
        }
    }

    public TabLayout$Tab getTab() {
        return this.tab;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        String string2 = ActionBar$Tab.class.getName();
        accessibilityEvent.setClassName((CharSequence)string2);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        String string2 = ActionBar$Tab.class.getName();
        accessibilityNodeInfo.setClassName((CharSequence)string2);
    }

    public void onMeasure(int n10, int n11) {
        block8: {
            int n12;
            Object object;
            float f10;
            TabLayout tabLayout;
            int n13;
            block9: {
                block10: {
                    int n14 = View.MeasureSpec.getSize((int)n10);
                    n13 = View.MeasureSpec.getMode((int)n10);
                    tabLayout = this.this$0;
                    int n15 = tabLayout.getTabMaxWidth();
                    if (n15 > 0 && (n13 == 0 || n14 > n15)) {
                        TabLayout tabLayout2 = this.this$0;
                        n10 = tabLayout2.tabMaxWidth;
                        n14 = -1 << -1;
                        f10 = -0.0f;
                        n10 = View.MeasureSpec.makeMeasureSpec((int)n10, (int)n14);
                    }
                    super.onMeasure(n10, n11);
                    object = this.textView;
                    if (object == null) break block8;
                    object = this.this$0;
                    f10 = object.tabTextSize;
                    n13 = this.defaultMaxLines;
                    tabLayout = this.iconView;
                    n12 = 1;
                    if (tabLayout != null && (n15 = tabLayout.getVisibility()) == 0) {
                        n13 = n12;
                    } else {
                        tabLayout = this.textView;
                        if (tabLayout != null && (n15 = tabLayout.getLineCount()) > n12) {
                            object = this.this$0;
                            f10 = object.tabTextMultiLineSize;
                        }
                    }
                    tabLayout = this.textView;
                    float f11 = tabLayout.getTextSize();
                    TextView textView = this.textView;
                    int n16 = textView.getLineCount();
                    Object object2 = this.textView;
                    int n17 = TextViewCompat.getMaxLines(object2);
                    n15 = (int)(f10 == f11 ? 0 : (f10 > f11 ? 1 : -1));
                    if (n15 == 0 && (n17 < 0 || n13 == n17)) break block8;
                    object2 = this.this$0;
                    n17 = object2.mode;
                    if (n17 != n12 || n15 <= 0 || n16 != n12) break block9;
                    tabLayout = this.textView.getLayout();
                    if (tabLayout == null) break block10;
                    f11 = this.approximateLineWidth((Layout)tabLayout, 0, f10);
                    n16 = this.getMeasuredWidth();
                    n17 = this.getPaddingLeft();
                    n16 -= n17;
                    n17 = this.getPaddingRight();
                    float f12 = n16 -= n17;
                    float f13 = f11 - f12;
                    n15 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
                    if (n15 <= 0) break block9;
                }
                n12 = 0;
            }
            if (n12 != 0) {
                tabLayout = this.textView;
                tabLayout.setTextSize(0, f10);
                object = this.textView;
                object.setMaxLines(n13);
                super.onMeasure(n10, n11);
            }
        }
    }

    public boolean performClick() {
        boolean bl2 = super.performClick();
        TabLayout$Tab tabLayout$Tab = this.tab;
        if (tabLayout$Tab != null) {
            TabLayout$Tab tabLayout$Tab2;
            if (!bl2) {
                bl2 = false;
                tabLayout$Tab2 = null;
                this.playSoundEffect(0);
            }
            tabLayout$Tab2 = this.tab;
            tabLayout$Tab2.select();
            bl2 = true;
        }
        return bl2;
    }

    public void reset() {
        this.setTab(null);
        this.setSelected(false);
    }

    public void setSelected(boolean n10) {
        int n11;
        TextView textView;
        int n12 = this.isSelected();
        if (n12 != n10) {
            n12 = 1;
        } else {
            n12 = 0;
            textView = null;
        }
        super.setSelected(n10 != 0);
        if (n12 != 0 && n10 && (n12 = Build.VERSION.SDK_INT) < (n11 = 16)) {
            n12 = 4;
            this.sendAccessibilityEvent(n12);
        }
        if ((textView = this.textView) != null) {
            textView.setSelected(n10 != 0);
        }
        if ((textView = this.iconView) != null) {
            textView.setSelected(n10 != 0);
        }
        if ((textView = this.customView) != null) {
            textView.setSelected(n10 != 0);
        }
    }

    public void setTab(TabLayout$Tab tabLayout$Tab) {
        TabLayout$Tab tabLayout$Tab2 = this.tab;
        if (tabLayout$Tab != tabLayout$Tab2) {
            this.tab = tabLayout$Tab;
            this.update();
        }
    }

    public final void update() {
        boolean bl2;
        int n10;
        int n11;
        ViewParent viewParent;
        int n12;
        Object object;
        TabLayout$Tab tabLayout$Tab = this.tab;
        int n13 = 0;
        Object object2 = null;
        if (tabLayout$Tab != null) {
            object = tabLayout$Tab.getCustomView();
        } else {
            n12 = 0;
            object = null;
        }
        if (object != null) {
            viewParent = object.getParent();
            if (viewParent != this) {
                if (viewParent != null) {
                    viewParent = (ViewGroup)viewParent;
                    viewParent.removeView(object);
                }
                this.addView((View)object);
            }
            this.customView = object;
            viewParent = this.textView;
            n11 = 8;
            if (viewParent != null) {
                viewParent.setVisibility(n11);
            }
            if ((viewParent = this.iconView) != null) {
                viewParent.setVisibility(n11);
                viewParent = this.iconView;
                viewParent.setImageDrawable(null);
            }
            n10 = 16908308;
            viewParent = (TextView)object.findViewById(n10);
            this.customTextView = viewParent;
            if (viewParent != null) {
                this.defaultMaxLines = n10 = TextViewCompat.getMaxLines((TextView)viewParent);
            }
            n10 = 16908294;
            object = (ImageView)object.findViewById(n10);
            this.customIconView = object;
        } else {
            object = this.customView;
            if (object != null) {
                this.removeView((View)object);
                this.customView = null;
            }
            this.customTextView = null;
            this.customIconView = null;
        }
        object = this.customView;
        n10 = 0;
        viewParent = null;
        if (object == null) {
            object = this.iconView;
            if (object == null) {
                object = LayoutInflater.from((Context)this.getContext());
                n11 = R$layout.design_layout_tab_icon;
                object = (ImageView)object.inflate(n11, (ViewGroup)this, false);
                this.addView((View)object, 0);
                this.iconView = object;
            }
            if (tabLayout$Tab != null && (object = tabLayout$Tab.getIcon()) != null) {
                object2 = DrawableCompat.wrap(tabLayout$Tab.getIcon()).mutate();
            }
            if (object2 != null) {
                object = this.this$0.tabIconTint;
                DrawableCompat.setTintList((Drawable)object2, (ColorStateList)object);
                object = this.this$0.tabIconTintMode;
                if (object != null) {
                    DrawableCompat.setTintMode((Drawable)object2, (PorterDuff.Mode)object);
                }
            }
            if ((object2 = this.textView) == null) {
                object2 = LayoutInflater.from((Context)this.getContext());
                n12 = R$layout.design_layout_tab_text;
                object2 = (TextView)object2.inflate(n12, (ViewGroup)this, false);
                this.addView((View)object2);
                this.textView = object2;
                this.defaultMaxLines = n13 = TextViewCompat.getMaxLines(object2);
            }
            object2 = this.textView;
            object = this.this$0;
            n12 = object.tabTextAppearance;
            TextViewCompat.setTextAppearance(object2, n12);
            object2 = this.this$0.tabTextColors;
            if (object2 != null) {
                object = this.textView;
                object.setTextColor((ColorStateList)object2);
            }
            object2 = this.textView;
            object = this.iconView;
            this.updateTextAndIcon((TextView)object2, (ImageView)object);
        } else {
            object2 = this.customTextView;
            if (object2 != null || (object = this.customIconView) != null) {
                object = this.customIconView;
                this.updateTextAndIcon((TextView)object2, (ImageView)object);
            }
        }
        if (tabLayout$Tab != null && (n13 = TextUtils.isEmpty((CharSequence)(object2 = TabLayout$Tab.access$100(tabLayout$Tab)))) == 0) {
            object2 = TabLayout$Tab.access$100(tabLayout$Tab);
            this.setContentDescription((CharSequence)object2);
        }
        if (tabLayout$Tab != null && (bl2 = tabLayout$Tab.isSelected())) {
            n10 = 1;
        }
        this.setSelected(n10 != 0);
    }

    public final void updateOrientation() {
        ImageView imageView;
        int n10 = this.this$0.inlineLabel ^ 1;
        this.setOrientation(n10);
        TextView textView = this.customTextView;
        if (textView == null && (imageView = this.customIconView) == null) {
            textView = this.textView;
            imageView = this.iconView;
            this.updateTextAndIcon(textView, imageView);
        } else {
            imageView = this.customIconView;
            this.updateTextAndIcon(textView, imageView);
        }
    }
}

