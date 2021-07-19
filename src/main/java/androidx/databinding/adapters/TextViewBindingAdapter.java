/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.text.InputFilter
 *  android.text.InputFilter$LengthFilter
 *  android.text.Spanned
 *  android.text.TextWatcher
 *  android.text.method.DialerKeyListener
 *  android.text.method.DigitsKeyListener
 *  android.text.method.KeyListener
 *  android.text.method.PasswordTransformationMethod
 *  android.text.method.TextKeyListener
 *  android.text.method.TextKeyListener$Capitalize
 *  android.text.method.TransformationMethod
 *  android.util.Log
 *  android.view.View
 *  android.widget.TextView
 *  android.widget.TextView$BufferType
 */
package androidx.databinding.adapters;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.DialerKeyListener;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TextKeyListener;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.ListenerUtil;
import androidx.databinding.adapters.TextViewBindingAdapter$1;
import androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged;
import androidx.databinding.adapters.TextViewBindingAdapter$BeforeTextChanged;
import androidx.databinding.adapters.TextViewBindingAdapter$OnTextChanged;
import androidx.databinding.library.baseAdapters.R$id;

public class TextViewBindingAdapter {
    public static final int DECIMAL = 5;
    public static final int INTEGER = 1;
    public static final int SIGNED = 3;
    private static final String TAG = "TextViewBindingAdapters";

    public static String getTextString(TextView textView) {
        return textView.getText().toString();
    }

    private static boolean haveContentsChanged(CharSequence charSequence, CharSequence charSequence2) {
        int n10;
        int n11 = 1;
        int n12 = charSequence == null ? n11 : 0;
        if (n12 != (n10 = charSequence2 == null ? n11 : 0)) {
            return n11 != 0;
        }
        if (charSequence == null) {
            return false;
        }
        n12 = charSequence.length();
        if (n12 != (n10 = charSequence2.length())) {
            return n11 != 0;
        }
        for (n10 = 0; n10 < n12; ++n10) {
            char c10;
            char c11 = charSequence.charAt(n10);
            if (c11 == (c10 = charSequence2.charAt(n10))) continue;
            return n11 != 0;
        }
        return false;
    }

    public static void setAutoText(TextView textView, boolean bl2) {
        int n10;
        KeyListener keyListener = textView.getKeyListener();
        TextKeyListener.Capitalize capitalize = TextKeyListener.Capitalize.NONE;
        if (keyListener != null) {
            n10 = keyListener.getInputType();
        } else {
            n10 = 0;
            keyListener = null;
        }
        int n11 = n10 & 0x1000;
        if (n11 != 0) {
            capitalize = TextKeyListener.Capitalize.CHARACTERS;
        } else {
            n11 = n10 & 0x2000;
            if (n11 != 0) {
                capitalize = TextKeyListener.Capitalize.WORDS;
            } else if ((n10 &= 0x4000) != 0) {
                capitalize = TextKeyListener.Capitalize.SENTENCES;
            }
        }
        TextKeyListener textKeyListener = TextKeyListener.getInstance((boolean)bl2, (TextKeyListener.Capitalize)capitalize);
        textView.setKeyListener((KeyListener)textKeyListener);
    }

    public static void setBufferType(TextView textView, TextView.BufferType bufferType) {
        CharSequence charSequence = textView.getText();
        textView.setText(charSequence, bufferType);
    }

    /*
     * WARNING - void declaration
     */
    public static void setCapitalize(TextView textView, TextKeyListener.Capitalize capitalize) {
        void var3_7;
        int n10;
        KeyListener keyListener = textView.getKeyListener();
        int n11 = keyListener.getInputType();
        n11 = n11 & (n10 = 32768);
        if (n11 != 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            keyListener = null;
        }
        capitalize = TextKeyListener.getInstance((boolean)var3_7, (TextKeyListener.Capitalize)capitalize);
        textView.setKeyListener((KeyListener)capitalize);
    }

