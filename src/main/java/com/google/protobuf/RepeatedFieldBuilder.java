/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.RepeatedFieldBuilder$BuilderExternalList;
import com.google.protobuf.RepeatedFieldBuilder$MessageExternalList;
import com.google.protobuf.RepeatedFieldBuilder$MessageOrBuilderExternalList;
import com.google.protobuf.SingleFieldBuilder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RepeatedFieldBuilder
implements GeneratedMessage$BuilderParent {
    private List builders;
    private RepeatedFieldBuilder$BuilderExternalList externalBuilderList;
    private RepeatedFieldBuilder$MessageExternalList externalMessageList;
    private RepeatedFieldBuilder$MessageOrBuilderExternalList externalMessageOrBuilderList;
    private boolean isClean;
    private boolean isMessagesListMutable;
    private List messages;
    private GeneratedMessage$BuilderParent parent;

    public RepeatedFieldBuilder(List list, boolean bl2, GeneratedMessage$BuilderParent generatedMessage$BuilderParent, boolean bl3) {
        this.messages = list;
        this.isMessagesListMutable = bl2;
        this.parent = generatedMessage$BuilderParent;
        this.isClean = bl3;
    }

    private void ensureBuilders() {
        ArrayList arrayList = this.builders;
        if (arrayList == null) {
            List list = this.messages;
            int n10 = list.size();
            this.builders = arrayList = new ArrayList(n10);
            arrayList = null;
            for (int i10 = 0; i10 < (n10 = (list = this.messages).size()); ++i10) {
                list = this.builders;
                list.add(null);
            }
        }
    }

    private void ensureMutableMessageList() {
        boolean bl2 = this.isMessagesListMutable;
        if (!bl2) {
            ArrayList arrayList;
            List list = this.messages;
            this.messages = arrayList = new ArrayList(list);
            this.isMessagesListMutable = bl2 = true;
        }
    }

    private GeneratedMessage getMessage(int n10, boolean bl2) {
        Object object = this.builders;
        if (object == null) {
            return (GeneratedMessage)this.messages.get(n10);
        }
        if ((object = (SingleFieldBuilder)object.get(n10)) == null) {
            return (GeneratedMessage)this.messages.get(n10);
        }
        GeneratedMessage generatedMessage = bl2 ? ((SingleFieldBuilder)object).build() : ((SingleFieldBuilder)object).getMessage();
        return generatedMessage;
    }

    private void incrementModCounts() {
        AbstractList abstractList = this.externalMessageList;
        if (abstractList != null) {
            ((RepeatedFieldBuilder$MessageExternalList)abstractList).incrementModCount();
        }
        if ((abstractList = this.externalBuilderList) != null) {
            ((RepeatedFieldBuilder$BuilderExternalList)abstractList).incrementModCount();
        }
        if ((abstractList = this.externalMessageOrBuilderList) != null) {
            ((RepeatedFieldBuilder$MessageOrBuilderExternalList)abstractList).incrementModCount();
        }
    }

    private void onChanged() {
        GeneratedMessage$BuilderParent generatedMessage$BuilderParent;
        boolean bl2 = this.isClean;
        if (bl2 && (generatedMessage$BuilderParent = this.parent) != null) {
            generatedMessage$BuilderParent.markDirty();
            bl2 = false;
            generatedMessage$BuilderParent = null;
            this.isClean = false;
        }
    }

    public RepeatedFieldBuilder addAllMessages(Iterable object) {
        boolean bl2;
        Object object2;
        int n10;
        Object object3 = object.iterator();
        while ((n10 = object3.hasNext()) != 0) {
            object2 = (GeneratedMessage)object3.next();
            Internal.checkNotNull(object2);
        }
        int n11 = -1;
        n10 = object instanceof Collection;
        if (n10 != 0) {
            object3 = object;
            object3 = (Collection)object;
            n10 = object3.size();
            if (n10 == 0) {
                return this;
            }
            n11 = object3.size();
        }
        this.ensureMutableMessageList();
        if (n11 >= 0 && (bl2 = (object2 = this.messages) instanceof ArrayList)) {
            Object object4 = object2;
            object4 = (ArrayList)object2;
            n10 = ((List)object2).size() + n11;
            ((ArrayList)object4).ensureCapacity(n10);
        }
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object3 = (GeneratedMessage)object.next();
            this.addMessage((GeneratedMessage)object3);
        }
        this.onChanged();
        this.incrementModCounts();
        return this;
    }

    public GeneratedMessage$Builder addBuilder(int n10, GeneratedMessage generatedMessage) {
        this.ensureMutableMessageList();
        this.ensureBuilders();
        boolean bl2 = this.isClean;
        SingleFieldBuilder singleFieldBuilder = new SingleFieldBuilder(generatedMessage, this, bl2);
        this.messages.add(n10, null);
        this.builders.add(n10, singleFieldBuilder);
        this.onChanged();
        this.incrementModCounts();
        return singleFieldBuilder.getBuilder();
    }

    public GeneratedMessage$Builder addBuilder(GeneratedMessage generatedMessage) {
        this.ensureMutableMessageList();
        this.ensureBuilders();
        boolean bl2 = this.isClean;
        SingleFieldBuilder singleFieldBuilder = new SingleFieldBuilder(generatedMessage, this, bl2);
        this.messages.add(null);
        this.builders.add(singleFieldBuilder);
        this.onChanged();
        this.incrementModCounts();
        return singleFieldBuilder.getBuilder();
    }

    public RepeatedFieldBuilder addMessage(int n10, GeneratedMessage object) {
        Internal.checkNotNull(object);
        this.ensureMutableMessageList();
        List list = this.messages;
        list.add(n10, object);
        object = this.builders;
        if (object != null) {
            list = null;
            object.add(n10, null);
        }
        this.onChanged();
        this.incrementModCounts();
        return this;
    }

    public RepeatedFieldBuilder addMessage(GeneratedMessage object) {
        Internal.checkNotNull(object);
        this.ensureMutableMessageList();
        List list = this.messages;
        list.add(object);
        object = this.builders;
        if (object != null) {
            list = null;
            object.add(null);
        }
        this.onChanged();
        this.incrementModCounts();
        return this;
    }

    public List build() {
        List list;
        Object object;
        Object object2;
        int n10;
        List list2;
        boolean bl2;
        this.isClean = bl2 = true;
        int n11 = this.isMessagesListMutable;
        if (n11 == 0 && (list2 = this.builders) == null) {
            return this.messages;
        }
        list2 = null;
        if (n11 == 0) {
            block5: {
                for (n11 = 0; n11 < (n10 = (object2 = this.messages).size()); ++n11) {
                    object2 = (Message)this.messages.get(n11);
                    object = (SingleFieldBuilder)this.builders.get(n11);
                    if (object == null || (object = ((SingleFieldBuilder)object).build()) == object2) continue;
                    n11 = 0;
                    break block5;
                }
                n11 = (int)(bl2 ? 1 : 0);
            }
            if (n11 != 0) {
                return this.messages;
            }
        }
        this.ensureMutableMessageList();
        for (n11 = 0; n11 < (n10 = (object2 = this.messages).size()); ++n11) {
            object2 = this.messages;
            object = this.getMessage(n11, bl2);
            object2.set(n11, object);
        }
        this.messages = list = Collections.unmodifiableList(this.messages);
        this.isMessagesListMutable = false;
        return list;
    }

    public void clear() {
        Object object = Collections.emptyList();
        this.messages = object;
        this.isMessagesListMutable = false;
        object = this.builders;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                SingleFieldBuilder singleFieldBuilder = (SingleFieldBuilder)object.next();
                if (singleFieldBuilder == null) continue;
                singleFieldBuilder.dispose();
            }
            object = null;
            this.builders = null;
        }
        this.onChanged();
        this.incrementModCounts();
    }

    public void dispose() {
        this.parent = null;
    }

    public GeneratedMessage$Builder getBuilder(int n10) {
        this.ensureBuilders();
        Object object = (SingleFieldBuilder)this.builders.get(n10);
        if (object == null) {
            object = (GeneratedMessage)this.messages.get(n10);
            boolean bl2 = this.isClean;
            SingleFieldBuilder singleFieldBuilder = new SingleFieldBuilder((GeneratedMessage)object, this, bl2);
            this.builders.set(n10, singleFieldBuilder);
            object = singleFieldBuilder;
        }
        return ((SingleFieldBuilder)object).getBuilder();
    }

    public List getBuilderList() {
        RepeatedFieldBuilder$BuilderExternalList repeatedFieldBuilder$BuilderExternalList = this.externalBuilderList;
        if (repeatedFieldBuilder$BuilderExternalList == null) {
            this.externalBuilderList = repeatedFieldBuilder$BuilderExternalList = new RepeatedFieldBuilder$BuilderExternalList(this);
        }
        return this.externalBuilderList;
    }

    public int getCount() {
        return this.messages.size();
    }

    public GeneratedMessage getMessage(int n10) {
        return this.getMessage(n10, false);
    }

    public List getMessageList() {
        RepeatedFieldBuilder$MessageExternalList repeatedFieldBuilder$MessageExternalList = this.externalMessageList;
        if (repeatedFieldBuilder$MessageExternalList == null) {
            this.externalMessageList = repeatedFieldBuilder$MessageExternalList = new RepeatedFieldBuilder$MessageExternalList(this);
        }
        return this.externalMessageList;
    }

    public MessageOrBuilder getMessageOrBuilder(int n10) {
        Object object = this.builders;
        if (object == null) {
            return (MessageOrBuilder)this.messages.get(n10);
        }
        if ((object = (SingleFieldBuilder)object.get(n10)) == null) {
            return (MessageOrBuilder)this.messages.get(n10);
        }
        return ((SingleFieldBuilder)object).getMessageOrBuilder();
    }

    public List getMessageOrBuilderList() {
        RepeatedFieldBuilder$MessageOrBuilderExternalList repeatedFieldBuilder$MessageOrBuilderExternalList = this.externalMessageOrBuilderList;
        if (repeatedFieldBuilder$MessageOrBuilderExternalList == null) {
            this.externalMessageOrBuilderList = repeatedFieldBuilder$MessageOrBuilderExternalList = new RepeatedFieldBuilder$MessageOrBuilderExternalList(this);
        }
        return this.externalMessageOrBuilderList;
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    public void markDirty() {
        this.onChanged();
    }

    public void remove(int n10) {
        SingleFieldBuilder singleFieldBuilder;
        this.ensureMutableMessageList();
        this.messages.remove(n10);
        List list = this.builders;
        if (list != null && (singleFieldBuilder = (SingleFieldBuilder)list.remove(n10)) != null) {
            singleFieldBuilder.dispose();
        }
        this.onChanged();
        this.incrementModCounts();
    }

    public RepeatedFieldBuilder setMessage(int n10, GeneratedMessage object) {
        Internal.checkNotNull(object);
        this.ensureMutableMessageList();
        List list = this.messages;
        list.set(n10, object);
        object = this.builders;
        if (object != null) {
            list = null;
            SingleFieldBuilder singleFieldBuilder = object.set(n10, null);
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
            }
        }
        this.onChanged();
        this.incrementModCounts();
        return this;
    }
}

