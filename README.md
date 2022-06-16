Test automation framework for https://www.saucedemo.com/

# Technologies/Libraries

- TestNG 7.1.0
- Maven 3.8.1
- Selenium 3.141.59
- DriverManager 4.4.1
- Browser Chrome 90.0
- Browser Edge 90.0
- OS: Windows 10

Tested by: Viktoryia Latosh

Tested on: https://www.saucedemo.com/

# Checklist

**Module: LOGIN**

1. "Username" should be required. Expected: Error message "Epic sadface: Username is required"
2. "Password" should be required. Expected: Error message "Epic sadface: Password is required"
3. Enter invalid data "Username" and "Password". Expected: "Epic sadface: Username and password do not match any user in
   this service"
4. Enter valid data "Username" and "Password". Expected: Go to page "https://www.saucedemo.com/inventory.html"

**Module: PRODUCTS PAGE**

5. Checkout button "Add to cart". Expected: Button "Remove"
6. Checkout dropdown of sorting (name, price). Expected: Sorting is correct
7. Product should be added into the cart when you click "Add to cart". Expected: product is in the cart
8. Check that clicking on the product name opens the product description page. Expected: the product description page is
   open

**Module: CART PAGE**

9. Check the operation of the button "CONTINUE SHOPPING". Expected: Go to the
   page "https://www.saucedemo.com/inventory.html"
10. Check the operation of the button "CHECKOUT". Expected: Go to the
    page "https://www.saucedemo.com/checkout-step-one.html"

**Module: CHECKOUT: YOUR INFORMATION PAGE**

11. Сheck on the valid data entry page (input "First Name", "Last Name", "Zip/Postal Code")
12. Сheck on the invalid data entry page (input "First Name", "Last Name", "Zip/Postal Code")
13. "First Name" should be required. Expected: "Error: First Name is required"
14. "Last Name" should be required. Expected: "Error: Last Name is required"
15. "Zip/Postal Code" should be required. Expected: "Error: Postal Code is required"

**Module: CHECKOUT: OVERVIEW PAGE**

16. Check the operation of the button "CANCEL". Expected: Go to the page "https://www.saucedemo.com/cart.html"
17. Checkout total price

**Module: CHECKOUT: COMPLETE!**

18. Check the operation of the button "BACK HOME". Expected: Go to the page "https://www.saucedemo.com/inventory.html"
19. Check there is a message "THANK YOU FOR YOUR ORDER" after placing the order. Expected: "THANK YOU FOR YOUR ORDER"

**Element: BURGER MENU**

20. Choose "LOGOUT" from the BURGER MENU. Expected: Go to the page "https://www.saucedemo.com/"
21. Choose "ALL ITEMS" from the BURGER MENU. Expected: Go to the page "https://www.saucedemo.com/inventory.html"
22. Choose "RESET APP STATE" from the BURGER MENU. Expected: reset app state

**Element: footer**

24. Check the transition to social networks when you click the buttons (Twitter, Facebook, Linkedin)

[INFO] Tests run: 13, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 129.499 s - in TestSuite
