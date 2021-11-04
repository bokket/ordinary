//
// Created by bokket on 2020/12/3.
//

#include "String.h"
#include <cstring.h>
/***
 * delete _str和delete [] _str的区别  
***/
String::~String()
{
    if(_str!=NULL)
    {
        delete [] _str;
        _str=NULL;
    }
    capacity_=0;
    len_=0;
}
String::String()
        :_str(new char[1])
        ,capacity_(0)
        ,len_(0)
{
    strcpy(_str,"");
    /*
    len_=0;
    _str= new char[len_+1];
    strcpy(_str,"");*/
}
String::String(const char *s="")
        :capacity_(strlen(s)+1)
        ,len_(strlen(s))
        ,_str(new char[strlen(s)+1])
{
    strcpy(_str,s);
            /*
    if(str==NULL)
    {
        len_=0;
        _str=new char[len_+1];
        strcpy(_str,"");
    }
    else
    {
        len_=strlen(str);
        _str=new char[len_+1];
        strcpy(_str,str);
    }
             */
}
String::String(const String &str)
        :capacity_(strlen(str._str)+1)
        ,len_(strlen(str._str))
        ,_str(new char[strlen(str._str)+1])
{
    strcpy(_str,str._str);


     /*
    _str=new char[str.len_+1];
    len_=str.len_;
    if(str._str!=NULL)
        strcpy(_str,str._str);
    _str[len_]='\0';*/
    /*if(str._str==NULL)
    {
        len_=0;
        _str=new char[len_+1];
        strcpy(_str,"");
    }
    if(_str!=NULL)
    {
        delete []_str;
    }
    len_=str.len_;
    _str=new char[len_+1];
    strcpy(_str,str._str);
*/
}
String::String(size_t n, const char c)
{
    len_=n;
    _str=new char[len_+1];
    for(int i=0;i<n;i++)
    {
        _str[i]=c;
    }
}


void String::CheckCapacity(size_t pos)
{
    if(len_+1+pos >= capacity_)
    {
        capacity_=capacity_*2+10;
        char *tmp=new char[capacity_];
        strcpy(tmp,_str);
        delete [] _str;
        _str=tmp;
    }
}


String & String::operator=(const String &str)
{
    /*if(str==NULL)
        delete []_str;
    if(str._str==NULL)
    {
        len_=0;
        _str=new char[len_+1];
        strcpy(_str,"");
    }
    else
    {
        len_=str.len_;
        _str=new char[len_+1];
        strcpy(_str,str._str);
    }*/
    /*
    delete []_str;
    _str=new char[str.len_+1];
    len_=str.len_;
    if(str._str!=NULL)
        strcpy(_str,str._str);

    _str[len_]='\0';
    return *this;*/

    if(this!=&str)
    {
        delete []_str;
        _str=new char[strlen(str._str)+1];
        strcpy(_str,str._str);
    }
    return *this;
}
String & String::operator=(char *s)
{
    if(s==NULL)
    {
        len_=0;
        _str=new char[len_+1];
        strcpy(_str,"");
    }
    else
    {
        len_=strlen(s);
        _str=new char[len_+1];
        strcpy(_str,s);
    }
}


String & String::operator=(String str)
{
    cout<<"this is String & string::operator= (String str);"<<endl;

    swap(_str,str._str);
    capacity_=strlne(str._str+1);
    len_=str.len_;
    return *this;
}

char & String::operator[](size_t n)
{
    if(n<0 || n>len_)
        cout<<"数组越界"<<endl;
    return _str[n];
}
const char & String::operator[](size_t n) const
{
    if(n<0 || n>len_)
        cout<<"数组越界"<<endl;
    return _str[n];
}

char & String::at(size_t n)
{
    if(n<0 || n>len_)
        throw 0;
    return _str[n];
}

const char * String::c_str() const
{
    return _str;
}
char * String::toString() const
{
    char *str=new char[len_+1];
    if(_str!=NULL)
    {
        strcpy(str,_str);
    }
    str[len_]='\0';
    return str;
}

String & String::operator!=(const String & , const String &)
{

}

