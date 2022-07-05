
This project demos a cljs react-native app.
It opens another app when you change the dimensions (landscape, portrait)

references

https://github.com/thheller/reagent-react-native
https://github.com/flexsurfer/rn-shadow-steroid
https://github.com/status-im/status-react

# dev

`./rn-start`
react native metro server

`./run-android`
install the app on your device

`npx shadow-cljs watch app`

cider connect cljs -> localhost -> shadow -> :app

Open dev menu in shadow and disable fast refresh.
Else you get the second, slow react-native refresh.

# release

`npx shadow-cljs release app`

```shell
cd android
./gradlew assembleRelease
```

APK should appear at android/app/build/outputs/apk/release
