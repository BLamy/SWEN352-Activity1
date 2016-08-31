package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

public class InventoryTest extends TestCase {


    /**
     * Sets up the test fixture. 
     * (Called before every test case method.) 
     */ 
    protected void setUp() { 
    } 


    /**
     * Tears down the test fixture. 
     * (Called after every test case method.) 
     */ 
    protected void tearDown() { 

    } 
    
    public void testConstructor() {
    	Inventory inventory = new Inventory();
    	assertEquals("Coffee should be 15 by default", inventory.getCoffee(), 15);
    	assertEquals("Milk should be 15 by default", inventory.getMilk(), 15);
    	assertEquals("Sugar should be 15 by default", inventory.getSugar(), 15);
    	assertEquals("Chocolate should be 15 by default", inventory.getChocolate(), 15);
    }
    
    
    //----------------------------------------
    // Coffee
    public void testMinimalCoffeeValue() {
    	Inventory inventory = new Inventory();
    	inventory.setCoffee(-1);
    	assertEquals("Coffee Value should not take negitive value", inventory.getCoffee(), 15);
    }
    
    public void testAddCoffee() throws InventoryException {
    	Inventory inventory = new Inventory();
    	inventory.addCoffee("5");
    	assertEquals("Coffee Value should not take negitive value", inventory.getCoffee(), 20);
    }
    
    public void testAddCoffeeShouldThrowNonIntError() throws InventoryException {
    	Boolean didFail = false;
    	Inventory inventory = new Inventory();
    	try{
        	inventory.addCoffee("a");
    	} catch (Exception e) {
    		didFail = true;
    	}
    	assertTrue("Should throw if passed non integer", didFail);
    }
    
    public void testAddCoffeeShouldThrowNonPositiveIntError() throws InventoryException {
    	Boolean didFail = false;
    	Inventory inventory = new Inventory();
    	try{
        	inventory.addCoffee("-1");
    	} catch (Exception e) {
    		didFail = true;
    	}
    	assertTrue("Should throw if passed non positive integer", didFail);
    }
    
    //----------------------------------------
    // Milk
    public void testMinimalMilkValue() {
    	Inventory inventory = new Inventory();
    	inventory.setMilk(-1);
    	assertEquals("Milk Value should not take negitive value", inventory.getMilk(), 15);
    }
    
    public void testAddMilk() throws InventoryException {
    	Inventory inventory = new Inventory();
    	inventory.addMilk("5");
    	assertEquals("Milk Value should not take negitive value", inventory.getMilk(), 20);
    }
    
    public void testAddMilkShouldThrowNonIntError() throws InventoryException {
    	Boolean didFail = false;
    	Inventory inventory = new Inventory();
    	try{
        	inventory.addMilk("a");
    	} catch (Exception e) {
    		didFail = true;
    	}
    	assertTrue("Should throw if passed non integer", didFail);
    }
    
    public void testAddMilkShouldThrowNonPositiveIntError() throws InventoryException {
    	Boolean didFail = false;
    	Inventory inventory = new Inventory();
    	try{
        	inventory.addMilk("-1");
    	} catch (Exception e) {
    		didFail = true;
    	}
    	assertTrue("Should throw if passed non positive integer", didFail);
    }
   
    //----------------------------------------
    // Sugar
    public void testMinimalSugarValue() {
    	Inventory inventory = new Inventory();
    	inventory.setSugar(-1);
    	assertEquals("Sugar Value should not take negitive value", inventory.getSugar(), 15);
    }
    
    public void testAddSugar() throws InventoryException {
    	Inventory inventory = new Inventory();
    	inventory.addSugar("5");
    	assertEquals("Sugar Value should not take negitive value", inventory.getSugar(), 20);
    }
    
    public void testAddSugarShouldThrowNonIntError() throws InventoryException {
    	Boolean didFail = false;
    	Inventory inventory = new Inventory();
    	try{
        	inventory.addSugar("a");
    	} catch (Exception e) {
    		didFail = true;
    	}
    	assertTrue("Should throw if passed non integer", didFail);
    }
    