String & String::operator+(char c)
{
    CheckCapacity(1);
    memcpy(_str+len_,&c,1);
    len_+=1;
    return *this;
}
String & String::operator+(const String &str) const
{
    String s1;
    if(len_==0 && str.len_==0)
        return s1;

    s1.len_=len_+str.len_;

    s1._str=new char[s1.len_+1];
    if(_str!=NULL)
        strcpy(s1._str,_str);

    if(str._str!=NULL)
        strcpy(s1._str,str._str);

    *(s1._str+s1.len_)='\0';
    return s1;
    /*
    int size=len_+strlen(str._str);
    char* tmp=new char[size+1];

    //memcpy(tmp,_str,len_);
    strcpy(tmp,_str);
    strcpy(tmp,str._str);
    //memcpy(tmp+len_,str._str,str.len_);

    delete []_str;
    tmp[size]='\0';
    _str=tmp;
    len_=size;
    return *this;*/
}
String & String::operator+(char *s)
{
    len_+=strlen(s);
    CheckCapacity(strlen(s));
    memcpy(_str+strlen(s),s,strlen(s));
    return *this;
}


String & String::operator+=(char c)
{
    CheckCapacity(1);
    _str[len_++]=c;
    _str[len_]='\0';
    return *this;
}
String & String::operator+=(const String &str)
{
    /*
    CheckCapacity(str.len_);
    strcat(_str,str._str);
    len_+=str.len_;
    return *this;

    if(str.len_==0)
        return *this;*/

    len_+=str.len_;
    char* newstr=new char[len_+1];
    if(_str!=NULL)
    {
        strcpy(newstr,_str);
        delete []str_;
    }
    strcat(newstr,str._str);
    newstr[len_]='\0';
    _str=newstr;
    return *this;
    /*char* des;
    CheckCapacity(strlen(str._str));
    if(_str!=NULL)
    {
        des=new char[len_+1];
        strcpy(des,_str);
        delete []_str;
    }
    if(str._str!=NULL)
    {
        len_+=str.len_;
        _str=new char[len_+1];
        strcpy(_str,des);
        strcpy(_str,str._str);
    }*/
}
String & String::operator+=(const char *s)
{
    CheckCapacity(strlen(s));
    strcat(_str,s);
    len_+=strlen(s);
    return *this;
    /*CheckCapacity(strlen(s));
    char* des;
    if(_str!=NULL)
    {
        des=new char[len_+1];
        strcpy(des,s);
        delete []_str;
    }
    if(s!=NULL)
    {
        len_+=strlen(s);
        _str=new char[len_+1];
        strcpy(_str,des);
        strcpy(_str,s);
    }
    return *this;
     */
}



bool String::operator==(const String &str) const
{
    int size=strlen(str._str);
    if(size!=len_)
        return false;
    else
    {
        for(int i=0;i<size;i++)
        {
            if(_str[i]!=str._str[i])
                return false;
        }
    }
    return true;
}
bool String::operator==(const char *s) const
{
    int size=strlen(s);
    if(size!=len_)
        return false;
    else
    {
        for(int i=0;i<size;i++)
        {
            if(s[i]!=_str[i])
                return false;
        }
    }
    return true;
}
bool String::operator!=(const String &str)
{
    int size=strlen(str._str);
    if(size!=len_)
    {
        return true;
    }
    else
    {
        for(int i=0;i<size;i++)
        {
            if(_str[i]!=str._str[i])
                return true;
        }
    }
    return false;
}
bool String::operator!=(const char *s)
{
    int size=strlen(s);
    if(size!=len_)
    {
        return true;
    }
    else
    {
        for(int i=0;i<size;i++)
        {
            if(_str[i]!=s[i])
                return true;
        }
    }
    return false;
}
bool String::operator>(const String &str)
{
    if(strcmp(_str,str._str)>0)
        return true;
    else
        return false;
}
bool String::operator>(const char *s)
{
    if(strcmp(_str,s)>0)
        return true;
    else
        return false;
}
bool String::operator<(const String &str)
{
    if(strcmp(_str,str._str)<0)
        return true;
    else
        return false;
}
bool String::operator<(const char *s)
{
    if(strcmp(_str,s)<0)
        return true;
    else
        return false;
}
ostream & operator<<(ostream& os,String & str)
{
    os<<str._str;
    return os;
}
istream & operator>>(istream& is,String & str)
{
    is>>str._str;
    return in;
}
size_t String::size() const
{
    return len_;
}
size_t String::length()
{
    return len_;
}

