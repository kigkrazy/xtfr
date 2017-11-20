### 几个类尝试

|类名|函数名|是否有效|
|:---:|:---:|:---:|
|com.oppo.statistics.provider|getHostUrl|无效|

### 几个关键函数位置，及其说明

|类名|函数名|是否有效|  
|:---:|:---:|:---:|
|com.nearme.a__ServiceManage| - |各个组件的初始化（包括HTTP请求 组件）|  
|com.nearme.network.c__NetRequestEngine|-|HTTP请求组件|
|a.a.a.kk__HttpRequestMrgImpl|-|HTTP Request初始化，包括证书初始化|

### 发现的问题
#### 分析位置
com.nearme.common.util.DeviceUtil#getRomName

#### 描述
获取Display设备rom版本号的获取方法，此种方法并非直接“Build.DISPLAY”,参数没有替换到相关属性值。

#### 解决方案
要求用Hook android.os.SystemPropertiesd#get的方法，将build所有属性值重写一遍