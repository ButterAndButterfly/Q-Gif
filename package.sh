# cd 到脚本所在目录
cd $(dirname $0)

# 复制整个文件夹
mkdir target
cp -r src/. target

# 获取java文件列表
cd target
find `pwd` -name "*.java" > ../sources.txt
cd ..

# 编译java
javac -encoding UTF-8 @sources.txt

# 删除所有.java文件
cd target
find . -name "*.java" |xargs rm -rf {}
cd ..

# 打包
jar cvfe addTextToGif.jar nicelee.Main -C ./target .

#rm -rf target
#rm -f sources.txt