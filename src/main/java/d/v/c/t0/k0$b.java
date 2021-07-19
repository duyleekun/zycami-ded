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
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig$Resolution;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import d.v.c.t0.k0$a;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

public class k0$b
implements NavDirections {
    private final HashMap a;

    private k0$b(long l10, UploadCEMediaInfo[] uploadCEMediaInfoArray, CompositeConfig$Resolution compositeConfig$Resolution) {
        HashMap<Object, Object> hashMap;
        this.a = hashMap = new HashMap<Object, Object>();
        Object object = l10;
        String string2 = "templateId";
        hashMap.put(string2, object);
        if (uploadCEMediaInfoArray != null) {
            object = "mediaArr";
            hashMap.put(object, uploadCEMediaInfoArray);
            if (compositeConfig$Resolution != null) {
                hashMap.put("resolution", (Object)compositeConfig$Resolution);
                return;
            }
            object = new IllegalArgumentException("Argument \"resolution\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Argument \"mediaArr\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public /* synthetic */ k0$b(long l10, UploadCEMediaInfo[] uploadCEMediaInfoArray, CompositeConfig$Resolution compositeConfig$Resolution, k0$a k0$a) {
        this(l10, uploadCEMediaInfoArray, compositeConfig$Resolution);
    }

    public UploadCEMediaInfo[] a() {
        return (UploadCEMediaInfo[])this.a.get("mediaArr");
    }

    public CompositeConfig$Resolution b() {
        return (CompositeConfig$Resolution)((Object)this.a.get("resolution"));
    }

    public long c() {
        return (Long)this.a.get("templateId");
    }

    public k0$b d(UploadCEMediaInfo[] object) {
        if (object != null) {
            this.a.put("mediaArr", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"mediaArr\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public k0$b e(CompositeConfig$Resolution object) {
        if (object != null) {
            this.a.put("resolution", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"resolution\" is marked as non-null but was passed a null value.");
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
            long l10;
            HashMap hashMap;
            Object object4;
            object = (k0$b)object;
            object3 = this.a;
            object2 = "templateId";
            Object object5 = ((HashMap)object3).containsKey(object2);
            if (object5 != (object4 = (hashMap = ((k0$b)object).a).containsKey(object2))) {
                return false;
            }
            long l11 = this.c();
            long l12 = l11 - (l10 = ((k0$b)object).c());
            object5 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object5 != 0) {
                return false;
            }
            object3 = this.a;
            object2 = "mediaArr";
            object5 = ((HashMap)object3).containsKey(object2);
            if (object5 != (object4 = (hashMap = ((k0$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.a();
            if (object3 != null ? (object5 = (object3 = this.a()).equals(object2 = ((k0$b)object).a())) == 0 : (object3 = ((k0$b)object).a()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "resolution";
            object5 = ((HashMap)object3).containsKey(object2);
            if (object5 != (object4 = (hashMap = ((k0$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.b();
            if (object3 != null ? (object5 = (Object)((Enum)(object3 = this.b())).equals(object2 = ((k0$b)object).b())) == 0 : (object3 = ((k0$b)object).b()) != null) {
                return false;
            }
            object5 = this.getActionId();
            if (object5 != (n10 = ((k0$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public k0$b f(long l10) {
        HashMap hashMap = this.a;
        Long l11 = l10;
        hashMap.put("templateId", l11);
        return this;
    }

    public int getActionId() {
        return 2131361861;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bundle getArguments() {
        Object object = CompositeConfig$Resolution.class;
        Bundle bundle = new Bundle();
        Object object2 = this.a;
        String string2 = "templateId";
        boolean bl2 = ((HashMap)object2).containsKey(string2);
        if (bl2) {
            object2 = (Long)this.a.get(string2);
            long l10 = (Long)object2;
            bundle.putLong(string2, l10);
        }
        if (bl2 = ((HashMap)(object2 = this.a)).containsKey(string2 = "mediaArr")) {
            object2 = (UploadCEMediaInfo[])this.a.get(string2);
            bundle.putParcelableArray(string2, (Parcelable[])object2);
        }
        if (!(bl2 = ((HashMap)(object2 = this.a)).containsKey(string2 = "resolution"))) return bundle;
        object2 = (CompositeConfig$Resolution)((Object)this.a.get(string2));
        Class clazz = Parcelable.class;
        boolean bl3 = clazz.isAssignableFrom((Class<?>)object);
        if (!bl3 && object2 != null) {
            clazz = Serializable.class;
            bl3 = clazz.isAssignableFrom((Class<?>)object);
            if (bl3) {
                object = (Serializable)Serializable.class.cast(object2);
                bundle.putSerializable(string2, (Serializable)object);
                return bundle;
            }
            object2 = new StringBuilder();
            object = ((Class)object).getName();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" must implement Parcelable or Serializable or must be an Enum.");
            object = ((StringBuilder)object2).toString();
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
            throw unsupportedOperationException;
        }
        object = (Parcelable)Parcelable.class.cast(object2);
        bundle.putParcelable(string2, (Parcelable)object);
        return bundle;
    }

    public int hashCode() {
        long l10 = this.c();
        long l11 = this.c();
        int n10 = 32;
        int n11 = (int)(l10 ^= (l11 >>>= n10));
        int n12 = 31;
        n11 = (n11 + n12) * n12;
        int n13 = Arrays.hashCode(this.a());
        n11 = (n11 + n13) * n12;
        CompositeConfig$Resolution compositeConfig$Resolution = this.b();
        if (compositeConfig$Resolution != null) {
            compositeConfig$Resolution = this.b();
            n13 = compositeConfig$Resolution.hashCode();
        } else {
            n13 = 0;
            compositeConfig$Resolution = null;
        }
        n11 = (n11 + n13) * n12;
        n12 = this.getActionId();
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionCEVideoSizeDialogToCECompositeDialog(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append("){templateId=");
        long l10 = this.c();
        stringBuilder.append(l10);
        stringBuilder.append(", mediaArr=");
        Object object = this.a();
        stringBuilder.append(object);
        stringBuilder.append(", resolution=");
        object = this.b();
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

