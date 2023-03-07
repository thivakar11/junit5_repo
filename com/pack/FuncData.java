package com.pack;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
public class FuncData
{
    static Map<String,DataBase> map = new HashMap<>();
    //Main Method
    public boolean addData(String name, String num, String email, String password) throws MyException
    {
        if(validateEmail(email))
        {
            if(validateName(name))
            {
                if(validateNum(num))
                {
                    if(validatePassword(password))
                    {
                        map.put(num, new DataBase(name,num,email,password));
                        return true;
                    }
                    else
                    {
                        throw new MyException("Exception Thrown");
                    }
                }
                else
                {
                    throw new MyException("Exception Thrown");
                }
            }
            else
            {
                throw new MyException("Exception Thrown");
            }
        }
        else
        {
            throw new MyException("Exception Thrown");
        }
    }

    //Sub-Method

    public boolean validateName(String name)
    {
        // TODO Auto-generated method stub
        if(name!=null)
        {
            if(Pattern.matches("\\p{Alpha}{1,10}", name))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public boolean validateEmail(String email)
    {
        // TODO Auto-generated method stub
        if(email!=null)
        {
            if(Pattern.matches("^[a-zA-Z0-9\\p{Punct}]{1,20}@\\p{Alpha}{1,10}\\.com$", email))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public boolean validateNum(String num){
        // TODO Auto-generated method stub
        if(num!=null)
        {
            if(Pattern.matches("\\d{10}", num))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }


    public boolean validatePassword(String password)
    {
        // TODO Auto-generated method stub
        if(password!=null)
        {
            if(Pattern.matches("[a-zA-Z0-9\\p{Punct}]{1,25}", password))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
