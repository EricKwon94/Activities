# Activities

## Setup
```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

dependencies {
	implementation 'com.github.kss2:Activities:1.0.1'
}
```
## Usage
```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // It needs to be initialized in the first activity.
        Activities.init(this);
        
        // You can use activities in adapters or your class.
        CurrentActivity currentActivity = (CurrentActivity) Activities.getCurrentActivity();
        PreviousActivity previousActivity = (PreviousActivity) Activities.getPreviousActivity();
        List<Activity> activities = Activities.getActivities();
        Context context = Activities.getApplicationContext();
    }
    
@Override
  protected void onDestroy() {
      super.onDestroy();
      // Option
      Activities.release();
  }
```
## License
Activities is under MIT license. See the [LICENSE](LICENSE) file for more info.
