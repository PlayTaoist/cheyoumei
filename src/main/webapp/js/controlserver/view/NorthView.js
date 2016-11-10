Ext.define('controlserver.view.NorthView', {
    extend: 'Ext.panel.Panel',
    xtype: 'northView',
    border:0,
    height: 55,
	bodyStyle:'background:url(img/main_top/bg.png)',
	split: true,
	maxHeight: 55,
	minHeight: 55,
	layout: 'hbox',
	items:[{
		align: 'left',
		width:581,
		height:55,
		border:0,
		html:'<img src="img/main_top/logo.png" />'
	},{xtype : "tbfill"},{
		xtype: 'button',
		id:'topview_mainTab',
        icon:'img/main_top/house.png',
        margin: '28 10 0 0',
        tooltip: '启动'
	},{
		xtype: 'button',
		id:'topview_editUserinfo',
        icon:'img/main_top/user_suit.png',
        margin: '28 10 0 0',
        tooltip: '修改用户信息'
	},{
		xtype: 'button',
		id:'topview_exitSystem',
        icon:'img/main_top/cross.png',
        margin: '28 15 0 0',
        tooltip: '退出系统'
	}]
});