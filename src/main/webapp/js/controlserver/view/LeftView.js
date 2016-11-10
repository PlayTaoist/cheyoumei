Ext.define('controlserver.view.LeftView', {
    extend: 'Ext.panel.Panel',
    xtype : 'leftView',
    title : '操作菜单',
    width : 220,
    minWidth: 175,
    maxWidth: 400,
    rootVisible: false,
	collapsible : true,
	animCollapse: true,
	autoScroll : true,
	split: true,
	margins: '0 0 0 5',
	icon:'img/main_left/monitor.png',
/*	tools: [{
		type:'refresh',
		tooltip: '刷新',
		id:'leftview_tools_refresh'
	}],*/
	defaults: {
        bodyStyle: 'padding:5px'
    },
    layout: {
        type: 'accordion',
        titleCollapse: true,
        animate: true,
        activeOnTop: false
    },
	 items: [{
        title: '物流订单',
        xtype:'ordersManageMenuView'
    },{
        title: '车辆管理',
        xtype:'carManageMenuView'
    },{
        title: '仓库管理',
        html: 'Panel content!'
    },{
        title: '客户管理',
        html: 'Panel content!'
    },{
        title: '系统管理',
        xtype:'systemManageMenuView'
    }]
});