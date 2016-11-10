var organizationID = 1;

Ext.define('controlserver.controller.CarManageController', {
	extend : 'Ext.app.Controller',
	xtype : 'carManageController',
	views : [
			'left.CarManageMenuView',
			'right.systemmanage.AddCarTabView',
			'right.systemmanage.CarManageTabView'],
	stores : [
			'left.CarManageMenuStore', 
			'right.systemmanage.CarManageStore'],
	models : ['MenuTreeModel',
	          'right.systemmanage.CarManageModel'],
	init : function() {
		this.control({
					'carManageMenuView' : {
						itemclick : this.openMenu
					},
					'carManageTabView' : {
						show : this.show
					},
					'addCarTabView' : {
						show : this.show
					},
					'carManageTabView actioncolumn[id=carActionColumn]' : {
						itemclick : this.handleApp
					}
				})
	},

	/**
	 * 单击菜单时，打开相应功能
	 */
	openMenu : function(view, record, item, index) {
		var control = this;
		if (record.data.leaf) {
			// Ext.Msg.alert("sdfsdf","sdfsd");
			Ext.Ajax.request({
				url : record.data.url,
				success : function(response) {
					var result = Ext.JSON.decode(response.responseText);
					if (result.result) {
						var tabPanel = Ext.ComponentQuery.query('rightView')[0];// 查询获取右边对他tabPanel
						var tabs = tabPanel.items.items;// 获取现有tab
						var isExistTab = false; // 记录单击的菜单是否存在
						var menuId = record.data.id;// 记录title
						var targetTabXtype = menuId + "TabView";
						for (var i = 0; i < tabs.length; i++) {
							// var tabTitle = tabs[i].tab.text;
							var tabXtype = tabs[i].xtype;
							if (tabXtype == targetTabXtype) {
								// 判断tabpanel中的tab的title有没有和菜单一样的，一样代表已经存在，只要激活就可以了
								isExistTab = true;
								tabPanel.setActiveTab(tabs[i]);
								break;
							}
						}
						if (!isExistTab) {
							// 不存在则打开一个tab
							var newTab = tabPanel.add([{
										title : record.data.text,
										icon : record.data.icon,
										xtype : targetTabXtype
									}])[0];
							tabPanel.setActiveTab(newTab);
						}
					} else {
						// Ext.Msg.alert("提示",result.msg);
						controlserver.controller.SystemManageController
								.requestResultFailure(result);
					}
				},
				failure : function() {
					controlserver.controller.SystemManageController.requestResultFailure({
								type : 2,
								msg : '连接服务器失败.....'
							});
					// Ext.Msg.alert("提示","连接服务器失败......");
				}
			});
		}
	},
	// 加载panel时显示数据
	show : function(view) {
		view.getStore().load();
	}
})
