
[系统消息]词库初始化
$黄色日志 寻芸XY-防艾特❂注入中..........$
$绿色日志 寻芸XY-防艾特❂注入成功！$

.*@.*.*
如果:$读 寻芸XY/服务器/开关 X 正常$!=正常
返回
如果尾
如果:$读 激活验证/卡密激活状态/%群号% X 未激活$==未激活
返回
如果尾
如果:%群号%==0
返回
如果尾
如果:$管理员 %群号% %登录账号%$!=%登录账号%
返回
如果尾
如果:%AT0%==%登录账号%
$调用 给你脸了？$

[内部]给你脸了？
时:%时间yyyy-MM-dd%
次:$读 柠檬的/艾特劳资干嘛/%时%/%群号% %QQ% 0$
如果:%次%==0
$回复 %MsgId%$
你艾特我干嘛！
$写 柠檬的/艾特劳资干嘛/%时%/%群号% %QQ% [%次%+1]$
返回
如果尾
如果:%次%==1
$回复 %MsgId%$
你还艾特我是吧！
$写 柠檬的/艾特劳资干嘛/%时%/%群号% %QQ% [%次%+1]$
返回
如果尾
如果:%次%==2
$回复 %MsgId%$
你还艾特我，真以为我不会反抗呐！
$写 柠檬的/艾特劳资干嘛/%时%/%群号% %QQ% [%次%+1]$
返回
如果尾
如果:%次%==3
$回复 %MsgId%$
你再艾特我可就要摇人了哦！
$写 柠檬的/艾特劳资干嘛/%时%/%群号% %QQ% [%次%+1]$
返回
如果尾
如果:%次%==4
$回复 %MsgId%$
你真以为我没人脉啊！
$写 柠檬的/艾特劳资干嘛/%时%/%群号% %QQ% [%次%+1]$
返回
如果尾
如果:%次%==5
$回复 %MsgId%$
你真因为我不敢叫人呐！
$写 柠檬的/艾特劳资干嘛/%时%/%群号% %QQ% [%次%+1]$
返回
如果尾
如果:%次%==6
$回复 %MsgId%$
再给你一次机会！
$写 柠檬的/艾特劳资干嘛/%时%/%群号% %QQ% [%次%+1]$
返回
如果尾
如果:%次%==7
$回复 %MsgId%$
你欺负我，我要去告状！
$写 柠檬的/艾特劳资干嘛/%时%/%群号% %QQ% [%次%+1]$
返回
如果尾
如果:%次%>7
管家上！
fsn:好的小姐！
$调用 Q群管家触发$
$写 柠檬的/艾特劳资干嘛/%时%/%群号% %QQ% [%次%+1]$
$禁 %群号% %QQ% [30*60]$


管家发([\s\S]*)
如果:$主人 %QQ%$==0
返回
如果尾
fsn:%括号1%
$撤回 %MsgId%$
$调用 Q群管家触发$

[群聊消息]JSON
j:%Json%
如果:@j[app]==com.tencent.autoreply&%QQ%==2854196310
$全局变量 qqgj%群号% @j[meta][metadata][token]$
$配置文件 YKXBL群管/配置/%群号%.txt 保存$
如果:$读 YKXBL群管/全局配置 发送格式 文本$==管家
$撤回 %MsgId%$
如果尾
返回
如果尾

[内部]Q群管家触发
A:[0,1,2,3,4,5,6,7,8,9,"A","B","C","D","E","F","a","b","c","d","e","f"]
C:$随机数 A 8$
b:{"bkn":$GTK %skey%$,"group_id":%群号%,"qna_item":{"slot":0,"question":"%C%","answer":"%fsn%","keyword":["%C%"]}}
t:{"qname-service":"976321:131072","qname-space":"Production","User-Agent":"Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/537.36 (KHTML, like Gecko) Safari/537.36 VivoBrowser/14.5.12.0 Chrome/87.0.4280.141","Content-Type":"application/json","Origin":"https://web.qun.qq.com","Cookie":"uin=o%Robot%;skey=%skey%;p_skey=%qun.qq.com%;"}
f:https://web.qun.qq.com/qunrobot/proxy/domain/app.qun.qq.com/cgi-bin/guanjia_robot/qna_setting/set_qna?bkn=$GTK %skey%$
F:$访问 POST %f% %b% %t% ydt$
如果:@F[retcode]!=200&@F[retcode]!=0
如果:@F[retcode]==100420
f:https://web.qun.qq.com/qunrobot/proxy/domain/app.qun.qq.com/cgi-bin/guanjia_robot/qna_setting/set_qna?bkn=$GTK %skey%$
b:{"bkn":$GTK %skey%$,"group_id":%群号%,"qna_item":{"slot":1,"question":"","answer":"","keyword":[]}}
F:$访问 POST %f% %b% %t% ydt$
$跳转 4$
如果尾
返回
如果尾
i:0
f:https://app.qun.qq.com/cgi-bin/guanjia_robot/qna_callback/get_answer?bkn=$GTK %skey%$
:at
如果:%i%>=5
返回
如果尾
b:{}
T:$全局变量 qqgj%群号%$
$JSON 添加 b anonymous 1$$JSON 添加 b question %C%$$JSON 添加 b token %T%$
//t:{"Cookie":"uin=o0%Robot%; p_uin=o0%Robot%; skey=%skey%; p_skey=%qun.qq.com%","Content-Type":"application/json"}
F:$访问 POST %f% %b% %t% ydt$
如果:@F[ec]!=200&@F[ec]!=0
$新建消息 A$
$添加消息 A Group$
$添加消息 A GroupId %群号%$
$添加消息 A AtUin 2854196310$
$添加消息 A AtName Q群管家$
$发送消息 A B$
$撤回 %B:MsgId%$
$休眠 1000$
i:[%i%+1]
$jump :at$
如果尾
f:https://web.qun.qq.com/qunrobot/proxy/domain/app.qun.qq.com/cgi-bin/guanjia_robot/qna_setting/get_qna?bkn=$GTK %skey%$
b:{"bkn":$GTK %skey%$,"group_id":%群号%}
F:$访问 POST %f% %b% %t% ydt$
如果:@F[retcode]!=0&@F[retcode]!=200
返回
如果尾
l:@F[data][qna_list]
长:$JSON 长度 l$
i:0
:xz
如果:%i%>=%长%
返回
如果尾
如果:@l[%i%][question]==%C%
s:[%i%+1]
$跳转 4$
如果尾
i:[%i%+1]
$jump :xz$
i:0
:sc
如果:%i%>=5
返回
如果尾
f:https://web.qun.qq.com/qunrobot/proxy/domain/app.qun.qq.com/cgi-bin/guanjia_robot/qna_setting/set_qna?bkn=$GTK %skey%$
b:{"bkn":$GTK %skey%$,"group_id":%群号%,"qna_item":{"slot":%s%,"question":"","answer":"","keyword":[]}}
F:$访问 POST %f% %b% %t% ydt$
如果:@F[retcode]!=0&@F[retcode]!=200
i:[%i%+1]
$jump :sc$
如果尾