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
import androidx.navigation.NavDirections;
import com.zhiyun.cama.album.AlbumSection;
import d.v.c.o0.r0$a;
import java.io.Serializable;
import java.util.HashMap;

public class r0$c
implements NavDirections {
    private final HashMap a;

    private r0$c(AlbumSection albumSection) {
        HashMap<String, AlbumSection> hashMap;
        this.a = hashMap = new HashMap<String, AlbumSection>();
        hashMap.put("section", albumSection);
    }

    public /* synthetic */ r0$c(AlbumSection albumSection, r0$a r0$a) {
        this(albumSection);
    }

    public AlbumSection a() {
        return (AlbumSection)this.a.get("section");
    }

    public r0$c b(AlbumSection albumSection) {
        this.a.put("section", albumSection);
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
            boolean bl3;
            HashMap hashMap;
            boolean bl4;
            object = (r0$c)object;
            object3 = this.a;
            object2 = "section";
            boolean n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (bl4 = (hashMap = ((r0$c)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.a();
            if (object3 != null ? !(bl3 = ((AlbumSection)(object3 = this.a())).equals(object2 = ((r0$c)object).a())) : (object3 = ((r0$c)object).a()) != null) {
                return false;
            }
            int n11 = this.getActionId();
            if (n11 != (n10 = ((r0$c)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int getActionId() {
        return 2131361875;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bundle getArguments() {
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

    public int hashCode() {
        int n10;
        AlbumSection albumSection = this.a();
        if (albumSection != null) {
            albumSection = this.a();
            n10 = albumSection.hashCode();
        } else {
            n10 = 0;
            albumSection = null;
        }
        int n11 = 31;
        n10 = (n10 + n11) * n11;
        n11 = this.getActionId();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionAlbumListFragmentToAlbumDetailFragment(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append("){section=");
        AlbumSection albumSection = this.a();
        stringBuilder.append(albumSection);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

