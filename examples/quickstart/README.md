# Quickstart

This example is a ported version of the OSGi enroute quickstart project. The original tutorial can be found 
[here](https://enroute.osgi.org/tutorial/020-tutorial_qs.html).

## Run

### CLI

To create the executable `.jar` file you have to run following command from within the `examples/quickstart` directory:

``` bash
$ ./../../gradlew clean export
```

The final application can be found at `app/build/export/app.jar`. To run the application enter

```bash
$ java -jar app/build/export/app.jar
```

While the application is running, it will provide a simple REST API. You can test the running version under
[http://localhost:8080/rest/upper/test](http://localhost:8080/rest/upper/test). When you open this URL with a web browser
of your choice, you should see the string `"TEST"` printed in uppercase letters. You can convert a arbitrary string to uppercase
by changing the last path component of the URL.

To terminate the application press `CTRL + C` in your terminal.

### IntelliJ

If you want to run or debug the application from inside your IDE you need to create a launcher that depends on the gradle export.