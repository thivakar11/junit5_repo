package com.pack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass
{
    private FuncData func;


    @DisplayName("First Test")
    @ParameterizedTest
    @CsvSource({"thivakar,8903207298,thiva@gmail.com,Hello@123","naveen,9443916298,naveen1998@gmail.com,Naveen$~|345"})
    void test(String name, String num, String email, String password) throws MyException
    {
        func = new FuncData();
        assertEquals(true,func.addData(name,num,email,password) );
    }

    @Nested
    @DisplayName("Sub-Method")
    class SubClass
    {
        @BeforeEach
        void classint()
        {
            func = new FuncData();
        }
        @DisplayName("Name True Test")
        @ParameterizedTest
        @ValueSource(strings = {"thivakar","naveen","abcdefghij","Tamil","RAM"})
        void test1(String name)
        {
            assertTrue(func.validateName(name));
        }

        @DisplayName("Name False Test")
        @ParameterizedTest
        @ValueSource(strings = {"","Abi@123","abcdefghijklm"})
        void Ftest1(String name)
        {
            assertFalse(func.validateName(name));
        }

        @DisplayName("Number True Test")
        @ParameterizedTest
        @ValueSource(strings = {"8903207298","9443916298"})
        void test2(String num)
        {
            assertTrue(func.validateNum(num) );
        }

        @DisplayName("Number False Test")
        @ParameterizedTest
        @ValueSource(strings = {"+8903207298","99443916298","","Abc"})
        void Ftest2(String num)
        {
            assertFalse(func.validateNum(num) );
        }

        @DisplayName("Email Test")
        @ParameterizedTest
        @ValueSource(strings = {"thivakars1999@gmail.com","naveen1998@gmail.com"})
        void test3(String email) throws MyException {
            assertTrue(func.validateEmail(email) );
        }

        @DisplayName("Email False Test")
        @ParameterizedTest
        @ValueSource(strings = {"thivakars1999@gm@il.com","naveen1998@gmail",""})
        void Ftest3(String email) throws MyException {
            assertFalse(func.validateEmail(email) );
        }

        @DisplayName("password Test")
        @ParameterizedTest
        @ValueSource(strings = {"Thiva@123","Naveen$~|345"})
        void test4(String password)
        {
            assertTrue(func.validatePassword(password));
        }

        @DisplayName("password False Test")
        @ParameterizedTest
        @ValueSource(strings = {"abcdefghijklmnopqrstuvwxyz",""})
        void Ftest4(String password)
        {
            assertFalse(func.validatePassword(password));
        }
    }

    @Nested
    class Exception
    {
        @DisplayName("Exception Test")
        @Test
        void MainExcep() throws MyException
        {
            func = new FuncData();
            MyException exception=assertThrows(MyException.class,()->func.addData("thivakar","8903207298","thiva@","Hello@123"));
            assertEquals("Exception Thrown",exception.getMessage());
        }
    }
}