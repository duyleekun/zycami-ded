/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.os.Bundle
 */
package d.v.x;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.zhiyun.permission.Permission;
import com.zhiyun.permission.R$string;
import d.v.e.l.o1;
import d.v.x.b;
import d.v.x.c$a;
import j.a.a.b$b;
import j.a.a.d;
import j.a.a.d$a;
import j.a.a.d$b;
import j.a.a.e;
import j.a.a.e$b;
import java.util.List;

public class c
extends Fragment
implements d$a,
d$b {
    private static final String e = "permission_helper";
    private static final int f = 122;
    private static final String g = "android.permission.CAMERA";
    private static final String h = "android.permission.READ_EXTERNAL_STORAGE";
    private static final String i = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String j = "android.permission.READ_PHONE_STATE";
    private static final String k = "android.permission.ACCESS_FINE_LOCATION";
    private static final String l = "android.permission.RECORD_AUDIO";
    private String a;
    private Permission b;
    private b c;
    private boolean d = false;

    private void getPermissions() {
        Object object = this.b;
        if (object == null) {
            return;
        }
        object = this.n((Permission)((Object)object));
        Object object2 = this.a;
        if (object2 == null) {
            object2 = this.b;
            object2 = this.l((Permission)((Object)object2));
        }
        this.a = object2;
        if (object == null) {
            return;
        }
        int n10 = ((String[])object).length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = object[i10];
            String[] stringArray = new String[]{string2};
            boolean bl2 = j.a.a.d.l(this, stringArray);
            if (!bl2) continue;
            this.a = object2 = this.m(string2);
            break;
        }
        if ((n10 = (int)(j.a.a.d.l(this, (String[])object) ? 1 : 0)) != 0) {
            object = new b$b(this);
            n10 = R$string.request_permission;
            object = ((b$b)object).k(n10);
            object2 = this.a;
            object = ((b$b)object).h((String)object2);
            n10 = R$string.cancel;
            object = ((b$b)object).b(n10);
            n10 = R$string.settings;
            object = ((b$b)object).e(n10).a();
            ((j.a.a.b)object).d();
        } else {
            n11 = 122;
            object2 = new e$b(this, n11, (String[])object);
            object = ((e$b)object2).a();
            j.a.a.d.i((e)object);
        }
    }

    public static /* synthetic */ String h(c c10, String string2) {
        c10.a = string2;
        return string2;
    }

    public static /* synthetic */ Permission i(c c10, Permission permission) {
        c10.b = permission;
        return permission;
    }

    public static /* synthetic */ b j(c c10, b b10) {
        c10.c = b10;
        return b10;
    }

    public static /* synthetic */ void k(c c10) {
        c10.getPermissions();
    }

    private String l(Permission object) {
        Resources resources = this.getResources();
        int[] nArray = c$a.a;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = "";
                break;
            }
            case 7: {
                n10 = R$string.permission_camera_rationale;
                object = o1.N(resources, n10);
                break;
            }
            case 6: {
                n10 = R$string.permission_location_rationale;
                object = o1.N(resources, n10);
                break;
            }
            case 5: {
                n10 = R$string.permission_storage_rationale;
                object = o1.N(resources, n10);
                break;
            }
            case 4: {
                n10 = R$string.permission_storage_rationale;
                object = o1.N(resources, n10);
                break;
            }
            case 3: {
                n10 = R$string.permission_record_rationale;
                object = o1.N(resources, n10);
                break;
            }
            case 2: {
                n10 = R$string.permission_camera_rationale;
                object = o1.N(resources, n10);
                break;
            }
            case 1: {
                n10 = R$string.permission_phone_rationale;
                object = o1.N(resources, n10);
            }
        }
        return object;
    }

    private String m(String string2) {
        int n10;
        Resources resources = this.getResources();
        string2.hashCode();
        int n11 = string2.hashCode();
        int n12 = -1;
        switch (n11) {
            default: {
                break;
            }
            case 1831139720: {
                String string3 = l;
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n12 = 5;
                break;
            }
            case 1365911975: {
                String string4 = i;
                n10 = (int)(string2.equals(string4) ? 1 : 0);
                if (n10 == 0) break;
                n12 = 4;
                break;
            }
            case 463403621: {
                String string5 = g;
                n10 = (int)(string2.equals(string5) ? 1 : 0);
                if (n10 == 0) break;
                n12 = 3;
                break;
            }
            case -5573545: {
                String string6 = j;
                n10 = (int)(string2.equals(string6) ? 1 : 0);
                if (n10 == 0) break;
                n12 = 2;
                break;
            }
            case -406040016: {
                String string7 = h;
                n10 = (int)(string2.equals(string7) ? 1 : 0);
                if (n10 == 0) break;
                n12 = 1;
                break;
            }
            case -1888586689: {
                String string8 = k;
                n10 = (int)(string2.equals(string8) ? 1 : 0);
                if (n10 == 0) break;
                n12 = 0;
            }
        }
        switch (n12) {
            default: {
                string2 = "";
                break;
            }
            case 5: {
                n10 = R$string.permission_record_rationale;
                string2 = o1.N(resources, n10);
                break;
            }
            case 3: {
                n10 = R$string.permission_camera_rationale;
                string2 = o1.N(resources, n10);
                break;
            }
            case 2: {
                n10 = R$string.permission_phone_rationale;
                string2 = o1.N(resources, n10);
                break;
            }
            case 1: 
            case 4: {
                n10 = R$string.permission_storage_rationale;
                string2 = o1.N(resources, n10);
                break;
            }
            case 0: {
                n10 = R$string.permission_location_rationale;
                string2 = o1.N(resources, n10);
            }
        }
        return string2;
    }

    private String[] n(Permission stringArray) {
        Object object = c$a.a;
        int n10 = stringArray.ordinal();
        n10 = object[n10];
        object = k;
        String string2 = l;
        String string3 = g;
        String string4 = i;
        String string5 = h;
        switch (n10) {
            default: {
                n10 = 0;
                stringArray = null;
                break;
            }
            case 7: {
                stringArray = new String[]{string5, string4, string3, string2};
                break;
            }
            case 6: {
                stringArray = new String[]{object};
                break;
            }
            case 5: {
                stringArray = new String[]{string5, string4, object};
                break;
            }
            case 4: {
                stringArray = new String[]{string5, string4};
                break;
            }
            case 3: {
                stringArray = new String[]{string2};
                break;
            }
            case 2: {
                stringArray = new String[]{string3};
                break;
            }
            case 1: {
                stringArray = new String[]{j};
            }
        }
        return stringArray;
    }

    public void c(int n10, List object) {
        int n11;
        Object object2 = this.c;
        if (object2 != null) {
            object2.a();
        }
        object2 = object.iterator();
        while ((n11 = object2.hasNext()) != 0) {
            object = (String)object2.next();
            String[] stringArray = new String[]{object};
            boolean bl2 = j.a.a.d.l(this, stringArray);
            if (!bl2) continue;
            this.a = object2 = this.m((String)object);
            break;
        }
        object2 = new b$b(this);
        n11 = R$string.request_permission;
        object2 = ((b$b)object2).k(n11);
        object = this.a;
        object2 = ((b$b)object2).h((String)object);
        n11 = R$string.cancel;
        object2 = ((b$b)object2).b(n11);
        n11 = R$string.settings;
        ((b$b)object2).e(n11).a().d();
    }

    public void d(int n10) {
        this.d = true;
    }

    public void f(int n10) {
        this.d = true;
    }

    public void g(int n10, List list) {
        Object object = this.b;
        if (object == null) {
            return;
        }
        if ((object = this.n((Permission)((Object)object))) == null) {
            return;
        }
        n10 = ((String[])object).length;
        int n11 = list.size();
        if (n10 == n11 && (object = this.c) != null) {
            object.b();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.getPermissions();
    }

    public void onRequestPermissionsResult(int n10, String[] stringArray, int[] nArray) {
        Object[] objectArray = new Object[]{this};
        j.a.a.d.d(n10, stringArray, nArray, objectArray);
    }
}

