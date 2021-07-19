/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ResolveInfo
 *  android.os.Bundle
 *  android.view.WindowManager$LayoutParams
 */
package d.r.a.s.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.WindowManager;
import d.r.a.u.d0;
import d.r.a.u.s;

public class b
extends Activity {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onCreate(Bundle var1_1) {
        block33: {
            block36: {
                block35: {
                    block37: {
                        block34: {
                            super.onCreate((Bundle)var1_1);
                            var1_1 = this.getIntent();
                            var2_4 = "LinkProxyActivity";
                            if (var1_1 == null) {
                                s.m(var2_4, "enter RequestPermissionsActivity onCreate, intent is null, finish");
                                this.finish();
                                return;
                            }
                            var3_5 = true;
                            var4_6 = null;
                            var5_7 /* !! */  = this.getWindow();
                            var6_9 = 0x800033;
                            var5_7 /* !! */ .setGravity(var6_9);
                            var7_10 = var5_7 /* !! */ .getAttributes();
                            var7_10.x = 0;
                            var7_10.y = 0;
                            var7_10.height = var3_5;
                            var7_10.width = var3_5;
                            try {
                                var5_7 /* !! */ .setAttributes((WindowManager.LayoutParams)var7_10);
                            }
                            catch (Throwable var5_8) {
                                var7_10 = "enter onCreate error ";
                                s.i(var2_4, (String)var7_10, var5_8);
                            }
                            var5_7 /* !! */  = this.getPackageName();
                            var7_10 = new StringBuilder();
                            var8_11 = this.hashCode();
                            var7_10.append(var8_11);
                            var9_12 = " enter onCreate ";
                            var7_10.append(var9_12);
                            var7_10.append((String)var5_7 /* !! */ );
                            var7_10 = var7_10.toString();
                            s.m(var2_4, (String)var7_10);
                            var10_13 = "com.vivo.abe".equals(var5_7 /* !! */ );
                            var7_10 = "previous_intent";
                            if (!var10_13) break block37;
                            if (var1_1 != null) ** GOTO lbl54
                            var1_1 = "adapterToService intent is null";
                            s.m(var2_4, (String)var1_1);
                            break block33;
lbl54:
                            // 1 sources

                            var11_14 /* !! */  = var1_1.getExtras();
                            if (var11_14 /* !! */  != null) ** GOTO lbl61
                            var1_1 = "adapterToService getExtras() is null";
                            s.m(var2_4, (String)var1_1);
                            break block33;
lbl61:
                            // 1 sources

                            var1_1 = var1_1.getExtras();
                            var1_1 = var1_1.get((String)var7_10);
                            var1_1 = (Intent)var1_1;
                            if (var1_1 != null) break block34;
                            var1_1 = "adapterToService proxyIntent is null";
                            s.m(var2_4, (String)var1_1);
                        }
                        try {
                            d0.c((Context)this, (Intent)var1_1);
                            break block33;
                        }
                        catch (Exception var1_2) {
                            var11_14 /* !! */  = var1_2.toString();
                            s.b(var2_4, (String)var11_14 /* !! */ , var1_2);
                        }
                        break block33;
                    }
                    var5_7 /* !! */  = var1_1.getExtras();
                    if (var5_7 /* !! */  == null) break block33;
                    var1_1 = var1_1.getExtras();
                    var1_1 = var1_1.get((String)var7_10);
                    var1_1 = (Intent)var1_1;
                    if (var1_1 == null) break block35;
                    var5_7 /* !! */  = this.getPackageManager();
                    if (var5_7 /* !! */  == null) break block35;
                    var6_9 = 576;
                    var5_7 /* !! */  = var5_7 /* !! */ .queryIntentServices((Intent)var1_1, var6_9);
                    if (var5_7 /* !! */  == null) break block35;
                    var6_9 = (int)var5_7 /* !! */ .isEmpty();
                    if (var6_9 != 0) break block35;
                    var5_7 /* !! */  = var5_7 /* !! */ .get(0);
                    var5_7 /* !! */  = (ResolveInfo)var5_7 /* !! */ ;
                    if (var5_7 /* !! */  == null) break block35;
                    var5_7 /* !! */  = var5_7 /* !! */ .serviceInfo;
                    if (var5_7 /* !! */  == null) break block35;
                    var10_13 = var5_7 /* !! */ .exported;
                    if (var10_13) break block36;
                }
                var3_5 = false;
                var11_15 = null;
            }
            if (var3_5) {
                this.startService((Intent)var1_1);
            }
            var4_6 = "service's exported is ";
            var1_1 = new StringBuilder(var4_6);
            var1_1.append(var3_5);
            var1_1 = var1_1.toString();
            try {
                s.h(var2_4, (String)var1_1);
            }
            catch (Exception var1_3) {
                var11_15 = var1_3.toString();
                s.b(var2_4, var11_15, var1_3);
            }
        }
        this.finish();
    }

    public void onDestroy() {
        super.onDestroy();
        CharSequence charSequence = new StringBuilder();
        int n10 = ((Object)((Object)this)).hashCode();
        charSequence.append(n10);
        charSequence.append(" onDestory ");
        String string2 = this.getPackageName();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        s.m("LinkProxyActivity", (String)charSequence);
    }
}

