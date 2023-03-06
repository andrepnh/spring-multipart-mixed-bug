# spring-multipart-mixed-bug
To replicate issues on multipart/mixed controllers on Spring Boot 2.7.

The app will try to consume `multipart/mixed` requests using different approaches, but none will work. If we try the
same code, but using `multipart/form-data`, it works as expected.

To test, run the app and send `curl` requests to the endpoints on `DemoApplication`, or use the `test.sh` script to 
fire requests to all endpoints mixing the two content types. After that, check app logs to see if the variables 
are bound to the request parts.