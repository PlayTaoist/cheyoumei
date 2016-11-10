Ext.define('controlserver.view.RightView', {
    extend: 'Ext.tab.Panel',
    xtype: 'rightView',
    layout: 'fit',
    defaults :{
            autoScroll: true,
            bodyPadding: 10
    },
    activeTab: 0,
    items: [{
        xtype:'mainView'
    }]
});