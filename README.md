Android app skeleton
=======================================
[![Build Status](https://circleci.com/gh/fs/android-base.png?style=shield&circle-token=c932b3e8650c436df970e9d1e9e06e8ef8fc9893)](https://circleci.com/gh/fs/android-base)
[![Build Status](https://travis-ci.org/fs/android-base.png)](https://travis-ci.org/fs/android-base/pull_requests)
[![codecov](https://codecov.io/gh/fs/android-base/branch/master/graph/badge.svg)](https://codecov.io/gh/fs/android-base)

This project will help you quickly start developing a new android app

## Table of Contents
1. [Setup. Install IDE, secret environment](#setup)
1. [Build. Create apk](#building)
1. [How to Deploy](#deploying-to-fabric)
1. [How to Release](#build-a-release-apk)
1. [Run tests](#run-tests)
1. [ProGuard](#proguard)
1. [Credits](#credits)

## Setup
### Starting from base project
1. `git clone --depth 1 git://github.com/fs/android-base.git --origin android-base [NEW-PROJECT-NAME]`
2. `cd [NEW-PROJECT-NAME]`
3. `git remote add origin https://github.com/[NEW-PROJECT-GITHUB-ACCOUNT]/[NEW-PROJECT-NAME].git`
4. `git push -u origin master`
5. Update `APPLICATION_ID` in `app/build.gradle`.
6. Rename package under `app/src/main/java`.
7. Remove current and Credits sections from `README.MD`.

### IDE
1. Download latest Android Studio from https://developer.android.com/studio/index.html
2. Follow Android Studio installation instruction.
3. Download and install latest JDK8 http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html.
4. Open Android Studio - Open Existing Android Project - find folder with project and click `OK`
5. Wait a while. Follow Android Studio instructions to install missing items.
6. Press `cmd + shift + a` and type `AVD Manager` and press Enter.
7. Press `Create Virtual Device...` button.
8. Select `Nexus 5X`
9. Select latest API level (in case if latest is not available then click `Download` and wait, it's going to take a while).
10. Click `Next`
11. Click `Finish`

### Updating secret keys
1. Decrypt file:

```bash
openssl aes-256-cbc -d -md sha256 -nosalt -a -pass pass:{KEY} -in secrets/keys.properties.crypted > temp.properties
```

2. Add/remove keys inside `temp.properties`
3. Encrypt temp.properties back

```bash
openssl aes-256-cbc -e -md sha256 -nosalt -a -pass pass:{KEY} -in temp.properties -out ./secrets/keys.properties.crypted

```

4. Clean up: `rm temp.properties`.

## Building
### Create APK
After you complete the `Gradle` project configuration, you can use `gradlew` executable to build the APK:
```bash
$ ./gradlew assembleDebug       // to build a debug APK
$ ./gradlew assembleRelease     // to build a release signed APK, can upload to Market
```
### Install
After build the APK and immediately install it on a running emulator or connected device, instead invoke installDebug:
```bash
$ ./gradlew installDebug
```

### Deploying to Fabric
1. Increase app version & build number.
2. Commit changes.
3. Create git tag.
4. `git push && git push --tags`
5. Wait until https://circleci.com finish build.
6. Open crashlytics application on Android device
7. Find Android Base app, click on it and click "Update".

### Build a release APK
When you're ready to release and distribute your app, you must build a release APK that is signed with your private key:
```bash
$ ./gradlew assembleRelease
```

### Run tests
Local unit test:
```bash
$ ./gradlew test
```
Instrumented unit test:
```bash
$ ./gradlew connectedAndroidTest
```

## ProGuard
Project already has proguard config for included libraries.
Maintain [proguard-rules.pro](https://github.com/fs/android-base/blob/master/app/proguard-rules.pro) updated when you add new libraries or play with reflection.
When you add new library or check out its Proguard section and add rules to `proguard-rules.pro`.
When you add code which uses reflection add rules to `proguard-rules.pro`.

## Credits
Android app skeleton is maintained by [Adel Nizamutdinov](http://github.com/adelnizamutdinov) and [Ilya Eremin](http://github.com/ilyaeremin).
It was written by [Flatstack](http://www.flatstack.com) with the help of our
[contributors](http://github.com/fs/android-base/contributors)

[<img src="http://www.flatstack.com/logo.svg" width="100"/>](http://www.flatstack.com)