package com.company.test;


import com.company.Utility;
import com.company.model.Pokemon;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {

    @Test
    public void testRandom(){

        double max = 100, min = 1;
        for (int i = 0; i < 100 ; i++) {
            double testNumber = Utility.randomNumber(max, min);
            Assert.assertTrue(testNumber > 0 && testNumber <100);
        }
    }

    @Test
    public void testCreatePokemon(){

        Pokemon testPokemon = new Pokemon();
        String name = "testPokemon";

        testPokemon.setName(name);
        Assert.assertEquals(name, name);
    }

}
