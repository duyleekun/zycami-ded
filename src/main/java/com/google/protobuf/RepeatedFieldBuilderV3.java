/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessage$BuilderParent;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.RepeatedFieldBuilderV3$BuilderExternalList;
import com.google.protobuf.RepeatedFieldBuilderV3$MessageExternalList;
import com.google.protobuf.RepeatedFieldBuilderV3$MessageOrBuilderExternalList;
import com.google.protobuf.SingleFieldBuilderV3;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RepeatedFieldBuilderV3
implements AbstractMessage$BuilderParent {
    private List builders;
    private RepeatedFieldBuilderV3$BuilderExternalList externalBuilderList;
    private RepeatedFieldBuilderV3$MessageExternalList externalMessageList;
    private RepeatedFieldBuilderV3$MessageOrBuilderExternalList externalMessageOrBuilderList;
    private boolean isClean;
    private boolean isMessagesListMutable;
    private List messages;
    private AbstractMessage$BuilderParent parent;

    public RepeatedFieldBuilderV3(List list, boolean bl2, AbstractMessage$BuilderParent abstractMessage$BuilderParent, boolean bl3) {
        this.messages = list;
        this.isMessagesListMutable = bl2;
        this.parent = abstractMessage$BuilderParent;
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

    private AbstractMessage getMessage(int n10, boolean bl2) {
        Object object = this.builders;
        if (object == null) {
            return (AbstractMessage)this.messages.get(n10);
        }
        if ((object = (SingleFieldBuilderV3)object.get(n10)) == null) {
            return (AbstractMessage)this.messages.get(n10);
        }
        AbstractMessage abstractMessage = bl2 ? ((SingleFieldBuilderV3)object).build() : ((SingleFieldBuilderV3)object).getMessage();
        return abstractMessage;
    }

    private void incrementModCounts() {
        AbstractList abstractList = this.externalMessageList;
        if (abstractList != null) {
            ((RepeatedFieldBuilderV3$MessageExternalList)abstractList).incrementModCount();
        }
        if ((abstractList = this.externalBuilderList) != null) {
            ((RepeatedFieldBuilderV3$BuilderExternalList)abstractList).incrementModCount();
        }
        if ((abstractList = this.externalMessageOrBuilderList) != null) {
            ((RepeatedFieldBuilderV3$MessageOrBuilderExternalList)abstractList).incrementModCount();
        }
    }

    private void onChanged() {
        AbstractMessage$BuilderParent abstractMessage$BuilderParent;
        boolean bl2 = this.isClean;
        if (bl2 && (abstractMessage$BuilderParent = this.parent) != null) {
            abstractMessage$BuilderParent.markDirty();
            bl2 = false;
            abstractMessage$BuilderParent = null;
            this.isClean = false;
        }
    }

    public RepeatedFieldBuilderV3 addAllMessages(Iterable object) {
        boolean bl2;
        Object object2;
        int n10;
        Object object3 = object.iterator();
        while ((n10 = object3.hasNext()) != 0) {
            object2 = (AbstractMessage)object3.next();
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
            object3 = (AbstractMessage)object.next();
            this.addMessage((AbstractMessage)object3);
        }
        this.onChanged();
        this.incrementModCounts();
        return this;
    }

    public AbstractMessage$Builder addBuilder(int n10, AbstractMessage abstractMessage) {
        this.ensureMutableMessageList();
        this.ensureBuilders();
        boolean bl2 = this.isClean;
        SingleFieldBuilderV3 singleFieldBuilderV3 = new SingleFieldBuilderV3(abstractMessage, this, bl2);
        this.messages.add(n10, null);
        this.builders.add(n10, singleFieldBuilderV3);
        this.onChanged();
        this.incrementModCounts();
        return singleFieldBuilderV3.getBuilder();
    }

    public AbstractMessage$Builder addBuilder(AbstractMessage abstractMessage) {
        this.ensureMutableMessageList();
        this.ensureBuilders();
        boolean bl2 = this.isClean;
        SingleFieldBuilderV3 singleFieldBuilderV3 = new SingleFieldBuilderV3(abstractMessage, this, bl2);
        this.messages.add(null);
        this.builders.add(singleFieldBuilderV3);
        this.onChanged();
        this.incrementModCounts();
        return singleFieldBuilderV3.getBuilder();
    }

    public RepeatedFieldBuilderV3 addMessage(int n10, AbstractMessage object) {
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

    public RepeatedFieldBuilderV3 addMessage(AbstractMessage object) {
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
                    object = (SingleFieldBuilderV3)this.builders.get(n11);
                    if (object == null || (object = ((SingleFieldBuilderV3)object).build()) == object2) continue;
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
                SingleFieldBuilderV3 singleFieldBuilderV3 = (SingleFieldBuilderV3)object.next();
                if (singleFieldBuilderV3 == null) continue;
                singleFieldBuilderV3.dispose();
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

    public AbstractMessage$Builder getBuilder(int n10) {
        this.ensureBuilders();
        Object object = (SingleFieldBuilderV3)this.builders.get(n10);
        if (object == null) {
            object = (AbstractMessage)this.messages.get(n10);
            boolean bl2 = this.isClean;
            SingleFieldBuilderV3 singleFieldBuilderV3 = new SingleFieldBuilderV3((AbstractMessage)object, this, bl2);
            this.builders.set(n10, singleFieldBuilderV3);
            object = singleFieldBuilderV3;
        }
        return ((SingleFieldBuilderV3)object).getBuilder();
    }

    public List getBuilderList() {
        RepeatedFieldBuilderV3$BuilderExternalList repeatedFieldBuilderV3$BuilderExternalList = this.externalBuilderList;
        if (repeatedFieldBuilderV3$BuilderExternalList == null) {
            this.externalBuilderList = repeatedFieldBuilderV3$BuilderExternalList = new RepeatedFieldBuilderV3$BuilderExternalList(this);
        }
        return this.externalBuilderList;
    }

    public int getCount() {
        return this.messages.size();
    }

    public AbstractMessage getMessage(int n10) {
        return this.getMessage(n10, false);
    }

    public List getMessageList() {
        RepeatedFieldBuilderV3$MessageExternalList repeatedFieldBuilderV3$MessageExternalList = this.externalMessageList;
        if (repeatedFieldBuilderV3$MessageExternalList == null) {
            this.externalMessageList = repeatedFieldBuilderV3$MessageExternalList = new RepeatedFieldBuilderV3$MessageExternalList(this);
        }
        return this.externalMessageList;
    }

    public MessageOrBuilder getMessageOrBuilder(int n10) {
        Object object = this.builders;
        if (object == null) {
            return (MessageOrBuilder)this.messages.get(n10);
        }
        if ((object = (SingleFieldBuilderV3)object.get(n10)) == null) {
            return (MessageOrBuilder)this.messages.get(n10);
        }
        return ((SingleFieldBuilderV3)object).getMessageOrBuilder();
    }

    public List getMessageOrBuilderList() {
        RepeatedFieldBuilderV3$MessageOrBuilderExternalList repeatedFieldBuilderV3$MessageOrBuilderExternalList = this.externalMessageOrBuilderList;
        if (repeatedFieldBuilderV3$MessageOrBuilderExternalList == null) {
            this.externalMessageOrBuilderList = repeatedFieldBuilderV3$MessageOrBuilderExternalList = new RepeatedFieldBuilderV3$MessageOrBuilderExternalList(this);
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
        SingleFieldBuilderV3 singleFieldBuilderV3;
        this.ensureMutableMessageList();
        this.messages.remove(n10);
        List list = this.builders;
        if (list != null && (singleFieldBuilderV3 = (SingleFieldBuilderV3)list.remove(n10)) != null) {
            singleFieldBuilderV3.dispose();
        }
        this.onChanged();
        this.incrementModCounts();
    }

    public RepeatedFieldBuilderV3 setMessage(int n10, AbstractMessage object) {
        Internal.checkNotNull(object);
        this.ensureMutableMessageList();
        List list = this.messages;
        list.set(n10, object);
        object = this.builders;
        if (object != null) {
            list = null;
            SingleFieldBuilderV3 singleFieldBuilderV3 = object.set(n10, null);
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.dispose();
            }
        }
        this.onChanged();
        this.incrementModCounts();
        return this;
    }
}

