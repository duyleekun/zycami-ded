/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.EditText
 *  android.widget.TextView
 */
package l.a.k.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import l.a.j.a.d;
import l.a.k.d.h;
import l.a.q.b;
import l.a.q.j;
import l.a.q.z;
import skin.support.design.R$color;
import skin.support.design.R$style;
import skin.support.design.R$styleable;

public class i
extends TextInputLayout
implements z {
    private b a;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;

    public i(Context context) {
        this(context, null);
    }

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        Object object = new b((View)this);
        this.a = object;
        ((b)object).c(attributeSet, n10);
        object = R$styleable.TextInputLayout;
        int n11 = R$style.Widget_Design_TextInputLayout;
        context = context.obtainStyledAttributes(attributeSet, (int[])object, n10, n11);
        int n12 = R$styleable.TextInputLayout_android_textColorHint;
        n10 = (int)(context.hasValue(n12) ? 1 : 0);
        if (n10 != 0) {
            this.e = n12 = context.getResourceId(n12, 0);
            this.f = n12;
            this.c();
        }
        n12 = R$styleable.TextInputLayout_errorTextAppearance;
        n12 = context.getResourceId(n12, 0);
        this.f(n12);
        n12 = R$styleable.TextInputLayout_counterTextAppearance;
        n12 = context.getResourceId(n12, 0);
        this.d(n12);
        n12 = R$styleable.TextInputLayout_passwordToggleDrawable;
        this.b = n12 = context.getResourceId(n12, 0);
        context.recycle();
    }

    private void a() {
        TextView textView;
        int n10;
        this.c = n10 = j.b(this.c);
        if (n10 != 0 && (textView = this.getCounterView()) != null) {
            Context context = this.getContext();
            int n11 = this.c;
            int n12 = l.a.j.a.d.c(context, n11);
            textView.setTextColor(n12);
            this.g();
        }
    }

    private void b() {
        TextView textView;
        int n10;
        int n11;
        this.d = n11 = j.b(this.d);
        if (n11 != 0 && n11 != (n10 = R$color.design_error) && (textView = this.getErrorView()) != null) {
            Context context = this.getContext();
            int n12 = this.d;
            n10 = l.a.j.a.d.c(context, n12);
            textView.setTextColor(n10);
            this.g();
        }
    }

    private void c() {
        int n10;
        int n11;
        this.e = n11 = j.b(this.e);
        if (n11 != 0 && n11 != (n10 = R$color.abc_hint_foreground_material_light)) {
            Context context = this.getContext();
            n10 = this.e;
            context = l.a.j.a.d.e(context, n10);
            this.setFocusedTextColor((ColorStateList)context);
        } else {
            EditText editText = this.getEditText();
            if (editText != null) {
                n11 = 0;
                editText = null;
                EditText editText2 = this.getEditText();
                n10 = editText2 instanceof l.a.q.h;
                if (n10 != 0) {
                    editText = (l.a.q.h)this.getEditText();
                    n11 = editText.getTextColorResId();
                } else {
                    editText2 = this.getEditText();
                    n10 = editText2 instanceof h;
                    if (n10 != 0) {
                        editText = (h)this.getEditText();
                        n11 = editText.getTextColorResId();
                    }
                }
                n11 = j.b(n11);
                if (n11 != 0) {
                    editText2 = this.getContext();
                    editText = l.a.j.a.d.e((Context)editText2, n11);
                    this.setFocusedTextColor((ColorStateList)editText);
                }
            }
        }
    }

    private void d(int n10) {
        if (n10 != 0) {
            int n11;
            int[] nArray;
            Context context = this.getContext();
            TypedArray typedArray = context.obtainStyledAttributes(n10, nArray = skin.support.R$styleable.SkinTextAppearance);
            boolean bl2 = typedArray.hasValue(n11 = skin.support.R$styleable.SkinTextAppearance_android_textColor);
            if (bl2) {
                bl2 = false;
                nArray = null;
                this.c = n11 = typedArray.getResourceId(n11, 0);
            }
            typedArray.recycle();
        }
        this.a();
    }

    private void f(int n10) {
        if (n10 != 0) {
            int n11;
            int[] nArray;
            Context context = this.getContext();
            TypedArray typedArray = context.obtainStyledAttributes(n10, nArray = skin.support.R$styleable.SkinTextAppearance);
            boolean bl2 = typedArray.hasValue(n11 = skin.support.R$styleable.SkinTextAppearance_android_textColor);
            if (bl2) {
                bl2 = false;
                nArray = null;
                this.d = n11 = typedArray.getResourceId(n11, 0);
            }
            typedArray.recycle();
        }
        this.b();
    }

    private void g() {
        Object object = TextInputLayout.class;
        Object[] objectArray = "updateEditTextBackground";
        Class[] classArray = new Class[]{};
        object = ((Class)object).getDeclaredMethod((String)objectArray, classArray);
        boolean bl2 = true;
        ((Method)object).setAccessible(bl2);
        objectArray = new Object[]{};
        try {
            ((Method)object).invoke(this, objectArray);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private TextView getCounterView() {
        boolean bl2;
        Object object = TextInputLayout.class;
        String string2 = "mCounterView";
        try {
            object = ((Class)object).getDeclaredField(string2);
            bl2 = true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        ((Field)object).setAccessible(bl2);
        object = ((Field)object).get(this);
        return (TextView)object;
    }

    private TextView getErrorView() {
        boolean bl2;
        Object object = TextInputLayout.class;
        String string2 = "mErrorView";
        try {
            object = ((Class)object).getDeclaredField(string2);
            bl2 = true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        ((Field)object).setAccessible(bl2);
        object = ((Field)object).get(this);
        return (TextView)object;
    }

    private void h() {
        Object object = TextInputLayout.class;
        Object[] objectArray = "updateLabelState";
        int n10 = 1;
        Class[] classArray = new Class[n10];
        Class<Boolean> clazz = Boolean.TYPE;
        classArray[0] = clazz;
        object = ((Class)object).getDeclaredMethod((String)objectArray, classArray);
        ((Method)object).setAccessible(n10 != 0);
        objectArray = new Object[n10];
        Boolean bl2 = Boolean.FALSE;
        objectArray[0] = bl2;
        try {
            ((Method)object).invoke(this, objectArray);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void setDefaultTextColor(ColorStateList colorStateList) {
        Object object = TextInputLayout.class;
        String string2 = "mDefaultTextColor";
        object = ((Class)object).getDeclaredField(string2);
        boolean bl2 = true;
        ((Field)object).setAccessible(bl2);
        try {
            ((Field)object).set(this, colorStateList);
            this.h();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void setFocusedTextColor(ColorStateList colorStateList) {
        Object object = TextInputLayout.class;
        String string2 = "mFocusedTextColor";
        object = ((Class)object).getDeclaredField(string2);
        boolean bl2 = true;
        ((Field)object).setAccessible(bl2);
        try {
            ((Field)object).set(this, colorStateList);
            this.h();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void e() {
        this.b();
        this.a();
        this.c();
        b b10 = this.a;
        if (b10 != null) {
            b10.a();
        }
    }

    public void setCounterEnabled(boolean bl2) {
        super.setCounterEnabled(bl2);
        if (bl2) {
            this.a();
        }
    }

    public void setErrorEnabled(boolean bl2) {
        super.setErrorEnabled(bl2);
        if (bl2) {
            this.b();
        }
    }

    public void setErrorTextAppearance(int n10) {
        super.setErrorTextAppearance(n10);
        this.f(n10);
    }
}

