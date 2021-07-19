/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.GhostView;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GhostViewPlatform
implements GhostView {
    private static final String TAG = "GhostViewApi21";
    private static Method sAddGhostMethod;
    private static boolean sAddGhostMethodFetched;
    private static Class sGhostViewClass;
    private static boolean sGhostViewClassFetched;
    private static Method sRemoveGhostMethod;
    private static boolean sRemoveGhostMethodFetched;
    private final View mGhostView;

    private GhostViewPlatform(View view) {
        this.mGhostView = view;
    }

    /*
     * WARNING - void declaration
     */
    public static GhostView addGhost(View object, ViewGroup object2, Matrix matrix) {
        GhostViewPlatform.fetchAddGhostMethod();
        Method method = sAddGhostMethod;
        if (method != null) {
            void var2_8;
            void var1_6;
            int n10 = 3;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            int n11 = 1;
            objectArray[n11] = var1_6;
            n11 = 2;
            objectArray[n11] = var2_8;
            Object object3 = method.invoke(null, objectArray);
            View view = (View)object3;
            try {
                GhostViewPlatform ghostViewPlatform = new GhostViewPlatform(view);
                return ghostViewPlatform;
            }
            catch (InvocationTargetException invocationTargetException) {
                Throwable throwable = invocationTargetException.getCause();
                RuntimeException runtimeException = new RuntimeException(throwable);
                throw runtimeException;
            }
            catch (IllegalAccessException illegalAccessException) {}
        }
        return null;
    }

    private static void fetchAddGhostMethod() {
        boolean bl2 = sAddGhostMethodFetched;
        if (!bl2) {
            bl2 = true;
            GhostViewPlatform.fetchGhostViewClass();
            GenericDeclaration genericDeclaration = sGhostViewClass;
            String string2 = "addGhost";
            int n10 = 3;
            Class[] classArray = new Class[n10];
            int n11 = 0;
            Class<ViewGroup> clazz = null;
            Class<View> clazz2 = View.class;
            classArray[0] = clazz2;
            clazz = ViewGroup.class;
            classArray[bl2] = clazz;
            n11 = 2;
            clazz2 = Matrix.class;
            classArray[n11] = clazz2;
            genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod(string2, classArray);
            sAddGhostMethod = genericDeclaration;
            try {
                ((Method)genericDeclaration).setAccessible(bl2);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                string2 = TAG;
                classArray = "Failed to retrieve addGhost method";
                Log.i((String)string2, (String)classArray, (Throwable)noSuchMethodException);
            }
            sAddGhostMethodFetched = bl2;
        }
    }

    private static void fetchGhostViewClass() {
        boolean bl2 = sGhostViewClassFetched;
        if (!bl2) {
            Object object = "android.view.GhostView";
            object = Class.forName((String)object);
            try {
                sGhostViewClass = object;
            }
            catch (ClassNotFoundException classNotFoundException) {
                String string2 = TAG;
                String string3 = "Failed to retrieve GhostView class";
                Log.i((String)string2, (String)string3, (Throwable)classNotFoundException);
            }
            sGhostViewClassFetched = bl2 = true;
        }
    }

    private static void fetchRemoveGhostMethod() {
        boolean bl2 = sRemoveGhostMethodFetched;
        if (!bl2) {
            bl2 = true;
            GhostViewPlatform.fetchGhostViewClass();
            GenericDeclaration genericDeclaration = sGhostViewClass;
            String string2 = "removeGhost";
            Class[] classArray = new Class[bl2];
            Class<View> clazz = View.class;
            classArray[0] = clazz;
            genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod(string2, classArray);
            sRemoveGhostMethod = genericDeclaration;
            try {
                ((Method)genericDeclaration).setAccessible(bl2);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                string2 = TAG;
                classArray = "Failed to retrieve removeGhost method";
                Log.i((String)string2, (String)classArray, (Throwable)noSuchMethodException);
            }
            sRemoveGhostMethodFetched = bl2;
        }
    }

    public static void removeGhost(View view) {
        GhostViewPlatform.fetchRemoveGhostMethod();
        Object object = sRemoveGhostMethod;
        if (object != null) {
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = view;
            try {
                ((Method)object).invoke(null, objectArray);
            }
            catch (InvocationTargetException invocationTargetException) {
                Throwable throwable = invocationTargetException.getCause();
                object = new RuntimeException(throwable);
                throw object;
            }
            catch (IllegalAccessException illegalAccessException) {}
        }
    }

    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
    }

    public void setVisibility(int n10) {
        this.mGhostView.setVisibility(n10);
    }
}

