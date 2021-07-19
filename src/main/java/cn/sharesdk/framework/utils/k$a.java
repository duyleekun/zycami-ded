/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class k$a
extends DefaultHandler {
    private HashMap a;
    private HashMap b;

    public k$a() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public HashMap a() {
        return this.a;
    }

    public void characters(char[] object, int n10, int n11) {
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = (Object)String.valueOf(object, n10, n11).trim())) ? 1 : 0)) != 0) {
            return;
        }
        HashMap hashMap = this.b;
        if (hashMap != null) {
            String string2 = "value";
            hashMap.put(string2, object);
        }
    }

    public void endElement(String string2, String string3, String string4) {
        this.b = null;
    }

    public void startElement(String hashMap, String string2, String object, Attributes attributes) {
        hashMap = this.b;
        if (hashMap != null) {
            hashMap = new HashMap();
            object = this.b;
            ((HashMap)object).put(string2, hashMap);
            this.b = hashMap;
        } else {
            this.b = hashMap = new HashMap();
            object = this.a;
            ((HashMap)object).put(string2, hashMap);
        }
        int n10 = attributes.getLength();
        string2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            object = this.b;
            String string3 = attributes.getLocalName(i10);
            String string4 = attributes.getValue(i10);
            ((HashMap)object).put(string3, string4);
        }
    }
}

