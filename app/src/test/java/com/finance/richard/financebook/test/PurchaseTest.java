package com.finance.richard.financebook.test;

import android.support.v7.appcompat.BuildConfig;
import android.test.suitebuilder.annotation.SmallTest;

import com.finance.richard.financebook.Purchase;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Created by richard on 8/15/2015.
 */


public class PurchaseTest extends TestCase{

    Purchase purchase;

    @Override
    protected void setUp() throws Exception{

        purchase = new Purchase();
    }

    @SmallTest
    public void getName_Bob(){
        purchase.setName("Bob");
        String result = purchase.getName();
        String expected = "Bob";
        assertEquals(expected, result);
    }
}
