Ext.define("controlserver.view.right.systemmanage.AddCarTabView",{
	extend : 'Ext.grid.Panel',
	xtype : 'addCarTabView',
	id:'addcar',
	closable : true,
	initComponent : function() {  
		this.columns = [
				];
	    Ext.onReady(function () {  
            var win = new Ext.Window({  
				width:320,
				
				layout:'form',
				modal:true,
				bodyPadding:5,
				items:[{
					fieldLabel: '车牌',
					name :'plate',
					xtype:'textfield',
					allowBlank : false
				},{fieldLabel: '型号',
					name :'type',
					xtype:'textfield',
					allowBlank : false
				},{
					fieldLabel : '承载量（千克）',
					name : 'capacity',
					xtype : 'textfield',
					allowBlank : false
				},{
					fieldLabel : '可用容量',
					name : 'allowance',
					xtype : 'textfield',
					allowBlank : false
				},{
					fieldLabel : '状态',
					name : 'status',
					xtype : 'textfield',
					allowBlank : false
				},{
					fieldLabel : '所在仓库',
					name : 'repo',
					xtype : 'textfield',
					allowBlank : false
				},{
					fieldLabel : '用户',
					name : 'userId',
					xtype : 'textfield',
					allowBlank : false
				}],
			buttons :[{
				text : '确定',
				handler : function() {
					var plate = win.items.get(0);
					var type=win.items.get(1);
					var capacity = win.items.get(2);
					var allowance = win.items.get(3);
					var status = win.items.get(4);
					var repo = win.items.get(5);
					var userId = win.items.get(6);
					if (plate.isValid()&&type.isValid()&&capacity.isValid() ) {
						Ext.Ajax.request({
							url : 'manager/systemManage/car/addCar',
							params : {
								plate : plate.getValue(),
								type:type.getValue(),
								capacity : capacity.getValue(),
								allowance:allowance.getValue(),
								status:status.getValue(),
								repo:repo.getValue(),
								userId:userId.getValue()
							},
							success : function(response) {
								var text = response.responseText;
								var result = Ext.JSON.decode(text);
								if (result.result) {								
									win.close();
									parent.Ext.getCmp('addcar').close();
								} else {
									controlserver.controller.AppStoreController
											.requestResultFailure(result);
								}
							}
						});
					}
				}
			},{
				text : '取消',
				handler : function() {
					win.close();
					parent.Ext.getCmp('addcar').close();
				}
			}]
            });  
            win.show();  
        }) ;
		this.callParent();

       
	}
})
