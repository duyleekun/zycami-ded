/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppCompatViewInflater$DeclaredOnClickListener
implements View.OnClickListener {
    private final View mHostView;
    private final String mMethodName;
    private Context mResolvedContext;
    private Method mResolvedMethod;

    public AppCompatViewInflater$DeclaredOnClickListener(View view, String string2) {
        this.mHostView = view;
        this.mMethodName = string2;
    }

    private void resolveMethod(Context object) {
        int n10;
        Object object2;
        CharSequence charSequence;
        Object object3;
        int n11;
        while (object != null) {
            block13: {
                try {
                    n11 = object.isRestricted();
                    if (n11 != 0) break block13;
                }
                catch (NoSuchMethodException noSuchMethodException) {}
                object3 = object.getClass();
                charSequence = this.mMethodName;
                int n12 = 1;
                object2 = new Class[n12];
                Class<View> clazz = View.class;
                object2[0] = clazz;
                object3 = ((Class)object3).getMethod((String)charSequence, (Class<?>)object2);
                if (object3 == null) break block13;
                this.mResolvedMethod = object3;
                this.mResolvedContext = object;
                return;
            }
            if ((n11 = object instanceof ContextWrapper) != 0) {
                object = ((ContextWrapper)object).getBaseContext();
                continue;
            }
            n10 = 0;
            object = null;
        }
        object = this.mHostView;
        n10 = object.getId();
        if (n10 == (n11 = -1)) {
            object = "";
        } else {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(" with id '");
            charSequence = this.mHostView.getContext().getResources();
            object = charSequence.getResourceEntryName(n10);
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append("'");
            object = ((StringBuilder)object3).toString();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Could not find method ");
        object2 = this.mMethodName;
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
        object2 = this.mHostView.getClass();
        ((StringBuilder)charSequence).append(object2);
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        object3 = new IllegalStateException((String)object);
        throw object3;
    }

    public void onClick(View view) {
        Object object = this.mResolvedMethod;
        if (object == null) {
            object = this.mHostView.getContext();
            this.resolveMethod((Context)object);
        }
        object = this.mResolvedMethod;
        Context context = this.mResolvedContext;
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = view;
        try {
            ((Method)object).invoke(context, objectArray);
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            object = new IllegalStateException("Could not execute method for android:onClick", invocationTargetException);
            throw object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new IllegalStateException("Could not execute non-public method for android:onClick", illegalAccessException);
            throw object;
        }
    }
}

