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
import androidx.navigation.NavDirections;
import com.zhiyun.cama.data.database.model.Feedback;
import d.v.c.j1.a.l0$a;
import java.io.Serializable;
import java.util.HashMap;

public class l0$b
implements NavDirections {
    private final HashMap a;

    private l0$b() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public /* synthetic */ l0$b(l0$a l0$a) {
        this();
    }

    public Feedback a() {
        return (Feedback)this.a.get("feedback");
    }

    public l0$b b(Feedback feedback) {
        this.a.put("feedback", feedback);
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
            object = (l0$b)object;
            object3 = this.a;
            object2 = "feedback";
            boolean n12 = ((HashMap)object3).containsKey(object2);
            if (n12 != (bl4 = (hashMap = ((l0$b)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.a();
            if (object3 != null ? !(bl3 = ((Feedback)(object3 = this.a())).equals(object2 = ((l0$b)object).a())) : (object3 = ((l0$b)object).a()) != null) {
                return false;
            }
            int n11 = this.getActionId();
            if (n11 != (n10 = ((l0$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int getActionId() {
        return 2131361922;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bundle getArguments() {
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

    public int hashCode() {
        int n10;
        Feedback feedback = this.a();
        if (feedback != null) {
            feedback = this.a();
            n10 = feedback.hashCode();
        } else {
            n10 = 0;
            feedback = null;
        }
        int n11 = 31;
        n10 = (n10 + n11) * n11;
        n11 = this.getActionId();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionFeedbackDetailFragmentToFeedbackEditFragment(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append("){feedback=");
        Feedback feedback = this.a();
        stringBuilder.append(feedback);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

