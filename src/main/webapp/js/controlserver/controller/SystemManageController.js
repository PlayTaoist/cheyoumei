var organizationID = 1;

Ext.define('controlserver.controller.SystemManageController', {
	extend : 'Ext.app.Controller',

	xtype : 'systemManageController',
	views : ['NorthView', 'LeftView', 'RightView', 'right.MainView',
			'left.TerminalManageMenuView', 
			'left.SystemManageMenuView',
			'right.systemmanage.RoleManageTabView',
			'right.systemmanage.ResourceManageTabView',
			'right.systemmanage.UserManageTabView'],
	stores : ['left.TerminalManageMenuStore', 
			'left.SystemManageMenuStore', 'right.systemmanage.RoleManageStore',
			'right.systemmanage.ResourceManageStore',
			'right.systemmanage.UserManageStore'],
	models : ['MenuTreeModel', 'right.systemmanage.RoleManageModel',
			'right.systemmanage.ResourceManageModel',
			'right.systemmanage.UserManageModel'],
	init : function() {
		this.control({
					'northView button[id=topview_mainTab]' : {
						click : this.showMainTab
					},
					'northView button[id=topview_exitSystem]' : {
						click : this.exitSystem
					},
					'northView button[id=topview_editUserinfo]' : {
						click : this.editUserinfo
					},
					'terminalManageMenuView' : {
						itemclick : this.openMenu
					},
					'systemManageMenuView' : {
						itemclick : this.openMenu
					},
					'roleManageTabView' : {
						show : this.show
					},
					'resourceManageTabView' : {
						show : this.show
					},
					'resourceManageTabView button[id=addResourceButton]' : {
						click : this.addResource
					},
					'resourceManageTabView actioncolumn[id=resourceActionColumn]' : {
						itemclick : this.deleteOrEditResource
					},
					'userManageTabView' : {
						show : this.show
					},
					'userManageTabView button[id=addUserButton]' : {
						click : this.addUser
					},
					'userManageTabView actioncolumn[id=resourceActionColumn]' : {
						itemclick : this.handleUser
					}
				})
	},
	addUser : function(button) {
		Ext.Ajax.request({
			url : 'manager/systemManage/userManage/getRoleListByUserId',
			params : {
				id : '0'
			},
			success : function(response) {
				var text = response.responseText;
				var result = Ext.JSON.decode(text);
				if (result.result) {
					var storecombobox =  Ext.create('Ext.data.Store', {
		  			   	fields: [{name:'demname'},{name:'id'}],
		   				proxy :{
		   					type:'ajax',
		   					url:'manager/systemManage/departmentManage/getDepartmentList',
		   					reader:{
		   						type : 'json',
		   						root : 'datas'
		   					}
		   				}
						});
					var list = result.list;
					var addUserWindow = Ext.create('Ext.window.Window', {
						title : button.text,
						icon : button.icon,
						width : 400,
						modal : true,
						bodyPadding : 5,
						layout : 'form',
						items : [{
									fieldLabel : '姓名:',
									name : 'likename',
									xtype : 'textfield',
									allowBlank : false
								}, {
									xtype : 'radiogroup',
									fieldLabel : '角色',
									columns : 2,
									vertical : true,
									items : list
								}, {
									fieldLabel : '帐号:',
									name : 'username',
									xtype : 'textfield',
									allowBlank : false
								}, {
									fieldLabel : '密码:',
									name : 'password',
									xtype : 'textfield',
									inputType : 'password',
									allowBlank : false
								},{
									fieldLabel : '性别',
									name : 'sex',
									xtype : 'radiogroup',
									allowBlank : false,
									 items: [{
									 name: 'sex',
									inputValue: '男',
									boxLabel: '男',
									 checked: true
									  }, {
										name: 'sex',
									   inputValue: '女',
										boxLabel: '女'
									 }]
								},{
									fieldLabel : '手机号:',
									name : 'phone',
									xtype : 'textfield',
									allowBlank : false
								},{
									fieldLabel : '部门',
					                xtype: 'combobox',
					                name : 'department',
					                editable : false,
					                multiSelect : false,
					                displayField : 'demname',
					                valueField : 'demname',
					                store : storecombobox
								},{
									fieldLabel : '备注:',
									xtype : 'textarea',
									name : 'description'
								}],
						buttons : [{
							text : '提交',
							handler : function() {
								var likename = addUserWindow.items.get(0);
								var role = addUserWindow.items.get(1);
								var username = addUserWindow.items.get(2);
								var password = addUserWindow.items.get(3);
								var sex=addUserWindow.items.get(4);
								var phone=addUserWindow.items.get(5);
								var department=addUserWindow.items.get(6);
								var description = addUserWindow.items.get(7);
								var checked  = role.getChecked();
								if (likename.isValid() && password.isValid()
										&& username.isValid()&&checked.length!=0) {
											Ext.Ajax.request({
												url:'manager/systemManage/userManage/addUser',
												params:{
													likename:likename.getValue(),
													roleId: checked[0].inputValue,
													username:username.getValue(),
													password:password.getValue(),
													sex:sex.getValue(),
													phone:phone.getValue(),
													department:department.getValue(),
													description:description.getValue()
												},
												success : function(response) {
													var text = response.responseText;
													var result = Ext.JSON.decode(text);
													if (result.result) {
														var userGridPanel = Ext.ComponentQuery
																.query("userManageTabView")[0];
														userGridPanel.getStore().reload();
														addUserWindow.close();
													} else {
														controlserver.controller.SystemManageController
																.requestResultFailure(result);
													}
												}
											});
								} else {
									controlserver.controller.SystemManageController
											.requestResultFailure({
														result : false,
														type:'2',
														msg : '用户/登陆名/密码不能为空'
													});
								}
							}
						}, {
							text : '取消',
							handler : function() {
								addUserWindow.close();
							}
						}]
					});
					addUserWindow.show();
				} else {
					controlserver.controller.SystemManageController
							.requestResultFailure(result);
				}
			}
		});

	},
	/**
	 * 编辑，删除，修改用户
	 * 
	 * @param {}
	 *            column
	 * @param {}
	 *            grid
	 * @param {}
	 *            rowIndex
	 * @param {}
	 *            colIndex
	 * @param {}
	 *            item
	 * @param {}
	 *            e
	 * @param {}
	 *            record
	 * @param {}
	 *            rowEl
	 */
	handleUser : function(column, grid, rowIndex, colIndex, item, e, record,
			rowEl) {
		if (item.action == "edit") {

		}
		if (item.action == "delete") {

		}
		if (item.action == "passwd") {

		}
	},
	/**
	 * 删除或编辑资源
	 * 
	 * @param {}
	 *            column 操作字段
	 * @param {}
	 *            grid 对应的grid
	 * @param {}
	 *            rowIndex
	 * @param {}
	 *            colIndex
	 * @param {}
	 *            item
	 * @param {}
	 *            e
	 * @param {}
	 *            record
	 * @param {}
	 *            rowEl
	 */
	deleteOrEditResource : function(column, grid, rowIndex, colIndex, item, e,
			record, rowEl) {
		var rec = grid.getStore().getAt(rowIndex);
		if (item.action == "edit") {
			var editResourceWindow = Ext.create('Ext.window.Window', {
				width : 400,
				title : item.tooltip,
				icon : item.icon,
				layout : 'form',
				modal : true,
				bodyPadding : 5,
				items : [{
							fieldLabel : '资源名称',
							name : 'name',
							xtype : 'textfield',
							value : record.get("name"),
							allowBlank : false
						}, {
							fieldLabel : '资源URL',
							name : 'url',
							xtype : 'textfield',
							value : record.get("url"),
							allowBlank : false
						}, {
							fieldLabel : '资源描述',
							name : 'description',
							value : record.get("description"),
							xtype : 'textarea'
						}],
				buttons : [{
					text : '确定',
					handler : function() {
						var name = editResourceWindow.items.get(0);
						var url = editResourceWindow.items.get(1);
						var description = editResourceWindow.items.get(2);
						if (name.isValid() && url.isValid()) {
							Ext.Ajax.request({
								url : 'manager/systemManage/resourceManage/editResource',
								params : {
									id : record.get("id"),
									name : name.getValue(),
									url : url.getValue(),
									description : description.getValue()
								},
								success : function(response) {
									var text = response.responseText;
									var result = Ext.JSON.decode(text);
									if (result.result) {
										var resourceGridPanel = Ext.ComponentQuery
												.query("resourceManageTabView")[0];
										resourceGridPanel.getStore().reload();
										editResourceWindow.close();
									} else {
										controlserver.controller.SystemManageController
												.requestResultFailure(result);
									}
								}
							});
						}

					}
				}, {
					text : '取消',
					handler : function() {
						editResourceWindow.close();
					}
				}]
			});
			editResourceWindow.show();
		}
		if (item.action == "delete") {
			Ext.Msg.show({
				title : '警告',
				buttons : Ext.Msg.YESNO,
				icon : Ext.Msg.WARNING,
				msg : '确定要求删除该资源',
				fn : function(buttonId) {
					if (buttonId == "yes") {
						Ext.Ajax.request({
							url : 'manager/systemManage/resourceManage/deleteResource',
							params : {
								id : record.get("id")
							},
							success : function(res, req) {
								var result = Ext.JSON.decode(res.responseText);
								if (result.result) {
									grid.getStore().reload();
								} else {
									controlserver.controller.SystemManageController
											.requestResultFailure(result);
								}
							}
						});
					}
				}
			});

		}
		// alert(record.get('name'));
	},
	/**
	 * 增加资源的方法
	 * 
	 * @param {}
	 *            button
	 */
	addResource : function(button) {
		var addResourceWindow = Ext.create('Ext.window.Window', {
			width : 400,
			title : button.text,
			icon : button.icon,
			layout : 'form',
			modal : true,
			bodyPadding : 5,
			items : [{
						fieldLabel : '资源名称',
						name : 'name',
						xtype : 'textfield',
						allowBlank : false
					}, {
						fieldLabel : '资源URL',
						name : 'url',
						xtype : 'textfield',
						allowBlank : false
					}, {
						fieldLabel : '资源描述',
						name : 'url',
						xtype : 'textarea'
					}],
			buttons : [{
				text : '确定',
				handler : function() {
					var name = addResourceWindow.items.get(0);
					var url = addResourceWindow.items.get(1);
					var description = addResourceWindow.items.get(2);
					if (name.isValid() && url.isValid()) {
						Ext.Ajax.request({
							url : 'manager/systemManage/resourceManage/addResource',
							params : {
								name : name.getValue(),
								url : url.getValue(),
								description : description.getValue()
							},
							success : function(response) {
								var text = response.responseText;
								var result = Ext.JSON.decode(text);
								if (result.result) {
									var resourceGridPanel = Ext.ComponentQuery
											.query("resourceManageTabView")[0];
									resourceGridPanel.getStore().reload();
									addResourceWindow.close();
								} else {
									controlserver.controller.SystemManageController
											.requestResultFailure(result);
								}
							}
						});
					}

				}
			}, {
				text : '取消',
				handler : function() {
					addResourceWindow.close();
				}
			}]
		});
		addResourceWindow.show();
	},
	/**
	 * 单击菜单时，打开相应功能
	 */
	openMenu : function(view, record, item, index) {
		var control = this;
		if (record.data.leaf) {
			// Ext.Msg.alert("sdfsdf","sdfsd");
			Ext.Ajax.request({
				url : record.data.url,
				success : function(response) {
					var result = Ext.JSON.decode(response.responseText);
					if (result.result) {
						var tabPanel = Ext.ComponentQuery.query('rightView')[0];// 查询获取右边对他tabPanel
						var tabs = tabPanel.items.items;// 获取现有tab
						var isExistTab = false; // 记录单击的菜单是否存在
						var menuId = record.data.id;// 记录title
						var targetTabXtype = menuId + "TabView";
						for (var i = 0; i < tabs.length; i++) {
							// var tabTitle = tabs[i].tab.text;
							var tabXtype = tabs[i].xtype;
							if (tabXtype == targetTabXtype) {
								// 判断tabpanel中的tab的title有没有和菜单一样的，一样代表已经存在，只要激活就可以了
								isExistTab = true;
								tabPanel.setActiveTab(tabs[i]);
								break;
							}
						}
						if (!isExistTab) {
							// 不存在则打开一个tab
							var newTab = tabPanel.add([{
										title : record.data.text,
										icon : record.data.icon,
										xtype : targetTabXtype
									}])[0];
							tabPanel.setActiveTab(newTab);
						}
					} else {
						// Ext.Msg.alert("提示",result.msg);
						controlserver.controller.SystemManageController
								.requestResultFailure(result);
					}
				},
				failure : function() {
					controlserver.controller.SystemManageController.requestResultFailure({
								type : 2,
								msg : '连接服务器失败.....'
							});
					// Ext.Msg.alert("提示","连接服务器失败......");
				}
			});
		}
	},
	statics : {
		requestResultFailure : function(result) {
			if (result.type == 1) {
				Ext.Msg.show({
							title : '信息',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.INFO,
							msg : result.msg
						});
			} else if (result.type == 2) {
				Ext.Msg.show({
							title : '提示',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.INFO,
							msg : result.msg
						});
			} else if (result.type == 3) {
				Ext.Msg.show({
							title : '警告',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.WARNING,
							msg : result.msg
						});
			} else if (result.type == 4) {
				Ext.Msg.show({
							title : '错误',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR,
							msg : result.msg
						});
			}

		}
	},

	// 编辑个人资料
	editUserinfo : function(button) {
		var userinfoWindow = Ext.create('Ext.window.Window', {
			title : '修改密码',
			height : '300',
			width : '400',
			layout : 'fit',
			modal : true,
			items : {
				xtype : 'form',
				layout : 'anchor',
				defaults : {
					anchor : '100%',
					margin : '5',
					labelWidth : 50
				},
				defaultType : 'textfield',
				items : [{
							fieldLabel : '用户名',
							name : 'username',
							allowBlank : false
						}, {
							fieldLabel : '密码',
							name : 'password',
							allowBlank : false
						}],
				buttons : [{
					text : '提交',
					formBind : true,
					disabled : true,
					handler : function() {
						var form = this.up('form').getForm();
						if (form.isValid()) {
							form.submit({
								success : function(form, action) {
									Ext.Msg.alert('Success', action.result.msg);
								},
								failure : function(form, action) {
									Ext.Msg.alert('Failed', action.result.msg);
								}
							});
						}
					}
				}, {
					text : '重置',
					handler : function() {
						this.up('form').getForm().reset();
					}
				}]
			}
		});
		userinfoWindow.show();
	},
	// 退出登录
	exitSystem : function(button) {
		Ext.Msg.show({
					title : '退出系统',
					msg : '您确定要退出系统?',
					buttons : Ext.Msg.YESNO,
					icon : Ext.Msg.QUESTION,
					fn : function(buttonId) {
						if (buttonId == "yes") {
							Ext.Ajax.request({
										url : 'exit',
										success : function(response) {
											window.location.href = contextPath
													+ "index";
										}
									})
						}
					}
				});
	},
	// 加载panel时显示数据
	show : function(view) {
		view.getStore().load();
	}
})
