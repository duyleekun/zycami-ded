/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.LayoutTransition
 *  android.util.Log
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import androidx.transition.R$id;
import androidx.transition.ViewGroupUtilsApi14$1;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewGroupUtilsApi14 {
    private static final int LAYOUT_TRANSITION_CHANGING = 4;
    private static final String TAG = "ViewGroupUtilsApi14";
    private static Method sCancelMethod;
    private static boolean sCancelMethodFetched;
    private static LayoutTransition sEmptyLayoutTransition;
    private static Field sLayoutSuppressedField;
    private static boolean sLayoutSuppressedFieldFetched;

    private ViewGroupUtilsApi14() {
    }

    private static void cancelLayoutTransition(LayoutTransition object) {
        Method method;
        boolean bl2 = sCancelMethodFetched;
        String string2 = "Failed to access cancel method by reflection";
        Object[] objectArray = null;
        String string3 = TAG;
        if (!bl2) {
            bl2 = true;
            Object object2 = LayoutTransition.class;
            String string4 = "cancel";
            Class[] classArray = new Class[]{};
            object2 = ((Class)object2).getDeclaredMethod(string4, classArray);
            sCancelMethod = object2;
            try {
                ((Method)object2).setAccessible(bl2);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)string3, (String)string2);
            }
            sCancelMethodFetched = bl2;
        }
        if ((method = sCancelMethod) != null) {
            objectArray = new Object[]{};
            try {
                method.invoke(object, objectArray);
            }
            catch (InvocationTargetException invocationTargetException) {
                object = "Failed to invoke cancel method by reflection";
                Log.i((String)string3, (String)object);
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.i((String)string3, (String)string2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void suppressLayout(ViewGroup viewGroup, boolean bl2) {
        boolean bl3;
        Object object;
        block16: {
            Object object2;
            object = sEmptyLayoutTransition;
            boolean bl4 = true;
            bl3 = false;
            if (object == null) {
                sEmptyLayoutTransition = object = new ViewGroupUtilsApi14$1();
                object.setAnimator(2, null);
                sEmptyLayoutTransition.setAnimator(0, null);
                sEmptyLayoutTransition.setAnimator((int)(bl4 ? 1 : 0), null);
                sEmptyLayoutTransition.setAnimator(3, null);
                object = sEmptyLayoutTransition;
                int n10 = 4;
                object.setAnimator(n10, null);
            }
            if (bl2) {
                LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
                if (layoutTransition != null) {
                    int n11 = layoutTransition.isRunning();
                    if (n11 != 0) {
                        ViewGroupUtilsApi14.cancelLayoutTransition(layoutTransition);
                    }
                    if (layoutTransition != (object = sEmptyLayoutTransition)) {
                        n11 = R$id.transition_layout_save;
                        viewGroup.setTag(n11, (Object)layoutTransition);
                    }
                }
                layoutTransition = sEmptyLayoutTransition;
                viewGroup.setLayoutTransition(layoutTransition);
                return;
            }
            viewGroup.setLayoutTransition(null);
            bl2 = sLayoutSuppressedFieldFetched;
            object = TAG;
            if (!bl2) {
                object2 = ViewGroup.class;
                String string2 = "mLayoutSuppressed";
                try {
                    sLayoutSuppressedField = object2 = ((Class)object2).getDeclaredField(string2);
                    ((Field)object2).setAccessible(bl4);
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    object2 = "Failed to access mLayoutSuppressed field by reflection";
                    Log.i((String)object, (String)object2);
                }
                sLayoutSuppressedFieldFetched = bl4;
            }
            if ((object2 = sLayoutSuppressedField) != null) {
                block15: {
                    block14: {
                        try {
                            bl2 = ((Field)object2).getBoolean(viewGroup);
                            if (!bl2) break block14;
                        }
                        catch (IllegalAccessException illegalAccessException) {}
                        try {
                            Field field = sLayoutSuppressedField;
                            field.setBoolean(viewGroup, false);
                        }
                        catch (IllegalAccessException illegalAccessException) {
                            bl3 = bl2;
                            break block15;
                        }
                    }
                    bl3 = bl2;
                    break block16;
                }
                object2 = "Failed to get mLayoutSuppressed field by reflection";
                Log.i((String)object, (String)object2);
            }
        }
        if (bl3) {
            viewGroup.requestLayout();
        }
        if ((object = (LayoutTransition)viewGroup.getTag((int)((bl2 = R$id.transition_layout_save) ? 1 : 0))) == null) return;
        viewGroup.setTag((int)(bl2 ? 1 : 0), null);
        viewGroup.setLayoutTransition(object);
    }
}