    public static void setDigits(TextView textView, CharSequence charSequence) {
        if (charSequence != null) {
            charSequence = DigitsKeyListener.getInstance((String)charSequence.toString());
            textView.setKeyListener((KeyListener)charSequence);
        } else {
            charSequence = textView.getKeyListener();
            boolean bl2 = charSequence instanceof DigitsKeyListener;
            if (bl2) {
                bl2 = false;
                charSequence = null;
                textView.setKeyListener(null);
            }
        }
    }

    public static void setDrawableBottom(TextView textView, Drawable drawable2) {
        TextViewBindingAdapter.setIntrinsicBounds(drawable2);
        Drawable drawable3 = textView.getCompoundDrawables();
        Drawable drawable4 = drawable3[0];
        Drawable drawable5 = drawable3[1];
        drawable3 = drawable3[2];
        textView.setCompoundDrawables(drawable4, drawable5, drawable3, drawable2);
    }

    public static void setDrawableEnd(TextView textView, Drawable drawable2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 < n11) {
            TextViewBindingAdapter.setDrawableRight(textView, drawable2);
        } else {
            TextViewBindingAdapter.setIntrinsicBounds(drawable2);
            Drawable drawable3 = textView.getCompoundDrawablesRelative();
            n11 = 0;
            Drawable drawable4 = drawable3[0];
            int n12 = 1;
            Drawable drawable5 = drawable3[n12];
            int n13 = 3;
            drawable3 = drawable3[n13];
            textView.setCompoundDrawablesRelative(drawable4, drawable5, drawable2, drawable3);
        }
    }

    public static void setDrawableLeft(TextView textView, Drawable drawable2) {
        TextViewBindingAdapter.setIntrinsicBounds(drawable2);
        Drawable drawable3 = textView.getCompoundDrawables();
        Drawable drawable4 = drawable3[1];
        Drawable drawable5 = drawable3[2];
        drawable3 = drawable3[3];
        textView.setCompoundDrawables(drawable2, drawable4, drawable5, drawable3);
    }

    public static void setDrawableRight(TextView textView, Drawable drawable2) {
        TextViewBindingAdapter.setIntrinsicBounds(drawable2);
        Drawable drawable3 = textView.getCompoundDrawables();
        Drawable drawable4 = drawable3[0];
        Drawable drawable5 = drawable3[1];
        drawable3 = drawable3[3];
        textView.setCompoundDrawables(drawable4, drawable5, drawable2, drawable3);
    }

    public static void setDrawableStart(TextView textView, Drawable drawable2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 < n11) {
            TextViewBindingAdapter.setDrawableLeft(textView, drawable2);
        } else {
            TextViewBindingAdapter.setIntrinsicBounds(drawable2);
            Drawable drawable3 = textView.getCompoundDrawablesRelative();
            n11 = 1;
            Drawable drawable4 = drawable3[n11];
            int n12 = 2;
            Drawable drawable5 = drawable3[n12];
            int n13 = 3;
            drawable3 = drawable3[n13];
            textView.setCompoundDrawablesRelative(drawable2, drawable4, drawable5, drawable3);
        }
    }

    public static void setDrawableTop(TextView textView, Drawable drawable2) {
        TextViewBindingAdapter.setIntrinsicBounds(drawable2);
        Drawable drawable3 = textView.getCompoundDrawables();
        Drawable drawable4 = drawable3[0];
        Drawable drawable5 = drawable3[2];
        drawable3 = drawable3[3];
        textView.setCompoundDrawables(drawable4, drawable2, drawable5, drawable3);
    }

    public static void setImeActionLabel(TextView textView, int n10) {
        CharSequence charSequence = textView.getImeActionLabel();
        textView.setImeActionLabel(charSequence, n10);
    }

    public static void setImeActionLabel(TextView textView, CharSequence charSequence) {
        int n10 = textView.getImeActionId();
        textView.setImeActionLabel(charSequence, n10);
    }

    public static void setInputMethod(TextView textView, CharSequence charSequence) {
        String string2 = "Could not create input method: ";
        String string3 = TAG;
        Object object = charSequence.toString();
        object = Class.forName((String)object);
        object = ((Class)object).newInstance();
        object = (KeyListener)object;
        try {
            textView.setKeyListener((KeyListener)object);
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append((Object)charSequence);
            charSequence = ((StringBuilder)object).toString();
            Log.e((String)string3, (String)charSequence, (Throwable)illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append((Object)charSequence);
            charSequence = ((StringBuilder)object).toString();
            Log.e((String)string3, (String)charSequence, (Throwable)instantiationException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append((Object)charSequence);
            charSequence = ((StringBuilder)object).toString();
            Log.e((String)string3, (String)charSequence, (Throwable)classNotFoundException);
        }
    }

    private static void setIntrinsicBounds(Drawable drawable2) {
        if (drawable2 != null) {
            int n10 = drawable2.getIntrinsicWidth();
            int n11 = drawable2.getIntrinsicHeight();
            drawable2.setBounds(0, 0, n10, n11);
        }
    }

    public static void setLineSpacingExtra(TextView textView, float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            float f11 = textView.getLineSpacingMultiplier();
            textView.setLineSpacing(f10, f11);
        } else {
            n10 = 1065353216;
            float f12 = 1.0f;
            textView.setLineSpacing(f10, f12);
        }
    }

    public static void setLineSpacingMultiplier(TextView textView, float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            float f11 = textView.getLineSpacingExtra();
            textView.setLineSpacing(f11, f10);
        } else {
            n10 = 0;
            float f12 = 0.0f;
            textView.setLineSpacing(0.0f, f10);
        }
    }

    public static void setMaxLength(TextView textView, int n10) {
        InputFilter.LengthFilter lengthFilter = textView.getFilters();
        int n11 = 1;
        if (lengthFilter == null) {
            lengthFilter = new InputFilter[n11];
            InputFilter.LengthFilter lengthFilter2 = new InputFilter.LengthFilter(n10);
            lengthFilter[0] = lengthFilter2;
        } else {
            int n12;
            InputFilter.LengthFilter lengthFilter3;
            int n13;
            block7: {
                int n14;
                for (n13 = 0; n13 < (n14 = ((InputFilter[])lengthFilter).length); ++n13) {
                    lengthFilter3 = lengthFilter[n13];
                    n12 = lengthFilter3 instanceof InputFilter.LengthFilter;
                    if (n12 == 0) continue;
                    n12 = Build.VERSION.SDK_INT;
                    int n15 = 21;
                    if (n12 >= n15 && (n14 = (lengthFilter3 = (InputFilter.LengthFilter)lengthFilter3).getMax()) == n10) {
                        n14 = 0;
                        lengthFilter3 = null;
                    } else {
                        n14 = n11;
                    }
                    if (n14 != 0) {
                        lengthFilter[n13] = lengthFilter3 = new InputFilter.LengthFilter(n10);
                    }
                    n13 = n11;
                    break block7;
                }
                n13 = 0;
            }
            if (n13 == 0) {
                n13 = ((InputFilter[])lengthFilter).length + n11;
                lengthFilter3 = new InputFilter[n13];
                n12 = ((InputFilter[])lengthFilter).length;
                System.arraycopy(lengthFilter, 0, lengthFilter3, 0, n12);
                lengthFilter3[n13 -= n11] = lengthFilter = new InputFilter.LengthFilter(n10);
                lengthFilter = lengthFilter3;
            }
        }
        textView.setFilters((InputFilter[])lengthFilter);
    }

    /*
     * WARNING - void declaration
     */
    public static void setNumeric(TextView textView, int n10) {
        void var2_5;
        int bl2 = n10 & 3;
        boolean bl3 = true;
        if (bl2 != 0) {
            boolean bl4 = bl3;
        } else {
            boolean bl5 = false;
        }
        if ((n10 &= 5) == 0) {
            bl3 = false;
        }
        DigitsKeyListener digitsKeyListener = DigitsKeyListener.getInstance((boolean)var2_5, (boolean)bl3);
        textView.setKeyListener((KeyListener)digitsKeyListener);
    }

    public static void setPassword(TextView textView, boolean bl2) {
        if (bl2) {
            PasswordTransformationMethod passwordTransformationMethod = PasswordTransformationMethod.getInstance();
            textView.setTransformationMethod((TransformationMethod)passwordTransformationMethod);
        } else {
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            bl2 = transformationMethod instanceof PasswordTransformationMethod;
            if (bl2) {
                bl2 = false;
                transformationMethod = null;
                textView.setTransformationMethod(null);
            }
        }
    }

    public static void setPhoneNumber(TextView textView, boolean bl2) {
        if (bl2) {
            DialerKeyListener dialerKeyListener = DialerKeyListener.getInstance();
            textView.setKeyListener((KeyListener)dialerKeyListener);
        } else {
            KeyListener keyListener = textView.getKeyListener();
            bl2 = keyListener instanceof DialerKeyListener;
            if (bl2) {
                bl2 = false;
                keyListener = null;
                textView.setKeyListener(null);
            }
        }
    }

    public static void setShadowColor(TextView textView, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        float f10 = 2.24E-44f;
        if (n11 >= n12) {
            float f11 = textView.getShadowDx();
            f10 = textView.getShadowDy();
            float f12 = textView.getShadowRadius();
            textView.setShadowLayer(f12, f11, f10, n10);
        }
    }

    public static void setShadowDx(TextView textView, float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        float f11 = 2.24E-44f;
        if (n10 >= n11) {
            n10 = textView.getShadowColor();
            f11 = textView.getShadowDy();
            float f12 = textView.getShadowRadius();
            textView.setShadowLayer(f12, f10, f11, n10);
        }
    }

    public static void setShadowDy(TextView textView, float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        float f11 = 2.24E-44f;
        if (n10 >= n11) {
            n10 = textView.getShadowColor();
            f11 = textView.getShadowDx();
            float f12 = textView.getShadowRadius();
            textView.setShadowLayer(f12, f11, f10, n10);
        }
    }

    public static void setShadowRadius(TextView textView, float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        float f11 = 2.24E-44f;
        if (n10 >= n11) {
            n10 = textView.getShadowColor();
            f11 = textView.getShadowDx();
            float f12 = textView.getShadowDy();
            textView.setShadowLayer(f10, f11, f12, n10);
        }
    }

    public static void setText(TextView textView, CharSequence charSequence) {
        int n10;
        CharSequence charSequence2 = textView.getText();
        if (charSequence != charSequence2 && (charSequence != null || (n10 = charSequence2.length()) != 0)) {
            boolean bl2;
            boolean bl3;
            n10 = charSequence instanceof Spanned;
            if (n10 != 0 ? (bl3 = charSequence.equals(charSequence2)) : !(bl2 = TextViewBindingAdapter.haveContentsChanged(charSequence, charSequence2))) {
                return;
            }
            textView.setText(charSequence);
        }
    }

    public static void setTextSize(TextView textView, float f10) {
        textView.setTextSize(0, f10);
    }

    public static void setTextWatcher(TextView textView, TextViewBindingAdapter$BeforeTextChanged object, TextViewBindingAdapter$OnTextChanged textViewBindingAdapter$OnTextChanged, TextViewBindingAdapter$AfterTextChanged textViewBindingAdapter$AfterTextChanged, InverseBindingListener inverseBindingListener) {
        if (object == null && textViewBindingAdapter$AfterTextChanged == null && textViewBindingAdapter$OnTextChanged == null && inverseBindingListener == null) {
            object = null;
        } else {
            TextViewBindingAdapter$1 textViewBindingAdapter$1 = new TextViewBindingAdapter$1((TextViewBindingAdapter$BeforeTextChanged)object, textViewBindingAdapter$OnTextChanged, inverseBindingListener, textViewBindingAdapter$AfterTextChanged);
            object = textViewBindingAdapter$1;
        }
        int n10 = R$id.textWatcher;
        textViewBindingAdapter$OnTextChanged = (TextWatcher)ListenerUtil.trackListener((View)textView, object, n10);
        if (textViewBindingAdapter$OnTextChanged != null) {
            textView.removeTextChangedListener((TextWatcher)textViewBindingAdapter$OnTextChanged);
        }
        if (object != null) {
            textView.addTextChangedListener((TextWatcher)object);
        }
    }
}

