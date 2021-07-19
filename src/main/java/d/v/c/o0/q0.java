/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package d.v.c.o0;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import com.zhiyun.cama.album.AlbumSection;
import d.v.c.o0.q0$a;
import java.io.Serializable;
import java.util.HashMap;

public class q0
implements NavArgs {
    private final HashMap a;

    private q0() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private q0(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ q0(HashMap hashMap, q0$a q0$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(q0 q02) {
        return q02.a;
    }

    public static q0 b(Bundle object) {
        Object object2 = new q0();
        Object object3 = q0.class.getClassLoader();
        object.setClassLoader((ClassLoader)object3);
        object3 = "section";
        boolean bl2 = object.containsKey((String)object3);
        if (bl2) {
            Class clazz = Parcelable.class;
            Class<AlbumSection> clazz2 = AlbumSection.class;
            bl2 = clazz.isAssignableFrom(clazz2);
            if (!bl2 && !(bl2 = (clazz = Serializable.class).isAssignableFrom(clazz2 = AlbumSection.class))) {
                object2 = new StringBuilder();
                object3 = AlbumSection.class.getName();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(" must implement Parcelable or Serializable or must be an Enum.");
                object2 = ((StringBuilder)object2).toString();
                object = new UnsupportedOperationException((String)object2);
                throw object;
            }
            if ((object = (AlbumSection)object.get((String)object3)) != null) {
                ((q0)object2).a.put(object3, object);
                return object2;
            }
            object = new IllegalArgumentException("Argument \"section\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Required argument \"section\" is missing and does not have an android:defaultValue");
        throw object;
    }

    public AlbumSection c() {
        return (AlbumSection)this.a.get("section");
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bundle d() {
        Bundle bundle = new Bundle();
        Object object = this.a;
        String string2 = "section";
        boolean bl2 = ((HashMap)object).containsKey(string2);
        if (!bl2) return bundle;
        object = (AlbumSection)this.a.get(string2);
        Class clazz = Parcelable.class;
        Class<AlbumSection> clazz2 = AlbumSection.class;
        boolean bl3 = clazz.isAssignableFrom(clazz2);
        if (!bl3 && object != null) {
            clazz = Serializable.class;
            clazz2 = AlbumSection.class;
            bl3 = clazz.isAssignableFrom(clazz2);
            if (bl3) {
                clazz = Serializable.class;
                object = (Serializable)clazz.cast(object);
                bundle.putSerializable(string2, (Serializable)object);
                return bundle;
            }
            object = new StringBuilder();
            string2 = AlbumSection.class.getName();
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
            object = (q0)object;
            object3 = this.a;
            object2 = "section";
            boolean bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((q0)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.c();
            if (object3 != null ? !(bl3 = ((AlbumSection)(object3 = this.c())).equals(object = ((q0)object).c())) : (object = ((q0)object).c()) != null) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        AlbumSection albumSection = this.c();
        if (albumSection != null) {
            albumSection = this.c();
            n10 = albumSection.hashCode();
        } else {
            n10 = 0;
            albumSection = null;
        }
        return 31 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AlbumInfoDialogArgs{section=");
        AlbumSection albumSection = this.c();
        stringBuilder.append(albumSection);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

