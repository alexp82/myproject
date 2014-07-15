/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/support/element/Table.p.vm.java
 */
package com.keba.demo.web.selenium.support.elements;

import static com.google.common.collect.Lists.newArrayList;
import static com.palominolabs.xpath.XPathUtils.getXPathString;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table extends CustomWebElement {
    public Paginator paginator;

    public void edit(String value) {
        webClient.clickLinkTitle("Edit " + value);
    }

    public void view(String value) {
        webClient.clickLinkTitle("View " + value);
    }

    public void select(String value) {
        webClient.clickLinkTitle("Select " + value);
    }

    public void delete(String value) {
        webClient.clickLinkTitle("Delete " + value);
    }

    public void confirmDelete() {
        By yesButton = By.name("form:askForDeleteItemDialogYes");
        webClient.click(yesButton);
        webClient.waitUntilInvisible(yesButton);
    }

    public void cancelDelete() {
        By noButton = By.name("form:askForDeleteItemDialogNo");
        webClient.click(noButton);
        webClient.waitUntilInvisible(noButton);
    }

    public void hasText(String... values) {
        for (String value : values) {
            webClient.waitUntilTextIsPresent(value);
        }
    }

    public void hasSize(int size) {
        paginator.hasSize(size);
    }

    public void editLine(int line) {
        clickNthLineWithIcon(line, "iconEdit");
    }

    public void selectLine(int line) {
        clickNthLineWithIcon(line, "iconSelect");
    }

    public void viewLine(int line) {
        clickNthLineWithIcon(line, "iconView");
    }

    public void deleteLine(int line) {
        clickNthLineWithIcon(line, "iconDelete");
    }

    private void clickNthLineWithIcon(int line, String icon) {
        String xpath = "//div[@id='form:searchResults']//table/tbody/tr[" + line + "]/td[contains(@class,'actions-column')]//div[contains(@class,'" + icon
                + "')]";
        webClient.click(By.xpath(xpath));
    }

    public void selectAll() {
        By selectAllCheckBox = By
                .xpath("//table/thead[@id='form:searchResults_head']/tr/th[@id='form:searchResults:selectAll']/div[contains(@class,'ui-chkbox-all')]/div[contains(@class,'ui-chkbox-box')]");
        webClient.waitUntilEnabled(selectAllCheckBox);
        webClient.find(selectAllCheckBox).click();
        By unselectedCheckboxes = By.xpath("//div[@id='form:searchResults']//td[@class='ui-selection-column']//span[not(contains(@class,'ui-icon-check'))]");
        webClient.waitUntilRemoved(unselectedCheckboxes);
    }

    public void confirmSelection() {
        String selectMultipleSelectionIcon = "//div[@id='form:searchResults']/div[contains(@class,'ui-datatable-footer')]//div[contains(@class,'iconSelect')]";
        webClient.click(By.xpath(selectMultipleSelectionIcon));
    }

    /**
     * Get the values for a given column
     */
    public List<String> column(String columnName) {
        By values = By.xpath("//div[@id='form:searchResults']//tbody/tr/td[contains(@class," + getXPathString(columnName) + ")]");
        webClient.waitUntilFound(values);
        List<String> ret = newArrayList();
        for (WebElement webElement : webClient.findAll(values)) {
            ret.add(webElement.getText());
        }
        return ret;
    }

    /**
     * Get the values for a given column and a line, please note that lines start at 1
     */
    public String columnAt(String columnName, int line) {
        By value = By.xpath("//div[@id='form:searchResults']//tbody/tr[" + line + "]/td[contains(@class," + getXPathString(columnName) + ")]");
        webClient.waitUntilFound(value);
        return webClient.find(value).getText();
    }
}
