/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.xmlpull.v1.XmlPullParser
 */
package com.xiaomi.push.service;

import com.xiaomi.push.gg;
import com.xiaomi.push.gp;
import com.xiaomi.push.gq;
import com.xiaomi.push.gu;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class e
implements gp {
    public static gg a(XmlPullParser object) {
        Object object2;
        String string2;
        String string3;
        int n10;
        int n11;
        String[] stringArray;
        Object object3;
        Object object4;
        int n12 = object.getEventType();
        int n13 = 2;
        int n14 = 0;
        if (n12 != n13) {
            return null;
        }
        String string4 = object.getName();
        String string5 = object.getNamespace();
        n12 = object.getAttributeCount();
        if (n12 > 0) {
            n12 = object.getAttributeCount();
            object4 = new String[n12];
            int n15 = object.getAttributeCount();
            object3 = new String[n15];
            stringArray = null;
            for (n11 = 0; n11 < (n10 = object.getAttributeCount()); ++n11) {
                object4[n11] = string3 = object.getAttributeName(n11);
                string3 = gu.b(object.getAttributeValue(n11));
                object3[n11] = string3;
            }
            stringArray = object4;
            string2 = null;
            object2 = null;
            string3 = object3;
        } else {
            n11 = 0;
            stringArray = null;
            n10 = 0;
            string3 = null;
            string2 = null;
            object2 = null;
        }
        while ((n12 = object.next()) != (n14 = 3)) {
            n14 = 4;
            if (n12 == n14) {
                object4 = object.getText();
                string2 = ((String)object4).trim();
                continue;
            }
            if (n12 != n13) continue;
            if (object2 == null) {
                object2 = object4 = new ArrayList();
            }
            if ((object4 = e.a(object)) == null) continue;
            object2.add(object4);
        }
        object3 = object;
        object = new gg(string4, string5, stringArray, (String[])string3, string2, (List)object2);
        return object;
    }

    public void a() {
        gq.a().a("all", "xm:chat", this);
    }

    public gg b(XmlPullParser xmlPullParser) {
        int n10;
        int n11 = xmlPullParser.getEventType();
        while (true) {
            int n12 = 1;
            n10 = 2;
            if (n11 == n12 || n11 == n10) break;
            n11 = xmlPullParser.next();
        }
        if (n11 == n10) {
            return e.a(xmlPullParser);
        }
        return null;
    }
}

