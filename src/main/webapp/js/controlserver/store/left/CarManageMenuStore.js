Ext.define('controlserver.store.left.CarManageMenuStore',{
	extend:'Ext.data.TreeStore',
	model: 'controlserver.model.MenuTreeModel',//store和model之间要用全名
	rootVisible: false,
	root: {
        expanded: true,
        children: [
       		{id:'carManage', text: "车辆管理", leaf: true,url:"manager/systemManage/car" },
       		{id:'addCar',text:"新增车辆",icon:"img/main_left/page_white_text_width.png",leaf:true,url:"manager/systemManage/userManage"}
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