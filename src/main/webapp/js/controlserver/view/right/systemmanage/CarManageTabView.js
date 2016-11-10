Ext.define("controlserver.view.right.systemmanage.CarManageTabView",{
	extend : 'Ext.grid.Panel',
	xtype : 'carManageTabView',
	closable : true,
	initComponent : function() {
		var store=Ext.create('controlserver.store.right.systemmanage.CarManageStore',{
                		
          });
         this.store = store;
		this.columns = [{
					text : 'ID',
					flex : 1,
					sortable : true,
					dataIndex : 'id'
				}, {
					text : '车牌',
					flex : 2,
					sortable : false,
					dataIndex : 'plate'
				}, {
					text : '类型',
					flex : 2,
					sortable : false,
					dataIndex : 'type'
				},{
					text : '承载量（千克）',
					flex : 2,
					sortable : false,
					dataIndex : 'capacity'
				}, {
					text : '已用（千克）',
					flex : 2,
					sortable : false,
					dataIndex : 'allowance'
				},  {
					text : '状态',
					flex : 2,
					sortable : false,
					dataIndex : 'status'
				}, {
					text : '所在仓库',
					flex : 2,
					sortable : false,
					dataIndex : 'repo'
				},{
					text : '车主',
					sortable : false,
					flex : 3,
					dataIndex : 'user'
				},{
					text : '操作',
					width : 100,
					sortable : false,
					xtype : 'actioncolumn',
					id:'carActionColumn',
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
		this.bbar=Ext.create('Ext.PagingToolbar', {
            store: store,
            displayInfo: true,
            displayMsg: '第{0}条 - 第{1}条 共 {2}条',
            emptyMsg: "没有用户"
        });
		this.callParent();
	}
})