void String::set_length(size_t len)
{
    len_=len;
}

char * String::memcpy(char *des, const char *src, size_t n)
{
    static_assert(des && src, "des && src is empty");
    while(n--)
    {
        *des++=*src++;
    }
    return dest;
}

int String::strlen(const char *s)
{
    int cnt=0;
    while(*s!='\0')
    {
        s++;
        cnt++;
    }
    return cnt;
}

int String::atoi(char *ptr)
{
    int ret=0;
    int sign=1;

    /*if(ptr==NULL)
    {
        cout<<"String::atoi() ptr is NULL"<<endl;
        return 0;
    }
    while(isspace(*ptr)!=0)
    {
        ptr++;
    }

    if(*ptr=='-')
        sign=-1;
    if(*ptr=='-' || *ptr=='+')
        ptr++;

    while (*ptr>='0' && *ptr<='9')
    {
        ret=ret*10+*ptr-'0';
        ptr++;
    }
    ret=sign*ret;

    return ret;*/

    long long num=0;
    if(ptr!=NULL && *ptr!='\0')
    {
        while(*ptr==' ')
        {
            ptr++;
            continue;
        }
        bool sign= false;
        if(*ptr=='+')
            ptr++;
        else if(*ptr=='-')
        {
            ptr++;
            sign=true;
        }
        if(*ptr!='\0')
        {
            num=strtoi(const char* str,bool minus);
        }

    }
}

long long stroi(const char* str,bool minus)
{
    long long num=0;
    while(*str!='\0')
    {
        if(*str>=0 && *str<=9)
        {
            int flag = minus ? -1 : 1;
            num = num * 10 + (*str - '0') * flag;

            if (minus == false && num > (0x7FFFFFFF))
                return INT_MAX;
            else if (minus == true && num < (signed int) 0x80000000)
                return INT_MIN;
            str++;
        }
        else
            break;
    }
    return num;
}
void String::push_back(const char *s)
{
    CheckCapacity(strlen(s));
    strcat(_str,s);
    len_+=strlen(s);
    return *this;
}
void String::push_back(const char c)
{
    CheckCapacity(1);
    _str[len_++]=c;
    _str[len_]='\0';
}

size_t String::find(const char *s, int pos)
{

}
size_t String::find(const String &str, int pos)
{

}
size_t String::find(const char c, int pos) const
{

}



bool String::Empty()
{
    if(_str==NULL)
        return true;
    else
        return false;
}
String & String::swap(const char *s)
{
    char* str[1024];
    int size=strlen(s);

    strcpy(str,s);
    str[size]='\0';

    strcpy(_str,str);

    return *this;
}
String & String::swap(const String &str)
{
    char str[1024];
    char temp[1024];

    int size=strlen(str._str);

    strcpy(str,str._str);
    strcpy(temp,_str);
    str[size]='\0';
    temp[len_]='\0';

    strcpy(_str,str);
    strcpy(str._str,tmp);

    return *this;
}

String String::substr(size_t begin, size_t end)
{
    char str[1024];

    int k=0;
    int i=0;
    if(end>len_-1)
        cout<<"error String::substr"<<endl;
    for(i=0;i<begin;i++)
    {
        str[k]=_str[i];
        k++;
    }
    for(i=end+1;i<len_;i++)
    {
        str[k]=_str[i];
        k++;
    }
    strcpy(_str,str);
    return *this;
}
String & String::assign(const String &, size_t, size_t)
{

}

String & String::erase(size_t pos, size_t len)
{
    char test[1024];
    int k=0;
    for(int i=pos+len;i<len_;i++)
    {
        test[k]=_str[i];
        k++;
    }
    for(int j=0;j<k;j++)
    {
        _str[j+pos]=test[j];
    }
    len_-=len;
    _str[len_]='\0';
    return *this;
}


