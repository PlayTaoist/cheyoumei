Ext.define('controlserver.store.left.TerminalManageMenuStore',{
	extend:'Ext.data.TreeStore',
	//model: 'controlserver.model.MenuTreeModel',//store和model之间要用全名
	rootVisible: false,
	root: {
        expanded: true,
        children: [
            {id:'terminalRegister', text: "终端注册", leaf: true,icon:"img/main_left/phone.png",url:'manager/terminalManage/terminalRegister'}
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