# Avito automated tests project 

## Used technologies

<img height="100" src="https://user-images.githubusercontent.com/25181517/192108890-200809d1-439c-4e23-90d3-b090cf9a4eea.png"> <img height="100" src="https://user-images.githubusercontent.com/25181517/192108372-f71d70ac-7ae6-4c0d-8395-51d8870c2ef0.png"> <img height="100" src="	https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png"> <img height="100" src="https://user-images.githubusercontent.com/25181517/184103699-d1b83c07-2d83-4d99-9a1e-83bd89e08117.png"> <img height="100" src="https://img.stackshare.io/service/8189/New_Project__8_.jpg"> <img height="100" src="https://raw.githubusercontent.com/neupokoev/childWorld/00e266c739d4448bbba45aa1059d3e14abd2ff6b/images/Gradle.svg"> <img height="100" src="https://raw.githubusercontent.com/neupokoev/childWorld/00e266c739d4448bbba45aa1059d3e14abd2ff6b/images/Junit5.svg">  <img height="https://raw.githubusercontent.com/neupokoev/childWorld/00e266c739d4448bbba45aa1059d3e14abd2ff6b/images/Jenkins.svg">  <img height="100" src="https://raw.githubusercontent.com/neupokoev/childWorld/00e266c739d4448bbba45aa1059d3e14abd2ff6b/images/Selenoid.svg"> <img height="100" src="https://raw.githubusercontent.com/neupokoev/childWorld/00e266c739d4448bbba45aa1059d3e14abd2ff6b/images/Allure%20TestOps.svg"> <img height="100" src="https://raw.githubusercontent.com/neupokoev/childWorld/00e266c739d4448bbba45aa1059d3e14abd2ff6b/images/Allure%20Report.svg"> 



# Jenkins job
https://jenkins.autotests.cloud/job/08-Daniil-lesson13_avitotests/

# USAGE examples

### For run remote tests need fill remote.properties or to pass value:

* browser (default chrome)
* browserSize (default 1920x1080)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)

Run tests with filled remote.properties:
```bash
gradle clean all_test
```

Run tests with not filled remote.properties:
```bash
gradle clean all_test -DbrowserSize=1920x1080 -Dbrowser=chrome -DbaseURL=https://www.avito.ru/
```

Serve report:
```bash
allure serve build/allure-results
```

### Allure report
![Allure1](https://user-images.githubusercontent.com/62812456/235561905-58b72ac3-e6e0-441e-87e9-4a169f866a07.jpg)

### Allure TestOps
![TestOps](https://user-images.githubusercontent.com/62812456/235562130-c9990ba8-5ace-4402-8bb7-29688111cd8a.jpg)

### Testrun Video

https://user-images.githubusercontent.com/62812456/235562767-44505256-8636-45eb-8848-2637eaff7b88.mp4


