Ext.define('controlserver.store.right.systemmanage.UserManageStore',{
	 extend: 'Ext.data.Store',
	 model: 'controlserver.model.right.systemmanage.UserManageModel',
	 pageSize: 15,
     proxy: {
         type: 'ajax',
         url: 'manager/systemManage/userManage/getUserList',
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
     autoLoad: false,
     remoteFilter: true

})