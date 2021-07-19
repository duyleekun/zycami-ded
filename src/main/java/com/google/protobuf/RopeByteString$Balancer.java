/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.RopeByteString$1;
import java.util.ArrayDeque;
import java.util.Arrays;

public class RopeByteString$Balancer {
    private final ArrayDeque prefixesStack;

    private RopeByteString$Balancer() {
        ArrayDeque arrayDeque;
        this.prefixesStack = arrayDeque = new ArrayDeque();
    }

    public /* synthetic */ RopeByteString$Balancer(RopeByteString.1 var1_1) {
        this();
    }

    public static /* synthetic */ ByteString access$100(RopeByteString$Balancer ropeByteString$Balancer, ByteString byteString, ByteString byteString2) {
        return ropeByteString$Balancer.balance(byteString, byteString2);
    }

    private ByteString balance(ByteString byteString, ByteString iterable) {
        boolean bl2;
        this.doBalance(byteString);
        this.doBalance((ByteString)iterable);
        byteString = (ByteString)this.prefixesStack.pop();
        while (!(bl2 = ((ArrayDeque)(iterable = this.prefixesStack)).isEmpty())) {
            iterable = (ByteString)this.prefixesStack.pop();
            RopeByteString ropeByteString = new RopeByteString((ByteString)iterable, byteString, null);
            byteString = ropeByteString;
        }
        return byteString;
    }

    private void doBalance(ByteString object) {
        block4: {
            block3: {
                boolean bl2;
                block2: {
                    bl2 = ((ByteString)object).isBalanced();
                    if (!bl2) break block2;
                    this.insert((ByteString)object);
                    break block3;
                }
                bl2 = object instanceof RopeByteString;
                if (!bl2) break block4;
                object = (RopeByteString)object;
                ByteString byteString = RopeByteString.access$400((RopeByteString)object);
                this.doBalance(byteString);
                object = RopeByteString.access$500((RopeByteString)object);
                this.doBalance((ByteString)object);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Has a new type of ByteString been created? Found ");
        object = object.getClass();
        stringBuilder.append(object);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private int getDepthBinForLength(int n10) {
        int[] nArray = RopeByteString.minLengthByDepth;
        if ((n10 = Arrays.binarySearch(nArray, n10)) < 0) {
            n10 = -(n10 + 1) + -1;
        }
        return n10;
    }

    private void insert(ByteString iterable) {
        int n10;
        int n102 = ((ByteString)iterable).size();
        n102 = this.getDepthBinForLength(n102);
        int n11 = RopeByteString.minLength(n102 + 1);
        Iterable iterable2 = this.prefixesStack;
        boolean n12 = ((ArrayDeque)iterable2).isEmpty();
        if (!n12 && (n10 = ((ByteString)(iterable2 = (ByteString)this.prefixesStack.peek())).size()) < n11) {
            int n13;
            int n14;
            n102 = RopeByteString.minLength(n102);
            ByteString byteString = (ByteString)this.prefixesStack.pop();
            while ((n14 = ((ArrayDeque)(iterable2 = this.prefixesStack)).isEmpty()) == 0 && (n14 = ((ByteString)(iterable2 = (ByteString)this.prefixesStack.peek())).size()) < n102) {
                iterable2 = (ByteString)this.prefixesStack.pop();
                RopeByteString ropeByteString = new RopeByteString((ByteString)iterable2, byteString, null);
                byteString = ropeByteString;
            }
            ByteString byteString2 = new RopeByteString(byteString, (ByteString)iterable, null);
            while ((n13 = ((ArrayDeque)(iterable = this.prefixesStack)).isEmpty()) == 0) {
                n13 = ((ByteString)byteString2).size();
                n13 = RopeByteString.minLength(this.getDepthBinForLength(n13) + 1);
                byteString = (ByteString)this.prefixesStack.peek();
                n11 = byteString.size();
                if (n11 >= n13) break;
                iterable = (ByteString)this.prefixesStack.pop();
                byteString = new RopeByteString((ByteString)iterable, byteString2, null);
                byteString2 = byteString;
            }
            iterable = this.prefixesStack;
            ((ArrayDeque)iterable).push(byteString2);
        } else {
            ArrayDeque arrayDeque = this.prefixesStack;
            arrayDeque.push(iterable);
        }
    }
}

