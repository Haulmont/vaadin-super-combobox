package com.haulmont.vaadin.sample;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;

import java.util.ArrayList;
import java.util.List;

public class SuperBeanContainer<IDTYPE, BEANTYPE> extends BeanContainer<IDTYPE, BEANTYPE> {

    protected Object missingBoxValue;

    public SuperBeanContainer(Class<? super BEANTYPE> type) {
        super(type);
    }

    @Override
    public boolean containsId(Object itemId) {
        boolean containsFlag = super.containsId(itemId);
        if (!containsFlag) {
            missingBoxValue = itemId;
        }
        return true;
    }

    @Override
    public List<IDTYPE> getItemIds() {
        List<IDTYPE> itemIds = super.getItemIds();
        if (missingBoxValue != null && !itemIds.contains(missingBoxValue)) {
            List<IDTYPE> newItemIds = new ArrayList<>(itemIds);
            newItemIds.add((IDTYPE) missingBoxValue);
            for (IDTYPE itemId : itemIds) {
                newItemIds.add(itemId);
            }
            itemIds = newItemIds;
        }

        return itemIds;
    }

    @Override
    public BeanItem<BEANTYPE> getItem(Object itemId) {
        if (missingBoxValue == itemId) {
            return new BeanItem(itemId);
        }

        return super.getItem(itemId);
    }

    @Override
    public int size() {
        int size = super.size();
        if (missingBoxValue != null) {
            size++;
        }
        return size;
    }
}