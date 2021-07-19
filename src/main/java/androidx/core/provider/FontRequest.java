/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import java.util.List;

public final class FontRequest {
    private final List mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;

    public FontRequest(String string2, String string3, String string4, int n10) {
        String string5;
        this.mProviderAuthority = string5 = (String)Preconditions.checkNotNull(string2);
        this.mProviderPackage = string5 = (String)Preconditions.checkNotNull(string3);
        this.mQuery = string5 = (String)Preconditions.checkNotNull(string4);
        boolean bl2 = false;
        string5 = null;
        this.mCertificates = null;
        if (n10 != 0) {
            bl2 = true;
        } else {
            bl2 = false;
            string5 = null;
        }
        Preconditions.checkArgument(bl2);
        this.mCertificatesArray = n10;
        this.mIdentifier = string2 = this.createIdentifier(string2, string3, string4);
    }

    public FontRequest(String string2, String string3, String string4, List list) {
        String string5;
        this.mProviderAuthority = string5 = (String)Preconditions.checkNotNull(string2);
        this.mProviderPackage = string5 = (String)Preconditions.checkNotNull(string3);
        this.mQuery = string5 = (String)Preconditions.checkNotNull(string4);
        this.mCertificates = list = (List)Preconditions.checkNotNull(list);
        this.mCertificatesArray = 0;
        this.mIdentifier = string2 = this.createIdentifier(string2, string3, string4);
    }

    private String createIdentifier(String string2, String string3, String string4) {
        StringBuilder stringBuilder = new StringBuilder(string2);
        string2 = "-";
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public List getCertificates() {
        return this.mCertificates;
    }

    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    public String getId() {
        return this.mIdentifier;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public String toString() {
        Object object;
        int n10;
        int n11;
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("FontRequest {mProviderAuthority: ");
        String string2 = this.mProviderAuthority;
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(", mProviderPackage: ");
        string2 = this.mProviderPackage;
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(", mQuery: ");
        string2 = this.mQuery;
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(", mCertificates:");
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = null;
        string2 = null;
        for (n11 = 0; n11 < (n10 = (object = this.mCertificates).size()); ++n11) {
            int n12;
            stringBuilder.append(" [");
            object = (List)this.mCertificates.get(n11);
            for (int i10 = 0; i10 < (n12 = object.size()); ++i10) {
                stringBuilder.append(" \"");
                String string3 = Base64.encodeToString((byte[])((byte[])object.get(i10)), (int)0);
                stringBuilder.append(string3);
                string3 = "\"";
                stringBuilder.append(string3);
            }
            object = " ]";
            stringBuilder.append((String)object);
        }
        stringBuilder.append("}");
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("mCertificatesArray: ");
        n11 = this.mCertificatesArray;
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        return stringBuilder.toString();
    }
}

