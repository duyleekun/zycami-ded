/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package d.v.c.t0;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import com.zhiyun.cama.cloud_engine.CETemplateModel;
import d.v.c.t0.f0$a;
import java.io.Serializable;
import java.util.HashMap;

public class f0
implements NavArgs {
    private final HashMap a;

    private f0() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private f0(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ f0(HashMap hashMap, f0$a f0$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(f0 f02) {
        return f02.a;
    }

    public static f0 b(Bundle object) {
        Object object2 = new f0();
        Object object3 = f0.class.getClassLoader();
        object.setClassLoader((ClassLoader)object3);
        object3 = "templateModel";
        boolean bl2 = object.containsKey((String)object3);
        if (bl2) {
            Class clazz = Parcelable.class;
            Class<CETemplateModel> clazz2 = CETemplateModel.class;
            bl2 = clazz.isAssignableFrom(clazz2);
            if (!bl2 && !(bl2 = (clazz = Serializable.class).isAssignableFrom(clazz2 = CETemplateModel.class))) {
                object2 = new StringBuilder();
                object3 = CETemplateModel.class.getName();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(" must implement Parcelable or Serializable or must be an Enum.");
                object2 = ((StringBuilder)object2).toString();
                object = new UnsupportedOperationException((String)object2);
                throw object;
            }
            if ((object = (CETemplateModel)object.get((String)object3)) != null) {
                ((f0)object2).a.put(object3, object);
                return object2;
            }
            object = new IllegalArgumentException("Argument \"templateModel\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Required argument \"templateModel\" is missing and does not have an android:defaultValue");
        throw object;
    }

    public CETemplateModel c() {
        return (CETemplateModel)this.a.get("templateModel");
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bundle d() {
        Bundle bundle = new Bundle();
        Object object = this.a;
        String string2 = "templateModel";
        boolean bl2 = ((HashMap)object).containsKey(string2);
        if (!bl2) return bundle;
        object = (CETemplateModel)this.a.get(string2);
        Class clazz = Parcelable.class;
        Class<CETemplateModel> clazz2 = CETemplateModel.class;
        boolean bl3 = clazz.isAssignableFrom(clazz2);
        if (!bl3 && object != null) {
            clazz = Serializable.class;
            clazz2 = CETemplateModel.class;
            bl3 = clazz.isAssignableFrom(clazz2);
            if (bl3) {
                clazz = Serializable.class;
                object = (Serializable)clazz.cast(object);
                bundle.putSerializable(string2, (Serializable)object);
                return bundle;
            }
            object = new StringBuilder();
            string2 = CETemplateModel.class.getName();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" must implement Parcelable or Serializable or must be an Enum.");
            object = ((StringBuilder)object).toString();
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
            throw unsupportedOperationException;
        }
        clazz = Parcelable.class;
        object = (Parcelable)clazz.cast(object);
        bundle.putParcelable(string2, (Parcelable)object);
        return bundle;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            HashMap hashMap;
            boolean bl4;
            object = (f0)object;
            object3 = this.a;
            object2 = "templateModel";
            boolean bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((f0)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.c();
            if (object3 != null ? !(bl3 = (object3 = this.c()).equals(object = ((f0)object).c())) : (object = ((f0)object).c()) != null) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        CETemplateModel cETemplateModel = this.c();
        if (cETemplateModel != null) {
            cETemplateModel = this.c();
            n10 = cETemplateModel.hashCode();
        } else {
            n10 = 0;
            cETemplateModel = null;
        }
        return 31 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CETemplatePreviewDialogArgs{templateModel=");
        CETemplateModel cETemplateModel = this.c();
        stringBuilder.append(cETemplateModel);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

