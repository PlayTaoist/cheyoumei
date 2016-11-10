Ext.define('controlserver.model.right.systemmanage.CarManageModel',{
	extend: 'Ext.data.Model',
    fields: [
        {name: 'id',  type: 'int'},
        {name: 'plate',  type: 'string'},
        {name: 'type',   type: 'string'},
        {name: 'capacity',   type: 'string'},
        {name: 'allowance',   type: 'string'},
        //{name: 'withs',   type: 'string'},
        {name: 'status',   type: 'string'},
        {name: 'repo',   type: 'string'},
        {name: 'user',   type: 'string'},
    ]
})