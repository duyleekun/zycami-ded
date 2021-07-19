/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.widget.AutoCompleteTextView
 */
package androidx.appcompat.widget;

import android.os.Build;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

public class SearchView$PreQAutoCompleteTextViewReflector {
    private Method mDoAfterTextChanged = null;
    private Method mDoBeforeTextChanged = null;
    private Method mEnsureImeVisible = null;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SearchView$PreQAutoCompleteTextViewReflector() {
        Class[] classArray;
        SearchView$PreQAutoCompleteTextViewReflector.preApi29Check();
        Method method = null;
        boolean bl2 = true;
        Object object = AutoCompleteTextView.class;
        String string2 = "doBeforeTextChanged";
        try {
            classArray = new Class[]{};
            this.mDoBeforeTextChanged = object = ((Class)object).getDeclaredMethod(string2, classArray);
            ((Method)object).setAccessible(bl2);
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        object = AutoCompleteTextView.class;
        string2 = "doAfterTextChanged";
        try {
            classArray = new Class[]{};
            this.mDoAfterTextChanged = object = ((Class)object).getDeclaredMethod(string2, classArray);
            ((Method)object).setAccessible(bl2);
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        object = AutoCompleteTextView.class;
        string2 = "ensureImeVisible";
        try {
            Class<Boolean> clazz;
            classArray = new Class[bl2];
            classArray[0] = clazz = Boolean.TYPE;
            this.mEnsureImeVisible = method = ((Class)object).getMethod(string2, classArray);
            method.setAccessible(bl2);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return;
        }
    }

    private static void preApi29Check() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 < n11) {
            return;
        }
        UnsupportedClassVersionError unsupportedClassVersionError = new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        throw unsupportedClassVersionError;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void doAfterTextChanged(AutoCompleteTextView autoCompleteTextView) {
        SearchView$PreQAutoCompleteTextViewReflector.preApi29Check();
        Method method = this.mDoAfterTextChanged;
        if (method == null) return;
        Object[] objectArray = null;
        try {
            objectArray = new Object[]{};
            method.invoke(autoCompleteTextView, objectArray);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void doBeforeTextChanged(AutoCompleteTextView autoCompleteTextView) {
        SearchView$PreQAutoCompleteTextViewReflector.preApi29Check();
        Method method = this.mDoBeforeTextChanged;
        if (method == null) return;
        Object[] objectArray = null;
        try {
            objectArray = new Object[]{};
            method.invoke(autoCompleteTextView, objectArray);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void ensureImeVisible(AutoCompleteTextView autoCompleteTextView) {
        SearchView$PreQAutoCompleteTextViewReflector.preApi29Check();
        Method method = this.mEnsureImeVisible;
        if (method == null) return;
        int n10 = 1;
        try {
            Object[] objectArray = new Object[n10];
            Boolean bl2 = Boolean.TRUE;
            objectArray[0] = bl2;
            method.invoke(autoCompleteTextView, objectArray);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

