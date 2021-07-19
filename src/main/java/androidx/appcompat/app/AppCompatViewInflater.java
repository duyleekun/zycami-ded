/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Constructor;

public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final String[] sClassPrefixList;
    private static final SimpleArrayMap sConstructorMap;
    private static final Class[] sConstructorSignature;
    private static final int[] sOnClickAttrs;
    private final Object[] mConstructorArgs;

    static {
        Object object = new Class[2];
        object[0] = Context.class;
        int n10 = 1;
        object[n10] = AttributeSet.class;
        sConstructorSignature = object;
        object = new int[n10];
        object[0] = (Class)16843375;
        sOnClickAttrs = (int[])object;
        sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
        sConstructorMap = object = new SimpleArrayMap();
    }

    public AppCompatViewInflater() {
        Object[] objectArray = new Object[2];
        this.mConstructorArgs = objectArray;
    }

    private void checkOnClickListener(View view, AttributeSet attributeSet) {
        int n10;
        Object object = view.getContext();
        int n11 = object instanceof ContextWrapper;
        if (n11 != 0 && ((n11 = Build.VERSION.SDK_INT) < (n10 = 15) || (n11 = (int)(ViewCompat.hasOnClickListeners(view) ? 1 : 0)) != 0)) {
            Object object2 = sOnClickAttrs;
            if ((object = (attributeSet = object.obtainStyledAttributes(attributeSet, object2)).getString(0)) != null) {
                object2 = new AppCompatViewInflater$DeclaredOnClickListener;
                object2(view, (String)object);
                view.setOnClickListener((View.OnClickListener)object2);
            }
            attributeSet.recycle();
        }
    }

    private View createViewByPrefix(Context object, String string2, String classArray) {
        SimpleArrayMap simpleArrayMap = sConstructorMap;
        Constructor constructor = (Constructor)simpleArrayMap.get(string2);
        if (constructor == null) {
            if (classArray != null) {
                constructor = new Constructor();
                ((StringBuilder)((Object)constructor)).append((String)classArray);
                ((StringBuilder)((Object)constructor)).append(string2);
                classArray = ((StringBuilder)((Object)constructor)).toString();
            } else {
                classArray = string2;
            }
            constructor = null;
            object = object.getClassLoader();
            object = Class.forName((String)classArray, false, (ClassLoader)object);
            classArray = View.class;
            object = ((Class)object).asSubclass(classArray);
            classArray = sConstructorSignature;
            constructor = ((Class)object).getConstructor(classArray);
            simpleArrayMap.put(string2, constructor);
        }
        boolean bl2 = true;
        try {
            constructor.setAccessible(bl2);
            object = this.mConstructorArgs;
        }
        catch (Exception exception) {
            return null;
        }
        object = constructor.newInstance((Object[])object);
        return (View)object;
    }

    private View createViewFromTag(Context objectArray, String objectArray2, AttributeSet attributeSet) {
        block14: {
            String string2 = "view";
            int n10 = objectArray2.equals(string2) ? 1 : 0;
            if (n10 != 0) {
                objectArray2 = attributeSet.getAttributeValue(null, "class");
            }
            n10 = 1;
            View view = this.mConstructorArgs;
            view[0] = objectArray;
            view[n10] = attributeSet;
            int n11 = -1;
            int n12 = 46;
            n12 = objectArray2.indexOf(n12);
            if (n11 != n12) break block14;
            n11 = 0;
            attributeSet = null;
            while (true) {
                view = sClassPrefixList;
                int n13 = ((Object[])view).length;
                if (n11 >= n13) break;
                view = view[n11];
                view = this.createViewByPrefix((Context)objectArray, (String)objectArray2, (String)view);
                if (view != null) {
                    objectArray = this.mConstructorArgs;
                    objectArray[0] = null;
                    objectArray[n10] = null;
                    return view;
                }
                ++n11;
                continue;
                break;
            }
            objectArray = this.mConstructorArgs;
            objectArray[0] = null;
            objectArray[n10] = null;
            return null;
        }
        try {
            objectArray = this.createViewByPrefix((Context)objectArray, (String)objectArray2, null);
            objectArray2 = this.mConstructorArgs;
            objectArray2[0] = null;
            objectArray2[n10] = null;
            return objectArray;
        }
        catch (Throwable throwable) {
            objectArray2 = this.mConstructorArgs;
            objectArray2[0] = null;
            objectArray2[n10] = null;
            throw throwable;
        }
        catch (Exception exception) {
            objectArray = this.mConstructorArgs;
            objectArray[0] = null;
            objectArray[n10] = null;
            return null;
        }
    }

    private static Context themifyContext(Context object, AttributeSet object2, boolean n10, boolean bl2) {
        block7: {
            block8: {
                Object object3 = R$styleable.View;
                object2 = object.obtainStyledAttributes(object2, object3, 0, 0);
                if (n10 != 0) {
                    n10 = R$styleable.View_android_theme;
                    n10 = object2.getResourceId(n10, 0);
                } else {
                    n10 = 0;
                }
                if (bl2 && n10 == 0) {
                    n10 = R$styleable.View_theme;
                    if ((n10 = object2.getResourceId(n10, 0)) != 0) {
                        String string2 = LOG_TAG;
                        object3 = "app:theme is now deprecated. Please move to using android:theme instead.";
                        Log.i((String)string2, (String)object3);
                    }
                }
                object2.recycle();
                if (n10 == 0) break block7;
                int n11 = object instanceof ContextThemeWrapper;
                if (n11 == 0) break block8;
                object2 = object;
                object2 = (ContextThemeWrapper)((Object)object);
                n11 = object2.getThemeResId();
                if (n11 == n10) break block7;
            }
            object2 = new ContextThemeWrapper((Context)object, n10);
            object = object2;
        }
        return object;
    }

    private void verifyNotNull(View object, String string2) {
        if (object != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = this.getClass().getName();
        stringBuilder.append(string3);
        stringBuilder.append(" asked to inflate view for <");
        stringBuilder.append(string2);
        stringBuilder.append(">, but returned null");
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public AppCompatAutoCompleteTextView createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = new AppCompatAutoCompleteTextView(context, attributeSet);
        return appCompatAutoCompleteTextView;
    }

    public AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        AppCompatButton appCompatButton = new AppCompatButton(context, attributeSet);
        return appCompatButton;
    }

    public AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        AppCompatCheckBox appCompatCheckBox = new AppCompatCheckBox(context, attributeSet);
        return appCompatCheckBox;
    }

    public AppCompatCheckedTextView createCheckedTextView(Context context, AttributeSet attributeSet) {
        AppCompatCheckedTextView appCompatCheckedTextView = new AppCompatCheckedTextView(context, attributeSet);
        return appCompatCheckedTextView;
    }

    public AppCompatEditText createEditText(Context context, AttributeSet attributeSet) {
        AppCompatEditText appCompatEditText = new AppCompatEditText(context, attributeSet);
        return appCompatEditText;
    }

    public AppCompatImageButton createImageButton(Context context, AttributeSet attributeSet) {
        AppCompatImageButton appCompatImageButton = new AppCompatImageButton(context, attributeSet);
        return appCompatImageButton;
    }

    public AppCompatImageView createImageView(Context context, AttributeSet attributeSet) {
        AppCompatImageView appCompatImageView = new AppCompatImageView(context, attributeSet);
        return appCompatImageView;
    }

    public AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        AppCompatMultiAutoCompleteTextView appCompatMultiAutoCompleteTextView = new AppCompatMultiAutoCompleteTextView(context, attributeSet);
        return appCompatMultiAutoCompleteTextView;
    }

    public AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        AppCompatRadioButton appCompatRadioButton = new AppCompatRadioButton(context, attributeSet);
        return appCompatRadioButton;
    }

    public AppCompatRatingBar createRatingBar(Context context, AttributeSet attributeSet) {
        AppCompatRatingBar appCompatRatingBar = new AppCompatRatingBar(context, attributeSet);
        return appCompatRatingBar;
    }

    public AppCompatSeekBar createSeekBar(Context context, AttributeSet attributeSet) {
        AppCompatSeekBar appCompatSeekBar = new AppCompatSeekBar(context, attributeSet);
        return appCompatSeekBar;
    }

    public AppCompatSpinner createSpinner(Context context, AttributeSet attributeSet) {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(context, attributeSet);
        return appCompatSpinner;
    }

    public AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context, attributeSet);
        return appCompatTextView;
    }

    public AppCompatToggleButton createToggleButton(Context context, AttributeSet attributeSet) {
        AppCompatToggleButton appCompatToggleButton = new AppCompatToggleButton(context, attributeSet);
        return appCompatToggleButton;
    }

    public View createView(Context context, String string2, AttributeSet attributeSet) {
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public final View createView(View view, String string2, Context context, AttributeSet attributeSet, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        void var5_21;
        Object object;
        void var8_39;
        void var7_38;
        void var6_22;
        view = bl2 && view != null ? view.getContext() : context;
        if (var6_22 != false || var7_38 != false) {
            view = AppCompatViewInflater.themifyContext((Context)view, attributeSet, (boolean)var6_22, (boolean)var7_38);
        }
        if (var8_39 != false) {
            view = TintContextWrapper.wrap((Context)view);
        }
        string2.hashCode();
        int n10 = -1;
        int n11 = string2.hashCode();
        switch (n11) {
            default: {
                break;
            }
            case 2001146706: {
                String string3 = "Button";
                boolean bl6 = string2.equals(string3);
                if (!bl6) break;
                int n12 = 13;
                break;
            }
            case 1666676343: {
                String string4 = "EditText";
                boolean bl7 = string2.equals(string4);
                if (!bl7) break;
                int n13 = 12;
                break;
            }
            case 1601505219: {
                String string5 = "CheckBox";
                boolean bl8 = string2.equals(string5);
                if (!bl8) break;
                int n14 = 11;
                break;
            }
            case 1413872058: {
                String string6 = "AutoCompleteTextView";
                boolean bl9 = string2.equals(string6);
                if (!bl9) break;
                int n15 = 10;
                break;
            }
            case 1125864064: {
                String string7 = "ImageView";
                boolean bl10 = string2.equals(string7);
                if (!bl10) break;
                int n16 = 9;
                break;
            }
            case 799298502: {
                String string8 = "ToggleButton";
                boolean bl11 = string2.equals(string8);
                if (!bl11) break;
                int n17 = 8;
                break;
            }
            case 776382189: {
                String string9 = "RadioButton";
                boolean bl12 = string2.equals(string9);
                if (!bl12) break;
                int n18 = 7;
                break;
            }
            case -339785223: {
                String string10 = "Spinner";
                boolean bl13 = string2.equals(string10);
                if (!bl13) break;
                int n19 = 6;
                break;
            }
            case -658531749: {
                String string11 = "SeekBar";
                boolean bl14 = string2.equals(string11);
                if (!bl14) break;
                int n20 = 5;
                break;
            }
            case -937446323: {
                String string12 = "ImageButton";
                boolean bl15 = string2.equals(string12);
                if (!bl15) break;
                int n21 = 4;
                break;
            }
            case -938935918: {
                String string13 = "TextView";
                boolean bl16 = string2.equals(string13);
                if (!bl16) break;
                int n22 = 3;
                break;
            }
            case -1346021293: {
                String string14 = "MultiAutoCompleteTextView";
                boolean bl17 = string2.equals(string14);
                if (!bl17) break;
                int n23 = 2;
                break;
            }
            case -1455429095: {
                String string15 = "CheckedTextView";
                boolean bl18 = string2.equals(string15);
                if (!bl18) break;
                boolean bl19 = true;
                break;
            }
            case -1946472170: {
                String string16 = "RatingBar";
                boolean bl20 = string2.equals(string16);
                if (!bl20) break;
                boolean bl21 = false;
                object = null;
            }
        }
        switch (var5_21) {
            default: {
                object = this.createView((Context)view, string2, attributeSet);
                break;
            }
            case 13: {
                object = this.createButton((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 12: {
                object = this.createEditText((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 11: {
                object = this.createCheckBox((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 10: {
                object = this.createAutoCompleteTextView((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 9: {
                object = this.createImageView((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 8: {
                object = this.createToggleButton((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 7: {
                object = this.createRadioButton((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 6: {
                object = this.createSpinner((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 5: {
                object = this.createSeekBar((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 4: {
                object = this.createImageButton((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 3: {
                object = this.createTextView((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 2: {
                object = this.createMultiAutoCompleteTextView((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 1: {
                object = this.createCheckedTextView((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
                break;
            }
            case 0: {
                object = this.createRatingBar((Context)view, attributeSet);
                this.verifyNotNull((View)object, string2);
            }
        }
        if (object == null && context != view) {
            object = this.createViewFromTag((Context)view, string2, attributeSet);
        }
        if (object != null) {
            this.checkOnClickListener((View)object, attributeSet);
        }
        return object;
    }
}

