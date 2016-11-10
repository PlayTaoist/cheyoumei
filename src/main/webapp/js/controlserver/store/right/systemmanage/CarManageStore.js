Ext.define('controlserver.store.right.systemmanage.CarManageStore',{
	 extend: 'Ext.data.Store',
	 model: 'controlserver.model.right.systemmanage.CarManageModel',
	 pageSize: 15,
     proxy: {
         type: 'ajax',
         url: 'manager/systemManage/car/getCarList',
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