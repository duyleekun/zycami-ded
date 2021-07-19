/*
 * Decompiled with CFR 0.151.
 */
package com.mob;

import com.mob.MobCommunicator;
import com.mob.MobCommunicator$NetworkError;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.utils.Hashon;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;

public class MobCommunicator$3
implements HttpResponseCallback {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ MobCommunicator c;

    public MobCommunicator$3(MobCommunicator mobCommunicator, String[] stringArray, byte[] byArray) {
        this.c = mobCommunicator;
        this.a = stringArray;
        this.b = byArray;
    }

    public void onResponse(HttpConnection object) {
        int n10;
        int n11;
        int n12 = object.getResponseCode();
        Object object2 = n12 == (n11 = 200) ? object.getInputStream() : object.getErrorStream();
        Object object3 = new ByteArrayOutputStream();
        int n13 = 1024;
        byte[] byArray = new byte[n13];
        int n14 = ((InputStream)object2).read(byArray);
        while (n14 != (n10 = -1)) {
            ((ByteArrayOutputStream)object3).write(byArray, 0, n14);
            n14 = ((InputStream)object2).read(byArray);
        }
        ((InputStream)object2).close();
        ((ByteArrayOutputStream)object3).close();
        object2 = ((ByteArrayOutputStream)object3).toByteArray();
        object3 = "httpStatus";
        if (n12 == n11) {
            long l10;
            long l11;
            Object object4 = this.c;
            long l12 = MobCommunicator.a((MobCommunicator)object4, (HttpConnection)object);
            long l13 = l12 - (l11 = (long)-1);
            Object object5 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object5 != false && (object5 = (l10 = l12 - (l11 = (long)((Object)object2).length)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
                object = this.a;
                Object object6 = this.c;
                object4 = this.b;
                object[0] = object6 = MobCommunicator.a((MobCommunicator)object6, (byte[])object4, (byte[])object2);
                return;
            }
            object = new HashMap();
            Serializable serializable = n12;
            ((HashMap)object).put(object3, serializable);
            serializable = -2;
            ((HashMap)object).put("status", serializable);
            ((HashMap)object).put("error", "Illegal content length");
            object = MobCommunicator.a(this.c).fromHashMap((HashMap)object);
            serializable = new MobCommunicator$NetworkError((String)object);
            throw serializable;
        }
        object = MobCommunicator.a(this.c);
        String string2 = new String((byte[])object2, "utf-8");
        object = ((Hashon)object).fromJson(string2);
        Serializable serializable = n12;
        ((HashMap)object).put(object3, serializable);
        object = MobCommunicator.a(this.c).fromHashMap((HashMap)object);
        serializable = new MobCommunicator$NetworkError((String)object);
        throw serializable;
    }
}

