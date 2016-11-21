/**
 * Copyright 2016, GeoSolutions Sas.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree.
 */
const FileSaver = require('browser-filesaver');
const shpwrite = require('shp-write');
const ExporterUtils = {
    exportFeatures: function(outputformat, features, columns, filename = 'export') {
        switch (outputformat) {
            case "csv": {
                this.exportCSV(features, columns, filename);
                break;
            }
            case "shp": {
                this.exportShp(features, columns, filename);
                break;
            }
            default:
                this.exportCSV(features, columns, filename);
        }
    },
    exportCSV: function(features, columns, filename) {
        const csvString = this.convertArrayOfObjectsToCSV(features, columns);
        let file = new Blob([csvString], {
                    type: "text/csv;charset=utf-8;"
                });
        FileSaver.saveAs(file, `${filename}.csv`);
    },
    exportShp: function(features, columns, filename) {
        shpwrite.download({
            type: 'FeatureCollection',
            features: this.getFeaturesForShp(features, columns)
            }, {
            folder: filename,
            types: {
            point: 'SiraPoints',
            polygon: 'SiraPolygons',
            line: 'SiraLines'
            }});
    },
    cvsEscape: function(value) {
        if (value === null || value === undefined) {
            return '';
        }
        let stringValue;
        if (typeof value === 'string') {
            stringValue = value;
        }else if (typeof value.toString === 'function') {
            stringValue = value.toString();
        }else {
            stringValue = '';
        }
        return stringValue.replace(/"/g, "\"\"");
    },
    convertArrayOfObjectsToCSV: function(features, columns, columnDelimiter = ',', lineDelimiter = '\r\n') {
        if (features === null || !features.length) {
            return null;
        }
        // Get columns header
        let result = [];
        let headers = columns.map((c) => this.cvsEscape(c.headerName)).join(columnDelimiter);
        result.push(headers);
        const ids = columns.map((c) => c.field.replace('properties.', ''));
        features.reduce(( res, ft) => {
            res.push(ids.map((id) => {
                return this.cvsEscape(ft.properties[id]);
            }).join(columnDelimiter));
            return res;
        }, result);
        return result.join(lineDelimiter);
    },
    getFeaturesForShp: function(features, columns) {
        const cols = columns.map((c) => ({id: c.field.replace('properties.', ''), header: c.headerName}));
        return features.reduce((res, ft) => {
            if (ft.geometry.coordinates) {
                res.push({
                    type: ft.type,
                    id: ft.id,
                    geometry: ft. geometry,
                    properties: cols.reduce((obj, col) => {
                        obj[col.header] = ft.properties[col.id];
                        return obj;
                    }, {}) });
            }
            return res;
        }, []);

    }
};

module.exports = ExporterUtils;
