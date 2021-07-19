/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package androidx.media;

import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager$RemoteUserInfoImpl;

public class MediaSessionManagerImplBase$RemoteUserInfoImplBase
implements MediaSessionManager$RemoteUserInfoImpl {
    private String mPackageName;
    private int mPid;
    private int mUid;

    public MediaSessionManagerImplBase$RemoteUserInfoImplBase(String string2, int n10, int n11) {
        this.mPackageName = string2;
        this.mPid = n10;
        this.mUid = n11;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n11 = object instanceof MediaSessionManagerImplBase$RemoteUserInfoImplBase;
        if (n11 == 0) {
            return false;
        }
        object = (MediaSessionManagerImplBase$RemoteUserInfoImplBase)object;
        n11 = this.mPid;
        if (n11 >= 0 && (n11 = ((MediaSessionManagerImplBase$RemoteUserInfoImplBase)object).mPid) >= 0) {
            int n12;
            int n13;
            String string2 = this.mPackageName;
            String string3 = ((MediaSessionManagerImplBase$RemoteUserInfoImplBase)object).mPackageName;
            n11 = (int)(TextUtils.equals((CharSequence)string2, (CharSequence)string3) ? 1 : 0);
            if (n11 == 0 || (n11 = this.mPid) != (n13 = ((MediaSessionManagerImplBase$RemoteUserInfoImplBase)object).mPid) || (n11 = this.mUid) != (n12 = ((MediaSessionManagerImplBase$RemoteUserInfoImplBase)object).mUid)) {
                bl2 = false;
            }
            return bl2;
        }
        String string4 = this.mPackageName;
        String string5 = ((MediaSessionManagerImplBase$RemoteUserInfoImplBase)object).mPackageName;
        n11 = (int)(TextUtils.equals((CharSequence)string4, (CharSequence)string5) ? 1 : 0);
        if (n11 == 0 || (n11 = this.mUid) != (n10 = ((MediaSessionManagerImplBase$RemoteUserInfoImplBase)object).mUid)) {
            bl2 = false;
        }
        return bl2;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getPid() {
        return this.mPid;
    }

    public int getUid() {
        return this.mUid;
    }

    public int hashCode() {
        Object object = this.mPackageName;
        object = this.mUid;
        Object[] objectArray = new Object[]{object, object};
        return ObjectsCompat.hash(objectArray);
    }
}

