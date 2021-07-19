/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build$VERSION
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.PointerIcon
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.TextView$BufferType
 */
package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.Chip$2;
import com.google.android.material.chip.Chip$ChipTouchHelper;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipDrawable$Delegate;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Chip
extends AppCompatCheckBox
implements ChipDrawable$Delegate {
    private static final int CLOSE_ICON_VIRTUAL_ID = 0;
    private static final Rect EMPTY_BOUNDS;
    private static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private static final int[] SELECTED_STATE;
    private static final String TAG = "Chip";
    private ChipDrawable chipDrawable;
    private boolean closeIconFocused;
    private boolean closeIconHovered;
    private boolean closeIconPressed;
    private boolean deferredCheckedValue;
    private int focusedVirtualView;
    private final ResourcesCompat$FontCallback fontCallback;
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;
    private View.OnClickListener onCloseIconClickListener;
    private final Rect rect;
    private final RectF rectF;
    private RippleDrawable ripple;
    private final Chip$ChipTouchHelper touchHelper;

    static {
        Object object;
        EMPTY_BOUNDS = object = new Rect();
        object = new int[1];
        object[0] = (Rect)0x10100A1;
        SELECTED_STATE = (int[])object;
    }

    public Chip(Context context) {
        this(context, null);
    }

    public Chip(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.chipStyle;
        this(context, attributeSet, n10);
    }

    public Chip(Context object, AttributeSet object2, int n10) {
        super((Context)object, (AttributeSet)object2, n10);
        Object object3;
        this.focusedVirtualView = -1 << -1;
        this.rect = object3 = new Rect();
        super();
        this.rectF = object3;
        super(this);
        this.fontCallback = object3;
        this.validateAttributes((AttributeSet)object2);
        int n11 = R$style.Widget_MaterialComponents_Chip_Action;
        object = ChipDrawable.createFromAttributes((Context)object, object2, n10, n11);
        this.setChipDrawable((ChipDrawable)object);
        super(this, this);
        this.touchHelper = object2;
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)object2);
        this.initOutlineProvider();
        boolean bl2 = this.deferredCheckedValue;
        this.setChecked(bl2);
        bl2 = false;
        object2 = null;
        ((ChipDrawable)object).setShouldDrawText(false);
        CharSequence charSequence = ((ChipDrawable)object).getText();
        this.setText(charSequence);
        object = ((ChipDrawable)object).getEllipsize();
        this.setEllipsize((TextUtils.TruncateAt)object);
        this.setIncludeFontPadding(false);
        object = this.getTextAppearance();
        if (object != null) {
            object = this.getTextAppearance();
            this.updateTextPaintDrawState((TextAppearance)object);
        }
        this.setSingleLine();
        this.setGravity(8388627);
        this.updatePaddingInternal();
    }

    public static /* synthetic */ ChipDrawable access$000(Chip chip) {
        return chip.chipDrawable;
    }

    public static /* synthetic */ boolean access$100(Chip chip) {
        return chip.hasCloseIcon();
    }

    public static /* synthetic */ RectF access$200(Chip chip) {
        return chip.getCloseIconTouchBounds();
    }

    public static /* synthetic */ Rect access$300(Chip chip) {
        return chip.getCloseIconTouchBoundsInt();
    }

    public static /* synthetic */ Rect access$400() {
        return EMPTY_BOUNDS;
    }

    private void applyChipDrawable(ChipDrawable chipDrawable) {
        chipDrawable.setDelegate(this);
    }

    private float calculateTextOffsetFromStart(ChipDrawable chipDrawable) {
        float f10 = this.getChipStartPadding();
        float f11 = chipDrawable.calculateChipIconWidth();
        f10 += f11;
        f11 = this.getTextStartPadding();
        f10 += f11;
        int n10 = ViewCompat.getLayoutDirection((View)this);
        if (n10 == 0) {
            return f10;
        }
        return -f10;
    }

    /*
     * WARNING - void declaration
     */
    private int[] createCloseIconDrawableState() {
        void var1_8;
        void var1_7;
        void var1_6;
        void var1_5;
        int[] nArray;
        boolean n10 = this.isEnabled();
        int n11 = 0;
        int n12 = 1;
        if (n10) {
            int n13 = n12;
        } else {
            boolean bl2 = false;
            nArray = null;
        }
        int n14 = this.closeIconFocused;
        if (n14 != 0) {
            void var1_4;
            var1_5 = var1_4 + true;
        }
        if ((n14 = this.closeIconHovered) != 0) {
            var1_6 = var1_5 + true;
        }
        if ((n14 = this.closeIconPressed) != 0) {
            var1_7 = var1_6 + true;
        }
        if ((n14 = this.isChecked()) != 0) {
            var1_8 = var1_7 + true;
        }
        nArray = new int[var1_8];
        n14 = this.isEnabled();
        if (n14 != 0) {
            nArray[0] = n14 = 16842910;
            n11 = n12;
        }
        if ((n12 = this.closeIconFocused) != 0) {
            nArray[n11] = n12 = 16842908;
            ++n11;
        }
        if ((n12 = (int)(this.closeIconHovered ? 1 : 0)) != 0) {
            nArray[n11] = n12 = 16843623;
            ++n11;
        }
        if ((n12 = (int)(this.closeIconPressed ? 1 : 0)) != 0) {
            nArray[n11] = n12 = 16842919;
            ++n11;
        }
        if ((n12 = (int)(this.isChecked() ? 1 : 0)) != 0) {
            nArray[n11] = n12 = 0x10100A1;
        }
        return nArray;
    }

    private void ensureFocus() {
        int n10 = this.focusedVirtualView;
        int n11 = -1 << -1;
        if (n10 == n11) {
            n10 = -1;
            this.setFocusedVirtualView(n10);
        }
    }

    private RectF getCloseIconTouchBounds() {
        Object object = this.rectF;
        object.setEmpty();
        boolean bl2 = this.hasCloseIcon();
        if (bl2) {
            object = this.chipDrawable;
            RectF rectF = this.rectF;
            ((ChipDrawable)object).getCloseIconTouchBounds(rectF);
        }
        return this.rectF;
    }

    private Rect getCloseIconTouchBoundsInt() {
        RectF rectF = this.getCloseIconTouchBounds();
        Rect rect = this.rect;
        int n10 = (int)rectF.left;
        int n11 = (int)rectF.top;
        int n12 = (int)rectF.right;
        int n13 = (int)rectF.bottom;
        rect.set(n10, n11, n12, n13);
        return this.rect;
    }

    private TextAppearance getTextAppearance() {
        Object object = this.chipDrawable;
        object = object != null ? ((ChipDrawable)object).getTextAppearance() : null;
        return object;
    }

    private boolean handleAccessibilityExit(MotionEvent object) {
        block19: {
            int n10;
            Object object2 = ExploreByTouchHelper.class;
            String string2 = "Unable to send Accessibility Exit event";
            String string3 = TAG;
            int n11 = object.getAction();
            if (n11 == (n10 = 10)) {
                object = "mHoveredVirtualViewId";
                object = ((Class)object2).getDeclaredField((String)object);
                n10 = 1;
                ((Field)object).setAccessible(n10 != 0);
                Object object3 = this.touchHelper;
                object = ((Field)object).get(object3);
                object = (Integer)object;
                n11 = (Integer)object;
                int n12 = -1 << -1;
                if (n11 == n12) break block19;
                object = "updateHoveredVirtualView";
                Object[] objectArray = new Class[n10];
                Class<Integer> clazz = Integer.TYPE;
                objectArray[0] = clazz;
                object = ((Class)object2).getDeclaredMethod((String)object, (Class<?>[])objectArray);
                ((Method)object).setAccessible(n10 != 0);
                object2 = this.touchHelper;
                objectArray = new Object[n10];
                object3 = n12;
                objectArray[0] = object3;
                try {
                    ((Method)object).invoke(object2, objectArray);
                    return n10 != 0;
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    Log.e((String)string3, (String)string2, (Throwable)noSuchFieldException);
                }
                catch (InvocationTargetException invocationTargetException) {
                    Log.e((String)string3, (String)string2, (Throwable)invocationTargetException);
                }
                catch (IllegalAccessException illegalAccessException) {
                    Log.e((String)string3, (String)string2, (Throwable)illegalAccessException);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    Log.e((String)string3, (String)string2, (Throwable)noSuchMethodException);
                }
            }
        }
        return false;
    }

    private boolean hasCloseIcon() {
        boolean bl2;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && (chipDrawable = chipDrawable.getCloseIcon()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            chipDrawable = null;
        }
        return bl2;
    }

    private void initOutlineProvider() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            Chip$2 chip$2 = new Chip$2(this);
            this.setOutlineProvider(chip$2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean moveFocus(boolean n10) {
        this.ensureFocus();
        boolean bl2 = true;
        int n11 = -1;
        if (n10 != 0) {
            n10 = this.focusedVirtualView;
            if (n10 != n11) return false;
            this.setFocusedVirtualView(0);
            return bl2;
        } else {
            n10 = this.focusedVirtualView;
            if (n10 != 0) return false;
            this.setFocusedVirtualView(n11);
        }
        return bl2;
    }

    private void setCloseIconFocused(boolean bl2) {
        boolean bl3 = this.closeIconFocused;
        if (bl3 != bl2) {
            this.closeIconFocused = bl2;
            this.refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean bl2) {
        boolean bl3 = this.closeIconHovered;
        if (bl3 != bl2) {
            this.closeIconHovered = bl2;
            this.refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean bl2) {
        boolean bl3 = this.closeIconPressed;
        if (bl3 != bl2) {
            this.closeIconPressed = bl2;
            this.refreshDrawableState();
        }
    }

    private void setFocusedVirtualView(int n10) {
        int n11 = this.focusedVirtualView;
        if (n11 != n10) {
            if (n11 == 0) {
                n11 = 0;
                this.setCloseIconFocused(false);
            }
            this.focusedVirtualView = n10;
            if (n10 == 0) {
                n10 = 1;
                this.setCloseIconFocused(n10 != 0);
            }
        }
    }

    private void unapplyChipDrawable(ChipDrawable chipDrawable) {
        if (chipDrawable != null) {
            chipDrawable.setDelegate(null);
        }
    }

    private void updatePaddingInternal() {
        Object object = this.getText();
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0 && (object = this.chipDrawable) != null) {
            float f10;
            ChipDrawable chipDrawable;
            float f11;
            float f12 = ((ChipDrawable)object).getChipStartPadding();
            float f13 = this.chipDrawable.getChipEndPadding();
            f12 += f13;
            f13 = this.chipDrawable.getTextStartPadding();
            f12 += f13;
            f13 = this.chipDrawable.getTextEndPadding();
            f12 += f13;
            ChipDrawable chipDrawable2 = this.chipDrawable;
            int n11 = chipDrawable2.isChipIconVisible();
            if (n11 != 0 && (chipDrawable2 = this.chipDrawable.getChipIcon()) != null || (chipDrawable2 = this.chipDrawable.getCheckedIcon()) != null && (n11 = (chipDrawable2 = this.chipDrawable).isCheckedIconVisible()) != 0 && (n11 = this.isChecked()) != 0) {
                chipDrawable2 = this.chipDrawable;
                f13 = chipDrawable2.getIconStartPadding();
                f11 = this.chipDrawable.getIconEndPadding();
                f13 += f11;
                chipDrawable = this.chipDrawable;
                f11 = chipDrawable.getChipIconSize();
                f12 += (f13 += f11);
            }
            if ((n11 = (chipDrawable2 = this.chipDrawable).isCloseIconVisible()) != 0 && (chipDrawable2 = this.chipDrawable.getCloseIcon()) != null) {
                chipDrawable2 = this.chipDrawable;
                f13 = chipDrawable2.getCloseIconStartPadding();
                f11 = this.chipDrawable.getCloseIconEndPadding();
                f13 += f11;
                chipDrawable = this.chipDrawable;
                f11 = chipDrawable.getCloseIconSize();
                f12 += (f13 += f11);
            }
            if ((n11 = (f10 = (f13 = (float)ViewCompat.getPaddingEnd((View)this)) - f12) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) != 0) {
                n11 = ViewCompat.getPaddingStart((View)this);
                int n12 = this.getPaddingTop();
                n10 = (int)f12;
                int n13 = this.getPaddingBottom();
                ViewCompat.setPaddingRelative((View)this, n11, n12, n10, n13);
            }
        }
    }

    private void updateTextPaintDrawState(TextAppearance textAppearance) {
        TextPaint textPaint = this.getPaint();
        Object object = this.chipDrawable.getState();
        textPaint.drawableState = object;
        object = this.getContext();
        ResourcesCompat$FontCallback resourcesCompat$FontCallback = this.fontCallback;
        textAppearance.updateDrawState((Context)object, textPaint, resourcesCompat$FontCallback);
    }

    private void validateAttributes(AttributeSet object) {
        if (object == null) {
            return;
        }
        String string2 = NAMESPACE_ANDROID;
        String string3 = object.getAttributeValue(string2, "background");
        if (string3 == null) {
            string3 = object.getAttributeValue(string2, "drawableLeft");
            if (string3 == null) {
                string3 = object.getAttributeValue(string2, "drawableStart");
                if (string3 == null) {
                    string3 = object.getAttributeValue(string2, "drawableEnd");
                    String string4 = "Please set end drawable using R.attr#closeIcon.";
                    if (string3 == null) {
                        string3 = object.getAttributeValue(string2, "drawableRight");
                        if (string3 == null) {
                            string3 = "singleLine";
                            int n10 = 1;
                            int n11 = object.getAttributeBooleanValue(string2, string3, n10 != 0);
                            if (n11 != 0 && (n11 = object.getAttributeIntValue(string2, string3 = "lines", n10)) == n10 && (n11 = object.getAttributeIntValue(string2, string3 = "minLines", n10)) == n10 && (n11 = object.getAttributeIntValue(string2, string3 = "maxLines", n10)) == n10) {
                                string3 = "gravity";
                                n10 = 8388627;
                                int n12 = object.getAttributeIntValue(string2, string3, n10);
                                if (n12 != n10) {
                                    object = TAG;
                                    string2 = "Chip text must be vertically center and start aligned";
                                    Log.w((String)object, (String)string2);
                                }
                                return;
                            }
                            object = new UnsupportedOperationException("Chip does not support multi-line text");
                            throw object;
                        }
                        object = new UnsupportedOperationException(string4);
                        throw object;
                    }
                    object = new UnsupportedOperationException(string4);
                    throw object;
                }
                object = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
                throw object;
            }
            object = new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            throw object;
        }
        object = new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
        throw object;
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean bl2;
        Chip$ChipTouchHelper chip$ChipTouchHelper;
        boolean bl3 = this.handleAccessibilityExit(motionEvent);
        if (!(bl3 || (bl3 = (chip$ChipTouchHelper = this.touchHelper).dispatchHoverEvent(motionEvent)) || (bl2 = super.dispatchHoverEvent(motionEvent)))) {
            bl2 = false;
            motionEvent = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl2;
        Chip$ChipTouchHelper chip$ChipTouchHelper = this.touchHelper;
        boolean bl3 = chip$ChipTouchHelper.dispatchKeyEvent(keyEvent);
        if (!bl3 && !(bl2 = super.dispatchKeyEvent(keyEvent))) {
            bl2 = false;
            keyEvent = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void drawableStateChanged() {
        boolean bl2;
        super.drawableStateChanged();
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && (bl2 = chipDrawable.isCloseIconStateful())) {
            chipDrawable = this.chipDrawable;
            int[] nArray = this.createCloseIconDrawableState();
            bl2 = chipDrawable.setCloseIconState(nArray);
        } else {
            bl2 = false;
            chipDrawable = null;
        }
        if (bl2) {
            this.invalidate();
        }
    }

    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable = this.chipDrawable;
        chipDrawable = chipDrawable != null ? chipDrawable.getCheckedIcon() : null;
        return chipDrawable;
    }

    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable = this.chipDrawable;
        chipDrawable = chipDrawable != null ? chipDrawable.getChipBackgroundColor() : null;
        return chipDrawable;
    }

    public float getChipCornerRadius() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getChipCornerRadius();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getChipEndPadding();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public Drawable getChipIcon() {
        ChipDrawable chipDrawable = this.chipDrawable;
        chipDrawable = chipDrawable != null ? chipDrawable.getChipIcon() : null;
        return chipDrawable;
    }

    public float getChipIconSize() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getChipIconSize();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable = this.chipDrawable;
        chipDrawable = chipDrawable != null ? chipDrawable.getChipIconTint() : null;
        return chipDrawable;
    }

    public float getChipMinHeight() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getChipMinHeight();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public float getChipStartPadding() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getChipStartPadding();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable = this.chipDrawable;
        chipDrawable = chipDrawable != null ? chipDrawable.getChipStrokeColor() : null;
        return chipDrawable;
    }

    public float getChipStrokeWidth() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getChipStrokeWidth();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public CharSequence getChipText() {
        return this.getText();
    }

    public Drawable getCloseIcon() {
        ChipDrawable chipDrawable = this.chipDrawable;
        chipDrawable = chipDrawable != null ? chipDrawable.getCloseIcon() : null;
        return chipDrawable;
    }

    public CharSequence getCloseIconContentDescription() {
        Object object = this.chipDrawable;
        object = object != null ? ((ChipDrawable)object).getCloseIconContentDescription() : null;
        return object;
    }

    public float getCloseIconEndPadding() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getCloseIconEndPadding();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public float getCloseIconSize() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getCloseIconSize();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public float getCloseIconStartPadding() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getCloseIconStartPadding();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable = this.chipDrawable;
        chipDrawable = chipDrawable != null ? chipDrawable.getCloseIconTint() : null;
        return chipDrawable;
    }

    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable = this.chipDrawable;
        chipDrawable = chipDrawable != null ? chipDrawable.getEllipsize() : null;
        return chipDrawable;
    }

    public void getFocusedRect(Rect rect) {
        int n10 = this.focusedVirtualView;
        if (n10 == 0) {
            Rect rect2 = this.getCloseIconTouchBoundsInt();
            rect.set(rect2);
        } else {
            super.getFocusedRect(rect);
        }
    }

    public MotionSpec getHideMotionSpec() {
        Object object = this.chipDrawable;
        object = object != null ? ((ChipDrawable)object).getHideMotionSpec() : null;
        return object;
    }

    public float getIconEndPadding() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getIconEndPadding();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public float getIconStartPadding() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getIconStartPadding();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable = this.chipDrawable;
        chipDrawable = chipDrawable != null ? chipDrawable.getRippleColor() : null;
        return chipDrawable;
    }

    public MotionSpec getShowMotionSpec() {
        Object object = this.chipDrawable;
        object = object != null ? ((ChipDrawable)object).getShowMotionSpec() : null;
        return object;
    }

    public CharSequence getText() {
        Object object = this.chipDrawable;
        object = object != null ? ((ChipDrawable)object).getText() : "";
        return object;
    }

    public float getTextEndPadding() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getTextEndPadding();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public float getTextStartPadding() {
        float f10;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            f10 = chipDrawable.getTextStartPadding();
        } else {
            f10 = 0.0f;
            chipDrawable = null;
        }
        return f10;
    }

    public boolean isCheckable() {
        boolean bl2;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && (bl2 = chipDrawable.isCheckable())) {
            bl2 = true;
        } else {
            bl2 = false;
            chipDrawable = null;
        }
        return bl2;
    }

    public boolean isCheckedIconEnabled() {
        return this.isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        boolean bl2;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && (bl2 = chipDrawable.isCheckedIconVisible())) {
            bl2 = true;
        } else {
            bl2 = false;
            chipDrawable = null;
        }
        return bl2;
    }

    public boolean isChipIconEnabled() {
        return this.isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        boolean bl2;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && (bl2 = chipDrawable.isChipIconVisible())) {
            bl2 = true;
        } else {
            bl2 = false;
            chipDrawable = null;
        }
        return bl2;
    }

    public boolean isCloseIconEnabled() {
        return this.isCloseIconVisible();
    }

    public boolean isCloseIconVisible() {
        boolean bl2;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && (bl2 = chipDrawable.isCloseIconVisible())) {
            bl2 = true;
        } else {
            bl2 = false;
            chipDrawable = null;
        }
        return bl2;
    }

    public void onChipDrawableSizeChange() {
        this.updatePaddingInternal();
        this.requestLayout();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            this.invalidateOutline();
        }
    }

    public int[] onCreateDrawableState(int n10) {
        int[] nArray = super.onCreateDrawableState(++n10);
        boolean bl2 = this.isChecked();
        if (bl2) {
            int[] nArray2 = SELECTED_STATE;
            CheckBox.mergeDrawableStates((int[])nArray, (int[])nArray2);
        }
        return nArray;
    }

    public void onDraw(Canvas canvas) {
        Object object = this.getText();
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0 && (object = this.chipDrawable) != null && (n10 = ((ChipDrawable)object).shouldDrawText()) == 0) {
            n10 = canvas.save();
            ChipDrawable chipDrawable = this.chipDrawable;
            float f10 = this.calculateTextOffsetFromStart(chipDrawable);
            canvas.translate(f10, 0.0f);
            super.onDraw(canvas);
            canvas.restoreToCount(n10);
            return;
        }
        super.onDraw(canvas);
    }

    public void onFocusChanged(boolean bl2, int n10, Rect rect) {
        if (bl2) {
            int n11 = -1;
            this.setFocusedVirtualView(n11);
        } else {
            int n12 = -1 << -1;
            this.setFocusedVirtualView(n12);
        }
        this.invalidate();
        super.onFocusChanged(bl2, n10, rect);
        this.touchHelper.onFocusChanged(bl2, n10, rect);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int bl2 = motionEvent.getActionMasked();
        int n10 = 7;
        float f10 = 9.8E-45f;
        if (bl2 != n10) {
            int n11 = 10;
            f10 = 1.4E-44f;
            if (bl2 == n11) {
                boolean bl3 = false;
                Object var5_8 = null;
                this.setCloseIconHovered(false);
            }
        } else {
            RectF rectF = this.getCloseIconTouchBounds();
            f10 = motionEvent.getX();
            float f11 = motionEvent.getY();
            boolean bl4 = rectF.contains(f10, f11);
            this.setCloseIconHovered(bl4);
        }
        return super.onHoverEvent(motionEvent);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onKeyDown(int var1_1, KeyEvent var2_2) {
        block13: {
            block12: {
                var3_3 = var2_2.getKeyCode();
                var4_4 = 61 != 0;
                var5_5 = false;
                var6_6 = true;
                if (var3_3 == var4_4) break block12;
                var4_4 = 66 != 0;
                if (var3_3 == var4_4) ** GOTO lbl-1000
                switch (var3_3) {
                    default: {
                        break block13;
                    }
                    case 22: {
                        var3_3 = var2_2.hasNoModifiers();
                        if (var3_3) {
                            var3_3 = ViewUtils.isLayoutRtl((View)this) ^ var6_6;
                            var5_5 = this.moveFocus(var3_3);
                        }
                        break block13;
                    }
                    case 21: {
                        var3_3 = var2_2.hasNoModifiers();
                        if (var3_3) {
                            var3_3 = ViewUtils.isLayoutRtl((View)this);
                            var5_5 = this.moveFocus(var3_3);
                        }
                        break block13;
                    }
                    case 23: lbl-1000:
                    // 2 sources

                    {
                        if ((var3_3 = this.focusedVirtualView) == (var4_4 = -1 != 0)) ** GOTO lbl30
                        if (!var3_3) {
                            this.performCloseIconClick();
                            return var6_6;
                        }
                        break block13;
lbl30:
                        // 1 sources

                        this.performClick();
                        return var6_6;
                    }
                }
            }
            var3_3 = var2_2.hasNoModifiers();
            var3_3 = var3_3 != false ? 2 != 0 : ((var3_3 = (boolean)var2_2.hasModifiers((int)var6_6)) != false ? var6_6 : false);
            if (var3_3) {
                var7_7 = this.getParent();
                var8_8 = this;
                while ((var8_8 = var8_8.focusSearch((int)var3_3)) != null && var8_8 != this && (var9_9 = var8_8.getParent()) == var7_7) {
                }
                if (var8_8 != null) {
                    var8_8.requestFocus();
                    return var6_6;
                }
            }
        }
        if (var5_5) {
            this.invalidate();
            return var6_6;
        }
        return super.onKeyDown(var1_1, var2_2);
    }

    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int n10) {
        float f10;
        float f11;
        RectF rectF = this.getCloseIconTouchBounds();
        boolean bl2 = rectF.contains(f11 = motionEvent.getX(), f10 = motionEvent.getY());
        if (bl2 && (bl2 = this.isEnabled())) {
            return PointerIcon.getSystemIcon((Context)this.getContext(), (int)1002);
        }
        return null;
    }

    /*
     * Unable to fully structure code
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block9: {
            block6: {
                block7: {
                    block8: {
                        var2_2 = var1_1.getActionMasked();
                        var3_3 = this.getCloseIconTouchBounds();
                        var4_4 = var1_1.getX();
                        var5_5 = var1_1.getY();
                        var6_6 = var3_3.contains(var4_4, var5_5);
                        var7_7 = 0;
                        var4_4 = 0.0f;
                        var8_8 = 1;
                        var5_5 = 1.4E-45f;
                        if (var2_2 == 0) break block6;
                        if (var2_2 == var8_8) break block7;
                        var9_9 = 2;
                        if (var2_2 == var9_9) break block8;
                        var6_6 = 3;
                        if (var2_2 == var6_6) ** GOTO lbl-1000
                        ** GOTO lbl-1000
                    }
                    var2_2 = (int)this.closeIconPressed;
                    if (var2_2 == 0) ** GOTO lbl-1000
                    if (var6_6 == 0) {
                        this.setCloseIconPressed(false);
                    }
                    ** GOTO lbl36
                }
                var2_2 = this.closeIconPressed;
                if (var2_2 != 0) {
                    this.performCloseIconClick();
                    var2_2 = var8_8;
                } else lbl-1000:
                // 2 sources

                {
                    var2_2 = 0;
                }
                this.setCloseIconPressed(false);
                break block9;
            }
            if (var6_6 != 0) {
                this.setCloseIconPressed((boolean)var8_8);
lbl36:
                // 2 sources

                var2_2 = var8_8;
            } else lbl-1000:
            // 3 sources

            {
                var2_2 = 0;
            }
        }
        if (var2_2 != 0 || (var10_10 = super.onTouchEvent(var1_1))) {
            var7_7 = var8_8;
            var4_4 = var5_5;
        }
        return (boolean)var7_7;
    }

    public boolean performCloseIconClick() {
        boolean bl2;
        this.playSoundEffect(0);
        View.OnClickListener onClickListener = this.onCloseIconClickListener;
        boolean bl3 = true;
        if (onClickListener != null) {
            onClickListener.onClick((View)this);
            bl2 = bl3;
        } else {
            bl2 = false;
            onClickListener = null;
        }
        this.touchHelper.sendEventForVirtualView(0, (int)(bl3 ? 1 : 0));
        return bl2;
    }

    public void setBackground(Drawable object) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (object != chipDrawable && object != (chipDrawable = this.ripple)) {
            object = new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
            throw object;
        }
        super.setBackground(object);
    }

    public void setBackgroundColor(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
        throw unsupportedOperationException;
    }

    public void setBackgroundDrawable(Drawable object) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (object != chipDrawable && object != (chipDrawable = this.ripple)) {
            object = new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
            throw object;
        }
        super.setBackgroundDrawable((Drawable)object);
    }

    public void setBackgroundResource(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
        throw unsupportedOperationException;
    }

    public void setBackgroundTintList(ColorStateList object) {
        object = new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
        throw object;
    }

    public void setBackgroundTintMode(PorterDuff.Mode object) {
        object = new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
        throw object;
    }

    public void setCheckable(boolean bl2) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckable(bl2);
        }
    }

    public void setCheckableResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckableResource(n10);
        }
    }

    public void setChecked(boolean bl2) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) {
            this.deferredCheckedValue = bl2;
        } else {
            boolean bl3 = chipDrawable.isCheckable();
            if (bl3) {
                bl3 = this.isChecked();
                super.setChecked(bl2);
                if (bl3 != bl2 && (chipDrawable = this.onCheckedChangeListenerInternal) != null) {
                    chipDrawable.onCheckedChanged((CompoundButton)this, bl2);
                }
            }
        }
    }

    public void setCheckedIcon(Drawable drawable2) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIcon(drawable2);
        }
    }

    public void setCheckedIconEnabled(boolean bl2) {
        this.setCheckedIconVisible(bl2);
    }

    public void setCheckedIconEnabledResource(int n10) {
        this.setCheckedIconVisible(n10);
    }

    public void setCheckedIconResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconResource(n10);
        }
    }

    public void setCheckedIconVisible(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconVisible(n10);
        }
    }

    public void setCheckedIconVisible(boolean bl2) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconVisible(bl2);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipBackgroundColor(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipBackgroundColorResource(n10);
        }
    }

    public void setChipCornerRadius(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipCornerRadius(f10);
        }
    }

    public void setChipCornerRadiusResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipCornerRadiusResource(n10);
        }
    }

    public void setChipDrawable(ChipDrawable chipDrawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != chipDrawable) {
            this.unapplyChipDrawable(chipDrawable2);
            this.chipDrawable = chipDrawable;
            this.applyChipDrawable(chipDrawable);
            boolean bl2 = RippleUtils.USE_FRAMEWORK_RIPPLE;
            if (bl2) {
                chipDrawable2 = RippleUtils.convertToRippleDrawableColor(this.chipDrawable.getRippleColor());
                ChipDrawable chipDrawable3 = this.chipDrawable;
                chipDrawable = new RippleDrawable((ColorStateList)chipDrawable2, (Drawable)chipDrawable3, null);
                this.ripple = chipDrawable;
                chipDrawable = this.chipDrawable;
                boolean bl3 = false;
                chipDrawable2 = null;
                chipDrawable.setUseCompatRipple(false);
                chipDrawable = this.ripple;
                ViewCompat.setBackground((View)this, chipDrawable);
            } else {
                chipDrawable = this.chipDrawable;
                boolean bl4 = true;
                chipDrawable.setUseCompatRipple(bl4);
                chipDrawable = this.chipDrawable;
                ViewCompat.setBackground((View)this, chipDrawable);
            }
        }
    }

    public void setChipEndPadding(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipEndPadding(f10);
        }
    }

    public void setChipEndPaddingResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipEndPaddingResource(n10);
        }
    }

    public void setChipIcon(Drawable drawable2) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIcon(drawable2);
        }
    }

    public void setChipIconEnabled(boolean bl2) {
        this.setChipIconVisible(bl2);
    }

    public void setChipIconEnabledResource(int n10) {
        this.setChipIconVisible(n10);
    }

    public void setChipIconResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconResource(n10);
        }
    }

    public void setChipIconSize(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconSize(f10);
        }
    }

    public void setChipIconSizeResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconSizeResource(n10);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconTint(colorStateList);
        }
    }

    public void setChipIconTintResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconTintResource(n10);
        }
    }

    public void setChipIconVisible(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconVisible(n10);
        }
    }

    public void setChipIconVisible(boolean bl2) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconVisible(bl2);
        }
    }

    public void setChipMinHeight(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipMinHeight(f10);
        }
    }

    public void setChipMinHeightResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipMinHeightResource(n10);
        }
    }

    public void setChipStartPadding(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStartPadding(f10);
        }
    }

    public void setChipStartPaddingResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStartPaddingResource(n10);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeColor(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeColorResource(n10);
        }
    }

    public void setChipStrokeWidth(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeWidth(f10);
        }
    }

    public void setChipStrokeWidthResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeWidthResource(n10);
        }
    }

    public void setChipText(CharSequence charSequence) {
        this.setText(charSequence);
    }

    public void setChipTextResource(int n10) {
        String string2 = this.getResources().getString(n10);
        this.setText(string2);
    }

    public void setCloseIcon(Drawable drawable2) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIcon(drawable2);
        }
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconContentDescription(charSequence);
        }
    }

    public void setCloseIconEnabled(boolean bl2) {
        this.setCloseIconVisible(bl2);
    }

    public void setCloseIconEnabledResource(int n10) {
        this.setCloseIconVisible(n10);
    }

    public void setCloseIconEndPadding(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconEndPadding(f10);
        }
    }

    public void setCloseIconEndPaddingResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconEndPaddingResource(n10);
        }
    }

    public void setCloseIconResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconResource(n10);
        }
    }

    public void setCloseIconSize(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconSize(f10);
        }
    }

    public void setCloseIconSizeResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconSizeResource(n10);
        }
    }

    public void setCloseIconStartPadding(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconStartPadding(f10);
        }
    }

    public void setCloseIconStartPaddingResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconStartPaddingResource(n10);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconTint(colorStateList);
        }
    }

    public void setCloseIconTintResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconTintResource(n10);
        }
    }

    public void setCloseIconVisible(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconVisible(n10);
        }
    }

    public void setCloseIconVisible(boolean bl2) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconVisible(bl2);
        }
    }

    public void setCompoundDrawables(Drawable object, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (object == null) {
            if (drawable3 == null) {
                super.setCompoundDrawables(object, drawable2, drawable3, drawable4);
                return;
            }
            object = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            throw object;
        }
        object = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        throw object;
    }

    public void setCompoundDrawablesRelative(Drawable object, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (object == null) {
            if (drawable3 == null) {
                super.setCompoundDrawablesRelative(object, drawable2, drawable3, drawable4);
                return;
            }
            object = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            throw object;
        }
        object = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        throw object;
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int n10, int n11, int n12, int n13) {
        if (n10 == 0) {
            if (n12 == 0) {
                super.setCompoundDrawablesRelativeWithIntrinsicBounds(n10, n11, n12, n13);
                return;
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            throw unsupportedOperationException;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        throw unsupportedOperationException;
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable object, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (object == null) {
            if (drawable3 == null) {
                super.setCompoundDrawablesRelativeWithIntrinsicBounds(object, drawable2, drawable3, drawable4);
                return;
            }
            object = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            throw object;
        }
        object = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        throw object;
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int n10, int n11, int n12, int n13) {
        if (n10 == 0) {
            if (n12 == 0) {
                super.setCompoundDrawablesWithIntrinsicBounds(n10, n11, n12, n13);
                return;
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            throw unsupportedOperationException;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        throw unsupportedOperationException;
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable object, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (object == null) {
            if (drawable3 == null) {
                super.setCompoundDrawablesWithIntrinsicBounds(object, drawable2, drawable3, drawable4);
                return;
            }
            object = new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
            throw object;
        }
        object = new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        throw object;
    }

    public void setEllipsize(TextUtils.TruncateAt object) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) {
            return;
        }
        chipDrawable = TextUtils.TruncateAt.MARQUEE;
        if (object != chipDrawable) {
            super.setEllipsize(object);
            chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                chipDrawable.setEllipsize((TextUtils.TruncateAt)object);
            }
            return;
        }
        object = new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        throw object;
    }

    public void setGravity(int n10) {
        int n11 = 8388627;
        if (n10 != n11) {
            String string2 = TAG;
            String string3 = "Chip text must be vertically center and start aligned";
            Log.w((String)string2, (String)string3);
        } else {
            super.setGravity(n10);
        }
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setHideMotionSpec(motionSpec);
        }
    }

    public void setHideMotionSpecResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setHideMotionSpecResource(n10);
        }
    }

    public void setIconEndPadding(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setIconEndPadding(f10);
        }
    }

    public void setIconEndPaddingResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setIconEndPaddingResource(n10);
        }
    }

    public void setIconStartPadding(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setIconStartPadding(f10);
        }
    }

    public void setIconStartPaddingResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setIconStartPaddingResource(n10);
        }
    }

    public void setLines(int n10) {
        int n11 = 1;
        if (n10 <= n11) {
            super.setLines(n10);
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Chip does not support multi-line text");
        throw unsupportedOperationException;
    }

    public void setMaxLines(int n10) {
        int n11 = 1;
        if (n10 <= n11) {
            super.setMaxLines(n10);
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Chip does not support multi-line text");
        throw unsupportedOperationException;
    }

    public void setMaxWidth(int n10) {
        super.setMaxWidth(n10);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setMaxWidth(n10);
        }
    }

    public void setMinLines(int n10) {
        int n11 = 1;
        if (n10 <= n11) {
            super.setMinLines(n10);
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Chip does not support multi-line text");
        throw unsupportedOperationException;
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListenerInternal = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.onCloseIconClickListener = onClickListener;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setRippleColor(colorStateList);
        }
    }

    public void setRippleColorResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setRippleColorResource(n10);
        }
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setShowMotionSpec(motionSpec);
        }
    }

    public void setShowMotionSpecResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setShowMotionSpecResource(n10);
        }
    }

    public void setSingleLine(boolean bl2) {
        if (bl2) {
            super.setSingleLine(bl2);
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Chip does not support multi-line text");
        throw unsupportedOperationException;
    }

    public void setText(CharSequence charSequence, TextView.BufferType object) {
        Object object2 = this.chipDrawable;
        if (object2 == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        object2 = BidiFormatter.getInstance().unicodeWrap(charSequence);
        ChipDrawable chipDrawable = this.chipDrawable;
        boolean bl2 = chipDrawable.shouldDrawText();
        if (bl2) {
            object2 = null;
        }
        super.setText((CharSequence)object2, (TextView.BufferType)object);
        object = this.chipDrawable;
        if (object != null) {
            ((ChipDrawable)object).setText(charSequence);
        }
    }

    public void setTextAppearance(int n10) {
        TextAppearance textAppearance;
        super.setTextAppearance(n10);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearanceResource(n10);
        }
        if ((textAppearance = this.getTextAppearance()) != null) {
            textAppearance = this.getTextAppearance();
            chipDrawable = this.getContext();
            TextPaint textPaint = this.getPaint();
            ResourcesCompat$FontCallback resourcesCompat$FontCallback = this.fontCallback;
            textAppearance.updateMeasureState((Context)chipDrawable, textPaint, resourcesCompat$FontCallback);
            textAppearance = this.getTextAppearance();
            this.updateTextPaintDrawState(textAppearance);
        }
    }

    public void setTextAppearance(Context object, int n10) {
        TextAppearance textAppearance;
        super.setTextAppearance(object, n10);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearanceResource(n10);
        }
        if ((textAppearance = this.getTextAppearance()) != null) {
            textAppearance = this.getTextAppearance();
            chipDrawable = this.getPaint();
            ResourcesCompat$FontCallback resourcesCompat$FontCallback = this.fontCallback;
            textAppearance.updateMeasureState((Context)object, (TextPaint)chipDrawable, resourcesCompat$FontCallback);
            object = this.getTextAppearance();
            this.updateTextPaintDrawState((TextAppearance)object);
        }
    }

    public void setTextAppearance(TextAppearance textAppearance) {
        Object object = this.chipDrawable;
        if (object != null) {
            ((ChipDrawable)object).setTextAppearance(textAppearance);
        }
        if ((object = this.getTextAppearance()) != null) {
            object = this.getTextAppearance();
            Context context = this.getContext();
            TextPaint textPaint = this.getPaint();
            ResourcesCompat$FontCallback resourcesCompat$FontCallback = this.fontCallback;
            ((TextAppearance)object).updateMeasureState(context, textPaint, resourcesCompat$FontCallback);
            this.updateTextPaintDrawState(textAppearance);
        }
    }

    public void setTextAppearanceResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearanceResource(n10);
        }
        chipDrawable = this.getContext();
        this.setTextAppearance((Context)chipDrawable, n10);
    }

    public void setTextEndPadding(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextEndPadding(f10);
        }
    }

    public void setTextEndPaddingResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextEndPaddingResource(n10);
        }
    }

    public void setTextStartPadding(float f10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextStartPadding(f10);
        }
    }

    public void setTextStartPaddingResource(int n10) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextStartPaddingResource(n10);
        }
    }
}

