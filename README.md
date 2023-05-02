![57409617]<img src=user-images.githubusercontent.com/62812456/235563252-2de65600-bcda-4049-9e4a-51386f08d4b3.png width="150" height="150">



# Avito project in Allure TestOps automated tests

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


