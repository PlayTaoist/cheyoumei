Ext.define('controlserver.store.left.OrdersManageMenuStore',{
	extend:'Ext.data.TreeStore',
	model: 'controlserver.model.MenuTreeModel',//store和model之间要用全名
	rootVisible: false,
	root: {
        expanded: true,
        children: [
       		{ text: "订单管理", leaf: true },
       		{ text: "新增订单", leaf: true },
       		{ text: "订单查询", leaf: true }
        ]
    }
  /*  proxy: {
        type: 'ajax',
        url: 'manager/terminalManage/getMenu',
        reader: {
            type: 'json'
        }
    },
   autoLoad : false,
	root: {
	    expanded : false
	}*/
})