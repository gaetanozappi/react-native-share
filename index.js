var Intent = require('react-native').NativeModules.Share;
var Platform = require('react-native').Platform;

module.exports = {
  getCheck() {
    if (Platform.OS !== 'android') {
      throw Error('⚠️ Android only supported ⚠️');
    }
    return Intent.getCheck();
  },
};
