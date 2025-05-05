package com.adobe.aem.guides.aemspa.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import java.util.List;

public interface SampleHeaderModel extends ComponentExporter {
    List<NavigationItem> getNavigationItems();

    interface NavigationItem {
        String getTitle();
        String getUrl();
    }
}
