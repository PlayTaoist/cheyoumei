Ext.define("controlserver.view.right.systemmanage.RoleManageTabView", {
	extend : 'Ext.grid.Panel',
	xtype : 'roleManageTabView',
	closable : true,
	store : 'right.systemmanage.RoleManageStore',

	initComponent : function() {
		function requestFailure() {
			Ext.Msg.show({
						title : '提示',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						msg : '连接服务器失败......'
					});
		}
		function requestResultFailure(result) {
			if(result.type==1){
				Ext.Msg.show({
						title : '信息',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						msg : result.msg
					});
			}else if(result.type==2){
				Ext.Msg.show({
						title : '提示',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						msg : result.msg
					});
			}else if(result.type==3){
				Ext.Msg.show({
						title : '警告',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.WARNING,
						msg : result.msg
					});
			}else if(result.type==4){
				Ext.Msg.show({
						title : '错误',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR,
						msg : result.msg
					});
			}
			
		}
		this.features = [{
					id : 'group',
					ftype : 'groupingsummary'
				}];
		this.columns = [{
					text : '序号',
					flex : 1,
					sortable : true,
					dataIndex : 'id'
				}, {
					text : '角色名称',
					flex : 2,
					sortable : false,
					dataIndex : 'name'
				}, {
					text : '权限',
					flex : 3,
					sortable : false,
					renderer : function(data, metadata, record, rowIndex,
							columnIndex, store) {
						return '<span style="color:' + '#73b51e' + '">' + data
								+ '</span>';
					},
					dataIndex : 'resources'
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
					items : [{
						icon : 'img/main_right/user_edit.png',
						tooltip : '编辑',
						handler : function(grid, rowIndex, colIndex) {
							var rec = grid.getStore().getAt(rowIndex);

							Ext.Ajax.request({
								url : 'manager/systemManage/roleManage/getResourceListByRoleId',
								params : {
									id : rec.get('id')
								},
								success : function(response) {
									var text = response.responseText;
									var result = Ext.JSON.decode(text);
									if (result.result) {
										var list = result.list;//从服务器获取的权限列表数组；
										var window = Ext.create(
												'Ext.window.Window', {
													title : '编辑角色',
													//height: 200,
													width : 500,
													modal : true,
													bodyPadding : 5,
													icon : 'img/main_right/user_edit.png',
													layout : 'form',
													items : [{
																xtype : 'hiddenfield',
																name : 'id',
																value : rec
																		.get('id')
															}, {
																xtype : 'textfield',
																name : 'name',
																value : rec
																		.get('name'),
																fieldLabel : '角色名称:',
																allowBlank : false
															}, {
																xtype : 'checkboxgroup',
																fieldLabel : '角色权限',
																columns : 3,
																vertical : true,
																items : list
															}, {
																xtype : 'textareafield',
																name : 'description',
																value : rec
																		.get('description'),
																fieldLabel : '角色描述:'
															}],
													buttons : [{
																text : '确定',
																handler : function() {
																		var id = window.items.get(0);
																		var name = window.items.get(1);
																		var resources = window.items.get(2);
																		var des = window.items.get(3);
																		if (name.isValid()) {
																			var resourceArray = resources.getChecked();
																			var resourceIds=new String("");
																			for (var i = 0; i < resourceArray.length; i++) {
																				resourceIds += resourceArray[i].inputValue
																						+ ",";
																			}
																			Ext.Ajax.request({
																				url : 'manager/systemManage/roleManage/editRole',
																				params : {
																					id:id.getValue(),
																					name : name.getValue(),
																					resourceIds : resourceIds.substring(0,resourceIds.length-1),
																					description : des
																							.getValue()
																				},
																				success : function(response) {
																					var text = response.responseText;
																					var result = Ext.JSON.decode(text);
																					if (result.result) {
																						var roleManageTabView = Ext.ComponentQuery
																								.query('roleManageTabView')[0];
																						roleManageTabView
																								.getStore()
																								.reload();
																						window.close();
																					} else {
																						requestResultFailure(result);
																					}
																				}
																			});
																		}
																}
															}, {
																text : '取消',
																handler : function() {
																	window
																			.close();
																}
															}]
												}).show();
									} else {
										requestResultFailure(result);
									}
								}
							});

						},
						isDisabled : function(view, rowIndex, colIndex, item,
								record) {
							/*if (record.data.id == 1 || record.data.id == 2
									|| record.data.id == 3
									|| record.data.id == 4) {
								return true;
							} else {
								return false;
							}*/
									//调试期间暂时放开编辑
									return false;
						}
					},'-', {
						icon : 'img/main_right/user_delete.png',
						tooltip : '删除',
						handler : function(grid, rowIndex, colIndex) {
							Ext.Msg.show({
								title : '警告',
								buttons : Ext.Msg.OKCANCEL,
								icon : Ext.Msg.WARNING,
								msg : '确定要求删除角色:'+grid.getStore().getAt(rowIndex).get('name'),
								fn:function(buttonId){
									if(buttonId=="ok"){
										Ext.Ajax.request({
											url : 'manager/systemManage/roleManage/deleteRole',
											params : {
												id : grid.getStore().getAt(rowIndex).get('id')
											},
											success : function(response) {
												var text = response.responseText;
												var result = Ext.JSON.decode(text);
												if(result.result){
													grid.getStore().reload();
												}else{
													requestResultFailure(result);
												}
											}
										});
									}
								}
							});
							
						},
						isDisabled : function(view, rowIndex, colIndex, item,
								record) {
							if (record.data.id == 1 || record.data.id == 2
									|| record.data.id == 3
									|| record.data.id == 4) {
								return true;
							} else {
								return false;
							}
						}
					}]
				}];
		this.tbar = [{
			text : '自定义角色',
			xtype : 'button',
			icon : 'img/main_right/user_add.png',
			scope : this,
			handler : function(button) {
				Ext.Ajax.request({
					url : 'manager/systemManage/roleManage/getResourceListByRoleId',
					params : {
						id : '0'
					},
					success : function(response) {
						var text = response.responseText;
						var result = Ext.JSON.decode(text);
						if (result.result) {
							var list = result.list;//从服务器获取的权限列表数组；
							var window = Ext.create('Ext.window.Window', {
								title : '自定义角色',
								//height: 200,
								width : 500,
								modal : true,
								bodyPadding : 5,
								icon : 'img/main_right/user_add.png',
								layout : 'form',
								items : [{
											xtype : 'textfield',
											name : 'name',
											fieldLabel : '角色名称:',
											allowBlank : false
										}, {
											xtype : 'checkboxgroup',
											fieldLabel : '角色权限',
											columns : 3,
											vertical : true,
											items : list
										}, {
											xtype : 'textareafield',
											name : 'description',
											fieldLabel : '角色描述:'
										}],
								buttons : [{
									text : '确定',
									handler : function(button) {
										var role = window.items.get(0);
										var resources = window.items.get(1);
										var des = window.items.get(2);
										if (role.isValid()) {
											var resourceArray = resources.getChecked();
											var resourceIds=new String("");
											for (var i = 0; i < resourceArray.length; i++) {
												resourceIds += resourceArray[i].inputValue
														+ ",";
											}
											Ext.Ajax.request({
												url : 'manager/systemManage/roleManage/addRole',
												params : {
													name : role.getValue(),
													resourceIds : resourceIds.substring(0,resourceIds.length-1),
													description : des
															.getValue()
												},
												success : function(response) {
													var text = response.responseText;
													var result = Ext.JSON.decode(text);
													if (result.result) {
														var roleManageTabView = Ext.ComponentQuery
																.query('roleManageTabView')[0];
														roleManageTabView
																.getStore()
																.reload();
														window.close();
													} else {
														requestResultFailure(result);
													}
												}
											});
										}
									}
								}, {
									text : '取消',
									handler : function() {
										window.close();
									}
								}]
							}).show();
						} else {
							requestResultFailure(result);
						}
					}
				});
			}
		}];
		this.plugins = [{
					ptype : 'datatip',
					tpl : '【角色】:{name},【权限】:{resources}'
				}];
		this.callParent();
	}
})