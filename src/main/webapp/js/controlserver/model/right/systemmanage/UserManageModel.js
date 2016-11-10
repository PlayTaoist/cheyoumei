Ext.define('controlserver.model.right.systemmanage.UserManageModel',{
	extend: 'Ext.data.Model',
    fields: [
        {name: 'id',  type: 'int'},
        {name: 'userName',  type: 'string'},
        {name: 'firm',  type: 'string'},
        {name: 'mobilePhone', type: 'string'},
        {name: 'payPwd', type: 'string'},
        {name: 'point', type: 'int'},
        {name: 'balance', type: 'double'},
        {name: 'loginPwd', type: 'string'},
        {name: 'logoUrl', type: 'string'},
        {name: 'gender', type: 'string'},
        {name: 'addr', type: 'string'},
        {name: 'totalRase',   type: 'int'},
        {name: 'raseCount',   type: 'int'},
        {name: 'isActived',   type: 'boolean'},
        {name: 'isOnline',   type: 'boolean'},
        {name: 'isdeleted',   type: 'boolean'},
        {name: 'lastLogin',   type: 'string'},   //时间
        {name: 'createdAt',   type: 'string'},  //时间
        {name: 'deletedAt',   type: 'string'}, //时间
        {name: 'deletedByUserId',   type: 'int'},
        {name: 'role',   type: 'string'},
    ]
})