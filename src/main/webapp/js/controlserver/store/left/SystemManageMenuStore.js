Ext.define('controlserver.store.left.SystemManageMenuStore',{
	extend:'Ext.data.TreeStore',
	model: 'controlserver.model.MenuTreeModel',//store和model之间要用全名
	rootVisible: false,
	root: {
        expanded: true,
        children: [
            {text: "管理员设置", icon:"img/main_left/group_gear.png",expanded: false,children:[
	            {id:'userManage',text:"用户管理", icon:"img/main_left/user.png",leaf:true,url:"manager/systemManage/userManage"},
	            {id:'roleManage',text:"角色管理", icon:"img/main_left/user_orange.png",leaf:true,url:"manager/systemManage/roleManage"},
	             {id:'resourceManage',text:"功能管理", icon:"img/main_left/script_gear.png",leaf:true,url:"manager/systemManage/resourceManage"}
            ]},
            { text: "日志管理", icon:"img/main_left/page_gear.png",expanded: false,children:[
            	{id:'logList',text:"日志列表",icon:"img/main_left/page_white_text_width.png",leaf:true,url:"manager/systemManage/logList"}
            ]}
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