Ext.define('controlserver.view.left.SystemManageMenuView', {
    extend: 'Ext.tree.Panel',
    xtype : 'systemManageMenuView',
    rootVisible: false,
    store:'left.SystemManageMenuStore'
   /* initComponent: function() {
		this.store=Ext.create('controlserver.store.left.TerminalManagerMenuStore',{});
		var proxy = this.store .getProxy( );
		var operation = new Ext.data.Operation({
		    action: 'read',
		    filters:[new Ext.util.Filter({
		             property: 'eyeColor',
		           	 value   : 'brown'
		     })]
		});
		proxy.read(operation);
		this.callParent(arguments);
	}*/
});