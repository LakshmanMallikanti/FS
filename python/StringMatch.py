'''
The Valid shortcuts of a string "abcd", are as follows:
abcd, abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 1b2, 2c1, 3d, a3, 4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains only 
lowercase letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true


Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false

'''

s=input("").split(" ")
s2=s[0]
s1=s[1]
if(s1.isdigit()):
    if(len(s2)==int(s1)):
        print("true")
    else:
        print("false")
else:
    i=j=0
    while(i<len(s1) and j<len(s2)):
        if(s1[i]==s2[j]):
            i=i+1
            j=j+1
        else:
            num=0
            while(i<len(s1) and s1[i].isdigit()):
                num=num*10+int(s1[i])
                i=i+1
            count=0
            while( j<len(s2)):
                if(i==len(s1)):
                    count=count+1
                    j=j+1
                else:
                    if(s1[i]==s2[j] and count==num): break
                    else:
                        count=count+1
                        j=j+1
    if(i==len(s1) and j==len(s2)):
        print("true")
    else:
        print("false")
                