/**
 * Copyright 2016, GeoSolutions Sas.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree.
 */

const React = require('react');

const Slider = require('react-nouislider');
const {Label, Glyphicon} = require('react-bootstrap');
const WMSLegend = require('../../../../MapStore2/web/client/components/TOC/fragments/WMSLegend');
const assign = require('object-assign');

const {toggleSiraControl} = require('../../../actions/controls');
const {
    // SiraQueryPanel action functions
    expandFilterPanel
} = require('../../../actions/siradec');
const {connect} = require('react-redux');

require('./SiraSettings.css');
const glyphStyle = {"float": "right", marginTop: 12, cursor: 'pointer'};

const SiraSettings = React.createClass({
    propTypes: {
        opacityText: React.PropTypes.node,
        settings: React.PropTypes.object,
        element: React.PropTypes.object,
        updateNode: React.PropTypes.func,
        updateSettings: React.PropTypes.func,
        expandFilterPanel: React.PropTypes.func,
        toggleSiraControl: React.PropTypes.func
    },
    contextTypes: {
        messages: React.PropTypes.object
    },
    getDefaultProps() {
        return {
            updateSettings: () => {},
            updateNode: () => {},
            expandFilterPanel: () => {},
            toggleSiraControl: () => {}
        };
    },
    renderOpacity() {
        return (
            <div key="opacity" style={{width: "70%", display: "inline-block", paddingLeft: 7}}>
            <label key="opacity-label" className="control-label">{this.props.opacityText}</label>
            <Slider key="opacity-slider" start={[Math.round(this.props.settings.options.opacity * 100)]}
                range={{min: 0, max: 100}}
                onChange={(opacity) => this.updateOpacity({opacity: opacity / 100}) }/>
            <Label key="opacity-percent" >{Math.round(this.props.settings.options.opacity * 100) + "%"}</Label>
            </div>);
    },
    renderLegend() {
        return (
            <div key="legend" style={{width: "65%", display: "inline-block"}}>
                <WMSLegend node={this.props.element}/>
            </div>
            );
    },
    renderSiraTool() {
        return [ (<Glyphicon
                    style={glyphStyle}
                    key="toggle-featuregrid"
                    glyph="tasks"
                    onClick={this.props.toggleSiraControl}/>),
                    (<Glyphicon
                    style={glyphStyle}
                    key="toggle-query"
                    glyph="search"
                    onClick={()=>this.props.expandFilterPanel(true)}/>)];
    },
    render() {
        const renderLeg = this.props.settings && this.props.settings.options && this.props.settings.options.showlegend && this.props.element.type === "wms";
        const renderSTool = this.props.element.group && this.props.element.group === 'Oggetti';
        const renderLegendTool = this.props.element.type !== "vector";
        return (<div id="sira-layer-settings">
            {renderLeg ? this.renderLegend() : this.renderOpacity()}
            {renderSTool ? this.renderSiraTool() : (<span/>)}
            {renderLegendTool ? (<Glyphicon
                style={glyphStyle}
                key="toggle-legned"
                glyph="list"
                onClick={this.toggleLegend}
            />) : (<span/>)}
            </div>);
    },
    updateOpacity(newParams) {
        this.props.updateSettings(newParams);
        this.props.updateNode(
            this.props.settings.node,
            this.props.settings.nodeType,
            assign({}, this.props.settings.props, newParams)
        );
    },
    toggleLegend() {
        this.props.updateSettings({"showlegend": !this.props.settings.options.showlegend});
    }
});

module.exports = connect(() =>({}), {
    expandFilterPanel,
    toggleSiraControl: toggleSiraControl.bind(null, 'grid', true)
})(SiraSettings);
