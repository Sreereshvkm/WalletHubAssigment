Softwares / Jars used
----------------------
Java
----
java version "10.0.2" 2018-07-17
Java(TM) SE Runtime Environment 18.3 (build 10.0.2+13)
Java HotSpot(TM) 64-Bit Server VM 18.3 (build 10.0.2+13, mixed mode)

Editor
----
Eclipse Jee Oxygen

Selenium Jars
-------------
selenium-java-3.141.59

Browsers used
-------------
1. Chrome version : Version 90.0.4430.85 (Official Build) (64-bit) 
2. Firefox  version : 88.0 (64-bit)

Respective drivers are downloaded and stored in driver folder of project

Project structure
------------------
1. commobLibs.Baselibs.java -  All commonly used functions for both assignments are created in this file.
2. libs.Fb_libs.java  - Page factory is used for creating object repository for Facebook assignment.
3. libs.WalletHub_libs.java - Page factory is used for creating object repository for WalletHub assignment.
4. tests.FbAssignmentTest - Facebook test mentioned in the assignments is tested here.
5. tests.WalletHubTest - WalletHub test mentioned in the assignment is tested here

Note: Since it is already mentioned not use any third party libraries , used only pure selenium api and core java libraries

Challenge faced
-------------------
WalletHub application does not show any confirmation message as mentioned in the given document.
After review is posted . I could see only login page.

Automating mouseover action on chrome browser, I have tried all the option such as 
1. Actions class method moveToElement(). It failed to highlight the stars
2. Direct java script to do moveover by using javascriptExecuter interface. Still not worked
3. Reduced window size and mouse pointer moved out of chrome browser(using Robot class) and then tried to do mouseover. still failed to highted stars
4. I believe issue is with chrome browser. I tried the same in Firefox browser, it worked perfectly with actions class method moveToElement()






