package com.adobe.aem.guides.aemspa.react.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomDropdownModel {

    @ChildResource(name = "dropdownItems")
    private List<Resource> dropdownItems;

    private List<DropdownItem> items;

    @PostConstruct
    protected void init() {
        items = new ArrayList<>();
        if (dropdownItems != null) {
            for (Resource item : dropdownItems) {
                Map<String, Object> values = item.getValueMap();
                String label = (String) values.getOrDefault("label", "");
                String value = (String) values.getOrDefault("value", "");
                items.add(new DropdownItem(label, value));
            }
        }
    }

    public List<DropdownItem> getItems() {
        return items;
    }

    public static class DropdownItem {
        private final String label;
        private final String value;

        public DropdownItem(String label, String value) {
            this.label = label;
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public String getValue() {
            return value;
        }
    }
}
