
# react-native-payforting

## Getting started

`$ npm install react-native-payforting --save`

### Mostly automatic installation

`$ react-native link react-native-payforting`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-payforting` and add `RNPayforting.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNPayforting.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.rummykhan.payforting.RNPayfortingPackage;` to the imports at the top of the file
  - Add `new RNPayfortingPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-payforting'
  	project(':react-native-payforting').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-payforting/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-payforting')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNPayforting.sln` in `node_modules/react-native-payforting/windows/RNPayforting.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Payforting.RNPayforting;` to the usings at the top of the file
  - Add `new RNPayfortingPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNPayforting from 'react-native-payforting';

// TODO: What to do with the module?
RNPayforting;
```
  