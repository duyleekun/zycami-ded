/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package j.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.fragment.app.Fragment;
import j.a.a.b$a;
import pub.devrel.easypermissions.AppSettingsDialogHolderActivity;

public class b
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final int j = 16061;
    public static final String k = "extra_app_settings";
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final int g;
    private Object h;
    private Context i;

    static {
        b$a b$a = new b$a();
        CREATOR = b$a;
    }

    private b(Parcel parcel) {
        int n10;
        String string2;
        int n11;
        this.a = n11 = parcel.readInt();
        this.b = string2 = parcel.readString();
        this.c = string2 = parcel.readString();
        this.d = string2 = parcel.readString();
        this.e = string2 = parcel.readString();
        this.f = n11 = parcel.readInt();
        this.g = n10 = parcel.readInt();
    }

    public /* synthetic */ b(Parcel parcel, b$a b$a) {
        this(parcel);
    }

    private b(Object object, int n10, String string2, String string3, String string4, String string5, int n11, int n12) {
        this.c(object);
        this.a = n10;
        this.b = string2;
        this.c = string3;
        this.d = string4;
        this.e = string5;
        this.f = n11;
        this.g = n12;
    }

    public /* synthetic */ b(Object object, int n10, String string2, String string3, String string4, String string5, int n11, int n12, b$a b$a) {
        this(object, n10, string2, string3, string4, string5, n11, n12);
    }

    public static b a(Intent object, Activity activity) {
        object = (b)object.getParcelableExtra(k);
        super.c(activity);
        return object;
    }

    private void c(Object object) {
        block4: {
            block3: {
                boolean bl2;
                block2: {
                    this.h = object;
                    bl2 = object instanceof Activity;
                    if (!bl2) break block2;
                    object = (Activity)object;
                    this.i = object;
                    break block3;
                }
                bl2 = object instanceof Fragment;
                if (!bl2) break block4;
                object = ((Fragment)object).getContext();
                this.i = object;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown object: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    private void f(Intent intent) {
        Object object = this.h;
        int n10 = object instanceof Activity;
        if (n10 != 0) {
            object = (Activity)object;
            n10 = this.f;
            object.startActivityForResult(intent, n10);
        } else {
            n10 = object instanceof Fragment;
            if (n10 != 0) {
                object = (Fragment)object;
                n10 = this.f;
                ((Fragment)object).startActivityForResult(intent, n10);
            }
        }
    }

    public int b() {
        return this.g;
    }

    public void d() {
        Intent intent = AppSettingsDialogHolderActivity.d(this.i, this);
        this.f(intent);
    }

    public int describeContents() {
        return 0;
    }

    public AlertDialog e(DialogInterface.OnClickListener object, DialogInterface.OnClickListener onClickListener) {
        Object object2;
        Object object3;
        int n10 = this.a;
        int n11 = -1;
        if (n10 != n11) {
            Context context = this.i;
            object3 = new AlertDialog$Builder(context, n10);
        } else {
            object2 = this.i;
            object3 = new AlertDialog$Builder((Context)object2);
        }
        object2 = ((AlertDialog$Builder)object3).setCancelable(false);
        object3 = this.c;
        object2 = ((AlertDialog$Builder)object2).setTitle((CharSequence)object3);
        object3 = this.b;
        object2 = ((AlertDialog$Builder)object2).setMessage((CharSequence)object3);
        object3 = this.d;
        object = ((AlertDialog$Builder)object2).setPositiveButton((CharSequence)object3, (DialogInterface.OnClickListener)object);
        object2 = this.e;
        return ((AlertDialog$Builder)object).setNegativeButton((CharSequence)object2, onClickListener).show();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.a;
        parcel.writeInt(n10);
        String string2 = this.b;
        parcel.writeString(string2);
        string2 = this.c;
        parcel.writeString(string2);
        string2 = this.d;
        parcel.writeString(string2);
        string2 = this.e;
        parcel.writeString(string2);
        n10 = this.f;
        parcel.writeInt(n10);
        n10 = this.g;
        parcel.writeInt(n10);
    }
}

