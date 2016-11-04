/**
 * Copyright 2016, GeoSolutions Sas.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree.
 */

var React = require('react');
var Node = require('../../../MapStore2/web/client/components/TOC/Node');
var VisibilityCheck = require('../../../MapStore2/web/client/components/TOC/fragments/VisibilityCheck');
var Title = require('../../../MapStore2/web/client/components/TOC/fragments/Title');
var InlineSpinner = require('../../../MapStore2/web/client/components/misc/spinners/InlineSpinner/InlineSpinner');

const LayersTool = require('../../../MapStore2/web/client/components/TOC/fragments/LayersTool');
const SiraSettings = require('./fragments/SiraSettings');
const ConfirmButton = require('../../../MapStore2/web/client/components/buttons/ConfirmButton');
const {Glyphicon} = require('react-bootstrap');

var DefaultLayer = React.createClass({
    propTypes: {
        node: React.PropTypes.object,
        settings: React.PropTypes.object,
        propertiesChangeHandler: React.PropTypes.func,
        onToggle: React.PropTypes.func,
        onSettings: React.PropTypes.func,
        style: React.PropTypes.object,
        sortableStyle: React.PropTypes.object,
        hideSettings: React.PropTypes.func,
        updateSettings: React.PropTypes.func,
        updateNode: React.PropTypes.func,
        removeNode: React.PropTypes.func,
        activateLegendTool: React.PropTypes.bool,
        activateSettingsTool: React.PropTypes.bool,
        settingsText: React.PropTypes.oneOfType([React.PropTypes.string, React.PropTypes.element]),
        opacityText: React.PropTypes.oneOfType([React.PropTypes.string, React.PropTypes.element]),
        saveText: React.PropTypes.oneOfType([React.PropTypes.string, React.PropTypes.element]),
        closeText: React.PropTypes.oneOfType([React.PropTypes.string, React.PropTypes.element]),
        modalOptions: React.PropTypes.object,
        settingsOptions: React.PropTypes.object,
        visibilityCheckType: React.PropTypes.string,
        groups: React.PropTypes.array
    },
    getDefaultProps() {
        return {
            style: {},
            sortableStyle: {},
            propertiesChangeHandler: () => {},
            onToggle: () => {},
            onSettings: () => {},
            activateLegendTool: false,
            activateSettingsTool: false,
            modalOptions: {},
            settingsOptions: {},
            visibilityCheckType: "glyph"
        };
    },
    renderCollapsible() {
        if (this.props.settings && this.props.settings.node === this.props.node.id) {
            return (<SiraSettings
                position="collapsible"
                settings={this.props.settings}
                opacityText={this.props.opacityText}
                element={this.props.node}
                updateSettings={this.props.updateSettings}
                updateNode={this.props.updateNode}
                />);
            // <WMSLegend position="collapsible"/>;
        }
        return [];
    },
    renderTools() {
        const tools = [];
        tools.push(
            <ConfirmButton key="removelayer"
                text={(<Glyphicon glyph="1-close"/>)}
                style={{"float": "right", cursor: "pointer", backgroundColor: "transparent", marginRight: 3, padding: 0, outline: "none"}}
                confirming={{text: "Sei sicuro",
                    style: {"float": "right", cursor: "pointer", marginTop: -5}}}
                    onConfirm={() => {
                        this.props.removeNode(this.props.node.id, "layers");
                    }}/>
                );
        tools.push(
            <VisibilityCheck key="visibilitycheck"
                checkType={this.props.visibilityCheckType}
                propertiesChangeHandler={this.props.propertiesChangeHandler}
                style={{"float": "right", cursor: "pointer", marginLeft: 0, marginRight: 0}}/>
                );
        if (this.props.activateSettingsTool) {
            tools.push(
                <LayersTool key="toolsettings"
                        style={{"float": "right", cursor: "pointer", marginRight: 0}}
                        glyph="1-menu-manage"
                        onClick={(node) => {
                            if (this.props.settings && this.props.settings.node === this.props.node.id) {
                                this.props.hideSettings();
                            }else {
                                this.props.onSettings(node.id, "layers",
                                    {opacity: parseFloat(node.opacity !== undefined ? node.opacity : 1)});
                            }}}/>
            );
        }
        return tools;
    },
    render() {
        let {children, propertiesChangeHandler, onToggle, ...other } = this.props;
        return (
            <Node className="toc-default-layer" sortableStyle={this.props.sortableStyle} style={this.props.style} type="layer" {...other}>
                <Title onClick={this.props.onToggle}/>
                <InlineSpinner loading={this.props.node.loading}/>
                {this.renderCollapsible()}
                {this.renderTools()}
            </Node>
        );
    }
});

module.exports = DefaultLayer;