void String::get_next(int *nextval)
{

}
String & String::append(const String &str)
{
    strcat(_str,str._str);
    len_+=str.len_;
    return *this;
}
String & String::append(const char *s)
{
     //memcpy(_str,s,strlen(s));
     strcat(_str,s);
     len_+=strlen(s);
     return *this;
}
String & String::append(size_t pos, const char c)
{
   char tmp[1024];
   int i=0;
   for(i=0;i<pos;i++)
   {
       tmp[i]=c;
   }
   tmp[i]='\0';
   strcat(_str,tmp);
   len_+=strlen(tmp);
   return *this;
}
String & String::append(const String &str, size_t pos, size_t len)
{
    char tmp[1024];
    int k=0;
    for(int i=pos;i<pos+len;i++)
    {
        tmp[k]=str._str[i];
        k++;
    }
    strcat(_str,tmp);
    len_+=strlen(tmp);
    return *this;
}
size_t String::compare(const char *s) const
{
    return _str==s;
}
size_t String::compare(const String &str) const
{
    return _str==str._str;
}
size_t String::compare(const String &lhs, const String &rhs) const
{
    int n=(lhs.len_<rhs.len_ ? lhs.len_:rhs.len_);
    for(int i=0;i<n;i++)
    {
        if(lhs[i]>rhs[i])
            return 1;
        if(lhs[i]<rhs[i])
            return 0;
    }
    if(lhs.len_>rhs.len_)
        return 1;
    if(lhs[i]<rhs[i])
        return 0;
    return -1;
}
int String::copy(char *s, size_t n, size_t pos) const
{
    if(n<strlen(s))
        throw 0;
    int k=0;
    for(int i=pos;i<pos+n;i++)
    {
        s[k]=_str[i];
        k++;
    }
    return k;
}
bool String::equals(const char *other)
{
    if(len_!=strlen(other))
        return false;
    for(int i=0;i<len_;i++)
    {
        if(_str[i]!=other[i])
            return false;
    }
    return true;
}
bool String::equals(const String &other)
{
    if(len_!=other.len_)
        return false;
    for(int i=0;i<other.len_;i++)
    {
        if(_str[i]!=other[i])
            return false;
    }
    return true;
}

String & String::remove(const int n)
{
    return remove(n,1);
}

String & String::remove(const int start, const int nChars)
{
    if(start<0 || nChars<=0 || start>(len_-1))
        return *this;

    int i;
    if(start+nChars < len_)
        i=nChars;
    else
        i=len_-start;

    len_-=i;
    for(int j=start;j<len_;j++)
        *(_str+j)=*(_str+(j+i));

    *(_str+len)='\0';
    return *this;
}

String & String::insert(const int n, const char c)
{
    int i;
    if(n<len_)
        i=n;
    if(n>len_-1)
        i=len_;
    if(n<0)
        i=0;

    len_++;
    char* str=new char[len_+1];
    for(int j=0;j<i;j++)
        str[j]=*(_str+j);

    str[i]=c;
    for(int j=i;j<len_;j++)
        str[j+1]=*(_str+j);

    str[len_]='\0';
    delete []_str;
    _str=str;
    return *this;

}
String & String::insert(size_t pos1, const char *s)
{
    char str[100];
    int k=0;
    int size=strlen(s)+pos1;
    int i=0;
    int j=0;
    for(i=pos1;i<len_;i++)
    {
        str[k]=_str[i];
        k++;
    }
    i=0;
    for(j=pos1;j<size;j++)
    {
        _str[j]=s[i];
        i++;
    }
    len_+=strlen(s);
    j=0;
    for(i=size;i<len_;i++)
    {
        _str[i]=str[j];
        j++;
    }
    _str[len_]='\0';
    return *this;
}
String & String::insert(size_t pos1, size_t n, char c)
{

}

String & String::insert(size_t pos1, const String &str)
{
    char str[100];
    int k=0;
    int i=0;
    int j=0;
    int size=pos1+strlen(str._str);
    for(i=pos1;i<len_;i++)
    {
        str[k]=_str[i];
        k++;
    }
    i=0;
    for(j=pos1;j<size;j++)
    {
        _str[j]=str._str[i];
        i++;
    }

    len_+=strlen(str._str);
    j=0;
    for(i=size;i<len_;i++)
    {
        _str[i]=str[j];
        j++;
    }
    _str[len_]='\0';
    return *this;
}
String & String::insert(size_t pos1, const char *s, size_t n)
{

}
String & String::insert(size_t pos1, const String &str, size_t pos2, size_t n)
{

}

