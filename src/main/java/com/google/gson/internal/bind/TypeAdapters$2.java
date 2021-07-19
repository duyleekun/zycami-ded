/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters$36;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.BitSet;

public class TypeAdapters$2
extends TypeAdapter {
    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public BitSet read(JsonReader object) {
        Object object2 = new BitSet();
        ((JsonReader)object).beginArray();
        JsonToken jsonToken = ((JsonReader)object).peek();
        int n10 = 0;
        while (true) {
            int n11;
            block15: {
                block13: {
                    int n12;
                    block14: {
                        JsonToken jsonToken2;
                        void var3_4;
                        if (var3_4 == (jsonToken2 = JsonToken.END_ARRAY)) {
                            ((JsonReader)object).endArray();
                            return object2;
                        }
                        int[] nArray = TypeAdapters$36.$SwitchMap$com$google$gson$stream$JsonToken;
                        n11 = var3_4.ordinal();
                        int n13 = nArray[n11];
                        if (n13 == (n11 = 1)) break block14;
                        int n14 = 2;
                        if (n13 != n14) {
                            n14 = 3;
                            if (n13 != n14) {
                                object2 = new StringBuilder();
                                ((StringBuilder)object2).append("Invalid bitset value type: ");
                                ((StringBuilder)object2).append(var3_4);
                                object2 = ((StringBuilder)object2).toString();
                                object = new JsonSyntaxException((String)object2);
                                throw object;
                            }
                            String string2 = ((JsonReader)object).nextString();
                            try {
                                n12 = Integer.parseInt(string2);
                                if (n12 != 0) {
                                }
                                break block13;
                            }
                            catch (NumberFormatException numberFormatException) {
                                object2 = new StringBuilder();
                                ((StringBuilder)object2).append("Error: Expecting: bitset number value (1, 0), Found: ");
                                ((StringBuilder)object2).append(string2);
                                object2 = ((StringBuilder)object2).toString();
                                object = new JsonSyntaxException((String)object2);
                                throw object;
                            }
                        }
                        n11 = (int)(((JsonReader)object).nextBoolean() ? 1 : 0);
                        break block15;
                    }
                    n12 = ((JsonReader)object).nextInt();
                    if (n12 != 0) break block15;
                }
                n11 = 0;
            }
            if (n11 != 0) {
                ((BitSet)object2).set(n10);
            }
            ++n10;
            JsonToken jsonToken3 = ((JsonReader)object).peek();
        }
    }

    public void write(JsonWriter jsonWriter, BitSet bitSet) {
        jsonWriter.beginArray();
        int n10 = bitSet.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = bitSet.get(i10);
            long l10 = n11;
            jsonWriter.value(l10);
        }
        jsonWriter.endArray();
    }
}

