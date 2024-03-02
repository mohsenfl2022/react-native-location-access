# react-native-location-access

access mobile location

## Installation

```sh
npm install react-native-location-access
```

## Usage

```js

import * as React from 'react';
import { StyleSheet, View, Text } from 'react-native';

import { checkGpsStatus, onChangeState } from 'react-native-location-access';
export default function App() {
  const check = async () => {
    checkGpsStatus().then((res) => {
      console.log('====================================');
      console.log(res);
      console.log('====================================');
    });
  };
  const change = async () => {
    try {
      const res = await onChangeState();
      console.log('====================================');
      console.log(res);
      console.log('====================================');
    } catch (e) {
      console.log(e);
    }
  };
  return (
    <View style={styles.container}>
      <Text onPress={check} style={styles.text}>
        checkGpsStatus
      </Text>

      <Text onPress={change} style={styles.text}>
        onChangeState
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: 'white',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
  text: { color: 'black', fontSize: 24 },
});


```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
