/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 *  org.xmlpull.v1.XmlPullParserFactory
 */
package com.xiaomi.push;

import com.xiaomi.push.fs;
import com.xiaomi.push.gd;
import com.xiaomi.push.gj;
import com.xiaomi.push.gm;
import com.xiaomi.push.gr;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class fo {
    private XmlPullParser a;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public fo() {
        XmlPullParserFactory xmlPullParserFactory;
        try {
            xmlPullParserFactory = XmlPullParserFactory.newInstance();
        }
        catch (XmlPullParserException xmlPullParserException) {
            return;
        }
        xmlPullParserFactory = xmlPullParserFactory.newPullParser();
        this.a = xmlPullParserFactory;
        String string2 = "http://xmlpull.org/v1/doc/features.html#process-namespaces";
        boolean bl2 = true;
        xmlPullParserFactory.setFeature(string2, bl2);
    }

    public gj a(byte[] object, fs object2) {
        Object object3 = this.a;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        object3.setInput((Reader)inputStreamReader);
        this.a.next();
        object = this.a;
        int n10 = object.getEventType();
        object3 = this.a.getName();
        int n11 = 2;
        if (n10 == n11) {
            object = "message";
            n10 = (int)(((String)object3).equals(object) ? 1 : 0);
            if (n10 != 0) {
                return gr.a(this.a);
            }
            object = "iq";
            n10 = (int)(((String)object3).equals(object) ? 1 : 0);
            if (n10 != 0) {
                return gr.a(this.a, (fs)object2);
            }
            object = "presence";
            n10 = (int)(((String)object3).equals(object) ? 1 : 0);
            if (n10 != 0) {
                return gr.a(this.a);
            }
            object = this.a.getName();
            n10 = (int)(((String)object).equals(object2 = "stream") ? 1 : 0);
            if (n10 == 0) {
                object = this.a.getName();
                n10 = (int)(((String)object).equals(object2 = "error") ? 1 : 0);
                if (n10 == 0) {
                    object = this.a.getName();
                    n10 = (int)(((String)object).equals(object2 = "warning") ? 1 : 0);
                    if (n10 != 0) {
                        this.a.next();
                        object = this.a.getName();
                        object2 = "multi-login";
                        n10 = (int)(((String)object).equals(object2) ? 1 : 0);
                    } else {
                        object = this.a.getName();
                        object2 = "bind";
                        ((String)object).equals(object2);
                    }
                } else {
                    object2 = gr.a(this.a);
                    object = new gd((gm)object2);
                    throw object;
                }
            }
        }
        return null;
    }
}

