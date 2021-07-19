/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata.icy;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IcyDecoder
extends SimpleMetadataDecoder {
    private static final Pattern METADATA_ELEMENT = Pattern.compile("(.+?)='(.*?)';", 32);
    private static final String STREAM_KEY_NAME = "streamtitle";
    private static final String STREAM_KEY_URL = "streamurl";
    private final CharsetDecoder iso88591Decoder;
    private final CharsetDecoder utf8Decoder;

    public IcyDecoder() {
        CharsetDecoder charsetDecoder;
        this.utf8Decoder = charsetDecoder = Charsets.UTF_8.newDecoder();
        this.iso88591Decoder = charsetDecoder = Charsets.ISO_8859_1.newDecoder();
    }

    private String decodeToString(ByteBuffer byteBuffer) {
        Object object = this.utf8Decoder;
        object = ((CharsetDecoder)object).decode(byteBuffer);
        try {
            object = ((CharBuffer)object).toString();
            this.utf8Decoder.reset();
        }
        catch (Throwable throwable) {
            this.utf8Decoder.reset();
            byteBuffer.rewind();
            throw throwable;
        }
        catch (CharacterCodingException characterCodingException) {
            object = this.utf8Decoder;
            ((CharsetDecoder)object).reset();
            byteBuffer.rewind();
            try {
                object = this.iso88591Decoder;
                object = ((CharsetDecoder)object).decode(byteBuffer);
                object = ((CharBuffer)object).toString();
                return object;
            }
            catch (CharacterCodingException characterCodingException2) {
                return null;
            }
            finally {
                this.iso88591Decoder.reset();
                byteBuffer.rewind();
            }
        }
        byteBuffer.rewind();
        return object;
    }

    public Metadata decode(MetadataInputBuffer object, ByteBuffer metadata$EntryArray) {
        object = this.decodeToString((ByteBuffer)metadata$EntryArray);
        int n10 = metadata$EntryArray.limit();
        byte[] byArray = new byte[n10];
        metadata$EntryArray.get(byArray);
        int n11 = 1;
        String string2 = null;
        if (object == null) {
            metadata$EntryArray = new Metadata$Entry[n11];
            IcyInfo icyInfo = new IcyInfo(byArray, null, null);
            metadata$EntryArray[0] = icyInfo;
            object = new Metadata(metadata$EntryArray);
            return object;
        }
        object = METADATA_ELEMENT.matcher((CharSequence)object);
        int n12 = 0;
        Object object2 = null;
        String string3 = null;
        while ((n12 = (int)(((Matcher)object).find(n12) ? 1 : 0)) != 0) {
            object2 = Util.toLowerInvariant(((Matcher)object).group(n11));
            int n13 = 2;
            String string4 = ((Matcher)object).group(n13);
            if (object2 != null) {
                ((String)object2).hashCode();
                String string5 = STREAM_KEY_URL;
                boolean bl2 = ((String)object2).equals(string5);
                if (!bl2) {
                    string5 = STREAM_KEY_NAME;
                    n12 = (int)(((String)object2).equals(string5) ? 1 : 0);
                    if (n12 != 0) {
                        string2 = string4;
                    }
                } else {
                    string3 = string4;
                }
            }
            n12 = ((Matcher)object).end();
        }
        metadata$EntryArray = new Metadata$Entry[n11];
        metadata$EntryArray[0] = object2 = new IcyInfo(byArray, string2, string3);
        object = new Metadata(metadata$EntryArray);
        return object;
    }
}

