/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package d.v.c.n1;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import d.v.c.n1.m2$a;
import java.io.Serializable;
import java.util.HashMap;

public class m2$b
implements NavDirections {
    private final HashMap a;

    private m2$b(UploadCEMediaInfo object) {
        HashMap<String, Object> hashMap;
        this.a = hashMap = new HashMap<String, Object>();
        if (object != null) {
            hashMap.put("media", object);
            return;
        }
        object = new IllegalArgumentException("Argument \"media\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public /* synthetic */ m2$b(UploadCEMediaInfo uploadCEMediaInfo, m2$a m2$a) {
        this(uploadCEMediaInfo);
    }

    public UploadCEMediaInfo a() {
        return (UploadCEMediaInfo)this.a.get("media");
    }

    public m2$b b(UploadCEMediaInfo object) {
        if (object != null) {
            this.a.put("media", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"media\" is marked as non-null but was passed a null value.");
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
            object = (m2$b)object;
            object3 = this.a;
            object2 = "media";
            boolean n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (bl4 = (hashMap = ((m2$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.a();
            if (object3 != null ? !(bl3 = (object3 = this.a()).equals(object2 = ((m2$b)object).a())) : (object3 = ((m2$b)object).a()) != null) {
                return false;
            }
            int n11 = this.getActionId();
            if (n11 != (n10 = ((m2$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int getActionId() {
        return 2131361990;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        Object object = this.a;
        String string2 = "media";
        boolean bl2 = ((HashMap)object).containsKey(string2);
        if (!bl2) return bundle;
        object = (UploadCEMediaInfo)this.a.get(string2);
        Class clazz = Parcelable.class;
        Class<UploadCEMediaInfo> clazz2 = UploadCEMediaInfo.class;
        boolean bl3 = clazz.isAssignableFrom(clazz2);
        if (!bl3 && object != null) {
            clazz = Serializable.class;
            clazz2 = UploadCEMediaInfo.class;
            bl3 = clazz.isAssignableFrom(clazz2);
            if (bl3) {
                clazz = Serializable.class;
                object = (Serializable)clazz.cast(object);
                bundle.putSerializable(string2, (Serializable)object);
                return bundle;
            }
            object = new StringBuilder();
            string2 = UploadCEMediaInfo.class.getName();
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
        UploadCEMediaInfo uploadCEMediaInfo = this.a();
        if (uploadCEMediaInfo != null) {
            uploadCEMediaInfo = this.a();
            n10 = uploadCEMediaInfo.hashCode();
        } else {
            n10 = 0;
            uploadCEMediaInfo = null;
        }
        int n11 = 31;
        n10 = (n10 + n11) * n11;
        n11 = this.getActionId();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionUploadWorksFragmentToVideoCropFragment(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append("){media=");
        UploadCEMediaInfo uploadCEMediaInfo = this.a();
        stringBuilder.append(uploadCEMediaInfo);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

