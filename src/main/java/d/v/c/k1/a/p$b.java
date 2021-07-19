/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package d.v.c.k1.a;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import d.v.c.k1.a.p$a;
import java.io.Serializable;
import java.util.HashMap;

public class p$b
implements NavDirections {
    private final HashMap a;

    private p$b(long l10, UploadCEMediaInfo uploadCEMediaInfo) {
        HashMap<String, Object> hashMap;
        this.a = hashMap = new HashMap<String, Object>();
        Serializable serializable = l10;
        String string2 = "templeteId";
        hashMap.put(string2, serializable);
        if (uploadCEMediaInfo != null) {
            hashMap.put("mediaArr", uploadCEMediaInfo);
            return;
        }
        super("Argument \"mediaArr\" is marked as non-null but was passed a null value.");
        throw serializable;
    }

    public /* synthetic */ p$b(long l10, UploadCEMediaInfo uploadCEMediaInfo, p$a p$a) {
        this(l10, uploadCEMediaInfo);
    }

    public UploadCEMediaInfo a() {
        return (UploadCEMediaInfo)this.a.get("mediaArr");
    }

    public long b() {
        return (Long)this.a.get("templeteId");
    }

    public p$b c(UploadCEMediaInfo object) {
        if (object != null) {
            this.a.put("mediaArr", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"mediaArr\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public p$b d(long l10) {
        HashMap hashMap = this.a;
        Long l11 = l10;
        hashMap.put("templeteId", l11);
        return this;
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
            long l10;
            HashMap hashMap;
            Object object4;
            object = (p$b)object;
            object3 = this.a;
            object2 = "templeteId";
            Object object5 = ((HashMap)object3).containsKey(object2);
            if (object5 != (object4 = (hashMap = ((p$b)object).a).containsKey(object2))) {
                return false;
            }
            long l11 = this.b();
            long l12 = l11 - (l10 = ((p$b)object).b());
            object5 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object5 != 0) {
                return false;
            }
            object3 = this.a;
            object2 = "mediaArr";
            object5 = ((HashMap)object3).containsKey(object2);
            if (object5 != (object4 = (hashMap = ((p$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.a();
            if (object3 != null ? (object5 = (Object)(object3 = this.a()).equals(object2 = ((p$b)object).a())) == 0 : (object3 = ((p$b)object).a()) != null) {
                return false;
            }
            object5 = this.getActionId();
            if (object5 != (n10 = ((p$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int getActionId() {
        return 2131361856;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        Object object = this.a;
        String string2 = "templeteId";
        boolean bl2 = ((HashMap)object).containsKey(string2);
        if (bl2) {
            object = (Long)this.a.get(string2);
            long l10 = (Long)object;
            bundle.putLong(string2, l10);
        }
        if (!(bl2 = ((HashMap)(object = this.a)).containsKey(string2 = "mediaArr"))) return bundle;
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
        long l10 = this.b();
        long l11 = this.b();
        int n11 = 32;
        int n12 = (int)(l10 ^= (l11 >>>= n11));
        int n13 = 31;
        n12 = (n12 + n13) * n13;
        UploadCEMediaInfo uploadCEMediaInfo = this.a();
        if (uploadCEMediaInfo != null) {
            uploadCEMediaInfo = this.a();
            n10 = uploadCEMediaInfo.hashCode();
        } else {
            n10 = 0;
            uploadCEMediaInfo = null;
        }
        n12 = (n12 + n10) * n13;
        n13 = this.getActionId();
        return n12 + n13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionAddVideoFragmentToCEVideoSizeDialog(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append("){templeteId=");
        long l10 = this.b();
        stringBuilder.append(l10);
        stringBuilder.append(", mediaArr=");
        UploadCEMediaInfo uploadCEMediaInfo = this.a();
        stringBuilder.append(uploadCEMediaInfo);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

