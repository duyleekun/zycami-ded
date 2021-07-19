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
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import d.v.c.t0.j0$a;
import java.io.Serializable;
import java.util.HashMap;

public class j0
implements NavArgs {
    private final HashMap a;

    private j0() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private j0(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ j0(HashMap hashMap, j0$a j0$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(j0 j02) {
        return j02.a;
    }

    public static j0 b(Bundle object) {
        Object object2 = new j0();
        Object object3 = j0.class.getClassLoader();
        object.setClassLoader((ClassLoader)object3);
        object3 = "templeteId";
        boolean bl2 = object.containsKey((String)object3);
        if (bl2) {
            long l10 = object.getLong((String)object3);
            HashMap hashMap = ((j0)object2).a;
            Class<Serializable> clazz = l10;
            hashMap.put(object3, clazz);
            object3 = "mediaArr";
            bl2 = object.containsKey((String)object3);
            if (bl2) {
                clazz = Parcelable.class;
                Class<UploadCEMediaInfo> clazz2 = UploadCEMediaInfo.class;
                bl2 = clazz.isAssignableFrom(clazz2);
                if (!bl2 && !(bl2 = (clazz = Serializable.class).isAssignableFrom(clazz2 = UploadCEMediaInfo.class))) {
                    object2 = new StringBuilder();
                    object3 = UploadCEMediaInfo.class.getName();
                    ((StringBuilder)object2).append((String)object3);
                    ((StringBuilder)object2).append(" must implement Parcelable or Serializable or must be an Enum.");
                    object2 = ((StringBuilder)object2).toString();
                    object = new UnsupportedOperationException((String)object2);
                    throw object;
                }
                if ((object = (UploadCEMediaInfo)object.get((String)object3)) != null) {
                    ((j0)object2).a.put(object3, object);
                    return object2;
                }
                object = new IllegalArgumentException("Argument \"mediaArr\" is marked as non-null but was passed a null value.");
                throw object;
            }
            object = new IllegalArgumentException("Required argument \"mediaArr\" is missing and does not have an android:defaultValue");
            throw object;
        }
        object = new IllegalArgumentException("Required argument \"templeteId\" is missing and does not have an android:defaultValue");
        throw object;
    }

    public UploadCEMediaInfo c() {
        return (UploadCEMediaInfo)this.a.get("mediaArr");
    }

    public long d() {
        return (Long)this.a.get("templeteId");
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bundle e() {
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

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            long l10;
            HashMap hashMap;
            boolean bl4;
            object = (j0)object;
            object3 = this.a;
            object2 = "templeteId";
            Object object4 = ((HashMap)object3).containsKey(object2);
            if (object4 != (bl4 = (hashMap = ((j0)object).a).containsKey(object2))) {
                return false;
            }
            long l11 = this.d();
            long l12 = l11 - (l10 = ((j0)object).d());
            object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4) {
                return false;
            }
            object3 = this.a;
            object2 = "mediaArr";
            object4 = ((HashMap)object3).containsKey(object2);
            if (object4 != (bl4 = (hashMap = ((j0)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.c();
            if (object3 != null ? !(bl3 = (object3 = this.c()).equals(object = ((j0)object).c())) : (object = ((j0)object).c()) != null) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        long l10 = this.d();
        long l11 = this.d();
        int n10 = 32;
        int n11 = (int)(l10 ^= (l11 >>>= n10));
        int n12 = 31;
        n11 = (n11 + n12) * n12;
        UploadCEMediaInfo uploadCEMediaInfo = this.c();
        if (uploadCEMediaInfo != null) {
            uploadCEMediaInfo = this.c();
            n12 = uploadCEMediaInfo.hashCode();
        } else {
            n12 = 0;
            uploadCEMediaInfo = null;
        }
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CEVideoSizeDialogArgs{templeteId=");
        long l10 = this.d();
        stringBuilder.append(l10);
        stringBuilder.append(", mediaArr=");
        UploadCEMediaInfo uploadCEMediaInfo = this.c();
        stringBuilder.append(uploadCEMediaInfo);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

