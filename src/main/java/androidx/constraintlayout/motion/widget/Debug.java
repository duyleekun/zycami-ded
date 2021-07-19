/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Debug {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void dumpLayoutParams(ViewGroup.LayoutParams object, String object2) {
        Object object3 = new Throwable();
        object3 = ((Throwable)object3).getStackTrace()[1];
        Appendable appendable = new StringBuilder();
        ((StringBuilder)appendable).append(".(");
        Object object4 = ((StackTraceElement)object3).getFileName();
        ((StringBuilder)appendable).append((String)object4);
        ((StringBuilder)appendable).append(":");
        int n10 = ((StackTraceElement)object3).getLineNumber();
        ((StringBuilder)appendable).append(n10);
        ((StringBuilder)appendable).append(") ");
        ((StringBuilder)appendable).append((String)object2);
        object2 = "  ";
        ((StringBuilder)appendable).append((String)object2);
        object3 = ((StringBuilder)appendable).toString();
        appendable = System.out;
        object4 = new StringBuilder();
        Object object5 = " >>>>>>>>>>>>>>>>>>. dump ";
        ((StringBuilder)object4).append((String)object5);
        ((StringBuilder)object4).append((String)object3);
        ((StringBuilder)object4).append((String)object2);
        object2 = object.getClass().getName();
        ((StringBuilder)object4).append((String)object2);
        object2 = ((StringBuilder)object4).toString();
        ((PrintStream)appendable).println((String)object2);
        object2 = object.getClass().getFields();
        int n11 = 0;
        appendable = null;
        while (true) {
            int n12;
            if (n11 >= (n12 = ((Object)object2).length)) {
                object = System.out;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(" <<<<<<<<<<<<<<<<< dump ");
                ((StringBuilder)object2).append((String)object3);
                object2 = ((StringBuilder)object2).toString();
                ((PrintStream)object).println((String)object2);
                return;
            }
            object4 = object2[n11];
            try {
                CharSequence charSequence;
                object5 = ((Field)object4).get(object);
                object4 = ((Field)object4).getName();
                Object object6 = "To";
                boolean bl2 = ((String)object4).contains((CharSequence)object6);
                if (bl2 && !(bl2 = ((String)(object6 = object5.toString())).equals(charSequence = "-1"))) {
                    object6 = System.out;
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)object3);
                    String string2 = "       ";
                    ((StringBuilder)charSequence).append(string2);
                    ((StringBuilder)charSequence).append((String)object4);
                    object4 = " ";
                    ((StringBuilder)charSequence).append((String)object4);
                    ((StringBuilder)charSequence).append(object5);
                    object4 = ((StringBuilder)charSequence).toString();
                    ((PrintStream)object6).println((String)object4);
                }
            }
            catch (IllegalAccessException illegalAccessException) {}
            ++n11;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void dumpLayoutParams(ViewGroup viewGroup, String string2) {
        Object object = new Throwable();
        object = ((Throwable)object).getStackTrace()[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".(");
        Object object2 = ((StackTraceElement)object).getFileName();
        stringBuilder.append((String)object2);
        stringBuilder.append(":");
        int n10 = ((StackTraceElement)object).getLineNumber();
        stringBuilder.append(n10);
        stringBuilder.append(") ");
        stringBuilder.append(string2);
        stringBuilder.append("  ");
        object = stringBuilder.toString();
        int n11 = viewGroup.getChildCount();
        object2 = System.out;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string2);
        stringBuilder2.append(" children ");
        stringBuilder2.append(n11);
        string2 = stringBuilder2.toString();
        ((PrintStream)object2).println(string2);
        string2 = null;
        int n12 = 0;
        object2 = null;
        block2: while (n12 < n11) {
            stringBuilder2 = viewGroup.getChildAt(n12);
            Field[] fieldArray = System.out;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append((String)object);
            stringBuilder3.append("     ");
            Object object3 = Debug.getName((View)stringBuilder2);
            stringBuilder3.append((String)object3);
            String string3 = stringBuilder3.toString();
            fieldArray.println(string3);
            stringBuilder2 = stringBuilder2.getLayoutParams();
            fieldArray = stringBuilder2.getClass().getFields();
            int n13 = 0;
            Object var10_10 = null;
            while (true) {
                block7: {
                    int n14;
                    if (n13 < (n14 = fieldArray.length)) {
                        object3 = fieldArray[n13];
                        Object object4 = ((Field)object3).get(stringBuilder2);
                        Object object5 = ((Field)object3).getName();
                        CharSequence charSequence = "To";
                        boolean bl2 = ((String)object5).contains(charSequence);
                        if (bl2 && !(bl2 = ((String)(object5 = object4.toString())).equals(charSequence = "-1"))) {
                            object5 = System.out;
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append((String)object);
                            String string4 = "       ";
                            ((StringBuilder)charSequence).append(string4);
                            object3 = ((Field)object3).getName();
                            ((StringBuilder)charSequence).append((String)object3);
                            object3 = " ";
                            ((StringBuilder)charSequence).append((String)object3);
                            ((StringBuilder)charSequence).append(object4);
                            object3 = ((StringBuilder)charSequence).toString();
                            ((PrintStream)object5).println((String)object3);
                        }
                        break block7;
                    }
                    ++n12;
                    continue block2;
                    catch (IllegalAccessException illegalAccessException) {}
                }
                ++n13;
            }
            break;
        }
        return;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static void dumpPoc(Object var0) {
        var1_1 = new Throwable();
        var1_1 = var1_1.getStackTrace();
        var2_2 = 1;
        var1_1 = var1_1[var2_2];
        var3_3 = new StringBuilder();
        var3_3.append(".(");
        var4_4 = var1_1.getFileName();
        var3_3.append((String)var4_4);
        var3_3.append(":");
        var5_5 = var1_1.getLineNumber();
        var3_3.append(var5_5);
        var3_3.append(")");
        var1_1 = var3_3.toString();
        var3_3 = var0.getClass();
        var4_4 = System.out;
        var6_6 /* !! */  = new StringBuilder();
        var6_6 /* !! */ .append((String)var1_1);
        var7_7 = "------------- ";
        var6_6 /* !! */ .append(var7_7);
        var8_8 = var3_3.getName();
        var6_6 /* !! */ .append(var8_8);
        var8_8 = " --------------------";
        var6_6 /* !! */ .append(var8_8);
        var6_6 /* !! */  = var6_6 /* !! */ .toString();
        var4_4.println((String)var6_6 /* !! */ );
        var4_4 = var3_3.getFields();
        var6_6 /* !! */  = null;
        block21: for (var9_9 = 0; var9_9 < (var10_10 = ((Field[])var4_4).length); ++var9_9) {
            block27: {
                var11_11 = var4_4[var9_9];
                var12_12 = var11_11.get(var0);
                var13_13 = var11_11.getName();
                var14_14 = "layout_constraint";
                var15_15 = var13_13.startsWith((String)var14_14);
                if (!var15_15) break block27;
                var15_15 = var12_12 instanceof Integer;
                if (var15_15) {
                    var13_13 = var12_12.toString();
                    var14_14 = "-1";
                    var15_15 = var13_13.equals(var14_14);
                    if (var15_15) break block27;
                }
                if (var15_15 = var12_12 instanceof Integer) {
                    var13_13 = var12_12.toString();
                    var14_14 = "0";
                    var15_15 = var13_13.equals(var14_14);
                    if (var15_15) break block27;
                }
                if (var15_15 = var12_12 instanceof Float) {
                    var13_13 = var12_12.toString();
                    var14_14 = "1.0";
                    var15_15 = var13_13.equals(var14_14);
                    if (var15_15) break block27;
                }
                if (var15_15 = var12_12 instanceof Float) {
                    var13_13 = var12_12.toString();
                    var14_14 = "0.5";
                    var15_15 = var13_13.equals(var14_14);
                    if (var15_15) break block27;
                }
                var13_13 = System.out;
                var14_14 = new StringBuilder();
                var14_14.append((String)var1_1);
                var16_16 = "    ";
                var14_14.append(var16_16);
                var11_11 = var11_11.getName();
                var14_14.append((String)var11_11);
                var11_11 = " ";
                var14_14.append((String)var11_11);
                var14_14.append(var12_12);
                var11_11 = var14_14.toString();
                var13_13.println((String)var11_11);
            }
lbl102:
            // 2 sources

        }
        var0 = System.out;
        var4_4 = new StringBuilder();
        var4_4.append((String)var1_1);
        var4_4.append(var7_7);
        var1_1 = var3_3.getSimpleName();
        var4_4.append((String)var1_1);
        var4_4.append(var8_8);
        var1_1 = var4_4.toString();
        var0.println((String)var1_1);
        return;
        catch (IllegalAccessException v0) {
            ** continue;
        }
    }

    public static String getActionType(MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getAction();
        Field[] fieldArray = MotionEvent.class.getFields();
        for (int i10 = 0; i10 < (n10 = fieldArray.length); ++i10) {
            int n12;
            Field field = fieldArray[i10];
            try {
                n12 = field.getModifiers();
            }
            catch (IllegalAccessException illegalAccessException) {}
            n12 = Modifier.isStatic(n12) ? 1 : 0;
            if (n12 == 0) continue;
            Class<?> clazz = field.getType();
            Class<Integer> clazz2 = Integer.TYPE;
            n12 = clazz.equals(clazz2) ? 1 : 0;
            if (n12 == 0) continue;
            n12 = 0;
            clazz = null;
            n12 = field.getInt(null);
            if (n12 != n11) continue;
            return field.getName();
        }
        return "---";
    }

    public static String getCallFrom(int n10) {
        Object object = new Throwable();
        object = ((Throwable)object).getStackTrace();
        StackTraceElement stackTraceElement = object[n10 += 2];
        object = new StringBuilder();
        ((StringBuilder)object).append(".(");
        String string2 = stackTraceElement.getFileName();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(":");
        n10 = stackTraceElement.getLineNumber();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(")");
        return ((StringBuilder)object).toString();
    }

    public static String getLoc() {
        Object object = new Throwable();
        object = ((Throwable)object).getStackTrace()[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".(");
        String string2 = ((StackTraceElement)object).getFileName();
        stringBuilder.append(string2);
        stringBuilder.append(":");
        int n10 = ((StackTraceElement)object).getLineNumber();
        stringBuilder.append(n10);
        stringBuilder.append(") ");
        object = ((StackTraceElement)object).getMethodName();
        stringBuilder.append((String)object);
        stringBuilder.append("()");
        return stringBuilder.toString();
    }

    public static String getLocation() {
        Serializable serializable = new Throwable();
        serializable = ((Throwable)serializable).getStackTrace()[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".(");
        String string2 = ((StackTraceElement)serializable).getFileName();
        stringBuilder.append(string2);
        stringBuilder.append(":");
        int n10 = ((StackTraceElement)serializable).getLineNumber();
        stringBuilder.append(n10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String getLocation2() {
        Serializable serializable = new Throwable();
        serializable = ((Throwable)serializable).getStackTrace()[2];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".(");
        String string2 = ((StackTraceElement)serializable).getFileName();
        stringBuilder.append(string2);
        stringBuilder.append(":");
        int n10 = ((StackTraceElement)serializable).getLineNumber();
        stringBuilder.append(n10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String getName(Context object, int n10) {
        int n11 = -1;
        if (n10 == n11) return "UNKNOWN";
        try {
            object = object.getResources();
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("?");
            ((StringBuilder)object).append(n10);
            return ((StringBuilder)object).toString();
        }
        return object.getResourceEntryName(n10);
    }

    /*
     * Loose catch block
     */
    public static String getName(Context object, int[] object2) {
        CharSequence charSequence = new StringBuilder();
        int n10 = ((int[])object2).length;
        charSequence.append(n10);
        String string2 = "[";
        charSequence.append(string2);
        charSequence = charSequence.toString();
        n10 = 0;
        string2 = null;
        while (true) {
            int n11 = ((int[])object2).length;
            if (n10 >= n11) break;
            CharSequence charSequence2 = new StringBuilder();
            charSequence2.append((String)charSequence);
            charSequence = " ";
            CharSequence charSequence3 = n10 == 0 ? "" : charSequence;
            charSequence2.append((String)charSequence3);
            charSequence2 = charSequence2.toString();
            charSequence3 = object.getResources();
            int n12 = object2[n10];
            try {
                charSequence = charSequence3.getResourceEntryName(n12);
            }
            catch (Resources.NotFoundException notFoundException) {
                charSequence3 = new StringBuilder();
                String string3 = "? ";
                ((StringBuilder)charSequence3).append(string3);
                n12 = object2[n10];
                ((StringBuilder)charSequence3).append(n12);
                ((StringBuilder)charSequence3).append((String)charSequence);
                charSequence = ((StringBuilder)charSequence3).toString();
            }
            charSequence3 = new StringBuilder();
            ((StringBuilder)charSequence3).append((String)charSequence2);
            ((StringBuilder)charSequence3).append((String)charSequence);
            charSequence = ((StringBuilder)charSequence3).toString();
            ++n10;
            continue;
            break;
        }
        object = new StringBuilder();
        {
            catch (Exception exception) {
                object = exception.toString();
                Log.v((String)"DEBUG", (String)object);
                return "UNKNOWN";
            }
        }
        ((StringBuilder)object).append((String)charSequence);
        object2 = "]";
        ((StringBuilder)object).append((String)object2);
        return ((StringBuilder)object).toString();
    }

    public static String getName(View view) {
        Context context;
        try {
            context = view.getContext();
        }
        catch (Exception exception) {
            return "UNKNOWN";
        }
        context = context.getResources();
        int n10 = view.getId();
        return context.getResourceEntryName(n10);
    }

    public static String getState(MotionLayout motionLayout, int n10) {
        int n11 = -1;
        if (n10 == n11) {
            return "UNDEFINED";
        }
        return motionLayout.getContext().getResources().getResourceEntryName(n10);
    }

    public static void logStack(String string2, String string3, int n10) {
        String string4;
        int n11;
        StackTraceElement[] stackTraceElementArray = new Throwable();
        stackTraceElementArray = stackTraceElementArray.getStackTrace();
        int n12 = stackTraceElementArray.length;
        n10 = Math.min(n10, n12 -= n11);
        String string5 = string4 = " ";
        for (n11 = 1; n11 <= n10; ++n11) {
            Object object = stackTraceElementArray[n11];
            object = new StringBuilder();
            ((StringBuilder)object).append(".(");
            CharSequence charSequence = stackTraceElementArray[n11].getFileName();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(":");
            int n13 = stackTraceElementArray[n11].getLineNumber();
            ((StringBuilder)object).append(n13);
            ((StringBuilder)object).append(") ");
            charSequence = stackTraceElementArray[n11].getMethodName();
            ((StringBuilder)object).append((String)charSequence);
            object = ((StringBuilder)object).toString();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string5);
            ((StringBuilder)charSequence).append(string4);
            string5 = ((StringBuilder)charSequence).toString();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string5);
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(string5);
            object = ((StringBuilder)charSequence).toString();
            Log.v((String)string2, (String)object);
        }
    }

    public static void printStack(String string2, int n10) {
        String string3;
        int n11;
        StackTraceElement[] stackTraceElementArray = new Throwable();
        stackTraceElementArray = stackTraceElementArray.getStackTrace();
        int n12 = stackTraceElementArray.length;
        n10 = Math.min(n10, n12 -= n11);
        String string4 = string3 = " ";
        for (n11 = 1; n11 <= n10; ++n11) {
            Object object = stackTraceElementArray[n11];
            object = new StringBuilder();
            ((StringBuilder)object).append(".(");
            Object object2 = stackTraceElementArray[n11].getFileName();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(":");
            int n13 = stackTraceElementArray[n11].getLineNumber();
            ((StringBuilder)object).append(n13);
            ((StringBuilder)object).append(") ");
            object = ((StringBuilder)object).toString();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string4);
            ((StringBuilder)object2).append(string3);
            string4 = ((StringBuilder)object2).toString();
            object2 = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string4);
            stringBuilder.append((String)object);
            stringBuilder.append(string4);
            object = stringBuilder.toString();
            ((PrintStream)object2).println((String)object);
        }
    }
}

