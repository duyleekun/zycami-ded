/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.TypedValue
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.ResourcesCompat$FontCallback;

public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int n10, int[] nArray) {
        TypedArray typedArray = context.obtainStyledAttributes(n10, nArray);
        TintTypedArray tintTypedArray = new TintTypedArray(context, typedArray);
        return tintTypedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] nArray) {
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
        TintTypedArray tintTypedArray = new TintTypedArray(context, (TypedArray)attributeSet);
        return tintTypedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] nArray, int n10, int n11) {
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray, n10, n11);
        TintTypedArray tintTypedArray = new TintTypedArray(context, (TypedArray)attributeSet);
        return tintTypedArray;
    }

    public boolean getBoolean(int n10, boolean bl2) {
        return this.mWrapped.getBoolean(n10, bl2);
    }

    public int getChangingConfigurations() {
        return this.mWrapped.getChangingConfigurations();
    }

    public int getColor(int n10, int n11) {
        return this.mWrapped.getColor(n10, n11);
    }

    public ColorStateList getColorStateList(int n10) {
        TypedArray typedArray = this.mWrapped;
        int n11 = typedArray.hasValue(n10);
        if (n11 != 0) {
            typedArray = this.mWrapped;
            Context context = null;
            n11 = typedArray.getResourceId(n10, 0);
            if (n11 != 0 && (typedArray = AppCompatResources.getColorStateList(context = this.mContext, n11)) != null) {
                return typedArray;
            }
        }
        return this.mWrapped.getColorStateList(n10);
    }

    public float getDimension(int n10, float f10) {
        return this.mWrapped.getDimension(n10, f10);
    }

    public int getDimensionPixelOffset(int n10, int n11) {
        return this.mWrapped.getDimensionPixelOffset(n10, n11);
    }

    public int getDimensionPixelSize(int n10, int n11) {
        return this.mWrapped.getDimensionPixelSize(n10, n11);
    }

    public Drawable getDrawable(int n10) {
        TypedArray typedArray = this.mWrapped;
        int n11 = typedArray.hasValue(n10);
        if (n11 != 0 && (n11 = (typedArray = this.mWrapped).getResourceId(n10, 0)) != 0) {
            return AppCompatResources.getDrawable(this.mContext, n11);
        }
        return this.mWrapped.getDrawable(n10);
    }

    public Drawable getDrawableIfKnown(int n10) {
        Object object = this.mWrapped;
        boolean bl2 = object.hasValue(n10);
        if (bl2) {
            object = this.mWrapped;
            Context context = null;
            if ((n10 = object.getResourceId(n10, 0)) != 0) {
                object = AppCompatDrawableManager.get();
                context = this.mContext;
                return ((AppCompatDrawableManager)object).getDrawable(context, n10, true);
            }
        }
        return null;
    }

    public float getFloat(int n10, float f10) {
        return this.mWrapped.getFloat(n10, f10);
    }

    public Typeface getFont(int n10, int n11, ResourcesCompat$FontCallback resourcesCompat$FontCallback) {
        TypedArray typedArray = this.mWrapped;
        TypedValue typedValue = null;
        if ((n10 = typedArray.getResourceId(n10, 0)) == 0) {
            return null;
        }
        typedArray = this.mTypedValue;
        if (typedArray == null) {
            typedArray = new TypedValue();
            this.mTypedValue = typedArray;
        }
        typedArray = this.mContext;
        typedValue = this.mTypedValue;
        return ResourcesCompat.getFont((Context)typedArray, n10, typedValue, n11, resourcesCompat$FontCallback);
    }

    public float getFraction(int n10, int n11, int n12, float f10) {
        return this.mWrapped.getFraction(n10, n11, n12, f10);
    }

    public int getIndex(int n10) {
        return this.mWrapped.getIndex(n10);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int n10, int n11) {
        return this.mWrapped.getInt(n10, n11);
    }

    public int getInteger(int n10, int n11) {
        return this.mWrapped.getInteger(n10, n11);
    }

    public int getLayoutDimension(int n10, int n11) {
        return this.mWrapped.getLayoutDimension(n10, n11);
    }

    public int getLayoutDimension(int n10, String string2) {
        return this.mWrapped.getLayoutDimension(n10, string2);
    }

    public String getNonResourceString(int n10) {
        return this.mWrapped.getNonResourceString(n10);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int n10, int n11) {
        return this.mWrapped.getResourceId(n10, n11);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int n10) {
        return this.mWrapped.getString(n10);
    }

    public CharSequence getText(int n10) {
        return this.mWrapped.getText(n10);
    }

    public CharSequence[] getTextArray(int n10) {
        return this.mWrapped.getTextArray(n10);
    }

    public int getType(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            return this.mWrapped.getType(n10);
        }
        TypedValue typedValue = this.mTypedValue;
        if (typedValue == null) {
            this.mTypedValue = typedValue = new TypedValue();
        }
        typedValue = this.mWrapped;
        TypedValue typedValue2 = this.mTypedValue;
        typedValue.getValue(n10, typedValue2);
        return this.mTypedValue.type;
    }

    public boolean getValue(int n10, TypedValue typedValue) {
        return this.mWrapped.getValue(n10, typedValue);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int n10) {
        return this.mWrapped.hasValue(n10);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int n10) {
        return this.mWrapped.peekValue(n10);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }
}

