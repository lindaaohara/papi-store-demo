// This is the package it defines the family relation of objects; like the last name
package com.codedifferently.store;

// This is importing the Assert Class from the org.junit package or folder
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// This is a public class called PapiStoreTest
    public class PapiStoreTest {

        PapiStore papiStore;

 //Annotation to set up the initial states necessary to run all the tests, called fixtures
        @Before
        public void setup(){
            papiStore = new PapiStore();
            papiStore.createActiveTab("Jamal");
            papiStore.createActiveTab("Victor");
            papiStore.owesPapiMoney.put("Jamal", 0.0);
            papiStore.owesPapiMoney.put("Victor", 7.0);
        }

        //Annotation lets Junit know to pay attention to run this test
        @Test
        public void OpenStoreTest(){
            //Given

        //first thing you need to do is call the method that you're testing, i.e., openStore
            papiStore.openStore();

            //When
            //if the store is open, the boolean will be true
            Boolean expected = true;
            Boolean actual = papiStore.isStoreOpen();

            //Then
            //Assert.assertEquals(expected, actual);
            Assert.assertTrue(actual);
        }
//set up tests for both success and failure
        @Test
        public void allowToUseTabTestSuccess(){
            // given
            // A variable called papiStore is a reference of Type PapiStore that is pointing to a new PapiStore object
            PapiStore papiStore = new PapiStore();

            // when
            Boolean expected = true;
            Boolean actual = papiStore.allowToUseTab("Jamal");

            // then
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void allowToUseTabTestFail(){
            // given
            PapiStore papiStore = new PapiStore();

            // when
            Boolean expected = false;
            Boolean actual = papiStore.allowToUseTab("Victor");

            // then
            Assert.assertEquals(expected, actual);
        }
}
