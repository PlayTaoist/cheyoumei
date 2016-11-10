Ext.define("controlserver.view.right.systemmanage.ResourceManageTabView", {
	extend : 'Ext.grid.Panel',
	xtype : 'resourceManageTabView',
	closable : true,
	initComponent : function() {
		var store=Ext.create('controlserver.store.right.systemmanage.ResourceManageStore',{
                		
          });
         this.store = store;
		this.columns = [{
					text : '序号',
					flex : 1,
					sortable : true,
					dataIndex : 'id'
				}, {
					text : '资源名称',
					flex : 2,
					sortable : false,
					dataIndex : 'name'
				}, {
					text : 'URL',
					flex : 3,
					sortable : false,
					dataIndex : 'url'
				}, {
					text : '备注',
					sortable : false,
					flex : 2,
					dataIndex : 'description'
				}, {
					text : '操作',
					width : 100,
					sortable : false,
					xtype : 'actioncolumn',
					id:'resourceActionColumn',
					items : [{
						icon : 'img/main_right/script_edit.png',
						action:'edit',
						tooltip : '编辑',
						handler: function (grid, rowIndex, colIndex, item, e, record, rowEl) {     
					      this.fireEvent('itemclick', this, grid, rowIndex, colIndex, item, e, record, rowEl);  //添加事件方便在control中处理
					    }
					},'-', {
						icon : 'img/main_right/script_delete.png',
						action:'delete',
						tooltip : '删除',
						handler: function (grid, rowIndex, colIndex, item, e, record, rowEl) {     
					        this.fireEvent('itemclick', this, grid, rowIndex, colIndex, item, e, record, rowEl);  
					    }
					}]
				}];
		this. dockedItems = [{
			dock: 'top',
            xtype: 'toolbar',
			items:[{
				text : '添加资源',
				id:'addResourceButton',
				xtype : 'button',
				icon : 'img/main_right/script_add.png',
				scope : this
			},'-',{
                width: 200,
                fieldLabel: '搜索:',
                labelWidth: 30,
                //xtype:'textfield'
                xtype: 'searchfield',
                store: store
            }]
		}];
		this.bbar=Ext.create('Ext.PagingToolbar', {
            store: store,
            displayInfo: true,
            displayMsg: '第{0}条 - 第{1}条 共 {2}条',
            emptyMsg: "没有资源"
        });
		this.callParent();
	}
})