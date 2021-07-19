/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.DrawableContainer$DrawableContainerState
 *  android.util.Log
 */
package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.Log;
import java.lang.reflect.Method;

public class DrawableUtils {
    private static final String LOG_TAG = "DrawableUtils";
    private static Method setConstantStateMethod;
    private static boolean setConstantStateMethodFetched;

    private DrawableUtils() {
    }

    public static boolean setContainerConstantState(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        return DrawableUtils.setContainerConstantStateV9(drawableContainer, constantState);
    }

    private static boolean setContainerConstantStateV9(DrawableContainer object, Drawable.ConstantState constantState) {
        Object[] objectArray;
        Object object2;
        boolean bl2 = setConstantStateMethodFetched;
        String string2 = LOG_TAG;
        boolean bl3 = true;
        if (!bl2) {
            object2 = DrawableContainer.class;
            objectArray = "setConstantState";
            Class[] classArray = new Class[bl3];
            Class<DrawableContainer.DrawableContainerState> clazz = DrawableContainer.DrawableContainerState.class;
            classArray[0] = clazz;
            object2 = ((Class)object2).getDeclaredMethod((String)objectArray, classArray);
            setConstantStateMethod = object2;
            try {
                ((Method)object2).setAccessible(bl3);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object2 = "Could not fetch setConstantState(). Oh well.";
                Log.e((String)string2, (String)object2);
            }
            setConstantStateMethodFetched = bl3;
        }
        if ((object2 = setConstantStateMethod) != null) {
            objectArray = new Object[bl3];
            objectArray[0] = constantState;
            try {
                ((Method)object2).invoke(object, objectArray);
                return bl3;
            }
            catch (Exception exception) {
                object = "Could not invoke setConstantState(). Oh well.";
                Log.e((String)string2, (String)object);
            }
        }
        return false;
    }
}

