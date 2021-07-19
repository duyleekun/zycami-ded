/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.TextFormat$Parser;
import com.google.protobuf.TextFormat$Parser$SingularOverwritePolicy;
import com.google.protobuf.TextFormatParseInfoTree$Builder;
import com.google.protobuf.TypeRegistry;

public class TextFormat$Parser$Builder {
    private boolean allowUnknownEnumValues = false;
    private boolean allowUnknownExtensions = false;
    private boolean allowUnknownFields = false;
    private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
    private TextFormat$Parser$SingularOverwritePolicy singularOverwritePolicy;
    private TypeRegistry typeRegistry;

    public TextFormat$Parser$Builder() {
        Object object;
        this.singularOverwritePolicy = object = TextFormat$Parser$SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
        this.parseInfoTreeBuilder = null;
        object = TypeRegistry.getEmptyTypeRegistry();
        this.typeRegistry = object;
    }

    public TextFormat$Parser build() {
        TypeRegistry typeRegistry = this.typeRegistry;
        boolean bl2 = this.allowUnknownFields;
        boolean bl3 = this.allowUnknownEnumValues;
        boolean bl4 = this.allowUnknownExtensions;
        TextFormat$Parser$SingularOverwritePolicy textFormat$Parser$SingularOverwritePolicy = this.singularOverwritePolicy;
        TextFormatParseInfoTree.Builder builder = this.parseInfoTreeBuilder;
        TextFormat$Parser textFormat$Parser = new TextFormat$Parser(typeRegistry, bl2, bl3, bl4, textFormat$Parser$SingularOverwritePolicy, builder, null);
        return textFormat$Parser;
    }

    public TextFormat$Parser$Builder setAllowUnknownExtensions(boolean bl2) {
        this.allowUnknownExtensions = bl2;
        return this;
    }

    public TextFormat$Parser$Builder setAllowUnknownFields(boolean bl2) {
        this.allowUnknownFields = bl2;
        return this;
    }

    public TextFormat$Parser$Builder setParseInfoTreeBuilder(TextFormatParseInfoTree.Builder builder) {
        this.parseInfoTreeBuilder = builder;
        return this;
    }

    public TextFormat$Parser$Builder setSingularOverwritePolicy(TextFormat$Parser$SingularOverwritePolicy textFormat$Parser$SingularOverwritePolicy) {
        this.singularOverwritePolicy = textFormat$Parser$SingularOverwritePolicy;
        return this;
    }

    public TextFormat$Parser$Builder setTypeRegistry(TypeRegistry typeRegistry) {
        this.typeRegistry = typeRegistry;
        return this;
    }
}

