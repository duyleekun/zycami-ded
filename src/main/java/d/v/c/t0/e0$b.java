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
import androidx.navigation.NavDirections;
import com.zhiyun.cama.cloud_engine.CETemplateModel;
import d.v.c.t0.e0$a;
import java.io.Serializable;
import java.util.HashMap;

public class e0$b
implements NavDirections {
    private final HashMap a;

    private e0$b(CETemplateModel object) {
        HashMap<String, Object> hashMap;
        this.a = hashMap = new HashMap<String, Object>();
        if (object != null) {
            hashMap.put("templateModel", object);
            return;
        }
        object = new IllegalArgumentException("Argument \"templateModel\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public /* synthetic */ e0$b(CETemplateModel cETemplateModel, e0$a e0$a) {
        this(cETemplateModel);
    }

    public CETemplateModel a() {
        return (CETemplateModel)this.a.get("templateModel");
    }

    public e0$b b(CETemplateModel object) {
        if (object != null) {
            this.a.put("templateModel", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"templateModel\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            int n10;
            boolean bl3;
            HashMap hashMap;
            boolean bl4;
            object = (e0$b)object;
            object3 = this.a;
            object2 = "templateModel";
            boolean n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (bl4 = (hashMap = ((e0$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.a();
            if (object3 != null ? !(bl3 = (object3 = this.a()).equals(object2 = ((e0$b)object).a())) : (object3 = ((e0$b)object).a()) != null) {
                return false;
            }
            int n11 = this.getActionId();
            if (n11 != (n10 = ((e0$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int getActionId() {
        return 2131361987;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bundle getArguments() {
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

    public int hashCode() {
        int n10;
        CETemplateModel cETemplateModel = this.a();
        if (cETemplateModel != null) {
            cETemplateModel = this.a();
            n10 = cETemplateModel.hashCode();
        } else {
            n10 = 0;
            cETemplateModel = null;
        }
        int n11 = 31;
        n10 = (n10 + n11) * n11;
        n11 = this.getActionId();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionTemplateFragmentToCETemplatePreviewDialog(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append("){templateModel=");
        CETemplateModel cETemplateModel = this.a();
        stringBuilder.append(cETemplateModel);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

