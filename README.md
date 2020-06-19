# Q-Gif
<p align="center">
  <img src="/pics/真香/text.gif"/>
  <br>
      <strong>
        <a href="https://github.com/ButterAndButterfly/Q-Gif" target="_blank">Q-Gif</a>
      </strong>  为Gif定制对话而生  
  <br>
      <strong>
        <a href="https://github.com/ButterAndButterfly" target="_blank">ButterAndButterfly</a><br>
      </strong>  
        Butter, 寓意宅男; Butterfly, 寓意美好的事物。 
        <br/> 美好的世界由我们创造!  
</p>



## 如何使用  
+ 请前往[issue](https://github.com/ButterAndButterfly/Q-Gif/issues)，根据标签进行选择。  
+ 比如，[真香-王境泽](https://github.com/ButterAndButterfly/Q-Gif/issues/2)  
    在对应issue按照格式输入四句台词，例如：  
    ```
    我就是饿死
    死外边，从这里跳下去
    不会吃你们一点东西
    真香
    ```
    请注意台词需要放入代码区块中(不指定语言)，即用` ``` `包裹
+ Gif生成需要一定时间，且即使是失败也会有回复。请勿重复发送。  

## 相关接口  
```java
// 生成 充钱就能解决.gif
FileOutputStream output = new FileOutputStream("充钱就能解决.gif");
Bot.gen("充钱就能解决", output, "那我这个问题？", "你这个问题充钱就能解决");
// 生成 真香.gif
output = new FileOutputStream("真香.gif");
Bot.gen("真香", output, "我就是饿死", "死外边，从这里跳下去", "不会吃你们一点东西", "真香");
```        

## 如何拓展场景  
+ 参考类`nicelee.bilibili.Train`  
+ 详细步骤请看[真香！如何给Gif添加对白?](https://nICEnnnnnnnLee.github.io/blog/2020/06/14/java-add-text-to-gif/)  

## 其它  
参考了<https://github.com/glt/GIFBuilder>进行实现，实现环境由Android改为JVM  

## LICENSE  
```
Copyright (C) 2020 NiceLee. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
本项目用到的Gif图片资源均引用自互联网，所有权利保留


