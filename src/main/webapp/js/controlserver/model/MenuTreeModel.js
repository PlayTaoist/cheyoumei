Ext.define('controlserver.model.MenuTreeModel',{
	extend: 'Ext.data.TreeModel',
    fields: [
        {name: 'id',  type: 'string'},
        {name: 'text',  type: 'string'},
        {name: 'icon',   type: 'string'},
        {name: 'expanded',   type: 'boolean'},
        {name: 'leaf',type: 'boolean'},
        {name: 'url',type: 'string'}
    ]
})