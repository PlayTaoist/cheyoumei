Ext.define('controlserver.store.left.SystemStatusMenuStore',{
	extend:'Ext.data.TreeStore',
	model: 'controlserver.model.MenuTreeModel',//store和model之间要用全名
	rootVisible: false,
	root: {
        expanded: true,
        children: [
            { text: "状态监控", icon:'img/main_left/monitor_lightning.png',leaf: true },
            { text: "接口状态", leaf: true },
            { text: "流量统计", leaf: true }
        ]
    }
    /*proxy: {
        type: 'ajax',
        url: 'manager/systemStatus/getMenu',
        reader: {
            type: 'json'
        }
    },
    autoLoad : false,
	root: {
	    expanded : false
	}*/
	
})