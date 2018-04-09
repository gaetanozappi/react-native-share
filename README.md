# React Native: Native Share

[![github home](https://img.shields.io/badge/gaetanozappi-react--native--share-blue.svg?style=flat-square)](https://github.com/gaetanozappi/react-native-share)
[![github issues](https://img.shields.io/github/issues/gaetanozappi/react-native-share.svg?style=flat-square)](https://github.com/gaetanozappi/react-native-share/issues)

-   [Usage](#usage)
-   [License](#license)

### Android

Add `react-native-share` to your `./android/settings.gradle` file as follows:

```text
include ':react-native-share'
project(':react-native-share').projectDir = new File(settingsDir, '../node_modules/react-native-share/android/app')
```

Include it as dependency in `./android/app/build.gradle` file:

```text
dependencies {
    ...
    compile project(':react-native-share')
}
```

Finally, you need to add the package within the `ReactInstanceManager` of your
MainActivity (`./android/app/src/main/java/your/bundle/MainActivity.java`):

```java
import com.reactlibrary.SharePackage;  // <---- import this one
...
@Override
protected List<ReactPackage> getPackages() {
    return Arrays.<ReactPackage>asList(
        new MainReactPackage(),
        new SharePackage()  // <---- add this line
    );
}
```

After that, you will need to recompile
your project with `react-native run-android`.

## Usage

```javascript
import Share from 'react-native-share';
```

- API Way

```javascript
Share.getCheck().then((url) => {
  console.log(url);
}).catch(e => console.log(e));
```

## License
The MIT License
