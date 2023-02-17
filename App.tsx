/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, {Component} from 'react';
import {StyleSheet, View, Animated, requireNativeComponent} from 'react-native';

const MyCustomView = requireNativeComponent('MyCustomView');

class App extends Component {
  private animatedEventWorks: any;
  private animatedEventIssue: any;

  private animatedValueWorks: any;
  private animatedValueIssue: any;

  constructor(props: any) {
    super(props);

    this.animatedValueWorks = new Animated.Value(0);
    this.animatedValueIssue = new Animated.Value(0);

    this.animatedEventWorks = Animated.event(
      [
        {
          nativeEvent: {
            value: this.animatedValueWorks,
          },
        },
      ],
      {useNativeDriver: true},
    );

    this.animatedEventIssue = Animated.event(
      [
        {
          nativeEvent: {
            value: this.animatedValueIssue,
          },
        },
      ],
      {useNativeDriver: true},
    );
  }


  componentDidMount() {
    this.animatedValueWorks.addListener((v) => {
      console.log("Event recieved from OnAnimatedEventWorks", v)
    })

    this.animatedValueIssue.addListener((v) => {
      console.log("Event recieved from onAnimatedEventIssue", v)
    })
  }

  render() {
    const AnimatedCustomView = Animated.createAnimatedComponent(MyCustomView);

    return (
      <View style={styles.container}>
        <AnimatedCustomView
          style={styles.myView}
          onAnimatedEventIssue={this.animatedEventIssue}
          OnAnimatedEventWorks={this.animatedEventWorks}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
    justifyContent: 'center',
    alignItems: 'center',
  },
  myView: {
    height: 40,
    width: 40,
    backgroundColor: 'red',
  }
});

export default App;
