#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <mxml.h>
int main()
{
    //文件头
    mxml_node_t* root=mxmlNewXML("1.0");

    //根标签
    mxml_node_t* china=mxmlNewElement(root,"china");

    //子标签 --- city
    mxml_node_t* city=mxmlNewElement(china,"city");
    mxml_node_t* info=mxmlNewElement(city,"name");
    //给标签赋值
    mxmlNewText(info,0,"北京");
    //设置属性值
    mxmlElementSetAttr(info,"isbig","yes");
    //面积
    info=mxmlNewElement(city,"area");
    mxmlNewText(info,0,"16410 平方公里");
    //人口
    info=mxmlNewElement(city,"population");
    mxmlNewText(info,0,"2171万人");
    //GDP
    info=mxmlNewElement(city,"gdp");
    mxmlNewText(info,0,"24541亿元");

    //东京
    city=mxmlNewElement(china,"city");
    info=mxmlNewElement(city,"name");
    //给标签赋值
    mxmlNewText(info,0,"东京");
    //设置属性值
    mxmlElementSetAttr(info,"isbig","no");
    //面积
    info=mxmlNewElement(city,"area");
    mxmlNewText(info,0,"2188 平方公里");
    //人口
    info=mxmlNewElement(city,"population");
    mxmlNewText(info,0,"3670万人");
    //GDP
    info=mxmlNewElement(city,"gdp");
    mxmlNewText(info,0,"31700亿元");

    //数据保存
    FILE* fp=fopen("china.xml","w");
    mxmlSaveFile(root,fp,MXML_NO_CALLBACK);
    fclose(fp);
    //先左后右再根
    mxmlDelete(root);
    

    

}