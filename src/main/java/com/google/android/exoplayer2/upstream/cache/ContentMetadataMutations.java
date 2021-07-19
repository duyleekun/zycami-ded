/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentMetadataMutations {
    private final Map editedValues;
    private final List removedValues;

    public ContentMetadataMutations() {
        Cloneable cloneable;
        this.editedValues = cloneable = new Cloneable();
        this.removedValues = cloneable;
    }

    private ContentMetadataMutations checkAndSet(String string2, Object object) {
        Map map = this.editedValues;
        String string3 = (String)Assertions.checkNotNull(string2);
        object = Assertions.checkNotNull(object);
        map.put(string3, object);
        this.removedValues.remove(string2);
        return this;
    }

    public static ContentMetadataMutations setContentLength(ContentMetadataMutations contentMetadataMutations, long l10) {
        return contentMetadataMutations.set("exo_len", l10);
    }

    public static ContentMetadataMutations setRedirectedUri(ContentMetadataMutations contentMetadataMutations, Uri object) {
        String string2 = "exo_redir";
        if (object == null) {
            return contentMetadataMutations.remove(string2);
        }
        object = object.toString();
        return contentMetadataMutations.set(string2, (String)object);
    }

    public Map getEditedValues() {
        boolean bl2;
        Object object = this.editedValues;
        HashMap hashMap = new HashMap(object);
        object = hashMap.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Object object2 = entry.getValue();
            int n10 = object2 instanceof byte[];
            if (n10 == 0) continue;
            object2 = (byte[])object2;
            n10 = ((V)object2).length;
            object2 = Arrays.copyOf(object2, n10);
            entry.setValue(object2);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public List getRemovedValues() {
        List list = this.removedValues;
        ArrayList arrayList = new ArrayList(list);
        return Collections.unmodifiableList(arrayList);
    }

    public ContentMetadataMutations remove(String string2) {
        this.removedValues.add(string2);
        this.editedValues.remove(string2);
        return this;
    }

    public ContentMetadataMutations set(String string2, long l10) {
        Long l11 = l10;
        return this.checkAndSet(string2, l11);
    }

    public ContentMetadataMutations set(String string2, String string3) {
        return this.checkAndSet(string2, string3);
    }

    public ContentMetadataMutations set(String string2, byte[] byArray) {
        int n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        return this.checkAndSet(string2, byArray);
    }
}

