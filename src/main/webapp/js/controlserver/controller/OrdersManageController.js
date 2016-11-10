var organizationID = 1;

Ext.define('controlserver.controller.OrdersManageController', {
	extend : 'Ext.app.Controller',

	xtype : 'ordersManageController',
	views : ['left.OrdersManageMenuView'],
	stores : ['left.OrdersManageMenuStore'],
	models : ['MenuTreeModel'],
	init : function() {
		this.control({
					'roleManageTabView' : {
						show : this.show
					},
					'resourceManageTabView' : {
						show : this.show
					}
				})
	},
	// 加载panel时显示数据
	show : function(view) {
		view.getStore().load();
	}
})