    public void testAddSugarShouldThrowNonPositiveIntError() throws InventoryException {
    	Boolean didFail = false;
    	Inventory inventory = new Inventory();
    	try{
        	inventory.addSugar("-1");
    	} catch (Exception e) {
    		didFail = true;
    	}
    	assertTrue("Should throw if passed non positive integer", didFail);
    }
    
    //----------------------------------------
    // Chocolate
    public void testMinimalChocolateValue() {
    	Inventory inventory = new Inventory();
    	inventory.setChocolate(-1);
    	assertEquals("Chocolate Value should not take negitive value", inventory.getChocolate(), 15);
    }
    
    public void testAddChocolate() throws InventoryException {
    	Inventory inventory = new Inventory();
    	inventory.addChocolate("5");
    	assertEquals("Chocolate Value should not take negitive value", inventory.getChocolate(), 20);
    }
    
    public void testAddChocolateShouldThrowNonIntError() throws InventoryException {
    	Boolean didFail = false;
    	Inventory inventory = new Inventory();
    	try{
        	inventory.addChocolate("a");
    	} catch (Exception e) {
    		didFail = true;
    	}
    	assertTrue("Should throw if passed non integer", didFail);
    }
    
    public void testAddChocolateShouldThrowNonPositiveIntError() throws InventoryException {
    	Boolean didFail = false;
    	Inventory inventory = new Inventory();
    	try{
        	inventory.addChocolate("-1");
    	} catch (Exception e) {
    		didFail = true;
    	}
    	assertTrue("Should throw if passed non positive integer", didFail);
    }
    
    
    public void testUseIngredience() throws RecipeException {
    	Recipe recipe = new Recipe();
    	recipe.setAmtChocolate("5");
    	recipe.setAmtMilk("5");
    	recipe.setAmtSugar("5");
    	recipe.setAmtCoffee("5");
    	
    	Inventory inventory = new Inventory();
    	inventory.useIngredients(recipe);
    	
    	assertEquals("Chocolate Value should not take negitive value", inventory.getChocolate(), 10);
    	assertEquals("Milk Value should not take negitive value", inventory.getMilk(), 10);
    	assertEquals("Sugar Value should not take negitive value", inventory.getSugar(), 10);
    	assertEquals("Coffee Value should not take negitive value", inventory.getCoffee(), 10);
    }

    public void testNotEnoughCoffee() throws RecipeException {
    	Recipe recipe = new Recipe();
    	recipe.setAmtCoffee("16");    	
    	Inventory inventory = new Inventory();
    	assertFalse("Can't use ingreients because not enough coffee", inventory.useIngredients(recipe));
    }
    
    public void testNotEnoughMilk() throws RecipeException {
    	Recipe recipe = new Recipe();
    	recipe.setAmtMilk("16");    	
    	Inventory inventory = new Inventory();
    	assertFalse("Can't use ingreients because not enough milk", inventory.useIngredients(recipe));
    }
    public void testNotEnoughSugar() throws RecipeException {
    	Recipe recipe = new Recipe();
    	recipe.setAmtSugar("16");    	
    	Inventory inventory = new Inventory();
    	assertFalse("Can't use ingreients because not enough sugar", inventory.useIngredients(recipe));
    }
    
    public void testNotEnoughChocolate() throws RecipeException {
    	Recipe recipe = new Recipe();
    	recipe.setAmtChocolate("16");    	
    	Inventory inventory = new Inventory();
    	assertFalse("Can't use ingreients because not enough chocolate", inventory.useIngredients(recipe));
    }
    
    public void testToString() {  	
    	Inventory inventory = new Inventory();
    	String actual = inventory.toString();
    	String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
    	assertEquals("ToString not valid", actual, expected);
    }

}

