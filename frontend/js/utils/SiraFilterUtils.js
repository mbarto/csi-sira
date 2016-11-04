/**
 * Copyright 2016, GeoSolutions Sas.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree.
 */
const FilterUtils = require('../../MapStore2/web/client/utils/FilterUtils');

FilterUtils.toOGCFilterSira = function(ftName, json, version, sortOptions = null, hits = false, format = null) {
    let newFilter = this.toOGCFilter(ftName, json, version, sortOptions, hits, format);
    let undefFilter = `<${this.nsplaceholder}:Filter>undefined</${this.nsplaceholder}:Filter>`;
    return newFilter.replace(undefFilter, '');

};
FilterUtils.toCQLFilterSira = function(json) {
    let filter = this.toCQLFilter(json);
    return filter === "(undefined)" ? "(INCLUDE)" : filter;
};
FilterUtils.getOgcAllPropertyValue = function(featureTypeName, attribute) {
    return `<wfs:GetPropertyValue service="WFS" valueReference='${attribute}'
                version="2.0" xmlns:fes="http://www.opengis.net/fes/2.0"
                xmlns:gml="http://www.opengis.net/gml/3.2"
                xmlns:wfs="http://www.opengis.net/wfs/2.0"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://www.opengis.net/wfs/2.0 http://schemas.opengis.net/wfs/2.0/wfs.xsd http://www.opengis.net/gml/3.2 http://schemas.opengis.net/gml/3.2.1/gml.xsd">
                    <wfs:Query typeNames="${featureTypeName}"/>
            </wfs:GetPropertyValue>`;
};
FilterUtils.getSLD = function(ftName, json, version) {
    let filter = this.toOGCFilterSira(ftName, json, version);
    let sIdx = filter.search( `<${this.nsplaceholder}:Filter>`);
    if (sIdx !== -1) {
        let eIndx = filter.search( `</wfs:Query>`);
        filter = filter.substr(sIdx, eIndx - sIdx);
    } else {
        filter = '';
    }
    return `<StyledLayerDescriptor version="1.0.0"
            xmlns:sira="http://www.regione.piemonte.it/ambiente/sira/1.0"
            xsi:schemaLocation="http://www.opengis.net/sld StyledLayerDescriptor.xsd" xmlns:ogc="http://www.opengis.net/ogc" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:gml="http://www.opengis.net/gml" xmlns:gsml="urn:cgi:xmlns:CGI:GeoSciML:2.0" xmlns:sld="http://www.opengis.net/sld" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"><NamedLayer><Name>${ftName}</Name><UserStyle><FeatureTypeStyle><Rule >${filter}<PointSymbolizer><Graphic><Mark><WellKnownName>circle</WellKnownName><Fill><CssParameter name="fill">#0000FF</CssParameter></Fill></Mark><Size>20</Size></Graphic></PointSymbolizer></Rule></FeatureTypeStyle></UserStyle></NamedLayer></StyledLayerDescriptor>`;

};

module.exports = FilterUtils;
