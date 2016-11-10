# 车优美
# 一个洗车服务端(车优美)
{"datas":[
{"id":1,"addr":"海南省海口市龙华区府城镇凤翔路321号","shopName":"车信达洗车店","totalRase":1,"user_id":2,"url":"/image/url/log1.png","discPrice":18.0,"critical":true},
{"id":2,"addr":"海南省海口市龙华区府城镇凤翔路322号","shopName":"车信达洗车店","totalRase":1,"user_id":3,"url":"/image/url/log2.png","discPrice":18.0,"critical":true},
{"id":3,"addr":"海南省海口市龙华区府城镇凤翔路323号","shopName":"车信达洗车店","totalRase":1,"user_id":4,"url":"/image/url/log3.png","discPrice":18.0,"critical":true},
{"id":4,"addr":"海南省海口市龙华区府城镇凤翔路324号","shopName":"车信达洗车店","totalRase":1,"user_id":5,"url":"/image/url/log4.png","discPrice":18.0,"critical":true},
{"id":5,"addr":"海南省海口市龙华区府城镇凤翔路325号","shopName":"车信达洗车店","totalRase":1,"user_id":6,"url":"/image/url/log5.png","discPrice":18.0,"critical":true},
{"id":6,"addr":"海南省海口市龙华区府城镇凤翔路326号","shopName":"车信达洗车店","totalRase":1,"user_id":7,"url":"/image/url/log6.png","discPrice":18.0,"critical":true},
{"id":7,"addr":"海南省海口市龙华区府城镇凤翔路327号","shopName":"车信达洗车店","totalRase":1,"user_id":8,"url":"/image/url/log7.png","discPrice":18.0,"critical":true},
{"id":8,"addr":"海南省海口市龙华区府城镇凤翔路328号","shopName":"车信达洗车店","totalRase":1,"user_id":9,"url":"/image/url/log8.png","discPrice":18.0,"critical":true}]}
==============================
{"datas":[
{"id":6,"addr":"海南省海口市龙华区府城镇凤翔路326号","shopName":"车信达洗车店6","totalRase":1,"user_id":7,"url":"image/url/log.png","discPrice":66.0},
{"id":7,"addr":"海南省海口市龙华区府城镇凤翔路327号","shopName":"车信达洗车店7","totalRase":1,"user_id":8,"url":"image/url/log.png","discPrice":77.0},
{"id":8,"addr":"海南省海口市龙华区府城镇凤翔路328号","shopName":"车信达洗车店8","totalRase":1,"user_id":9,"url":"image/url/log.png","discPrice":88.0},
{"id":9,"addr":"海南省海口市龙华区府城镇凤翔路329号","shopName":"车信达洗车店9","totalRase":1,"user_id":10,"url":"image/url/log.png","discPrice":99.0}]}
//车库信息
http://localhost:8080/cheyoumei/usrCar/findUsrCar?userid_id=5
//增加车辆信息
http://localhost:8080/cheyoumei/usrCar/add?plateNum=苏SB7749&carColor=黑色&userid_id=5&carbrand=奥迪 A6 的国产
//更新车辆信息
http://localhost:8080/cheyoumei/usrCar/updateUsrCar?id=2&plateNum=京B21353&carColor=白色&carSeries=宝马 X6系列
//删除车辆信息
http://localhost:8080/cheyoumei/usrCar/delUsrCar?id=5
//用户信息更新
http://localhost:8080/cheyoumei/mobileUpdateLoginPwd?id=2&mobilePhone="2222222"&loginPwd="111111"&logoUrl="images/users/logo/nologo.png"
//手机用户登录
http://172.16.23.184:8080/cheyoumei/mobileUserLogin?mobilePhone=2222222&loginPwd=1qaz2wsx3edc  
//删除车辆信息
http://localhost:8080/cheyoumei/usrCar/delUsrCar?id=2
//获取商店列表
http://localhost:8080/cheyoumei/arriveStore/washCar?mobileAddress=海南省海口市美兰区府城镇凤翔路322号&currentPage=2&pageSize=2
//商店详细信息
http://172.16.23.184:8080/cheyoumei/arriveStore/shopDetailInfo?id=2
{"datas":[{"parent":"洗车","serviceDatas":[{"id":2,"name":"产品02","discPrice":22.0},{"id":3,"name":"产品03","discPrice":33.0}]}],"stateCode":0}
//更改用户支付密码
http://172.16.23.184:8080/cheyoumei/mobileUpdatePayPwd?id=2&payPwd=123456
//生成订单信息
http://localhost:8080/cheyoumei/addOrders?customerId=2&goodId=2&sellerId=3&serverType=0
//根据订单号查询订单
http://localhost:8080/cheyoumei/findOrders?ordersNum=20150618000002&serverType=0
//查询用户所有到店的订单详情
http://localhost:8080/cheyoumei/findOrdersByCustomerId?customerid=2&serverType=0
//查询用户洗车记录
http://localhost:8080/cheyoumei/findOrdersListByCustomerId?customerid=2
//增加商店评论
localhost:8080/cheyoumei/mobile/comment?goodsId=2&userId=2&rasePoint=4&message=这个已经评论过了
//增加订单评论内容
localhost:8080/cheyoumei/mobile/comment?goodsId=2&userId=2&rasePoint=4&message=这个已经评论过了&orderCode=201506111542
//分页查询评论
http://localhost:8080/cheyoumei/mobile/findCommentList?shopId=2&currentPage=1&pageSize=8
//订单确认返回服务时间
http://localhost:8080/cheyoumei/mobile/confirmService?orderCode=20150616000001

//设置用户默认车辆
http://localhost:8080/cheyoumei/usrCar/setDefaultCar?userid_id=49&carId=5
