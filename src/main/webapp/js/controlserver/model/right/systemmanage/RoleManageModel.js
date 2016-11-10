Ext.define('controlserver.model.right.systemmanage.RoleManageModel',{
	extend: 'Ext.data.Model',
    fields: [
        {name: 'id',  type: 'int'},
        {name: 'name',  type: 'string'},
        {name: 'resources',   type: 'string'},
        {name: 'description',   type: 'string'}
    ]
})