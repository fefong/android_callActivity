Android/Java Start Another Activity
===========================

Example Application: Call Activity | Start Another Activity
- [Android/Java Start Another Activity](#androidjava-start-another-activity)
  - [Start Activity](#start-activity)
  - [Start Activity with Put Extra](#start-activity-with-put-extra)
    - [Set PutExtras](#set-putextras)
    - [Get PutExtras](#get-putextras)
  - [Start Activity for Result](#start-activity-for-result)
- [Some links for more in depth learning](#some-links-for-more-in-depth-learning)



## Start Activity

Simple start another activity

**Structure for startActivity:**
```java
Intent i = new Intent(MainActivity.this, SecondActivity.class);

startActivity(i);
```

## Start Activity with Put Extra

Initialize another activity with parameters
Using different types of parameters
* String;
* Integer;
* Long;
* Boolean;
* Drawable;
* Model [(Class Person)](src/main/java/com/example/android_callactivity/model/Person.java) 

### Set PutExtras

**Structure for startActivity with putExtras:**
```java
Intent i = new Intent(MainActivity.this, SecondActivity.class);

i.putExtra(getString("KEY", "StringValueExtra");

startActivity(i);
```

**Example**
```java
Intent i = new Intent(MainActivity.this, SecondActivity.class);

i.putExtra(getString(R.string.EXTRA_STRING), "StringValueExtra");
i.putExtra(getString(R.string.EXTRA_INT), 1);
i.putExtra(getString(R.string.EXTRA_LONG), 1L);
i.putExtra(getString(R.string.EXTRA_BOOLEAN), true);
i.putExtra(getString(R.string.EXTRA_DRAWABLE), R.drawable.ic_android);
i.putExtra(getString(R.string.EXTRA_MODEL), new Person("NamePerson", "AnyPersonValue"));

startActivity(i);
```

* How to create model? How to do the Getters and Setters?
  * [Getters and Setters](https://github.com/fefong/java_GettersAndSetters)

* How to declare variables? 
  * [Variables](https://github.com/fefong/java_variables)

* See [strings.xml](src/main/res/values/strings.xml)
  
### Get PutExtras

**In the second activity:**


```java
Intent i = getIntent();
Bundle extras = i.getExtras();
```

Check has extras (PutExtras)

```java
if (extras == null) {
//TODO
}
```

Check contains key PutExtra

```java
if (extras.containsKey("KEY"){
//TODO    
}
```

**Example**
```java
if (extras != null) {
     if (extras.containsKey("KEY"){
         //TODO
     }
}
```

## Start Activity for Result

Declare variable for request code.

```java
int CODE_ANY = 100; // ANY VALUE;
```

```java
Intent i = new Intent(MainActivity.this, SecondActivity.class);

startActivityForResult(i, CODE_ANY));
```

**In the second activity**

```java
Intent i = new Intent();
i.putExtra("KEY", "THIS VALUE RETURN ACTIVITY FOR RESULT");
setResult(RESULT_OK);

finish();
```

:warning: Necessary **Override** method **onActivityResult** on first activity.

```java
@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
if( requestCode ==  CODE_ANY)) {

    if (resultCode == RESULT_OK) {
        if(data != null){
            if(data.getExtras().containsKey("KEY")){
            // TODO - has extra
            }
        }
    }  

}
```

# Some links for more in depth learning

* [JAVA](https://github.com/search?q=fefong%2Fjava)
  * [IF/Else](https://github.com/fefong/java_ifElse)
  * [Variables](https://github.com/fefong/java_variables)
  * [Getters and Setters](https://github.com/fefong/java_GettersAndSetters)
* [ANDROID](https://github.com/search?q=fefong%2Fandroid)