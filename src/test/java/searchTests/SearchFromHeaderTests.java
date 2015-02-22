package searchTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.KweekweekHeader;


import base.BaseTest;

public class SearchFromHeaderTests extends BaseTest{

	@Test
	public void searchBySelectingFromList() throws InterruptedException{
		KweekweekHeader kweekweekHeader = new PageFactory().initElements(driver, KweekweekHeader.class);
		
		  List<String> options =  kweekweekHeader.getListOfOptions();
          for (String option : options){
              kweekweekHeader.clickSearchField();
              kweekweekHeader.selectOptionFromSearchList(option);
              Thread.sleep(1500);
              Assert.assertEquals(1, kweekweekHeader.addElementWithXpathToList(option).size());
              kweekweekHeader.removeElementsFromList(kweekweekHeader.addElementWithXpathToList(option));
              kweekweekHeader.clickKweekweekLogo();
           
              }
	}
	
	@Test 
	public void searchForAllEventsByClickingButton(){
		KweekweekHeader kweekweekHeader = new PageFactory().initElements(driver, KweekweekHeader.class);
		kweekweekHeader.clickSearchButton();
		String option = "";
		Assert.assertEquals(1,kweekweekHeader.addElementWithXpathToList(option).size());
		kweekweekHeader.removeElementsFromList(kweekweekHeader.addElementWithXpathToList(option));
	}
	
	@Test
	public void searchBySelectingCategoryFromHeader() throws InterruptedException {
		KweekweekHeader kweekweekHeader = new PageFactory().initElements(driver, KweekweekHeader.class);
		
		List<String> categories = kweekweekHeader.getListOfCategories();
		for (String category : categories){
			kweekweekHeader.clickCategoriesButton();
			String selectedCategory = kweekweekHeader.getSelectedCategory(category);
			Thread.sleep(3000);
			kweekweekHeader.selectOptionFromCategoriesList(category);
			kweekweekHeader.addSelectedCategoryToList(category);
			Assert.assertEquals(1, kweekweekHeader.addSelectedCategoryToList(category).size());
			kweekweekHeader.removeElementsFromList(kweekweekHeader.addSelectedCategoryToList(category));
		}
	}
	@Test(enabled = false)
	public void printCategoryOnModule(){
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		kweekweekHeader.clickSearchButton();
		String category = kweekweekHeader.getCategoryOnModule();
		System.out.print(kweekweekHeader.addSelectedCategoryToList(category));
	}
	
	
}
