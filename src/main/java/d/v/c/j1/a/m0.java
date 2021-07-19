/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package d.v.c.j1.a;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import com.zhiyun.cama.data.database.model.Feedback;
import d.v.c.j1.a.m0$a;
import java.io.Serializable;
import java.util.HashMap;

public class m0
implements NavArgs {
    private final HashMap a;

    private m0() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private m0(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ m0(HashMap hashMap, m0$a m0$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(m0 m02) {
        return m02.a;
    }

    public static m0 b(Bundle object) {
        Object object2 = new m0();
        Object object3 = m0.class.getClassLoader();
        object.setClassLoader((ClassLoader)object3);
        object3 = "feedback";
        boolean bl2 = object.containsKey((String)object3);
        if (bl2) {
            Class<Parcelable> clazz = Parcelable.class;
            Class<Feedback> clazz2 = Feedback.class;
            bl2 = clazz.isAssignableFrom(clazz2);
            if (!bl2 && !(bl2 = (clazz = Serializable.class).isAssignableFrom(clazz2 = Feedback.class))) {
                object2 = new StringBuilder();
                object3 = Feedback.class.getName();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(" must implement Parcelable or Serializable or must be an Enum.");
                object2 = ((StringBuilder)object2).toString();
                object = new UnsupportedOperationException((String)object2);
                throw object;
            }
            object = (Feedback)object.get((String)object3);
            clazz = ((m0)object2).a;
            ((HashMap)((Object)clazz)).put(object3, object);
        } else {
            object = ((m0)object2).a;
            bl2 = false;
            Object var4_5 = null;
            ((HashMap)object).put(object3, null);
        }
        return object2;
    }

    public Feedback c() {
        return (Feedback)this.a.get("feedback");
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bundle d() {
        Bundle bundle = new Bundle();
        Object object = this.a;
        String string2 = "feedback";
        boolean bl2 = ((HashMap)object).containsKey(string2);
        if (!bl2) {
            bl2 = false;
            object = null;
            bundle.putSerializable(string2, null);
            return bundle;
        }
        object = (Feedback)this.a.get(string2);
        Class clazz = Parcelable.class;
        Class<Feedback> clazz2 = Feedback.class;
        boolean bl3 = clazz.isAssignableFrom(clazz2);
        if (!bl3 && object != null) {
            clazz = Serializable.class;
            clazz2 = Feedback.class;
            bl3 = clazz.isAssignableFrom(clazz2);
            if (bl3) {
                clazz = Serializable.class;
                object = (Serializable)clazz.cast(object);
                bundle.putSerializable(string2, (Serializable)object);
                return bundle;
            }
            object = new StringBuilder();
            string2 = Feedback.class.getName();
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
            object = (m0)object;
            object3 = this.a;
            object2 = "feedback";
            boolean bl5 = ((HashMap)object3).containsKey(object2);
            if (bl5 != (bl4 = (hashMap = ((m0)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.c();
            if (object3 != null ? !(bl3 = ((Feedback)(object3 = this.c())).equals(object = ((m0)object).c())) : (object = ((m0)object).c()) != null) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        Feedback feedback = this.c();
        if (feedback != null) {
            feedback = this.c();
            n10 = feedback.hashCode();
        } else {
            n10 = 0;
            feedback = null;
        }
        return 31 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FeedbackEditFragmentArgs{feedback=");
        Feedback feedback = this.c();
        stringBuilder.append(feedback);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

