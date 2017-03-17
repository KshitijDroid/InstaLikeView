# InstaLikeView
[![](https://jitpack.io/v/Kshitij-Jain/InstaLikeView.svg)](https://jitpack.io/#Kshitij-Jain/InstaLikeView)

A simple library to add like animation similar to instagram.

<img src="https://github.com/Kshitij-Jain/InstaLikeView/blob/master/screenshots/video.gif" width="256">

### Download

#### Step 1. Add the JitPack repository to your build file

##### Gradle

Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

```

##### **Maven**

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

#### **Step 2.** Add the dependency

##### Gradle

```
dependencies{
    compile 'com.github.Kshitij-Jain:InstaLikeView:1.05'
}

```

##### Maven

```
<dependency>
    <groupId>com.github.Kshitij-Jain</groupId>
    <artifactId>InstaLikeView</artifactId>
    <version>1.05</version>
</dependency>
```

### Usage

#### Include following code in your layout:

```
<com.github.kshitij_jain.instalike.InstaLikeView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:likeColor="@color/colorPrimaryDark"
        app:likeSize="128dp"
        app:likeSrc="@drawable/img_heart"
        android:id="@+id/insta_like_view"/>
```

#### Include following code in your activity:

```
InstaLikeView mInstaLikeView = (InstaLikeView) findViewById(R.id.insta_like_view);
// To start animation
mInstaLikeView.start();
```
##### Supported xml attributes:
```
 app:likeColor="@color/colorPrimary" // Set Like Color
 app:likeSize="@dimen/likeDimension" // Set Like Size (Default 80dp)
 app:likeSrc="@drawable/img_burger" // Set Like Drawable
 ``` 

##### Other supported methods:

```
mInstaLikeView.start(); // Start Animation
mInstaLikeView.setLikeResource(R.drawable.img_burger); // Set Like Drawable
mInstaLikeView.setLikeDrawable(ContextCompat.getDrawable(this, R.drawable.img_burger)); // Set Like Drawable
mInstaLikeView.setLikeColor(ContextCompat.getColor(this, R.color.colorAccent)); // Set Like Color
``` 

### License
```
Copyright 2017 Kshitij Jain

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