String & String::replace(size_t begin, size_t end, const char c)
{
    if(end>len_)
        cout<<"replace error"<<endl;
    for(int i=begin-1;i<end;i++)
    {
        _str[i]=c;
    }
    return *this;
}

String & String::replace(size_t begin, size_t end, const char *s)
{
    if(end>len_ || (strlen(s)+begin > len_) )
        cout<<"replace error"<<endl;
    for(int i=begin-1;i<end;i++)
    {
        _str[i]=s[i];
    }
    return *this;
}

String & String::replace(size_t begin, size_t end, const String &str)
{
    if(end>len_ || str.len_+begin > len_) )
        cout<<"replace error"<<endl;
    for(int i=begin-1;i<end;i++)
    {
        _str[i]=str._str[i];
    }
    return *this;
}

int String::replaceAll(char ch, char c)
{
    int cnt=0;
    for(int i=0;i<len_;i++)
    {
        if(_str[i]==ch)
        {
            _str[i]=c;
            cnt++;
        }
    }
    return cnt;
}

String::iterator::iterator()
                :it(NULL)
                ,index(0);
{
}
String::iterator::iterator(const String *sp)
                :it(sp)
                ,index(0)
{
}
String::iterator::iterator(const iterator &rhs)
                :it(rhs.it)
                ,index(rhs.index)
{
}
String::iterator::iterator(const String *sp, int n)
                :it(sp)
                ,index(n)
{
}
String::iterator::~iterator()
{
    it=NULL;
}
iterator String::iterator::begin() const
{
    return iterator(this,0);
}
int String::iterator::end() const
{
    return iterator(this,len_);
}
iterator & String::iterator::operator++()
{
    if(it==NULL)
    {
        cout<<""<<endl;
        exit(1);
        index++;
    }
    if(index>it->len_)
        it=NULL;

    return *this;
}
iterator String::iterator::operator++(int)
{
    operator copy(*this);
    operator++();
    return copy;
}
iterator String::iterator::operator+(const int k)
{
    if(it==NULL)
    {
        cout<<""<<endl;
        exit(1);
    }
    return iterator(it,index+k);
}

iterator & String::iterator::operator--()
{
    if(it==NULL)
    {
        cout<<""<<endl;
        exit(1);
    }
    index--;
    if(index>it->len_ || index<0)
        it=NULL;
    return *this;
}
iterator String::iterator::operator--(int)
{
    iterator copy(*this);
    operator--();
    return copy;
}
iterator String::iterator::operator-(const int k)
{
    if(it==NULL)
    {
        cout<<""<<endl;
        exit(1);
    }
    return iterator(it,index-k);
}

iterator & String::iterator::operator=(const iterator &obj)
{
    it=obj.it;
    index=obj.index;
    return *this;
}

bool String::iterator::operator<(const iterator &rhs)
{
    if(it!=rhs.it)
    {
        cout<<""<<endl;
        exit(1);
    }
    return (index<rhs.index);
}
bool String::iterator::operator<=(const iterator &rhs)
{
    if(it!=rhs.it)
    {
        cout<<""<<endl;
        exit(1);
    }
    return (index<=rhs.index);
}
bool String::iterator::operator>(const iterator &rhs)
{
    if(it!=rhs.it)
    {
        cout<<""<<endl;
        exit(1);
    }
    return (index>rhs.index);
}
bool String::iterator::operator>=(const iterator &rhs)
{
    if(it!=rhs.it)
    {
        cout<<""<<endl;
        exit(1);
    }
    return (index>=rhs.index);
}
bool String::iterator::operator!=(const iterator &rhs)
{
    if(it!=rhs.it)
    {
        cout<<""<<endl;
        exit(1);
    }
    return !(*this==rhs);
}
bool String::iterator::operator==(const iterator &rhs)
{
    if(it!=rhs.it)
    {
        cout<<""<<endl;
        exit(1);
    }
    return (it==rhs.it && index==rhs.index);
}

const char * String::iterator::operator->() const
{
    return it;
}

const int String::iterator::operator->() const
{
    return index;
}
char String::iterator::operator*()
{
    return *(it->data+index);
}


