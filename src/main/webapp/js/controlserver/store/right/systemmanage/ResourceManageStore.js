Ext.define('controlserver.store.right.systemmanage.ResourceManageStore',{
	 extend: 'Ext.data.Store',
	 model: 'controlserver.model.right.systemmanage.ResourceManageModel',//store和model之间要用全名
	 pageSize: 15,
     proxy: {
         type: 'ajax',
         url: 'manager/systemManage/resourceManage/getResourceList',
         reader: {
             type: 'json',
             root: 'datas'
         },
         simpleSortMode: true,
         filterParam: 'query',
         encodeFilters: function(filters) {
                return filters[0].value;
         }
         
     },
     //buffered: true,
     
     /*sorters: [{
         property: 'id',
         direction: 'ASC'
     }, {
         property: 'name',
         direction: 'ASC'
     }],*/
     autoLoad: false,
     remoteFilter: true
	/*data : [
         {id: '1',  name: '系统管理员',resources:'用户设置，角色管理',description:'系统最高权限的角色'},
        {id: '2',    name: '配置管理员',resources:'无',description:'只能对系统策略进行配置'},
        {id: '3',   name: '用户管理员',resources:'用户管理',description:'只能对用户进行管理'},
        {id: '4',  name: '日志管理员',resources:'日志管理',description:'只能管理日志'}
     ]*/
})