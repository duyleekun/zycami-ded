/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ClassesInfoCache$MethodReference {
    public final int mCallType;
    public final Method mMethod;

    public ClassesInfoCache$MethodReference(int n10, Method method) {
        this.mCallType = n10;
        this.mMethod = method;
        method.setAccessible(true);
    }

    public boolean equals(Object object) {
        String string2;
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        int n10 = object instanceof ClassesInfoCache$MethodReference;
        if (n10 == 0) {
            return false;
        }
        object = (ClassesInfoCache$MethodReference)object;
        n10 = this.mCallType;
        int n11 = ((ClassesInfoCache$MethodReference)object).mCallType;
        if (n10 != n11 || !(bl2 = (string2 = this.mMethod.getName()).equals(object = ((ClassesInfoCache$MethodReference)object).mMethod.getName()))) {
            bl3 = false;
        }
        return bl3;
    }

    public int hashCode() {
        int n10 = this.mCallType * 31;
        int n11 = this.mMethod.getName().hashCode();
        return n10 + n11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void invokeCallback(LifecycleOwner object, Lifecycle$Event objectArray, Object object2) {
        try {
            int n10 = this.mCallType;
            if (n10 == 0) {
                object = this.mMethod;
                objectArray = new Object[]{};
                ((Method)object).invoke(object2, objectArray);
                return;
            }
            int n11 = 1;
            if (n10 == n11) {
                objectArray = this.mMethod;
                Object[] objectArray2 = new Object[n11];
                objectArray2[0] = object;
                objectArray.invoke(object2, objectArray2);
                return;
            }
            int n12 = 2;
            if (n10 != n12) {
                return;
            }
            Method method = this.mMethod;
            Object[] objectArray3 = new Object[n12];
            objectArray3[0] = object;
            objectArray3[n11] = objectArray;
            method.invoke(object2, objectArray3);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            objectArray = new RuntimeException(illegalAccessException);
            throw objectArray;
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            objectArray = new RuntimeException("Failed to call observer method", throwable);
            throw objectArray;
        }
    }
}

