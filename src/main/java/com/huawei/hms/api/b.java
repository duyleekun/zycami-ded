/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.app.Fragment
 *  android.app.FragmentManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package com.huawei.hms.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.EnableServiceActivity;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiMobileServicesUtil;
import com.huawei.hms.api.ResolutionDelegate;
import com.huawei.hms.api.b$a;
import com.huawei.hms.common.ErrorDialogFragment;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.common.api.HuaweiApiCallable;
import com.huawei.hms.common.internal.ConnectionErrorMessages;
import com.huawei.hms.common.internal.DialogRedirect;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.UpdateManager;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper$PackageStates;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;
import d.j.d.a.k;
import d.j.d.a.l;

public final class b
extends HuaweiApiAvailability {
    private static final b b;

    static {
        b b10;
        b = b10 = new b();
    }

    private b() {
    }

    public static int a(Activity activity) {
        int n10;
        int n11 = com.huawei.hms.api.b.a((Context)activity);
        if (n11 != 0 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 16)) {
            return 0;
        }
        return 3;
    }

    private static int a(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }

    private static Dialog a(Activity object, int n10, DialogRedirect dialogRedirect, DialogInterface.OnCancelListener object2) {
        if (n10 == 0) {
            return null;
        }
        int n11 = com.huawei.hms.api.b.a(object);
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)object, n11);
        String string2 = ConnectionErrorMessages.getErrorMessage(object, n10);
        builder.setMessage((CharSequence)string2);
        if (object2 != null) {
            builder.setOnCancelListener(object2);
        }
        object2 = ConnectionErrorMessages.getErrorDialogButtonMessage(object, n10);
        builder.setPositiveButton((CharSequence)object2, (DialogInterface.OnClickListener)dialogRedirect);
        object = ConnectionErrorMessages.getErrorTitle(object, n10);
        if (object != null) {
            builder.setTitle((CharSequence)object);
        }
        return builder.create();
    }

    private Intent a(Activity activity, int n10) {
        Context context = activity.getApplicationContext();
        int n11 = Util.isAvailableLibExist(context);
        if (n11 == 0) {
            return null;
        }
        n11 = 1;
        if (n10 != n11 && n10 != (n11 = 2)) {
            n11 = 6;
            if (n10 != n11) {
                return null;
            }
            String string2 = BindingFailedResolution.class.getName();
            return BridgeActivity.getIntentStartBridgeActivity(activity, string2);
        }
        return UpdateManager.startUpdateIntent(activity);
    }

    private static Intent a(Activity activity, String string2) {
        return BridgeActivity.getIntentStartBridgeActivity(activity, string2);
    }

    private static Intent a(Context context, String string2) {
        return BridgeActivity.getIntentStartBridgeActivity(context, string2);
    }

    private static void a(Activity activity, Dialog object, String string2, DialogInterface.OnCancelListener onCancelListener) {
        Checker.checkNonNull(activity, "activity must not be null.");
        object = ErrorDialogFragment.newInstance((Dialog)object, onCancelListener);
        activity = activity.getFragmentManager();
        ((ErrorDialogFragment)((Object)object)).show((FragmentManager)activity, string2);
    }

    private void a(Object object) {
        AvailabilityException availabilityException = new AvailabilityException();
        boolean bl2 = object instanceof HuaweiApi;
        if (bl2) {
            object = (HuaweiApi)object;
            object = availabilityException.getConnectionResult((HuaweiApi)object);
        } else {
            object = (HuaweiApiCallable)object;
            object = availabilityException.getConnectionResult((HuaweiApiCallable)object);
        }
        int n10 = ((ConnectionResult)object).getErrorCode();
        if (n10 == 0) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("The service is unavailable: ");
        String string2 = availabilityException.getMessage();
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        HMSLog.i("HuaweiApiAvailabilityImpl", (String)object);
        throw availabilityException;
    }

    public static b getInstance() {
        return b;
    }

    public Intent a(Context context, int n10) {
        int n11;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter getResolveErrorIntent, errorCode: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = "HuaweiApiAvailabilityImpl";
        HMSLog.i(string2, (String)charSequence);
        int n12 = 1;
        if (n10 != n12 && n10 != (n11 = 2)) {
            n12 = 6;
            if (n10 != n12) {
                context = null;
            } else {
                String string3 = BindingFailedResolution.class.getName();
                context = com.huawei.hms.api.b.a(context, string3);
            }
        } else {
            UpdateBean updateBean = new UpdateBean();
            updateBean.setHmsOrApkUpgrade(n12 != 0);
            charSequence = HMSPackageManager.getInstance(context.getApplicationContext()).getHMSPackageName();
            updateBean.setClientPackageName((String)charSequence);
            n12 = HuaweiApiAvailability.getServicesVersionCode();
            updateBean.setClientVersionCode(n12);
            updateBean.setClientAppId("C10132067");
            charSequence = ResourceLoaderUtil.getmContext();
            if (charSequence == null) {
                charSequence = context.getApplicationContext();
                ResourceLoaderUtil.setmContext((Context)charSequence);
            }
            charSequence = ResourceLoaderUtil.getString("hms_update_title");
            updateBean.setClientAppName((String)charSequence);
            context = UpdateManager.getStartUpdateIntent(context, updateBean);
        }
        return context;
    }

    public PendingIntent b(Context context, int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter getResolveErrorPendingIntent, errorCode: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = "HuaweiApiAvailabilityImpl";
        HMSLog.i(string2, (String)charSequence);
        Intent intent = this.a(context, n10);
        if (intent != null) {
            charSequence = null;
            int n11 = 0x8000000;
            context = PendingIntent.getActivity((Context)context, (int)0, (Intent)intent, (int)n11);
        } else {
            context = null;
        }
        return context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public k checkApiAccessible(HuaweiApi huaweiApi, HuaweiApi ... object) {
        AvailabilityException availabilityException2;
        Object object2;
        block5: {
            object2 = new l();
            object2 = ((l)object2).b();
            if (huaweiApi != null) {
                try {
                    this.a(huaweiApi);
                }
                catch (AvailabilityException availabilityException2) {
                    break block5;
                }
            }
            if (object == null) return object2;
            int n10 = ((HuaweiApi[])object).length;
            Object var6_8 = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object3 = object[i10];
                this.a(object3);
            }
            return object2;
        }
        object = new StringBuilder();
        String string2 = "checkApi has AvailabilityException ";
        ((StringBuilder)object).append(string2);
        String string3 = availabilityException2.getMessage();
        ((StringBuilder)object).append(string3);
        string3 = ((StringBuilder)object).toString();
        object = "HuaweiApiAvailabilityImpl";
        HMSLog.i((String)object, string3);
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public k checkApiAccessible(HuaweiApiCallable huaweiApiCallable, HuaweiApiCallable ... object) {
        AvailabilityException availabilityException2;
        Object object2;
        block5: {
            object2 = new l();
            object2 = ((l)object2).b();
            if (huaweiApiCallable != null) {
                try {
                    this.a(huaweiApiCallable);
                }
                catch (AvailabilityException availabilityException2) {
                    break block5;
                }
            }
            if (object == null) return object2;
            int n10 = ((HuaweiApiCallable[])object).length;
            Object var6_8 = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object3 = object[i10];
                this.a(object3);
            }
            return object2;
        }
        object = new StringBuilder();
        String string2 = "HuaweiApiCallable checkApi has AvailabilityException ";
        ((StringBuilder)object).append(string2);
        String string3 = availabilityException2.getMessage();
        ((StringBuilder)object).append(string3);
        string3 = ((StringBuilder)object).toString();
        object = "HuaweiApiAvailabilityImpl";
        HMSLog.i((String)object, string3);
        return object2;
    }

    public PendingIntent getErrPendingIntent(Context context, int n10, int n11) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter getResolveErrorPendingIntent, errorCode: ");
        charSequence.append(n10);
        charSequence.append(" requestCode: ");
        charSequence.append(n11);
        charSequence = charSequence.toString();
        String string2 = "HuaweiApiAvailabilityImpl";
        HMSLog.i(string2, (String)charSequence);
        Intent intent = this.a(context, n10);
        if (intent != null) {
            int n12 = 0x8000000;
            context = PendingIntent.getActivity((Context)context, (int)n11, (Intent)intent, (int)n12);
        } else {
            context = null;
        }
        return context;
    }

    public PendingIntent getErrPendingIntent(Context context, ConnectionResult connectionResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(connectionResult);
        int n10 = connectionResult.getErrorCode();
        return this.b(context, n10);
    }

    public Dialog getErrorDialog(Activity activity, int n10, int n11) {
        Checker.checkNonNull(activity, "activity must not be null.");
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter getErrorDialog, errorCode: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        HMSLog.i("HuaweiApiAvailabilityImpl", (String)charSequence);
        return this.getErrorDialog(activity, n10, n11, null);
    }

    public Dialog getErrorDialog(Activity activity, int n10, int n11, DialogInterface.OnCancelListener onCancelListener) {
        Checker.checkNonNull(activity, "activity must not be null.");
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter getErrorDialog, errorCode: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        HMSLog.i("HuaweiApiAvailabilityImpl", (String)charSequence);
        charSequence = this.a(activity, n10);
        DialogRedirect dialogRedirect = DialogRedirect.getInstance(activity, (Intent)charSequence, n11);
        return com.huawei.hms.api.b.a(activity, n10, dialogRedirect, onCancelListener);
    }

    public String getErrorString(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter getErrorString, errorCode: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        HMSLog.i("HuaweiApiAvailabilityImpl", (String)charSequence);
        return ConnectionResult.a(n10);
    }

    public k getHuaweiServicesReady(Activity object) {
        Preconditions.checkNotNull(object);
        int n10 = 1;
        Object object2 = new l[n10];
        Object object3 = new l();
        Object object4 = null;
        object2[0] = object3;
        object3 = object2[0].b();
        Object object5 = object.getApplicationContext();
        int n11 = 30000000;
        int n12 = this.isHuaweiMobileServicesAvailable((Context)object5, n11);
        Intent intent = this.getResolveErrorIntent((Activity)object, n12);
        String string2 = ResolutionDelegate.class.getName();
        string2 = BridgeActivity.getIntentStartBridgeActivity((Activity)object, string2);
        if (intent != null) {
            object4 = new b$a(this, (l[])object2);
            ForegroundIntentBuilder.registerResponseCallback("CALLBACK_METHOD", (BusResponseCallback)object4);
            object2 = new Bundle();
            object4 = "resolution";
            object2.putParcelable((String)object4, (Parcelable)intent);
            string2.putExtras((Bundle)object2);
            object.startActivity((Intent)string2);
        } else {
            n11 = 3;
            if (n12 == n11) {
                object2 = new Intent();
                object4 = EnableServiceActivity.class;
                object2.setClass((Context)object, (Class)object4);
                object.startActivity(object2);
            } else {
                object = "HuaweiApiAvailabilityImpl";
                if (n12 == 0) {
                    object2 = "The HMS service is available.";
                    HMSLog.i((String)object, (String)object2);
                } else {
                    object5 = "Framework can not solve the availability problem.";
                    HMSLog.e((String)object, (String)object5);
                    object = object2[0];
                    object2 = new AvailabilityException();
                    ((l)object).c((Exception)object2);
                }
            }
        }
        return object3;
    }

    public Intent getResolveErrorIntent(Activity activity, int n10) {
        int n11;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter getResolveErrorIntent, errorCode: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        HMSLog.i("HuaweiApiAvailabilityImpl", (String)charSequence);
        charSequence = activity.getApplicationContext();
        int n12 = Util.isAvailableLibExist((Context)charSequence);
        Intent intent = null;
        if (n12 == 0) {
            return null;
        }
        n12 = 1;
        if (n10 != n12 && n10 != (n11 = 2)) {
            n12 = 6;
            if (n10 == n12) {
                String string2 = BindingFailedResolution.class.getName();
                intent = com.huawei.hms.api.b.a(activity, string2);
            }
        } else {
            UpdateBean updateBean = new UpdateBean();
            updateBean.setHmsOrApkUpgrade(n12 != 0);
            charSequence = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
            updateBean.setClientPackageName((String)charSequence);
            n12 = HuaweiApiAvailability.getServicesVersionCode();
            updateBean.setClientVersionCode(n12);
            updateBean.setClientAppId("C10132067");
            charSequence = ResourceLoaderUtil.getmContext();
            if (charSequence == null) {
                charSequence = activity.getApplicationContext();
                ResourceLoaderUtil.setmContext((Context)charSequence);
            }
            charSequence = ResourceLoaderUtil.getString("hms_update_title");
            updateBean.setClientAppName((String)charSequence);
            intent = UpdateManager.getStartUpdateIntent(activity, updateBean);
        }
        return intent;
    }

    public PendingIntent getResolveErrorPendingIntent(Activity activity, int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter getResolveErrorPendingIntent, errorCode: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = "HuaweiApiAvailabilityImpl";
        HMSLog.i(string2, (String)charSequence);
        Intent intent = this.getResolveErrorIntent(activity, n10);
        if (intent != null) {
            charSequence = null;
            int n11 = 0x8000000;
            activity = PendingIntent.getActivity((Context)activity, (int)0, (Intent)intent, (int)n11);
        } else {
            activity = null;
        }
        return activity;
    }

    public int isHuaweiMobileNoticeAvailable(Context object) {
        int n10;
        Checker.checkNonNull(object, "context must not be null.");
        Object object2 = new PackageManagerHelper((Context)object);
        Object object3 = HMSPackageManager.getInstance((Context)object).getHMSPackageName();
        object2 = object2.getPackageStates((String)object3);
        object3 = PackageManagerHelper$PackageStates.NOT_INSTALLED;
        boolean n102 = ((Enum)object3).equals(object2);
        if (n102) {
            return 1;
        }
        boolean bl2 = ((HMSPackageManager)(object = HMSPackageManager.getInstance((Context)object))).isApkUpdateNecessary(n10 = 20600000);
        if (bl2) {
            return 2;
        }
        return 0;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int n10 = HuaweiApiAvailability.getServicesVersionCode();
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, n10);
    }

    public int isHuaweiMobileServicesAvailable(Context context, int n10) {
        Checker.checkNonNull(context, "context must not be null.");
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, n10);
    }

    public boolean isUserResolvableError(int n10) {
        return this.isUserResolvableError(n10, null);
    }

    public boolean isUserResolvableError(int n10, PendingIntent pendingIntent) {
        int n11;
        if (n10 == 0) {
            return false;
        }
        int n12 = 1;
        if (pendingIntent != null) {
            return n12;
        }
        if (n10 != n12 && n10 != (n11 = 2) && n10 != (n11 = 6)) {
            return false;
        }
        return n12;
    }

    public void popupErrNotification(Context context, ConnectionResult connectionResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(connectionResult);
        int n10 = connectionResult.getErrorCode();
        this.showErrorNotification(context, n10);
    }

    public void resolveError(Activity activity, int n10, int n11) {
        this.resolveError(activity, n10, n11, null);
    }

    public void resolveError(Activity object, int n10, int n11, PendingIntent object2) {
        String string2;
        CharSequence charSequence;
        Checker.checkNonNull(object, "activity must not be null.");
        String string3 = "HuaweiApiAvailabilityImpl";
        if (object2 != null) {
            charSequence = new StringBuilder();
            string2 = "Enter resolveError, param pendingIntent is not null. and.errorCode: ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            HMSLog.i(string3, (String)charSequence);
        } else {
            object2 = new StringBuilder();
            charSequence = "Enter resolveError, param pendingIntent is  null. get pendingIntent from error code.and.errorCode: ";
            ((StringBuilder)object2).append((String)charSequence);
            ((StringBuilder)object2).append(n10);
            object2 = ((StringBuilder)object2).toString();
            HMSLog.i(string3, (String)object2);
            object2 = this.getResolveErrorPendingIntent((Activity)object, n10);
        }
        if (object2 != null) {
            charSequence = new StringBuilder();
            string2 = "In resolveError, start pingding intent.errorCode: ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            HMSLog.i(string3, (String)charSequence);
            IntentSender intentSender = object2.getIntentSender();
            string2 = object;
            try {
                object.startIntentSenderForResult(intentSender, n11, null, 0, 0, 0);
            }
            catch (IntentSender.SendIntentException sendIntentException) {
                object = new StringBuilder();
                String string4 = "Enter resolveError, start pendingIntent failed.errorCode: ";
                ((StringBuilder)object).append(string4);
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
                HMSLog.e(string3, (String)object);
            }
        }
    }

    public boolean showErrorDialogFragment(Activity activity, int n10, int n11) {
        return this.showErrorDialogFragment(activity, n10, n11, null);
    }

    public boolean showErrorDialogFragment(Activity activity, int n10, int n11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialog = this.getErrorDialog(activity, n10, n11, onCancelListener);
        if (dialog == null) {
            return false;
        }
        com.huawei.hms.api.b.a(activity, dialog, "HuaweiMobileServicesErrorDialog", onCancelListener);
        return true;
    }

    public boolean showErrorDialogFragment(Activity activity, int n10, Fragment fragment, int n11, DialogInterface.OnCancelListener onCancelListener) {
        return this.showErrorDialogFragment(activity, n10, n11, onCancelListener);
    }

    public void showErrorNotification(Context context, int n10) {
        Checker.checkNonNull(context, "context must not be null.");
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter showErrorNotification, errorCode: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = "HuaweiApiAvailabilityImpl";
        HMSLog.i(string2, (String)charSequence);
        context = (Activity)context;
        charSequence = null;
        context = this.getErrorDialog((Activity)context, n10, 0);
        if (context == null) {
            HMSLog.i(string2, "showErrorNotification errorDialog can not be null");
            return;
        }
        context.show();
    }
}

