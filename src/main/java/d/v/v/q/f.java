/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Movie
 *  android.text.TextUtils
 */
package d.v.v.q;

import android.content.Context;
import android.graphics.Movie;
import android.text.TextUtils;
import com.meicam.sdk.NvsAssetPackageManager;
import com.meicam.sdk.NvsStreamingContext;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.nvseditor.data.CustomerAssetInfo;
import com.zhiyun.nvseditor.data.NvsAssetInfo;
import d.m.a.b$a;
import d.m.a.c;
import d.v.e.l.k2;
import d.v.v.b;
import d.v.v.q.f$a;
import d.v.v.q.f$b;
import d.v.v.q.f$c;
import d.v.v.q.f$d;
import d.v.v.q.f$e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import m.a.a;

public class f {
    private NvsAssetPackageManager a;

    private f() {
        NvsAssetPackageManager nvsAssetPackageManager;
        this.a = nvsAssetPackageManager = NvsStreamingContext.getInstance().getAssetPackageManager();
    }

    public /* synthetic */ f(f$a a10) {
        this();
    }

    public static f d() {
        return f$e.a();
    }

    private int e(EditConfig$ResourceType editConfig$ResourceType) {
        int[] nArray = f$c.a;
        int n10 = editConfig$ResourceType.ordinal();
        n10 = nArray[n10];
        int n11 = 3;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                if (n10 != n11) {
                    return 0;
                }
                return n13;
            }
            return n12;
        }
        return n11;
    }

    private NvsAssetInfo h(String object, int n10) {
        NvsAssetInfo nvsAssetInfo = new NvsAssetInfo();
        String string2 = "/";
        int n11 = ((String)object).lastIndexOf(string2);
        int n12 = 1;
        Object object2 = ((String)object).substring(n11 += n12);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        String string3 = null;
        if (bl2) {
            return null;
        }
        object2 = object2.split("\\.");
        bl2 = false;
        NvsAssetPackageManager nvsAssetPackageManager = null;
        object2 = object2[0];
        int n13 = ((String)object).lastIndexOf(string2) + n12;
        string2 = ((String)object).substring(0, n13);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append((String)object2);
        string2 = ".lic";
        stringBuilder.append(string2);
        CharSequence charSequence = stringBuilder.toString();
        nvsAssetInfo.setAssetType(n10);
        nvsAssetInfo.setUuid((String)object2);
        nvsAssetInfo.setFilePath((String)object);
        Object object3 = nvsAssetInfo.getUuid();
        n10 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
        if (n10 != 0) {
            return null;
        }
        object3 = this.a;
        if (object3 == null) {
            return null;
        }
        nvsAssetInfo.setStatus(0);
        object3 = new StringBuilder();
        NvsAssetPackageManager nvsAssetPackageManager2 = this.a;
        int n14 = nvsAssetInfo.getPackageType();
        boolean bl3 = true;
        int n15 = nvsAssetPackageManager2.installAssetPackage((String)object, (String)charSequence, n14, bl3, (StringBuilder)object3);
        if (n15 != 0) {
            n13 = 2;
            if (n15 != n13) {
                nvsAssetInfo.setStatus(n13);
                return nvsAssetInfo;
            }
            object = this.a;
            string2 = nvsAssetInfo.getUuid();
            n11 = nvsAssetInfo.getPackageType();
            n15 = ((NvsAssetPackageManager)object).getAssetPackageVersion(string2, n11);
            nvsAssetInfo.setVersion(n15);
            object = this.a;
            string2 = nvsAssetInfo.getUuid();
            n11 = nvsAssetInfo.getPackageType();
            n15 = ((NvsAssetPackageManager)object).getAssetPackageSupportedAspectRatio(string2, n11);
            nvsAssetInfo.setAspectRation(n15);
            object = this.a;
            string2 = nvsAssetInfo.getFilePath();
            n15 = ((NvsAssetPackageManager)object).getAssetPackageVersionFromAssetPackageFilePath(string2);
            n13 = nvsAssetInfo.getVersion();
            if (n15 > n13) {
                nvsAssetPackageManager = this.a;
                string3 = nvsAssetInfo.getFilePath();
                stringBuilder = null;
                int n16 = nvsAssetInfo.getPackageType();
                n13 = nvsAssetPackageManager.upgradeAssetPackage(string3, null, n16, false, (StringBuilder)(charSequence = nvsAssetInfo.getPackageId()));
                if (n13 == 0) {
                    nvsAssetInfo.setVersion(n15);
                }
            }
            nvsAssetInfo.setPackageId((StringBuilder)object3);
            nvsAssetInfo.setStatus(n12);
            return nvsAssetInfo;
        }
        nvsAssetInfo.setStatus(n12);
        object = this.a;
        string2 = nvsAssetInfo.getUuid();
        n11 = nvsAssetInfo.getPackageType();
        n15 = ((NvsAssetPackageManager)object).getAssetPackageVersion(string2, n11);
        nvsAssetInfo.setVersion(n15);
        object = this.a;
        string2 = nvsAssetInfo.getUuid();
        n11 = nvsAssetInfo.getPackageType();
        n15 = ((NvsAssetPackageManager)object).getAssetPackageSupportedAspectRatio(string2, n11);
        nvsAssetInfo.setAspectRation(n15);
        nvsAssetInfo.setPackageId((StringBuilder)object3);
        return nvsAssetInfo;
    }

    public boolean a(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        int n10 = 1;
        if (bl2) {
            Object[] objectArray = new Object[n10];
            objectArray[0] = string2;
            m.a.a.i("file path is null :%s", objectArray);
            return false;
        }
        Object object = ".caf";
        bl2 = string2.endsWith((String)object);
        if (bl2) {
            return n10 != 0;
        }
        object = ".gif";
        bl2 = string2.endsWith((String)object);
        if (!bl2) {
            object = new Object[n10];
            object[0] = string2;
            m.a.a.i("file path not gif:%s", object);
            return false;
        }
        string2 = this.b(string2);
        object = new File(string2);
        return object.exists();
    }

    public String b(String string2) {
        String string3 = ".caf";
        int n10 = string2.endsWith(string3);
        if (n10 != 0) {
            return string2;
        }
        n10 = string2.lastIndexOf("/");
        string2 = string2.substring(n10);
        int n11 = string2.lastIndexOf(".");
        string2 = string2.substring(0, n11);
        CharSequence charSequence = new StringBuilder();
        CharSequence charSequence2 = k2.h().getAbsolutePath();
        charSequence.append((String)charSequence2);
        charSequence2 = File.separator;
        charSequence.append((String)charSequence2);
        charSequence = charSequence.toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append(string2);
        ((StringBuilder)charSequence2).append(string3);
        return ((StringBuilder)charSequence2).toString();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long c(String var1_1) {
        block14: {
            var2_9 = TextUtils.isEmpty((CharSequence)var1_1);
            var3_10 = -1;
            if (var2_9 != false) return var3_10;
            var5_11 = ".gif";
            var2_9 = var1_1.endsWith((String)var5_11);
            if (!var2_9) {
                return var3_10;
            }
            var2_9 = false;
            var5_11 = null;
            try {
                var6_13 = new FileInputStream(var1_1);
            }
            catch (Throwable var1_5) {
                break block14;
            }
            catch (FileNotFoundException var1_6) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var1_1 = Movie.decodeStream((InputStream)var6_13);
                var7_14 = var1_1.duration() * 1000;
            }
            catch (Throwable var1_3) {
                var5_11 = var6_13;
                break block14;
            }
            catch (FileNotFoundException var1_4) {
                var5_11 = var6_13;
                ** GOTO lbl-1000
            }
            var8_15 = var7_14;
            try {
                var6_13.close();
                return var8_15;
            }
            catch (IOException var1_2) {
                var1_2.printStackTrace();
            }
            return var8_15;
lbl-1000:
            // 2 sources

            {
                var1_1.printStackTrace();
                if (var5_11 == null) return var3_10;
            }
            try {
                var5_11.close();
                return var3_10;
            }
            catch (IOException var1_7) {
                var1_7.printStackTrace();
            }
            return var3_10;
        }
        if (var5_11 == null) throw var1_8;
        try {
            var5_11.close();
            throw var1_8;
        }
        catch (IOException var5_12) {
            var5_12.printStackTrace();
        }
        throw var1_8;
    }

    public void f(String object) {
        String string2;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0 && (n10 = ((String)object).endsWith(string2 = ".gif")) != 0) {
            n10 = ((String)object).lastIndexOf("/");
            string2 = ((String)object).substring(n10);
            int n11 = string2.lastIndexOf(".");
            string2 = string2.substring(0, n11);
            Object object2 = new StringBuilder();
            CharSequence charSequence = k2.h().getAbsolutePath();
            ((StringBuilder)object2).append((String)charSequence);
            charSequence = File.separator;
            ((StringBuilder)object2).append((String)charSequence);
            object2 = ((StringBuilder)object2).toString();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object2);
            long l10 = System.currentTimeMillis();
            ((StringBuilder)charSequence).append(l10);
            Object object3 = ".caf";
            ((StringBuilder)charSequence).append((String)object3);
            charSequence = ((StringBuilder)charSequence).toString();
            Object object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object2);
            ((StringBuilder)object4).append(string2);
            ((StringBuilder)object4).append((String)object3);
            string2 = ((StringBuilder)object4).toString();
            int n12 = 20;
            int n13 = 1;
            c c10 = new c(n12, n13);
            c c11 = new c(n13, n13);
            object3 = b.b();
            Context context = ((b)object3).a();
            int n14 = 2;
            int n15 = 1;
            object4 = object2;
            object2 = new d.m.a.b(context, (String)object, (String)charSequence, 0, 0, n14, c10, c11, n15);
            object = new f$b(this, (String)charSequence, string2);
            ((d.m.a.b)object2).k((b$a)object);
            ((d.m.a.b)object2).l();
        }
    }

    public void g(String object, f$d f$d) {
        String string2;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0 && (n10 = ((String)object).endsWith(string2 = ".gif")) != 0) {
            n10 = ((String)object).lastIndexOf("/");
            string2 = ((String)object).substring(n10);
            int n11 = string2.lastIndexOf(".");
            string2 = string2.substring(0, n11);
            Object object2 = new StringBuilder();
            Object object3 = k2.h().getAbsolutePath();
            ((StringBuilder)object2).append((String)object3);
            object3 = File.separator;
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(".caf");
            string2 = ((StringBuilder)object3).toString();
            int n12 = 20;
            n11 = 1;
            c c10 = new c(n12, n11);
            c c11 = new c(n11, n11);
            object3 = b.b();
            Context context = ((b)object3).a();
            int n13 = 2;
            int n14 = 1;
            object2 = new d.m.a.b(context, (String)object, string2, 0, 0, n13, c10, c11, n14);
            object = new f$a(this, (d.m.a.b)object2, f$d, string2);
            ((d.m.a.b)object2).k((b$a)object);
            ((d.m.a.b)object2).l();
        }
    }

    public boolean i(EditConfig$ResourceType editConfig$ResourceType, String string2, String string3) {
        int n10;
        StringBuilder stringBuilder;
        boolean bl2;
        NvsAssetPackageManager nvsAssetPackageManager = this.a;
        int n11 = this.e(editConfig$ResourceType);
        int n12 = nvsAssetPackageManager.installAssetPackage(string2, string3, n11, bl2 = true, stringBuilder = new StringBuilder());
        return n12 == 0 || n12 == (n10 = 2);
    }

    public NvsAssetInfo j(String string2) {
        return this.h(string2, 4);
    }

    public CustomerAssetInfo k(String string2) {
        int n10;
        int n11 = 2;
        Object object = this.h("assets:/E14FEE65-71A0-4717-9D66-3397B6C11223.5.animatedsticker", n11);
        if (object == null) {
            return null;
        }
        CustomerAssetInfo customerAssetInfo = new CustomerAssetInfo((NvsAssetInfo)object);
        int n12 = customerAssetInfo.getStatus();
        if (n12 == (n10 = 1)) {
            object = UUID.randomUUID().toString();
            customerAssetInfo.setCustomerUuid((String)object);
            customerAssetInfo.setCustomerPath(string2);
        }
        return customerAssetInfo;
    }

    public CustomerAssetInfo l(String string2) {
        int n10;
        int n11 = 2;
        Object object = this.h("assets:/E14FEE65-71A0-4717-9D66-3397B6C11223.5.animatedsticker", n11);
        if (object == null) {
            return null;
        }
        CustomerAssetInfo customerAssetInfo = new CustomerAssetInfo((NvsAssetInfo)object);
        int n12 = customerAssetInfo.getStatus();
        if (n12 == (n10 = 1)) {
            object = UUID.randomUUID().toString();
            customerAssetInfo.setCustomerUuid((String)object);
            customerAssetInfo.setCustomerPath(string2);
        }
        return customerAssetInfo;
    }

    public NvsAssetInfo m(String string2) {
        return this.h(string2, 1);
    }

    public CustomerAssetInfo n(String object) {
        int n10;
        if ((object = this.h((String)object, 2)) == null) {
            return null;
        }
        CustomerAssetInfo customerAssetInfo = new CustomerAssetInfo((NvsAssetInfo)object);
        int n11 = ((NvsAssetInfo)object).getStatus();
        if (n11 == (n10 = 1)) {
            return customerAssetInfo;
        }
        return null;
    }

    public NvsAssetInfo o(String string2) {
        return this.h(string2, 3);
    }
}

