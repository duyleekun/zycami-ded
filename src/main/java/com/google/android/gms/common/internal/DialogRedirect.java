/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.common.internal.zad;
import com.google.android.gms.common.internal.zae;

public abstract class DialogRedirect
implements DialogInterface.OnClickListener {
    public static DialogRedirect getInstance(Activity activity, Intent intent, int n10) {
        zac zac2 = new zac(intent, activity, n10);
        return zac2;
    }

    public static DialogRedirect getInstance(Fragment fragment, Intent intent, int n10) {
        zad zad2 = new zad(intent, fragment, n10);
        return zad2;
    }

    public static DialogRedirect getInstance(LifecycleFragment lifecycleFragment, Intent intent, int n10) {
        zae zae2 = new zae(intent, lifecycleFragment, n10);
        return zae2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onClick(DialogInterface dialogInterface, int n10) {
        Throwable throwable2222222;
        block4: {
            this.redirect();
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (ActivityNotFoundException activityNotFoundException) {}
                String string2 = "DialogRedirect";
                String string3 = "Failed to start resolution intent";
                {
                    Log.e((String)string2, (String)string3, (Throwable)activityNotFoundException);
                }
                dialogInterface.dismiss();
                return;
            }
            dialogInterface.dismiss();
            return;
        }
        dialogInterface.dismiss();
        throw throwable2222222;
    }

    public abstract void redirect();
}

