Ext.define("controlserver.view.right.systemmanage.UserManageTabView",{
	extend : 'Ext.grid.Panel',
	xtype : 'userManageTabView',
	closable : true,
	initComponent : function() {
		var store=Ext.create('controlserver.store.right.systemmanage.UserManageStore',{
                		
          });
         this.store = store;
		this.columns = [{
					text : '序号',
					flex : 1,
					sortable : true,
					dataIndex : 'id'
				}, {
					text : '用户账号',
					width : 120,
					sortable : false,
					dataIndex : 'userName'
				},{
					text : '商铺名称',
					width : 180,
					sortable : false,
					dataIndex : 'firm'
				},{
					text : '手机号',
					width : 120,
					sortable : false,
					dataIndex : 'mobilePhone'
				},{
					text : '支付密码',
					width : 100,
					sortable : false,
					dataIndex : 'payPwd'
				},{
					text : '积分',
					width : 60,
					sortable : false,
					dataIndex : 'point'
				},{
					text : '余额',
					width : 60,
					sortable : false,
					dataIndex : 'balance'
				},{
					text : '登陆密码',
					width : 120,
					sortable : false,
					dataIndex : 'loginPwd'
				}, 
				{
					text : '头像地址',
					width : 180,
					sortable : false,
					dataIndex : 'logoUrl'
				},
				{
					text : '性别',
					width : 60,
					sortable : false,
					dataIndex : 'gender'
				},
				{
					text : '用户地址',
					width : 280,
					sortable : false,
					dataIndex : 'addr'
				},{
					text : '星级',
					width : 50,
					sortable : false,
					dataIndex : 'totalRase'
				},{
					text : '评价次数',
					width : 80,
					sortable : false,
					dataIndex : 'raseCount'
				},{
					text : '激活用户',
					width : 80,
					sortable : false,
					dataIndex : 'isActived'
				},{
					text : '用户在线',
					width : 80,
					sortable : false,
					dataIndex : 'isOnline'
				},{
					text : '删除用户',
					width : 80,
					sortable : false,
					dataIndex : 'isdeleted'
				},{
					text : '最近登陆',
					width : 150,
					sortable : false,
					dataIndex : 'lastLogin',
					renderer: function(value){
				        return new Date(parseInt(value)).toLocaleString();
				    }
				},{
					text : '创建时间',
					width : 150,
					sortable : false,
					dataIndex : 'createdAt',
					renderer: function(value){
				        return new Date(parseInt(value)).toLocaleString();
				    }
				},{
					text : '删除时间',
					width : 150,
					sortable : false,
					dataIndex : 'deletedAt',
					renderer: function(value){
				        return new Date(parseInt(value)).toLocaleString();
				    }
				},{
					text : '操作员ID',
					width : 80,
					sortable : false,
					dataIndex : 'deletedByUserId'
				},{
					text : '用户角色',
					width : 120,
					sortable : false,
					dataIndex : 'role'
				},{
					text : '操作',
					width : 150,
					sortable : false,
					xtype : 'actioncolumn',
					id:'userActionColumn',
					items : [{
						icon : 'img/main_right/user_edit.png',
						action:'edit',
						tooltip : '编辑',
						handler: function (grid, rowIndex, colIndex, item, e, record, rowEl) {     
					      this.fireEvent('itemclick', this, grid, rowIndex, colIndex, item, e, record, rowEl);  //添加事件方便在control中处理
					    }
					},'-', {
						icon : 'img/main_right/user_delete.png',
						action:'delete',
						tooltip : '删除',
						handler: function (grid, rowIndex, colIndex, item, e, record, rowEl) {     
					        this.fireEvent('itemclick', this, grid, rowIndex, colIndex, item, e, record, rowEl);  
					    }
					}, '-',{
						icon : 'img/main_right/lock_edit.png',
						action:'passwd',
						tooltip : '修改密码',
						handler: function (grid, rowIndex, colIndex, item, e, record, rowEl) {     
					        this.fireEvent('itemclick', this, grid, rowIndex, colIndex, item, e, record, rowEl);  
					    }
					}]
				}];
		this. dockedItems = [{
			dock: 'top',
            xtype: 'toolbar',
			items:[{
				text : '添加用户',
				id:'addUserButton',
				xtype : 'button',
				icon : 'img/main_right/user_add.png',
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
            emptyMsg: "没有用户"
        });
		this.callParent();
	}
})