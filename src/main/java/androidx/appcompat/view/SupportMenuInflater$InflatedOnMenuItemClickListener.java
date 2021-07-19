/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.InflateException
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 */
package androidx.appcompat.view;

import android.view.InflateException;
import android.view.MenuItem;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;

public class SupportMenuInflater$InflatedOnMenuItemClickListener
implements MenuItem.OnMenuItemClickListener {
    private static final Class[] PARAM_TYPES;
    private Method mMethod;
    private Object mRealOwner;

    static {
        Class[] classArray = new Class[]{MenuItem.class};
        PARAM_TYPES = classArray;
    }

    public SupportMenuInflater$InflatedOnMenuItemClickListener(Object object, String string2) {
        Object object2;
        this.mRealOwner = object;
        object = object.getClass();
        try {
            object2 = PARAM_TYPES;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Couldn't resolve menu item onClick handler ");
            stringBuilder.append(string2);
            stringBuilder.append(" in class ");
            object = ((Class)object).getName();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            InflateException inflateException = new InflateException((String)object);
            inflateException.initCause((Throwable)exception);
            throw inflateException;
        }
        object2 = ((Class)object).getMethod(string2, (Class<?>)object2);
        this.mMethod = object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean onMenuItemClick(MenuItem object) {
        GenericDeclaration genericDeclaration;
        try {
            genericDeclaration = this.mMethod;
            genericDeclaration = ((Method)genericDeclaration).getReturnType();
            Object object2 = Boolean.TYPE;
            boolean bl2 = true;
            if (genericDeclaration == object2) {
                genericDeclaration = this.mMethod;
                object2 = this.mRealOwner;
                Object[] objectArray = new Object[bl2];
                objectArray[0] = object;
                object = ((Method)genericDeclaration).invoke(object2, objectArray);
                object = (Boolean)object;
                return (Boolean)object;
            }
            genericDeclaration = this.mMethod;
            object2 = this.mRealOwner;
            Object[] objectArray = new Object[bl2];
            objectArray[0] = object;
            ((Method)genericDeclaration).invoke(object2, objectArray);
            return bl2;
        }
        catch (Exception exception) {
            genericDeclaration = new RuntimeException(exception);
            throw genericDeclaration;
        }
    }
}

