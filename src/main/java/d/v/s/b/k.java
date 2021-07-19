/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.RecoverableSecurityException
 *  android.content.ContentUris
 *  android.content.Context
 *  android.content.IntentSender
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.provider.MediaStore$Files
 */
package d.v.s.b;

import android.app.RecoverableSecurityException;
import android.content.ContentUris;
import android.content.Context;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.zhiyun.mediaprovider.data.MediaBean;
import com.zhiyun.mediaprovider.data.local.MediaDatabaseCommHelp;
import com.zhiyun.mediaprovider.data.local.dao.AlbumCustomizeDao;
import d.v.s.b.g$a;
import d.v.s.b.h;
import d.v.s.c.a;
import java.lang.ref.WeakReference;
import java.util.List;

public class k
implements h {
    private static final Uri c = MediaStore.Files.getContentUri((String)"external");
    private static final String d = "_id";
    private final WeakReference a;
    private final AlbumCustomizeDao b;

    private k(Context object) {
        Context context;
        this.a = context = new WeakReference(object);
        object = MediaDatabaseCommHelp.getInstance();
        context = (Context)context.get();
        this.b = object = ((MediaDatabaseCommHelp)object).getDataBase(context).albumCustomizeDao();
    }

    private int B(Uri uri, String string2, String[] stringArray, g$a g$a) {
        Context context = (Context)this.a.get();
        if (context == null) {
            return -3;
        }
        try {
            context = context.getContentResolver();
        }
        catch (SecurityException securityException) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 29;
            if (n10 >= n11 && (n10 = securityException instanceof RecoverableSecurityException) != 0 && g$a != null) {
                IntentSender intentSender = ((RecoverableSecurityException)securityException).getUserAction().getActionIntent().getIntentSender();
                g$a.a(intentSender);
            }
            return -4;
        }
        return context.delete(uri, string2, stringArray);
    }

    private void C(int n10) {
        this.b.deleteAlbumLikeData(n10);
    }

    private void D(int n10, String string2) {
        this.b.deleteAlbumLikeData(n10, string2);
    }

    public static k E(Context context) {
        k k10 = new k(context);
        return k10;
    }

    public int b(MediaBean object, g$a g$a) {
        int n10;
        Uri uri = ((MediaBean)object).getUri();
        int n11 = this.B(uri, null, null, g$a);
        if (n11 == (n10 = 1)) {
            n10 = (int)(d.v.s.c.a.a() ? 1 : 0);
            if (n10 != 0) {
                int n12 = ((MediaBean)object).getId();
                this.C(n12);
            } else {
                n10 = ((MediaBean)object).getId();
                object = ((MediaBean)object).getPath();
                this.D(n10, (String)object);
            }
        }
        return n11;
    }

    public int g(Uri uri) {
        return this.z(uri, null);
    }

    public int h(MediaBean mediaBean) {
        return this.b(mediaBean, null);
    }

    public int m(List list) {
        return this.p(list, null);
    }

    public int p(List object, g$a g$a) {
        int n10;
        int n11 = object.size();
        if (n11 == 0) {
            return -2;
        }
        n11 = 0;
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            int n12;
            Object object2 = (MediaBean)object.next();
            Uri uri = ((MediaBean)object2).getUri();
            int n13 = this.B(uri, null, null, g$a);
            if (n13 != (n12 = 1)) continue;
            ++n11;
            n13 = (int)(d.v.s.c.a.a() ? 1 : 0);
            if (n13 != 0) {
                n10 = ((MediaBean)object2).getId();
                this.C(n10);
                continue;
            }
            n13 = ((MediaBean)object2).getId();
            object2 = ((MediaBean)object2).getPath();
            this.D(n13, (String)object2);
        }
        return n11;
    }

    public int q(Uri[] uriArray, g$a g$a) {
        int n10 = uriArray.length;
        if (n10 == 0) {
            return -2;
        }
        n10 = uriArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12;
            Uri uri = uriArray[i10];
            int n13 = this.B(uri, null, null, g$a);
            if (n13 != (n12 = 1)) continue;
            ++n11;
            long l10 = ContentUris.parseId((Uri)uri);
            int n14 = (int)l10;
            this.C(n14);
        }
        return n11;
    }

    public int t(int n10) {
        Uri uri = c;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("_id = ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        int n11 = this.B(uri, (String)charSequence, null, null);
        int n12 = 1;
        if (n11 == n12) {
            this.C(n10);
        }
        return n11;
    }

    public int u(int[] nArray) {
        int n10 = nArray.length;
        if (n10 == 0) {
            return -2;
        }
        n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Uri uri = c;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("_id = ");
            charSequence.append(n12);
            charSequence = charSequence.toString();
            int n13 = this.B(uri, (String)charSequence, null, null);
            int n14 = 1;
            if (n13 != n14) continue;
            ++n11;
            this.C(n12);
        }
        return n11;
    }

    public int v(Uri[] uriArray) {
        return this.q(uriArray, null);
    }

    public int z(Uri uri, g$a g$a) {
        int n10;
        int n11 = this.B(uri, null, null, g$a);
        if (n11 == (n10 = 1)) {
            long l10 = ContentUris.parseId((Uri)uri);
            int n12 = (int)l10;
            this.C(n12);
        }
        return n11;
    }
}

