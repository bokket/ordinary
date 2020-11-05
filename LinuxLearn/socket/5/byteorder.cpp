//
// Created by bokket on 2020/11/4.
//

//#include <iostream>
#include <stdio.h>
using namespace std;

void byteorder()
{
    union {
        short value;
        char union_bytes[sizeof(short)];
    }test;

    test.value=0x0102;
    if(test.union_bytes[0]==1 && test.union_bytes[1]==2)
    {
        printf("big duan\n");
    }
    else if(test.union_bytes[0]==2 && test.union_bytes[1]==1)
    {
        printf("%#x\n",test.value);
        printf("litter duan\n");
    }
    else
    {
        printf("unkown");
    }
};
int main()
{
    byteorder();
}
