/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.mob.commons.b;

import android.content.Context;
import com.mob.commons.b.c;
import com.mob.commons.b.f;
import com.mob.commons.b.f$c;
import com.mob.commons.k;
import java.lang.reflect.Method;

public class m
extends f {
    public m(Context context) {
        super(context);
    }

    private String a(Context object, Object object2, Method method) {
        block6: {
            if (object2 != null && method != null) {
                int n10 = 1;
                Object[] objectArray = new Object[n10];
                objectArray[0] = object;
                object = method.invoke(object2, objectArray);
                if (object == null) break block6;
                try {
                    return (String)object;
                }
                catch (Throwable throwable) {
                    object2 = c.a();
                    ((c)object2).a(throwable);
                }
            }
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public f$c c() {
        block28: {
            var1_1 = 98;
            var2_2 = k.a(var1_1);
            var3_3 /* !! */  = null;
            var2_2 = Class.forName((String)var2_2);
            var4_4 = var2_2.newInstance();
            return var4_4;
            ** finally { 
lbl10:
            // 1 sources

            break block28;
            catch (Throwable var4_6) {
                var1_1 = 0;
                var2_2 = null;
            }
            var5_7 = c.a();
            var5_7.a(var4_4);
            var4_4 = null;
        }
        var6_8 = 1;
        if (var2_2 != null && var4_4 != null) {
            var7_9 = 99;
            var8_11 = k.a(var7_9);
            var9_13 /* !! */  = new Class[var6_8];
            var10_15 /* !! */  = Context.class;
            var9_13 /* !! */ [0] = var10_15 /* !! */ ;
            try {
                var8_11 = var2_2.getMethod((String)var8_11, var9_13 /* !! */ );
            }
            catch (Throwable var8_12) {
                var9_13 /* !! */  = c.a();
                var9_13 /* !! */ .a(var8_12);
                var7_9 = 0;
                var8_11 = null;
            }
            var11_17 = 100;
            var9_13 /* !! */  = k.a(var11_17);
            var10_15 /* !! */  = new Class[var6_8];
            var12_19 /* !! */  = Context.class;
            var10_15 /* !! */ [0] = var12_19 /* !! */ ;
            try {
                var9_13 /* !! */  = var2_2.getMethod((String)var9_13 /* !! */ , var10_15 /* !! */ );
            }
            catch (Throwable var9_14) {
                var10_15 /* !! */  = c.a();
                var10_15 /* !! */ .a(var9_14);
                var11_17 = 0;
                var9_13 /* !! */  = null;
            }
            var13_21 = 101;
            var10_15 /* !! */  = k.a(var13_21);
            var12_19 /* !! */  = new Class[var6_8];
            var14_23 = Context.class;
            var12_19 /* !! */ [0] = var14_23;
            try {
                var10_15 /* !! */  = var2_2.getMethod((String)var10_15 /* !! */ , var12_19 /* !! */ );
            }
            catch (Throwable var10_16) {
                var12_19 /* !! */  = c.a();
                var12_19 /* !! */ .a(var10_16);
                var13_21 = 0;
                var10_15 /* !! */  = null;
            }
            var15_24 = 102;
            var12_19 /* !! */  = k.a(var15_24);
            var14_23 = new Class[var6_8];
            var16_25 = Context.class;
            var14_23[0] = var16_25;
            try {
                var3_3 /* !! */  = var2_2.getMethod((String)var12_19 /* !! */ , var14_23);
            }
            catch (Throwable var12_20) {
                var14_23 = c.a();
                var14_23.a(var12_20);
            }
            var17_26 = var8_11;
            var8_11 = var3_3 /* !! */ ;
            var3_3 /* !! */  = var9_13 /* !! */ ;
            var9_13 /* !! */  = var17_26;
        } else {
            var7_10 = false;
            var8_11 = null;
            var11_18 = false;
            var9_13 /* !! */  = null;
            var13_22 = false;
            var10_15 /* !! */  = null;
        }
        var12_19 /* !! */  = new f$c();
        var14_23 = this.a;
        var3_3 /* !! */  = this.a((Context)var14_23, var4_4, (Method)var3_3 /* !! */ );
        var12_19 /* !! */ .b = var3_3 /* !! */ ;
        var3_3 /* !! */  = this.a;
        var3_3 /* !! */  = this.a((Context)var3_3 /* !! */ , var4_4, (Method)var10_15 /* !! */ );
        var12_19 /* !! */ .e = var3_3 /* !! */ ;
        var3_3 /* !! */  = this.a;
        var3_3 /* !! */  = this.a((Context)var3_3 /* !! */ , var4_4, (Method)var8_11);
        var12_19 /* !! */ .c = var3_3 /* !! */ ;
        var3_3 /* !! */  = this.a;
        var12_19 /* !! */ .d = var3_3 /* !! */  = this.a((Context)var3_3 /* !! */ , var4_4, (Method)var9_13 /* !! */ );
        if (var2_2 == null || var4_4 == null) {
            var6_8 = 0;
            var5_7 = null;
        }
        var12_19 /* !! */ .a = var6_8;
        return var12_19 /* !! */ ;
    }
}

