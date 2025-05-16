package com.adobe.aem.guides.aemspa.react.core.models.impl;

import com.adobe.aem.guides.aemspa.react.core.models.SampleHeaderModel;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.Collections;
import java.util.List;

@Model(
    adaptables = SlingHttpServletRequest.class,
    adapters = { SampleHeaderModel.class, ComponentExporter.class },
    resourceType = "aem-spa-react/components/header",
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class SampleHeaderModelImpl implements SampleHeaderModel {

    @ChildResource(name = "navigationItems")
    private List<NavigationItemImpl> navigationItems;

    @Override
    public List<NavigationItem> getNavigationItems() {
        return navigationItems != null ? Collections.unmodifiableList(navigationItems) : Collections.emptyList();

    }

    @Override
    public String getExportedType() {
        return "aem-spa-react/components/header";
    }

    @Model(adaptables = Resource.class)
    public static class NavigationItemImpl implements NavigationItem {

        @ValueMapValue
        private String title;

        @ValueMapValue
        private String url;

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getUrl() {
            return url;
        }
    }
}
