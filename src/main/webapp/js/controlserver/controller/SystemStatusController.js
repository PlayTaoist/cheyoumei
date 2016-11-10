var organizationID = 1;

Ext.define('controlserver.controller.SystemStatusController', {
	extend : 'Ext.app.Controller',

	xtype : 'systemStatusController',
	views : ['left.SystemStatusMenuView'],
	stores : ['left.SystemStatusMenuStore'],
	models : [],
	init : function() {
		this.control({
			
				})
	},
	// 加载panel时显示数据
	show : function(view) {
		view.getStore().load();
	}
})
