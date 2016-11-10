Ext.define('controlserver.model.right.systemmanage.ResourceManageModel',{
	extend: 'Ext.data.Model',
    fields: [
        {name: 'id',  type: 'int'},
        {name: 'name',  type: 'string'},
        {name: 'url',   type: 'string'},
        {name: 'description',   type: 'string'}
    ]
})