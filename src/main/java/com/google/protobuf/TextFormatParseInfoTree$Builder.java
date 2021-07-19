/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.TextFormatParseInfoTree;
import com.google.protobuf.TextFormatParseInfoTree$1;
import com.google.protobuf.TextFormatParseLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextFormatParseInfoTree$Builder {
    private Map locationsFromField;
    private Map subtreeBuildersFromField;

    private TextFormatParseInfoTree$Builder() {
        HashMap hashMap;
        this.locationsFromField = hashMap = new HashMap();
        this.subtreeBuildersFromField = hashMap = new HashMap();
    }

    public /* synthetic */ TextFormatParseInfoTree$Builder(TextFormatParseInfoTree$1 textFormatParseInfoTree$1) {
        this();
    }

    public TextFormatParseInfoTree build() {
        Map map = this.locationsFromField;
        Map map2 = this.subtreeBuildersFromField;
        TextFormatParseInfoTree textFormatParseInfoTree = new TextFormatParseInfoTree(map, map2, null);
        return textFormatParseInfoTree;
    }

    public TextFormatParseInfoTree$Builder getBuilderForSubMessageField(Descriptors$FieldDescriptor object) {
        ArrayList<Object> arrayList = (ArrayList<Object>)this.subtreeBuildersFromField.get(object);
        if (arrayList == null) {
            arrayList = new ArrayList<Object>();
            Map map = this.subtreeBuildersFromField;
            map.put(object, arrayList);
        }
        object = new TextFormatParseInfoTree$Builder();
        arrayList.add(object);
        return object;
    }

    public TextFormatParseInfoTree$Builder setLocation(Descriptors$FieldDescriptor descriptors$FieldDescriptor, TextFormatParseLocation textFormatParseLocation) {
        ArrayList<TextFormatParseLocation> arrayList = (ArrayList<TextFormatParseLocation>)this.locationsFromField.get(descriptors$FieldDescriptor);
        if (arrayList == null) {
            arrayList = new ArrayList<TextFormatParseLocation>();
            Map map = this.locationsFromField;
            map.put(descriptors$FieldDescriptor, arrayList);
        }
        arrayList.add(textFormatParseLocation);
        return this;
    }
}

