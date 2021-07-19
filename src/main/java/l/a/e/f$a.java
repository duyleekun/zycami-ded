/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package l.a.e;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class f$a
implements View.OnClickListener {
    private final View a;
    private final String b;
    private Method c;
    private Context d;

    public f$a(View view, String string2) {
        this.a = view;
        this.b = string2;
    }

    private void b(Context object, String object2) {
        int n10;
        Object object3;
        CharSequence charSequence;
        int n11;
        while (object != null) {
            block13: {
                try {
                    n11 = object.isRestricted();
                    if (n11 != 0) break block13;
                }
                catch (NoSuchMethodException noSuchMethodException) {}
                object2 = object.getClass();
                charSequence = this.b;
                int n12 = 1;
                object3 = new Class[n12];
                Class<View> clazz = View.class;
                object3[0] = clazz;
                object2 = ((Class)object2).getMethod((String)charSequence, (Class<?>)object3);
                if (object2 == null) break block13;
                this.c = object2;
                this.d = object;
                return;
            }
            if ((n11 = object instanceof ContextWrapper) != 0) {
                object = ((ContextWrapper)object).getBaseContext();
                continue;
            }
            n10 = 0;
            object = null;
        }
        object = this.a;
        n10 = object.getId();
        if (n10 == (n11 = -1)) {
            object = "";
        } else {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(" with id '");
            charSequence = this.a.getContext().getResources();
            object = charSequence.getResourceEntryName(n10);
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("'");
            object = ((StringBuilder)object2).toString();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Could not find method ");
        object3 = this.b;
        ((StringBuilder)charSequence).append((String)object3);
        ((StringBuilder)charSequence).append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
        object3 = this.a.getClass();
        ((StringBuilder)charSequence).append(object3);
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public void onClick(View view) {
        String string2;
        Object object = this.c;
        if (object == null) {
            object = this.a.getContext();
            string2 = this.b;
            this.b((Context)object, string2);
        }
        object = this.c;
        string2 = this.d;
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = view;
        try {
            ((Method)object).invoke(string2, objectArray);
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

